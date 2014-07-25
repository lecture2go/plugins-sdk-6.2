<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>

<portlet:defineObjects />
<%
	Locale locale = renderRequest.getLocale();
	ResourceBundle resource = portletConfig.getResourceBundle(locale);
%>

<c:set var="selectfaculty" value='<%= resource.getString("select-faculty") %>'/>
<c:set var="selectproducer" value='<%= resource.getString("select-producer") %>'/>
<c:set var="selectsemester" value='<%= resource.getString("select-semester") %>'/>
<c:set var="selectstatus" value='<%= resource.getString("select-status") %>'/>
<c:set var="approved" value='<%= resource.getString("approved") %>'/>
<c:set var="pending" value='<%= resource.getString("pending") %>'/>
<c:set var="addnewlectureserie" value='<%= resource.getString("add-new-lecture-serie") %>'/>
<c:set var="yourareabouttodeletealllectureseriedata" value='<%= resource.getString("your-are-about-to-delete-all-lecture-serie-data") %>'/>
<c:set var="deletelectureserie" value='<%= resource.getString("delete-lecture-serie") %>'/>
<c:set var="donotallowlectureserie" value='<%= resource.getString("do-not-allow-lecture-serie") %>'/>
<c:set var="allowlectureserie" value='<%= resource.getString("allow-lecture-serie") %>'/>
<c:set var="nolecturefound" value='<%= resource.getString("no-lecture-found") %>'/>
<c:set var="gotofirstpage" value='<%= resource.getString("go-to-first-page") %>'/>
<c:set var="gotopage" value='<%= resource.getString("go-to-page") %>'/>
<c:set var="gotolastpage" value='<%= resource.getString("go-to-last-page") %>'/>
<c:set var="of" value='<%= resource.getString("of") %>'/>
<c:set var="page" value='<%= resource.getString("page") %>'/>
<c:set var="filter" value='<%= resource.getString("filter") %>'/>
<c:set var="resultspersite" value='<%= resource.getString("results-per-site") %>'/>
<c:set var="pleasecorrectinput" value='<%= resource.getString("please-correct-input") %>'/>
<c:set var="lectureid" value='<%= resource.getString("lecture-id") %>'/>
<c:set var="enterlectureid" value='<%= resource.getString("enter-lecture-id") %>'/>
<c:set var="lecturename" value='<%= resource.getString("lecture-name") %>'/>
<c:set var="enterlecturename" value='<%= resource.getString("enter-lecture-name") %>'/>
<c:set var="selectlecturetype" value='<%= resource.getString("select-lecture-type") %>'/>
<c:set var="facilities" value='<%= resource.getString("facilities") %>'/>
<c:set var="add" value='<%= resource.getString("add") %>'/>
<c:set var="pleaceaddfacility" value='<%= resource.getString("pleace-add-facility") %>'/>
<c:set var="producer" value='<%= resource.getString("producer") %>'/>
<c:set var="addoneproducer" value='<%= resource.getString("add-one-producer") %>'/>
<c:set var="shortdescription" value='<%= resource.getString("short-description") %>'/>
<c:set var="semester" value='<%= resource.getString("semester") %>'/>
<c:set var="addnewsemester" value='<%= resource.getString("add-new-semester") %>'/>
<c:set var="languages" value='<%= resource.getString("languages") %>'/>
<c:set var="addonelanguage" value='<%= resource.getString("add-one-language") %>'/>
<c:set var="lecturers" value='<%= resource.getString("lecturers") %>'/>
<c:set var="exampleprofname" value='<%= resource.getString("example-prof-name") %>'/>
<c:set var="password" value='<%= resource.getString("password") %>'/>
<c:set var="description" value='<%= resource.getString("description") %>'/>
<c:set var="save" value='<%= resource.getString("save") %>'/>
<c:set var="lecturetype" value='<%= resource.getString("lecture-type") %>'/>
<c:set var="gotooverview" value='<%= resource.getString("go-to-overview") %>'/>
<c:set var="editthisevent" value='<%= resource.getString("edit-this-event") %>'/>
<c:set var="gotooverview" value='<%= resource.getString("go-to-overview") %>'/>
<c:set var="newinstitution" value='<%= resource.getString("new-institution") %>'/>
<c:set var="newinstitution" value='<%= resource.getString("new-institution") %>'/>
<c:set var="choosestreamer" value='<%= resource.getString("choose-streamer") %>'/>
<c:set var="rootdirectory" value='<%= resource.getString("root-directory") %>'/>
<c:set var="order" value='<%= resource.getString("order") %>'/>
<c:set var="up" value='<%= resource.getString("up") %>'/>
<c:set var="down" value='<%= resource.getString("down") %>'/>
<c:set var="reallydeleteinstitution" value='<%= resource.getString("really-delete-institution") %>'/>
<c:set var="deleteinstitution" value='<%= resource.getString("delete-institution") %>'/>
<c:set var="httpstreamer" value='<%= resource.getString("http-streamer") %>'/>
<c:set var="edit" value='<%= resource.getString("edit") %>'/>
<c:set var="zb" value='<%= resource.getString("zb") %>'/>
<c:set var="orip" value='<%= resource.getString("or-ip") %>'/>
<c:set var="httpstreamerlist" value='<%= resource.getString("http-streamer-list") %>'/>
<c:set var="reallydeletestreamer" value='<%= resource.getString("really-delete-streamer") %>'/>
<c:set var="deletestreamer" value='<%= resource.getString("delete-streamer") %>'/>
<c:set var="addnewhttpstreamer" value='<%= resource.getString("add-new-http-streamer") %>'/>
<c:set var="zb" value='<%= resource.getString("zb") %>'/>
<c:set var="resultspersite" value='<%= resource.getString("results-per-site") %>'/>
<c:set var="chooserole" value='<%= resource.getString("choose-role") %>'/>
<c:set var="username" value='<%= resource.getString("user-name") %>'/>
<c:set var="student" value='<%= resource.getString("student") %>'/>
<c:set var="coordinator" value='<%= resource.getString("coordinator") %>'/>
<c:set var="l2gadmin" value='<%= resource.getString("l2gadmin") %>'/>
<c:set var="producer" value='<%= resource.getString("producer") %>'/>
<c:set var="state" value='<%= resource.getString("state") %>'/>
<c:set var="stopped" value='<%= resource.getString("stopped") %>'/>
<c:set var="started" value='<%= resource.getString("started") %>'/>
<c:set var="threadisupdatedevery" value='<%= resource.getString("thread-is-updated-every") %>'/>
<c:set var="start" value='<%= resource.getString("start") %>'/>
<c:set var="stop" value='<%= resource.getString("stop") %>'/>
<c:set var="milliseconds" value='<%= resource.getString("milliseconds") %>'/>
<c:set var="hours" value='<%= resource.getString("hours") %>'/>
<c:set var="coordinatorfor" value='<%= resource.getString("coordinator-for") %>'/>
<c:set var="producerfor" value='<%= resource.getString("producer-for") %>'/>
<c:set var="facility" value='<%= resource.getString("facility") %>'/>
<c:set var="save" value='<%= resource.getString("save") %>'/>
<c:set var="name" value='<%= resource.getString("name") %>'/>
<c:set var="gotooverview" value='<%= resource.getString("go-to-overview") %>'/>
<c:set var="languagesforselect" value='<%= resource.getString("languages-for-select") %>'/>
<c:set var="eventtypesforselect" value='<%= resource.getString("event-types-for-select") %>'/>
<c:set var="pleasechoosefilterunlockedtomanagelectureseries" value='<%= resource.getString("please-choose-filter-unlocked-to-manage-lectureseries") %>'/>
<c:set var="nolectureseriestoapprove" value='<%= resource.getString("no-lectureseries-to-approve") %>'/>
<c:set var="editandapprove" value='<%= resource.getString("edit-and-approve") %>'/>

