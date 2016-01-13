<%@page import="java.util.ListIterator"%>
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

<%if(video.getVideoId()>0){%>
	<%if(video.getAccessPermitted()==1){%>
		<%if(video.getOpenAccess()==1){%>
			<div class="col-xs-10 col-md-10">
				<c:if test="${relatedVideos.size()>1}"> <div class="path"></c:if>
			    <c:if test="${relatedVideos.size()<=1}"> <div class="path-wide"></c:if>
			    	<%
			    	if(video.getLectureseriesId()>0){
				    	for(int i=0; i<videoLectureseries.size(); i++){
				    		Lectureseries lec = LectureseriesLocalServiceUtil.getLectureseries(videoLectureseries.get(i).getLectureseriesId());
				    		List<Institution> institutions = InstitutionLocalServiceUtil.getByLectureseriesId(lec.getLectureseriesId(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
				    		for(int j=0; j<institutions.size(); j++){
				    			Institution insti = InstitutionLocalServiceUtil.getById(institutions.get(j).getInstitutionId());    			
				    			Institution pInst = InstitutionLocalServiceUtil.getById(institutions.get(j).getParentId());
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
								
						    	<A HREF="<%=backURL1%>"><%=pInst.getName() %></A> <span class="icon-arrow-right">&nbsp;</span> 
						    	<A HREF="<%=backURL2%>"><%=insti.getName() %></A> 
						    	<%if(lec.getLectureseriesId()>0) {%>
					    		<span class="icon-arrow-right">&nbsp;</span> <SPAN><%=lec.getName()%></SPAN>
					    	<%}%>
						    	<br/>
				    		<%}
				    	}
			    	}else{
				    	for(int i=0; i<videoInstitutions.size(); i++){
				    		Institution insti = InstitutionLocalServiceUtil.getById(videoInstitutions.get(i).getInstitutionId());    			
				    		Institution pInst = InstitutionLocalServiceUtil.getById(videoInstitutions.get(i).getInstitutionParentId());
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
						    	<A HREF="<%=backURL3%>"><%=pInst.getName() %></A>  <span class="icon-arrow-right">&nbsp;</span>  
						    	<A HREF="<%=backURL4%>"><%=insti.getName() %></A>
						    	<br/> 
				      <%}  		
			    	}
			    	%>
			    </div>
			</div>
		<%}%>
		    
		<div class="col-md-7">
		    <div id="main" >
			  <%
			    String title = video.getTitle();
			  	if(timeStart>0 && timeEnd>timeStart && video.getCitation2go()==1){
					title ="citation-of "+title;
			  	}
			   
			  	if(timeEnd>0 && timeEnd>timeStart && video.getCitation2go()==1){
			      %>
			      	<aui:a href="<%=video.getUrl()%>">go-to-full-video</aui:a>
			      <%
			    }
		      %>
		       <c:if test="${relatedVideos.size()>1}"><div class="player"></c:if>
			   <c:if test="${relatedVideos.size()<=1}"><div class="player-wide"></c:if>
				<%@ include file="/player/includePlayer.jsp"%>
				   <div class="license">
				      <%if(videoLicense.getL2go()==1){%>
				      	<a href="#"><img title="lecture2Go-license-click-for-info" src="/lecture2go-portlet/img/l2go-lizenz-88x31.png"/></a>
				 	  <%}else{%>
						<a href="#"><img title="cc-license-click-for-info" src="/lecture2go-portlet/img/lizenz_cc.png" /></a> 		
				 	  <%}%>       
				   </div>
			       <div class="label label-light">${video.hits} views</div>			  
			  </div>
			  
			  <c:if test="${relatedVideos.size()>1}"> <div class="meta-video-info"></c:if>
			  <c:if test="${relatedVideos.size()<=1}"> <div class="meta-video-info-wide"></c:if>
			    <div class="meta-title"><%=title%></div>
		      	<div class="meta-creators">${video.creators}
		      		<%
		      		String dt = "";
		      		try{dt=video.getDate().trim().substring(0, 10);}catch(Exception e){}
		      		%>
		      		&nbsp;<p class= "meta-date"><%=dt%></p>
		      	</div>
				<div class="meta-description">
					  <%if(videoMetadata.getDescription().trim().length()>0){ %>	
					  	${videoMetadata.description}
					  <%}else{%>
				      	${lectureseries.longDesc}
					  <%}%>
				</div>
		    </div>
		    
		    <%
		    if(timeEnd==0 || timeEnd<timeStart || video.getCitation2go()==0){
			%>
			
			    <c:if test="${relatedVideos.size()>1}"><div class="metainfo"></c:if>
			    <c:if test="${relatedVideos.size()<=1}"><div class="metainfo-wide"></c:if>
					<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
					    <c:if test="${video.downloadLink==1}">
						    <li><a href="#download" data-toggle="tab">Download</a></li>
					    </c:if>
					    <%if(video.getOpenAccess()==1){%>
					   	 	<li><a href="#share" data-toggle="tab">Share</a></li>
					    <%}%>
					    <li><a href="#support" data-toggle="tab">Support</a></li>
					    <%if(video.isHasChapters()){ %>
					    	<li><a href="#chapters" data-toggle="tab">Chapters</a></li>
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
										
										JSONObject jsn = new JSONObject();
										jsn.put("institution",institut);
										jsn.put("system","Lecture2Go");
										jsn.put("role","Lecture2Go-Benutzer");
										jsn.put("gender","");
										jsn.put("firstname",PortalUtil.getOriginalServletRequest(request).getParameter("firstname"));
										jsn.put("lastname",PortalUtil.getOriginalServletRequest(request).getParameter("lastname"));
										jsn.put("email",PortalUtil.getOriginalServletRequest(request).getParameter("email"));
										jsn.put("subject",video.getUrl());
										jsn.put("body",PortalUtil.getOriginalServletRequest(request).getParameter("body"));
										jsn.put("ergebnis",PortalUtil.getOriginalServletRequest(request).getParameter("ergebnis"));
										jsn.put("option1",option1);
										jsn.put("result",PortalUtil.getOriginalServletRequest(request).getParameter("result"));
										jsn.put("spamprotect",PortalUtil.getOriginalServletRequest(request).getParameter("spamprotect"));
									%>
									<div id="meta-share">
										<%
											String url=video.getUrl();
											if(video.getOpenAccess()==0)url=video.getSecureUrl();
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
										    	newRow='<div class="chaptertile" id="' + segment.segmentId + '" begin="' + segment.start + '" end="' + segment.end + '">'+
												'<a><img width="130px" height="63px" class="imgsmall" title="watch this chapter" src="'+segment.image+'"></a>'+
												'<span>'+segment.start +' - '+segment.end+'</span><br/>'+
												'<a><span>'+segment.title+'</span></a>';
											}else{
												newRow='<div class="commenttile" id="'+segment.segmentId+'" onload="alert('+segment.segmentId+')">'+
									    		'<div>'+
												'<b id="pf1_'+segment.segmentId+'">'+
									    		'<span class="icon-small icon-plus" id="showr'+segment.segmentId+'" onclick="showSegment('+segment.segmentId+')"/>'+
									    		'</b>'+
									    		'<b id="pf2_'+segment.segmentId+'">'+
									    		'<span class="icon-small icon-minus" id="hidr'+segment.segmentId+'" onclick="hideSegment('+segment.segmentId+')"/>'+
									    		'</b>'+
									    		'<a><span class="fs8">'+segment.start+'</span>'+
									    		'<iavst class="white" begin="'+segment.start+'" end="'+segment.end+'"><span>'+segment.title+'</span></iavst></a>'+
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
				if(relatedVideos.size()>1){
				%>
			    	<div class="related">
						<div class="col-md-5">
						    <div class="related-lectureseries-name">lecture-series &nbsp;<a target="_blank" class="icon-small icon-rss" href="${video.mp4RssLink}"></a> </div>
							<ul class="ul-related">
								<li class="placeholder"></li>
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
								<li class="videotile small related">
									<a href="<%=viewOpenAccessVideoURL1.toString()%>">
										<div class="video-image-wrapper-small related">
											<img class="video-image related" src="<%=vid.getImageSmall()%>">
										</div>
										<div class="metainfo-small related">
							          			<em class="creator-small2 related">
												<%
						       						String fullname="";
							        				String date = "";
							           				try{ date = vid.getDate().trim().substring(0, 10);}catch(Exception e){}

							           				List<Creator> cv = CreatorLocalServiceUtil.getCreatorsByVideoId(vid.getVideoId());
													ListIterator<Creator> cvi = cv.listIterator();										
							       					int i=0;
							       					while(cvi.hasNext()){
							       						if(i<2){
							       							fullname += cvi.next().getFullName();
							       							if(cv.size()>1) fullname+="; ";
								    					}else{
								    						fullname+="ET. AL";
															break;
								    					}
								    					i++;
							        				}
							           			%>
												<%=fullname %>
							           			</em>
												<div class="title-small related"><%=vid.getTitle()%></div>
								           		<div class="date related">[<%=date%>]</div> 
						            	</div>
									</a>
								</li>
								<%if(vli.hasNext()){%><li class="placeholder"></li><%}%>
							</ul>
							<%}%>
						</div>
			    	</div>
				<%
				}
				%>
			<%
			}
		    %>
		</div>
		
		<!-- coockie start -->
		<script type="text/javascript">
			$(function(){
				//cookie
				$.cookie("L2G_LSID", "<%=lectureseries.getLectureseriesId()%>");
			});
		</script>		
		<!-- coockie end -->
		<%
	}else{
		%>
		<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL2">
			<portlet:param name="objectId" value="<%=objectId%>"/>
			<%if(objectType.equals("v")){%><portlet:param name="objectType" value="v"/><%}%>
			<%if(objectType.equals("l")){%><portlet:param name="objectType" value="l"/><%}%>
		</portlet:actionURL>
		<aui:form action="<%=viewOpenAccessVideoURL2.toString() %>" method="post">
			<aui:fieldset helpMessage="enter-password" column="true" label='<%="l2go-video-password"%>'>
				<aui:input name="password" label="password" required="true" value=""/>
				
				<aui:button-row>
					<aui:button type="submit"/>
				</aui:button-row>
			</aui:fieldset>
		</aui:form>	
		<%
	}
	%>
	<%
}
%>
<script type="text/javascript">
    $( function () {
        $('#tabs').tabs();
    });
</script>    		