<%@page import="de.uhh.l2g.plugins.model.Host"%>
<%@include file="/init.jsp"%>

<jsp:useBean id="reqLectureseriesList" type="java.util.List<de.uhh.l2g.plugins.model.Lectureseries>" scope="request" />
<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="reqLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="reqSubInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />

<liferay-portlet:resourceURL id="updateMetadata" var="updateURL" />
<liferay-portlet:resourceURL id="updateDescription" var="updateDescriptionURL" />
<liferay-portlet:resourceURL id="updateLicense" var="updateLicenseURL" />
<liferay-portlet:resourceURL id="updateVideoFileName" var="updateVideoFileNameURL" />
<liferay-portlet:resourceURL id="videoFileNameExists" var="videoFileNameExistsURL" />
<liferay-portlet:resourceURL id="deleteFile" var="deleteFileURL" />
<liferay-portlet:resourceURL id="isFirstUpload" var="isFirstUploadURL" />
<liferay-portlet:resourceURL id="defaultContainer" var="defaultContainerURL" />
<liferay-portlet:resourceURL id="updateCreators" var="updateCreatorsURL" />
<liferay-portlet:resourceURL id="updateSubInstitutions" var="updateSubInstitutionsURL" />
<liferay-portlet:resourceURL id="getJSONCreator" var="getJSONCreatorURL" />
<liferay-portlet:resourceURL id="updateupdateOpenAccessForLectureseries" var="updateupdateOpenAccessForLectureseriesURL" />
<liferay-portlet:resourceURL id="videoUpdateGenerationDate" var="videoUpdateGenerationDateURL" />
<liferay-portlet:resourceURL id="getGenerationDate" var="getGenerationDateURL" />

