<script type="text/javascript">jwplayer.key="Ez+YMIX4GOdXtP/v87cdP4FQuVY2dvNrQluq/w==";</script>
<script>
    $(function() {
        // herausfinden ob es ein tablet/smartphone ist
        var isTouchDevice = 'ontouchstart' in document.documentElement;

        // Die Adresse des Web- und Videoservers ermitteln
        var server = "#";

        // Diese Funktion wird genutzt um die Url Parameter auszulesen
        var getUrlParameter = function(sParam){
            var sPageURL = window.location.search.substring(1);
            var sURLVariables = sPageURL.split('&');
            for (var i = 0; i < sURLVariables.length; i++){
                var sParameterName = sURLVariables[i].split('=');
                if (sParameterName[0] == sParam){
                    return sParameterName[1];
                }
            }
        };

        // Diese Funktion benutzen wir später zum Formatieren von Zeitangaben
        var secondsToTime = function(secs) {
            var sec_num = parseInt(secs, 10);
            var hours   = Math.floor(sec_num / 3600);
            var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
            var seconds = sec_num - (hours * 3600) - (minutes * 60);

            if (hours   < 10) {hours   = "0"+hours;}
            if (minutes < 10) {minutes = "0"+minutes;}
            if (seconds < 10) {seconds = "0"+seconds;}
            return hours+':'+minutes+':'+seconds;
        };

        // Start- und Endzeit der Zitatfunktion ermitteln (Durch die URL Parameter)
        var frameStart = getUrlParameter('start');
        var frameEnd = getUrlParameter('end');
		
        var containerFormat = "${video.containerFormat}";
        var desctopStreamUrl ="${video.streamUrl}";
		var mobileStreamUrl ="${video.streamAndroidUrl}";
		var openAccessDownloadLink ="";
		if(containerFormat=="mp4"){
			openAccessDownloadLink = "${video.mp4OpenAccessDownloadLink}";
		}else{
			openAccessDownloadLink = "${video.mp3OpenAccessDownloadLink}";
		}
		var vttFile ="${video.vttChapterFile}";
		
        // Hier wird der JW-Player initialisiert
        // Interessant ist hierbei, dass es mehrere Quellen geben kann
        jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            image: "${video.image}",
            sources: [
            	{ file: mobileStreamUrl },
            	{ file: desctopStreamUrl },
				{ file: openAccessDownloadLink }
            ],
            tracks: [{
                file: vttFile,
                kind:'chapters'
            }],
            primary: "flash",
            androidhls: true,

            // Die Skin wird hier geladen. Im Zitatmodus wird eine andere Skin genutzt
            // die über keine Zeitleiste verfügt
            skin: ((frameStart && frameEnd) ?
                    '/lecture2go-portlet/player/jwplayer/skins/six/six_nobar.xml' :
                    '/lecture2go-portlet/player/jwplayer/skins/six/six.xml')
        }).onReady(function() {

            // Mit diesen Objekt werden die Kapitel definiert
            var chapters = [
                {
                    title: 'Intro',
                    start: 0,
                    end: 20
                },
                {
                    title: 'Kapitel 1',
                    start: 20,
                    end: 40
                },
                {
                    title: 'Rest',
                    start: 40,
                    end: 60
                }
            ];
            
         	// Inputfelder fuer Start und Ende der Zitate / Kapitel speichern 
            var $inputTimeStart = $("#<portlet:namespace></portlet:namespace>timeStart").val("");
            var $inputTimeEnd = $("#<portlet:namespace></portlet:namespace>timeEnd").val("");
            var $citation = $("#<portlet:namespace></portlet:namespace>citation").val("");
            
            var chapterListElement = $('#chapters');

            if (frameStart && frameEnd) {
                // Sollten sich die Start- und Endzeit in den URL Parametern befinden
                // wird in diesen Abschnitt dafür gesorgt das man auch nur das Entsprechende
                // Videomaterial zu sehen bekommt


                // iOS und Android unterstützen seek nur wenn der Nutzer
                // selbst manuell das vide gestartet hat. Wir werden den start des Zitates
                // später anders lösen
                if (!isTouchDevice) {
                    jwplayer().seek(frameStart);
                    jwplayer().pause();
                }

                // Dieser Even-Listener wird kontinuierlich aufgerufen
                // und sorgt dafür, das der gewählte Zeitraum eingehalten wird
                jwplayer().onTime( function(event){
                    var pos =  event.position;


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
            } else {
                // In diesen Abschnitt wird der Standard-Modus
                // initalisiert.

                //Dazu werden die Kapitel erst einmal für den Nutzer sichtbar abgelegt
                for (var i = 0, n = chapters.length; i < n; i++) {
                    var cur = chapters[i];

                    chapterListElement.append('<li id="chapter'+i+'" data-start="'+cur.start+'" data-end="'+cur.end+'">' + cur.title + '</li>');
                }

                // Sollte der Nutzer auf die Kapitel klicken,
                // wird zur entsprechenden Stelle gesprungen
                chapterListElement.find('li').on('click', function(event) {
                    jwplayer().seek($(event.target).attr('data-start'));
                });


                // In diesen Block wird ca. alle 100 Millisekunden geprüft
                // in welchen Kapitel wir uns befinden
                jwplayer().onTime( function(event){
                    var pos =  event.position;

                    for (var i = 0, n = chapters.length; i < n; i++) {
                        var cur = chapters[i];

                        if (pos > cur.start && pos < cur.end) {
                            chapterListElement.find('li:not(#chapter'+i+')').removeClass('active');
                            chapterListElement.find('li#chapter'+i).addClass('active');
                        }
                    }
                });


                // Im nachfolgenden Abschnitt wird den Nutzer ermöglicht
                // eigene Zitate zu erstellen und zu teilen
                var player = jwplayer();

                var startFrameTime = undefined;
                var endFrameTime = undefined;
                var startTimeStr = undefined;
                var entTimeStr = undefined;
                

                // Benutzer setzt Start des Clips
                $inputTimeStart.click(function() {
                	startFrameTime = Math.round(player.getPosition());
                    startTimeStr = secondsToTime(Math.floor(startFrameTime));

                    $inputTimeStart.val(startTimeStr);
                    
                    if (startFrameTime && endFrameTime) {
                    	// Falls Startzeit nach Endzeit liegt, Zeiten angleichen
                    	if (startFrameTime > endFrameTime) {
                    		endFrameTime = startFrameTime;
                    		endTimeStr = secondsToTime(Math.floor(endFrameTime));
                    		$inputTimeEnd.val(endTimeStr);
                    		
                    	}
                    	generateClipLink (startFrameTime, endFrameTime);
                    	console.log("start: " + startFrameTime + ", end: " + endFrameTime);
                    }
                });

                // Benutzer setzt Ende des Clips
                $inputTimeEnd.click(function() {
                	endFrameTime = Math.round(player.getPosition());
                    EndTimeStr = secondsToTime(Math.floor(endFrameTime));

                    $inputTimeEnd.val(EndTimeStr);

                    if (startFrameTime && endFrameTime) {
                    	// Falls Startzeit nach Endzeit liegt, Zeiten angleichen
                    	if (startFrameTime > endFrameTime) {
                    		startFrameTime = endFrameTime;
                    		startTimeStr = secondsToTime(Math.floor(startFrameTime));
                    		$inputTimeStart.val(startTimeStr);
                    		
                    	}
                    	generateClipLink (startFrameTime, endFrameTime);
                    	console.log("start: " + startFrameTime + ", end: " + endFrameTime);
                    }
                });
                
                function generateClipLink (firstFrame, lastFrame) {
                	$citation.val("${video.url}"+"/"+firstFrame+"/"+lastFrame);
                }

            }
        });
    });

</script>

<div id="player1"></div>


