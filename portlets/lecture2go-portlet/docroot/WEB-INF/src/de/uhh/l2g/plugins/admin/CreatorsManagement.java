package de.uhh.l2g.plugins.admin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;

public class CreatorsManagement extends MVCPortlet {

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}
		
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameterMap().get("backURL")[0];
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		String t=request.getParameter("jobTitle");
		Creator creator = new CreatorImpl();
		creator.setFirstName(fn);
		creator.setLastName(ln);
		creator.setJobTitle(t);
		CreatorLocalServiceUtil.addCreator(creator);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCreatorId = new Long(request.getParameterMap().get("creatorId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		String t=request.getParameter("jobTitle");
		Creator creator = CreatorLocalServiceUtil.getCreator(reqCreatorId);
		creator.setFirstName(fn);
		creator.setLastName(ln);
		creator.setJobTitle(t);
		CreatorLocalServiceUtil.updateCreator(creator);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCreatorId = new Long(request.getParameterMap().get("creatorId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		//Video_Creator, Lecture_Creator, Creator
		CreatorLocalServiceUtil.deleteById(reqCreatorId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
