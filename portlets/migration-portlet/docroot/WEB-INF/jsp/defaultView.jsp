<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ include file="/WEB-INF/jsp/include.jsp" %>


<h3><liferay-ui:message key="migrationPortlet" /></h3>


<portlet:actionURL var="testExternalDBEntitiesUrl">
	<portlet:param name="action" value="testExternalDBEntities" />
</portlet:actionURL>

<portlet:actionURL var="executeUserMigrationUrl">
	<portlet:param name="action" value="migrateUser" />
</portlet:actionURL>

<portlet:actionURL var="executeSegmentMigrationUrl">
	<portlet:param name="action" value="migrateSegments" />
</portlet:actionURL>

<portlet:actionURL var="executeCoordinatorMigrationUrl">
	<portlet:param name="action" value="migrateCoordinators" />
</portlet:actionURL>

<portlet:actionURL var="executeProducerMigrationUrl">
	<portlet:param name="action" value="migrateProducers" />
</portlet:actionURL>

<portlet:actionURL var="executeVideoMigrationUrl">
	<portlet:param name="action" value="migrateVideos" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateOfficeUrl">
	<portlet:param name="action" value="migrateOffices" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateMetadataUrl">
	<portlet:param name="action" value="migrateMetadatas" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateInstitutionUrl">
	<portlet:param name="action" value="migrateInstitutions" />
</portlet:actionURL>


<portlet:actionURL var="executeMigrateLicenseUrl">
	<portlet:param name="action" value="migrateLicenses" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateHostUrl">
	<portlet:param name="action" value="migrateHosts" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateL2gsysUrl">
	<portlet:param name="action" value="migrateL2gSyses" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateLectureseriesUrl">
	<portlet:param name="action" value="migrateLectureserieses" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateVideohitlistUrl">
	<portlet:param name="action" value="migrateVideohitlists" />
</portlet:actionURL>

<portlet:actionURL var="executeMigrateLastvideolistUrl">
	<portlet:param name="action" value="migrateLastvideolists" />
</portlet:actionURL>




<portlet:actionURL var="executeLectureseriesFacilityUrl">
	<portlet:param name="action" value="migrateLectureseriesFacilities" />
</portlet:actionURL>


<portlet:actionURL var="executeVideo_InstitutionUrl">
	<portlet:param name="action" value="migrateVideo_Institution" />
</portlet:actionURL>

<portlet:actionURL var="executeProducer_LectureseriesUrl">
	<portlet:param name="action" value="migrateProducer_Lectureseries" />
</portlet:actionURL>

<portlet:actionURL var="executeInstitution_HostUrl">
	<portlet:param name="action" value="migrateInstitution_Host" />
</portlet:actionURL>


<portlet:actionURL var="executeVideo_LectureseriesUrl">
	<portlet:param name="action" value="migrateVideo_Lectureseries" />
</portlet:actionURL>

<portlet:actionURL var="executeVideo_CategoryUrl">
	<portlet:param name="action" value="migrateVideo_Category" />
</portlet:actionURL>

<portlet:actionURL var="executeCreatorUrl">
	<portlet:param name="action" value="migrateCreator" />
</portlet:actionURL>

<portlet:actionURL var="executeStatisticUrl">
	<portlet:param name="action" value="migrateStatistic" />
</portlet:actionURL>

<portlet:actionURL var="updateCounterTableValuesUrl">
	<portlet:param name="action" value="migrateCounterTableValues" />
</portlet:actionURL>

<p><liferay-ui:message key="migrationActions" /></p>


<p><a href="<c:out value="${testExternalDBEntitiesUrl}" />"><liferay-ui:message key="testExternalDBEntities" /></a></p>


