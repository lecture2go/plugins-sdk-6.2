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

import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;

public class TermsManagement extends MVCPortlet {

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}
		
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = new Long(request.getParameterMap().get("termId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		String y=request.getParameter("year");
		String p=request.getParameter("prefix");
		Term term = TermLocalServiceUtil.getTerm(reqTermId);
		term.setYear(y);
		term.setPrefix(p);
		TermLocalServiceUtil.updateTerm(term);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = new Long(request.getParameterMap().get("termId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		//Video_Term, Lecture_Term, Term
		TermLocalServiceUtil.deleteById(reqTermId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
