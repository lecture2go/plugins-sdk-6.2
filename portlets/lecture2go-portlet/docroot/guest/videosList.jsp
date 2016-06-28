<%@include file="/init.jsp"%>
 
<%
	// defines how many terms and creators are shown initially	
	int maxTerms	= 4;

	// get all filter-requests
	Long parentInstitutionId 	= ServletRequestUtils.getLongParameter(request, "parentInstitutionId", 0);
	Long institutionId 			= ServletRequestUtils.getLongParameter(request, "institutionId", 0);
	Long termId 				= ServletRequestUtils.getLongParameter(request, "termId", 0);
	Long categoryId 			= ServletRequestUtils.getLongParameter(request, "categoryId", 0);
	
	// TODO: creators are removed, the creatorId temporary exists for compatibility
	Long creatorId 				= ServletRequestUtils.getLongParameter(request, "creatorId", 0);

	String searchQuery			= ServletRequestUtils.getStringParameter(request, "searchQuery", "");

	// filters are set if they have a value different than 0
	boolean hasInstitutionFiltered 			= (institutionId != 0);
	boolean hasParentInstitutionFiltered 	= (parentInstitutionId != 0);
	boolean hasTermFiltered 				= (termId != 0);
	boolean hasCategoryFiltered				= (categoryId != 0);
	boolean isSearched						= (searchQuery.trim().length()>0);

	// the institution is dependent on the parentinstitution, do not allow institution-filters without parentinstitution-filter
	if (hasInstitutionFiltered && !hasParentInstitutionFiltered) {
		institutionId = new Long(0);
	}

	// get filtered lectureseries and single videos
	List<Lectureseries> reqLectureseries = LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId, parentInstitutionId, termId, categoryId, creatorId, searchQuery);

	// differentiate returned lectureseries in real lectureseries and fake video lectureseries (openAccessVideoId is negative on videos)
	ArrayList<Long> lectureseriesIds = new ArrayList<Long>();
	ArrayList<Long> videoIds = new ArrayList<Long>();
	long id;
 	for (Lectureseries lecture : reqLectureseries) {
		id = lecture.getLectureseriesId();
		if (lecture.getLatestOpenAccessVideoId() < 0) {
			videoIds.add(id);
		} else {
			lectureseriesIds.add(id);
		}
	} 
	
	// get the institutions, parentinstitutuons, terms, categories and creators which are part of the dataset. those are displayed so the user can do further filtering
	List<Institution> presentParentInstitutions 	= new ArrayList<Institution>();
	List<Institution> presentInstitutions 			= new ArrayList<Institution>();
	List<Term> presentTerms 						= new ArrayList<Term>();
	List<Creator> presentCreators 					= new ArrayList<Creator>();
	List<Category> presentCategories 				= new ArrayList<Category>();

	// if a filter is selected, only show the selected one else show all
 	if (hasParentInstitutionFiltered) {
		presentParentInstitutions.add(InstitutionLocalServiceUtil.getById(parentInstitutionId));
	} else {
		presentParentInstitutions = InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
	} 
	
 	if (hasParentInstitutionFiltered && hasInstitutionFiltered) {
		presentInstitutions.add(InstitutionLocalServiceUtil.getById(institutionId));
	} else {
		presentInstitutions = InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, parentInstitutionId);
	}
	
	if (hasTermFiltered) {
		presentTerms.add(TermLocalServiceUtil.getById(termId));
	} else {
		presentTerms = TermLocalServiceUtil.getTermsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
	}
	
	if (hasCategoryFiltered) {
		presentCategories.add(CategoryLocalServiceUtil.getById(categoryId));
	} else {
		presentCategories = CategoryLocalServiceUtil.getCategoriesFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
	}
	
	List<Lectureseries> tempLectureseriesList = new ArrayList();
	
	PortletURL portletURL = renderResponse.createRenderURL();
	
	// set parameter for search iterator or possible backURL
	portletURL.setParameter("parentInstitutionId", parentInstitutionId.toString());
	portletURL.setParameter("institutionId", institutionId.toString());
	portletURL.setParameter("termId", termId.toString());
	portletURL.setParameter("categoryId", categoryId.toString());
	portletURL.setParameter("creatorId", creatorId.toString());
	portletURL.setParameter("searchQuery", searchQuery);
	
	// set page context for better use in taglibs
	pageContext.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
	pageContext.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
	pageContext.setAttribute("hasTermFiltered", hasTermFiltered);
	pageContext.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
	pageContext.setAttribute("hasManyTerms", presentTerms.size() > maxTerms);
	
	boolean resultSetEmpty = true;
	if(presentParentInstitutions.size()>0||presentInstitutions.size()>0||presentTerms.size()>0||presentCategories.size()>0){
		resultSetEmpty=false;
	}
		
