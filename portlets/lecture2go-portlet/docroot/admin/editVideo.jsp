<%@include file="/init.jsp"%>

<jsp:useBean id="reqLectureseriesList" type="java.util.List<de.uhh.l2g.plugins.model.Lectureseries>" scope="request" />
<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="reqLicenseList" type="java.util.List<de.uhh.l2g.plugins.model.License>" scope="request" />
<jsp:useBean id="reqLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="video" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="reqSubInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />

<liferay-portlet:resourceURL id="updateMetadata" var="updateURL" />
<liferay-portlet:resourceURL id="updateDescription" var="updateDescriptionURL" />
<liferay-portlet:resourceURL id="updateVideoFileName" var="updateVideoFileNameURL" />
<liferay-portlet:resourceURL id="videoFileNameExists" var="videoFileNameExistsURL" />
<liferay-portlet:resourceURL id="deleteFile" var="deleteFileURL" />
<liferay-portlet:resourceURL id="isFirstUpload" var="isFirstUploadURL" />
<liferay-portlet:resourceURL id="defaultContainer" var="defaultContainerURL" />
<liferay-portlet:resourceURL id="updateCreators" var="updateCreatorsURL" />
<liferay-portlet:resourceURL id="updateSubInstitutions" var="updateSubInstitutionsURL" />
<liferay-portlet:resourceURL id="getJSONCreator" var="getJSONCreatorURL" />
<liferay-portlet:resourceURL id="getJSONAllCreators" var="getJSONAllCreatorsURL" />
<liferay-portlet:resourceURL id="updateupdateOpenAccessForLectureseries" var="updateupdateOpenAccessForLectureseriesURL" />
<liferay-portlet:resourceURL id="videoUpdateGenerationDate" var="videoUpdateGenerationDateURL" />
<liferay-portlet:resourceURL id="getGenerationDate" var="getGenerationDateURL" />
<liferay-portlet:resourceURL id="videoUpdateFirstTitle" var="videoUpdateFirstTitleURL" />
<liferay-portlet:resourceURL id="getFileName" var="getFileNameURL" />
<liferay-portlet:resourceURL id="getSecureFileName" var="getSecureFileNameURL" />
<liferay-portlet:resourceURL id="getShare" var="getShareURL" />
<liferay-portlet:resourceURL id="updateNumberOfProductions" var="updateNumberOfProductionsURL" />
<liferay-portlet:resourceURL id="updateThumbnail" var="updateThumbnailURL" />
<liferay-portlet:resourceURL id="getJSONVideo" var="getJSONVideoURL" />
<liferay-portlet:resourceURL id="convertVideo" var="convertVideoURL" />
<liferay-portlet:resourceURL id="getVideoConversionStatus" var="getVideoConversionStatusURL" />
<liferay-portlet:resourceURL id="updateHtaccess" var="updateHtaccessURL" />
<liferay-portlet:resourceURL id="handleVttUpload" var="handleVttUploadURL" />
<liferay-portlet:resourceURL id="updateAll" var="updateAllURL" />


