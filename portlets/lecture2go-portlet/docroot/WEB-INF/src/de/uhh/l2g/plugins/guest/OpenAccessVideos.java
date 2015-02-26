package de.uhh.l2g.plugins.guest;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class OpenAccessVideos extends MVCPortlet {
	
	public void viewRole(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		request.setAttribute("","");
		response.setRenderParameter("jspPage","/guest/videosList.jsp");
	}

}