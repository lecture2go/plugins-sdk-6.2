<script type="text/javascript">jwplayer.key="qKvU61clkb6v98R2Yoc/cL6x7dFfJ3we+r6nxD6iB0Q="</script>

<style>
<!--
.jw-reset.jw-settings-content-item {
    line-height: 13px;
}

.jw-breakpoint-4 .jw-settings-menu, .jw-breakpoint-3 .jw-settings-menu {
    width: 220px;
}

.jwplayer .jw-rightclick.jw-open {
    display: none;
}
-->
</style>

<script>
$(function() {
    // herausfinden ob es ein tablet/smartphone ist
    var isTouchDevice = 'ontouchstart' in document.documentElement;

	var vttFile ="${video.vttChapterFile}";



    
    // Hier wird der JW-Player initialisiert
    // Interessant ist hierbei, dass es mehrere Quellen geben kann
    jwplayer('player1').setup({
        width: "100%",
        aspectratio: "16:9",
        playbackRateControls: [0.75, 1, 1.25, 1.5],
        image: "${reqVideo.image}",
        cast: {},
        sources: ${video.jsonPlayerUris},
        tracks: [{
             file: vttFile,
             kind:'chapters'
        }],
        hlshtml: true,
        androidhls: true
    });

    
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
});
</script>

<div id="player1"></div>


