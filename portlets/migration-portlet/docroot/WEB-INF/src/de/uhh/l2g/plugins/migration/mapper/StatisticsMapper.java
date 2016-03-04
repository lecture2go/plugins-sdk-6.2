package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyUpload;
import de.uhh.l2g.plugins.model.Upload;

public class StatisticsMapper {
	static final Log log = LogFactoryUtil.getLog(StatisticsMapper.class);; 
	
	public static Statistics mapUpload(LegacyStatistics legacyStatistics, Statistics statistics, long companyId) {
		if (legacyStatistics == null || statistics == null) {
			log.warn("can't execute method with null values - return statistics as null value");
			return null;
		}
		statistics.setPrivateVideo(legacyStatistics.getPrivate());
		statistics.setPublicVideo(legacyStatistics.getPublic());
		statistics.setTimestamp(legacyStatistics.getTimestamp());
		statistics.setUserId(UserIDMapper.getNewUserId(legacyStatistics.getUserId(), companyId));
		statistics.setVideoId(legacyStatistics.getVideoId());
		return statistics;
	} 

}
