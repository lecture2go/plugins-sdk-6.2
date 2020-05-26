package de.uhh.l2g.plugins.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

public class AdminStreamerManagement extends MVCPortlet {
	protected static Log LOG = LogFactoryUtil.getLog(AdminInstitutionManagement.class.getName());
	public static final String DEFAULT_STREAMER = "Default";

	public void updateStreamingServer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		String name = ParamUtil.getString(request, "hostName");
		long hostId = ParamUtil.getLong(request, "hostId");
		String hostPrefix = ParamUtil.getString(request, "hostPrefix");
		LOG.info("Trying to update: " + name);
		try {
			HostLocalServiceUtil.updateHost(hostId, name, hostPrefix);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed updating Streaming Server", e);
			//PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/streamingServerList.jsp");
		}
	}
	
	public void deleteStreamingServer(ActionRequest request, ActionResponse response) {
		long hostId = ParamUtil.getLong(request, "hostId");
		LOG.info("Trying to remove " + hostId);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Host.class.getName(), request);
			if (hostId > 0)
				HostLocalServiceUtil.deleteHost(hostId, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed deleting Streaming Server", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/streamingServerList.jsp");
		}
	}	
	
	public void addStreamingServer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		String name = ParamUtil.getString(request, "hostName");
		String hostPrefix = ParamUtil.getString(request, "hostPrefix");
		LOG.info("Trying to add " + name);
		try {
			HostLocalServiceUtil.addHost(name, hostPrefix);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed adding Streaming Server", e);
			response.setRenderParameter("mvcPath", "/admin/streamingServerList.jsp");
		}
	}
	
	public void updateTreeRoot(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		String institutionName = ParamUtil.getString(request, "treeRoot");
		long institutionId = ParamUtil.getLong(request, "treeRootId");
		LOG.info("Root: " + institutionId);
		try {
			InstitutionLocalServiceUtil.updateInstitution(institutionId, institutionName, 1);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed updating top level institution name ", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}
	
}
