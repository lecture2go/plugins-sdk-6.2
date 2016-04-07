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
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.model.ScheduledThread;
import de.uhh.l2g.plugins.model.Statistic;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.util.PermissionManager;
import de.uhh.l2g.plugins.util.PortletScheduler;
import de.uhh.l2g.plugins.util.StatisticsScheduler;
import de.uhh.l2g.plugins.util.ThreadManager;

public class ThreadManagement extends MVCPortlet {

	


	/**Set default permissions (assumes fixed and unique role names)
	 * 
	 * @param pm - PermissionManager 
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	private void setDefaultPermissions(PermissionManager pm) throws SystemException, PortalException{
		

	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
        
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			         ScheduledThread.class.getName(), renderRequest);
        
	
	    } catch (Exception e) {
	    	throw new PortletException(e);
	    }

		super.render(renderRequest, renderResponse);
	 
	}
	
	public void startThread(ActionRequest request, ActionResponse response){
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			 
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
			 
			  //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  scheduler.initScheduler(schedulerClassName, serviceContext.getPortletId());
			  System.out.println(scheduler.getPortletId());
			  scheduler.start();

		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			
			System.out.println(e.getClass().getName());
			e.printStackTrace();

			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	public void stopThread(ActionRequest request, ActionResponse response){		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
				
			 //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  
			  scheduler.initScheduler(schedulerClassName, serviceContext.getPortletId());
			  System.out.println(scheduler.getPortletId());
			  
			  scheduler.stop();

		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			
			System.out.println(e.getClass().getName());
			e.printStackTrace();
			
			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	public void killAll(ActionRequest request, ActionResponse response){
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
				
			  //Use the correct Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  
			  scheduler.killAll();

		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	public void init() throws PortletException{	
		super.init();
		
		/*Drop table LG_VideoStatistics and initialize view
		 * 
		 */
	}
	
	public void destroy(){
		System.out.println(this.getPortletName());
		super.destroy();
	}
	
}
