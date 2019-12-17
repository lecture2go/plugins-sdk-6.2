package de.uhh.l2g.plugins.servlets.oai.filters;

import org.dspace.xoai.dataprovider.filter.Filter;
import org.dspace.xoai.dataprovider.model.ItemIdentifier;

import com.liferay.portal.kernel.dao.orm.Criterion;

public abstract class L2GoFilter implements Filter {

	public abstract Criterion getCriterion();
}

