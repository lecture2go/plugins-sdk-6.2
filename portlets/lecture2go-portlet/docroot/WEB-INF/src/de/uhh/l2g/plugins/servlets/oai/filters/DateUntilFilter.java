package de.uhh.l2g.plugins.servlets.oai.filters;

import java.util.Date;

import org.dspace.xoai.dataprovider.model.ItemIdentifier;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.lyncode.builder.DateBuilder;

public class DateUntilFilter extends L2GoFilter {
	
	private Date date;

	public DateUntilFilter(Date date) {
        this.date = new DateBuilder(date).setMinMilliseconds().build();
	}

	@Override
	public boolean isItemShown(ItemIdentifier item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Criterion getCriterion() {
		return RestrictionsFactoryUtil.le("uploadDate", date);
	}

}
