package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyFacility;
import de.uhh.l2g.plugins.migration.model.LegacyVideoFacility;
import de.uhh.l2g.plugins.migration.service.LegacyFacilityLocalServiceUtil;
import de.uhh.l2g.plugins.model.Video_Institution;

public class VideoFacilityMapper {
	static final Log log = LogFactoryUtil.getLog(VideoFacilityMapper.class);; 

	public static Video_Institution mapVideoFacility(LegacyVideoFacility legacyVideoFacility, Video_Institution videoInstitution) {
		if (videoInstitution == null || legacyVideoFacility == null) {
			log.warn("can't execute method with null values - return videoInstitution as null value");
			return null;
		}
		videoInstitution.setInstitutionId(legacyVideoFacility.getFacilityId());
		try {
			LegacyFacility legacyFacility = LegacyFacilityLocalServiceUtil.getLegacyFacility(legacyVideoFacility.getFacilityId());
			if (legacyFacility != null) {
				videoInstitution.setInstitutionParentId(legacyFacility.getParentId());
			} else {
				videoInstitution.setInstitutionParentId(0L);
			}
		} catch (Exception e) {
			videoInstitution.setInstitutionParentId(0L);
		}
		videoInstitution.setVideoId(legacyVideoFacility.getVideoId());
		return videoInstitution;
	}

}