<%@ include file="/WEB-INF/jsp/logOutput.jsp" %> 

 <pre>
 <table style="width:100%">
  <tr>
    <th align="left" width=""><b>User Entities</b></th>
    <th align="left" width="10%"><b>LF52</b></th>
    <th align="left" width="15%"><b>LF62 migrated</b></th>
    <th align="left" width="10%"><b>Action</b></th>
    <th align="left" width="10%">Status</th>
    <th align="left" ></th>
  </tr>
  <tr>
    <td>User (& Contact & Adresses)</td>
    <td><c:out value="${userEntrieSize}" /></td>
    <td><c:out value="${userEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeUserMigrationUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${userOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  
  <tr>
    <td>Contact</td>
    <td><c:out value="${contactEntrieSize}" /></td>
    <td><c:out value="${contactEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${userOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  
   <tr>
    <td>Address</td>
    <td><c:out value="${addressEntrieSize}" /></td>
    <td><c:out value="${addressEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${userOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  
  <tr>
    <td>Segment</td>
    <td><c:out value="${segmentEntrieSize}" /></td>
    <td><c:out value="${segmentEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeSegmentMigrationUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${segmentOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>  
  <tr>
    <td>Coordintator</td>
    <td><c:out value="${coordinatorEntrieSize}" /></td>
    <td><c:out value="${coordinatorEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeCoordinatorMigrationUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${coordinatorOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  <tr>
    <td>Producer</td>
    <td><c:out value="${producerEntrieSize}" /></td>
    <td><c:out value="${producerEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeProducerMigrationUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${producerOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  <tr>
    <td>Video</td>
    <td><c:out value="${videoEntrieSize}" /></td>
    <td><c:out value="${videoEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeVideoMigrationUrl}" />"><liferay-ui:message key="migrate" /></td>
    <td><c:out value="${videoOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
</table> 
</pre>


<pre>
 <table style="width:100%">
  <tr>
    <th align="left" width=""><b>Single Entities</b></th>
    <th align="left" width="10%"><b>LF52</b></th>
    <th align="left" width="15%"><b>LF62 migrated</b></th>
    <th align="left" width="10%"><b>Action</b></th>
    <th align="left" width="10%"><b>Satus</b></th>
    <th align="left"></th>
  </tr>
  
  <tr>
    <td>Office</td>
    <td><c:out value="${officeEntrieSize}" /></td>
    <td><c:out value="${officeEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateOfficeUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${officeOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>  
  
  <tr>
    <td>Metadata</td>
    <td><c:out value="${metadataEntrieSize}" /></td>
    <td><c:out value="${metadataEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateMetadataUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${metadataOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  
  <tr>
    <td>Institution / Facility</td>
    <td><c:out value="${faciliyEntrieSize}" /></td>
    <td><c:out value="${InstitutionEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateInstitutionUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${institutionOkflag}" escapeXml="false" /></td>
    <td></td></tr> 
   
  <tr>
    <td>License</td>
    <td><c:out value="${licenseEntrieSize}" /></td>
    <td><c:out value="${licenseEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateLicenseUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${licenseOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr> 
  
  <tr>
    <td>Host</td>
    <td><c:out value="${hostEntrieSize}" /></td>
    <td><c:out value="${hostEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateHostUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${hostOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr> 
  
  <tr>
    <td>L2GSys / Sys</td>
    <td><c:out value="${l2gsysEntrieSize}" /></td>
    <td><c:out value="${sysEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateL2gsysUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${sysOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>   
  
  <tr>
    <td>Lectureseries (Term && Categories &&  Maps Latest Video ID)</td>
    <td><c:out value="${lectureseriesEntrieSize}" /></td>
    <td><c:out value="${lectureseriesEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateLectureseriesUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${lectureseriesOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
    
  <tr>
    <td>&#10149; Lecturesereries.setTermId</td>
    <td>0</td>
    <td><c:out value="${lectureseriesEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${lectureseriesOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  
  
  <tr>
    <td>&#10149; Term</td>
    <td>0</td>
    <td><c:out value="${termEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${lectureseriesOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>

  <tr>
    <td>&#10149; Category</td>
    <td>0</td>
    <td><c:out value="${categoryEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${lectureseriesOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  

  <tr>
    <td>Videohitlist</td>
    <td><c:out value="${videohitlistEntrieSize}" /></td>
    <td><c:out value="${videohitlistEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateVideohitlistUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${videohitlistOkflag}" escapeXml="false" /></td>
    <td></td>    
  </tr>   
    
  <tr>
    <td>Lastvideolist</td>
    <td><c:out value="${lastvideolistEntrieSize}" /></td>
    <td><c:out value="${lastvideolistEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeMigrateLastvideolistUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${lastvideolistOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>        
  </table> 
