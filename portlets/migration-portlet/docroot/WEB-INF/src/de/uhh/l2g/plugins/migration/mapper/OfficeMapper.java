package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyOffice;
import de.uhh.l2g.plugins.model.Office;

public class OfficeMapper {
	static final Log log = LogFactoryUtil.getLog(OfficeMapper.class);
	
	public static Office mapOffice(LegacyOffice legacyOffice, Office office) {
		if (office == null || legacyOffice == null) {
			log.warn("can't execute method with null values - return office as null value");
			return null;
		}
		office.setEmail(legacyOffice.getEmail());
		office.setInstitutionId(legacyOffice.getFacilityId());
		office.setName(legacyOffice.getName());
		office.setWww(legacyOffice.getWww());
		return office;
	}
	
	
}
