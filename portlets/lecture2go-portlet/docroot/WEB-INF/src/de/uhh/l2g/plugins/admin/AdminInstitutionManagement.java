package de.uhh.l2g.plugins.admin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.NoPropertyException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.util.PermissionManager;

public class AdminInstitutionManagement extends MVCPortlet {
	protected static Log LOG = LogFactoryUtil.getLog(AdminInstitutionManagement.class.getName());
	public static final String DEFAULT_STREAMER = "Default";


	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), renderRequest);

			// was this portlet allready initialized with default values? True
			// fo a fully insatlled system
			boolean isInitialized = true;

			long groupId = serviceContext.getScopeGroupId();
			long companyId = serviceContext.getCompanyId();

			LOG.debug("plid " + serviceContext.getPlid() + ", portletId " + serviceContext.getPortletId() + " ");

			long institutionId = ParamUtil.getLong(renderRequest, "institutionId");
			long hostId = ParamUtil.getLong(renderRequest, "hostId");

			// Check if default Permissions are Set for this Context (requires
			// L2G Roles)
			// Delete Permissions for admin from DB to reset
			LOG.debug("Initialize Permissions");
			Role admin = RoleLocalServiceUtil.fetchRole(companyId, AdminUserManagement.L2G_ADMIN);
			if (admin != null) {
				// Check if Permission is set for L2go Admin Role and Context
				PermissionManager pm = new PermissionManager(serviceContext);
				ResourcePermission rp = pm.getPermissionforRole(AdminUserManagement.L2G_ADMIN);
				if (rp == null) {
					// In this case we are probably missing other defaults too,
					// but UserPortlet has been triggered
					isInitialized = false;
				}
			} else {
				// This means User Portlet has not been initialized yet (we
				// can't generate default permissions yet)
				isInitialized = false;
				SessionErrors.add(renderRequest, "no-roles-error");
			}

			// We need to initialize DB if there are no values for root
			// Institution and default Host
			// We need to verify counters to check if DB has been changed from
			// remote (Migration, manual Additions) or stale folders

			// Set to zero if empty/otherwise synchronize with DB
			LOG.info("Updating Counter values!");

			// Initialize if needed
			// Trigger new init by deleting this test, removing Role or removing
			// ResourcePermissions for this context from DB
			if (isInitialized == false) {
				// Initialize if needed
				LOG.info("Initialize Service Builder Tables beacause the portlet seems to be unconfigured. isInitialized:" + isInitialized);

				// Add default host if empty or default entry does not exist
				long defaultHostId = HostLocalServiceUtil.getDefaultHostId(companyId, groupId);
				LOG.debug("Default Host: " + defaultHostId);
				if (defaultHostId == 0)
					defaultHostId = HostLocalServiceUtil.addDefaultHost(serviceContext).getHostId();

				// new Tree Root for Institution if empty
				long defaultInstitutionId = InstitutionLocalServiceUtil.getDefaultInstitutionId(companyId, groupId);
				LOG.debug("Default Institution: " + defaultInstitutionId);

				if (defaultInstitutionId == 0) {
					defaultInstitutionId = InstitutionLocalServiceUtil.addDefaultInstitution(serviceContext).getInstitutionId();
				}
				// Add default Link for Top Level if not exists (non functional
				// for analogy - relies on institution having exactly one fixed
				// host)
				long defaultInstitutionHostId = Institution_HostLocalServiceUtil.getDefaultInstitutionHostId(companyId, groupId);
				if (defaultInstitutionHostId == 0) {
					defaultInstitutionHostId = Institution_HostLocalServiceUtil.addDefaultInstitutionHost(defaultInstitutionId, defaultHostId, serviceContext);
				}
				LOG.debug("Default Institution_Host: " + defaultInstitutionHostId);
			}

			if (!(institutionId > 0)) {
				institutionId = 0;
				// institutionId = institutions.get(0).getInstitutionId();
			}
			if (!(hostId > 0)) {
				hostId = 0;
			}

			renderRequest.setAttribute("institutionId", institutionId);
			renderRequest.setAttribute("hostId", hostId);

		} catch (NoPropertyException e) {
			SessionErrors.add(renderRequest, "no-property-error");
			LOG.error("Failed retrieving crucial settings from portal properties", e);
			throw new PortletException(e);
		} catch (Exception e) {
			SessionErrors.add(renderRequest, e.getClass().getName());
			LOG.error("Failed rendering " + AdminInstitutionManagement.class.getName(), e);
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}

	public void addInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		String institutionName = "";

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);

			institutionName = ParamUtil.getString(request, "institution");
			long hostId = ParamUtil.getLong(request, "serverselect");
			long parentId = ParamUtil.getLong(request, "parent");
			int sort = ParamUtil.getInteger(request, "order");

			InstitutionLocalServiceUtil.addInstitution(institutionName, hostId, parentId, sort, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed adding Institution " + institutionName, e);
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}

	/**
	 * Works analogous to addInstitution, but is separate method to enforce
	 * restrictions
	 */
	public void addSubInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		String institutionName = "";

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);

			institutionName = ParamUtil.getString(request, "subInstitution");
			long hostId = 0;
			long parentId = ParamUtil.getLong(request, "subInstitutionParentId");
			int sort = ParamUtil.getInteger(request, "subInstitutionOrder");

			InstitutionLocalServiceUtil.addInstitution(institutionName, hostId, parentId, sort, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed adding Sub-Institution " + institutionName, e);
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}

	public void updateTreeRoot(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);
		String institutionName = ParamUtil.getString(request, "treeRoot");
		long institutionId = ParamUtil.getLong(request, "treeRootId");
		LOG.info("Root: " + institutionId);
		try {
			InstitutionLocalServiceUtil.updateInstitution(institutionId, institutionName, 1, serviceContext);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed updating top level institution name ", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}

	public void updateInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);
		String name = ParamUtil.getString(request, "outerListInstitution");
		long institutionId = ParamUtil.getLong(request, "outerListInstitutionId");
		int sort = ParamUtil.getInteger(request, "outerListOrder");
		LOG.info("Updating " + institutionId);
		try {
			InstitutionLocalServiceUtil.updateInstitution(institutionId, name, sort, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed updating Institution", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}

	public void updateSubInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);
		String institutionName = ParamUtil.getString(request, "innerListInstitution");
		long institutionId = ParamUtil.getLong(request, "innerListInstitutionId");
		int sort = ParamUtil.getInteger(request, "innerListOrder");
		LOG.info("Updating " + institutionId);
		try {
			InstitutionLocalServiceUtil.updateInstitution(institutionId, institutionName, sort, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed updating SubInstitution", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}

	public void deleteInstitution(ActionRequest request, ActionResponse response) {
		long institutionId = ParamUtil.getLong(request, "outerListInstitutionId");
		LOG.info("Deleting " + institutionId);
		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);
			response.setRenderParameter("institutionId", Long.toString(institutionId));
			InstitutionLocalServiceUtil.deleteInstitution(institutionId, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed deleting Institution", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}

	public void deleteSubInstitution(ActionRequest request, ActionResponse response) {
		long institutionId = ParamUtil.getLong(request, "innerListInstitutionId");
		long parentId = ParamUtil.getLong(request, "innerListInstitutionParentId");
		LOG.info("Trying to remove " + institutionId + " in " + parentId);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);
			response.setRenderParameter("institutionId", Long.toString(institutionId));
			InstitutionLocalServiceUtil.deleteInstitution(institutionId, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed deleting SubInstitution", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}

	public void deleteStreamingServer(ActionRequest request, ActionResponse response) {
		long hostId = ParamUtil.getLong(request, "curStreamingServerId");
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
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Host.class.getName(), request);
		String hostName = ParamUtil.getString(request, "name");
		String ip = ParamUtil.getString(request, "ip");
		String protocol = ParamUtil.getString(request, "protocol");
		int port = ParamUtil.getInteger(request, "port");
		LOG.info("Trying to add " + hostName + ": " + ip);
		try {
			HostLocalServiceUtil.addHost(hostName, ip, protocol, port, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed adding Streaming Server", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/streamingServerList.jsp");
		}
	}

	public void updateStreamingServer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Host.class.getName(), request);
		String hostName = ParamUtil.getString(request, "curStreamingServerName");
		String ip = ParamUtil.getString(request, "curStreamingServerIP");
		int port = ParamUtil.getInteger(request, "curStreamingServerPort");
		long hostId = ParamUtil.getLong(request, "curStreamingServerId");
		String protocol = ParamUtil.getString(request, "curStreamingServerProtocol");
		LOG.info("Trying to update " + hostName + ": " + ip);
		try {
			HostLocalServiceUtil.updateHost(hostId, hostName, ip, protocol, port, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			LOG.error("Failed updating Streaming Server", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/streamingServerList.jsp");
		}
	}

}
