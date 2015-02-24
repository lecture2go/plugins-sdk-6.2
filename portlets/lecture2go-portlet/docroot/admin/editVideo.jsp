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

	List<String> semesters = LectureseriesLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);

	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	String backURL = request.getAttribute("backURL").toString();
%>
 
<aui:fieldset helpMessage="test" column="true" label="video-file" >
	<div>
		<input id="fileupload" type="file" name="files[]" data-url="/servlet-file-upload/upload" multiple>
		<br/>
		<div id="progress" class="progress">
	    	<div class="bar" style="width: 0%;"></div>
		</div>
		<table id="uploaded-files" class="table"></table>
	</div>
</aui:fieldset>

<aui:fieldset helpMessage="test" column="true" label="video-metadata" >
	<aui:layout>
		<aui:form action="<%=actionURL%>" commandName="model" name="metadata">
			<aui:select size="1" name="lectureseriesId" label="lectureseries">
				<aui:option value="">select-lecture-series</aui:option>
					<%for (int i = 0; i < reqLectureseriesList.size(); i++) {
						if(reqLectureseriesList.get(i).getLectureseriesId()==reqVideo.getLectureseriesId()){%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>' selected="true"><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}else{%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>'><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}					
					}%>
			</aui:select>
			
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

			<aui:input name="creator" label="creator" required="false" value="<%=reqMetadata.getCreator()%>"/>

			<aui:input name="rightsHolder" label="rightsHolder" required="false" value="<%=reqMetadata.getRightsHolder()%>"/>
			
			<aui:input name="publisher" label="publisher" required="false" value="<%=reqMetadata.getPublisher()%>"/>
	
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
				<aui:button value="save" onclick="applyAllMetadataChanges()"/>
				<aui:button type="cancel" value="cancel" href="<%=backURL%>"/>
			</aui:button-row>
			
			<aui:input name="videoId" type="hidden" value="<%=reqVideo.getVideoId()%>"/>
		</aui:form>
	</aui:layout>
</aui:fieldset>

<script type="text/javascript">
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
					     //alert(jsonResponse.key1);
					   }
				}
			});	
		}
	);
}

function updateMetadata(){
	AUI().use('aui-io-request', 'aui-node',
		function(A){
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
				 	   	<portlet:namespace/>creator: A.one('#<portlet:namespace/>creator').get('value'),
				 	   	<portlet:namespace/>rightsHolder: A.one('#<portlet:namespace/>rightsHolder').get('value'),
				 	   	<portlet:namespace/>publisher: A.one('#<portlet:namespace/>publisher').get('value'),
				 	   	<portlet:namespace/>lectureseriesId: A.one('#<portlet:namespace/>lectureseriesId').get('value'),
			 	},
			 	//get server response
				on: {
					   success: function() {
					     var jsonResponse = this.get('responseData');
					     //alert(jsonResponse.key1);
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
	alert("testeee");
	AUI().use(
			'aui-node',
			function(A) {
					// Select the node(s) using a css selector string
				    var lectureseries = A.one('#<portlet:namespace/>lectureseriesId');
				    var language = A.one('#<portlet:namespace/>language');
				    var title = A.one('#<portlet:namespace/>title');
				    var tags = A.one('#<portlet:namespace/>tags');
				    var creator = A.one('#<portlet:namespace/>creator');
				    var rightsHolder = A.one('#<portlet:namespace/>rightsHolder');
				    var publisher = A.one('#<portlet:namespace/>publisher');
				    var license1 = A.one('#<portlet:namespace/>ccbyncsa');
				    var license2 = A.one('#<portlet:namespace/>uhhl2go');
				    
				    lectureseries.on('change',function(A){updateMetadata()});
					language.on('change',function(A){updateMetadata()});
				    license2.on('change',function(A){updateLicense(license2.get('value'))});
				    license1.on('change',function(A){updateLicense(license1.get('value'))});

					title.on('change',function(A){updateMetadata()});
				    tags.on('change',function(A){updateMetadata()});
				    creator.on('change',function(A){updateMetadata()});
				    rightsHolder.on('change',function(A){updateMetadata()});
				    publisher.on('change',function(A){updateMetadata()});
			}
	);
}

function <portlet:namespace/>updateDescription(data){
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
	        // since we are using jQuery, you don't need to parse response
	        console.log(data);
	        for (var i = 0; i < data.length; i++) {
	            var obj = data[i];
		        var id = "#"+obj.fileId;
		        $(id).remove();
	        }
	    }
	});	
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
        $.template( "filesTemplate", $("#template") );
        $.tmpl( "filesTemplate", vars ).appendTo( ".table" );
    });
</script>
