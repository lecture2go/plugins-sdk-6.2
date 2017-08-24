<script type="text/javascript">jwplayer.key="";</script>

<script>
var player = jwplayer('player1');

var playerUri1 =getJSONVideo().playerUris["url0"];
var playerUri2 =getJSONVideo().playerUris["url1"];
var playerUri3 =getJSONVideo().playerUris["url2"];
var playerUri4 =getJSONVideo().playerUris["url3"];
var playerUri5 =getJSONVideo().playerUris["url4"];

var videoImage =getJSONVideo().thumbnail;

var vttFile ="${video.vttChapterFile}";

    $(function() {
        // herausfinden ob es ein tablet/smartphone ist
        var isTouchDevice = 'ontouchstart' in document.documentElement;

        // Die Adresse des Web- und Videoservers ermitteln
        var server = "#";

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
        initializePlayer();
    });
    
    function initializePlayer(){
        //update player 
        playerUri1 =getJSONVideo().playerUris["url0"];
        playerUri2 =getJSONVideo().playerUris["url1"];
        playerUri3 =getJSONVideo().playerUris["url2"];
        playerUri4 =getJSONVideo().playerUris["url3"];
        playerUri5 =getJSONVideo().playerUris["url4"];
           
        videoImage =getJSONVideo().thumbnail;
        
        // Hier wird der JW-Player initialisiert
        // Interessant ist hierbei, dass es mehrere Quellen geben kann
        jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            image: videoImage,
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
    }
    
    function getJSONVideo() {
    	var video;
    	//set parameter to server for update 
    	$.ajax({
    		  type: "POST",
    		  url: "<%=getJSONVideoURL%>",
    		  dataType: 'json',
    		  data: {
    		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
    		  },
    		  global: false,
    		  async:false,
    		  success: function(data) {
    			  video=data;
    		  }
    	});
    	return video;
    }
</script>

<div id="player1"></div>


