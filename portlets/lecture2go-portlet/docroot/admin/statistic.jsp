<%@include file="/init.jsp" %>
<%@ page import="de.uhh.l2g.plugins.model.VideoStatistic" %>
<%@ page import="de.uhh.l2g.plugins.service.VideoStatisticLocalServiceUtil" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
//Scope GroupId
long groupId = themeDisplay.getLayout().getGroupId();
//Company Id of Application
long companyId = themeDisplay.getLayout().getCompanyId();

List<VideoStatistic> statisticEntries = VideoStatisticLocalServiceUtil.getAllStatistics();
ListIterator<VideoStatistic> it = statisticEntries.listIterator();
%>
 
<aui:fieldset column="false" label="statistic" >
	<span><liferay-ui:message key="statistic-info"/></span>
	<aui:layout cssClass="l2stat">
		<%
		while(it.hasNext()){ 
			VideoStatistic vStat = it.next();
			int timeSpan=vStat.getDateDiff();
			switch(timeSpan){
				case 0:
					%>
					<span><liferay-ui:message key="current"/> </span>
					<br />			
					<%
					;
		        break;
				case 1:
					%>
					<span><liferay-ui:message key="sinceyesterday"/> </span>
					<br />			
					<%
					;
		        break;
				case 7:
					%>
					<span><liferay-ui:message key="sinceweek"/> </span>
					<br />			
					<%
					;
		        break;
				case 30:
					%>
					<span><liferay-ui:message key="sincemonth"/> </span>
					<br />			
					<%
					;
		        break;
				case 366:
					%>
					<span><liferay-ui:message key="sinceyear"/> </span>
					<br />			
					<%
					;
		        break;
			}
			//
			if(timeSpan == 0){
				%>
					<em>-&nbsp;<liferay-ui:message key="total"/> 
						<%if(vStat.getCurrentTotal()>0) {%>
						 	<%=vStat.getCurrentTotal() %> <liferay-ui:message key="ofwhich"/>
						<%}%>
						<%if(vStat.getCurrentTotal()<1) {%>
							<liferay-ui:message key="videolistevaluationnotpossible"/> 
						<%}%>
					</em>
					<br />
					<%if(vStat.getCurrentPublic()>0) {%>
						<em> &nbsp; <%=vStat.getPubPercent() %> <liferay-ui:message key="percent"/> <liferay-ui:message key="public"/> </em>
					<%}%>			
					<br />
					<%if(vStat.getCurrentPrivate()>0) {%>
						<em> &nbsp; <%=vStat.getPrivPercent() %> <liferay-ui:message key="percent"/> <liferay-ui:message key="private"/> </em>
					<%}%>			
					<br />		
				<%		
			}else{
				%>
					<%if(vStat.getPublicDiff()>=0) {%>
						<em> -&nbsp;<liferay-ui:message key="public"/> <span class="plus">+<%=vStat.getPublicDiff()%></span></em>
						<br />			
					<%}%>
					<%if(vStat.getPublicDiff()<0) {%>
						<em> -&nbsp;<liferay-ui:message key="public"/> <span class="minus"><%=vStat.getPublicDiff()%></span></em>
						<br />			
					<%}%>
					<%if(vStat.getPrivateDiff()>=0) {%>
						<em> -&nbsp;<liferay-ui:message key="private"/> <span class="plus">+<%=vStat.getPrivateDiff()%></span></em>
						<br />			
					<%}%>
					<%if(vStat.getPrivateDiff()<0) {%>
						<em> -&nbsp;<liferay-ui:message key="private"/> <span class="minus"><%=vStat.getPrivateDiff()%></span></em>
						<br />			
					<%}%>
				<%		
			}
		}
		%>
	</aui:layout>
</aui:fieldset>