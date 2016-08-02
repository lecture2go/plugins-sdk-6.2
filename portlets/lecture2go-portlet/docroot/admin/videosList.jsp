<%@include file="/init.jsp"%>

<%
	List<Video> tempVideosList = new ArrayList<Video>();
	List<Coordinator> coordinators = new ArrayList<Coordinator>();
	List<Producer> producers = new ArrayList<Producer>();
	List<Lectureseries> lectureseries = new ArrayList<Lectureseries>();
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("coordinatorId", ServletRequestUtils.getLongParameter(request, "coordinatorId", 0)+"");
	portletURL.setParameter("producerId", ServletRequestUtils.getLongParameter(request, "producerId", 0)+"");
	portletURL.setParameter("lectureseriesId", ServletRequestUtils.getLongParameter(request, "lectureseriesId", 0)+"");

	Long coordinatorId = new Long(0);
	Long producerId = new Long(0);

	Long lectureseriesId = ServletRequestUtils.getLongParameter(request, "lectureseriesId", 0);
	if(permissionAdmin){
		coordinators = CoordinatorLocalServiceUtil.getAllCoordinators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		coordinatorId = ServletRequestUtils.getLongParameter(request, "coordinatorId", 0);
		producerId = ServletRequestUtils.getLongParameter(request, "producerId", 0);
		if(coordinatorId>0){
			Long institutionId = CoordinatorLocalServiceUtil.getCoordinator(coordinatorId).getInstitutionId();
			producers = ProducerLocalServiceUtil.getProducersByInstitutionId(institutionId);
			if(producerId==0)tempVideosList = VideoLocalServiceUtil.getByRootInstitution(institutionId);
			else {
				lectureseries = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, new Long(0), new Long(0), producerId);
				if(lectureseriesId==0) tempVideosList = VideoLocalServiceUtil.getByProducer(producerId);
				else tempVideosList = VideoLocalServiceUtil.getByProducerAndLectureseries(producerId, lectureseriesId);
			}
		}else{ 
			producerId = new Long(0);
			tempVideosList = VideoLocalServiceUtil.getVideos(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		}
	}else{
		if(permissionCoordinator){
			coordinatorId = remoteUser.getUserId();
			producerId = ServletRequestUtils.getLongParameter(request, "producerId", 0);
			Long institutionId = CoordinatorLocalServiceUtil.getCoordinator(coordinatorId).getInstitutionId();
			producers = ProducerLocalServiceUtil.getProducersByInstitutionId(institutionId);
			if(producerId>0){
				lectureseries = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, new Long(0), new Long(0), producerId);
				if(lectureseriesId==0)tempVideosList = VideoLocalServiceUtil.getByProducer(producerId);
				else tempVideosList = VideoLocalServiceUtil.getByProducerAndLectureseries(producerId, lectureseriesId);
			}else{
				tempVideosList = VideoLocalServiceUtil.getByRootInstitution(institutionId);
			}
		}else{
			if(permissionProducer){
				producerId = remoteUser.getUserId();
				if(lectureseriesId>0) tempVideosList = VideoLocalServiceUtil.getByProducerAndLectureseries(producerId, lectureseriesId);
				else tempVideosList = VideoLocalServiceUtil.getByProducer(producerId);
				lectureseries = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, new Long(0), new Long(0), producerId);
			}
		}
	}
	String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>
