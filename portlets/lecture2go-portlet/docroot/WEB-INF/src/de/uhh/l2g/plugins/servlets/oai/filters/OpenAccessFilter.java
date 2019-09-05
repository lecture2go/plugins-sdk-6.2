package de.uhh.l2g.plugins.servlets.oai.filters;

import org.dspace.xoai.dataprovider.model.ItemIdentifier;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

public class OpenAccessFilter extends L2GoFilter {

	public OpenAccessFilter() {
	}

	@Override
	public boolean isItemShown(ItemIdentifier item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Criterion getCriterion() {
		return RestrictionsFactoryUtil.eq("openAccess", 1);
	}

}
