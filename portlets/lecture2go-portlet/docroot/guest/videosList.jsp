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

<div class="row-fluid">
<%if(!resultSetEmpty){ %>
<div class="span3">

<liferay-ui:panel-container>
	<!-- 	parentinstitution filter -->
	<%if(presentParentInstitutions.size()>0){ %>
	<liferay-ui:panel extended="true" title="Einrichtung" cssClass='${hasParentInstitutionFiltered ? "filtered" : "notFiltered"}'>
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
			<li class="filter-menu"><div class="filter-menu-link"><a href="${filterByParentInstitution}">${parentInstitution.name}<span ${hasParentInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span></a></div></li>
		</c:forEach>
		</ul>
	</liferay-ui:panel>
	<%}%>
	
 	<!-- 	institution filter  -->
	<c:if test="${hasParentInstitutionFiltered}">
	<%if(presentInstitutions.size()>0){ %>
	<liferay-ui:panel extended="true" title="Bereich" cssClass='${hasInstitutionFiltered ? "filtered" : "notFiltered"}'>
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
			<li class="filter-menu"><div class="filter-menu-link"><a href="${filterByInstitution}">${institution.name}<span ${hasInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span></a></div></li>
		</c:forEach>
		</ul>
	</liferay-ui:panel>
	<%}%>
	</c:if>
	
	<!-- 	terms filter -->
	<%if(presentTerms.size()>0){%>
	<liferay-ui:panel extended="true" title="Semester" cssClass='${hasTermFiltered ? "filtered" : "notFiltered"}'>
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
			<li class="filter-menu"><div class="filter-menu-link"><a href="${filterByTerm}">${term.termName}<span ${hasTermFiltered ? 'class="icon-large icon-remove"' : ''}></span></a></div></li>
		</c:forEach>
		</ul>
		<c:if test="${hasManyTerms}">
			<div id="loadMoreTerms">mehr...</div>
		</c:if>
	</liferay-ui:panel>
	<%}%>

	
	<!-- 	category filter -->
	<%if(presentCategories.size()>0){%>
	<liferay-ui:panel extended="true" title="Kategorie" cssClass='${hasCategoryFiltered ? "filtered" : "notFiltered"}'>
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
			<li class="filter-menu"><div class="filter-menu-link"><a href="${filterByCategory}">${category.name} <span ${hasCategoryFiltered ? 'class="icon-large icon-remove"' : ''}></span></a></div></li>
		</c:forEach>
		</ul>
	</liferay-ui:panel>
	<%}%>
</liferay-ui:panel-container>

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

		
<liferay-ui:search-container emptyResultsMessage="no-lectureseries-found" delta="15" iteratorURL="<%=portletURL %>" >
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
			int videoCount=lectser.getNumberOfVideos();
			List<Creator> cl = CreatorLocalServiceUtil.getCreatorsByLectureseriesId(lectser.getLectureseriesId());
			ListIterator<Creator> cli = cl.listIterator();
			List<Video> vl = new ArrayList<Video>();
			ListIterator<Video> vli = vl.listIterator();

			if(videoCount>0 && isSearched){
				//get videos by search word and lecture series
				vl = VideoLocalServiceUtil.getBySearchWordAndLectureseriesId(searchQuery, new Long(oId));
			}else{
				vl = VideoLocalServiceUtil.getByLectureseries(new Long(oId));
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
							if(videoCount==1){
								if(isVideo){
									%>
							        <a href="<%=view1URL%>">
								       <div class="videotile metainfolist ">
									        <div class="video-image-wrapper">
									          <img class="video-image-big" src="<%=vidDummy.getImageMedium()%>"/>
									        </div>
									        
											<div class="lectureseries-title"><%=lectser.getName()%></div>
											
											<div class="allcreators">
												<%
						       						String fullname1="";

							           				List<Creator> clv = CreatorLocalServiceUtil.getCreatorsByVideoId(vidDummy.getVideoId());
													ListIterator<Creator> clvi = clv.listIterator();										
							       					int j=0;
							       					while(clvi.hasNext()){
							       						if(j<2){
							       							fullname1 += clvi.next().getFullName();
							       							if(clv.size()>1 && clvi.hasNext()) fullname1+=", ";
								    					}else{
								    						fullname1+="u. a.";
															break;
								    					}
								    					j++;
							        				}
							           			%>
												<%=fullname1 %>
												<br/>
												<%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName() %>
											</div>		
																	
									        <div class="tags">
									          <%
									        	String cat = "";
									        	List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId());
									        	ListIterator<Lectureseries_Institution> liIt = li.listIterator();
									            try{
									            	Long cId = Video_CategoryLocalServiceUtil.getByVideo(lectser.getLectureseriesId()).get(0).getCategoryId();
									            	cat =  CategoryLocalServiceUtil.getById(cId).getName();
									            }catch(Exception e){
									            	System.out.print(e);
									            }
									          %>
									          <span class="label label-light2"><%=cat%></span>
									          <%
									          	while(liIt.hasNext()){
									          		Lectureseries_Institution lI = liIt.next();
									          		Institution inst = InstitutionLocalServiceUtil.getById(lI.getInstitutionId());
									          		%>
											          <span class="label label-light2"><%=inst.getName()%></span>
									          		<%
									          	}
									          %>
									        </div>   
								        </div>
							        </a>
							    	<%									
								}else{
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
							        
							        <a href="<%=view2URL%>">
							          <span class="badge"><%=videoCount%></span>
								       <div class="videotile metainfolist ">
									        <div class="video-image-wrapper">
									          <img class="video-image-big layered-paper" src="<%=vidDummy.getImageMedium()%>"/>
									          <span class="tri"></span>
									          <span class="overlay"></span>
									        </div>
									        
											<div class="lectureseries-title"><%=lectser.getName()%></div>
											
											<div class="allcreators">
												<%
												String fullname1="";
												
	              								int i=0;
	              								while(cli1.hasNext()){
		              								if(i<2){
						       							fullname1 += cli1.next().getFullName();
						       							if(cl1.size()>1 && cli1.hasNext()) fullname1+=", ";
							    					}else{
							    						fullname1+="u. a.";
														break;
							    					}
		              								i++;
	              								}
												%>
												<%=fullname1%>
												<br/>
												<%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName() %>												
											</div>		

									        <div class="tags">
									          <%
									        	String cat =CategoryLocalServiceUtil.getById(lectser.getCategoryId()).getName();
									        	List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId());
									        	ListIterator<Lectureseries_Institution> liIt = li.listIterator();
									          %>
									          <span class="label label-light2"><%=cat%></span>
									          <%
									          	while(liIt.hasNext()){
									          		Lectureseries_Institution lI = liIt.next();
									          		Institution inst = InstitutionLocalServiceUtil.getById(lI.getInstitutionId());
									          		%>
											          <span class="label label-light2"><%=inst.getName()%></span>
									          		<%
									          	}
									          %>
									        </div>   
								        </div>
							        </a>
							    	<%										
								}
							}else{
								%>
							        <a href="<%=view1URL%>">
							          <span class="badge"><%=videoCount%></span>
								       <div class="videotile metainfolist ">
									        <div class="video-image-wrapper">
									          <img class="video-image-big layered-paper" src="<%=vidDummy.getImageMedium()%>"/>
									          <span class="tri"></span>
									          <span class="overlay"></span>
									        </div>
									        
											<div class="lectureseries-title"><%=lectser.getName()%></div>
											
											<div class="allcreators">
												<%
												String fullname2="";
	              								int i=0;
	              								while(cli.hasNext()){
		              								if(i<2){
						       							fullname2 += cli.next().getFullName();
						       							if(cl.size()>1 && cli.hasNext()) fullname2+=", ";
							    					}else{
							    						fullname2+="u. a.";
														break;
							    					}
		              								i++;
	              								}
												%>
												<%=fullname2%>
												<br/>
												<%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName() %>
											</div>		
																	
											
									        <div class="tags">
									          <%
									        	String cat ="";
									            try{cat=CategoryLocalServiceUtil.getById(lectser.getCategoryId()).getName();}catch(Exception e){}
									        	List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId());
									        	ListIterator<Lectureseries_Institution> liIt = li.listIterator();
									          %>
									          <span class="label label-light2"><%=cat%></span>
									          <%
									          	while(liIt.hasNext()){
									          		Lectureseries_Institution lI = liIt.next();
									          		Institution inst = InstitutionLocalServiceUtil.getById(lI.getInstitutionId());
									          		%>
											          <span class="label label-light2"><%=inst.getName()%></span>
									          		<%
									          	}
									          %>
									        </div>   
								        </div>
							        </a>
								<%	
							}
						%>
				</div>
				
				<!-- sublist for searched videos -->
				<%if(videoCount>1 && isSearched){ %>
					<div id="searchedvideos">
							<button id="<%="b"+oId%>" >
								<span class="lfr-icon-menu-text">
									<i class="icon-large icon-chevron-down"></i>
								</span>	
							</button>
						    <ul id="<%="p"+oId%>" class="list-group toggler-content-collapsed content">
							<%
							while(vli.hasNext()){
							Video v =  VideoLocalServiceUtil.getFullVideo(vli.next().getVideoId());
							String vId = v.getVideoId()+"";
							%>
								<portlet:actionURL name="viewOpenAccessVideo" var="vURL">
									<portlet:param name="objectId" value="<%=vId%>"/>
									<portlet:param name="objectType" value="v"/>
								</portlet:actionURL>				
								<li class="videotile small">
									<a href="<%=vURL%>">
										<div class="videotile metainfolist small">
											<div class="video-image-wrapper-small">
												<img class="video-image" src="<%=v.getImageSmall()%>">
											</div>
										</div>
										<div class="metainfo-small">
											<div class="title-small"><%=v.getTitle()%></div>
		              						<em class="creator-small2">
												<%
													List<Creator> cv = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());
													ListIterator<Creator> cvi = cl.listIterator();										
		              								int i=0;
		              								String fullname3="";
		              								while(cvi.hasNext()){
			              								if(i<2){
							       							fullname3 += cvi.next().getFullName();
							       							if(cv.size()>1 && cvi.hasNext()) fullname3+=", ";
								    					}else{
								    						fullname3+="u. a.";
															break;
								    					}
			              								i++;
		              								}
		              								String date = "";
		              								String dur = "";
		              								try{ date = v.getDate().trim();}catch(Exception e){}
		              								try{ dur = v.getDuration().trim().substring(0, 8);}catch(Exception e){}
		              							%>
		              							<%=fullname3%>
		              							<div class="generation-date"><%=date%></div>
		              							<div class="duration"><%=dur%></div>
		              						</em>
	              						</div>
									</a>
								</li>
								<li class="placeholder"></li>
							<%}%>
							</ul>
							<script>
							$("<%="#b"+oId%>").click(function() {
								$("<%="#p"+oId%>").slideToggle("slow");
							});
							</script>
						</div>
				<%}%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

