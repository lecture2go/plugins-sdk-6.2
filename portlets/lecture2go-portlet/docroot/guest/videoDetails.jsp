<%@include file="/init.jsp"%>

<jsp:useBean id="video" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="relatedVideos" type="java.util.List<de.uhh.l2g.plugins.model.Video>" scope="request" />
<jsp:useBean id="segments" type="java.util.List<de.uhh.l2g.plugins.model.Segment>" scope="request" />
<jsp:useBean id="videoLectureseries" type="java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries>" scope="request" />
<jsp:useBean id="videoInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />
<jsp:useBean id="videoMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="lectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="videoLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="objectType" type="java.lang.String" scope="request" />
<jsp:useBean id="objectId" type="java.lang.String" scope="request" />

<jsp:useBean id="timeStart" type="java.lang.Long" scope="request" />
<jsp:useBean id="timeEnd" type="java.lang.Long" scope="request" />

<%if(video.getVideoId()>0){%>
<%if(video.getAccessPermitted()==1){%>
	
	<%if(video.getOpenAccess()==1){%>
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
							<portlet:actionURL var="backURL1" name="addFilter">
								<portlet:param name="jspPage" value="/guest/videosList.jsp" />
								<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
								<portlet:param name="institutionId" value="0"/>
								<portlet:param name="termId" value="0"/>
								<portlet:param name="categoryId" value="0"/>
								<portlet:param name="creatorId" value="0"/>
							</portlet:actionURL>					
							<portlet:actionURL var="backURL2" name="addFilter">
								<portlet:param name="jspPage" value="/guest/videosList.jsp" />
								<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
								<portlet:param name="institutionId" value="<%=insti.getInstitutionId()+\"\"%>"/>
								<portlet:param name="termId" value="0"/>
								<portlet:param name="categoryId" value="0"/>
								<portlet:param name="creatorId" value="0"/>
							</portlet:actionURL>	
							
					    	<A HREF="<%=backURL1%>" CLASS="apath"><%=pInst.getName() %></A> <span class="sep">&gt;</span> 
					    	<A HREF="<%=backURL2%>" CLASS="apath"><%=insti.getName() %></A> 
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
							<portlet:actionURL var="backURL3" name="addFilter">
								<portlet:param name="jspPage" value="/guest/videosList.jsp" />
								<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
								<portlet:param name="institutionId" value="0"/>
								<portlet:param name="termId" value="0"/>
								<portlet:param name="categoryId" value="0"/>
								<portlet:param name="creatorId" value="0"/>
							</portlet:actionURL>					
							<portlet:actionURL var="backURL4" name="addFilter">
								<portlet:param name="jspPage" value="/guest/videosList.jsp" />
								<portlet:param name="parentInstitutionId" value="<%=pInst.getInstitutionId()+\"\"%>"/>
								<portlet:param name="institutionId" value="<%=insti.getInstitutionId()+\"\"%>"/>
								<portlet:param name="termId" value="0"/>
								<portlet:param name="categoryId" value="0"/>
								<portlet:param name="creatorId" value="0"/>
							</portlet:actionURL>		    	
					    	<A HREF="<%=backURL3%>" CLASS="apath"><%=pInst.getName() %></A> <span class="sep">&gt;</span> 
					    	<A HREF="<%=backURL4%>" CLASS="apath"><%=insti.getName() %></A>
					    	<br/> 
			      <%}  		
		    	}
		    	%>
		    </div>
		</div>
	<%}%>
	    
	<div class="col-md-7" style="margin-bottom:10px">
	    <div id="main" >
		  <%
		    String title = video.getTitle();
		  	if(timeStart>0 && timeEnd>timeStart && video.getCitation2go()==1){
				title ="citation-of "+title;
		  	}
		  %>
	      <h3 style="margin-top:10px; margin-bottom:2px"><%=title%></h3>
	      <%
		    if(timeEnd>0 && timeEnd>timeStart && video.getCitation2go()==1){
		      %>
		      	<aui:a href="<%=video.getUrl()%>" >go-to-full-video</aui:a>
		      <%
		    }
	      %>
		  <p>
		      <div class="player">
					<%@ include file="/player/includePlayer.jsp"%>
			  </div>
		  </p>	
	      <h5 data-date="12.11.2013" style="margin-top:0px; margin-bottom:10px">${video.creators}</h5>
	      <h5 style="margin-top:0px;">${lectureseries.name}</h5>
		  
		  <%if(videoMetadata.getDescription().trim().length()>0){ %>	
		  	<p>${videoMetadata.description}</p>
		  <%}else{%>
	      	<p>${lectureseries.longDesc}</p>
		  <%}%>
	      
	      <span>
	        <%if(videoLicense.getL2go()==1){%>
	        	<a href="#"><img id="myTooltip" title="lecture2Go-license-click-for-info" src="/lecture2go-portlet/img/l2go-lizenz-88x31.png" style="width:50px; opacity:0.5; float:right; margin-top:5px; margin-right:2px;"/></a>
	 		<%}else{%>
				<a href="#"><img id="myTooltip" title="cc-license-click-for-info" src="/lecture2go-portlet/img/lizenz_cc.png" style="width:20px; opacity:0.5; float:right; margin-top:5px; margin-right:2px;"/></a> 		
	 		<%}%>       
	      </span>
	      <span class="label label-light" style="float:right; margin-top:6px; margin-right:5px;">${video.hits} views</span>
	    </div>
	    
	    <%
	    if(timeEnd==0 || timeEnd<timeStart || video.getCitation2go()==0){
		%>
		    <div id="meta">
				<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
				    <c:if test="${video.downloadLink==1}">
					    <li><a href="#download" data-toggle="tab">Download</a></li>
				    </c:if>
				    <%if(video.getOpenAccess()==1){%>
				   	 	<li><a href="#share" data-toggle="tab">Share</a></li>
				    <%}%>
				    <li><a href="#support" data-toggle="tab">Support</a></li>
				</ul>
				    
				<div id="my-tab-content" class="tab-content">
					<c:if test="${video.downloadLink==1}">
						<div class="tab-pane" id="download">
					        <p><%@ include file="/guest/includeDownload.jsp" %></p>
					    </div>
					</c:if>
					<%if(video.getOpenAccess()==1){%>
					    <div class="tab-pane" id="share">
					        <p><%@ include file="/guest/includeShare.jsp" %></p>
					    </div>
				    <%}%>
				    <div class="tab-pane" id="support">
				        <p>
							<%
								Integer facultyId = (int)video.getRootInstitutionId();
								String institut = "";
								String option1 = PortalUtil.getOriginalServletRequest(request).getParameter("option1"); 
								
								switch(facultyId){
									case 3: institut = "UHH-Jura";break;
									case 4: institut = "UHH-WiSo";break;
									case 5: institut = "UHH-Medizin";break;
									case 6: institut = "UHH-EW";break;
									case 7: institut = "UHH-GWiss";break;
									case 8: institut = "UHH-MIN";break;
									case 203: institut = "UHH-PB";break;
									case 204: institut = "UHH-BWL";break;
									default: institut = "Fakultätübergreifend";break;
								}
								
								JSONObject jsn = new JSONObject();
								jsn.put("institution",institut);
								jsn.put("system","Lecture2Go");
								jsn.put("role","Lecture2Go-Benutzer");
								jsn.put("gender","");
								jsn.put("firstname",PortalUtil.getOriginalServletRequest(request).getParameter("firstname"));
								jsn.put("lastname",PortalUtil.getOriginalServletRequest(request).getParameter("lastname"));
								jsn.put("email",PortalUtil.getOriginalServletRequest(request).getParameter("email"));
								jsn.put("subject",video.getUrl());
								jsn.put("body",PortalUtil.getOriginalServletRequest(request).getParameter("body"));
								jsn.put("ergebnis",PortalUtil.getOriginalServletRequest(request).getParameter("ergebnis"));
								jsn.put("option1",option1);
								jsn.put("result",PortalUtil.getOriginalServletRequest(request).getParameter("result"));
								jsn.put("spamprotect",PortalUtil.getOriginalServletRequest(request).getParameter("spamprotect"));
							%>
							<div id="metadata">
								<%
									String url=video.getUrl();
									if(video.getOpenAccess()==0)url=video.getSecureUrl();
									SupportFormularClient sfc = new SupportFormularClient("mail4eLearnSupport",url,jsn.toString(),"");
									out.print(sfc.getFormular());
								%>
								
								<% 
									// If support form was submitted, insert Javascript code for scrolling down
									if(option1!=null){
										%>
										<script type="text/javascript">
											$(function() {
												 // activate contact tab
												 $("#tabs").tabs().tabs( "option", "active", $('#tabs >ul >li').size()-1 );
												 
												 var aTag = $("a[href='#support']");
												 $('html,body').animate({scrollTop: aTag.offset().top},'slow');
											 });
										</script>
										<%		
									}
								%>
							</div>		        
				    </div>
				</div>    
			</div>
		<%
		}
	    %>
	</div>
	
	<%
	if(timeEnd==0 || timeEnd<timeStart || video.getCitation2go()==0){
	%>
		<c:if test="${relatedVideos.size()>0}">
			<div id="additional" class="col-md-5">
			    <h4 style="margin-top:0px; float:left;">Veranstaltungsreihe</h4> &nbsp;
				<a target="_blank" class="icon-large icon-rss" href="${video.mp4RssLink}"></a>
				<br/><br/>
				 <div class="list-group" style="margin: 5px;">
					<c:forEach items="${relatedVideos}" var="vid">
						<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL">
							<c:if test="${vid.openAccess==1}"><portlet:param name="objectId" value="${vid.videoId}"/></c:if>
							<c:if test="${vid.openAccess==0}"><portlet:param name="objectId" value="${vid.getSPreffix()}"/></c:if>
							<portlet:param name="objectType" value="v"/>
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
	<%
	}
}else{
	%>
	<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL">
		<portlet:param name="objectId" value="<%=objectId%>"/>
		<%if(objectType.equals("v")){%><portlet:param name="objectType" value="v"/><%}%>
		<%if(objectType.equals("l")){%><portlet:param name="objectType" value="l"/><%}%>
	</portlet:actionURL>
	<aui:form action="<%=viewOpenAccessVideoURL.toString() %>" method="post">
		<aui:fieldset helpMessage="enter-password" column="true" label='<%="l2go-video-password"%>'>
			<aui:input name="password" label="password" required="true" value=""/>
			
			<aui:button-row>
				<aui:button type="submit"/>
			</aui:button-row>
		</aui:fieldset>
	</aui:form>	
	<%
}
%>
<%
}
%>
<script type="text/javascript">
    $( function () {
        $('#tabs').tabs();
    });
</script>    