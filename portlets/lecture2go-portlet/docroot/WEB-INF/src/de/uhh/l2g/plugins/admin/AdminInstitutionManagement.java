package de.uhh.l2g.plugins.admin;

import java.io.IOException;
import java.util.List;

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
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.util.PermissionManager;
import de.uhh.l2g.plugins.util.PortletScheduler;

public class AdminInstitutionManagement extends MVCPortlet {
	 protected static Log LOG = LogFactoryUtil.getLog(AdminInstitutionManagement.class.getName());	
	 public static final String DEFAULT_STREAMER = "Default";

	/**Set default permissions (assumes fixed and unique role names)
	 * 
	 * @param pm - PermissionManager 
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	private void setDefaultPermissions(PermissionManager pm) throws SystemException, PortalException{
		
		//Remove view permission for Guest and edit for ordinary Site Members
		pm.removeL2GLayoutViewPermission(RoleConstants.GUEST);
		pm.removeL2GLayoutPermissions(RoleConstants.SITE_MEMBER, new String[] { ActionKeys.VIEW, ActionKeys.ADD_DISCUSSION, ActionKeys.CUSTOMIZE });
				
		//Remove Advanced Permissions for Owner (Owner should be Administrator anyway)
		pm.removeL2GLayoutPermissions(RoleConstants.OWNER, new String[] { ActionKeys.CUSTOMIZE, ActionKeys.PERMISSIONS });
		
		//Allow View Permission for higher L2GRoles
		pm.setL2GLayoutViewPermission(AdminUserManagement.L2G_ADMIN);
		pm.setL2GLayoutViewPermission(AdminUserManagement.L2G_COORDINATOR);
		
		//Allow almost all Portlet operations for L2Go admin
		pm.setL2GPortletPermissions(AdminUserManagement.L2G_ADMIN,  new String[] {ActionKeys.VIEW, "VIEW_ALL_INSTITUTIONS", "VIEW_HOSTS", "ADD_INSTITUTIONS"});		
		pm.setL2GPortletPermissions(AdminUserManagement.L2G_COORDINATOR, ActionKeys.VIEW);
		// Remove for normal Member
		pm.removeL2GPortletPermissions(RoleConstants.SITE_MEMBER, ActionKeys.VIEW);
		// Remove for Owner
		pm.removeL2GPortletPermissions(RoleConstants.OWNER,  new String[] {"VIEW_ALL_INSTITUTIONS", "VIEW_HOSTS", "ADD_INSTITUTIONS"});
		
		//Entities on Model Level 
		pm.removeL2GEntityPermissions(RoleConstants.SITE_MEMBER, Institution.class.getName(), new String[] { ActionKeys.VIEW});
		pm.removeL2GEntityPermissions(RoleConstants.SITE_MEMBER, Institution_Host.class.getName(), new String[] { ActionKeys.VIEW});
		pm.removeL2GEntityPermissions(RoleConstants.SITE_MEMBER, Host.class.getName(), new String[] { ActionKeys.VIEW });
		
		pm.setL2GEntityPermissions(AdminUserManagement.L2G_ADMIN, Institution.class.getName(), new String[] {ActionKeys.VIEW, "ADD_SUB_INSTITUTION_ENTRY", "ADD_HOSTS", "EDIT_HOSTS", "EDIT_ALL_INSTITUTIONS" ,"EDIT_OWN_INSTITUTIONS" ,"DELETE_INSTITUTIONS", "DELETE_SUB_INSTITUTIONS", "ADD_SUB_INSTITUTION_ENTRY"});
		pm.setL2GEntityPermissions(AdminUserManagement.L2G_COORDINATOR, Institution.class.getName(), new String[] {ActionKeys.VIEW, "ADD_SUB_INSTITUTION_ENTRY","EDIT_OWN_INSTITUTIONS", "DELETE_SUB_INSTITUTIONS", "ADD_SUB_INSTITUTION_ENTRY"});
		//
		pm.setL2GEntityViewPermissions(AdminUserManagement.L2G_PRODUCER, Institution.class.getName());
		pm.setL2GEntityViewPermissions(AdminUserManagement.L2G_STUDENT, Institution.class.getName());
		
		pm.setL2GEntityPermissions(AdminUserManagement.L2G_ADMIN, Institution_Host.class.getName(), new String[] {ActionKeys.VIEW, ActionKeys.DELETE, "ADD_LINK"});
		pm.setL2GEntityViewPermissions(AdminUserManagement.L2G_COORDINATOR, Institution_Host.class.getName());
		
		pm.setL2GEntityViewPermissions(AdminUserManagement.L2G_PRODUCER, Institution_Host.class.getName());
		pm.setL2GEntityViewPermissions(AdminUserManagement.L2G_STUDENT, Institution_Host.class.getName());
		
		pm.setL2GEntityPermissions(AdminUserManagement.L2G_ADMIN, Host.class.getName(), new String[] {ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.DELETE, "ADD_HOST", "EDIT_HOST"});
		pm.setL2GEntityPermissions(AdminUserManagement.L2G_COORDINATOR, Host.class.getName(), new String[] {ActionKeys.VIEW});
		
		pm.setL2GEntityViewPermissions(AdminUserManagement.L2G_PRODUCER, Host.class.getName());
		pm.setL2GEntityViewPermissions(AdminUserManagement.L2G_STUDENT, Host.class.getName());
				
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			         Institution.class.getName(), renderRequest);

			//was this portlet allready initialized with default values? True fo a fully insatlled system
			boolean isInitialized = true;
			
			long groupId = serviceContext.getScopeGroupId();
			long companyId = serviceContext.getCompanyId();
			
			LOG.debug("plid "+serviceContext.getPlid()+", portletId "+serviceContext.getPortletId()+" ");
			
			long institutionId = ParamUtil.getLong(renderRequest, "institutionId");
			long hostId = ParamUtil.getLong(renderRequest, "hostId");
			
			
			//Check if default Permissions are Set for this Context (requires L2G Roles)
			//Delete Permissions for admin from DB to reset
			LOG.debug("Initialize Permissions");
			Role admin = RoleLocalServiceUtil.fetchRole(companyId, AdminUserManagement.L2G_ADMIN);
			if (admin != null){
				//TODO: More sophisticated Default 
				PermissionManager pm = new PermissionManager(serviceContext);
				ResourcePermission rp = pm.getPermissionforRole(AdminUserManagement.L2G_ADMIN);
				if (rp == null) {
					setDefaultPermissions(pm);
					//Now we can expect we don't have any defaults at all yet
					isInitialized = false;
				}
			}else {
				isInitialized = false;
				SessionErrors.add(renderRequest,"no-roles-error");
			}
			
			//Initialize if needed
			LOG.debug("Initialize Service Builder Tables" +isInitialized);
			if (isInitialized  == false || admin == null) {
		 
				    HostLocalServiceUtil.updateCounter();
				    Institution_HostLocalServiceUtil.updateCounter();
				    InstitutionLocalServiceUtil.updateCounter();
				    
				    LOG.debug("Updated Counter values!");
				    //Add default host if empty or default entry does not exist
				    long defaultHostId = HostLocalServiceUtil.getDefaultHostId(companyId,groupId);
				    LOG.debug("Default Host: "+defaultHostId);
				    if (defaultHostId == 0) defaultHostId = HostLocalServiceUtil.addDefaultHost(serviceContext).getHostId();
		
				    //new Tree Root for Institution if empty
				    long defaultInstitutionId = InstitutionLocalServiceUtil.getDefaultInstitutionId(companyId,groupId);
				    LOG.debug("Default Institution: "+defaultInstitutionId);
				    
				    if (defaultInstitutionId == 0) {
				    	defaultInstitutionId = InstitutionLocalServiceUtil.addDefaultInstitution(serviceContext).getInstitutionId();
				    }			    	
					//Add default Link for Top Level if not exists (non functional for analogy - relies on institution having exactly one fixed host)
				    long defaultInstitutionHostId = Institution_HostLocalServiceUtil.getDefaultInstitutionHostId(companyId,groupId);
				    if (defaultInstitutionHostId == 0) {		  
				       defaultInstitutionHostId = Institution_HostLocalServiceUtil.addDefaultInstitutionHost(defaultInstitutionId,defaultHostId,serviceContext);
				    }
				    LOG.debug("Default Institution_Host: "+defaultInstitutionHostId);
				    	
			}
		    
				
		    List<Institution> institutions = InstitutionLocalServiceUtil.getByGroupId(groupId);
		    List<Institution_Host> institution_host = Institution_HostLocalServiceUtil.getByGroupId(groupId);
		    List<Host> host = HostLocalServiceUtil.getByGroupId(groupId);

		    if (!(institutionId > 0)) {
		    	institutionId = 0;
		    	//institutionId = institutions.get(0).getInstitutionId();
	        }
		    if (!(hostId > 0)) {
		    	hostId = 0;
	        }
	    
		    renderRequest.setAttribute("institutionId", institutionId);
		    renderRequest.setAttribute("hostId", hostId);

		    } 
			catch (Exception e) {
		    	SessionErrors.add(renderRequest, e.getClass().getName());
		    	LOG.error("Failed rendering "+AdminInstitutionManagement.class.getName(), e);
		    	throw new PortletException(e);
		    }
            
		super.render(renderRequest, renderResponse);


	}

	public void addInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		String institutionName =""; 

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

			institutionName = ParamUtil.getString(request, "institution");
			long hostId = ParamUtil.getLong(request, "serverselect");
			long parentId = ParamUtil.getLong(request, "parent");
			int sort = ParamUtil.getInteger(request, "order");


	         InstitutionLocalServiceUtil.addInstitution(
	        		 institutionName, hostId, parentId, sort, serviceContext);

	         SessionMessages.add(request, "request_processed", "institution-entry-added");

	        // response.setRenderParameter("institutionId", Long.toString(institutionId));

	       } catch (Exception e) {
	         SessionErrors.add(request, e.getClass().getName());
	         LOG.error("Failed adding Institution "+institutionName, e);
	         PortalUtil.copyRequestParameters(request, response);

	         response.setRenderParameter("mvcPath",
	              "/admin/institutionList.jsp");
	       }


	}

	/** Works analogous to addInstitution, but is separate method to enforce restrictions*/
	public void addSubInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
        String institutionName = "";

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

