<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h3><liferay-ui:message key="migrationPortlet" /></h3>

<liferay-ui:message key="pleaseCheckProps" />


<%@ include file="/WEB-INF/jsp/logOutput.jsp" %>

<pre>
 
EXAMPLE OF PROPS Required 
 
###################################################################################################################
# L2GO Migration Portlet  START
###################################################################################################################


########## External DB   MySQL Database Configuration ##########

jdbc.legacy.driverClassName=com.mysql.jdbc.Driver
jdbc.legacy.url=jdbc:mysql://localhost/l2golf52?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
jdbc.legacy.username=XXXX
jdbc.legacy.password=YYYY


# target company id of your Liferay 6.2 instance
migration.portlet.target.companyid=10155

# target site id of your Liferay 6.2 instance
migration.portlet.target.siteid=20182

# target sites the user shall be linked to, can be comma separated
migration.portlet.target.sites=20182


###################################################################################################################
# L2GO Migration Portlet  END
###################################################################################################################

</pre>


