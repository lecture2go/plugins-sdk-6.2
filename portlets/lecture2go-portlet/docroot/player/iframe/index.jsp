<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org   /TR/html4/loose.dtd">
<html>

<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil"%>
<%@ page import="de.uhh.l2g.plugins.model.Video"%>
<%@ page import="de.uhh.l2g.plugins.model.impl.VideoImpl"%>

<%
	Video video = new VideoImpl();
	Long videoId = new Long(0);
	String start = null;
	String end = null;
	
	try{
		videoId = new Long(request.getParameter("v"));
		video = VideoLocalServiceUtil.getFullVideo(videoId);
	}catch(Exception e){
		try{
			String[] s = request.getQueryString().split("/");
			videoId = new Long(s[0].split("=")[1]);
			video = VideoLocalServiceUtil.getFullVideo(videoId);
			start = s[1];
			end = s[2];
		}catch(Exception a){}
	}
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta property="og:url" content="<%=request.getRequestURL()%>">
    <meta property="og:title" content="<%=video.getTitle()%>">
    <meta property="og:image" content="<%=video.getImage()%>">
    <meta property="og:description" content="<%=video.getTitle()%>">
    <meta property="og:type" content="video">
    <meta property="og:video" content="<%=video.getPlayerUris().get(2)%>">
    <meta property="og:video:secure_url" content="<%=video.getPlayerUris().get(2)%>">
    <meta property="og:video:type" content="video/mp4">
    <meta property="og:video:width" content="480">
    <meta property="og:video:height" content="270">
    
    <meta name="twitter:card" content="player">
    <meta name="twitter:player" content="<%=request.getRequestURL()%>">
    <meta name="twitter:player:width" content="480">
    <meta name="twitter:player:height" content="270">
    <meta name="twitter:player:stream" content="<%=video.getPlayerUris().get(2)%>">
    <meta name="twitter:player:stream:content_type" content="video/mp4; codecs=&quot;avc1.42E01E, mp4a.40.2&quot;">
    	
	<script type="text/javascript" src="/lecture2go-portlet/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/lecture2go-portlet/js/citation2go.js"></script>
	<script type="text/javascript" src="/lecture2go-portlet/player/jwplayer-7.9.3/jwplayer.js"></script>
	<script type="text/javascript">jwplayer.key="201IIc3/RasApk0L1+d1fv9pi5UCUsF6VvHj1C+EfkI=";</script>
	
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

<body>
	<%if(video.getVideoId()>0){ %>
		<div id="player1"></div>
		<script>
					var isCitation=false;
					// herausfinden ob es ein tablet/smartphone ist
			        var isTouchDevice = 'ontouchstart' in document.documentElement;
					
			        // Start- und Endzeit der Zitatfunktion ermitteln (Durch die URL Parameter)
			        var fs=<%=start%>;
			        var fe= <%=end%>;
			        
			        if(fs>0 && fe>0 && fe>fs){
				        var frameStart = <%=start%>;
				        var frameEnd = <%=end%>;
				        isCitation = true;
			        }
			        
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
			        }).onReady(function() {

			            if (frameStart && frameEnd) {
			                // Sollten sich die Start- und Endzeit in den URL Parametern befinden
			                // wird in diesen Abschnitt dafür gesorgt das man auch nur das Entsprechende
			                // Videomaterial zu sehen bekommt


			                // iOS und Android unterstützen seek nur wenn der Nutzer
			                // selbst manuell das vide gestartet hat. Wir werden den start des Zitates
			                // später anders lösen
			                if (!isTouchDevice) {
			                	jwplayer().on('firstFrame', function() { 
			                		jwplayer().play();
			                		jwplayer().seek(frameStart);
			                	});
			                }
			            }
			                
			            // Event listener alle 100 ms während playback
			            jwplayer().onTime( function(event){

			                // Sicher stellen, dass der gewählte Zeitraum eingehalten wird

			                var pos =  Math.floor(event.position);

			                if (pos < frameStart && isTouchDevice) {
			                    // Nur unter iOS und Android nötig,
			                    jwplayer().seek(frameStart);
			                } else if (pos > frameEnd) {
			                    jwplayer().seek(frameStart);
			                    jwplayer().pause();
			                }
			            });

			            // Diese Stelle ist wiederum nur auf PC nötig.
			            // Hiermit wird verhindert, dass der Nutzer per Tastatur
			            // aus den Zitatsbereich herausspult
			            if (!isTouchDevice) {
			                jwplayer().onSeek( function(event){
			                    var pos =  event.position;

			                    if (Math.ceil(pos) < Math.ceil(frameStart) || Math.ceil(pos) > Math.ceil(frameEnd)) {
			                        jwplayer().seek(frameStart);
			                        jwplayer().pause();
			                    }
			                });
			            }

			            $('#fullVideo').show();

			        });
			        //
			        var tit="Lecture2Go";
			        if(isCitation){
			        	tit="Zitat2Go";
			        }
			        jwplayer().addButton(
			        	"", 
			        	"Dieses Video auf Lecture2Go ansehen",
			        	function() {
			        		//stop player
			        		jwplayer().stop();
			        		//open web site
			        		<%
			        			String url = "";
			        			if(video.getOpenAccess()==1)url=video.getUrl();
			        			else url=video.getSecureUrl();
			        		%>
			                window.open('<%=url%>');
			            },
			            tit
			        )
								        
		</script>
	<%}%>
</body>
</html>
