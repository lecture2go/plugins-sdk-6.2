package de.uhh.l2g.plugins.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class UserDisplayTerms extends DisplayTerms {

	private String roleId;

	public UserDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		roleId = ParamUtil.getString(portletRequest, "roleId", "");
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