<%
	String actionURL = "";
	
	Map<String,String> institutions = new LinkedHashMap<String, String>();
	if(permissionAdmin){
		institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
	}
	if(permissionCoordinator)institutions = InstitutionLocalServiceUtil.getByParent(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getInstitutionId());

	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";

	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	String backURL = request.getAttribute("backURL").toString();
	List<Creator> creators = new ArrayList<Creator>();
	try{creators = CreatorLocalServiceUtil.getCreators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch (NullPointerException e){}
	JSONArray json = new JSONArray();
	for (Creator creator: creators) {
		JSONObject c = new JSONObject();
		try {
			c.put("id", creator.getCreatorId());
			c.put("value", creator.getFullName());
			c.put("label", creator.getFullName());
			json.put(c);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}	
	
	List<Term> semesters = new ArrayList<Term>(); 
	try{semesters = TermLocalServiceUtil.getAllSemesters();}catch(Exception e){}
	List<Category> categories = new ArrayList<Category>();
	try{categories = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch(Exception e){}

	Map<String,String> subInstitutions = new LinkedHashMap<String, String>();
	subInstitutions = InstitutionLocalServiceUtil.getByParent(reqVideo.getRootInstitutionId());
	List<Institution> producersSubInstitutions = InstitutionLocalServiceUtil.getByParentId(reqProducer.getInstitutionId());
	ListIterator<Institution> itPSI = producersSubInstitutions.listIterator();
	//video upload path
	//is first upload:
	String uploadRepository="";

	Host host = new HostImpl();	
	host = HostLocalServiceUtil.getByHostId(reqVideo.getHostId());
	uploadRepository=PropsUtil.get("lecture2go.media.repository")+"/"+host.getServerRoot()+"/"+reqProducer.getIdNum();
	
%>

<script type="text/javascript">
  $(function(){
    if(isFirstUpload()==1 && getDateTime().length==0){
   	  	$("#date-time-form").fadeIn(1000);
    	$("#upload-form").hide();
    	$("#l2gdate").hide();
    }else{
  	  $("#date-time-form").hide();
	  $("#upload-form").fadeIn(1000); 	
	  $("#<portlet:namespace/>lecture2go-date").val(getDateTime());
    }
    //
    $('#<portlet:namespace/>datetimepicker').datetimepicker({
    	format:'Y-m-d_H-i',
    	dayOfWeekStart : 1,
    	lang:'en',
    	startDate:	new Date(),
    	value: new Date(),
    	maxDate: '+1970/01/30',
    	minDate: false,
    	step:10
    });
  });
</script>
<div class="noresponsive">
	<label class="edit-video-lable"><liferay-ui:message key="upload"/></label>
	<div id="date-time-form">
		<aui:fieldset helpMessage="test" column="true" label="" >
			<aui:layout>
				<aui:input id="datetimepicker" name="datetimepicker" label="select-date-time-bevor-upload"/>
				<aui:button-row>
					<aui:button id="apply-date-time" name="apply-date-time" value="apply-date-time" onClick="applyDateTime();"/>
				</aui:button-row>
			</aui:layout>
		</aui:fieldset>
	</div>
	<div id="upload-form">
		<aui:fieldset helpMessage="test" column="true" label="" >
			<aui:layout>
				<div>
					<input id="fileupload" type="file" name="files[]" data-url="/servlet-file-upload/upload" multiple/>
					<input type="hidden" id="l2gDateTime" value=""/>
					<br/>
					<div id="progress" class="progress">
				    	<div class="bar" style="width: 0%;"></div>
					</div>
					<table id="uploaded-files" class="table"></table>
				</div>
			</aui:layout>
		</aui:fieldset>
	</div>
	
	<aui:fieldset column="false" label="" >
		<aui:layout>
			<aui:form action="<%=actionURL%>" commandName="model" name="metadata">
				<label class="edit-video-lable"><liferay-ui:message key="metadata"/></label>
				<div id="metadata-upload">
				<aui:input id="title" name="title" label="title" required="false" value="<%=reqVideo.getTitle()%>" />
				
				<aui:input id="creator" name="creator" label="creators" required="false" />
							
				<div id="creators"></div>
								
				<aui:select size="1" name="lectureseriesId" label="lecture-series" helpMessage="video-with-or-without-lectureseries" onChange="toggleLectureseries()">
					<aui:option value="0">-<liferay-ui:message key="without-lecture-series"/>-</aui:option>
					<%for (int i = 0; i < reqLectureseriesList.size(); i++) {
						if(reqLectureseriesList.get(i).getLectureseriesId()==reqVideo.getLectureseriesId()){%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>' selected="true"><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}else{%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>'><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}					
					}%>
				</aui:select>
				
				<div id="options">
					<aui:select id="subInstitutionId" size="1" name="subInstitutionId" label="sub-institution">
						<aui:option value="" selected="true"><liferay-ui:message key="select-sub-institution"/></aui:option>
					<%
					Long subInstitutionId = new Long(0);
					try{subInstitutionId = Video_InstitutionLocalServiceUtil.getByVideo(reqVideo.getVideoId()).get(0).getInstitutionId();}catch (Exception e){}
					
					while(itPSI.hasNext()){
						Institution i = itPSI.next();
						%><aui:option value='<%=i.getInstitutionId()%>'><%=i.getName()%></aui:option><%
					}
					%>
					</aui:select>
					
					<div class="subInstitutions" >
						<%
						try{
							//
							for (int i = 0; i < reqSubInstitutions.size(); i++) {
								Institution inst = InstitutionLocalServiceUtil.getById(reqSubInstitutions.get(i).getInstitutionId());
								%>
								<div id='<%=inst.getInstitutionId()%>'> 
									<%=inst.getName()+"&nbsp;&nbsp;&nbsp;" %> 
									<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("<%=inst.getInstitutionId()%>").remove();'></a>
									<aui:input type="hidden" name="institutions" id="institutions" value="<%=inst.getInstitutionId()%>"/>
								</div>
								<%
							}					
						}catch(Exception e){}
						%>				
					</div>	
								
					<aui:select id="termId" size="1" name="termId" label="term">
						<%for (int i = 0; i < semesters.size(); i++) {
							if (reqVideo.getTermId()==semesters.get(i).getTermId()) {%>
								<aui:option value='<%=semesters.get(i).getTermId()%>' selected="true"><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
							<%} else {%>
								<aui:option value='<%=semesters.get(i).getTermId()%>'><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
							<%}
						}%>
					</aui:select>
	
					<aui:select size="1" id="categoryId" name="categoryId" label="category">
						<%
						Long cId = new Long(0);
						try{cId = Video_CategoryLocalServiceUtil.getByVideo(reqVideo.getVideoId()).get(0).getCategoryId();}catch(Exception e){}
						
						for (int i = 0; i < categories.size(); i++) {
							if (cId==categories.get(i).getCategoryId()) {%>
								<aui:option value='<%=categories.get(i).getCategoryId()%>' selected="true"><%=categories.get(i).getName()%></aui:option>
							<%} else {%>
								<aui:option value='<%=categories.get(i).getCategoryId()%>'><%=categories.get(i).getName()%></aui:option>
							<%}
						}%>
					</aui:select>
				</div>
	
				<aui:select size="1" name="language" label="language" required="false">
					<%for (int i=0; i<languages.length; i++){
						if (languages[i].getLanguage().equals(reqMetadata.getLanguage())) {%>
							<aui:option value='<%=languages[i].getLanguage()%>' selected="true"><%=languages[i].getDisplayLanguage()%></aui:option>
						<%} else {%>
							<aui:option value='<%=languages[i].getLanguage()%>'><%=languages[i].getDisplayLanguage()%></aui:option>
						<%}
					}%>				
				</aui:select>
				
				<div id="l2gdate"><aui:input id="lecture2go-date" name="lecture2go-date" label="lecture2go-date" required="false" value="" disabled="true"/></div>
	
				<aui:input name="tags" label="tags" required="false" value="<%=reqVideo.getTags()%>"/>
	
				<aui:input name="publisher" label="publisher" required="false" value="<%=reqMetadata.getPublisher()%>"/>
				
				<aui:field-wrapper label="description">
				    <liferay-ui:input-editor  name="longDesc" toolbarSet="simple" initMethod="initEditor" onChangeMethod="setDescriptionData" cssClass="ta"/>
				    <script type="text/javascript">
				        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(reqMetadata.getDescription()) %>"; }
				    </script>
				</aui:field-wrapper>
				</div>
				
				<div id="permissions">
					<label class="edit-video-lable"><liferay-ui:message key="permissions"/></label>
					<div>
						<aui:input id="password" name="password" label="password" required="false" value="<%=reqVideo.getPassword()%>" />
					</div>
					
					<div id="c2g">
						<%if(reqVideo.getCitation2go()==0){%>
					  		<aui:input name="citationAllowed" type="checkbox" label="citation-allowed" id="citationAllowed"></aui:input>
					   	<%}else{%>
						  <aui:input name="citationAllowed" type="checkbox" label="citation-allowed" id="citationAllowed" checked="true"></aui:input>
					    <%}%>
					</div>
				</div>
				
				<div id="license">
					<label class="edit-video-lable"><liferay-ui:message key="license"/></label>
					<div>
						<%if(reqLicense.getL2go()==1){%><aui:input name="license"  id="uhhl2go" label="" value="uhhl2go" checked="true" type="radio"/><%}%>
						<%if(reqLicense.getL2go()==0){%><aui:input name="license" id="uhhl2go" label="" value="uhhl2go" type="radio"/><%}%>
						<a href="/license" target="_blank"><liferay-ui:message key="lecture2go-licence"/> </a>	 	      	      
					</div>	
					<div>		
						<%if(reqLicense.getCcbyncsa()==1){%><aui:input name="license" label="" id="ccbyncsa" value="ccbyncsa" checked="true" type="radio" /><%}%>
						<%if(reqLicense.getCcbyncsa()==0){%><aui:input name="license" label="" id="ccbyncsa" value="ccbyncsa" type="radio"/><%}%>
						<a href="http://creativecommons.org/licenses/by-nc-sa/3.0/" target="_blank"> <liferay-ui:message key="creative-commons"/> </a>
					</div>
				</div>
				
				<aui:button-row>
					<aui:button value="apply-changes" onclick="applyAllMetadataChanges()" cssClass="btn-primary"/>
					<aui:button type="cancel" value="cancel" href="<%=backURL%>"/>
				</aui:button-row>
				
				<aui:input name="videoId" type="hidden" value="<%=reqVideo.getVideoId()%>"/>
			</aui:form>
		</aui:layout>
	</aui:fieldset>
</div>

<script type="text/javascript">
var $options = $( "#options" );

$(function () {
	c = 0;
	var lsId = <%=reqLectureseries.getLectureseriesId()%>;
	if(lsId>0){
		$options.hide();
	}
	var local_source = <%=json.toString()%>
	$( "#_lgadminvideomanagement_WAR_lecture2goportlet_creator" ).autocomplete({
	    source: function(request, response) {
	        var results = $.ui.autocomplete.filter(local_source, request.term);

	        response(results.slice(0, 10));
	    },
		minLength: 1,
		open: function(event, ui) {
			$('.ui-autocomplete').append('<li id="addNewCreator" class="newcreator"><liferay-ui:message key="add-new-creator"/> <span class="icon-large icon-plus-sign"></span></li>');
			$( "#addNewCreator" ).on( "click", function() {
				c++;
				appendCreator(c);
				$("#_lgadminvideomanagement_WAR_lecture2goportlet_creator").autocomplete('close');
			});
		},
        response: function(event, ui) {
            if (ui.content.length === 0) {
            	avoidClosing = true;
	        }
        },
        close: function(event, ui) {
        	if (avoidClosing) {
        		$("ul.ui-autocomplete li:not(:last)").remove();
            	$("ul.ui-autocomplete").show();
            	avoidClosing = false;
        	}
        },
		select: function (event, ui) {
			if(ui.item.id>0){
  		        var vars = getJSONCreator(ui.item.id);
  		        console.log(vars);
  		        $.template( "filesTemplate", $("#created") );
  		        $.tmpl( "filesTemplate", vars ).appendTo( "#creators" );
  			}
		}
	});
});

function toggleLectureseries(){
	var $lId = $( "#<portlet:namespace/>lectureseriesId option:selected" ).val();
	//
	if($lId==0){
		$options.fadeIn( 500 ); 	
	}else{
		$options.hide();
	}
}

$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        add: function(e, data) {
            var uploadErrors = [];
            var acceptFileTypes = /(mp4|m4v|m4a|mp3|ogg|flv|webm|pdf)$/i;//file types
			
            if (data.originalFiles[0]['type'].length && !acceptFileTypes.test(data.originalFiles[0]['type'])) {
                uploadErrors.push('not an accepted file type');
            }
            if (data.originalFiles[0]['size'].length && data.originalFiles[0]['size'] > 2147483648) {
                uploadErrors.push('max file size 2 GB');
            }
          	//check for first upload
        	if (isFirstUpload()==1) {
        		if (!fileUploadAllowed(data.originalFiles)){
        			uploadErrors.push('first upload has to be a mp3 or mp4 media file');   
        		} else {
        			if(videoFileNameExistsInDatabase(data.originalFiles[0]['name'])==1) uploadErrors.push('file exists in DB, please rename');  
        		}
        	}
            if (uploadErrors.length > 0) {
                alert(uploadErrors.join("\n"));
            } else {
                data.submit();
            }
        },
        done: function (e, data) {
           var vars = data.jqXHR.responseJSON;
           $.template( "filesTemplate", $("#template") );
           $("#"+vars[0].id).remove();   
           $.tmpl( "filesTemplate", vars ).appendTo( ".table" );
           if(isFirstUpload()==1){//update
        	   	var f1 = "mp4";
           		var f2 = "mp3";
           		var f3 = vars[0].fileName;
           		if(f3.indexOf(f1) > -1){
	           		updateVideoFileName(vars[0]);
           		}
           		if(f3.indexOf(f2) > -1){
	           		updateVideoFileName(vars[0]);
           		}
           }else{
				//update only for mp3 and mp4, but without changing the container
				var f1 = vars[0].fileName;
				var f2 = defaultContainer();
				var f3 = "mp4";
				if(f1.indexOf(f2) > -1 || f1.indexOf(f3) > -1){
	           		updateVideoFileName(vars[0]);
				}
           }
        },
        progressall: function (e, data) {
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        if (progress==100){
	        	setTimeout(function(){$('#progress .bar').css('width',0 + '%')}, 2000);
	        }else{
		        $('#progress .bar').css('width',progress + '%');
	        }
   		},
		dropZone: $('#dropzone')
    }).bind('fileuploadsubmit', function (e, data) {
        // The example input, doesn't have to be part of the upload form:
        data.formData = {
        		//p.setHomeDir(PropsUtil.get("lecture2go.media.repository")+"/"+HostLocalServiceUtil.getByHostId(p.getHostId()).getServerRoot()+"/"+p.getHomeDir());
        		repository: "<%=uploadRepository%>",
        		openaccess: "<%=reqVideo.getOpenAccess()%>",
        		lectureseriesNumber: "<%=reqLectureseries.getNumber()%>",
        		fileName: "<%=VideoLocalServiceUtil.getVideo(reqVideo.getVideoId()).getFilename()%>",
        		secureFileName: "<%=VideoLocalServiceUtil.getVideo(reqVideo.getVideoId()).getSecureFilename()%>",
        		l2gDateTime: $("#l2gDateTime").val(),
        		videoId: "<%=reqVideo.getVideoId()%>",
        };        
    });
   
});

