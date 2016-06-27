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
List<Lectureseries> latest = LectureseriesLocalServiceUtil.getLatest(10);
ListIterator<Lectureseries> lli = latest.listIterator();

//get popular videos
//example -> top 10
List<Video> popular = VideoLocalServiceUtil.getPopular(12);
ListIterator<Video> pli = popular.listIterator();

//get all root (1st level) institutions with open access videos
List<Institution> institutions = InstitutionLocalServiceUtil.getRootInstitutionsByOpenAccessVideos();


%>

<div class="front-page-teaser">
 	<div class="bg-video-container">
		<video id="bg-vid" autoplay loop poster="/lecture2go-portlet/img/background_still.png" preload="none">
		    <source src="/lecture2go-portlet/img/background.mp4" type="video/mp4">
		</video>
		<div class="dark-overlay"></div>
	</div>
	<div class="l2go-info-container">
		<div class="l2go-info">
			<div class="l2go-title">
				Lecture<span class="orange">2</span>Go
			</div>
			<div class="l2go-subtitle">
				<p><liferay-ui:message key="l2go-description"/></p>
			</div>
			<div class="big-search">
			</div>
			
			<button id="outer-catalogue-button" class="catalogue-button" onclick="window.location='/web/vod/l2go';"><liferay-ui:message key="to-catalogue"/></button>
			
		</div>
	</div>
</div>


<div id="front-page-content">
<!-- new videos -->
	<div class="news">
		<h4><liferay-ui:message key="last-added"/></h4>
		<div class="video-box-list-container">
			<div id="news-carousel" class="carousel slide" data-interval="false" data-wrap="false">
            <!-- Carousel items -->
	            <div class="carousel-inner">
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
										vid = VideoLocalServiceUtil.getFullVideo(lectser.getLectureseriesId());
										oId = vid.getVideoId()+"";
									}else{
										oId = lectser.getLectureseriesId()+"";
										vid = VideoLocalServiceUtil.getFullVideo(lectser.getLatestOpenAccessVideoId());
									}

									List<Video_Institution> vi = Video_InstitutionLocalServiceUtil.getByVideo(vid.getVideoId());
						        	// only get the first institution
						        	Institution inst = InstitutionLocalServiceUtil.getById(vi.get(0).getInstitutionId());
						        	
									%>
									
									<c:if test='${count % 4 == 0 && count != 0}'>
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
													<img src="<%=vid.getImageMedium() %>">
												</div>
											</div>

											<div class="video-box-content">
												<div class="date"><%=vid.getSimpleDate() %></div>
												<div class="title-small dot-ellipsis dot-resize-update "><%=vid.getTitle() %></div>
												<div class="creator-small2 dot-ellipsis dot-resize-update "><%=vid.getLinkedCreators() %></div>										
												<% if (!isVideo) { %>
													<div class="lectureseries-small dot-ellipsis dot-resize-update "><%=lectser.getName() %></div> 
												<% } %>
												<div class="labels">
													<%
														String instLink="<a href='/l2go/-/get/"+inst.getInstitutionId()+"/"+inst.getParentId()+"/0/0/0/'>"+inst.getName()+"</a>"; 
													%>
										        	<span class="label label-light2"><%=instLink%></span>												
												</div>
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
				<a class="left carousel-control" href="#news-carousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
				<a class="right carousel-control" href="#news-carousel" data-slide="next"><i class="icon-chevron-right"></i></a>
			</div>
		</div>
	</div>





