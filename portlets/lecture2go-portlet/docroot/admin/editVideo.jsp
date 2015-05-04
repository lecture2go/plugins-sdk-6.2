<%@include file="/init.jsp"%>

<jsp:useBean id="reqLectureseriesList" type="java.util.List<de.uhh.l2g.plugins.model.Lectureseries>" scope="request" />
<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="reqLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />

<liferay-portlet:resourceURL id="updateMeatadata" var="updateURL" />
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
	List<Term> semesters = new ArrayList<Term>(); 
	try{semesters = TermLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch(Exception e){}
	List<Category> categories = new ArrayList<Category>();
	try{categories = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch(Exception e){}

	Map<String,String> subInstitutions = new LinkedHashMap<String, String>();
	subInstitutions = InstitutionLocalServiceUtil.getByParent(reqVideo.getRootInstitutionId());
%>

<script type="text/javascript">
  $("#upload-form").hide();
  $(function(){
    if(isFirstUpload()==1){
    	$("#upload-form").hide();
    }else{
  	  $('#date-time-form').hide();
	  $("#upload-form").fadeIn( 1000 ); 	
    }
    //
    $('#<portlet:namespace/>datetimepicker').datetimepicker({
    	format:'Y-m-d_H-i',
    	dayOfWeekStart : 1,
    	lang:'en',
    	startDate:	new Date(),
    	value: new Date(),
    	maxDate: new Date(),
    	minDate: false,
    	step:10
    });
  });
  
  function applyDateTime(){
	  $('#date-time-form').fadeOut( 1000 );
	  $("#upload-form").fadeIn( 1000 ); 	
	  $("#l2gDateTime").val( $('#<portlet:namespace/>datetimepicker').val());
  }
</script>

<div id="date-time-form">
	<aui:fieldset helpMessage="test" column="true" label="video-file" >
		<aui:layout>
			<aui:input id="datetimepicker" name="datetimepicker" label="chose-date-first"/>
			<aui:button-row>
				<aui:button id="apply-date-time" name="apply-date-time" value="apply-date-time" onClick="applyDateTime();"/>
				<aui:button type="cancel" value="cancel" href="<%=backURL%>"/>
			</aui:button-row>
		</aui:layout>
	</aui:fieldset>
</div>

<div id="upload-form">
	<aui:fieldset helpMessage="test" column="true" label="video-file" >
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
	
	<aui:fieldset helpMessage="test" column="true" label="video-metadata" >
		<aui:layout>
			<aui:form action="<%=actionURL%>" commandName="model" name="metadata">
				<aui:select size="1" name="lectureseriesId" label="lectureseries" onChange="toggleLectureseries()">
					<aui:option value="0">select-lecture-series</aui:option>
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
						<aui:option value="">select-sub-institution</aui:option>
					<%
					Long subInstitutionId = new Long(0);
					try{subInstitutionId = Video_InstitutionLocalServiceUtil.getByVideo(reqVideo.getVideoId()).get(0).getInstitutionId();}catch (Exception e){}
					
					for (Map.Entry<String, String> f : subInstitutions.entrySet()) {
					if(f.getKey().equals(subInstitutionId.toString())){
						%><aui:option value='<%=f.getKey()%>' selected="true"><%=f.getValue()%></aui:option>
						<%}else{%>
						<aui:option value='<%=f.getKey()%>'><%=f.getValue()%></aui:option>
						<%}
					}%>
					</aui:select>
					
					<div class="subInstitutions" >
						<%
						List<Video_Institution> subInst = new ArrayList<Video_Institution>();
						subInst = Video_InstitutionLocalServiceUtil.getByVideo(reqVideo.getVideoId());
						
						try{
							for (int i = 0; i < subInst.size(); i++) {
								Institution inst = InstitutionLocalServiceUtil.getById(subInst.get(i).getInstitutionId());
								%>
								<div id='<%=inst.getInstitutionId()%>'> 
									<%=inst.getName()+"&nbsp;&nbsp;&nbsp;" %> 
									<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("<%=inst.getInstitutionId()%>").remove();'></a>
									<aui:input type="hidden" name="institutions" id="institutions" value="<%=inst.getInstitutionId()%>"/>
								</div>
								<%
							}					
						}catch(Exception e){
							//
						}
						%>				
					</div>	
								
					<aui:select id="termId" size="1" name="termId" label="term">
						<aui:option value="">select-term</aui:option>
						<%for (int i = 0; i < semesters.size(); i++) {
							if (reqVideo.getTermId()==semesters.get(i).getTermId()) {%>
								<aui:option value='<%=semesters.get(i).getTermId()%>' selected="true"><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
							<%} else {%>
								<aui:option value='<%=semesters.get(i).getTermId()%>'><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
							<%}
						}%>
					</aui:select>
	
					<aui:select size="1" id="categoryId" name="categoryId" label="event-type" required="true">
						<aui:option value="">select-category</aui:option>
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
					<aui:option value="">select-language</aui:option>
					<%for (int i=0; i<languages.length; i++){
						if (languages[i].getLanguage().equals(reqMetadata.getLanguage())) {%>
							<aui:option value='<%=languages[i].getLanguage()%>' selected="true"><%=languages[i].getDisplayLanguage()%></aui:option>
						<%} else {%>
							<aui:option value='<%=languages[i].getLanguage()%>'><%=languages[i].getDisplayLanguage()%></aui:option>
						<%}
					}%>				
				</aui:select>
				
				<aui:input id="title" name="title" label="title" required="false" value="<%=reqVideo.getTitle()%>" />
	
				<aui:input name="tags" label="tags" required="false" value="<%=reqVideo.getTags()%>"/>
	
				<aui:input name="publisher" label="publisher" required="false" value="<%=reqMetadata.getPublisher()%>"/>
				
				<aui:select size="1" name="crId" label="creators">
					<aui:option value="">select-creator</aui:option>
					<%for (int i = 0; i < creators.size(); i++) {
						%><aui:option value='<%=creators.get(i).getCreatorId()%>'><%=creators.get(i).getJobTitle() + " "+creators.get(i).getLastName() + ", " + creators.get(i).getFirstName()%></aui:option><%
					}%>	
				</aui:select>	
							
				<div id="creators"></div>
	
				<a id="addCreator">
				    add-new-creator <span class="icon-large icon-plus-sign"></span>
				</a>
				<br/><br/>
		
				license
				<br/>
				<em>uhh-l2go</em>
				<%if(reqLicense.getL2go()==1){%><aui:input name="license"  id="uhhl2go" value="uhhl2go" checked="true" type="radio"/><%}%>
				<%if(reqLicense.getL2go()==0){%><aui:input name="license" id="uhhl2go" value="uhhl2go" type="radio"/><%}%>
				lecture2go-licence <a href="/license" target="_blank"> details </a>	 	      	      
				<br/><br/>
				
				<em>by-nc-sa</em>	
				<%if(reqLicense.getCcbyncsa()==1){%><aui:input name="license" id="ccbyncsa" value="ccbyncsa" checked="true" type="radio" /><%}%>
				<%if(reqLicense.getCcbyncsa()==0){%><aui:input name="license" id="ccbyncsa" value="ccbyncsa" type="radio"/><%}%>
				creative-commons <a href="http://creativecommons.org/licenses/by-nc-sa/3.0/" target="_blank"> details </a>
				
				<br/><br/>
				
				<aui:field-wrapper label="description">
				    <liferay-ui:input-editor name="longDesc" toolbarSet="liferay-article" initMethod="initEditor" width="250" onChangeMethod="setDescriptionData" />
				    <script type="text/javascript">
				        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(reqMetadata.getDescription()) %>"; }
				    </script>
				</aui:field-wrapper>
				
				<aui:button-row>
					<aui:button value="apply changes" onclick="applyAllMetadataChanges()"/>
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
	var lsId = <%=reqLectureseries.getLectureseriesId()%>;
	if(lsId>0){
		$options.fadeOut(1000);
	}
});

