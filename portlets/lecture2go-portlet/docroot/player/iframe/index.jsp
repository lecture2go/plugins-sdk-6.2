<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org   /TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="/lecture2go-portlet/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/lecture2go-portlet/player/jwplayer-7.12.13/jwplayer.js"></script>
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
	<script type="text/javascript">
		function getOpenAccess(){
			console.log("sgsdfg");
			var oa = $("#openaccess").attr('value');
			return oa;
		}
		function getParentUrl() {
		    var isInIframe = (parent !== window),
		        parentUrl = "null";
		    if (isInIframe) {
		        parentUrl = document.referrer;
		    }
		    return parentUrl;
		}

		function securityCheck(){
			if(getOpenAccess().indexOf("1")>-1){
				//load page
			}else{
				//stop loading page if not uni request
				if(getParentUrl().indexOf("uni-hamburg")==-1 || getParentUrl().indexOf("null")==0){
					window.stop();
					document.write('<script type="text/undefined">')
				}
			}
		}
		$(document).ready(function(){
			securityCheck();
		});

	</script>
	<!-- Piwik -->
		<script type="text/javascript">
		 var _paq = _paq || [];
		 // tracker methods like "setCustomDimension" should be called before "trackPageView"
		 _paq.push(['trackPageView']);
		 _paq.push(['enableLinkTracking']);
		 (function() {
		   var u="//www.piwik.uni-hamburg.de/";
		   _paq.push(['setTrackerUrl', u+'piwik.php']);
		   _paq.push(['setSiteId', '137']);
		   var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
		   g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
		 })();
		</script>
	<!-- End Piwik Code -->
</head>

<%@ page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil"%>
<%@ page import="de.uhh.l2g.plugins.model.Video"%>
<%@ page import="de.uhh.l2g.plugins.model.impl.VideoImpl"%>

<%
	Video video = new VideoImpl();
	Long videoId = new Long(0);
	String start = null;
	String end = null;
	String[] al = new String[3];
	String[] s = new String[3];

	try{//parameter is long
		videoId = new Long(request.getParameter("v"));
	}catch(NumberFormatException e){//parameter is path
		al = request.getParameter("v").split("/");
		// it can be on open access or closed access video !!!

		//for a closesed access video, check this
		//don't forget cases in commsy like this -> 37l2gbar8265/00.000_video-22005_2017-10-06_13-00.mp4
		if(al.length==1){
			int t =  al[0].split("_").length;
			if(t==4)videoId = VideoLocalServiceUtil.getByFilename(al[0]).iterator().next().getVideoId();
			else videoId = VideoLocalServiceUtil.getBySecureUrl(al[0]).getVideoId();
		}
		if(al.length==2){
			int t =  al[1].split("_").length;
			if(t==4)videoId = VideoLocalServiceUtil.getByFilename(al[1]).iterator().next().getVideoId();
			else videoId = VideoLocalServiceUtil.getBySecureUrl(al[1]).getVideoId();
		}

		//has time parameters
		if(al.length==3){
			try{
				s = request.getQueryString().split("/");
				videoId = new Long(s[0].split("=")[1]);
				start = s[1];
				end = s[2];
			}catch(Exception a){}
		}
	}
	//only for open access and requests from CommSy accesseble
	video = VideoLocalServiceUtil.getFullVideo(videoId);
%>
<body>
<input type="hidden" id="openaccess" name="openaccess" value="<%=video.getOpenAccess()%>">

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
			                // wird in diesen Abschnitt daf�r gesorgt das man auch nur das Entsprechende
			                // Videomaterial zu sehen bekommt


			                // iOS und Android unterst�tzen seek nur wenn der Nutzer
			                // selbst manuell das vide gestartet hat. Wir werden den start des Zitates
			                // sp�ter anders l�sen
			                if (!isTouchDevice) {
			                	jwplayer().on('firstFrame', function() {
			                		jwplayer().play();
			                		jwplayer().seek(frameStart);
			                	});
			                }
			            }

			            // Event listener alle 100 ms w�hrend playback
			            jwplayer().onTime( function(event){

			                // Sicher stellen, dass der gew�hlte Zeitraum eingehalten wird

			                var pos =  Math.floor(event.position);

			                if (pos < frameStart && isTouchDevice) {
			                    // Nur unter iOS und Android n�tig,
			                    jwplayer().seek(frameStart);
			                } else if (pos > frameEnd) {
			                    jwplayer().seek(frameStart);
			                    jwplayer().pause();
			                }
			            });

			            // Diese Stelle ist wiederum nur auf PC n�tig.
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