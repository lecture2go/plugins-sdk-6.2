<%@include file="/init.jsp"%>

<jsp:useBean id="video" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="relatedVideos" type="java.util.List<de.uhh.l2g.plugins.model.Video>" scope="request" />
<jsp:useBean id="segments" type="java.util.List<de.uhh.l2g.plugins.model.Segment>" scope="request" />
<jsp:useBean id="videoLectureseries" type="java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries>" scope="request" />
<jsp:useBean id="videoInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />
<jsp:useBean id="videoMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="lectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="videoLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="objectType" type="java.lang.String" scope="request" />
<jsp:useBean id="objectId" type="java.lang.String" scope="request" />

<jsp:useBean id="timeStart" type="java.lang.Long" scope="request" />
<jsp:useBean id="timeEnd" type="java.lang.Long" scope="request" />

<portlet:actionURL var="backURL0" name="addFilter">
	<portlet:param name="jspPage" value="/guest/videosList.jsp" />
	<portlet:param name="parentInstitutionId" value="0"/>
	<portlet:param name="institutionId" value="0"/>
	<portlet:param name="termId" value="0"/>
	<portlet:param name="categoryId" value="0"/>
	<portlet:param name="creatorId" value="0"/>
</portlet:actionURL>

<%
String tags= video.getTags().length()>0 ? " - "+video.getTags()+" - " : "";
String pageTitle=video.getTitle() +" - "+lectureseries.getName()+" - "+CreatorLocalServiceUtil.getCommaSeparatedCreatorsByVideoIdAndMaxCreators(video.getVideoId(), 200) + " - Universität Hamburg" + tags;
PortalUtil.setPageTitle(pageTitle, request);

String companyName = company.getName();
String portalURL = PrefsPropsUtil.getString(company.getCompanyId(),PropsKeys.DEFAULT_LANDING_PAGE_PATH);

boolean isCitation2Go = false;
if(timeStart>0 && timeEnd>timeStart && video.getCitation2go()==1)isCitation2Go=true;

String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>