<%
	String actionURL = "";
	
	Map<String,String> institutions = new LinkedHashMap<String, String>();
	if(permissionAdmin){
		institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
	}
	if(permissionCoordinator)institutions = InstitutionLocalServiceUtil.getByParentIdMap(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getInstitutionId());

	String[] languages = LanguageUtil.get(pageContext, "languages-for-select").split(",");
	String languageId="";

	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	String backURL = request.getAttribute("backURL").toString();
	List<Creator> creators = new ArrayList<Creator>();
	try{creators = CreatorLocalServiceUtil.getCreators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch (NullPointerException e){}
	JSONArray allCreatorsJSON = new JSONArray();
	for (Creator creator: creators) {
		JSONObject c = new JSONObject();
		try {
			c.put("id", creator.getCreatorId());
			c.put("value", creator.getFullName());
			c.put("label", creator.getFullName());
			allCreatorsJSON.put(c);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	List<Term> semesters = new ArrayList<Term>(); 
	try{semesters = TermLocalServiceUtil.getAllSemesters();}catch(Exception e){}
	List<Category> categories = new ArrayList<Category>();
	try{categories = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch(Exception e){}

	Map<String,String> subInstitutions = new LinkedHashMap<String, String>();
	subInstitutions = InstitutionLocalServiceUtil.getByParentIdMap(reqVideo.getRootInstitutionId());
	List<Institution> producersSubInstitutions = InstitutionLocalServiceUtil.getByParentId(reqProducer.getInstitutionId());
	ListIterator<Institution> itPSI = producersSubInstitutions.listIterator();
	//video upload path
	//is first upload:
	String uploadRepository="";

	Host host = new HostImpl();	
	host = HostLocalServiceUtil.getByHostId(reqVideo.getHostId());
	uploadRepository=PropsUtil.get("lecture2go.media.repository")+"/"+host.getServerRoot()+"/"+reqProducer.getIdNum();

	Map<Term, List<Lectureseries>> lectureseriesAsTreeList = new TreeMap<Term, List<Lectureseries>>();
	if(reqVideo.getVideoId()>0)lectureseriesAsTreeList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(1, (long) 0, (long) 0, reqVideo.getProducerId());
	else lectureseriesAsTreeList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(1, (long) 0, (long) 0, reqProducer.getProducerId());

%>

<script id="htmlTitle" type="text/x-tmpl">
    <%=reqVideo.getTitle()%>
</script>

<script type="text/javascript">
  $(function(){
	var vidtitle = $('#htmlTitle').text();
    if(isFirstUpload()==1 && getDateTime().length==0){
   	  	$("#date-time-form").fadeIn(1000);
    	$("#upload-form").hide();
    	$("#l2gdate").hide();
    	if(vidtitle.trim()>""){
    		$("#first-title").hide();
    		$("#date-time").show();
    	}else{
    		$("#date-time").hide();
    	}
    	$("#<portlet:namespace/>meta-ebene").hide();
    }else{
  	  $("#date-time-form").hide();
	  $("#upload-form").fadeIn(1000); 	
	  $("#<portlet:namespace/>lecture2go-date").val(getDateTime());
	  $("#<portlet:namespace/>meta-ebene").show();
	  //load the date and time to another div
	  loadDateTimepickerToTheMetadataSkeleton();
    }
    //
    $('#<portlet:namespace/>datetimepicker').datetimepicker({
    	format:'Y-m-d_H-i',
    	dayOfWeekStart : 1,
    	lang:'en',
    	startDate:	new Date(),
    	value: "<%=video.getGenerationDate().equals("") ? new Date() : video.getGenerationDate() %>",
    	maxDate: '+1970/01/30',
    	minDate: false,
    	step: 15
    });
    
	if (defaultContainer() == 'mp4') {
		activateThumbnailGeneration();
	}
  });

function loadDateTimepickerToTheMetadataSkeleton(){
	 $('#date-time').appendTo('#l2gdate');
     $('#date-time .button-holder').hide();//hide button because not used!
	 //change the lable
	 $('#date-time .control-label').text("<liferay-ui:message key='lecture2go-date'/>"); 	
}

function loadDateTimepickerToFirstTitle(){
	 $('#date-time').appendTo('#date-time-form');
	 $('#date-time').show();
     $('#date-time .button-holder').show();//hide button because not used!
	 //change the lable
	 $('#date-time .control-label').text("<liferay-ui:message key='select-date-time-bevor-upload'/>"); 	
}

function deactivateThumbnailGeneration() {
	$("#thumbnail-content-active").hide();
	$("#thumbnail-content-inactive").show();
}

function activateThumbnailGeneration() {
	$("#thumbnail-content-inactive").hide();
	$("#thumbnail-content-active").show();
}

</script>

<div class="noresponsive">
	<div id="upload">
		<label class="edit-video-lable"><liferay-ui:message key="upload"/><liferay-ui:icon-help message="upload-explanation"/></label>
		<div id="date-time-form">
			<aui:fieldset column="true">
				<aui:layout>
					<div id="first-title">
						<aui:input id="firsttitle" name="firsttitle" label="first-title" value="<%=reqVideo.getTitle()%>" />
						<aui:button-row>
							<aui:button id="apply-first-title" name="apply-first-title" value="apply-first-title" onClick="applyFirstTitle();"/>
						</aui:button-row>
					</div>
					<div id="date-time">
						<aui:input id="datetimepicker" name="datetimepicker" label="select-date-time-bevor-upload"/>
						<aui:button-row>
							<aui:button id="apply-date-time" name="apply-date-time" value="apply-date-time" onClick="applyDateTime();"/>
						</aui:button-row>
					</div>
				</aui:layout>
			</aui:fieldset>
		</div>
		<div id="upload-form">
			<aui:fieldset column="true">
				<aui:layout>
					<div>
						<input id="fileupload" type="file" name="files[]" data-url="/servlet-file-upload/upload" multiple/>
						<input type="hidden" id="l2gDateTime" value=""/>
						<br/>
						<div id="progress" class="progress">
					    	<div class="bar" style="width: 0%;"></div>
						</div>
						<c:if test='<%= PropsUtil.contains("lecture2go.videoprocessing.provider")%>'>
							<div id="postprocessing-info" style="margin-bottom: 20px;">
								<span class="conversion" data-video-id="<%=reqVideo.getVideoId()%>">
								</span>
									<c:if test="<%= permissionChecker.isOmniadmin() || reqProducer.getProducerId() == 21923 %>">
										<!-- the admin has a button to start postprocessing manually -->
										<aui:button type="button" id="start-postprocessing" value="Start Postprocessing"/>
									</c:if>
								</div>
						</c:if>
						<table id="uploaded-files" class="table"></table>
					</div>
				</aui:layout>
			</aui:fieldset>
		</div>
	</div>
	
	<aui:fieldset column="false" label="" id="meta-ebene" style="display:none;">
		<aui:layout>
			<aui:form action="<%=actionURL%>" commandName="model" name="metadata">
				<label class="edit-video-lable" id="edit-video-lable-1">
					<i id="l1" class="aui icon-chevron-down thumb"></i>
					<liferay-ui:message key="metadata"/>
				</label>
				<div id="metadata-upload">
					<aui:input id="stayhere" name="stayhere" label="" required="true" value="" type="hidden"/>
					
					<div id="titledefault"><aui:input id="title" name="title" label="title" required="true" value="<%=reqVideo.getTitle()%>" /></div>
					
					<div id="creators-custom">
						<aui:input id="creator" name="creator" label="creators-required" helpMessage="creator-explanation"/>
						<div id="creators"></div>
					</div>		
							
					<aui:select size="1" name="lectureseriesId" label="lecture-series" helpMessage="video-with-or-without-lectureseries" onChange="toggleLectureseries()">
						<aui:option value="0">-<liferay-ui:message key="without-lecture-series"/>-</aui:option>
						<%
						for(Map.Entry<Term, List<Lectureseries>> entry : lectureseriesAsTreeList.entrySet()) {%>
							<aui:option value='0' disabled="true">&#9472; <%=entry.getKey().getTermName()%> &#9472;</aui:option>
							<% for(Lectureseries l: entry.getValue()) {
									if(l.getLectureseriesId()==reqVideo.getLectureseriesId()){%>
										<aui:option value='<%=l.getLectureseriesId()%>' selected="true"><%=l.getName()%></aui:option>
									<%}else{%>
										<aui:option value='<%=l.getLectureseriesId()%>'><%=l.getName()%></aui:option>
									<%}	
								}
						 }
						 %>
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
									
						<aui:select id="termId" size="1" name="termId" label="term" required="true">
							<%for (int i = 0; i < semesters.size(); i++) {
								if (reqVideo.getTermId()==semesters.get(i).getTermId()) {%>
									<aui:option value='<%=semesters.get(i).getTermId()%>' selected="true"><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
								<%} else {%>
									<aui:option value='<%=semesters.get(i).getTermId()%>'><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
								<%}
							}%>
						</aui:select>
		
						<aui:select size="1" id="categoryId" name="categoryId" label="category" required="true">
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
		
					<aui:select size="1" name="language" label="language" required="true">
						<%for (int i=0; i<languages.length; i++){%>
								<aui:option value='<%=languages[i]%>' selected="<%=reqMetadata.getLanguage().contains(languages[i]) %>"><%=languages[i]%></aui:option>
						<%}%>				
					</aui:select>
					
					<div id="l2gdate"></div>
					
					<aui:input name="tags" label="tags" required="false" value="<%=reqVideo.getTags()%>"/>
		
					<aui:input name="publisher" label="publisher" required="false" value="<%=reqMetadata.getPublisher()%>"/>
					
					<aui:field-wrapper label="description">
					    <liferay-ui:input-editor  name="longDesc" toolbarSet="simple" initMethod="initEditor" onChangeMethod="setDescriptionData" cssClass="ta"/>
					    <script type="text/javascript">
					        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(reqMetadata.getDescription()) %>"; }
					    </script>
					</aui:field-wrapper>
				</div>
				<script>
					$( "#edit-video-lable-1" ).click(function() {
					  $( "#metadata-upload" ).slideToggle( "slow" );
					  $("#l1", this).toggleClass("thumb thumb-90");
					});
				</script>
				
				<div id="permissions">
					<label class="edit-video-lable" id="edit-video-lable-2">
						<i id="l2" class="aui icon-chevron-down thumb"></i>
						<liferay-ui:message key="permissions"/>
					</label>
					<div id="permissions-content">
						<%if(reqVideo.getOpenAccess()==0){%>
							<div>
								<aui:input id="password" name="password" label="password" required="false" value="<%=reqVideo.getPassword()%>" />
							</div>
						<%}else{%>
							<aui:input name="password" id="password" type="hidden" value="<%=reqVideo.getPassword()%>"/>
						<%}%>
						<div id="c2g">
							<%if(reqVideo.getCitation2go()==0){%>
						  		<aui:input name="citationAllowed" type="checkbox" label="citation-allowed" id="citationAllowed"></aui:input>
						   	<%}else{%>
							  <aui:input name="citationAllowed" type="checkbox" label="citation-allowed" id="citationAllowed" checked="true"></aui:input>
						    <%}%>
						</div>
					</div>
				</div>
				<script>
					$( "#edit-video-lable-2" ).click(function() {
					  $( "#permissions-content" ).slideToggle( "slow" );
					  $("#l2", this).toggleClass("thumb thumb-90");
					});
				</script>
				
				<div id="license">
					<label class="edit-video-lable" id="edit-video-lable-3">
						<i id="l3" class="aui icon-chevron-down thumb"></i>
						<liferay-ui:message key="license"/>
					</label>
					<div id="license-content">
						<c:forEach items="<%=reqLicenseList %>" var="license">
							<c:choose>
								<c:when test="${license.selectable}" >
								<div>
									<aui:input name="license" label="" value="${license.licenseId}" checked="${license.licenseId == reqLicense.licenseId ? 'true' : 'false'}" type="radio"/>
									<a href="${license.url}" title="${license.fullName}" target="_blank">${license.shortIdentifier} </a>	 	      
								</div>
								</c:when>
							    <c:otherwise>
							    	<!-- previously chosen but not selectable any more -->
							    	<c:if test="${license.licenseId == reqLicense.licenseId}">
							    		<div>
							    			<aui:input name="license" label="" value="${license.licenseId}" checked="true" type="radio" disabled="true"/>
											<a href="${license.url}" class="disabled" title="${license.fullName}" target="_blank">${license.shortIdentifier} </a>	
							    		</div>
							    	</c:if>
								</c:otherwise>
							</c:choose>	
						</c:forEach>
					</div>
				</div>
				<script>
					$( "#edit-video-lable-3" ).click(function() {
					  $( "#license-content" ).slideToggle( "slow" );
					  $("#l3", this).toggleClass("thumb thumb-90");
					});
				</script>

				<div id="embed">
					<label class="edit-video-lable" id="edit-video-lable-4">
						<i id="l4" class="aui icon-chevron-down thumb"></i>
						<liferay-ui:message key="share"/>
					</label>
					<div id="embed-content">
						<!-- embed start -->
						<%
							String vurl = "";	
							if(reqVideo.getOpenAccess()==1) vurl=reqVideo.getUrl();
							else vurl=reqVideo.getSecureUrl();
						%>
						<aui:input name="embed_code3" label="video-url" helpMessage="about-video-url" required="false" id="embed_code3" readonly="true" value="<%=vurl%>" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code3.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code3.select();"/>
						<aui:input name="embed_code" label="embed-iframe" helpMessage="about-iframe-embed" required="false" id="embed_code" readonly="true" value="<%=reqVideo.getEmbedIframe()%>" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code.select();"/>
						<%if(reqVideo.getDownloadLink()==1){%>
							<aui:input name="embed_code1" label="embed-html5" helpMessage="about-html5-embed" required="false" id="embed_code1" readonly="true" value="<%=reqVideo.getEmbedHtml5()%>" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code1.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code1.select();"/>							
						<%}%>
						<aui:input name="embed_code4" label="embed-commsy" helpMessage="about-commsy-embed" required="false" id="embed_code4" readonly="true" value="<%=reqVideo.getEmbedCommsy()%>" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code4.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code4.select();"/>
						<!-- embed end -->	      	      
					</div>
				</div>
				<script>
					$( "#edit-video-lable-4" ).click(function() {
					  $( "#embed-content" ).slideToggle( "slow" );
					  $("#l4", this).toggleClass("thumb thumb-90");
					});
				</script>

			<c:if test='<%= PropsUtil.contains("lecture2go.videoprocessing.provider")%>'>
				<div id="postprocessing">
					<label class="edit-video-lable" id="edit-video-lable-6">
						<i id="l6" class="aui icon-chevron-down thumb-90"></i>
						<liferay-ui:message key="include-video-caption"/>
						<liferay-ui:icon-help message="include-video-caption-description"/>
					</label>
	
					<div id="postprocessing-content" >
						<div id="include-video-caption">
							<div id="include-video-caption-content">								
								<!-- layout select radio buttons -->
								<div>
									<aui:input name="video-caption-layout" id="speakerleft" label="speaker-left" value="1" checked="true" type="radio" required="false" helpMessage="video-caption-speaker-left-explanation"/>
									<aui:input name="video-caption-layout" id="speakerright" label="speaker-right" value="2" checked="" type="radio" required="false" helpMessage="video-caption-speaker-right-explanation"/>
									<aui:input name="video-caption-layout" id="speakeronly" label="speaker-only" value="3" checked="" type="radio" required="false" helpMessage="video-caption-speaker-only-explanation"/>
								</div>
								<div style="clear: both">
									<img id="video-caption-previewimage-speakerslides" src=""/>
									<img id="video-caption-previewimage-speakeronly" src=""/>
								</div>
	
								<label style="clear:both;" id="edit-video-lable-7">
									<i id="l7" class="aui icon-chevron-down thumb-90"></i>
									<liferay-ui:message key="additional-video-caption-fields"/>
									<liferay-ui:icon-help message="additional-video-caption-fields-explanation"/>
								</label>
								<div id="include-video-caption-content-additional">
									<aui:input name="video-caption-title" label="title" required="false" value=""/>
									<aui:input name="video-caption-creators" label="creators" required="false" value=""/>
									<aui:input name="video-caption-institution" label="institution-of-creator" required="false" value=""/>
									<aui:input name="video-caption-date" label="date" required="false" value=""/>
									<aui:input name="video-caption-lectureseries" label="lectureseries" required="false" value=""/>
								</div>
								<div id="start-video-caption-postprocessing-area">
									<aui:button type="button" id="start-video-caption-postprocessing" value="include-video-caption" disabled="true"/>
									<liferay-ui:icon-help message="start-video-caption-postprocessing-disabled-explanation"/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>

				<div id="video-thumbnail">
					<label class="edit-video-lable" id="edit-video-lable-5">
						<i id="l5" class="aui icon-chevron-down thumb-90"></i>
						<liferay-ui:message key="video-thumbnail" />
					</label>
					
					<div id="thumbnail-content">
						<!-- thumbnail start --> 
						<div id="thumbnail-content-active" style="display:none;">
							<liferay-ui:message key="video-thumbnail-about"/>
							<%@include file="/player/includePlayerForThumbnail.jsp"%>
						</div>
						<div id="thumbnail-content-inactive">
							<liferay-ui:message key="video-thumbnail-not-available"/>
						</div>
						<!-- thumbnail end -->	      	      
					</div>
				</div>
				<script>
					$(function(){$( "#thumbnail-content" ).hide();});
					$( "#edit-video-lable-5" ).click(function() {
					  $( "#thumbnail-content" ).slideToggle( "slow" );
					  $("#l5", this).toggleClass("thumb-90 thumb");
					});
				</script>
				<br/>		
				<aui:button-row>
					<aui:button type="submit" value="apply-changes" onclick="updateAllMetadata();" cssClass="btn-primary"/>
					<aui:button type="cancel" value="back" name="cancel"/>
				</aui:button-row>
				
				<aui:input name="videoId" type="hidden" value="<%=reqVideo.getVideoId()%>"/>
			</aui:form>
		</aui:layout>
	</aui:fieldset>
</div>


<script id="htmlTemplate" type="text/x-tmpl">
    <%=reqMetadata.getDescription()%>
</script>

<script>
	var descData=$('#htmlTemplate').text();
	function <portlet:namespace/>setDescriptionData(data){
		descData = data;
	}
</script>

<script type="text/javascript">

var $options = $( "#options" );
var c = 0;

/* these variables are set here but used in the external autocomplete-creator.js file, be sure to include this js AFTER the jsp is rendered*/
var allCreatorsInJQueryAutocompleteFormat = <%= allCreatorsJSON.toString()%>;
var getJSONCreatorURL = "<%=getJSONCreatorURL%>";
var getJSONAllCreatorsURL = "<%=getJSONAllCreatorsURL%>";
var namespace = "<portlet:namespace/>";
<%
String assignedCreators ="";
try{
	assignedCreators = CreatorLocalServiceUtil.getJSONCreatorsByVideoId(reqVideo.getVideoId()).toString();
}catch(Exception e){}
%>
var assignedCreators = <%=assignedCreators%>;

var $options = $( "#options" );

$(function () {
	var lsId = <%=reqLectureseries.getLectureseriesId()%>;
	if(lsId>0){
		$options.hide();
	}
	
	autocompleteCreator($("#<portlet:namespace/>creator"), validate, typeof newCreatorHandler == "undefined" ? null : newCreatorHandler);
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
	toggleShare();
	
	$('#fileupload').fileupload({
        dataType: 'json',
        beforeSend: function(xhr, data) {
        	// send a custom header to notify the upload servlet where to put the temporary files upon upload
            xhr.setRequestHeader('X-tempdir', "<%=uploadRepository%>");
        },
        add: function(e, data) {
            var uploadErrors = [];
			var acceptFileTypes = /(mp4|m4v|m4a|audio\/mp3|audio\/mpeg|audio|pdf|vtt)$/i;//file types
			
			for(i=0;i<data.originalFiles.length; i++){
	            if (data.originalFiles[i]['type'].length && !acceptFileTypes.test(data.originalFiles[i]['type'])) {
	                uploadErrors.push('<liferay-ui:message key="not-an-accepted-file-type"/>');
	            }
	            //
	            //if ( data.originalFiles[i]['size'] > 5368709120) { //5 GB
	            //    uploadErrors.push('<liferay-ui:message key="max-file-size"/>');
	            //}
			}

          	//check for first upload
        	if (isFirstUpload()==1) {
        		if (!fileUploadAllowed(data.originalFiles)){
        			uploadErrors.push('<liferay-ui:message key="first-upload-requirements"/>');   
        		} else {
        			if(videoFileNameExistsInDatabase(data.originalFiles[0]['name'])==1) uploadErrors.push('<liferay-ui:message key="file-exists-in-database"/>');  
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
           		//mp4 file
           		if(f3.indexOf(f1) > -1){
	           		updateVideoFileName(vars[0]);
	           		validate();
           		}
           		//mp3 file, do not trigger the post processing
           		if(f3.indexOf(f2) > -1){
	           		updateVideoFileName(vars[0]);
	           		validate();
           		}
           }else{
				//update only for mp3 and mp4, but without changing the container
				var f1 = vars[0].fileName;
				var f2 = defaultContainer();
				var f3 = "mp4";
				//for mp3 and mp4 files
				if(f1.indexOf(f2) > -1 || f1.indexOf(f3) > -1){
	           		updateVideoFileName(vars[0]);
	           		validate();
				}
           }
           
           // handle subtitle file if existing
           handleVttUpload();
           
           //htaccess update function for physical file protectiom
           updateHtaccess();
       	   var st = false;
           
       	   jwplayer().remove();
           //initialize and show player
            setTimeout(
	           function(){
	        	   initializePlayer();
	        	   jwplayer().seek(0);
	        	   jwplayer().on('play',function(){
	            		  if(st==false){
	            			  jwplayer().pause();
	            			   st=true;
	            		  }
	     		   });	        	   
	           }, 2000
           );
           
       	   
        },
        progressall: function (e, data) {
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        if (progress==100){
	        	setTimeout(function(){$('#progress .bar').css('width',0 + '%')}, 2000);
	        }else{
		        $('#progress .bar').css('width',progress + '%');
		        if($('#<portlet:namespace></portlet:namespace>cancel').is(":visible")){
		        	$('#<portlet:namespace></portlet:namespace>cancel').hide();	
		        }
	        }
   		},
		dropZone: $('#dropzone')
    }).bind('fileuploadsubmit', function (e, data) {
        // The example input, doesn't have to be part of the upload form:
        	var fileName = getDBFilename();
        	var secureFileName = getSecureFilename();
        	data.formData = {
        		//p.setHomeDir(PropsUtil.get("lecture2go.media.repository")+"/"+HostLocalServiceUtil.getByHostId(p.getHostId()).getServerRoot()+"/"+p.getHomeDir());
        	    repository: "<%=uploadRepository%>",
        		openaccess: "<%=reqVideo.getOpenAccess()%>",
        		lectureseriesNumber: "<%=reqLectureseries.getNumber()%>",
        		fileName: fileName,
        		secureFileName: secureFileName,
        		l2gDateTime: $("#<portlet:namespace></portlet:namespace>datetimepicker").val(),
        		videoId: "<%=reqVideo.getVideoId()%>"
        };        
    });
   
});

function updateNumberOfProductions(){
	var ret="";
	$.ajax({
		  type: "POST",
		  url: "<%=updateNumberOfProductionsURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data.containerFormat;
		  }
	});
	return ret;	
}

function fileUploadAllowed(data){
	var ret = false;
    var acceptFileTypes = /(mp4|audio\/mp3|audio\/mpeg|audio)$/i;//allowed file types
    data.forEach(function(entry) {
    	if(acceptFileTypes.test(entry['type'])){
        	ret = true;
        }
    });
    return ret;
}

function defaultContainer(){
	var ret="";
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
	});
	return ret;
}

function isFirstUpload(){
	var ret = 0;
	$.ajax({
		  type: "POST",
		  url: "<%=isFirstUploadURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data.firstUpload;
		  }
	});
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
	});
	return ret;
}

