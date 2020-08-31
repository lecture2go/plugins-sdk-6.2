package de.uhh.l2g.plugins.servlets.oai.filters;

import java.util.Date;

import org.dspace.xoai.dataprovider.model.ItemIdentifier;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.lyncode.builder.DateBuilder;

public class DateFromFilter extends L2GoFilter {

	private Date date;

	public DateFromFilter(Date date) {
        this.date = new DateBuilder(date).setMinMilliseconds().build();
	}

	@Override
	public boolean isItemShown(ItemIdentifier item) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Criterion getCriterion() {
		return RestrictionsFactoryUtil.ge("datestamp", date);
	}
}