function toggleLectureseries(){
	var $lId = $( "#<portlet:namespace/>lectureseriesId option:selected" ).val();
	//
	if($lId==0){
		$options.fadeIn( 1000 ); 	
	}else{
		$options.fadeOut(1000);
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
	        $('#progress .bar').css('width',progress + '%');
   		},
		dropZone: $('#dropzone')
    }).bind('fileuploadsubmit', function (e, data) {
        // The example input, doesn't have to be part of the upload form:
        data.formData = {
        		repository: "<%=reqProducer.getHomeDir()%>",
        		openaccess: "<%=reqVideo.getOpenAccess()%>",
        		lectureseriesNumber: "<%=reqLectureseries.getNumber()%>",
        		fileName: "<%=VideoLocalServiceUtil.getVideo(reqVideo.getVideoId()).getFilename()%>",
        		secureFileName: "<%=VideoLocalServiceUtil.getVideo(reqVideo.getVideoId()).getSurl()%>",
        };        
    });
   
});

function fileUploadAllowed(data){
	var ret = false;
    var acceptFileTypes = /(mp4|mp3)$/i;//file types
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
				 	   	<portlet:namespace/>lectureseriesId: A.one('#<portlet:namespace/>lectureseriesId').get('value'),
				 	   	<portlet:namespace/>categoryId: categoryId,
				 	   	<portlet:namespace/>termId: termId,
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
				    var license1 = A.one('#<portlet:namespace/>ccbyncsa');
				    var license2 = A.one('#<portlet:namespace/>uhhl2go');
				    
				    updateDescription(descData);
				    updateLicense(license1.get('value'));
				    updateLicense(license2.get('value'));
				    updateCreators();
				    updateSubInstitutions();
				    updateMetadata();//last place, important!
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
	confirm("really? you want to remove this file? ");
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
	    }
	});	
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
$( "#addCreator" ).on( "click", function() {
	c++;
	appendCreator(c);
});

function remb(c){
	$("#"+c).remove();
}

AUI().use('aui-node',
  function(A){
	// Select the node(s) using a css selector string
    var crId = A.one('#<portlet:namespace/>crId');
    var subInstitutionId = A.one('#<portlet:namespace/>subInstitutionId');
    var subInstitutions = A.one('.subInstitutions');

    crId.on(
      	'change',
      	function(A) {
  			if(crId.get('value')>0){
  		        var vars = getJSONCreator(crId.get('value'));
  		        console.log(vars);
  		        $.template( "filesTemplate", $("#created") );
  		        $.tmpl( "filesTemplate", vars ).appendTo( "#creators" );
  			}
      	}
    );
    
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
	<aui:select size="1" name="jobTitle" label="">
		<aui:option value=""></aui:option>
		<%
		String[] l =  LanguageUtil.get(pageContext, "creator-titles").split(",");
		for(int i=0; i<l.length; i++){
			String title = l[i];
			%><aui:option value="<%=title%>"><%=title%></aui:option><%
		}
		%>
	</aui:select>
	<aui:input name="firstName" type="text"/>
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