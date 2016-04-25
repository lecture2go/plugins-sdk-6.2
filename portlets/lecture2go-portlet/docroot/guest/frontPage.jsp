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
List<Video> popular = VideoLocalServiceUtil.getPopular(10);
ListIterator<Video> pli = popular.listIterator();

//get all root (1st level) institutions with open access videos
List<Institution> institutions = InstitutionLocalServiceUtil.getRootInstitutionsByOpenAccessVideos();

%> 
<div class="teaser">
	<div class="info">
		<div class="pageDescription">
			<p>Lecture2Go ist die zentrale Medienplattform der Universität Hamburg, auf der Sie aufgenommene Vorlesungen, Konferenzen, Tutorials und mehr ansehen, hören und herunterladen können. <a href="">Mehr erfahren</a></p>
		</div>
		<div class="bigSearch">
			
		</div>
	</div>
</div>

<div class="contxent">
	<h4><liferay-ui:message key="last-uploaded"/></h4>
	<p>
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
				//object output
				if(isVideo){
					%> 
						video object --> title: <%=vid.getTitle() %>
					<%
				}else{
					%> 
						lecture series "<%=lectser.getName()%>" --> title from last video: "<%=vid.getTitle()%>"
					<%
				}
				%>
				<br/>
				<%
			}
		%>
	</p>

	<h4><liferay-ui:message key="most-viewed"/></h4>
  	<p>
		<%
			while(pli.hasNext()){
				Video vid = pli.next();
				%> 
					video object --> title: <%=vid.getTitle() %>				
					<br/>
				<%
			}
		%>
	</p> 
</div>

<script>
	//$(".search").appendTo(".bigSearch");
	// $('#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery').addClass("largeSearchbox");
</script>