function updateHtaccess (){
	var ret = 0;
	$.ajax({
		  type: "POST",
		  url: "<%=updateHtaccessURL%>",
		  dataType: 'json',
		  data: {
			  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
		  },
		  global: false,
		  async: false,
		  success: function(data) {
		    ret = 1;
		  }
	});
	return ret;
}

function handleVttUpload (){
	var ret = 0;
	$.ajax({
		  type: "POST",
		  url: "<%=handleVttUploadURL%>",
		  dataType: 'json',
		  data: {
			  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
		  },
		  global: false,
		  async: false,
		  success: function(data) {
		    ret = 1;
		  }
	});
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
				 	   	<portlet:namespace/>generationDate: file.generationDate
			 	},
			 	//get server response
				on: {
					   success: function() {
					     var jsonResponse = this.get('responseData');
					     
					     var fileExtension = file.name.split('.').pop();
						 if (fileExtension == "mp4" || file.type == "video/mp4") {
							 activateThumbnailGeneration();
						 }
					     
						 <c:if test='<%= PropsUtil.contains("lecture2go.videoprocessing.provider") %>'>
						 	// do not try to convert mp3s, this won't work
						 	if (!(fileExtension == "mp3" || file.type == "audio/mp3")) {
						     	videoProcessor.convert('<portlet:namespace/>','<%=convertVideoURL%>','<%=getVideoConversionStatusURL%>',<%=reqVideo.getVideoId()%>);
								// enable the button for video caption postprocessing
								$("#start-video-caption-postprocessing").removeAttr("disabled");
								$("#start-video-caption-postprocessing").removeClass("disabled");
								
								$("#start-video-caption-postprocessing-area > .taglib-icon-help").hide();
						 	}
						</c:if>

					     toggleShare();
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
				 	    <portlet:namespace/>description: descData,
				 	    <portlet:namespace/>licenseId: A.one("input[name=<portlet:namespace/>license]:checked").get("value")
			 	},
			 	async:true,
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

function updateAllMetadata(){
	validate();//inpul correct?
	var license = $("input[name=<portlet:namespace/>license]:checked").val();
	var creatorsJsonArray = JSON.stringify(getJsonCreatorsArray());
	var jsonSubInstitutionsArray = JSON.stringify(getJsonSubInstitutionsArray());
	var termId=0;
	var categoryId=0;
	var chebox;
	//
	$('#<portlet:namespace/>citationAllowedCheckbox').prop("checked") ? chebox=1 : chebox=0;
	
	if (!$("#options").is(':hidden')) {
		   termId = $('#<portlet:namespace/>termId').val();
		   categoryId = $('#<portlet:namespace/>categoryId').val();
	}
	if($("#<portlet:namespace/>title").val() && $("#creators > div").length>0){
		//action
		$.ajax({
			url: "${updateAllURL}",
			method: "POST",
			dataType: "json",
			data: {
					//metadata start
					"<portlet:namespace/>videoId": "<%=reqVideo.getVideoId()%>",
	            	"<portlet:namespace/>description": descData,
	            	"<portlet:namespace/>license": license,
	            	"<portlet:namespace/>creatorsJsonArray": creatorsJsonArray,  
	            	"<portlet:namespace/>subInstitutions": jsonSubInstitutionsArray,
			 	   	"<portlet:namespace/>lectureseriesId": $('#<portlet:namespace/>lectureseriesId').val(),
			 	   	"<portlet:namespace/>language": $('#<portlet:namespace/>language').val(),
			 	   	"<portlet:namespace/>title": $('#<portlet:namespace/>title').val(),
			 	   	"<portlet:namespace/>tags": $('#<portlet:namespace/>tags').val(),
			 	   	"<portlet:namespace/>publisher": $('#<portlet:namespace/>publisher').val(),
			 	   	"<portlet:namespace/>datetimepicker": $('#<portlet:namespace/>datetimepicker').val(),
			 	   	"<portlet:namespace/>citationAllowedCheckbox": chebox,
			 	   	"<portlet:namespace/>categoryId": categoryId,
			 	   	"<portlet:namespace/>termId": termId,
			 	   	"<portlet:namespace/>password": $('#<portlet:namespace/>password').val()
			 	   	//metadata end
	 		},
			success: function(res) {
				 // required creator field color needs to be set manually 
				 $("#creators-custom .control-group").removeClass("error").addClass("success");
	           	 //update the thumb nail
	           	 updateThumbnail();

				 // reload the creators list
	           	 $( "#creators" ).empty();
	           	 showCreatorsList(getJSONAllCreators(<%=reqVideo.getVideoId()%>));

	           	 //json object
	           	 if(res.errorsCount==0){
	           		 alert("<liferay-ui:message key='changes-applied'/>");	                		 
	           	 }else{
	           		 alert("<liferay-ui:message key='changes-applied-with-warnings'/>");
	           	 }
			}
		});
	}
} 

function applyAllMetadataChanges(){
	AUI().use(
			'aui-node',
			function(A) {
				validate();//inpul correct?
				if($("#<portlet:namespace/>title").val() && $("#creators > div").length>0){
				    //updateDescription(descData);
				    updateCreators();
				    updateMetadata();//last place, important!
				 	// required creator field color needs to be set manually 
				 	$("#creators-custom .control-group").removeClass("error").addClass("success");
					updateThumbnail();
				    alert("<liferay-ui:message key='changes-applied'/>");					
				}
			}
	);
}


function validate(){
	AUI().use(
			'aui-node',
			function(A) {
				if($("#creators > div").length==0){
				    // required creator field color needs to be set manually 
				 	$("#creators-custom .control-group").removeClass("success").addClass("error");

					$('html, body').animate({
		                   scrollTop: $("#creators-custom").offset().top
		               }, 1000);
			        if($('#<portlet:namespace></portlet:namespace>cancel').is(":visible")){
			        	$('#<portlet:namespace></portlet:namespace>cancel').hide();	
			        }	
					//alert("<liferay-ui:message key='please-add-creators'/>");
				}else{
					// required creator field color needs to be set manually 
					$("#creators-custom .control-group").removeClass("error").addClass("success");
					$('#<portlet:namespace></portlet:namespace>cancel').show();
				}
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
				 	    <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			 	},
			 	async:true,
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
		    	  	$("#date-time").hide();
		    	  	$("#first-title").show();
		    	  	$("#<portlet:namespace/>meta-ebene").hide();
		    	  	$(".conversion").html('');
		    	  	deactivateThumbnailGeneration();
		        }
		        jwplayer().remove();
		        //initialize and show player
			    initializePlayer();
		        //hide date fild
		        $("#l2gdate").hide();
		        //toggle share
		        toggleShare();
		    }
		});	
	}
}

