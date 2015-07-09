<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org   /TR/html4/loose.dtd">
<html>
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
					var vttChapterFile ="<%=video.getVttChapterFile()%>";
					var playerUri1 ="<%=video.getPlayerUris().get(0)%>";
			        var playerUri2 ="<%=video.getPlayerUris().get(1)%>";
			        var playerUri3 ="<%=video.getPlayerUris().get(2)%>";
			        var playerUri4 ="<%=video.getPlayerUris().get(3)%>";
			        var playerUri5 ="<%=video.getPlayerUris().get(4)%>";
			        
					var img = "<%=video.getImage()%>";
			        jwplayer('player1').setup({
			            width: "100%",
        			    height: "100%",
			            aspectratio: "16:9",
			            image: img,
			            sources: [
			                  	{ file: playerUri1 },
			                	{ file: playerUri2 },
			                	{ file: playerUri3 },
			                	{ file: playerUri4 },
			                	{ file: playerUri5 }
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
</html>
