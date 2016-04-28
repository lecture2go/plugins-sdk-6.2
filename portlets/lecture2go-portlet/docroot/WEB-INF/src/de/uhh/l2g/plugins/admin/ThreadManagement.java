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
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideohitlistLocalServiceUtil;
import de.uhh.l2g.plugins.service.impl.VideoLocalServiceImpl;
import de.uhh.l2g.plugins.util.PermissionManager;
import de.uhh.l2g.plugins.util.PortletScheduler;

public class ThreadManagement extends MVCPortlet {

	


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
	
	/**Schedule an unscheduled Job (requires readable config)
	 * 
	 * @param request
	 * @param response
	 */
	public void scheduleJob(ActionRequest request, ActionResponse response){
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			 
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
			 
			  //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  scheduler.initScheduler(schedulerClassName, serviceContext);
			 
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
	
	/**Resume a paused job (works with each scheduler in memory)
	 * 
	 * @param request
	 * @param response
	 */
	public void resumeJob(ActionRequest request, ActionResponse response){
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			 
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
			 
			  //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  scheduler.initScheduler(schedulerClassName, serviceContext);
			  
			  //System.out.println(scheduler.getPortletId());
			  scheduler.resume();

		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			
			System.out.println(e.getClass().getName());
			e.printStackTrace();

			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	/**Pauses running Job (works with each scheduler in memory)
	 * 
	 * @param request
	 * @param response
	 */
	public void pauseJob(ActionRequest request, ActionResponse response){		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
				
			 //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  
			  scheduler.initScheduler(schedulerClassName, serviceContext);
			  //System.out.println(scheduler.getPortletId());
			  
			  scheduler.pause();

		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			
			System.out.println(e.getClass().getName());
			e.printStackTrace();
			
			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	/**Update Job (updates Trigger (the timing Element) of Job in memory)
	 * (Does nothing at the moment!)
	 * 
	 * TODO: dynamic input with DB persitence
	 * 
	 * @param request
	 * @param response
	 */
	public void updateJob(ActionRequest request, ActionResponse response){		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
				
			 //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  
			  scheduler.initScheduler(schedulerClassName, serviceContext);
			  //System.out.println(scheduler.getPortletId());
			  
			  scheduler.update();

		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			
			System.out.println(e.getClass().getName());
			e.printStackTrace();
			
			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	/**Unchedules a Job from memory (deletes SchedulerEntry record)
	 * 
	 * WARN: currently causes Liferay to duplicate Job on redeploy, if unschedule fails on unregister
	 * @param request
	 * @param response
	 */
	public void unscheduleJob(ActionRequest request, ActionResponse response){		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
				
			 //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  
			  scheduler.initScheduler(schedulerClassName, serviceContext);
			  System.out.println(scheduler.getPortletId());
			  
			  scheduler.unschedule();

		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			
			System.out.println(e.getClass().getName());
			e.printStackTrace();
			
			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	/**Unchedules and removes a Job from memory (Trigger remains in DB)
	 * 
	 * @param request
	 * @param response
	 */
	public void removeJob(ActionRequest request, ActionResponse response){		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
				
			 //Make sure to use the appropriate Message Consumer 
			  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  
			  scheduler.initScheduler(schedulerClassName, serviceContext);
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
	
	public void removeAllJobs(ActionRequest request, ActionResponse response){
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ScheduledThread.class.getName(), request);
			
			  String schedulerClassName = ParamUtil.getString(request, "schedulerName");
			  if (schedulerClassName.isEmpty()){
				  PortletScheduler.removeAllPortletSchedulerJobs();
			  }
			  else{	//Use the correct Message Consumer 
			  	ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(serviceContext.getPortletId()); //Where portletID is not null
			  	PortletScheduler scheduler = (PortletScheduler) classLoader.loadClass(schedulerClassName).newInstance();
			  
			  	scheduler.removeAllJobs();
			  }
		 } catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath",
					"/admin/threads.jsp");
		}
	}
	
	/**
	 * 
	 * TODO: Remove duplicates from List before the can be scheduled, or correctly remove allready unscheduled Entries
	 */
	public void init() throws PortletException{	
		super.init();
		
		/*Drop table LG_VideoStatistics and initialize view
		 * 
		 */
	}
	
	public void destroy(){
	//	System.out.println(this.getPortletName());
	//	PortletScheduler.ListSchedulerEntries(this.getPortletName());
		super.destroy();
	}
	private static Long HITS=new Long(20);
	
	public void createPopularVideoList() throws SystemException {
		List<Video> returnList = new ArrayList<Video>();
		//1.get open access videos with more than 20 clicks 
		returnList = VideoLocalServiceUtil.getByHits(HITS);
		//2.truncate table videohitlist
		VideohitlistLocalServiceUtil.deleteAll();
		//3.fill table with data
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTimeZone( TimeZone.getTimeZone("CET") );
		long msnow = calendar.getTimeInMillis();

		Date d1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm");

		for(Video v : returnList){
			try {
				d1 = df.parse(v.getGenerationDate()); 
				long ms1   = d1.getTime();
				long hits = v.getHits();
				long timeinms = msnow - ms1;

				// Durschnittswerte berechnen
				//Berechne alter des Videos in...
				long days = timeinms / (1000*60*60*24); //...Tagen
				long week = timeinms / (1000*60*60*24*7); //...Wochen
				long month = timeinms / 2628000000l; //....Monaten
				long year = timeinms / (2628000000l*12l); //....Jahren
				
				//Berechne die Hits pro...
				long clicksperday = calcHitsPro(days, hits);
				long clicksperweek = calcHitsPro(week, hits);
				long clickspermonth = calcHitsPro(month, hits);
				long clicksperyear = calcHitsPro(year, hits);

				Videohitlist vhl = new VideohitlistImpl();
				vhl.setVideoId(v.getVideoId());
				vhl.setHitsPerDay(clicksperday);
				vhl.setHitsPerWeek(clicksperweek);
				vhl.setHitsPerMonth(clickspermonth);
				vhl.setHitsPerYear(clicksperyear);
				//save
				VideohitlistLocalServiceUtil.addVideohitlist(vhl);
				}catch (ParseException e) {
					System.out.println("Simple Date Parsen Error!!");
				}
		}
	}	
	
	private long calcHitsPro(long einheit, long hits){
		if(einheit>=1)return (long) (hits/einheit); //Hits pro Einheit (tag, woche, monat, jahr...)
		else return hits; //else: Das Video ist noch kein volles Jahr vollen Monat etc alt.
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		String resourceID = resourceRequest.getResourceID();
		if(resourceID.equals("triggerVideohitlistThread")){		
			try {
				createPopularVideoList();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}
}
