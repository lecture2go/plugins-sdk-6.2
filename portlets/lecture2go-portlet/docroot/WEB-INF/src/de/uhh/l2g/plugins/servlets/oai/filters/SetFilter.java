package de.uhh.l2g.plugins.servlets.oai.filters;

import org.dspace.xoai.dataprovider.model.ItemIdentifier;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class SetFilter extends L2GoFilter {

	String setSpec;
	
	public SetFilter(String setSpec) {
		this.setSpec = setSpec;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isItemShown(ItemIdentifier item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Criterion getCriterion() {
		return RestrictionsFactoryUtil.like("setSpec", setSpec);
	}

}
