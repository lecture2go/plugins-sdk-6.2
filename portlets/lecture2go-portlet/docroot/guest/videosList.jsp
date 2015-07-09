<%@include file="/init.jsp"%>

<%
	// defines how many terms and creators are shown initially	
	int maxTerms	= 4;
	int maxCreators = 4;

	// get all filter-requests
	Long parentInstitutionId 	= ServletRequestUtils.getLongParameter(request, "parentInstitutionId", 0);
	Long institutionId 			= ServletRequestUtils.getLongParameter(request, "institutionId", 0);
	Long termId 				= ServletRequestUtils.getLongParameter(request, "termId", 0);
	Long categoryId 			= ServletRequestUtils.getLongParameter(request, "categoryId", 0);
	Long creatorId 				= ServletRequestUtils.getLongParameter(request, "creatorId", 0);

	String searchQuery			= ServletRequestUtils.getStringParameter(request, "searchQuery", "");
	
	// filters are set if they have a value different than 0
	boolean hasInstitutionFiltered 			= (institutionId != 0);
	boolean hasParentInstitutionFiltered 	= (parentInstitutionId != 0);
	boolean hasTermFiltered 				= (termId != 0);
	boolean hasCategoryFiltered				= (categoryId != 0);
	boolean hasCreatorFiltered  			= (creatorId != 0);
	boolean isSearched						= (searchQuery != "");

	// the institution is dependent on the parentinstitution, do not allow institution-filters without parentinstitution-filter
	if (hasInstitutionFiltered && !hasParentInstitutionFiltered) {
		institutionId = new Long(0);
	}

// 	List<Lectureseries> reqLectureseries;
// 	if (isSearched) {
// 		reqLectureseries = LectureseriesLocalServiceUtil.getFilteredBySearchQuery(searchQuery);
// 	} else {
// 		reqLectureseries = LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId, parentInstitutionId, termId, categoryId, creatorId);
// 	}
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
	// in the first case only the selected one is shown because some filtered data may have multiple entries for the filter e.g. multiple creators
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
	
	if (hasCreatorFiltered) {
		presentCreators.add(CreatorLocalServiceUtil.getCreator(creatorId));
	} else {
		presentCreators = CreatorLocalServiceUtil.getCreatorsFromLectureseriesIdsAndVideoIds(lectureseriesIds,videoIds);
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
// 	if (isSearched) {
		
// 	}
	
	// set page context for better use in taglibs
	pageContext.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
	pageContext.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
	pageContext.setAttribute("hasTermFiltered", hasTermFiltered);
	pageContext.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
	pageContext.setAttribute("hasCreatorFiltered", hasCreatorFiltered);
	pageContext.setAttribute("hasManyTerms", presentTerms.size() > maxTerms);
	pageContext.setAttribute("hasManyCreators", presentCreators.size() > maxCreators);
		
%>

<style>
.clicked,
.clicked:hover,
.clicked:focus {
  z-index: 2;
  color: #a94442;
  background-color: #f9f9f9;
}
.clicked:before {
  position: relative;
  top: 1px;
  display: inline-block;
  font-family: 'Glyphicons Halflings';
  font-style: normal;
  font-weight: normal;
  line-height: 1;

  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  content: "\e014";
  float: right;
}

#loadMoreTerms,
#loadMoreCreators {
	cursor: pointer
}
</style>



<div class="row-fluid">
	<div class="span3">