function fileUploadAllowed(data){
	var ret = false;
    var acceptFileTypes = /(mp4|mp3)$/i;//allowed file types
    
    data.forEach(function(entry) {
    	console.log(entry['type']);
    	if(acceptFileTypes.test(entry['type'])){
        	ret = true;
        }
    });
    return ret;
}

function defaultContainer(){
	var ret;
	$.ajax({
		  type: "POST",
		  url: "<%=defaultContainerURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data.containerFormat;
		  }
	})
	return ret;
}

function isFirstUpload(){
	var ret = 0;
	$.ajax({
		  type: "POST",
		  url: "<%=isFirstUploadURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data.firstUpload;
		  }
	})
	return ret;
}

function videoFileNameExistsInDatabase (fileName){
	var ret = 0;
	$.ajax({
		  type: "POST",
		  url: "<%=videoFileNameExistsURL%>",
		  dataType: 'json',
		  data: {
			  <portlet:namespace/>fileName: fileName
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data.exist;
		  }
	})
	return ret;
}

function updateVideoFileName(file){
	AUI().use('aui-io-request', 'aui-node',
		function(A){
			A.io.request('<%=updateVideoFileNameURL%>', {
		 	dataType: 'json',
		 	method: 'POST',
			 	//send data to server
			 	data: {
				 	   	<portlet:namespace/>videoId: A.one('#<portlet:namespace/>videoId').get('value'),
				 	   	<portlet:namespace/>fileName: file.fileName,
				 	   	<portlet:namespace/>secureFileName: file.secureFileName,
				 	   	<portlet:namespace/>generationDate: file.generationDate,
			 	},
			 	//get server response
				on: {
					   success: function() {
					     var jsonResponse = this.get('responseData');
					   }
				}
			});	
		}
	);
}

