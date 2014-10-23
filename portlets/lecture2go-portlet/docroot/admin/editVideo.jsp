<%@include file="/init.jsp"%>

<jsp:useBean id="lectureseries" type="java.util.List<de.uhh.l2g.plugins.model.Lectureseries>" scope="request" />
<jsp:useBean id="license" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="producer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="citation2go" type="java.lang.Integer" scope="request" />

<%
	String actionURL = "";
	String vTitle = "";
	String vTags = "";
	String mCreator = "";
	String mRightsHolder = "";
	String mPublisher = "";
	String mDescription = "";

	MetadataImpl metadata = new MetadataImpl();
	
	Long producerId = ServletRequestUtils.getLongParameter(request, "producerId", 0);
	Long lectureseriesId = ServletRequestUtils.getLongParameter(request, "lectureseriesId", 0);
	
	Long vId=new Long(0);
	VideoImpl reqVideo = new VideoImpl();
	try{
		reqVideo = (VideoImpl)request.getAttribute("reqVideo");
		vTags = reqVideo.getTags();
		vTitle = reqVideo.getTitle();
		vId = reqVideo.getVideoId();
	}catch(Exception e){}
	try{
		metadata = (MetadataImpl)MetadataLocalServiceUtil.getMetadata(reqVideo.getMetadataId());
		mCreator = metadata.getCreator();
		mRightsHolder = metadata.getRightsHolder();
		mPublisher = metadata.getPublisher();
		mDescription = metadata.getDescription();
	}catch(Exception e){}
	
	Long facilityId = new Long(0);
	//TODO
	
	Map<String,String> facilities = new LinkedHashMap<String, String>();
	if(permissionAdmin){
		facilities = FacilityLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
	}
	if(permissionCoordinator)facilities = FacilityLocalServiceUtil.getByParent(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getFacilityId());

	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";

	List<String> semesters = LectureseriesLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	
%>

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/admin/videosList.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editVideo" var="editURL">
	<portlet:param name="videoId" value='<%=""+vId%>' />
</portlet:actionURL>

<portlet:actionURL name="removeVideo" var="removeURL">
	<portlet:param name="videoId" value='<%=""+vId%>' />
</portlet:actionURL>

<portlet:actionURL name="addVideo" var="addURL">
	<portlet:param name="videoId" value='<%=""+vId%>' />
</portlet:actionURL>

<%
	if(vId >0) {actionURL=editURL.toString();}
	else {actionURL = addURL.toString();}
%>


<aui:form action="<%=actionURL%>" commandName="model">
	<aui:fieldset helpMessage="test" column="true" label="">
		<aui:layout>
			
			<aui:select size="1" name="lectureseriesId" label="lectureseries" required="true">
				<aui:option value="">select-lecture-series</aui:option>
					<%for (int i = 0; i < lectureseries.size(); i++) {
						if(lectureseries.get(i).getLectureseriesId()==reqVideo.getLectureseriesId()){%>
							<aui:option value='<%=lectureseries.get(i).getLectureseriesId()%>' selected="true"><%=lectureseries.get(i).getName()%></aui:option>
						<%}else{%>
							<aui:option value='<%=lectureseries.get(i).getLectureseriesId()%>'><%=lectureseries.get(i).getName()%></aui:option>
						<%}					
					}%>
			</aui:select>
			
			<aui:select size="1" name="language" label="language" required="true">
				<aui:option value="">select-language</aui:option>
				<%for (int i=0; i<languages.length; i++){
					if (languages[i].getLanguage().equals(metadata.getLanguage())) {%>
						<aui:option value='<%=languages[i].getLanguage()%>' selected="true"><%=languages[i].getDisplayLanguage()%></aui:option>
					<%} else {%>
						<aui:option value='<%=languages[i].getLanguage()%>'><%=languages[i].getDisplayLanguage()%></aui:option>
					<%}
				}%>				
			</aui:select>
			
			<aui:input name="title" label="title" required="true" value="<%=vTitle%>" />

			<aui:input name="tags" label="tags" required="false" value="<%=vTags%>"/>

			<aui:input name="creator" label="creator" required="true" value="<%=mCreator%>"/>

			<aui:input name="rightsHolder" label="rightsHolder" required="true" value="<%=mRightsHolder%>"/>
			
			<aui:input name="publisher" label="publisher" required="true" value="<%=mPublisher%>"/>
	
			license
			<br/>
			<em>uhh-l2go</em>
			<%if(license.getL2go()==1){%><aui:input name="license" value="uhhl2go" checked="true" type="radio"/><%}%>
			<%if(license.getL2go()==0){%><aui:input name="license" value="uhhl2go" type="radio"/><%}%>
			lecture2go-licence <a href="/license" target="_blank"> details </a>	 	      	      
			<br/><br/>
			
			<em>by-nc-sa</em>	
			<%if(license.getCcbyncsa()==1){%><aui:input name="license" value="ccbyncsa" checked="true" type="radio" /><%}%>
			<%if(license.getCcbyncsa()==0){%><aui:input name="license" value="ccbyncsa" type="radio"/><%}%>
			creative-commons <a href="http://creativecommons.org/licenses/by-nc-sa/3.0/" target="_blank"> details </a>
			<br/><br/>
			
			<aui:field-wrapper label="description">
			    <liferay-ui:input-editor name="longDesc" toolbarSet="liferay-article" initMethod="initEditor" width="250" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(mDescription) %>"; }
			    </script>
			</aui:field-wrapper>
			
			<aui:button-row>
				<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
				<aui:button type="cancel" value="cancel" onClick="<%=cancelURL.toString()%>" />
				<%if (vId>0) {%>
					<liferay-ui:icon-menu cssClass="right">
						<liferay-ui:icon image="delete" message="Remove" url="<%=removeURL.toString()%>" />
					</liferay-ui:icon-menu>
				<%}%>
			</aui:button-row>
		</aui:layout>
	</aui:fieldset>
</aui:form>

<script>

AUI().use('aui-node',
	function(A) {
	}
);
</script>