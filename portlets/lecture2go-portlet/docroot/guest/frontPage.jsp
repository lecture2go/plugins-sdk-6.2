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

//get popular videos
//example -> top 10
List<Video> popular = VideoLocalServiceUtil.getPopular(10);

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
<!-- latest -->
<h4>Neue Inhalte</h4>
	<p>Lorem ipsum dolor sit amet, mea facete insolens an, cu vel quem constituam. Ius ea enim oporteat nominati, eos an cetero disputando. Propriae deserunt pri id, velit diceret sanctus et eam. Vis postea tibique sensibus cu, nec an verear audire eligendi, in per tantas nusquam phaedrum. Diam impedit commune an sit, sint partem legimus no mel, id eleifend voluptatibus eos.
  </p>

<h4>Highlights</h4>
  <p>
Mel ei veri nihil disputando, ea sed erant rationibus vituperata. Pri no labores intellegebat. Augue minimum reprimique ex sea, nec ad diam convenire. Et his solum congue nostrum. Sea clita eleifend ei, eam aliquid menandri accommodare ea, vix te aliquam torquatos persequeris. Ea mel vidisse maiorum accumsan, bonorum propriae no eam, usu et feugait imperdiet suscipiantur.
  </p>
</div>

<script>
	//$(".search").appendTo(".bigSearch");
	// $('#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery').addClass("largeSearchbox");
</script>