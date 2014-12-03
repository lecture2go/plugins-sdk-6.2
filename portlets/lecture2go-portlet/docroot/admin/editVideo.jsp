<%@include file="/init.jsp"%>

<jsp:useBean id="reqLectureseriesList" type="java.util.List<de.uhh.l2g.plugins.model.Lectureseries>" scope="request" />
<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="reqLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<%
	String actionURL = "";
	
	Map<String,String> facilities = new LinkedHashMap<String, String>();
	if(permissionAdmin){
		facilities = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
	}
	if(permissionCoordinator)facilities = InstitutionLocalServiceUtil.getByParent(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getInstitutionId());

	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";

	List<String> semesters = LectureseriesLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);

	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
%>

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/admin/videosList.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editVideo" var="editURL">
	<portlet:param name="videoId" value='<%=""+reqVideo.getVideoId()%>' />
</portlet:actionURL>

<portlet:actionURL name="removeVideo" var="removeURL">
	<portlet:param name="videoId" value='<%=""+reqVideo.getVideoId()%>' />
</portlet:actionURL>

<portlet:actionURL name="addVideo" var="addURL">
	<portlet:param name="videoId" value='<%=""+0%>' />
</portlet:actionURL>

<portlet:actionURL var="editCaseURL" name="uploadCase">
	<portlet:param name="jspPage" value="/admin/editVideo.jsp" />
</portlet:actionURL>
<%
	if(reqVideo.getVideoId() >0) {actionURL=editURL.toString();}
	else {actionURL = addURL.toString();}
%>

<portlet:resourceURL id="uploadMe" var="uploadMe" />
 
<aui:fieldset helpMessage="test" column="true" label="video-file" >
	<%@include file="/admin/includeJQueryUpload.jsp" %>
</aui:fieldset>

<br/>

<aui:fieldset helpMessage="test" column="true" label="video-metadata" >
	<aui:layout>
		<aui:form action="<%=actionURL%>" commandName="model" name="metadata">
			<aui:select size="1" name="lectureseriesId" label="lectureseries" required="true">
				<aui:option value="">select-lecture-series</aui:option>
					<%for (int i = 0; i < reqLectureseriesList.size(); i++) {
						if(reqLectureseriesList.get(i).getLectureseriesId()==reqVideo.getLectureseriesId()){%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>' selected="true"><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}else{%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>'><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}					
					}%>
			</aui:select>
			
			<aui:select size="1" name="language" label="language" required="true">
				<aui:option value="">select-language</aui:option>
				<%for (int i=0; i<languages.length; i++){
					if (languages[i].getLanguage().equals(reqMetadata.getLanguage())) {%>
						<aui:option value='<%=languages[i].getLanguage()%>' selected="true"><%=languages[i].getDisplayLanguage()%></aui:option>
					<%} else {%>
						<aui:option value='<%=languages[i].getLanguage()%>'><%=languages[i].getDisplayLanguage()%></aui:option>
					<%}
				}%>				
			</aui:select>
			
			<aui:input id="title" name="title" label="title" required="true" value="<%=reqVideo.getTitle()%>" />

			<aui:input name="tags" label="tags" required="false" value="<%=reqVideo.getTags()%>"/>

			<aui:input name="creator" label="creator" required="true" value="<%=reqMetadata.getCreator()%>"/>

			<aui:input name="rightsHolder" label="rightsHolder" required="true" value="<%=reqMetadata.getRightsHolder()%>"/>
			
			<aui:input name="publisher" label="publisher" required="true" value="<%=reqMetadata.getPublisher()%>"/>
	
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
			    <liferay-ui:input-editor name="longDesc" toolbarSet="liferay-article" initMethod="initEditor" width="250" onChangeMethod="setLongDesc" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(reqMetadata.getDescription()) %>"; }
			    </script>
			</aui:field-wrapper>
			<aui:button-row>
				<aui:button type="cancel" value="go to overview" onClick="<%=cancelURL.toString()%>" />
				<%if (reqVideo.getVideoId()>0) {%>
					<liferay-ui:icon-menu cssClass="right">
						<liferay-ui:icon image="delete" message="Remove" url="<%=removeURL.toString()%>" />
					</liferay-ui:icon-menu>
				<%}%>
			</aui:button-row>
			
			<aui:input name="producerId" type="hidden" value="<%=reqProducer.getProducerId()%>"/>
			<aui:input name="licenseId" type="hidden" value="<%=reqLicense.getLicenseId()%>"/>
			<aui:input name="videoId" type="hidden" value="<%=reqVideo.getVideoId()%>"/>
			<aui:input name="metadataId" type="hidden" value="<%=reqMetadata.getMetadataId()%>"/>
			<aui:input name="lectureseriesId" type="hidden" value="<%=reqLectureseries.getLectureseriesId()%>"/>
		</aui:form>
	</aui:layout>
