package de.uhh.l2g.plugins.admin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.CategoryImpl;
import de.uhh.l2g.plugins.model.impl.TermImpl;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.util.OaiPmhManager;

public class CategoryManagement extends MVCPortlet {

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}
		
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameterMap().get("backURL")[0];
		String name=request.getParameter("name");
		Category category = new CategoryImpl();
		category.setName(name);
		CategoryLocalServiceUtil.addCategory(category);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCategoryId = new Long(request.getParameterMap().get("categoryId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		String name=request.getParameter("name");

		Category category = CategoryLocalServiceUtil.getCategory(reqCategoryId);
		category.setName(name);
		CategoryLocalServiceUtil.updateCategory(category);
		
		// update the datestamp of all OAIRecords linked to the changed category
		OaiPmhManager.modifyByCategory(reqCategoryId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCategoryId = new Long(request.getParameterMap().get("categoryId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		//Video_Term, Lecture_Term, Term
		CategoryLocalServiceUtil.deleteById(reqCategoryId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}

}