function updateupdateOpenAccessForLectureseries(){
	AUI().use('aui-io-request', 'aui-node',
		function(A){
			A.io.request('<%=updateupdateOpenAccessForLectureseriesURL%>', {
		 	dataType: 'json',
		 	method: 'POST',
			 	//send data to server
			 	data: {
			 	   	<portlet:namespace/>videoId: A.one('#<portlet:namespace/>videoId').get('value'),
			 	},
			 	//get server response
				on: {
					   success: function() {
					     var jsonResponse = this.get('responseData');
					   }
				}
			});	
		}
	);
}

function updateMetadata(){
	AUI().use('aui-io-request', 'aui-node',
		function(A){
			var termId=0;
			var categoryId=0;
			if (!$("#options").is(':hidden')) {
				   termId = A.one('#<portlet:namespace/>termId').get('value');
				   categoryId = A.one('#<portlet:namespace/>categoryId').get('value');
			}
			A.io.request('<%=updateURL%>', {
		 	dataType: 'json',
		 	method: 'POST',
			 	//send data to server
			 	data: {
				 	   	<portlet:namespace/>lectureseriesId: A.one('#<portlet:namespace/>lectureseriesId').get('value'),
				 	   	<portlet:namespace/>videoId: A.one('#<portlet:namespace/>videoId').get('value'),
				 	   	<portlet:namespace/>language: A.one('#<portlet:namespace/>language').get('value'),
				 	   	<portlet:namespace/>title: A.one('#<portlet:namespace/>title').get('value'),
				 	   	<portlet:namespace/>tags: A.one('#<portlet:namespace/>tags').get('value'),
				 	   	<portlet:namespace/>publisher: A.one('#<portlet:namespace/>publisher').get('value'),
				 	   	<portlet:namespace/>citationAllowedCheckbox: A.one('#<portlet:namespace/>citationAllowedCheckbox').get('checked'),
				 	   	<portlet:namespace/>categoryId: categoryId,
				 	   	<portlet:namespace/>termId: termId,
				 	   	<portlet:namespace/>password: A.one('#<portlet:namespace/>password').get('value'),
			 	},
			 	//get server response
				on: {
					   success: function() {
					     var jsonResponse = this.get('responseData');
					   }
				}
			});	
		}
	);
}

