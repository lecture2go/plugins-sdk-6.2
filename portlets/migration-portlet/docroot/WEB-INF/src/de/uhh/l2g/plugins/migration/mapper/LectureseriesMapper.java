package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeries;
import de.uhh.l2g.plugins.model.Lectureseries;

public class LectureseriesMapper {
	static final Log log = LogFactoryUtil.getLog(LectureseriesMapper.class);
	
	public static Lectureseries mapLectureseries(LegacyLectureSeries legacyLectureseries, Lectureseries lectureseries) {
		if (legacyLectureseries == null || lectureseries == null) {
			log.warn("can't execute method with null values - return LectureseriesInstitution as null value");
			return null;
		}
	lectureseries.setApproved(legacyLectureseries.getApproved());
	// This field is updated on Category Migration! 
	//lectureseries.setCategoryId(legacyLectureseries.get)
	lectureseries.setEventType(legacyLectureseries.getEventType());
	lectureseries.setFacultyName(legacyLectureseries.getFacultyName());
	lectureseries.setLanguage(legacyLectureseries.getLanguage());
	// These 3 fields are  updated after Video_LectureSeries Mapping Table Migration! 
	//lectureseries.setLatestOpenAccessVideoId(legacyLectureseries.get)
	//lectureseries.setLatestVideoGenerationDate(legacyLectureseries.)
	//lectureseries.setLatestVideoUploadDate(legacyLectureseries)
	lectureseries.setLectureseriesId(legacyLectureseries.getId());
	lectureseries.setLongDesc(legacyLectureseries.getLongDesc());
	lectureseries.setName(legacyLectureseries.getName());
	lectureseries.setNumber(legacyLectureseries.getNumber());
	lectureseries.setPassword(legacyLectureseries.getPassword());
	lectureseries.setShortDesc(legacyLectureseries.getShortDesc());
	// This field is updated on Term Migration! 
	//lectureseries.setTermId()
	 return lectureseries;
	}

}