			institutionName = ParamUtil.getString(request, "subInstitution");
			long hostId = 0;
			long parentId = ParamUtil.getLong(request, "subInstitutionParentId");
			int sort = ParamUtil.getInteger(request, "subInstitutionOrder");


	         InstitutionLocalServiceUtil.addInstitution(
	        		 institutionName, hostId, parentId, sort, serviceContext);

	         SessionMessages.add(request, "request_processed", "subinstitution-entry-added");

	        // response.setRenderParameter("institutionId", Long.toString(institutionId));

	       } catch (Exception e) {
	         SessionErrors.add(request, e.getClass().getName());
	         LOG.error("Failed adding Sub-Institution "+institutionName, e);
	         PortalUtil.copyRequestParameters(request, response);

	         response.setRenderParameter("mvcPath",
	              "/admin/institutionList.jsp");
	       }


	}
	public void updateTreeRoot(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Institution.class.getName(), request);

		String institutionName = ParamUtil.getString(request, "treeRoot");
		long institutionId = ParamUtil.getLong(request, "treeRootId");
		//long selectedInstitutionId = ParamUtil.getLong(request, "selectedInstitutionId");
		LOG.info("Root: "+ institutionId);
		try {
			InstitutionLocalServiceUtil.updateInstitution(
					institutionId, institutionName, 1, serviceContext);

			SessionMessages.add(request,"request_processed", "tree-root-entry-updated");

			// response.setRenderParameter("mvcPath",
		     //         "/admin/institutionList.jsp");

		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
	        LOG.error("Failed updating top level institution name ", e);
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath",
					"/admin/institutionList.jsp");
		}
	}

		public void updateInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Institution.class.getName(), request);

			String name = ParamUtil.getString(request, "outerListInstitution");
			long institutionId = ParamUtil.getLong(request, "outerListInstitutionId");
			int sort = ParamUtil.getInteger(request, "outerListOrder");
			//long selectedInstitutionId = ParamUtil.getLong(request, "selectedInstitutionId");
			LOG.info("Updating "+institutionId);
			try {
				InstitutionLocalServiceUtil.updateInstitution(
						institutionId, name, sort, serviceContext);

				SessionMessages.add(request, "request_processed", "institution-entry-updated");

				// response.setRenderParameter("mvcPath",
			     //         "/admin/institutionList.jsp");

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				LOG.error("Failed updating Institution", e);
				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
			}
		}
		
		public void updateSubInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Institution.class.getName(), request);

			String institutionName = ParamUtil.getString(request, "innerListInstitution");
			long institutionId = ParamUtil.getLong(request, "innerListInstitutionId");
			int sort = ParamUtil.getInteger(request, "innerListOrder");
			//long selectedInstitutionId = ParamUtil.getLong(request, "selectedInstitutionId");
			LOG.info("Updating "+institutionId);
			try {
				InstitutionLocalServiceUtil.updateInstitution(
						institutionId, institutionName, sort, serviceContext);

				SessionMessages.add(request, "request_processed", "subinstitution-entry-updated");
			
				// response.setRenderParameter("mvcPath",
			     //         "/admin/institutionList.jsp");

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				LOG.error("Failed updating SubInstitution", e);
				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
			}
		}


		public void deleteInstitution (ActionRequest request, ActionResponse response) {

		    long institutionId = ParamUtil.getLong(request, "outerListInstitutionId");
		   // long selectedInstitutionId = ParamUtil.getLong(request, "institutionId");

		    LOG.info("Deleting "+institutionId);
		    try {

		       ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

		                    response.setRenderParameter("institutionId", Long.toString(institutionId));

		       InstitutionLocalServiceUtil.deleteInstitution(institutionId, serviceContext);
		       
		       SessionMessages.add(request, "request_processed", "institution-entry-deleted");

		    } catch (Exception e) {
		       SessionErrors.add(request, e.getClass().getName());
		       LOG.error("Failed deleting Institution", e);
			   PortalUtil.copyRequestParameters(request, response);

			   response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
		    }
		}

		
		public void deleteSubInstitution (ActionRequest request, ActionResponse response) {

		    long institutionId = ParamUtil.getLong(request, "innerListInstitutionId");
		    long parentId = ParamUtil.getLong(request, "innerListInstitutionParentId");
		    
		    LOG.info("Trying to remove "+ institutionId +" in "+parentId);

		    try {

		       ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

		                    response.setRenderParameter("institutionId", Long.toString(institutionId));

		       InstitutionLocalServiceUtil.deleteInstitution(institutionId, serviceContext);
		       
		       SessionMessages.add(request, "request_processed", "subnstitution-entry-deleted");

		    } catch (Exception e) {
		       SessionErrors.add(request, e.getClass().getName());
		       LOG.error("Failed deleting SubInstitution", e);
		       
			   PortalUtil.copyRequestParameters(request, response);

			   response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
		    }
		}

		public void deleteStreamingServer (ActionRequest request, ActionResponse response) {

		    long hostId = ParamUtil.getLong(request, "curStreamingServerId");
		    LOG.info("Trying to remove "+ hostId);
		    try {
     
		       ServiceContext serviceContext = ServiceContextFactory.getInstance(
		        Host.class.getName(), request);

		        //response.setRenderParameter("hostId", Long.toString(hostId));

		       if(hostId > 0) HostLocalServiceUtil.deleteHost(hostId, serviceContext);
		       
		       SessionMessages.add(request, "request_processed", "streamer-entry-deleted");


		    } catch (Exception e) {
		       SessionErrors.add(request, e.getClass().getName());
		       LOG.error("Failed deleting Streaming Server", e);
			   PortalUtil.copyRequestParameters(request, response);

			   response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
		    }
		}


		public void addStreamingServer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Host.class.getName(), request);

		String hostName = ParamUtil.getString(request, "name");
		String ip = ParamUtil.getString(request, "ip");
		String protocol = ParamUtil.getString(request, "protocol");
		int port = ParamUtil.getInteger(request, "port");
		LOG.info("Trying to add "+ hostName+ ": "+ip);
		try {
			
			HostLocalServiceUtil.addHost(hostName, ip, protocol, port, serviceContext);
			
			SessionMessages.add(request, "request_processed", "streamer-entry-added");


		// response.setRenderParameter("hostId", Long.toString(hostId));

		} catch (Exception e) {
        SessionErrors.add(request, e.getClass().getName());
        LOG.error("Failed adding Streaming Server", e);
        PortalUtil.copyRequestParameters(request, response);

         response.setRenderParameter("mvcPath",
              "/admin/institutionList.jsp");
       }


	}
		public void updateStreamingServer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Host.class.getName(), request);
		
		String hostName = ParamUtil.getString(request, "curStreamingServerName");
		String ip = ParamUtil.getString(request, "curStreamingServerIP");
		int port = ParamUtil.getInteger(request, "curStreamingServerPort");
		long hostId = ParamUtil.getLong(request, "curStreamingServerId");
		String protocol = ParamUtil.getString(request, "curStreamingServerProtocol");
		LOG.info("Trying to update "+ hostName+ ": "+ip);
		try {
			HostLocalServiceUtil.updateHost(hostId, hostName, ip, protocol, port, serviceContext);

			SessionMessages.add(request, "request_processed", "streamer-entry-updated");

			// response.setRenderParameter("institutionId",
			//      Long.toString(institutionId));

		} catch (Exception e) {
	        SessionErrors.add(request, e.getClass().getName());
	        LOG.error("Failed updating Streaming Server", e);
	        PortalUtil.copyRequestParameters(request, response);

	         response.setRenderParameter("mvcPath",
	              "/admin/institutionList.jsp");
       }


	}



/** public void viewStreamingServerList(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


	ServiceContext serviceContext = ServiceContextFactory.getInstance(
	         Institution.class.getName(), request);

    String name = ParamUtil.getString(request, "institution");
	long hostId = ParamUtil.getLong(request, "serverselect");
	long parent = ParamUtil.getLong(request, "parent");

	try {
		InstitutionLocalServiceUtil.addInstitution(
				name, hostId, parent, 0, serviceContext);

		SessionMessages.add(request, "request_processed", "subnstitution-entry-deleted");


        // response.setRenderParameter("institutionId",
        //      Long.toString(institutionId));

       } catch (Exception e) {
         SessionErrors.add(request, e.getClass().getName());
         System.out.println(e.getClass().getName());
         e.printStackTrace();
         PortalUtil.copyRequestParameters(request, response);

         response.setRenderParameter("mvcPath",
              "/admin/institutionList.jsp");
       }


	}*/
}