function updateCreatorOnServer(jsonArray) {
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
		  async: true,
		  success: function(data) {
		    //remove all creators 
		    $( "#creators" ).empty();
		    //and show new creators list
		    showCreatorsList(data);    
		  }
	});
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
				  if(!data.generationDate){
					  alert('<liferay-ui:message key="please-enter-a-date"/>');
				  }else{
					  $('#date-time-form').hide();
					  $("#upload-form").fadeIn(500); 	
					  $("#tm").text(getDateTime());
					  loadDateTimepickerToTheMetadataSkeleton();
					  $("#l2gdate").fadeIn(1000);
					  $("#<portlet:namespace/>meta-ebene").show();
					  <c:if test='<%= PropsUtil.contains("lecture2go.videoprocessing.provider")%>'>
						initializeCaptionGeneration();
					  </c:if>
				  }
			  }
	  });
}

function applyFirstTitle(){
	  var title = $('#<portlet:namespace/>firsttitle').val();
	  //
	  $.ajax({
			  type: "POST",
			  url: "<%=videoUpdateFirstTitleURL%>",
			  dataType: 'json',
			  data: {
				  <portlet:namespace/>firsttitle: title,
			 	  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			  },
			  global: false,
			  async:false,
			  success: function(data) {
				  if(!data.firsttitle){
					  alert('<liferay-ui:message key="please-enter-a-title"/>');
				  }else{
					  $('#first-title').hide();
					  loadDateTimepickerToFirstTitle();
					  $("#<portlet:namespace/>title").val(data.firsttitle);
				  }
			  }
	  });
}

