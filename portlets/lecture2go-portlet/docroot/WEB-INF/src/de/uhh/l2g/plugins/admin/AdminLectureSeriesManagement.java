package de.uhh.l2g.plugins.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONArray;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.CategoryImpl;
import de.uhh.l2g.plugins.model.impl.CoordinatorImpl;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.TagcloudImpl;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.util.EmailManager;
import de.uhh.l2g.plugins.util.Htaccess;
import de.uhh.l2g.plugins.util.HtmlManager;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;

public class AdminLectureSeriesManagement extends MVCPortlet {
	
	public void viewLectureseries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		// requested lectureseries
		//TagcloudLocalServiceUtil.generateForAllLectureseries();
		//LectureseriesLocalServiceUtil.updateUploadAndGenerationDate();
		
		long reqLectureseriesId = new Long(request.getParameterMap().get("lectureseriesId")[0]);
		String backURL = request.getParameter("backURL");
		Lectureseries reqLectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqLectureseriesId);
		request.setAttribute("reqLectureseries", reqLectureseries);

		Map<String,String> institutions = new LinkedHashMap<String, String>();
		List<Producer> producers = new ArrayList<Producer>();
		request.setAttribute("institutions", institutions);
		request.setAttribute("producers", producers);
		request.setAttribute("backURL", backURL);

		response.setRenderParameter("jspPage", "/admin/editLectureseries.jsp");
	}
	
	public void removeLectureseries(ActionRequest request, ActionResponse response) {
		Long lId = new Long(request.getParameter("lectureseriesId"));
		String backURL = request.getParameter("backURL");
		//remove lecture series
		try {
			LectureseriesLocalServiceUtil.deleteLectureseries(lId);
			//dependencies
			Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId(lId);//institution
			Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//producer
			VideoLocalServiceUtil.unlinkLectureseriesFromVideos(lId);//video
			Video_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//video links to lecture series
			TagcloudLocalServiceUtil.deleteByObjectId(lId);//tag cloud
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void editLectureseries(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException, SystemException, UnsupportedEncodingException{
		User user = UserLocalServiceUtil.getUser(new Long(request.getRemoteUser()));
		EmailManager em = new EmailManager();
		//search tags
		ArrayList<String> tagCloudArrayString = new ArrayList<String>();

		Long lId = new Long(request.getParameter("lectureseriesId"));
		String[] producers = request.getParameterValues("producers");
		
		String[] institutions = request.getParameterValues("institutions");
		String s = request.getParameter("longDesc");
		String backURL = request.getParameter("backURL");
		Long semesterId = new Long(0);
		try{
			semesterId = new Long(request.getParameter("semesterId"));
			Term t = TermLocalServiceUtil.getTerm(semesterId);
			tagCloudArrayString.add(t.getPrefix());
			tagCloudArrayString.add(t.getYear());
			tagCloudArrayString.add(t.getPrefix());
			tagCloudArrayString.add(t.getPrefix()+" "+t.getYear());
		}catch(Exception e){}
		Long categoryId = new Long(0);
		try{
			categoryId = new Long(request.getParameter("categoryId"));
		}catch(Exception e){}
		
		//update object
		Lectureseries lectureseries = LectureseriesLocalServiceUtil.getLectureseries(lId);
		//only for admin or coordinator can update this flag
		if(new Lecture2GoRoleChecker().isCoordinator(user) || new Lecture2GoRoleChecker().isL2gAdmin(user)){
			lectureseries.setApproved(1);
		}
		lectureseries.setNumber(request.getParameter("number"));
		lectureseries.setCategoryId(categoryId);
		lectureseries.setName(request.getParameter("name"));
		lectureseries.setShortDesc(request.getParameter("shortDesc"));
		lectureseries.setTermId(semesterId);
		lectureseries.setLanguage(request.getParameter("language"));
		lectureseries.setFacultyName(request.getParameter("facultyName"));
		lectureseries.setPassword(request.getParameter("password"));
		lectureseries.setLongDesc(s);	
		
		//update database
		LectureseriesLocalServiceUtil.updateLectureseries(lectureseries);
		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		
		//update institution link
		//delete old entries first
		Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId(lectureseries.getLectureseriesId());
		//new links to institution
		for(int i=0;i<institutions.length;i++){
			Lectureseries_InstitutionImpl lf = new Lectureseries_InstitutionImpl();
			lf.setLectureseriesId(lId);
			Institution parentInst = new InstitutionImpl();
			Institution inst = new InstitutionImpl();
			inst = InstitutionLocalServiceUtil.getById(new Long(institutions[i]));
			parentInst = InstitutionLocalServiceUtil.getById(inst.getParentId());
			lf.setInstitutionId(inst.getInstitutionId());
			lf.setInstitutionParentId(inst.getParentId());
			if(!Lectureseries_InstitutionLocalServiceUtil.institutionAssignedToLectureseries(lf))
				Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lf);
			//
			tagCloudArrayString.add(inst.getName());
			tagCloudArrayString.add(parentInst.getName());
		}

		//new creators
		String[] firstNames = request.getParameterValues("firstName");
		String[] lastNames = request.getParameterValues("lastName");
		String[] jobTitles = request.getParameterValues("jobTitle");
		String[] genders = request.getParameterValues("gender");
		String[] creatorIds = request.getParameterValues("creatorId");
		Long cId = new Long(0);
		//remove all creators for this lecture series first
		Lectureseries_CreatorLocalServiceUtil.removeByLectureseriesId(lId);
		//and add the new creators
		try{
			for(int i=0;i<creatorIds.length;i++){
				if(creatorIds[i].equals("0")){
					Creator c = new CreatorImpl();
					c.setFirstName(firstNames[i]);
					c.setLastName(lastNames[i]);
					c.setJobTitle(jobTitles[i]);
					c.setGender(genders[i]);
					c.setFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]);
					List<Creator> cl = CreatorLocalServiceUtil.getByFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]);
					if(cl.size()==0)cId = CreatorLocalServiceUtil.addCreator(c).getCreatorId();
					else cId = CreatorLocalServiceUtil.getByFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]).iterator().next().getCreatorId();
				}else{
					cId = new Long(creatorIds[i]);
				}
				//add created creator to lecture series
				Lectureseries_Creator lc = new Lectureseries_CreatorImpl();
				lc.setLectureseriesId(lId);
				lc.setCreatorId(cId);
				if(Lectureseries_CreatorLocalServiceUtil.getByLectureseriesIdAndCreatorId(lId, cId).size()==0){
					Lectureseries_CreatorLocalServiceUtil.addLectureseries_Creator(lc);
				}
				Creator cr = CreatorLocalServiceUtil.getCreator(cId);
				tagCloudArrayString.add(cr.getFirstName());
				tagCloudArrayString.add(cr.getLastName());
				tagCloudArrayString.add(cr.getFullName());
			}
		}catch (NullPointerException e){}
		//update producer link
		//delete old entries first
		Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);
		//new links to producer
		for(int i=0;i<producers.length;i++){
			Producer_LectureseriesImpl pl = new Producer_LectureseriesImpl();
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			//producer not assigned to lecture series yet
			if(!Producer_LectureseriesLocalServiceUtil.producerAssignedToLectureseries(pl))
				Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}	
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//category
		Category ctgr = new CategoryImpl();
		try{ctgr = CategoryLocalServiceUtil.getCategory(lectureseries.getCategoryId());}catch(Exception e){}			
		tagCloudArrayString.add(ctgr.getName());
		tagCloudArrayString.add(lectureseries.getName());
		tagCloudArrayString.add(lectureseries.getNumber());

		//edit tag cloud
		TagcloudLocalServiceUtil.updateByObjectIdAndObjectClassType(tagCloudArrayString, lectureseries.getClass().getName(), lectureseries.getLectureseriesId());
		
		//send an email to coordinator and administrator, if logged in as producer
		if(new Lecture2GoRoleChecker().isProducer(user)){
			//get producer details
			Producer p = new ProducerImpl();
			p = ProducerLocalServiceUtil.getProdUcer(user.getUserId());//full object "getProdUser()"
			Coordinator c = new CoordinatorImpl();
			// Subject
			String SUBJECT = "lecture-series-edited";
			String BODY = "lecture-series-edited-by-user" + " \n" + "lecture : " + lectureseries.getNumber() + ": " + lectureseries.getName();
			//if coordinator exists
			boolean coordExists = false;
			// Coordinator for this Producer
			try{
				c = CoordinatorLocalServiceUtil.getByInstitution(p.getInstitutionId());
				if(c.getCoordinatorId()>0)coordExists = true;
			}catch(NoSuchElementException e){}
			//check 
			if(coordExists){
				String COORDEMAILADDRESS = c.getEmailAddress();				
				String BODY2 = "coordinator" + " " + c.getFirstName() + " " + c.getLastName() + " " + "lecture-series-edited-by-user" + "  \n" + "lecture" + ": "  +lectureseries.getNumber() + ": " + lectureseries.getName();
				// Send mail to Coordinator
				em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), COORDEMAILADDRESS, HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY));
				// Send mail to L2Go
				em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PropsUtil.get("lecture2go.response.email.address"), HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY2));
			}
			// Send mail to Producer
			String PRODEMAILADDRESS = p.getEmailAddress();
			String BODY3 = "lecture-series-edited-coordinator-notified" +"  \n" + "lecture" +" :" + lectureseries.getNumber() + ": " + lectureseries.getName();
			em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PRODEMAILADDRESS, HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY3));
		}	

		//send an email to  administrator, if logged in as coordinator
		if(new Lecture2GoRoleChecker().isCoordinator(user)){
			//get coordinator details
			Coordinator c = new CoordinatorImpl();
			c = CoordinatorLocalServiceUtil.getById(user.getUserId());
			// Subject
			String SUBJECT = "new-lectureseries";
			String BODY = "coordinator" +" "+ c.getFirstName() + " " + c.getLastName()+ " " + "has-entered-a-new-event" + " \n" + "lecture" +":" + lectureseries.getNumber() + ": " + lectureseries.getName();
			// Send mail to L2Go
			em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PropsUtil.get("lecture2go.response.email.address")  , HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY));
		}	
	}

	public void addLectureseries(ActionRequest request, ActionResponse response) throws SystemException, PortalException, UnsupportedEncodingException {
		User user = UserLocalServiceUtil.getUser(new Long(request.getRemoteUser()));
		EmailManager em = new EmailManager();
		//search tags
		String tagCloudString = "";
		ArrayList<String> tagCloudArrayString = new ArrayList<String>();
		
		String s = request.getParameter("longDesc");
		String[] producers = request.getParameterValues("producers");
		String[] institutions = request.getParameterValues("institutions");
		String backURL = request.getParameter("backURL");
		Long semesterId = new Long(0);
		try{
			semesterId = new Long(request.getParameter("semesterId"));
			Term t = TermLocalServiceUtil.getTerm(semesterId);
			tagCloudString += t.getPrefix()+ " ### "+t.getYear()+" ### "+t.getPrefix()+" "+t.getYear()+" ### ";
			tagCloudArrayString.add(t.getPrefix()+" "+t.getYear());
		}catch(Exception e){}
		Long categoryId = new Long(0);
		try{
			categoryId = new Long(request.getParameter("categoryId"));
		}catch(Exception e){}
		
		//build lecture series object
		LectureseriesImpl lectureseries = new LectureseriesImpl();
		lectureseries.setApproved(0);
		lectureseries.setNumber(request.getParameter("number"));
		lectureseries.setCategoryId(categoryId);
		lectureseries.setName(request.getParameter("name"));
		lectureseries.setShortDesc(request.getParameter("shortDesc"));
		lectureseries.setTermId(semesterId);
		lectureseries.setLanguage(request.getParameter("language"));
		lectureseries.setFacultyName(request.getParameter("facultyName"));
		lectureseries.setPassword(request.getParameter("password"));
		lectureseries.setLongDesc(s);
		
		//save object to database
		Lectureseries newlect = LectureseriesLocalServiceUtil.addLectureseries(lectureseries);
		Long lId = newlect.getLectureseriesId();

		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		
		//link to institution
		for(int i=0;i<institutions.length;i++){
			Lectureseries_InstitutionImpl lf = new Lectureseries_InstitutionImpl();
			lf.setLectureseriesId(lId);
			Institution parentInst = new InstitutionImpl();
			Institution inst = new InstitutionImpl();
			inst = InstitutionLocalServiceUtil.getById(new Long(institutions[i]));
			parentInst = InstitutionLocalServiceUtil.getById(inst.getParentId());
			
			lf.setInstitutionId(inst.getInstitutionId());
			lf.setInstitutionParentId(inst.getParentId());
			Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lf);
			tagCloudArrayString.add(inst.getName());
			tagCloudArrayString.add(parentInst.getName());
		}

		//new creators
		String[] firstNames = request.getParameterValues("firstName");
		String[] lastNames = request.getParameterValues("lastName");
		String[] jobTitles = request.getParameterValues("jobTitle");
		String[] genders = request.getParameterValues("gender");
		String[] creatorIds = request.getParameterValues("creatorId");
		Long cId = new Long(0);
		//remove all creators for this lecture series first
		Lectureseries_CreatorLocalServiceUtil.removeByLectureseriesId(lId);
		//and add the new creators
		try{
			for(int i=0;i<creatorIds.length;i++){
				if(creatorIds[i].equals("0")){
					Creator c = new CreatorImpl();
					c.setFirstName(firstNames[i]);
					c.setLastName(lastNames[i]);
					c.setJobTitle(jobTitles[i]);
					c.setGender(genders[i]);
					c.setFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]);
					List<Creator> cl = CreatorLocalServiceUtil.getByFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]);
					if(cl.size()==0)cId = CreatorLocalServiceUtil.addCreator(c).getCreatorId();
					else cId = CreatorLocalServiceUtil.getByFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]).iterator().next().getCreatorId();
				}else{
					cId = new Long(creatorIds[i]);
				}
				//add created creator to lecture series
				Lectureseries_Creator lc = new Lectureseries_CreatorImpl();
				lc.setLectureseriesId(lId);
				lc.setCreatorId(cId);
				if(Lectureseries_CreatorLocalServiceUtil.getByLectureseriesIdAndCreatorId(lId, cId).size()==0){
					Lectureseries_CreatorLocalServiceUtil.addLectureseries_Creator(lc);
				}
				Creator cr = CreatorLocalServiceUtil.getCreator(cId);
				tagCloudArrayString.add(cr.getFirstName());
				tagCloudArrayString.add(cr.getLastName());
				tagCloudArrayString.add(cr.getFullName());
				
			}
		}catch (NullPointerException e){}
		//link to producer
		for(int i=0;i<producers.length;i++){
			Producer_LectureseriesImpl pl = new Producer_LectureseriesImpl();
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}
		
		//category 
		Tagcloud tagcloud = new TagcloudImpl();
		Category ctgr = new CategoryImpl();
		try{ctgr = CategoryLocalServiceUtil.getCategory(newlect.getCategoryId());}catch(Exception e){}			
		tagCloudArrayString.add(ctgr.getName());
		tagCloudArrayString.add(newlect.getName());
		tagCloudArrayString.add(newlect.getNumber());
		
		//Tag cloud
		tagcloud.setTags(tagCloudString);
		TagcloudLocalServiceUtil.add(tagCloudArrayString, newlect.getClass().getName(), newlect.getLectureseriesId()); 

		//
		request.setAttribute("institutions", institutions);
		request.setAttribute("producers", producers);
		request.setAttribute("backURL", backURL);
		//send an email to coordinator and administrator, if logged in as producer
		if(new Lecture2GoRoleChecker().isProducer(user)){
			//get producer details
			Producer p = new ProducerImpl();
			p = ProducerLocalServiceUtil.getProdUcer(user.getUserId());//full object "getProdUser()"
			Coordinator c = new CoordinatorImpl();
			// Subject
			String SUBJECT = "new-request-for-approval";
			String BODY = "you-have-a-new-request-for-approval" + " \n" + "lecture : " + newlect.getNumber() + ": " + newlect.getName();
			//if coordinator exists
			boolean coordExists = false;
			// Coordinator for this Producer
			try{
				c = CoordinatorLocalServiceUtil.getByInstitution(p.getInstitutionId());
				if(c.getCoordinatorId()>0)coordExists = true;
			}catch(NoSuchElementException e){}
			//check 
			if(coordExists){
				String COORDEMAILADDRESS = c.getEmailAddress();				
				String BODY2 = "coordinator" + " " + c.getFirstName() + " " + c.getLastName() + " " + "got-a-new-request-for-approval" + "  \n" + "lecture" + ": "  +newlect.getNumber() + ": " + newlect.getName();
				// Send mail to Coordinator
				em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), COORDEMAILADDRESS, HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY));
				// Send mail to L2Go
				em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PropsUtil.get("lecture2go.response.email.address"), HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY2));
			}
			// Send mail to Producer
			String PRODEMAILADDRESS = p.getEmailAddress();
			String BODY3 = "your-request-was-sent" +"  \n" + "lecture" +" :" + newlect.getNumber() + ": " + newlect.getName();
			em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PRODEMAILADDRESS, HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY3));
		}	

		//send an email to  administrator, if logged in as coordinator
		if(new Lecture2GoRoleChecker().isCoordinator(user)){
			//get coordinator details
			Coordinator c = new CoordinatorImpl();
			c = CoordinatorLocalServiceUtil.getById(user.getUserId());
			// Subject
			String SUBJECT = "new-lectureseries";
			String BODY = "coordinator" +" "+ c.getFirstName() + " " + c.getLastName()+ " " + "has-entered-a-new-event" + " \n" + "lecture" +":" + newlect.getNumber() + ": " + newlect.getName();
			// Send mail to L2Go
			em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PropsUtil.get("lecture2go.response.email.address")  , HtmlManager.ISO88591toUTF8(SUBJECT), HtmlManager.ISO88591toUTF8(BODY));
		}	
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		String resourceID = resourceRequest.getResourceID();
		
		if(resourceID.equals("getJSONCreator")){
			String creatorId = ParamUtil.getString(resourceRequest, "creatorId");
			Long cId = new Long(0);
			try{
				cId = new Long(creatorId);
			}catch(Exception e){
				e.printStackTrace();
			}
			JSONArray json = new JSONArray();
			try {
				json = CreatorLocalServiceUtil.getJSONCreator(cId);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			writeJSON(resourceRequest, resourceResponse, json);			
		}

	}

}
