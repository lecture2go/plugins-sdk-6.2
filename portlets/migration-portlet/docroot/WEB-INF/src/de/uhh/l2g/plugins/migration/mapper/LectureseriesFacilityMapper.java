package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

public class LectureseriesFacilityMapper {
	
	static final Log log = LogFactoryUtil.getLog(LectureseriesFacilityMapper.class);
	
	public static Lectureseries_Institution mapLectureseriesFacility(LegacyLectureSeriesFacility legacyLectureseriesFacility, Lectureseries_Institution lectureseriesInstitution) {
		if (lectureseriesInstitution == null || legacyLectureseriesFacility == null) {
			log.warn("legacyLectureseriesFacility == null?" + (legacyLectureseriesFacility == null));
			log.warn("lectureseriesInstitution == null?" + (lectureseriesInstitution == null));
			log.warn("can't execute method with null values - return LectureseriesInstitution as null value");
			return null;
		}
		
		try {
			Institution institution = InstitutionLocalServiceUtil.getInstitution(legacyLectureseriesFacility.getFacilityId());
			lectureseriesInstitution.setInstitutionParentId(institution.getParentId());
		} catch (Exception e) {
			lectureseriesInstitution.setInstitutionParentId(0);
		}
		lectureseriesInstitution.setLectureseriesId(legacyLectureseriesFacility.getLectureseriesId());
		lectureseriesInstitution.setInstitutionId(legacyLectureseriesFacility.getFacilityId());
		return lectureseriesInstitution;
	}

}