</aui:fieldset>

<liferay-portlet:resourceURL id="updateMeatadata" var="updateURL" />

<script type="text/javascript">
var longDesc;

function <portlet:namespace/>setLongDesc(data){
	this.longDesc = data;
	//update desc
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
				 	   	<portlet:namespace/>metadataId: A.one('#<portlet:namespace/>metadataId').get('value'),
				 	   	<portlet:namespace/>licenseId: A.one('#<portlet:namespace/>licenseId').get('value'),
				 	   	<portlet:namespace/>language: A.one('#<portlet:namespace/>language').get('value'),
				 	   	<portlet:namespace/>title: A.one('#<portlet:namespace/>title').get('value'),
				 	   	<portlet:namespace/>tags: A.one('#<portlet:namespace/>tags').get('value'),
				 	   	<portlet:namespace/>creator: A.one('#<portlet:namespace/>creator').get('value'),
				 	   	<portlet:namespace/>rightsHolder: A.one('#<portlet:namespace/>rightsHolder').get('value'),
				 	   	<portlet:namespace/>publisher: A.one('#<portlet:namespace/>publisher').get('value'),
				 	   	<portlet:namespace/>producerId: A.one('#<portlet:namespace/>producerId').get('value'),
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


AUI().use(
		'aui-node',
		function(A) {
				// Select the node(s) using a css selector string
			    var language = A.one('#<portlet:namespace/>language');
			    var title = A.one('#<portlet:namespace/>title');
			    var tags = A.one('#<portlet:namespace/>tags');
			    var creator = A.one('#<portlet:namespace/>creator');
			    var rightsHolder = A.one('#<portlet:namespace/>rightsHolder');
			    var publisher = A.one('#<portlet:namespace/>publisher');
			    var license1 = A.one('#<portlet:namespace/>ccbyncsa');
			    var license2 = A.one('#<portlet:namespace/>uhhl2go');
			    
			    title.on('keyup',function(A){updateMetadata()});
				language.on('change',function(A){updateMetadata()});
			    tags.on('keyup',function(A){updateMetadata()});
			    creator.on('keyup',function(A){updateMetadata()});
			    rightsHolder.on('keyup',function(A){updateMetadata()});
			    publisher.on('keyup',function(A){updateMetadata()});
			    license1.on('change',function(A){updateMetadata()});
			    license2.on('change',function(A){updateMetadata()});
		}
);

function uploadFileMe(){
	$.ajaxFileUpload
	({
		url:'<%=uploadMe%>',
		secureuri : false,
		fileElementId : 'fileToUpload',
		dataType : 'json',
		data : {
			name : 'fileToUpload',
			id : 'fileToUpload'	
		},
		success : function(data, status) {
			if (typeof (data.error) != 'undefined') {
				if (data.error != '') {
				 //alert(data.error);
				} else {
				 //alert(data.msg);
				}
			}
		},
		error : function(data, status, e) {
		 //alert(e);
		}
	});
}
</script>