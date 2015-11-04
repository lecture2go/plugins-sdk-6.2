package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries;
import de.uhh.l2g.plugins.model.Producer_Lectureseries;

public class ProducerLectureseriesMapper {
	static final Log log = LogFactoryUtil.getLog(ProducerLectureseriesMapper.class);

	public static Producer_Lectureseries mapProducerLectureseries(LegacyProducerLectureseries legacyProducerLectureseries, Producer_Lectureseries producerLectureseries, long companyId) {
	if (producerLectureseries == null || legacyProducerLectureseries == null) {
		log.warn("can't execute method with null values - return producerLectureseries as null value");
		return null;
	}
	producerLectureseries.setLectureseriesId(legacyProducerLectureseries.getLectureseriesId());
	producerLectureseries.setProducerId(UserIDMapper.getNewUserId(legacyProducerLectureseries.getProducerId(), companyId));
	return producerLectureseries;
	}

}
