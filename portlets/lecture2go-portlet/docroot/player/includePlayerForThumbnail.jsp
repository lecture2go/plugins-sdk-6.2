<script type="text/javascript">jwplayer.key="201IIc3/RasApk0L1+d1fv9pi5UCUsF6VvHj1C+EfkI=";</script>
<script>
var player = jwplayer('player1');

    $(function() {
        // herausfinden ob es ein tablet/smartphone ist
        var isTouchDevice = 'ontouchstart' in document.documentElement;

        // Die Adresse des Web- und Videoservers ermitteln
        var server = "#";

        var playerUri1 ="${video.playerUris.get(0)}";
        var playerUri2 ="${video.playerUris.get(1)}";
        var playerUri3 ="${video.playerUris.get(2)}";
        var playerUri4 ="${video.playerUris.get(3)}";
        var playerUri5 ="${video.playerUris.get(4)}";

        //hack for HLS in firefox and mp3
        var containerFormat = "${video.containerFormat}";
        var isFirefox = typeof InstallTrigger !== 'undefined';
        var downloadAllowed = "${video.downloadLink}";
        if(containerFormat.indexOf("mp3") !== -1 && isFirefox && downloadAllowed.indexOf("1")!==-1){
        	var playerUri = playerUri1;
        	playerUri1 = playerUri3;
        	playerUri3 = playerUri;
        }
        //
        
		var vttFile ="${video.vttChapterFile}";

		
        // Hier wird der JW-Player initialisiert
        // Interessant ist hierbei, dass es mehrere Quellen geben kann
        jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            image: "${video.image}",
            sources: [
            	{ file: playerUri1 },
            	{ file: playerUri2 },
            	{ file: playerUri3 },
            	{ file: playerUri4 },
            	{ file: playerUri5 }
            ],
            tracks: [{
                file: vttFile,
                kind:'chapters'
            }],
            hlshtml: true,
            androidhls: true
        });

        //update player
	    player = jwplayer('player1');
    });
</script>

<div id="player1"></div>


