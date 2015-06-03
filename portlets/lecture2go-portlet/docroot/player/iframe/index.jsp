<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="/lecture2go-portlet/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/lecture2go-portlet/player/jwplayer/jwplayer.js"></script>
	<script type="text/javascript">jwplayer.key="Ez+YMIX4GOdXtP/v87cdP4FQuVY2dvNrQluq/w==";</script>
	<title>Lecture2o-Embed</title>
</head>

<%@ page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil"%>
<%@ page import="de.uhh.l2g.plugins.model.Video"%>
<%@ page import="de.uhh.l2g.plugins.model.impl.VideoImpl"%>

<%
	Video video = new VideoImpl();
	Long videoId = new Long(0);
	try{
		videoId = new Long(request.getParameter("v"));
		video = VideoLocalServiceUtil.getFullVideo(videoId);
	}catch(Exception e){}
%>

<body>
	<%if(video.getOpenAccess()==1 && video.getVideoId()>0){ %>
		<div id="player1"></div>
		<script>
			        var desctopStreamUrl ="<%=video.getStreamUrl()%>";
					var mobileStreamUrl ="<%=video.getStreamAndroidUrl()%>";
					var mp4OpenAccessDownloadLink ="<%=video.getMp4OpenAccessDownloadLink()%>";
					var vttChapterFile ="<%=video.getVttChapterFile()%>";
					
			        jwplayer('player1').setup({
			            width: "100%",
			            height: "100%",
			            aspectratio: "16:9",
			            sources: [
			            	{ file: mobileStreamUrl },
			            	{ file: desctopStreamUrl },
							{ file: mp4OpenAccessDownloadLink }
			            ],
			            tracks: [{
			               			file: vttChapterFile,
			                		kind:'chapters'
				            	}
			            ],
			            primary: "flash",
			            androidhls: true,
			        });
		</script>
	<%}%>
</body>