function getDBFilename(){
	var ret ="";
	  //
	  $.ajax({
			  type: "POST",
			  url: "<%=getFileNameURL%>",
			  dataType: 'json',
			  data: {
			 	  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			  },
			  global: false,
			  async:false,
			  success: function(data) {
				 ret=data.fileName; 
			  }
	  });
	  return ret;
}

function getSecureFilename(){
	var ret ="";
	  //
	  $.ajax({
			  type: "POST",
			  url: "<%=getSecureFileNameURL%>",
			  dataType: 'json',
			  data: {
			 	  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			  },
			  global: false,
			  async:false,
			  success: function(data) {
				 ret=data.secureFileName; 
			  }
	  });
	  return ret;
}

function getShare(){
	  var ret;
	  //
	  $.ajax({
			  type: "POST",
			  url: "<%=getShareURL%>",
			  dataType: 'json',
			  data: {
			 	  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			  },
			  global: false,
			  async:false,
			  success: function(data) {
				 ret=data; 
			  }
	  });
	  return ret;
}

function toggleShare(){
	var mediaFilename = getDBFilename();
	var data = getShare();
	if(mediaFilename.length>0){
		 $("#embed").show();
		  $("#<portlet:namespace/>embed_code").val(data.iframeEmbed);//iframe
		  $("#<portlet:namespace/>embed_code1").val(data.html5Embed);//html5
		  $("#<portlet:namespace/>embed_code3").val(data.url);//url
		  $("#<portlet:namespace/>embed_code4").val(data.commsyEmbed);//commsy
	}else{
		 $("#embed").hide();
	}
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

function getJsonSubInstitutionsArray(){
	var namespace="<portlet:namespace/>";
	var jsonArray = [];
	$('.subInstitutions').children().each(function(n){
		var parameters = {};
		var $div = $(this);
		var id = $div.attr('id');
		parameters['institutionId'] = id;
		jsonArray[n]=parameters;
	});
	return jsonArray;
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
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
		  },
		  global: false,
		  async:true,
		  success: function(data) {
		    //		    
		  }
	});
}