<!-- popular videos -->
	<div class="popular">
		<h4><liferay-ui:message key="popular-videos"/></h4>
		<div class="video-box-list-container">
			<div id="popular-carousel" class="carousel slide" data-interval="false" data-wrap="false">
            <!-- Carousel items -->
	            <div class="carousel-inner">
	                <div class="item active">
						<div class="row-fluid video-box-list">
							<c:set var="count" value="0" scope="page" />
							<%
								while(pli.hasNext()){
									Video video = pli.next();
									
									Video vid = VideoLocalServiceUtil.getFullVideo(video.getVideoId());
									
									boolean isVideo = (vid.getLectureseriesId() < 0);

									String creators = CreatorLocalServiceUtil.getCommaSeparatedCreatorsByVideoIdAndMaxCreators(vid.getVideoId(),3);
								
									Lectureseries lec = LectureseriesLocalServiceUtil.getLectureseries(vid.getLectureseriesId());
									
						        	List<Video_Institution> vi = Video_InstitutionLocalServiceUtil.getByVideo(vid.getVideoId());
						        	// only get the first institution
						        	Institution inst = InstitutionLocalServiceUtil.getById(vi.get(0).getInstitutionId());
							%>
								<c:if test="${count % 4 == 0 && count != 0}">
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
												<img src="<%=vid.getImageMedium() %>">
											</div>
										</div>
	
										<div class="video-box-content"> 
											<div class="date"><%=vid.getSimpleDate() %></div>
											<div class="title-small dot-ellipsis dot-resize-update "><%= vid.getTitle() %></div>
											<div class="creator-small2 dot-ellipsis dot-resize-update "><%= vid.getLinkedCreators() %></div>
											<% if (!isVideo) { %>
												<div class="lectureseries-small dot-ellipsis dot-resize-update "><%= lec.getName() %></div>
											<% } %>
											<div class="labels">
												<%
													String instLink="<a href='/l2go/-/get/"+inst.getInstitutionId()+"/"+inst.getParentId()+"/0/0/0/'>"+inst.getName()+"</a>"; 
												%>
									        	<span class="label label-light2"><%=instLink%></span>
									        </div>
										</div>
									</div>
								<c:set var="count" value="${count + 1}" scope="page"/>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#popular-carousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
				<a class="right carousel-control" href="#popular-carousel" data-slide="next"><i class="icon-chevron-right"></i></a>
			</div>
		</div>
	</div>

</div>


<script>
$(document).ready(function(){

    // process different things depending on the screen size
	mediaCheck({
	  	media: '(min-width: 768px)',
	  	entry: function() {
	  		transformSearchToWideView();
		  	//hide all carousel items but the first and show carousel navigation
		  	$("#news-carousel .item:not(:first)").removeClass("active");
		  	$("#popular-carousel .item:not(:first)").removeClass("active");
		  	$(".carousel-control").show();
		  	showOrHideCarouselControl('#news-carousel');
		  	showOrHideCarouselControl('#popular-carousel');
		  	transformSearchToWideView();
		 },
	  exit: function() {
		  	transformSearchToSmallView();
		  	// do not show the big button on desktop
		  	$(".filter-facility-menu").hide();
		  	//show all carousel items and hide carousel navigation
		  	$(".item").addClass("active");
		  	$(".carousel-control").hide();
		 }
	});

	// handle the previous and next buttons of the carousel
    //showOrHideCarouselControl('#news-carousel');
    //showOrHideCarouselControl('#popular-carousel');

    $('#news-carousel').on('slid.bs.carousel', function() { 
    	showOrHideCarouselControl('#news-carousel');
    	// the truncation of the elements needs to be triggered manually on carousel switch
    	$(".active .title-small, .active .creator-small2, .active .lectureseries-small").trigger("update.dot");
    	});

    $('#popular-carousel').on('slid.bs.carousel', function() { 
    	showOrHideCarouselControl('#popular-carousel');
    	// the truncation of the elements needs to be triggered manually on carousel switch
    	$(".active .title-small, .active .creator-small2, .active .lectureseries-small").trigger("update.dot");
    });

});

		
/* 
	hides the "previous"-control-button on first carousel page and 
	the "next"-control-button on the last carousel page
*/
function showOrHideCarouselControl(id) {
  	var $this = $(id);
  	if($this.find('.carousel-inner .item:first').hasClass('active')) {
  		$this.children('.left.carousel-control').hide();
  	} else if($this.find('.carousel-inner .item:last').hasClass('active')) {
    	$this.children('.right.carousel-control').hide();
  	} else {
    	$this.children('.carousel-control').show();
  	}
}

function transformSearchToWideView() {
  	// move search box from top to center
  	$(".search").appendTo(".big-search");
  	// change image to button
	$('#_lgopenaccessvideos_WAR_lecture2goportlet_searchButton span').text(" <liferay-ui:message key='search'/>");
}

function transformSearchToSmallView() {
  	// move search box from center to top
  	$(".search").prependTo("#content");
	$('#_lgopenaccessvideos_WAR_lecture2goportlet_searchButton span').text("");
}
    
</script>