</div>
</div>

<script type="text/javascript">

$( document ).ready(function() {
	//turn off autocomplete
	$(document).on('focus', ':input', function() {
	    $(this).attr('autocomplete', 'off');
	});
	// only show the last terms
	$("ul.terms > li").slice(<%=maxTerms%>).hide();
	// show the remaining terms
	$('#loadMoreTerms').click(function () {
	    $('ul.terms > li').show();
	    $('#loadMoreTerms').hide();
	});
	
	// toggles the panel if necessary
    toggleFilterPanel();
    $(window).resize(toggleFilterPanel);
});

function toggleFilterPanel(){
    if ($( window ).width() <= 767){
    	// only fire once
    	if (!$('.notFiltered').children().hasClass('smallViewContent')) {
    		// we utilize the find() method because the divs to be changed do not necessarily have the same hierarchy
    		$('.notFiltered').find('.toggler-content-expanded').addClass('toggler-content-collapsed smallViewContent').removeClass('toggler-content-expanded');
    		$('.notFiltered').find('.toggler-header-expanded').addClass('toggler-header-collapsed smallViewHeader').removeClass('toggler-header-expanded');
       	}
    }
    else if ($( window ).width() > 767){
        $('.smallViewContent').addClass('toggler-content-expanded').removeClass('toggler-content-collapsed smallViewContent');
        $('.smallViewHeader').addClass('toggler-header-expanded').removeClass('toggler-header-collapsed smallViewHeader');
    }
}

</script>
