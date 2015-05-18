<%@ page import="org.json.JSONObject"%>
<%@ page import="de.uhh.l2g.webservices.*"%>

<style type="text/css">
	#institution.appmon_support_form_row {
	    display: none;
	}
	#system.appmon_support_form_row {
	    display: none;
	}
	#role.appmon_support_form_row {
	    display: none;
	}
	#gender.appmon_support_form_row {
	    display: none;
	}
	#subject.appmon_support_form_row {
	    display: none;
	}
</style>
<%
	int facultyId = 0;
	String institut = "";
	String option1 = request.getParameter("option1");
	switch(facultyId){
		case 3: institut = "UHH-Jura";break;
		case 4: institut = "UHH-WiSo";break;
		case 5: institut = "UHH-Medizin";break;
		case 6: institut = "UHH-EW";break;
		case 7: institut = "UHH-GWiss";break;
		case 8: institut = "UHH-MIN";break;
		case 203: institut = "UHH-PB";break;
		case 204: institut = "UHH-BWL";break;
		default: institut = "Fakultätübergreifend";break;
	}
	JSONObject jsn = new JSONObject();
	jsn.put("institution",institut);
	jsn.put("system","Lecture2Go");
	jsn.put("role","Lecture2Go-Benutzer");
	jsn.put("gender","");
	jsn.put("firstname",request.getParameter("firstname"));
	jsn.put("lastname",request.getParameter("lastname"));
	jsn.put("email",request.getParameter("email"));
	jsn.put("subject","###");
	jsn.put("body",request.getParameter("body"));
	jsn.put("ergebnis",request.getParameter("ergebnis"));
	jsn.put("option1",option1);
	jsn.put("result",request.getParameter("result"));
	jsn.put("spamprotect",request.getParameter("spamprotect"));
%>
<div id="metadata">
	<div id="description">
		<c:if test="${model.lectureseries.instructorsString==''}">
	  		${model.metadata.creator}
	  	</c:if>
		<c:if test="${model.lectureseries.instructorsString>''}">
	  		${model.lectureseries.instructorsString}
	  	</c:if>
	</div>
	<em class="title">${model.video.title}</em>
	
	<div class="clear"></div>
	<em class="smallitalic">
		<c:if test="${model.video.office!=null}">${office}: <a href="${model.video.office.www}" target="blank"> ${model.video.office.name} </a></c:if><br/>
		${supportdescription}
	</em>
	
	<a name="cont"></a><br/><br/>
<%
	//SupportFormularClient sfc = new SupportFormularClient("mail4eLearnSupport","",jsn.toString(),"");
	//out.print(sfc.getFormular());
%>

<% 
	if(option1!=null){
		%>
		<script type="text/javascript">
			$(function() {
				 // activate contact tab
				 $("#tabs").tabs( "option", "active", $('#tabs >ul >li').size()-1 );
				 scrollToAnchor('cont');
			 });
			
			function scrollToAnchor(aid){
			    var aTag = $("a[name='"+ aid +"']");
			    $('html,body').animate({scrollTop: aTag.offset().top},'slow');
			}
		</script>
		<%		
	}
%>
</div>