package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import de.uhh.l2g.plugins.migration.model.LegacyFacility;
import de.uhh.l2g.plugins.model.Institution;

public class FacilityMapper {
	static final Log log = LogFactoryUtil.getLog(FacilityMapper.class);
	
	public static Institution mapFacility(LegacyFacility legacyFacility, Institution institution, long groupId) {
		if (legacyFacility == null || institution == null) {
			log.warn("can't execute method with null values - return institution as null value");
			return null;
		}
		institution.setGroupId(groupId);
		institution.setLevel(legacyFacility.getLevel());
		institution.setName(legacyFacility.getName());
		institution.setParentId(legacyFacility.getParentId());
		institution.setSort(legacyFacility.getSort());
		institution.setTyp(legacyFacility.getTyp());
		institution.setWww(legacyFacility.getWww());
		return institution;
	}

}
