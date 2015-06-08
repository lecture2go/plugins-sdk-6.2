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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.ServerTemplate;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ServerTemplateLocalServiceUtil;

public class AdminInstitutionManagement extends MVCPortlet {


	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			         Institution.class.getName(), renderRequest);

			long groupId = serviceContext.getScopeGroupId();
			//groupId = 0;

			long institutionId = ParamUtil.getLong(renderRequest, "institutionId");
			long hostId = ParamUtil.getLong(renderRequest, "hostId");
			long serverTemplateId = ParamUtil.getLong(renderRequest, "serverTemplateId");

			long defaultHostId = 0;
			long defaultServerTemplateId = 0;


		    List<Institution> institutions = InstitutionLocalServiceUtil.getByGroupId(groupId);
		    List<Host> host = HostLocalServiceUtil.getByGroupId(groupId);
		    List<ServerTemplate> serverTemplate = ServerTemplateLocalServiceUtil.getByGroupId(groupId);

		    System.out.println(institutionId+" "+groupId+" "+institutions.toString());
		    System.out.println(hostId+" "+groupId+" "+host.toString());

		    //Add default server template if empty
		    if (serverTemplate.size() == 0) {
		    	ServerTemplate defaultServerTemplate = ServerTemplateLocalServiceUtil.addServerTemplate("HTTP", 0, "{Protocol}://{ServerURL}/{L2GO_FILEPATH}/{Filename}.{Ext}", "", "", "", 0,0 , serviceContext);
		    	SessionMessages.add(renderRequest, "entryAdded");
		    	defaultServerTemplateId = defaultServerTemplate.getServerTemplateId();
		    }

		    //Add default host if empty
		    if (host.size() == 0) {
		    	Host defaultHost = HostLocalServiceUtil.addHost("Default", "localhost", defaultServerTemplateId ,"HTTP", "", 80, serviceContext);
		    	SessionMessages.add(renderRequest, "entryAdded");
		    	defaultHostId = defaultHost.getHostId();
		    }

		    //new Top Level Institution if empty
		    if (institutions.size() == 0) {
		    	Institution institution = InstitutionLocalServiceUtil.addInstitution("Main", 0 ,new Long(0), 0, serviceContext);
		    	SessionMessages.add(renderRequest, "entryAdded");
		    	institutionId = institution.getInstitutionId();
		    }


		    if (!(institutionId > 0)) {
		    	institutionId = institutions.get(0).getInstitutionId();
	        }

		    //System.out.println(ServerTemplateLocalServiceUtil.getDefaultServersByGroupId(groupId));
		    renderRequest.setAttribute("institutionId", institutionId);
		    renderRequest.setAttribute("hostId", hostId);
		    renderRequest.setAttribute("serverTemplateId", serverTemplateId);

		    } catch (Exception e) {
		    	throw new PortletException(e);
		    }

		super.render(renderRequest, renderResponse);


	}

	public void addInstitutionEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Institution.class.getName(), request);

			String name = ParamUtil.getString(request, "institution");
			long hostId = ParamUtil.getLong(request, "serverselect");
			long parent = ParamUtil.getLong(request, "parent");
			int sort = ParamUtil.getInteger(request, "order");


	         InstitutionLocalServiceUtil.addInstitution(
	              name, hostId, parent, sort, serviceContext);

	         SessionMessages.add(request, "entryAdded");

	        // response.setRenderParameter("institutionId", Long.toString(institutionId));

	       } catch (Exception e) {
	         SessionErrors.add(request, e.getClass().getName());

	                            PortalUtil.copyRequestParameters(request, response);

	         response.setRenderParameter("mvcPath",
	              "/admin/institutionList.jsp");
	       }


	}

		public void updateInstitutionEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


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

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/admin/institutionList.jsp");
			}
		}

		public void updateTopLevelInstitutionEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


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

		                            PortalUtil.copyRequestParameters(request, response);

		         response.setRenderParameter("mvcPath",
		              "/admin/institutionList.jsp");
		       }



	}

	public void addStreamingServerEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {


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

                            PortalUtil.copyRequestParameters(request, response);

         response.setRenderParameter("mvcPath",
              "/admin/institutionList.jsp");
       }


}

}
