package de.uhh.l2g.plugins.admin;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
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

public class AdminInstitutionManagement extends MVCPortlet {


	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			         Institution.class.getName(), renderRequest);

			long groupId = serviceContext.getScopeGroupId();
			long companyId = serviceContext.getCompanyId();
			//groupId = 0;

			long institutionId = ParamUtil.getLong(renderRequest, "institutionId");
			long hostId = ParamUtil.getLong(renderRequest, "hostId");

			long defaultHostId = 0;
			long defaultInstitutionId = 0;


		    List<Institution_Host> institution_host = Institution_HostLocalServiceUtil.getByGroupId(groupId);
		    
		    //Add default host if empty or default entry does not exist
		    defaultHostId = HostLocalServiceUtil.getDefaultHostId(companyId,groupId);
		   // System.out.println(defaultHostId);
		    if (defaultHostId == 0) defaultHostId = HostLocalServiceUtil.addDefaultHost(serviceContext).getHostId();

		    //new Tree Root for Institution if empty
		    defaultInstitutionId = InstitutionLocalServiceUtil.getDefaultInstitutionId(companyId,groupId);
		    System.out.println(defaultInstitutionId);
		    if (defaultInstitutionId == 0) {
		    	defaultInstitutionId = InstitutionLocalServiceUtil.addDefaultInstitution(serviceContext).getInstitutionId();
		    	
			    //Add default Link if new institution has been added 
		    	Institution_Host defaultInstitution_Host = Institution_HostLocalServiceUtil.addEntry(defaultInstitutionId, defaultHostId, serviceContext);
		    	SessionMessages.add(renderRequest, "entryAdded");
		    	long defaultInstitution_HostId = defaultInstitution_Host.getPrimaryKey();
		    	System.out.println(defaultInstitution_HostId);
		    }
		    
		    

		    List<Institution> institutions = InstitutionLocalServiceUtil.getByGroupId(groupId);
		    List<Host> host = HostLocalServiceUtil.getByGroupId(groupId);

		    if (!(institutionId > 0)) {
		    	institutionId = institutions.get(0).getInstitutionId();
	        }
		    
		    System.out.println(institutionId+" "+groupId+" "+institutions.toString());
		    System.out.println(hostId+" "+groupId+" "+host.toString());

		    //System.out.println(StreamingServerTemplateLocalServiceUtil.getDefaultServersByGroupId(groupId));
		    renderRequest.setAttribute("institutionId", institutionId);
		    renderRequest.setAttribute("hostId", hostId);

		    } catch (Exception e) {
		    	  System.out.println(e.getClass().getName());
			         e.printStackTrace();
		    	throw new PortletException(e);
		    }

		super.render(renderRequest, renderResponse);


	}

	public void addInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

			String name = ParamUtil.getString(request, "institution");
			long hostId = ParamUtil.getLong(request, "serverselect");
			long parentId = ParamUtil.getLong(request, "parent");
			int sort = ParamUtil.getInteger(request, "order");


	         InstitutionLocalServiceUtil.addInstitution(
	              name, hostId, parentId, sort, serviceContext);

	         SessionMessages.add(request, "Institution entry added");

	        // response.setRenderParameter("institutionId", Long.toString(institutionId));

	       } catch (Exception e) {
	         SessionErrors.add(request, e.getClass().getName());
	         System.out.println(e.getClass().getName());
	         e.printStackTrace();
	         PortalUtil.copyRequestParameters(request, response);

	         response.setRenderParameter("mvcPath",
	              "/admin/institutionList.jsp");
	       }


	}

	/** Works analogous to addInstitution, but is sperate method to enforce restrictions*/
	public void addSubInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

			String name = ParamUtil.getString(request, "institution");
			long hostId = ParamUtil.getLong(request, "serverselect");
			long parentId = ParamUtil.getLong(request, "parent");
			int sort = ParamUtil.getInteger(request, "order");


	         InstitutionLocalServiceUtil.addInstitution(
	              name, hostId, parentId, sort, serviceContext);

	         SessionMessages.add(request, "Subinstitution entry added");

	        // response.setRenderParameter("institutionId", Long.toString(institutionId));

	       } catch (Exception e) {
	         SessionErrors.add(request, e.getClass().getName());
	         System.out.println(e.getClass().getName());
	         e.printStackTrace();
	         PortalUtil.copyRequestParameters(request, response);

	         response.setRenderParameter("mvcPath",
	              "/admin/institutionList.jsp");
	       }


	}
	public void updateRootInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Institution.class.getName(), request);

		String name = ParamUtil.getString(request, "rootInstitution");
		long institutionId = ParamUtil.getLong(request, "rootInstitutionId");
		//long selectedInstitutionId = ParamUtil.getLong(request, "selectedInstitutionId");
		System.out.println("Root: "+ institutionId);
		try {
			InstitutionLocalServiceUtil.updateInstitution(
					institutionId, name, 1, serviceContext);

			SessionMessages.add(request, "Institution entry updated");

			// response.setRenderParameter("mvcPath",
		     //         "/admin/institutionList.jsp");

		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			System.out.println(e.getClass().getName());
			e.printStackTrace();
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
			System.out.println(institutionId);
			try {
				InstitutionLocalServiceUtil.updateInstitution(
						institutionId, name, sort, serviceContext);

				SessionMessages.add(request, "Institution entry updated");

				// response.setRenderParameter("mvcPath",
			     //         "/admin/institutionList.jsp");

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				System.out.println(e.getClass().getName());
				e.printStackTrace();
				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
			}
		}
		
		public void updateSubInstitution(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Institution.class.getName(), request);

			String name = ParamUtil.getString(request, "innerListInstitution");
			long hostId = ParamUtil.getLong(request, "innerListHostId");
			long institutionId = ParamUtil.getLong(request, "innerListInstitutionId");
			int sort = ParamUtil.getInteger(request, "innerListOrder");
			//long selectedInstitutionId = ParamUtil.getLong(request, "selectedInstitutionId");
			System.out.println(institutionId);
			try {
				InstitutionLocalServiceUtil.updateInstitution(
						institutionId, name, sort, serviceContext);

				SessionMessages.add(request, "Institution entry updated");

				// response.setRenderParameter("mvcPath",
			     //         "/admin/institutionList.jsp");

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				System.out.println(e.getClass().getName());
				e.printStackTrace();
				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
			}
		}


		public void deleteInstitution (ActionRequest request, ActionResponse response) {

		    long institutionId = ParamUtil.getLong(request, "outerListInstitutionId");
		    long selectedInstitutionId = ParamUtil.getLong(request, "institutionId");

		    System.out.println("Delete "+institutionId);
		    try {

		       ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

		                    response.setRenderParameter("institutionId", Long.toString(institutionId));

		       InstitutionLocalServiceUtil.deleteInstitution(institutionId, serviceContext);
		       
		       SessionMessages.add(request, "Institution entry deleted");

		    } catch (Exception e) {
		    	 System.out.println(e.getClass().getName());
		         e.printStackTrace();
		       SessionErrors.add(request, e.getClass().getName());
		    }
		}

		public void deleteSubInstitution (ActionRequest request, ActionResponse response) {

		    long institutionId = ParamUtil.getLong(request, "innerListinstitutionId");
		    long parentId = ParamUtil.getLong(request, "parentId");

		    try {

		       ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

		                    response.setRenderParameter("institutionId", Long.toString(institutionId));

		       InstitutionLocalServiceUtil.deleteInstitution(institutionId, serviceContext);
		       
		       SessionMessages.add(request, "Sub Institution entry deleted");

		    } catch (Exception e) {
		    	  System.out.println(e.getClass().getName());
			         e.printStackTrace();
		       SessionErrors.add(request, e.getClass().getName());
		    }
		}

		public void deleteHost (ActionRequest request, ActionResponse response) {

		    long hostId = ParamUtil.getLong(request, "hostId");

		    try {

		       ServiceContext serviceContext = ServiceContextFactory.getInstance(
		        Host.class.getName(), request);

		                    response.setRenderParameter("hostId", Long.toString(hostId));

		       HostLocalServiceUtil.deleteHost(hostId, serviceContext);

		    } catch (Exception e) {
		    	  System.out.println(e.getClass().getName());
			         e.printStackTrace();
		       SessionErrors.add(request, e.getClass().getName());
		    }
		}


		public void addStreamingServer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Institution.class.getName(), request);

		String name = ParamUtil.getString(request, "institution");
		long hostId = ParamUtil.getLong(request, "serverselect");
		long parent = ParamUtil.getLong(request, "parent");

		try {
			InstitutionLocalServiceUtil.addInstitution(
					name, hostId, parent, 0, serviceContext);

			SessionMessages.add(request, "entryAdded");

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


	}

public void viewStreamingServerList(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


	ServiceContext serviceContext = ServiceContextFactory.getInstance(
	         Institution.class.getName(), request);

    String name = ParamUtil.getString(request, "institution");
	long hostId = ParamUtil.getLong(request, "serverselect");
	long parent = ParamUtil.getLong(request, "parent");

	try {
		InstitutionLocalServiceUtil.addInstitution(
				name, hostId, parent, 0, serviceContext);

         SessionMessages.add(request, "entryAdded");

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


}

}
