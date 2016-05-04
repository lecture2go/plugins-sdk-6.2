package de.uhh.l2g.plugins.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
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

import de.uhh.l2g.plugins.model.ScheduledThread;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Videohitlist;
import de.uhh.l2g.plugins.model.impl.VideohitlistImpl;
import de.uhh.l2g.plugins.service.StatisticLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideohitlistLocalServiceUtil;
import de.uhh.l2g.plugins.util.PermissionManager;
import de.uhh.l2g.plugins.util.PortletScheduler;

public class StatisticManagement extends MVCPortlet {

	


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
		
		pm.setL2GLayoutViewPermission(AdminUserManagement.L2G_ADMIN);
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
        
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			         ScheduledThread.class.getName(), renderRequest);
			
			//Check if default Permissions are Set for this Context (requires L2G Roles)
			//Delete Permissions for admin from DB to reset
			//LOG.debug("Initialize Permissions");
			Role admin = RoleLocalServiceUtil.fetchRole(serviceContext.getCompanyId(), AdminUserManagement.L2G_ADMIN);
			if (admin != null){
				//Check if Permission is set for L2go Admin Role and Context
				PermissionManager pm = new PermissionManager(serviceContext);
				ResourcePermission rp = pm.getPermissionforRole(AdminUserManagement.L2G_ADMIN);
				if (rp == null) {
					setDefaultPermissions(pm);
				}
			}else {
				//This means User Portlet has not been initialized yet (we can't generate default permissions yet)
				SessionErrors.add(renderRequest,"no-roles-error");
			}
        
	
	    } catch (Exception e) {
	    	throw new PortletException(e);
	    }

		super.render(renderRequest, renderResponse);	 
	}
	
	//This method is called on deploy
	/**Additionally to ordinary deploy replace table with view
	 * 
	 */
	public void init() throws PortletException{			
		super.init();
		System.out.println("Removing LG_VideoStatistic Table");
		StatisticLocalServiceUtil.removeVideoStatisticDefaultTable();
		System.out.println("Adding LG_VideoStatistic as View instead");
		StatisticLocalServiceUtil.addVideoStatisticView();
	}
}

