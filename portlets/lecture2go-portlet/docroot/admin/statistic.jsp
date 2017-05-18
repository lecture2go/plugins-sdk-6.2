<%@include file="/init.jsp"%>
<%@ page import="de.uhh.l2g.plugins.model.VideoStatistic"%>
<%@ page
	import="de.uhh.l2g.plugins.service.VideoStatisticLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
//Scope GroupId
long groupId = themeDisplay.getLayout().getGroupId();
//Company Id of Application
long companyId = themeDisplay.getLayout().getCompanyId();

List<VideoStatistic> statisticEntries = VideoStatisticLocalServiceUtil.getAllStatistics();
ListIterator<VideoStatistic> it = statisticEntries.listIterator();

String totalCurrentVideo = "-";
String totalPublic = "";
String totalPublicPerc = ""; 
String totalPrivate = "";
String totalPrivatePerc = "";

String totalYesterday = "-";
String totalYesterdayPublic = "";
String totalYesterdayPrivate = "";

String totalOneWeek = "-";
String totalOneWeekPublic = "";
String totalOneWeekPrivate = "";

String totalOneMonth = "-";
String totalOneMonthPublic = "";
String totalOneMonthPrivate = "";

String totalOneYear ="-";
String totalOneYearPublic = "";
String totalOneYearPrivate = "";

	while(it.hasNext()){ 
			VideoStatistic vStat = it.next();
			int timeSpan=vStat.getDateDiff();
			if(timeSpan == 0){
				totalCurrentVideo = vStat.getCurrentTotal()+"";
				totalPublic = vStat.getCurrentPublic()+"";
				totalPublicPerc = vStat.getCurrentPubPercent()+""; 
				totalPrivate = vStat.getCurrentPrivate()+"";
				totalPrivatePerc = vStat.getCurrentPrivPercent()+"";
				 } 
			else if(timeSpan == 1) {
				 totalYesterday = vStat.getTotalDiff() +"";
 				 totalYesterdayPublic = vStat.getPublicDiff()+"";
				 totalYesterdayPrivate = vStat.getPrivateDiff()+"";
                } 
			else if(timeSpan == 7) {
	        	 totalOneWeek = vStat.getTotalDiff() +"";
 				 totalOneWeekPublic = vStat.getPublicDiff()+"";
				 totalOneWeekPrivate = vStat.getPrivateDiff()+"";
		} else if(timeSpan > 27 && timeSpan < 32) {
		    	 totalOneMonth = vStat.getTotalDiff() +"";
 				 totalOneMonthPublic = vStat.getPublicDiff()+"";
				 totalOneMonthPrivate = vStat.getPrivateDiff()+"";
			 } else if(timeSpan == 365 || timeSpan == 366) {
				 totalOneYear = vStat.getTotalDiff() +"";
 				 totalOneYearPublic = vStat.getPublicDiff()+"";
				 totalOneYearPrivate = vStat.getPrivateDiff()+"";}	
		}

%>

<label class="edit-video-lable"><liferay-ui:message
		key="video-statistic" /></label>
<aui:fieldset column="false">
	<aui:layout cssClass="l2stat">
		<div class="lineBreak"></div>
		<div class="videoStatistic_table">
			<div class="lineBreak"></div>
			<div class="videoStatistic_heading">
				<div class="videoStatistic_cell">
					<liferay-ui:message key="timespan" />
				</div>
				<div class="videoStatistic_cell">
					<liferay-ui:message key="total" />
				</div>
				<div class="videoStatistic_cell">
					<liferay-ui:message key="public" />
				</div>
				<div class="videoStatistic_cell">
					<liferay-ui:message key="private" />
				</div>
			</div>
			<div class="videoStatistic_row">
				<div class="videoStatistic_cell">
					<liferay-ui:message key="total" />
				</div>
				<div class="videoStatistic_cell_total"><%=totalCurrentVideo %></div>
				<div class="videoStatistic_cell_public"><%=totalPublic %>
					<div class="lineBreak"></div>
					(<%=totalPublicPerc%>
					<liferay-ui:message key="percentSymbol" />
					)
				</div>
				<div class="videoStatistic_cell_private"><%=totalPrivate %>
					<div class="lineBreak"></div>
					(<%=totalPrivatePerc%>
					<liferay-ui:message key="percentSymbol" />
					)
				</div>
			</div>
			<div class="videoStatistic_row">
				<div class="videoStatistic_cell">
					<liferay-ui:message key="since-yesterday" />
				</div>
				<div class="videoStatistic_cell_total"><%=totalYesterday  %></div>
				<div class="videoStatistic_cell_public"><%=totalYesterdayPublic %></div>
				<div class="videoStatistic_cell_private"><%=totalYesterdayPrivate %></div>
			</div>
			<div class="videoStatistic_row">
				<div class="videoStatistic_cell">
					<liferay-ui:message key="since-week" />
				</div>
				<div class="videoStatistic_cell_total"><%=totalOneWeek  %></div>
				<div class="videoStatistic_cell_public"><%=totalOneWeekPublic %></div>
				<div class="videoStatistic_cell_private"><%=totalOneWeekPrivate %></div>
			</div>
			<div class="videoStatistic_row">
				<div class="videoStatistic_cell">
					<liferay-ui:message key="since-month" />
				</div>
				<div class="videoStatistic_cell_total"><%=totalOneMonth  %></div>
				<div class="videoStatistic_cell_public"><%=totalOneMonthPublic %></div>
				<div class="videoStatistic_cell_private"><%=totalOneMonthPrivate %></div>
			</div>
			<div class="videoStatistic_row">
				<div class="videoStatistic_cell">
					<liferay-ui:message key="since-year" />
				</div>
				<div class="videoStatistic_cell_total"><%=totalOneYear  %></div>
				<div class="videoStatistic_cell_public"><%=totalOneYearPublic %></div>
				<div class="videoStatistic_cell_private"><%=totalOneYearPrivate %></div>
			</div>
		</div>
	</aui:layout>
</aui:fieldset>