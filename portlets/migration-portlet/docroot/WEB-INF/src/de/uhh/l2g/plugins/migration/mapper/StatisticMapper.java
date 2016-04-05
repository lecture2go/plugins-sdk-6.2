package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyStatistic;
import de.uhh.l2g.plugins.model.Statistic;


public class StatisticMapper {
	static final Log log = LogFactoryUtil.getLog(StatisticMapper.class);; 
	
	public static Statistic mapStatistic(LegacyStatistic legacyStatistic, Statistic statistic, long companyId) {
		if (legacyStatistic == null || statistic == null) {
			log.warn("can't execute method with null values - return statistic as null value");
			return null;
		}
		statistic.setPrivateVideos(legacyStatistic.getPrivate_());
		statistic.setPublicVideos(legacyStatistic.getPublic_());
		statistic.setModifiedDate(legacyStatistic.getDate_());
		statistic.setCreateDate(legacyStatistic.getDate_());
		statistic.setAutofillRow(legacyStatistic.getAutofill());
		return statistic;
	} 

}
