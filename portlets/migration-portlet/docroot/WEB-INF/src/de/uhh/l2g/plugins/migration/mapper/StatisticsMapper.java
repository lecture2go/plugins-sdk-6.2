package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class StatisticsMapper {
	static final Log log = LogFactoryUtil.getLog(StatisticsMapper.class);; 
	
	public static Statistics mapStatistics(LegacyStatistics legacyStatistics, Statistics statistics, long companyId) {
		if (legacyStatistics == null || statistics == null) {
			log.warn("can't execute method with null values - return statistics as null value");
			return null;
		}
		statistics.setPrivateVideo(legacyStatistics.getPrivate());
		statistics.setPublicVideo(legacyStatistics.getPublic());
		statistics.setTimestamp(legacyStatistics.getTimestamp());
		statistics.setUserId(UserIDMapper.getNewUserId(legacyStatistics.getUserId(), companyId));
		return statistics;
	} 

}
