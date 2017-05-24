<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org   /TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="/lecture2go-portlet/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/lecture2go-portlet/player/jwplayer-7.9.3/jwplayer.js"></script>
	<script type="text/javascript">jwplayer.key="";</script>
	
	<title>Lecture2o-Embed</title>
	<style type="text/css">
	
		.jw-controlbar-center-group {
		    width: 100% !important;
		    padding: 0 .5em;
		}
		
		.jw-controlbar {
		    width: calc(100% - 100px) !important;
		}
	
		.jw-background-color {
    		background-color: rgba(33, 33, 33, 0.8);
		}

		.jw-skin-seven .jw-dock-button {
		    border-radius: 0em !important;
		}
	
		.jw-dock-button.jw-background-color.jw-reset {
		    bottom: -40px;
		    margin: 0 0 0 -11px;
		    position: absolute;
		    width: 100%;
		}
	
		.jw-icon.jw-dock-image.jw-reset::before {
		    color: #fff;
		    content: "Lecture2Go";
		    float: right;
		    font-family: arial;
		    font-size: 15px;
		    font-weight: bold;
		    margin-right: 8px;
		    margin-top: 11px;
		}		

		.jw-overlay::before {
		    background-color: rgba(0, 0, 0, 0);
		    bottom: 0;
		    content: " ";
		    left: -50%;
		    position: absolute;
		    top: 100px;
		    width: 100%;
		}

		.jw-dock-button .jw-overlay {
		    display: none;
		    margin-top: -63px !important;
		    margin-right: 5px !important;
		    font-size: 14px !important;
		}
	
		.jw-skin-seven .jw-dock .jw-overlay, .jw-skin-seven .jw-skip {
		    border-radius: 0em !important;
		}
			
		.jw-dock-image:hover {
    		opacity: 1;
		}
		
	</style>

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
	<%if(video.getVideoId()>0){ %>
		<div id="player1"></div>
		<script>
					var vttChapterFile ="<%=video.getVttChapterFile()%>";
					var playerUri1 ="<%=video.getPlayerUris().get(0)%>";
			        var playerUri2 ="<%=video.getPlayerUris().get(1)%>";
			        var playerUri3 ="<%=video.getPlayerUris().get(2)%>";
			        var playerUri4 ="<%=video.getPlayerUris().get(3)%>";
			        var playerUri5 ="<%=video.getPlayerUris().get(4)%>";

			        //hack for HLS in firefox and mp3
			        var containerFormat = "<%=video.getContainerFormat()%>";
			        var isFirefox = typeof InstallTrigger !== 'undefined';
			        var downloadAllowed = "<%=video.getDownloadLink()%>";
			        if(containerFormat.indexOf("mp3") !== -1 && isFirefox && downloadAllowed.indexOf("1")!==-1){
			        	var playerUri = playerUri1;
			        	playerUri1 = playerUri3;
			        	playerUri3 = playerUri;
			        }
			        //
			        
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
			            hlshtml: true,
			            androidhls: true
			        });
			        jwplayer().addButton(
			        	"", 
			        	"Dieses Video auf Lecture2Go ansehen",
			        	function() {
			        		//stop player
			        		jwplayer().stop();
			        		//open web site
			                window.open('<%=video.getUrl()%>');
			            },
			        	"Lecture2Go"
			        )
								        
		</script>
	<%}%>
</body>
</html>