function updateLicense(data){	
	AUI().use('aui-io-request', 'aui-node',
		function(A){
			A.io.request('<%=updateLicenseURL%>', {
		 	dataType: 'json',
		 	method: 'POST',
			 	//send data to server
			 	data: {
				 	   	<portlet:namespace/>license: data,
				 	   	<portlet:namespace/>videoId: A.one('#<portlet:namespace/>videoId').get('value'),
			 	},
			 	//get server response
				on: {
					   success: function() {
					     var jsonResponse = this.get('responseData');
					   }
				}
			});	
		}
	);
}

var descData;
function <portlet:namespace/>setDescriptionData(data){
	descData = data;
}

function applyAllMetadataChanges(){
	AUI().use(
			'aui-node',
			function(A) {
					// Select the node(s) using a css selector string
				    var license = A.one("input[name=<portlet:namespace/>license]:checked").get("value");
				    //alert(license2.get('value'));
				    updateDescription(descData);
				    updateLicense(license);
				    updateCreators();
				    updateSubInstitutions();
				    updateMetadata();//last place, important!
				    alert("<liferay-ui:message key='changes-applied'/>");
			}
	);
}

function updateDescription(data){
	AUI().use('aui-io-request', 'aui-node',
		function(A){
			A.io.request('<%=updateDescriptionURL%>', {
		 	dataType: 'json',
		 	method: 'POST',
			 	//send data to server
			 	data: {
				 	   	<portlet:namespace/>description: data,
				 	   	<portlet:namespace/>videoId: A.one('#<portlet:namespace/>videoId').get('value'),
			 	},
			 	//get server response
				on: {
					   success: function() {
					     var jsonResponse = this.get('responseData');
					   }
				}
			});	
		}
	);
}

