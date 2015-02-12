package de.uhh.l2g.plugins.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

public class AdminInstitutionManagement extends MVCPortlet {
	
	   
	
	public void viewInstitutionList(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);
		
	    String name = ParamUtil.getString(request, "institution");
	    String streamer = ParamUtil.getString(request, "streamingserver");

	    try {
	        InstitutionLocalServiceUtil.addInstitution(name, streamer, serviceContext);

	        SessionMessages.add(request, "institutionAdded");

	    } catch (Exception e) {
	        SessionErrors.add(request, e.getClass().getName());

	        response.setRenderParameter("mvcPath",
	            "/admin/institutionList.jsp");
	    }

		
	}
	
	public void addInstitutionEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);
		
	    String name = ParamUtil.getString(request, "institution");
	    String streamer = ParamUtil.getString(request, "serverselect");

	    try {
	         InstitutionLocalServiceUtil.addInstitution(
	              name, streamer, serviceContext);

	         SessionMessages.add(request, "entryAdded");

	        // response.setRenderParameter("institutionId",
	        //      Long.toString(institutionId));

	       } catch (Exception e) {
	         SessionErrors.add(request, e.getClass().getName());

	                            PortalUtil.copyRequestParameters(request, response);

	         response.setRenderParameter("mvcPath",
	              "/admin/institutionList.jsp");
	       }

		
	}
	
	

}