<%if(video.getVideoId()>0){%>
	<%if(video.getAccessPermitted()==1){%>
		<%if(video.getOpenAccess()==1 || video.getOpenAccess()==0){%>
			<div class="col-xs-10 col-md-10">
				<c:if test="${relatedVideos.size()>1}"> <div class="path"></c:if>
			    <c:if test="${relatedVideos.size()<=1}"> <div class="path-wide"></c:if>
			    	<%
			    	if(video.getLectureseriesId()>0){
				    	for(int i=0; i<videoLectureseries.size(); i++){
				    		Lectureseries lec = LectureseriesLocalServiceUtil.getLectureseries(videoLectureseries.get(i).getLectureseriesId());
				    		List<Institution> institutions = InstitutionLocalServiceUtil.getByLectureseriesId(lec.getLectureseriesId(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
					    	// right now we only show the first institution and not linked institutions
					    	// for(int j=0; j<institutions.size(); j++){
							for(int j=0; j<1; j++){
				    			Institution insti = InstitutionLocalServiceUtil.getById(institutions.get(j).getInstitutionId());    			
				    			Institution pInst = InstitutionLocalServiceUtil.getById(institutions.get(j).getParentId());
				    			Institution rInst = InstitutionLocalServiceUtil.getById(pInst.getParentId());
					    		%>
								<portlet:actionURL var="backURL1" name="addFilter">
									<portlet:param name="jspPage" value="/guest/videosList.jsp" />
									<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
									<portlet:param name="institutionId" value="0"/>
									<portlet:param name="termId" value="0"/>
									<portlet:param name="categoryId" value="0"/>
									<portlet:param name="creatorId" value="0"/>
								</portlet:actionURL>					
								<portlet:actionURL var="backURL2" name="addFilter">
									<portlet:param name="jspPage" value="/guest/videosList.jsp" />
									<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
									<portlet:param name="institutionId" value="<%=insti.getInstitutionId()+\"\"%>"/>
									<portlet:param name="termId" value="0"/>
									<portlet:param name="categoryId" value="0"/>
									<portlet:param name="creatorId" value="0"/>
								</portlet:actionURL>	
								
								<A HREF=<%=portalURL%>><%=companyName %></A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
								<A HREF="<%=backURL0%>"><%=pageName %></A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
								<A HREF="<%=backURL0%>"><%=rInst.getName() %></A> <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
						    	<A HREF="<%=backURL1%>"><%=pInst.getName() %></A> <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
						    	<A HREF="<%=backURL2%>"><%=insti.getName() %></A> 
						    	<%if(lec.getLectureseriesId()>0) {%>
					    		<span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <SPAN><%=lec.getName()%></SPAN>
					    		<%}%>
						    	<br/>
				    		<%}
				    	}
			    	}else{
				    	for(int i=0; i<videoInstitutions.size(); i++){
				    		try{
					    		Institution insti = InstitutionLocalServiceUtil.getById(videoInstitutions.get(i).getInstitutionId());    			
					    		Institution pInst = InstitutionLocalServiceUtil.getById(videoInstitutions.get(i).getInstitutionParentId());
					    		Institution rInst = InstitutionLocalServiceUtil.getById(pInst.getParentId());
						    	%>
									<portlet:actionURL var="backURL3" name="addFilter">
										<portlet:param name="jspPage" value="/guest/videosList.jsp" />
										<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
										<portlet:param name="institutionId" value="0"/>
										<portlet:param name="termId" value="0"/>
										<portlet:param name="categoryId" value="0"/>
										<portlet:param name="creatorId" value="0"/>
									</portlet:actionURL>					
									<portlet:actionURL var="backURL4" name="addFilter">
										<portlet:param name="jspPage" value="/guest/videosList.jsp" />
										<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
										<portlet:param name="institutionId" value="<%=insti.getInstitutionId()+\"\"%>"/>
										<portlet:param name="termId" value="0"/>
										<portlet:param name="categoryId" value="0"/>
										<portlet:param name="creatorId" value="0"/>
									</portlet:actionURL>		    	
							    	
   									<A HREF="/"><%=companyName %></A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
							    	<A HREF="<%=backURL0%>"><%=pageName %></A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
							    	<A HREF="<%=backURL0%>"><%=rInst.getName() %></A> <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
							    	<%if(pInst.getLevel()>0) {%>
							    	  <A HREF="<%=backURL3%>"><%=pInst.getName() %></A>
							    	  <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
							    	<%}%>
							    	<A HREF="<%=backURL4%>"><%=insti.getName() %></A>	
							    	<br/> 
					      		<%
				    		}catch(Exception e){}
				      }  		
			    	}
			    	%>
			    </div>
			</div>
		<%}%>
	
		<h1><liferay-ui:message key="video-catalog"/></h1>
		    
		<div class="col-md-7">
		    <div id="main" >
			  <%
			    String title = video.getTitle();  	
			  	Long lTermId = lectureseries.getTermId();
			  	String termMetadata = "";
			  	if(lTermId > 1)
			  	{
			  		termMetadata = " ("+TermLocalServiceUtil.getById(lTermId).getPrefix()+" "+TermLocalServiceUtil.getById(lTermId).getYear()+")";
			  	}
			  		String series = lectureseries.getName()+termMetadata;
			  	%>
		       <c:if test="${relatedVideos.size()>1}"><div class="player"></c:if>
			   <c:if test="${relatedVideos.size()<=1}"><div class="player-wide"></c:if>
				<%@ include file="/player/includePlayer.jsp"%>
				   <div class="license">
				      <%if(videoLicense.getL2go()==1){%>
				      	<a href="/license-l2go" title="<liferay-ui:message key='l2go-license-click-for-info'/>"><liferay-ui:message key="license"/>: <liferay-ui:message key='l2go-license'/></a>
				 	  <%}else{%>
						<a href="https://creativecommons.org/licenses/by-nc-sa/3.0/" title="<liferay-ui:message key='cc-license-click-for-info'/>"><liferay-ui:message key="license"/>: <liferay-ui:message key='cy-nc-sa-license'/></a> 		
				 	  <%}%>       
				   </div>
			       <div class="views"><liferay-ui:message key="views"/>: ${video.hits}</div>	
			       	
					  <c:if test="${relatedVideos.size()>1}"> <div class="meta-video-info"></c:if>
					  <c:if test="${relatedVideos.size()<=1}"> <div class="meta-video-info-wide"></c:if>
					    <div class="meta-title">
							<%
								if(isCitation2Go){
									%><div class="c2go-title"><liferay-ui:message key='citation-of'/></div><%
								}
							%>	
						    <%=title%>
					    </div>
				      	<div class="meta-creators">
										<%
									        String date1 = "";
											String creators = "";
											creators=CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(video.getVideoId(), 100);
									        try{ date1 = video.getDate().trim().substring(0, 10);}catch(Exception e){}
									    %>
										<%=creators%>
										<div class="date"><%=date1%></div>
						</div>
					    <div class="lectureseries-small"><%=series%></div>
						<div class="meta-description-container">
							<div class="meta-description">
								  <%if(videoMetadata.getDescription().trim().length()>0){ %>	
								  	${videoMetadata.description}
								  <%}else{%>
							      	${lectureseries.longDesc}
								  <%}%>
							</div>
						</div>
				    </div>
				    
				    <%
				    if(timeEnd==0 || timeEnd<timeStart || video.getCitation2go()==0){
					%>
					
					    <c:if test="${relatedVideos.size()>1}"><div class="metainfo"></c:if>
					    <c:if test="${relatedVideos.size()<=1}"><div class="metainfo-wide"></c:if>
							<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
							    <c:if test="${video.downloadLink==1}">
								    <li id="down"><a href="#download" data-toggle="tab"><liferay-ui:message key="download"/></a></li>
							    </c:if>
							    <%if(video.getOpenAccess()==1){%>
							   	 	<li><a href="#share" data-toggle="tab"><liferay-ui:message key="share"/></a></li>
							    <%}%>
							    <li><a href="#support" data-toggle="tab"><liferay-ui:message key="support"/></a></li>
							    <%if(video.isHasChapters()){ %>
							    	<li><a href="#chapters" data-toggle="tab"><liferay-ui:message key="chapters"/></a></li>
							    <%}%>				    
							</ul>
							    
							<div id="my-tab-content" class="tab-content">
								<c:if test="${video.downloadLink==1}">
									<div class="tab-pane" id="download">
								        <p><%@ include file="/guest/includeDownload.jsp" %></p>
								    </div>
								</c:if>
								<%if(video.getOpenAccess()==1){%>
								    <div class="tab-pane" id="share">
								        <p><%@ include file="/guest/includeShare.jsp" %></p>
								    </div>
							    <%}%>
								    <div class="tab-pane" id="support">
								        <p>
											<%
												Integer facultyId = (int)video.getRootInstitutionId();
												String institut = "";
												String option1 = PortalUtil.getOriginalServletRequest(request).getParameter("option1"); 
												
												switch(facultyId){
													case 3: institut = "UHH-Jura";break;
													case 4: institut = "UHH-WiSo";break;
													case 5: institut = "UHH-Medizin";break;
													case 6: institut = "UHH-EW";break;
													case 7: institut = "UHH-GWiss";break;
													case 8: institut = "UHH-MIN";break;
													case 203: institut = "UHH-PB";break;
													case 204: institut = "UHH-BWL";break;
													default: institut = "Fakultätübergreifend";break;
												}
												
												String url=video.getUrl();
												if(video.getOpenAccess()==0)url=video.getSecureUrl();
												
												JSONObject jsn = new JSONObject();
												jsn.put("institution",institut);
												jsn.put("system","Lecture2Go");
												jsn.put("role","Lecture2Go-Benutzer");
												jsn.put("gender","");
												jsn.put("firstname",PortalUtil.getOriginalServletRequest(request).getParameter("firstname"));
												jsn.put("lastname",PortalUtil.getOriginalServletRequest(request).getParameter("lastname"));
												jsn.put("email",PortalUtil.getOriginalServletRequest(request).getParameter("email"));
												jsn.put("subject",url);
												jsn.put("body",PortalUtil.getOriginalServletRequest(request).getParameter("body"));
												jsn.put("ergebnis",PortalUtil.getOriginalServletRequest(request).getParameter("ergebnis"));
												jsn.put("option1",option1);
												jsn.put("result",PortalUtil.getOriginalServletRequest(request).getParameter("result"));
												jsn.put("spamprotect",PortalUtil.getOriginalServletRequest(request).getParameter("spamprotect"));
											%>
											<div id="meta-share">
												<%
													SupportFormularClient sfc = new SupportFormularClient("mail4eLearnSupport",url,jsn.toString(),"");
													out.print(sfc.getFormular());
												%>
												
												<% 
													// If support form was submitted, scroll down and select 'support' tab
													if(option1!=null){
														%>
														<script type="text/javascript">
															$(function() {
																// activate contact tab
																$("#tabs li a").eq(-1).click();
																
																// Scrolling must happen in onload, because otherwise the Player is not yet loaded and the position would be wrong
																window.onload = function () {
																	var pos = $("#tabs").offset().top;
																	$('html, body').animate({scrollTop: pos - 10}, 1000, "easeInOutCubic");	
																}
																
															 });
														</script>
														<%		
													}
												%>
											</div>		        
								    </div>
		
									<%if(video.isHasChapters() || video.isHasComments()){%>
									    <div class="tab-pane" id="chapters">
									    	<liferay-portlet:resourceURL id="showSegments" var="segmentsURL" />
											<script type="text/javascript">
												$.ajax({
												    url: '<%=segmentsURL%>',
												    method: 'POST',
												    dataType: "json",
												    data: {
												 	   	<portlet:namespace/>videoId: "<%=video.getVideoId()%>",
												    },
												    success: function(data, textStatus, jqXHR) {
												        // since we are using jQuery, you don't need to parse response
												        drawSegmentRow(data);
												    }
												});	
											
												function hideSegment(sId){
													$("b#pf2_"+sId).hide();
													$("b#pf1_"+sId).show();
													$("b#iav"+sId).hide();		
												}
												function showSegment(sId){
													$("b#pf1_"+sId).hide();
													$("b#pf2_"+sId).show();
													$("b#iav"+sId).show();		
												}
												function loadSegment(sId){
													$("b#pf2_"+sId).show();
													$("b#pf1_"+sId).hide();
													$("b#iav"+sId).show();
												}
												
												function drawSegmentRow(data) {
													for (var i = 0; i < data.length; i++) {
														drawRow(data[i]);
												    }
												}
												
												function drawRow(segment) {
												    if(segment.chapter==1){
												    	// segment is a chapter
												    	newRow='<div class="chaptertile" id="' + segment.segmentId + '" begin="' + segment.start + '" end="' + segment.end + '">'+
														'<a><img width="130px" height="63px" class="imgsmall" title="watch this chapter" src="'+segment.image+'"></a>'+
														'<span class="time">'+segment.start +' - '+segment.end+'</span><br/>'+
														'<a><span class="segment-title">'+segment.title+'</span></a>';
													}else{
														// segment is a comment
														newRow='<div class="commenttile" id="'+segment.segmentId+'" onload="alert('+segment.segmentId+')">'+
											    		'<div>'+
														'<b id="pf1_'+segment.segmentId+'">'+
											    		'<span class="icon-small icon-plus" id="showr'+segment.segmentId+'" onclick="showSegment('+segment.segmentId+')"/>'+
											    		'</b>'+
											    		'<b id="pf2_'+segment.segmentId+'">'+
											    		'<span class="icon-small icon-minus" id="hidr'+segment.segmentId+'" onclick="hideSegment('+segment.segmentId+')"/>'+
											    		'</b>'+
											    		'<span class="time">'+segment.start+'</span>'+
											    		'<a><iavst class="white" begin="'+segment.start+'" end="'+segment.end+'"><span class="segment-title">'+segment.title+'</span></iavst></a>'+
											    		'</div>';
											    		if(segment.description >""){
											    			newRow=newRow+'<b id="iav'+segment.segmentId+'"><span class="fs10"><div id="description"><em>'+segment.description+'</em></div></span></b>';
											    		}
													}
													newRow=newRow+'</div>';
													if(segment.chapter!=1){
														newRow=newRow+'<script>YUI().use("node-base", function(Y) {Y.on("available", loadSegment('+segment.segmentId+'), "#'+segment.segmentId+'")})<\/script>';
													}
													
													if(segment.previousSegmentId == -1){
														$("#chapters").append(newRow);
													}else{
														$(newRow).insertAfter("#"+ segment.previousSegmentId);
													}
												}
											</script>
									    </div>
							    	<%}%>
							</div>    
						</div>
					<%
					}
				    %>	  
			  </div>

			  <%
			  if(relatedVideos.size()>1){
			  %>
			    <div class="related">
					<div class="col-md-5">
						    <div class="related-lectureseries-name"><liferay-ui:message key="lecture-series"/> &nbsp;<a target="_blank" class="icon-small icon-rss" href="${video.mp4RssLink}"></a> </div>
							<ul class="ul-related">
								<%
								ListIterator<Video> vli = relatedVideos.listIterator();
								while(vli.hasNext()){
								Video vid = vli.next();	
								String oId = "";
								if(vid.getOpenAccess()==1) oId = vid.getVideoId()+"";
								else oId = vid.getSPreffix();
								%>
								<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL1">
									<portlet:param name="objectId" value="<%=oId%>"/>
									<portlet:param name="objectType" value="v"/>
								</portlet:actionURL>
								<%-- test for the active video and highlight it --%>
								<c:set value="" var="activeClass"></c:set>
								<c:if test='<%=video.getVideoId() == vid.getVideoId() %>'> 
  									<c:set value="active" var="activeClass"></c:set>
								</c:if>
								<li class="videotile small related ${activeClass}" onClick="window.location='<%=viewOpenAccessVideoURL1.toString()%>'">
										<div class="video-image-wrapper-small related">
											<img class="video-image related" src="<%=vid.getImageSmall()%>">
										</div>
										<div class="metainfo-small related">
												<%
													String date = "";
							           				try{ date = vid.getDate().trim().substring(0, 10);}catch(Exception e){}
												%>
												<div class="title-small related"><%=vid.getTitle()%></div>
							          			<p class="creator-small2 related">
												<%=vid.getLinkedCreators() %>
							           			</p>
								           		<div class="date related"><%=date%></div> 
						            	</div>
								</li>
							<%}%>
							</ul>
					</div>
			    </div>
			  <%
			  }
			  %>			  
		</div>
		<%if(video.getOpenAccess()==0){%>
			<!-- coockie start -->
			<script type="text/javascript">
				$(function(){
					//cookie
					$.cookie("L2G_LSID", "<%=lectureseries.getLectureseriesId()%>");
				});
			</script>		
			<!-- coockie end -->
		<%}%>
		
		<%
	}else{
		if(video.getAccessPermitted()==0){
			%>
			<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL2">
				<portlet:param name="objectId" value="<%=objectId%>"/>
				<%if(objectType.equals("v")){%><portlet:param name="objectType" value="v"/><%}%>
				<%if(objectType.equals("l")){%><portlet:param name="objectType" value="l"/><%}%>
			</portlet:actionURL>
			<aui:form action="<%=viewOpenAccessVideoURL2.toString() %>" method="post">
				<aui:fieldset helpMessage="enter-password" column="true" label='<%="l2go-video-password"%>'>
					<aui:input name="password" label="password" required="true" value=""/>
					<aui:button type="submit" value="enter"/>
				</aui:fieldset>
			</aui:form>	
			<%
		}
	}
}
%>
<script type="text/javascript">
    $( function () {
        $('#tabs').tabs();
        $('[data-toggle=tab]').click(function(e){
    	    if ($(this).parent().hasClass('active')){
                $(this).parent().removeClass('active');
    		    $($(this).attr("href")).removeClass('active');
                // do not trigger the opening sequence from the tabs widget
    		    e.stopPropagation();
            }
    	});
    });
    
    $( document ).ready(function() {
		$('.meta-description').readmore({
			collapsedHeight: 60,
		  	moreLink: '<a href="#"><div><liferay-ui:message key="more"/><img class ="down_up" src="/lecture2go-theme/images/arrow_down.svg"/></div></a>',
		  	lessLink: '<a href="#"><div><liferay-ui:message key="less"/><img class ="down_up" src="/lecture2go-theme/images/arrow_up.svg"/></div></a>'
		});
	}); 
</script> 

<style type="text/css">
	.aui #breadcrumbs .breadcrumb {
	    display: none;
	}
	.current-page{
		display: none;
	}
</style>  		