function deleteFile(fileName){
	if(confirm('<liferay-ui:message key="really-delete-question"/>')){
		$.ajax({
		    url: '<%=deleteFileURL.toString()%>',
		    method: 'POST',
		    dataType: "json",
		    data: {
		 	   	<portlet:namespace/>fileName: fileName,
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		    },
		    success: function(data) {
		        //since we are using jQuery, you don't need to parse response
		        console.log(data);
		        for (var i = 0; i < data.length; i++) {
		            var obj = data[i];
			        var id = "#"+obj.fileId;
			        $(id).remove();
		        }
		        //update view
		        if (isFirstUpload()==1){
		      	  	$('#date-time-form').fadeIn( 500 );
		    	  	$("#upload-form").hide(); 
		        }
		        //hide date fild
		        $("#l2gdate").hide();
		    }
		});	
	}
}

function updateCreators(){
	var namespace="<portlet:namespace/>";
	var jsonArray = [];
	$('#creators').children().each(function(n){
		var parameters = {};
		var $div = $(this);
		var id = $div.attr('id');
		if(id.indexOf("nc")==-1){
			parameters['creatorId'] = $div.find('input[name = '+namespace+'creatorId]').val();
			parameters['firstName'] = $div.find('input[name = '+namespace+'firstName]').val();
			parameters['lastName'] = $div.find('input[name = '+namespace+'lastName]').val();
			parameters['middleName'] = "";
			parameters['jobTitle'] = $div.find('input[name = '+namespace+'jobTitle]').val();
			parameters['gender'] = "";
			parameters['fullName'] = $div.find('input[name = '+namespace+'fullName]').val();
		}else{
			parameters['creatorId'] = "0";
			parameters['firstName'] = $div.find('input[name = '+namespace+'firstName]').val().trim();
			parameters['lastName'] = $div.find('input[name = '+namespace+'lastName]').val().trim();
			parameters['middleName'] = "";
			parameters['jobTitle'] = $div.find('#'+namespace+'jobTitle option:selected').val();
			parameters['gender'] = "";
			parameters['fullName'] = parameters['jobTitle']+" "+parameters['firstName']+" "+parameters['lastName'];		
		}
		if(parameters['firstName'].length>0 && parameters['lastName'].length>0){
			jsonArray[n]=parameters;
		}
	});
	//set parameter to server for update 
	$.ajax({
		  type: "POST",
		  url: "<%=updateCreatorsURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>creator: JSON.stringify(jsonArray),
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    //remove all creators 
		    $( "#creators" ).empty();
		    //and show new creators list
	        $.template( "filesTemplate", $("#created") );
	        $.tmpl( "filesTemplate", data ).appendTo( "#creators" );		    
		  }
	})
}

