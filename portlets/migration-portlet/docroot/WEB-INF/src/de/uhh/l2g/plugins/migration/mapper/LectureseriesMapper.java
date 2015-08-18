package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeries;
import de.uhh.l2g.plugins.model.Lectureseries;

public class LectureseriesMapper {
	static final Log log = LogFactoryUtil.getLog(LectureseriesFacilityMapper.class);
	
	public static Lectureseries mapLectureseries(LegacyLectureSeries legacyLectureseries, Lectureseries lectureseries) {
		if (legacyLectureseries == null || lectureseries == null) {
			log.warn("can't execute method with null values - return LectureseriesInstitution as null value");
			return null;
		}
	lectureseries.setApproved(legacyLectureseries.getApproved());
	// TODO Where does it come from ? 
	//lectureseries.setCategoryId(legacyLectureseries.get)
	// TODO Where does it come from ? 
	//lectureseries.setEventType(legacyLectureseries.getT)
	lectureseries.setFacultyName(legacyLectureseries.getFacultyName());
	lectureseries.setLanguage(legacyLectureseries.getLanguage());
	// TODO Where does it come from ? 
	//lectureseries.setLatestOpenAccessVideoId(legacyLectureseries.get)
	// TODO Where does it come from ? 
	//lectureseries.setLatestVideoGenerationDate(legacyLectureseries.)
	// TODO Where does it come from ? 
	//lectureseries.setLatestVideoUploadDate(legacyLectureseries)
	lectureseries.setLectureseriesId(legacyLectureseries.getId());
	lectureseries.setLongDesc(legacyLectureseries.getLongDesc());
	lectureseries.setName(legacyLectureseries.getName());
	lectureseries.setNumber(legacyLectureseries.getNumber());
	lectureseries.setPassword(legacyLectureseries.getPassword());
	lectureseries.setShortDesc(legacyLectureseries.getShortDesc());
	// TODO Where does it come from ? 
	//lectureseries.setTermId(legacyLectureseries.getS)
	 return lectureseries;
	}

}
