<%@include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/oaipmh.jsp" /></portlet:renderURL>

<portlet:actionURL name="rebuildSmilAll" var="rebuildSmilAllURL"></portlet:actionURL>

	<label class="edit-video-lable"><liferay-ui:message key="Video-Processing"/></label>
	
	<aui:form action="${rebuildSmilAllURL}" name="rebuilSmilAll">
		<h2><liferay-ui:message key="limit-streaming"/></h2>
		<aui:row>
			<aui:select name="maxHeight" label="max-height">
				<aui:option value="" disabled="true" selected="true"><liferay-ui:message key="select-max-height"/></aui:option>
				<aui:option value="0"><liferay-ui:message key="best-quality"/></aui:option>
				<aui:option value="720">720p</aui:option>
				<aui:option value="540">540p</aui:option>
				<aui:option value="360">360p</aui:option>
			</aui:select>
		</aui:row>
		<aui:row>
			<aui:select name="maxBitrate" label="max-bitrate">
				<aui:option value="" disabled="true" selected="true"><liferay-ui:message key="select-max-bitrate"/></aui:option>
				<aui:option value="0"><liferay-ui:message key="best-quality"/></aui:option>
				<aui:option value="2500000">2,5 MBit/s</aui:option>
				<aui:option value="2000000">2 MBit/s</aui:option>
				<aui:option value="1500000">1,5 MBit/s</aui:option>
				<aui:option value="1000000">1 MBit/s</aui:option>
			</aui:select>
		</aui:row>
		<aui:row>
			<aui:select name="tenants" label="tenants" multiple="true">
				<aui:option value='<%= PropsUtil.get("lecture2go.videoprocessing.tenant") %>'><%= PropsUtil.get("lecture2go.videoprocessing.tenant") %></aui:option>
				<aui:option value='http://mediathek.hfmt-hamburg.de/'>http://mediathek.hfmt-hamburg.de</aui:option>
				<aui:option value='http://mediathek.hfbk.net/'>http://mediathek.hfbk.net</aui:option>
			</aui:select>
		</aui:row>
		
		<aui:button type="submit" value="submit"></aui:button>
	</aui:form>