function updateThumbnail(){
	//set parameter to server for update 
	$.ajax({
		  type: "POST",
		  url: "<%=updateThumbnailURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>inputTime: Math.floor(jwplayer().getPosition()),
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		  },
		  global: false,
		  async:true,
		  success: function(data) {
		  }
	});
}

var c = 0;


function remb(c){
	$("#"+c).remove();
	validate();
	<c:if test='<%= PropsUtil.contains("lecture2go.videoprocessing.provider")%>'>
		synchronizeAuthors();
	</c:if>
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

<c:if test='<%= PropsUtil.contains("lecture2go.videoprocessing.provider")%>'>

	/* ### POSTPROCESSING SPECIFIC ##### */
	 
	function newCreatorHandler() {
			synchronizeAuthors();
			refreshVideoCaptionPreviewImage();
	}
	
	$(function(){$( "#postprocessing-content" ).hide();});
	$( "#edit-video-lable-6" ).click(function() {
	 	$( "#postprocessing-content" ).slideToggle( "slow" );
	 	$("#l6", this).toggleClass("thumb thumb-90");
	});
	
	$(function(){$("#include-video-caption-content-additional").hide();});
	$( "#edit-video-lable-7" ).click(function() {
	 	$( "#include-video-caption-content-additional" ).slideToggle( "slow" );
	 	$("#l7", this).toggleClass("thumb thumb-90");
	});
	
	
	AUI().ready('', function(A){
		// synchronize the video-caption form to the metadata form on page load
		synchronizeTitleFields();
		synchronizeLectureSeriesFields();
		synchronizeDateFields();
		synchronizeAuthors();
	
		// load the video caption image on page load
		refreshVideoCaptionPreviewImage();
	
		// enable the button for video caption postprocessing, if there is already a mp4 file
		if (defaultContainer() == 'mp4') {
			// enable button
			$("#start-video-caption-postprocessing").removeAttr("disabled");
			$("#start-video-caption-postprocessing").removeClass("disabled");
			// hide disabled help text
			$("#start-video-caption-postprocessing-area > .taglib-icon-help").hide();
		}
	
		// change video caption if video data set is changed
		// title
		$("#<portlet:namespace/>title").keyup(function(){
			synchronizeTitleFields();
			refreshVideoCaptionPreviewImage();
		});
		
		$('#<portlet:namespace/>creator').focusout(function() {
			synchronizeAuthors();
			refreshVideoCaptionPreviewImage();
		});
		
		// lectureseries
		$("#<portlet:namespace/>lectureseriesId").change(function(){
			synchronizeLectureSeriesFields();
			refreshVideoCaptionPreviewImage();
		});
		// date
		$("#<portlet:namespace/>datetimepicker.field").change(function(){
			synchronizeDateFields();
			refreshVideoCaptionPreviewImage();
		});
	
		// change video caption if video caption specific fields are changed
		// layout
		$("input[type=radio][name=<portlet:namespace/>video-caption-layout]").change(function(){
			refreshVideoCaptionPreviewImage();
		});
		// every input field
		$("#include-video-caption-content input").keyup(function(){
			refreshVideoCaptionPreviewImage();
		});
	
		// the default postprocessing button
		$('#start-postprocessing').click(function(){
			videoProcessor.convert('<portlet:namespace/>','<%=convertVideoURL%>', '<%=getVideoConversionStatusURL%>', <%=reqVideo.getVideoId()%>);
		});
	
		// the video-caption-postprocessing button (additional properties are used)
		$('#start-video-caption-postprocessing').click(function(){
			additionalProperties = {
				"captionPosition": $('input[name=<portlet:namespace/>video-caption-layout]:checked').val(), 
				"captionLink": $("<div>").text(getVideoCaptionUrl()).html()
			}
			videoProcessor.convert('<portlet:namespace/>','<%=convertVideoURL%>', '<%=getVideoConversionStatusURL%>', <%=reqVideo.getVideoId()%>, "l2go-composite-adaptive-publish", JSON.stringify(additionalProperties));
			
			// close the postprocessing area
			$( "#postprocessing-content" ).slideToggle( "slow" );
	 		$("#l6").toggleClass("thumb thumb-90");
			// scroll to top to see conversion status
			$("html, body").animate({ scrollTop: 0 }, "slow");
		});
	});

	AUI().ready('', function(A){
		// check conversion status
		videoProcessor.pollStatus('<portlet:namespace/>','<%=getVideoConversionStatusURL%>','<%=convertVideoURL%>',<%=reqVideo.getVideoId()%>);
	});

	function initializeCaptionGeneration() {
		// synchronize the video-caption form to the metadata form 
		synchronizeTitleFields();
		synchronizeLectureSeriesFields();
		synchronizeDateFields();
		synchronizeAuthors();
	}

	
	function synchronizeTitleFields() {
		$("#<portlet:namespace/>video-caption-title").val($("#<portlet:namespace/>title").val());
	}

	function synchronizeLectureSeriesFields() {
		// only paste lectureseries name if a lectureseries is selected (not "without lectureseries")
		if ($("#<portlet:namespace/>lectureseriesId").val() == 0) {
			$("#<portlet:namespace/>video-caption-lectureseries").val("");
		} else {
			$("#<portlet:namespace/>video-caption-lectureseries").val($("#<portlet:namespace/>lectureseriesId option:selected").text().trim());
		}
	}

	function synchronizeDateFields() {
		var date = $("#<portlet:namespace/>datetimepicker.field").val();
		var year = date.slice(0,4);
		var month = date.slice(5,7);
		var day = date.slice(8,10);
		var renderDate = day + "." + month + "." + year;
		$("#<portlet:namespace/>video-caption-date").val(renderDate);

		refreshVideoCaptionPreviewImage();
	}

	function synchronizeAuthors() {
		var authorArray = [];
		// creators which are already in the database are handled (id starts with "c")
		$("#creators").children("[id^='c']").each(function() { 
			authorArray.push($(this).text().trim());
		});
		// creators which are just added are handled (id starts with "nc")
		$("#creators").children("[id^='nc']").each(function() { 
			// build the name manually
			var name = [
				$(this).find("#<portlet:namespace/>jobTitle").val(),
				$(this).find("#<portlet:namespace/>firstName").val(),
				$(this).find("#<portlet:namespace/>middleName").val(),
				$(this).find("#<portlet:namespace/>lastName").val()
				].join(" ");

			authorArray.push(name);
		});
		
		var authorsAsString = authorArray.join(", ");
		$("#<portlet:namespace/>video-caption-creators").val(authorsAsString);
		synchronizeAffiliations();
		refreshVideoCaptionPreviewImage();
	}
	

	function synchronizeAffiliations() {
		var affiliationArray = [];
		var jsonCreatorArray = getJsonCreatorsArray();
		for (var key in jsonCreatorArray) {
			if (jsonCreatorArray[key].affiliation != "") {
				affiliationArray.push(jsonCreatorArray[key].affiliation);
			}
		}
		var affiliationsAsString = affiliationArray.join(", ");
		$("#<portlet:namespace/>video-caption-institution").val(affiliationsAsString);
	}

	function getVideoCaptionUrl() {
		// create url to imagebuilder 
		var title = $("#<portlet:namespace/>video-caption-title").val();
		var creators = $("#<portlet:namespace/>video-caption-creators").val();
		var institution = $("#<portlet:namespace/>video-caption-institution").val();
		
		//ugly way to transform date (js does not have a native date format function)
		var date = $("#<portlet:namespace/>video-caption-date").val();

		var lectureseries = $("#<portlet:namespace/>video-caption-lectureseries").val();
		var layout = $('input[name=<portlet:namespace/>video-caption-layout]:checked').val();
		if (layout == 1 || layout == 2) {
			layoutname = "speakerslides";
		} else if (layout == 3) {
			layoutname = "speakeronly";
		}

		var imageUrl = encodeURI("https://lecture2go.uni-hamburg.de/imagebuilder/l2goimage?author=" + creators +"&institution=" + institution + "&title=" + title + "&date=" + date + "&series=" + lectureseries + "&type=" + layoutname + "&downscale=false");
		return imageUrl;
	}

	function refreshVideoCaptionPreviewImage() {
		var imageUrl = getVideoCaptionUrl();

		if (layoutname == "speakerslides") {
			$("#video-caption-previewimage-speakeronly").attr({src: ""});
			$("#video-caption-previewimage-speakerslides").attr({src: imageUrl});
		} else {
			$("#video-caption-previewimage-speakerslides").attr({src: ""});
			$("#video-caption-previewimage-speakeronly").attr({src: imageUrl});
		}
	}

</c:if>



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
    	$('#<portlet:namespace></portlet:namespace>cancel').click(function(){
    		   window.location.href="<%=backURL.toString()%>";
    	})
    	var vars = <%=VideoLocalServiceUtil.getJSONVideo(reqVideo.getVideoId()).toString()%>;
        console.log(vars);
        $.template( "filesTemplate", $("#template") );
        $.tmpl( "filesTemplate", vars ).appendTo( ".table" );
    });
</script>


<%@include file="includeCreatorTemplates.jsp" %>