<div class="noresponsive">
	<label class="edit-video-lable"><%=pageName%></label>
	<aui:fieldset helpMessage="" column="true" cssClass="list">
				<%if(permissionAdmin){%>
								<portlet:renderURL var="sortByCoordinator">
									<portlet:param name="jspPage" value="/admin/videosList.jsp" />
									<portlet:param name="producerId" value="<%=producerId.toString()%>"/>
									<portlet:param name="lectureseriesId" value="<%=lectureseriesId.toString()%>"/>
								</portlet:renderURL>
								<aui:form action="<%= sortByCoordinator.toString() %>" method="post">
									<aui:select name="coordinatorId" label="" onChange="submit();">
										<aui:option value=""><liferay-ui:message key="select-coordinator"/></aui:option>
										<%for (int i = 0; i < coordinators.size(); i++) {
											if(coordinators.get(i).getCoordinatorId()==coordinatorId){%>
												<aui:option value='<%=coordinators.get(i).getCoordinatorId()%>' selected="true"><%=coordinators.get(i).getLastName()+", "+coordinators.get(i).getFirstName()%></aui:option>
											<%}else{%>
												<aui:option value='<%=coordinators.get(i).getCoordinatorId()%>'><%=coordinators.get(i).getLastName()+", "+coordinators.get(i).getFirstName()%></aui:option>
											<%}					
										}%>								
									</aui:select>
								</aui:form>	
					<%}%>
					<%if(permissionCoordinator || (permissionAdmin && coordinatorId>0)){%>		
								<portlet:renderURL var="sortByProducer">
									<portlet:param name="jspPage" value="/admin/videosList.jsp" />
									<portlet:param name="coordinatorId" value="<%=coordinatorId.toString()%>"/>
									<portlet:param name="lectureseriesId" value="<%=lectureseriesId.toString()%>"/>
								</portlet:renderURL>
								<aui:form action="<%= sortByProducer.toString() %>" method="post">
									<aui:select name="producerId" label="" onChange="submit();">
										<aui:option value=""><liferay-ui:message key="select-producer"/></aui:option>
										<%for (int i = 0; i < producers.size(); i++) {
											if(producers.get(i).getProducerId()==producerId){%>
												<aui:option value='<%=producers.get(i).getProducerId()%>' selected="true"><%=producers.get(i).getLastName()+", "+producers.get(i).getFirstName()%></aui:option>
											<%}else{%>
												<aui:option value='<%=producers.get(i).getProducerId()%>'><%=producers.get(i).getLastName()+", "+producers.get(i).getFirstName()%></aui:option>
											<%}					
										}%>									
									</aui:select>
								</aui:form>		
					<%}%>	
					<%if( ((permissionAdmin || permissionCoordinator) && producerId>0  && coordinatorId>0) || permissionProducer ){%>		
								<portlet:renderURL var="sortByLectureseries">
									<portlet:param name="jspPage" value="/admin/videosList.jsp" />
									<portlet:param name="coordinatorId" value="<%=coordinatorId.toString()%>"/>
									<portlet:param name="producerId" value="<%=producerId.toString()%>"/>
								</portlet:renderURL>
								<aui:form action="<%= sortByLectureseries.toString() %>" method="post">
									<aui:select name="lectureseriesId" label="" onChange="submit();">
										<aui:option value=""><liferay-ui:message key="select-lecture-series"/></aui:option>
										<%for (int i = 0; i < lectureseries.size(); i++) {
											if(lectureseries.get(i).getLectureseriesId()==lectureseriesId){%>
												<aui:option value='<%=lectureseries.get(i).getLectureseriesId()%>' selected="true"><%=lectureseries.get(i).getName()%></aui:option>
											<%}else{%>
												<aui:option value='<%=lectureseries.get(i).getLectureseriesId()%>'><%=lectureseries.get(i).getName()%></aui:option>
											<%}					
										}%>								
									</aui:select>
								</aui:form>				
					<%}%>
	</aui:fieldset>
	
	<%if(producerId>0){%>	
		<br/>
		<portlet:actionURL name="addVideo" var="addVideoURL">
			<portlet:param name="lectureseriesId" value='<%=lectureseriesId+""%>'/>
				<portlet:param name="producerId" value='<%=producerId+""%>'/>
				<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>	
			</portlet:actionURL>	
			<a href="<%=addVideoURL.toString()%>" class="add-link">
			    <liferay-ui:message key="add-video"/> <span class="icon-large icon-plus-sign"/>
			</a>
	<%}%>
	
	<liferay-ui:search-container emptyResultsMessage="no-videos-found" delta="10"  iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
				results = ListUtil.subList(tempVideosList, searchContainer.getStart(), searchContainer.getEnd());
				total = tempVideosList.size();
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
			%>
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Video" keyProperty="videoId" modelVar="video">
				<% 
					Video vid = VideoLocalServiceUtil.getFullVideo(video.getVideoId()); 
					String url = "";
					if(vid.getOpenAccess()==1)url=vid.getUrl();
					else url=vid.getSecureUrl();
				%>
				<portlet:actionURL name="viewVideo" var="viewURL">
					<portlet:param name="videoId" value="<%= String.valueOf(video.getVideoId())%>" />
				</portlet:actionURL>
				<liferay-ui:search-container-column-text name="">
						<div class="admintile wide">
						<%
							Lectureseries ls = new LectureseriesImpl();
							if(vid.getLectureseriesId()>0)ls = LectureseriesLocalServiceUtil.getLectureseries(vid.getLectureseriesId());
							String lName="";
							/* if(!ls.getNumber().equals(""))lName+=ls.getNumber()+" :"; */
							if(!ls.getName().equals(""))lName+=ls.getName();
							String lTerm="";
							if(ls.getTermId()>0)lTerm = TermLocalServiceUtil.getById(ls.getTermId()).getTermName();
							String vName = vid.getTitle();
							if(vName.trim().equals(""))vName =LanguageUtil.get(pageContext, "no-title");
						%>
							<div class="video-image-wrapper" <% if(!vid.getFilename().equals("")){%> onClick="window.open('<%=url%>')" <%} %>>
							    <img class="video-image-big" src="<%=vid.getImageMedium()%>"/>
							</div>
							<div class="video-content-wrapper">
								<div class="admin-videolist-video-title" <% if(!vid.getFilename().equals("")){%> onClick="window.open('<%=url%>')" <%} %>>
									<%= vName %>
								</div>
								<%if(!lName.equals("")){%>
									<div class="admin-videolist-lectureseries-title">
										<%=lName%> (<%=lTerm%>)
									</div>
								<%}
								if(!vid.getFilename().equals("")){
									%><div class="format"><%
									if(vid.getMp4File().isFile()){%>
										<liferay-ui:message key="mp4-video"/> &nbsp;
									<%}
									
									if(vid.getMp3File().isFile()){%>
										<liferay-ui:message key="mp3-audio"/> &nbsp;
									<%}
									
									if(vid.getM4aFile().isFile()){%>
										<liferay-ui:message key="m4a-audio"/> &nbsp;
									<%}
									
									if(vid.getM4vFile().isFile()){%>
										<liferay-ui:message key="m4v-video"/> &nbsp;
									<%}
									
									if(vid.getFlvFile().isFile()){%>
										<liferay-ui:message key="flv-video"/> &nbsp;
									<%}
									
									if(vid.getOggFile().isFile()){%>
										<liferay-ui:message key="ogg-video"/> &nbsp;
									<%}
									
									if(vid.getWebmFile().isFile()){%>
										<liferay-ui:message key="webm-video"/> &nbsp;
									<%}
									
									if(vid.getPdfFile().isFile()){%>
										<liferay-ui:message key="pdf-text"/> &nbsp;
									<%}%>
									</div>
								<div class="admin-videolist-date">
									<%=vid.getDate()%> | <liferay-ui:message key="hits"/>: <%=vid.getHits()%>
								</div>
						<%}%>
						</div>
						<div class="video-edit-wrapper">
				
							<%
								String primKey = String.valueOf(vid.getPrimaryKey());
							%>
			
							<portlet:actionURL name="viewVideo" var="editURL">
								<portlet:param name="videoId" value="<%= primKey%>" />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>
							</portlet:actionURL>
							
							
							<portlet:actionURL name="lockVideo" var="lockURL">
								<portlet:param name="videoId" value="<%= primKey%>" />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>	
							</portlet:actionURL>
							
							<portlet:actionURL name="unlockVideo" var="unlockURL">
								<portlet:param name="videoId" value="<%= primKey%>" />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>	
							</portlet:actionURL>
							
							<portlet:actionURL name="activateDownload" var="activateDowonloadURL">
								<portlet:param name="videoId" value="<%= primKey%>" />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>	
							</portlet:actionURL>
							
							<portlet:actionURL name="deactivateDownload" var="deactivateDowonloadURL">
								<portlet:param name="videoId" value="<%= primKey%>" />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>	
							</portlet:actionURL>
							
							<portlet:actionURL name="addSegment" var="segmentURL">
								<portlet:param name="videoId" value="<%= primKey%>" />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>		
							</portlet:actionURL>
		
							<portlet:actionURL name="removeVideo" var="removeURL">
								<portlet:param name="videoId" value="<%= primKey%>" />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>	
							</portlet:actionURL>
							
							<a href="<%=editURL.toString()%>">
							   <span class="icon-large icon-pencil"></span>
							</a>
							
							<%if(vid.getFilename().length()>0){
								if (vid.getOpenAccess()==1){%>
								<a href="<%=lockURL.toString()%>">
								   <span class="icon-large icon-unlock"></span>
								</a>
								<%}else{%>
									 <a href="<%=unlockURL.toString()%>">
									    <span class="icon-large icon-lock"></span>
									 </a>
								<%}	
									
								if (vid.getDownloadLink()==1){%>
									 <a href="<%=deactivateDowonloadURL.toString()%>">
									    <span class="icon-large icon-download-alt"></span>
									 </a>
								<%}else{%>
									 <a href="<%=activateDowonloadURL.toString()%>">
									    <span class="icon-large icon-download"></span>
									 </a>		
								<%}	
								
								if (SegmentLocalServiceUtil.getSegmentsByVideoId(vid.getVideoId()).size()>0){%>
								 <a href="<%=segmentURL.toString()%>">
								    <span class="icon-large icon-comment"></span>
								 </a>			
								<%}else{%>
									<a href="<%=segmentURL.toString()%>">
									   <span class="icon-large icon-align-justify"></span>
									</a>	
								<%}
								
							}%>
							
							<a href="<%=removeURL.toString()%>">
								<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
							</a>
						</div>
					</div>
				</div>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>