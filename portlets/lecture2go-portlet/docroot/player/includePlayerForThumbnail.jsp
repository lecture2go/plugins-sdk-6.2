<script type="text/javascript">jwplayer.key="qKvU61clkb6v98R2Yoc/cL6x7dFfJ3we+r6nxD6iB0Q=";</script>

<script>

    $(function() {
    	initializePlayer();
    });
    
    function initializePlayer(){
        jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            image: getJSONVideo().thumbnail,
            sources: $.parseJSON(getJSONVideo().playerUris),
            hlshtml: true,
            androidhls: true
        });
    }
    
    function getJSONVideo() {
    	var video;
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