</pre>
  
  
<pre>
 <table style="width:100%">
  <tr>
    <th align="left" width="" ><b>Mapping Entities</b></th>
    <th align="left" width="10%" ><b>LF52</b></th>
    <th align="left" width="15%" ><b>LF62 migrated</b></th>
    <th align="left" width="10%"><b>Action</b></th>
    <th align="left" width="10%"><b>Satus</b></th>
    <th align="left"></th>
  </tr>
  <tr>
    <td>Lectureseries_Institution</td>
    <td><c:out value="${legacyLectureSeriesFacitityEntrieSize}" /></td>
    <td><c:out value="${lectureSeriesInstitutionEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeLectureseriesFacilityUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${lectureseriesInstitutionOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>  
  <tr>
    <td>Producer_LectureSeries</td>
    <td><c:out value="${legacyProducerLectureseriesEntrieSize}" /></td>
    <td><c:out value="${producerLectureseriesEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeProducer_LectureseriesUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${producerLectureseriesOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>  
  
   <tr>
    <td>Video_Faclilty</td>
    <td><c:out value="${legacyVideoFacilityEntrieSize}" /></td>
    <td><c:out value="${videoFacilityEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeVideo_InstitutionUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${videoFacilityOkflag}" escapeXml="false" /></td>
    <td></td>    
  </tr>  
  
  
  <tr>
    <td>Facility_Host</td>
    <td><c:out value="${legacyFacilityHostEntrieSize}" /></td>
    <td><c:out value="${facilityHostEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeInstitution_HostUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${facilityHostOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>   
  <tr>
    <td>Video_Lectureseries (req: TermId )</td>
    <td>0</td>
    <td><c:out value="${videoLectureseriesEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeVideo_LectureseriesUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${videoLectureseriesOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  <tr>
    <td>&#10149; Video.setTermId()</td>
    <td>0</td>
    <td><c:out value="${videoLectureseriesEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${videoLectureseriesOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>  
  <tr>
    <td>Video_Category (req: Video_Lectureseries)</td>
    <td>0</td>
    <td><c:out value="${videoCategoryEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeVideo_CategoryUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${videoCategoryOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>  
  <tr>
    <td>Creator</td>
    <td>0</td>
    <td><c:out value="${creatorEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeCreatorUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${creatorOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>    
  <tr>
    <td>&#10149; Lectureseries_Creator</td>
    <td>0</td>
    <td><c:out value="${lectureseriesCreatorEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${creatorOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  <tr>
    <td>&#10149; Video_Creator</td>
    <td>0</td>
    <td><c:out value="${videoCreatorEntrieSize62}" /></td>
    <td></td>
    <td><c:out value="${creatorOkflag}" escapeXml="false" /></td>
    <td></td>
  </tr> 
  <tr>
    <td>Statistic</td>
    <td><c:out value="${statisticEntrieSize}" /></td>
    <td><c:out value="${statisticEntrieSize62}" /></td>
    <td><a href="<c:out value="${executeStatisticUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${statisticokflag}" escapeXml="false" /></td>
    <td></td>
  </tr>
  <tr>
    <td> Update Counter Table Values</td>
    <td>--</td>
   	<td>--</td>
    <td><a href="<c:out value="${updateCounterTableValuesUrl}" />"><liferay-ui:message key="migrate" /></a></td>
    <td><c:out value="${updateCounterTableValuesOkFlag}" escapeXml="false" /></td>
    <td></td>
  </tr>   
  </table> 
</pre>