function applyDateTime(){
	  var genDate = $('#<portlet:namespace/>datetimepicker').val();
	  //
	  $.ajax({
			  type: "POST",
			  url: "<%=videoUpdateGenerationDateURL%>",
			  dataType: 'json',
			  data: {
				  <portlet:namespace/>generationDate: genDate,
			 	  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			  },
			  global: false,
			  async:false,
			  success: function(data) {
				  $('#date-time-form').hide();
				  $("#upload-form").fadeIn(500); 	
				  $("#tm").text(getDateTime());
				  $("#<portlet:namespace/>lecture2go-date").val(genDate);
				  $("#l2gdate").fadeIn(1000);
			  }
	  })
}

function getDateTime(){
	var ret ="";
	  //
	  $.ajax({
			  type: "POST",
			  url: "<%=getGenerationDateURL%>",
			  dataType: 'json',
			  data: {
			 	  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			  },
			  global: false,
			  async:false,
			  success: function(data) {
				 ret=data.generationDate; 
			  }
	  })
	  return ret;
}

function updateSubInstitutions(){
	var namespace="<portlet:namespace/>";
	var jsonArray = [];
	$('.subInstitutions').children().each(function(n){
		var parameters = {};
		var $div = $(this);
		var id = $div.attr('id');
		parameters['institutionId'] = id;
		jsonArray[n]=parameters;
	});
	//set parameter to server for update 
	$.ajax({
		  type: "POST",
		  url: "<%=updateSubInstitutionsURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>subInstitution: JSON.stringify(jsonArray),
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    //		    
		  }
	})
}

function appendCreator(c){
	$(function () {
    	var vars = {'counter':c};
    	$.template( "filesTemplate", $("#newCreator") );
    	$.tmpl( "filesTemplate", vars ).appendTo( "#creators" );
	});
};