%>
<div class="catalogue-container">
	<div class="row-fluid">
	<%if(!resultSetEmpty){ %>
		<div class="span3">
			<liferay-ui:panel-container>
				<!-- 	parentinstitution filter -->
				<%if(presentParentInstitutions.size()>0){ %>
				<liferay-ui:panel extended="true" title="institution" cssClass='${hasParentInstitutionFiltered ? "filtered" : "notFiltered"}'>
					<ul>
					<c:forEach items="<%=presentParentInstitutions %>" var="parentInstitution">
						<portlet:actionURL var="filterByParentInstitution" name="addFilter">
							<portlet:param name="jspPage" value="/guest/videosList.jsp" />
							<portlet:param name="parentInstitutionId" value='${hasParentInstitutionFiltered ? "0" : parentInstitution.institutionId}'/>
							<portlet:param name="institutionId" value="<%=institutionId.toString() %>"/>				
							<portlet:param name="termId" value="<%=termId.toString() %>"/>
							<portlet:param name="categoryId" value="<%=categoryId.toString() %>"/>
							<portlet:param name="creatorId" value="<%=creatorId.toString() %>"/>
							<portlet:param name="searchQuery" value="<%=searchQuery %>"/>	
						</portlet:actionURL>
						<li class="filter-menu"><a href="${filterByParentInstitution}"><div class="filter-menu-link">${parentInstitution.name}<span ${hasParentInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span></div></a></li>
					</c:forEach>
					</ul>
				</liferay-ui:panel>
				<%}%>
				
			 	<!-- 	institution filter  -->
				<c:if test="${hasParentInstitutionFiltered}">
				<%if(presentInstitutions.size()>0){ %>
				<liferay-ui:panel extended="true" title="sub-institution" cssClass='${hasInstitutionFiltered ? "filtered" : "notFiltered"}'>
					<ul>
					<c:forEach items="<%=presentInstitutions %>" var="institution">
						<portlet:actionURL var="filterByInstitution" name="addFilter">
							<portlet:param name="jspPage" value="/guest/videosList.jsp" />
							<portlet:param name="parentInstitutionId" value="<%=parentInstitutionId.toString() %>"/>
							<portlet:param name="institutionId" value='${hasInstitutionFiltered ? "0" : institution.institutionId}'/>
							<portlet:param name="termId" value="<%=termId.toString() %>"/>
							<portlet:param name="categoryId" value="<%=categoryId.toString() %>"/>
							<portlet:param name="creatorId" value="<%=creatorId.toString() %>"/>
							<portlet:param name="searchQuery" value="<%=searchQuery %>"/>	
						</portlet:actionURL>
						<li class="filter-menu"><a href="${filterByInstitution}"><div class="filter-menu-link">${institution.name}<span ${hasInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span></div></a></li>
					</c:forEach>
					</ul>
				</liferay-ui:panel>
				<%}%>
				</c:if>
				
				<!-- 	terms filter -->
				<%if(presentTerms.size()>0){%>
				<liferay-ui:panel extended="true" title="term" cssClass='${hasTermFiltered ? "filtered" : "notFiltered"}'>
					<ul class="terms">
					<c:forEach items="<%=presentTerms %>" var="term">
						<portlet:actionURL var="filterByTerm" name="addFilter">
							<portlet:param name="jspPage" value="/guest/videosList.jsp" />
							<portlet:param name="institutionId" value="<%=institutionId.toString() %>"/>
							<portlet:param name="parentInstitutionId" value="<%=parentInstitutionId.toString() %>"/>	
							<portlet:param name="termId" value='${hasTermFiltered ? "0" : term.termId}'/>
							<portlet:param name="categoryId" value="<%=categoryId.toString() %>"/>
							<portlet:param name="creatorId" value="<%=creatorId.toString() %>"/>
							<portlet:param name="searchQuery" value="<%=searchQuery %>"/>	
						</portlet:actionURL>
						<li class="filter-menu"><a href="${filterByTerm}"><div class="filter-menu-link">${term.termName}<span ${hasTermFiltered ? 'class="icon-large icon-remove"' : ''}></span></div></a></li>
					</c:forEach>
					</ul>
					<c:if test="${hasManyTerms}">
						<div id="loadMoreTerms"><liferay-ui:message key="more"/></div>
					</c:if>
				</liferay-ui:panel>
				<%}%>
			
				
				<!-- 	category filter -->
				<%if(presentCategories.size()>0){%>
				<liferay-ui:panel extended="true" title="category" cssClass='${hasCategoryFiltered ? "filtered" : "notFiltered"}'>
					<ul>
					<c:forEach items="<%=presentCategories %>" var="category">
			    		<portlet:actionURL var="filterByCategory" name="addFilter">
							<portlet:param name="jspPage" value="/guest/videosList.jsp" />
							<portlet:param name="institutionId" value="<%=institutionId.toString() %>"/>
							<portlet:param name="parentInstitutionId" value="<%=parentInstitutionId.toString() %>"/>
							<portlet:param name="termId" value="<%=termId.toString() %>"/>
							<portlet:param name="categoryId" value='${hasCategoryFiltered ? "0" : category.categoryId}'/>
							<portlet:param name="creatorId" value="<%=creatorId.toString() %>"/>	
							<portlet:param name="searchQuery" value="<%=searchQuery %>"/>	
						</portlet:actionURL>
						<li class="filter-menu"><a href="${filterByCategory}"><div class="filter-menu-link">${category.name} <span ${hasCategoryFiltered ? 'class="icon-large icon-remove"' : ''}></span></div></a></li>
					</c:forEach>
					</ul>
				</liferay-ui:panel>
				<%}%>
			</liferay-ui:panel-container>
		<!-- span3 -->
		</div>
	<%}%>

<%if(!resultSetEmpty){%><div class="span9"><%}%>
<%if(resultSetEmpty){%><div class="none"><%}%>
		
<portlet:actionURL var="filterBySearchQuery" name="addFilter">
	<portlet:param name="jspPage" value="/guest/videosList.jsp" />
	<portlet:param name="institutionId" value="0"/>
	<portlet:param name="parentInstitutionId" value="0"/>
	<portlet:param name="termId" value="0"/>
	<portlet:param name="categoryId" value="0"/>
	<portlet:param name="creatorId" value="0"/>
	<portlet:param name="jspPage" value="/guest/videosList.jsp" />
</portlet:actionURL>		

		
<liferay-ui:search-container emptyResultsMessage="no-lectureseries-found" delta="10" iteratorURL="<%=portletURL %>" >
	<liferay-ui:search-container-results>
		<%
			tempLectureseriesList = reqLectureseries;
			results = ListUtil.subList(tempLectureseriesList, searchContainer.getStart(), searchContainer.getEnd());
			total = tempLectureseriesList.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Lectureseries" keyProperty="lectureseriesId" modelVar="lectser">
		<%
			String oId = "";
			boolean isVideo = false;
			Video vidDummy = new VideoImpl();
			if(lectser.getLatestOpenAccessVideoId()<0){
				isVideo = true;
				vidDummy = VideoLocalServiceUtil.getFullVideo(lectser.getLectureseriesId());
				oId = vidDummy.getVideoId()+"";
			}else{
				oId = lectser.getLectureseriesId()+"";
				vidDummy = VideoLocalServiceUtil.getFullVideo(lectser.getLatestOpenAccessVideoId());
			}
			int videoCount = lectser.getNumberOfOpenAccessVideos();
			List<Creator> cl = CreatorLocalServiceUtil.getCreatorsByLectureseriesId(lectser.getLectureseriesId());
			ListIterator<Creator> cli = cl.listIterator();
			List<Video> vl = new ArrayList<Video>();
			ListIterator<Video> vli = vl.listIterator();

			if (videoCount > 0 && isSearched) {
				// get videos by search word and lecture series
				vl = VideoLocalServiceUtil.getBySearchWordAndLectureseriesId(searchQuery, new Long(oId));
			} else {
				// get all videos of the lecture series
				vl = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(new Long(oId), 1);
			}
			vli = vl.listIterator();
		%>
		<liferay-ui:search-container-column-text>
				<div class="videotile wide">
						<portlet:actionURL name="viewOpenAccessVideo" var="view1URL">
							<portlet:param name="objectId" value="<%=oId%>"/>
							<%if(isVideo){%><portlet:param name="objectType" value="v"/><%}%>
							<%if(!isVideo){%><portlet:param name="objectType" value="l"/><%}%>
						</portlet:actionURL>
						<%
							if(videoCount==0){
								if(isVideo){
									%>
									        <div class="video-image-wrapper">
									          <img class="video-image-big" src="<%=vidDummy.getImageMedium()%>"/>
									        </div>
									<div class="video-content-wrapper">
										<div class="video-content">
											<span class="term-of-creation"><%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName() %></span>
											
									        <div class="lectureseries-title dot-ellipsis dot-resize-update">
									        	<a href="<%=view1URL%>"><%=lectser.getName()%></a>
									        </div>
												
												<div class="allcreators">
													<%
							       						String fullname1="";
	
								           				List<Creator> clv = CreatorLocalServiceUtil.getCreatorsByVideoId(vidDummy.getVideoId());
														ListIterator<Creator> clvi = clv.listIterator();										
								       					int j=0;
								       					while(clvi.hasNext()){
								       						if(j<2){
								       							String n = clvi.next().getFullName();
								       							fullname1 += "<a href='/l2go/-/get/0/0/0/0/0/"+n+"'>"+n+"</a>";
								       							if(clvi.hasNext()) fullname1+=", ";
									    					}else{
									    						fullname1+="u.a.";
																break;
									    					}
									    					j++;
								        				}
								           			%>
													<%=fullname1 %>
												</div>
											</div>
											<div class="video-content-footer">
																		
										        <div class="tags">
										          <%
										        	String cat = "";
										        	List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId());
										        	ListIterator<Lectureseries_Institution> liIt = li.listIterator();
										            try{
										            	Long cId = Video_CategoryLocalServiceUtil.getByVideo(lectser.getLectureseriesId()).get(0).getCategoryId();
										            	cat ="<a href='/l2go/-/get/0/0/"+cId+"/0/0/'>"+CategoryLocalServiceUtil.getById(cId).getName()+"</a>";
	
										            }catch(Exception e){
										            	System.out.print(e);
										            }
										          %>
										          <span class="label label-light2 text-cut"><%=cat%></span>
										          <%
										          		try{
										          			Institution inst = InstitutionLocalServiceUtil.getById(vidDummy.getRootInstitutionId());
															String instLink="<a href='/l2go/-/get/0/"+inst.getInstitutionId()+"/0/0/0/'>"+inst.getName()+"</a>";  
											          		%>
													          <span class="label label-light2 text-cut"><%=instLink%></span>
											          		<%
										          		}catch(NullPointerException e){
										          			//
										          		}
										          %>
										        </div>
									        </div>	
								        </div>
							    	<%									
								}else{
									// single Video without lecture series
									Video v = new VideoImpl();
									v = vl.get(0);
									String vId = v.getVideoId()+"";
									List<Creator> cl1 = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());
									ListIterator<Creator> cli1 = cl1.listIterator();
									%>
									<portlet:actionURL name="viewOpenAccessVideo" var="view2URL">
										<portlet:param name="objectId" value="<%=vId%>"/>
										<portlet:param name="objectType" value="v"/>
									</portlet:actionURL>
							        
									        <div class="video-image-wrapper">
									          <img class="video-image-big layered-paper darker" src="<%=vidDummy.getImageMedium()%>"/>
									          <span class="tri"></span>
									          <span class="overlay"></span>
									        </div>
									<div class="video-content-wrapper">
									<div class="video-content">
										<span class="term-of-creation"><%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName() %></span>
										        
										        
								        <div class="lectureseries-title dot-ellipsis dot-resize-update dot-height-40">
								        	<a href="<%=view2URL%>"><%=lectser.getName()%></a>
								        </div>
												
												<div class="allcreators">
													<%
													String fullname1="";
													
		              								int i=0;
		              								while(cli1.hasNext()){
			              								if(i<2){
							       							String n = cli1.next().getFullName();
							       							fullname1 += "<a href='/l2go/-/get/0/0/0/0/0/"+n+"'>"+n+"</a>";
							       							if(cli1.hasNext()) fullname1+=", ";
								    					}else{
								    						fullname1+="u.a.";
															break;
								    					}
			              								i++;
		              								}
													%>
													<%=fullname1%>
												</div>
											</div>
											
											<div class="video-content-footer">
										        <div class="tags">
										          <%
										        	String cat ="<a href='/l2go/-/get/0/0/"+lectser.getCategoryId()+"/0/0/'>"+CategoryLocalServiceUtil.getById(lectser.getCategoryId()).getName()+"</a>";
										        	List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId());
										        	ListIterator<Lectureseries_Institution> liIt = li.listIterator();
										          %>
										          <span class="label label-light2 text-cut"><%=cat%></span>
										          <%
										          		try{
										          			Institution inst = InstitutionLocalServiceUtil.getById(vidDummy.getRootInstitutionId());
															String instLink="<a href='/l2go/-/get/0/"+inst.getInstitutionId()+"/0/0/0/'>"+inst.getName()+"</a>";  
											          		%>
													          <span class="label label-light2 text-cut"><%=instLink%></span>
											          		<%
										          		}catch(NullPointerException e){
										          			//
										          		}
										          %>
										        </div>  
									        </div> 
								        </div>
							    	<%										
								}
							}else{
								// multiple videos in lecture series
								%>
									        <div class="video-image-wrapper">
									          <img class="video-image-big layered-paper darker" src="<%=vidDummy.getImageMedium()%>"/>
											  <span class="badge"><%=videoCount%></span>
									          <span class="tri"></span>
									          <span class="overlay"></span>
									        </div>
									     
									<div class="video-content-wrapper">
										<div class="video-content">
											<span class="term-of-creation"><%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName() %></span>
										        
									        <div class="lectureseries-title dot-ellipsis dot-resize-update dot-height-40">
									        	<a href="<%=view1URL%>"><%=lectser.getName()%></a>
									        </div>
												
												<div class="allcreators">
													<%
													String fullname2="";
		              								int i=0;
		              								while(cli.hasNext()){
			              								if(i<2){
			              									String n = cli.next().getFullName();
							       							fullname2 += "<a href='/l2go/-/get/0/0/0/0/0/"+n+"'>"+n+"</a>";
							       							if(cli.hasNext()) fullname2+=", ";
								    					}else{
								    						fullname2+="u.a.";
															break;
								    					}
			              								i++;
		              								}
													%>
													<%=fullname2%>
												</div>
											</div>
											
											<div class="video-content-footer">
										        <button id="<%="b"+oId%>" >
													<span class="lfr-icon-menu-text">
														<i class="icon-large icon-chevron-down"></i>
													</span>	
												</button>
										        <div class="tags">
										          <%
										        	String cat ="";
										            try{
											        	cat ="<a href='/l2go/-/get/0/0/"+lectser.getCategoryId()+"/0/0/'>"+CategoryLocalServiceUtil.getById(lectser.getCategoryId()).getName()+"</a>";
										            }catch(Exception e){}
										        	List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId());
													%>
										          <span class="label label-light2 text-cut"><%=cat%></span>
										          <%
										          		try{
												        	Institution inst = InstitutionLocalServiceUtil.getById(li.get(0).getInstitutionId());
												        	
															String instLink="<a href='/l2go/-/get/"+inst.getInstitutionId()+"/" + inst.getParentId() + "/0/0/0/'>"+inst.getName()+"</a>"; 
											          		%>
													          <span class="label label-light2 text-cut"><%=instLink%></span>
											          		<%
										          		}catch(NullPointerException e){
										          			//
										          		}
										          %>
										        </div>
										     </div>
								        </div>
								<%	
							}
						%>
				<!-- videotile  -->
				</div>
				
				<!-- sublist for videos -->
				<%
				String videoDivTitle = "";
				if (videoCount>0) {%>
					<div id="videolist">
						<ul id="<%="p"+oId%>" class="list-group toggler-content-collapsed content">
							<%
							while(vli.hasNext()){
							Video v =  VideoLocalServiceUtil.getFullVideo(vli.next().getVideoId());
							String vId = v.getVideoId()+"";
       						int i=0;
							%>
								<portlet:actionURL name="viewOpenAccessVideo" var="vURL">
									<portlet:param name="objectId" value="<%=vId%>"/>
									<portlet:param name="objectType" value="v"/>
								</portlet:actionURL>				
								<li class="videotile small" onClick="window.location='<%=vURL%>'">
										<div class="videotile metainfolist small">
											<div class="video-image-wrapper-small">
												<img class="video-image" src="<%=v.getImageSmall()%>">
											</div>
										</div>
										<%
											List<Creator> cv = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());
											ListIterator<Creator> cvi = cl.listIterator();										
		              						String fullname3="";
		              						while(cvi.hasNext()){
			              						if(i<2){
			              							Creator c = cvi.next();
							       					String n = c.getFullName();
					       							fullname3 += "<a href='/l2go/-/get/0/0/0/0/0/"+n+"'>"+n+"</a>";
							       					if(cvi.hasNext())fullname3+=", ";
								    			}else{
								    				fullname3+="u.a.";
													break;
								    			}
			              						i++;
		              						}
		              						String date = "";
		              						String dur = "";
		              						try{ date = v. getSimpleDate().trim();}catch(Exception e){}
		              						try{ dur = v.getDuration().trim().substring(0, 8);}catch(Exception e){}
		              					%>
										<div class="metainfo-small">
		              						<div class="generation-date"><%=date%></div>
											<div class="title-small"><%=v.getTitle()%></div>		              							
			              					<div class="allcreators">		              							
		              							<%=fullname3%>
		              						</div>
	              						</div>
								</li>
							<%}%>
							</ul>
						</div>
				<%}%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
		<!-- span9 -->
		</div>
	<!-- row-fluid -->
	</div>
<!-- catalogue-container -->
</div>

<script>
//workaround: as neither DOM-ready nor Liferay.Portlet.ready are working right now, set an interval until the element is there
var checkExist = setInterval(function() {
	if ($('#_lgopenaccessvideos_WAR_lecture2goportlet_lectureseriesesSearchContainer').length) {
		var searchQuery = '<%= searchQuery %>';
		if (searchQuery) {
			$("#_lgopenaccessvideos_WAR_lecture2goportlet_lectureseriesesSearchContainer").mark(searchQuery);
		}
	   	clearInterval(checkExist);
 	}
}, 100);
</script>