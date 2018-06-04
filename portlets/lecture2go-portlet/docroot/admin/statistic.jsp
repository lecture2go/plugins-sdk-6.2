<%@include file="/init.jsp"%>
<%@ page import="de.uhh.l2g.plugins.model.VideoStatistic"%>
<%@ page
	import="de.uhh.l2g.plugins.service.StatisticLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
JSONObject jsonObject = StatisticLocalServiceUtil.getAllStatistics();

JSONArray array = (JSONArray) jsonObject.get("statistic");

String totalVideos = "-";
String totalPublic = "";
String totalPrivate = "";

String totalYesterday = "0";
String totalYesterdayPublic = "0";
String totalYesterdayPrivate = "0";

String totalOneWeek = "0";
String totalOneWeekPublic = "0";
String totalOneWeekPrivate = "0";

String totalOneMonth = "0";
String totalOneMonthPublic = "0";
String totalOneMonthPrivate = "0";

String totalOneYear ="0";
String totalOneYearPublic = "0";
String totalOneYearPrivate = "0";

for(int i=0;i<array.length();i++){
    JSONObject object = array.getJSONObject(i);
    String timespan = (String)object.get("timespan");
    
    if(timespan.equals("0")){
    	 totalVideos = object.get("total") + "";
    	 totalPublic = object.get("public") + "";
		 totalPrivate = object.get("private") + "";    	
    }
    if(timespan.equals("DAY")){
		 totalYesterday = object.get("totalDiff") + "";
		 totalYesterdayPublic = object.get("publicDiff") + "";
		 totalYesterdayPrivate = object.get("privateDiff") + "";    	
    }
    if(timespan.equals("WEEK")){
		 totalOneWeek = object.get("totalDiff") + "";
		 totalOneWeekPublic = object.get("publicDiff") + "";
		 totalOneWeekPrivate = object.get("privateDiff") + "";  	
    }
    if(timespan.equals("MONTH")){
		 totalOneMonth = object.get("totalDiff") + "";
		 totalOneMonthPublic = object.get("publicDiff") + "";
		 totalOneMonthPrivate = object.get("privateDiff") + "";    	
    }
    if(timespan.equals("YEAR")){
		 totalOneYear = object.get("totalDiff") + "";
		 totalOneYearPublic = object.get("publicDiff") + "";
		 totalOneYearPrivate = object.get("privateDiff") + "";
    }
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
				<div class="videoStatistic_cell_total"><%=totalVideos %></div>
				<div class="videoStatistic_cell_public"><%=totalPublic %></div>
				<div class="videoStatistic_cell_private"><%=totalPrivate %></div>
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