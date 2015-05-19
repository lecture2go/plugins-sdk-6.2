<%@include file="/init.jsp"%>

<jsp:useBean id="video" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="relatedVideos" type="java.util.List<de.uhh.l2g.plugins.model.Video>" scope="request" />
<jsp:useBean id="segments" type="java.util.List<de.uhh.l2g.plugins.model.Segment>" scope="request" />
<jsp:useBean id="videoLectureseries" type="java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries>" scope="request" />
<jsp:useBean id="videoInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />
<jsp:useBean id="videoMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="lectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="videoLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />

<div class="col-xs-10 col-md-10">
    <div id="pfad">
    	<%
    	if(video.getLectureseriesId()>0){
	    	for(int i=0; i<videoLectureseries.size(); i++){
	    		Lectureseries lec = LectureseriesLocalServiceUtil.getLectureseries(videoLectureseries.get(i).getLectureseriesId());
	    		List<Institution> institutions = InstitutionLocalServiceUtil.getByLectureseriesId(lec.getLectureseriesId(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	    		for(int j=0; j<institutions.size(); j++){
	    			Institution insti = InstitutionLocalServiceUtil.getById(institutions.get(j).getInstitutionId());    			
	    			Institution pInst = InstitutionLocalServiceUtil.getById(institutions.get(j).getParentId());
		    		%>
			    	<A HREF="#" CLASS="apath"><%=pInst.getName() %></A><span class="sep">&gt;</span> <A HREF="#" CLASS="apath"><%=insti.getName() %></A> 
			    	<%if(lec.getLectureseriesId()>0) {%>
			    		<span class="sep">&gt;</span> <SPAN CLASS="paththispage"><%=lec.getName()%></SPAN>
			    	<%}%>
			    	<br/>
	    		<%}
	    	}
    	}else{
	    	for(int i=0; i<videoInstitutions.size(); i++){
	    		Institution insti = InstitutionLocalServiceUtil.getById(videoInstitutions.get(i).getInstitutionId());    			
	    		Institution pInst = InstitutionLocalServiceUtil.getById(videoInstitutions.get(i).getInstitutionParentId());
		    	%>
			    <A HREF="#" CLASS="apath"><%=insti.getName() %></A><span class="sep">&gt;</span> <A HREF="#" CLASS="apath"><%=pInst.getName() %></A>
			    <br/> 
	      <%}  		
    	}
    	%>
    </div>
</div>
    
<div class="col-md-7" style="margin-bottom:10px">
    <div id="main" >
      <h3 style="margin-top:10px; margin-bottom:2px">${video.title}</h3>
      <h5 data-date="12.11.2013" style="margin-top:0px; margin-bottom:10px">${video.creators}</h5>
      <h5 style="margin-top:0px;">${lectureseries.name}</h5>
		
	  <%if(videoMetadata.getDescription().trim().length()>0){ %>	
	  	<p>${videoMetadata.description}</p>
	  <%}else{%>
      	<p>${lectureseries.longDesc}</p>
	  <%}%>
	  
	  <p><br /></p>

      <span>
        <%if(videoLicense.getL2go()==1){%>
        	<a href="#"><img id="myTooltip" title="lecture2Go-license-click-for-info" src="/lecture2go-portlet/img/l2go-lizenz-88x31.png" style="width:50px; opacity:0.5; float:right; margin-top:5px; margin-right:2px;"/></a>
 		<%}else{%>
			<a href="#"><img id="myTooltip" title="cc-license-click-for-info" src="/lecture2go-portlet/img/lizenz_cc.png" style="width:20px; opacity:0.5; float:right; margin-top:5px; margin-right:2px;"/></a> 		
 		<%}%>       
      </span>
      <span class="label label-light" style="float:right; margin-top:6px; margin-right:5px;">${video.hits} views</span>
    </div>
    <div id="meta">
		<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
		    <c:if test="${video.downloadLink==1}">
			    <li><a href="#download" data-toggle="tab">Download</a></li>
		    </c:if>
		    <li><a href="#share" data-toggle="tab">Share</a></li>
		    <li><a href="#support" data-toggle="tab">Support</a></li>
		</ul>
		    
		<div id="my-tab-content" class="tab-content">
			<c:if test="${video.downloadLink==1}">
				<div class="tab-pane" id="download">
			        <p><%@ include file="/guest/includeDownload.jsp" %></p>
			    </div>
			</c:if>
		    <div class="tab-pane" id="share">
		        <p><%@ include file="/guest/includeShare.jsp" %></p>
		    </div>
		    <div class="tab-pane" id="support">
		        <p><%@ include file="/guest/includeContact.jsp" %></p>
		    </div>
		</div>    
	</div>
</div>

<c:if test="${relatedVideos.size()>0}">
	<div id="additional" class="col-md-5">
	    <h4 style="margin-top:0px; float:left;">Veranstaltungsreihe</h4> &nbsp;
		<a target="_blank" class="icon-large icon-rss" href="${video.mp4RssLink}"></a>
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
</c:if>

<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $('#tabs').tab();
    });
</script>    