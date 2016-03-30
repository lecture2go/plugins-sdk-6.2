package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyStatistics;
import de.uhh.l2g.plugins.model.Statistics;


public class StatisticsMapper {
	static final Log log = LogFactoryUtil.getLog(StatisticsMapper.class);; 
	
	public static Statistics mapStatistics(LegacyStatistics legacyStatistics, Statistics statistics, long companyId) {
		if (legacyStatistics == null || statistics == null) {
			log.warn("can't execute method with null values - return statistics as null value");
			return null;
		}
		statistics.setPrivateVideos(legacyStatistics.getPrivate_());
		statistics.setPublicVideos(legacyStatistics.getPublic_());
		statistics.setModifiedDate(legacyStatistics.getDate_());
		statistics.setCreateDate(legacyStatistics.getDate_());
		statistics.setAutofillRow(legacyStatistics.getAutofill());
		return statistics;
	} 

}
