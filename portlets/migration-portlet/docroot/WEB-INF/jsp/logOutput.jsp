 
 <c:if test="${not empty logInfoString}"> 
 <pre>
######## <liferay-ui:message key="logOutput" /> #########
<c:out value="${logInfoString}" />
</pre>
</c:if>