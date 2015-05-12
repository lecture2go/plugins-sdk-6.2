<%@include file="/init.jsp"%>

<jsp:useBean id="video" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="relatedVideos" type="java.util.List<de.uhh.l2g.plugins.model.Video>" scope="request" />
<jsp:useBean id="segments" type="java.util.List<de.uhh.l2g.plugins.model.Segment>" scope="request" />
<jsp:useBean id="videoInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />
<jsp:useBean id="lectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />

<div class="col-md-7" style="margin-bottom:10px">
    <div id="main" >
      <h3 style="margin-top:10px; margin-bottom:2px">${video.title}</h3>
      <h5 data-date="12.11.2013" style="margin-top:0px; margin-bottom:10px">${video.creators}</h5>
      <h5 style="margin-top:0px;">${lectureseries.name}</h5>

      <p>${lectureseries.longDesc}</p>

	  <p><br /></p>
      <span id="togglerShare">
        <button class="btn btn-primary headerShare toggler-header-collapsed"><span class="glyphicon glyphicon-share" aria-hidden="true"></span> Teilen</button></a>
      </span>
      <span id="togglerDownload">
        <button class="headerDownload btn btn-primary toggler-header-collapsed"><span class="glyphicon glyphicon-download" aria-hidden="true"></span> Download</button>
      </span>

      <button id="showModal" class="btn btn-primary"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Support</button>

      <span>
        <a href="#"><img id="myTooltip" title="Creative Commons Lizenz. Für mehr Informationen klicken." src="/lecture2go-portlet/img/lizenz_cc.png" style="width:20px; opacity:0.5; float:right; margin-top:5px; margin-right:2px;"/></a>
      </span>
      <span class="label label-light" style="float:right; margin-top:6px; margin-right:5px;">${video.hits} views</span>

      <div class="contentShare toggler-content-collapsed">
        <h4>Teilen</h4>
        <p>Lorem ipsum dolor sit amet</p>
      </div>
      
      <div class="contentDownload toggler-content-collapsed">
        <h4>Download</h4>
        <p>Lorem ipsum dolor sit amet</p>
      </div>
      
      <div class="contentSupport toggler-content-collapsed">
        <h4>Kontakt</h4>
        <p>Lorem ipsum dolor sit amet</p>
      </div>
    </div>
</div>

<div id="additional" class="col-md-5">
    <h4 style="margin-top:0px; float:left;">Veranstaltungsreihe</h4>
	<a href="#"><img src="/lecture2go-portlet/img/rss.gif" style="margin-left:10px; margin-top:-4px;" /></a>
	<br/><br/>
	 <div class="list-group" style="margin: 5px;">
		<c:forEach items="${relatedVideos}" var="vid">
			<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL">
				<portlet:param name="videoId" value="${vid.videoId}"/>
				<portlet:param name="lectureseriesId" value="${vid.lectureseriesId}"/>
			</portlet:actionURL>		
			<c:choose>
			<c:when test="${video.videoId==vid.videoId}"><a href="#" class="list-group-item active" style="padding-left: 10px; padding-top: 5px; padding-bottom: 5px;"></c:when>
			<c:otherwise><a href="<%=viewOpenAccessVideoURL%>" class="list-group-item" style="padding-left: 10px; padding-top: 5px; padding-bottom: 5px;"></c:otherwise>
			</c:choose>	
		        <img class="preview" src="${vid.imageSmall}">
		        <h5 class="list-group-item-heading" style="margin-top:4px; margin-bottom:3px;">${vid.title}</h5>
		        <h5 style="margin-top:0px; margin-bottom:3px; font-size:80%;">${vid.creators}</h5>
		        <h5 style="margin-top:0px; margin-bottom:0px; font-size:80%;">${vid.date}</h5>			
			</a>
		</c:forEach>
	</div>
</div>

<script>
YUI().use(
  'aui-toggler',
  function(Y) {
    new Y.Toggler(
      {
        container: '#togglerShare',
        content: '.contentShare',
        expanded: false,
        header: '.headerShare'
      }
    );
  }
);

YUI().use(
  'aui-toggler',
  function(Y) {
    new Y.Toggler(
      {
        container: '#togglerDownload',
        content: '.contentDownload',
        expanded: false,
        header: '.headerDownload'
      }
    );
  }
);

$("#hidenav").click(function() {
  $( "#hide" ).toggleClass( "glyphicon-arrow-right glyphicon-arrow-left");
  $( "#additional" ).toggleClass( "hide");
  $( "#main" ).toggleClass( "col-md-7 col-md-12");

});

YUI().use(
  'aui-tooltip',
  function(Y) {
    new Y.TooltipDelegate(
      {
        trigger: '#myTooltip',
        position: 'top'
      }
    );
  }
);

YUI().use(
  'aui-modal',
  function(Y) {
     Y.one('#showModal').on(
      'click', function() {
        var modal = new Y.Modal(
          {
            bodyContent: 'Support Text',
            centered: true,
            headerContent: '<h4>Support</h4>',
            modal: true,
            render: '#modal',
            width: 450
          }
        );
      }
    )
 }
);
</script>