<liferay-ui:panel-container>
	<!-- 	parentinstitution filter -->
	<liferay-ui:panel extended="true" title="Einrichtung">
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
			<li ${hasParentInstitutionFiltered ? 'class="clicked"' : ''}><a href="${filterByParentInstitution}">${parentInstitution.name}</a></li>
		</c:forEach>
		</ul>
	</liferay-ui:panel>
	
 	<!-- 	institution filter  -->
	<c:if test="${hasParentInstitutionFiltered}">
	<liferay-ui:panel extended="true" title="Bereich">
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
			<li ${hasInstitutionFiltered ? 'class="clicked"' : ''}><a href="${filterByInstitution}">${institution.name}</a></li>
		</c:forEach>
		</ul>
	</liferay-ui:panel>
	</c:if>
	
	<!-- 	terms filter -->
	<liferay-ui:panel extended="true" title="Semester">
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
			<li ${hasTermFiltered ? 'class="clicked"' : ''}><a href="${filterByTerm}">${term.termName}</a></li>
		</c:forEach>
		</ul>
		<c:if test="${hasManyTerms}">
			<div id="loadMoreTerms">mehr...</div>
		</c:if>
	</liferay-ui:panel>
	

	
	<!-- 	category filter -->
	<liferay-ui:panel extended="true" title="Kategorie">
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
			<li ${hasCategoryFiltered ? 'class="clicked"' : ''}><a href="${filterByCategory}">${category.name}</a></li>
		</c:forEach>
		</ul>
	</liferay-ui:panel>
	
	<!-- 	creator filter -->
	<liferay-ui:panel extended="true" title="Person">
		<c:if test="${!hasCreatorFiltered && hasManyCreators}">
			<div class="input-group">
      			<input id="searchName" type="text" class="form-control" placeholder="Suche Person...">
    		</div>
		</c:if>
		<ul class="creators">
		<c:forEach items="<%=presentCreators %>" var="creator">
			<portlet:actionURL var="filterByCreator" name="addFilter">
				<portlet:param name="jspPage" value="/guest/videosList.jsp" />
				<portlet:param name="institutionId" value="<%=institutionId.toString() %>"/>
				<portlet:param name="parentInstitutionId" value="<%=parentInstitutionId.toString() %>"/>
				<portlet:param name="termId" value="<%=termId.toString() %>"/>
				<portlet:param name="categoryId" value="<%=categoryId.toString() %>"/>
				<portlet:param name="creatorId" value='${hasCreatorFiltered ? "0" : creator.creatorId}'/>
				<portlet:param name="searchQuery" value="<%=searchQuery %>"/>	
			</portlet:actionURL>
			<li ${hasCreatorFiltered ? 'class="clicked"' : ''}><a href="${filterByCreator}">${creator.fullName}</a></li>
		</c:forEach>
		</ul>
		<c:if test="${hasManyCreators}">
			<div id="loadMoreCreators">mehr...</div>
		</c:if>
	</liferay-ui:panel>
</liferay-ui:panel-container>

</div>

<div class="span9">
		
<portlet:actionURL var="filterBySearchQuery" name="addFilter">
	<portlet:param name="jspPage" value="/guest/videosList.jsp" />
	<portlet:param name="institutionId" value="0"/>
	<portlet:param name="parentInstitutionId" value="0"/>
	<portlet:param name="termId" value="0"/>
	<portlet:param name="categoryId" value="0"/>
	<portlet:param name="creatorId" value="0"/>
	<portlet:param name="jspPage" value="/guest/videosList.jsp" />
</portlet:actionURL>		
	
<aui:form action="${filterBySearchQuery}">
	<aui:fieldset>
		<aui:input name="searchQuery" inlineField="true"/>
		<aui:button type="submit" value="Search" ></aui:button>
       </aui:fieldset>
</aui:form>
		
<liferay-ui:search-container emptyResultsMessage="no-lectureseries-found" delta="5" iteratorURL="<%=portletURL %>">
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
		%>
		<liferay-ui:search-container-column-text>
			<img alt="" src="<%=vidDummy.getImageSmall()%>">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text>
			<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL">
				<portlet:param name="objectId" value="<%=oId%>"/>
				<%if(isVideo){%><portlet:param name="objectType" value="v"/><%}%>
				<%if(!isVideo){%><portlet:param name="objectType" value="l"/><%}%>
			</portlet:actionURL>
			<a href="<%=viewOpenAccessVideoURL%>"><%=lectser.getName()%></a>
			<br/>
			<%
				if(lectser.getLatestOpenAccessVideoId()<0){%>video id = <%=lectser.getLectureseriesId()%><%}
				else{%>lecture series id = <%=lectser.getLectureseriesId()%><%}
			%>		
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

</div>
</div>

<script type="text/javascript">
$( document ).ready(function() {
	// only the show the last terms
	$("ul.terms > li").slice(<%=maxTerms%>).hide();
	// show the remaining terms
	$('#loadMoreTerms').click(function () {
	    $('ul.terms > li').show();
	    $('#loadMoreTerms').hide();
	});
	
	// only the show the first creators
	$("ul.creators > li").slice(<%=maxCreators%>).hide();
	// show the remaining creators
	$('#loadMoreCreators').click(function () {
	    $('ul.creators > li').show();
	    $('#loadMoreCreators').hide();
	});

	// search in the creator list
	$("#searchName").keyup(function(){
        // get the search input
        var searchName = $(this).val();
         // loop all creators
        $(".creators li").each(function(){
            // if the the search query does not match (case insensitive), fade it out
            if ($(this).text().search(new RegExp(searchName, "i")) < 0) {
                $(this).fadeOut();
            // if the search query matches, show the item
            } else {
                $(this).show();
            }
        });
    });
});
</script>