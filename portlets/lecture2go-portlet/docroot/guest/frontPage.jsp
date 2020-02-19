<%@page import="de.uhh.l2g.plugins.model.impl.InstitutionImpl"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@include file="/init.jsp"%>
<%
Long institutionId = new Long(0);
Long parentInstitutionId = new Long(0);
Long termId = new Long(0);
Long categoryId = new Long(0);
Long creatorId = new Long(0);
String searchQuery = "";

//get latest 
//-lecture series = lectureseriesId>0
//-videos = lectureseriesId<0
//example -> top 10
List<Lectureseries> latest = LectureseriesLocalServiceUtil.getLatest(12);
ListIterator<Lectureseries> lli = latest.listIterator();

//get popular videos
//example -> top 10
List<Video> popular = VideoLocalServiceUtil.getPopular(12);
ListIterator<Video> pli = popular.listIterator();

//get all root (1st level) institutions with open access videos
List<Institution> institutions = InstitutionLocalServiceUtil.getRootInstitutionsByOpenAccessVideos();


%>


<div id="front-page-content">
	<!-- new videos -->
	<div class="news">
		<div class="video-box-list-container">
			<div>
            <!-- Carousel items -->
	            <div>
	                <div class="item active">
						<div class="row-fluid video-box-list">
							<c:set var="count" value="0" scope="page" />
							<%
								while(lli.hasNext()){
									Lectureseries lectser = lli.next();
									String oId = "";
									boolean isVideo = false;
									Video vid = new VideoImpl();
									if(lectser.getLatestOpenAccessVideoId()<0){
										isVideo = true;
										try {
											vid = VideoLocalServiceUtil.getVideo(lectser.getLectureseriesId());
										} catch (Exception e) {
											
										}
										oId = vid.getVideoId()+"";
									}else{
										oId = lectser.getLectureseriesId()+"";
										try {
											vid = VideoLocalServiceUtil.getVideo(lectser.getLatestOpenAccessVideoId());
										} catch (Exception e) {
											
										}

									}

									List<Video_Institution> vi = Video_InstitutionLocalServiceUtil.getByVideo(vid.getVideoId());
						        	// only get the first institution
						        	Institution inst = new InstitutionImpl();
						        	try{
						        		inst=InstitutionLocalServiceUtil.getById(vi.get(0).getInstitutionId());
						        	}catch(Exception e){}
						        	
									%>
									
									<c:if test='${count % 3 == 0 && count != 0}'>
										<!-- row-fluid -->
											</div>
											<!-- item -->
										</div>
										<div class="item">
		                    				<div class="row-fluid video-box-list">
		                    		</c:if>
										<div class="span3 video-box" onClick="window.location='<%=vid.getUrl() %>'">											
											<div class="video-box-image-container">
												<div class="video-box-image">
													<img src="<%=vid.getImage() %>">
												</div>
											</div>

											<div class="video-box-content">
												<div class="date"><%=vid.getSimpleDate() %></div>
												<div class="title-small dot-ellipsis dot-height-60 dot-resize-update "><%=vid.getTitle() %></div>
												<div class="creator-small2 dot-ellipsis dot-height-25 dot-resize-update "><%=vid.getLinkedCreators() %></div>
												<div class="lectureseries-small dot-ellipsis dot-height-25 dot-resize-update">
													<% if (!isVideo) { %>
														<%=lectser.getName() %>
													<% } else { %>
														&nbsp;
													<% } %>
												</div> 
												<%if(inst.getInstitutionId()>0){ %>
												<div class="labels">
													<%
														String instLink="<a href='/l2go/-/get/"+inst.getInstitutionId()+"/"+inst.getParentId()+"/0/0/0/'>"+inst.getName()+"</a>"; 
													%>
										        	<span class="label label-light2"><%=instLink%></span>												
												</div>
												<%}%>
											</div> 
										</div>
										
									<c:set var="count" value="${count + 1}" scope="page"/>

									<!-- span -->
									<%
								}
							%>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>


<style type="text/css">
	#breadcrumbs .breadcrumb {
	    visibility: hidden;
	}
	
	#breadcrumbs {
	    height: 17px !important;
	    margin-bottom: 3px;
	    margin-top: 0;
	    padding: 0;
	}
	
	.current-page{
		display: none;
	}
</style>  