var c = 0;


function remb(c){
	$("#"+c).remove();
}

AUI().use('aui-node',
  function(A){
	// Select the node(s) using a css selector string
    var subInstitutionId = A.one('#<portlet:namespace/>subInstitutionId');
    var subInstitutions = A.one('.subInstitutions');
	var citationAllowed = A.one('#<portlet:namespace/>citationAllowedCheckbox');

	citationAllowed.on(
			'click',
			function(A){
				toggleCitationAllowed(citationAllowed.get('checked'))
			}
	)
    
    subInstitutionId.on(
          'change',
          function(A) {
      			if(subInstitutionId.get('value')>0){
      	   	 		var n = subInstitutionId.get(subInstitutionId.get('selectedIndex')).get('value');
      	    		var t = subInstitutionId.get(subInstitutionId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
      	    		subInstitutions.append("<div id='"+n+"'> "+t+" <a class='icon-large icon-remove style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove();'/><input id='<portlet:namespace></portlet:namespace>institutions' name='<portlet:namespace></portlet:namespace>institutions' value='"+n+"' type='hidden'/></div>");
      			}
          }
     );
 
  }
);

function getJSONCreator (data){
	var ret;
	$.ajax({
		  type: "POST",
		  url: "<%=getJSONCreatorURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>creatorId: data,
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data;
		  }
	})
	return ret;
}
</script>

<!-- Template -->
<script type="text/x-jquery-tmpl" id="template">
   	<tr id="<%="${id}"%>">
    	<td><%="${name}"%></td>
    	<td>
			<a class="icon-large icon-remove" onclick="deleteFile('<%="${name}"%>');"></a>
		</td>
   	</tr>
</script>

<script type="text/javascript">
    $(function () {
        var vars = <%=VideoLocalServiceUtil.getJSONVideo(reqVideo.getVideoId()).toString()%>;
        console.log(vars);
        $.template( "filesTemplate", $("#template") );
        $.tmpl( "filesTemplate", vars ).appendTo( ".table" );
    });
</script>

<!-- Template -->
<script type="text/x-jquery-tmpl" id="newCreator">
	<div id="nc<%="${counter}"%>">
	<aui:input type="hidden" name="gender"/>
	<aui:input name="jobTitle" type="text"/>
	<aui:input name="firstName" type="text"/>
	<aui:input name="middleName" type="text"/>
	<aui:input name="lastName" type="text"/>
	<aui:input name="creatorId" value="0" type="hidden"/>
	<a class="icon-large icon-remove" onclick="remb('<%="nc${counter}"%>');"></a>
	<br/>
	</div>
</script>

<!-- Template -->
<script type="text/x-jquery-tmpl" id="created">
   	<div id="<%="c${creatorId}"%>">
    	<%="${fullName}"%> &nbsp; <a class="icon-large icon-remove" onclick="remb('<%="c${creatorId}"%>');"></a>
		<aui:input type="hidden" name="gender"/>
		<input type="hidden" name="<portlet:namespace/>creatorId" value="<%="${creatorId}"%>"/>
		<input type="hidden" name="<portlet:namespace/>firstName" value="<%="${firstName}"%>"/>
		<input type="hidden" name="<portlet:namespace/>lastName" value="<%="${lastName}"%>"/>
		<input type="hidden" name="<portlet:namespace/>jobTitle" value="<%="${jobTitle}"%>"/>
		<input type="hidden" name="<portlet:namespace/>fullName" value="<%="${fullName}"%>"/>
	</div>
</script>

<script type="text/javascript">
		<%
			String vars ="";
			try{
				vars = CreatorLocalServiceUtil.getJSONCreatorsByVideoId(reqVideo.getVideoId()).toString();
			}catch(Exception e){}
		%>
		
		$(function () {
	        var vars = <%=vars%>;
	        $.template( "filesTemplate", $("#created") );
	        $.tmpl( "filesTemplate", vars ).appendTo( "#creators" );
	    });
</script>
