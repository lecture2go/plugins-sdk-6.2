package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.migration.model.LegacyFacility;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

public class FacilityMapper {
	static final Log log = LogFactoryUtil.getLog(FacilityMapper.class);
	
	public static Institution mapFacility(LegacyFacility legacyFacility, Institution institution, long groupId, long companyId) {
		if (legacyFacility == null || institution == null) {
			log.warn("can't execute method with null values - return institution as null value");
			return null;
		}
		institution.setGroupId(groupId);
		institution.setCompanyId(companyId);	
		institution.setLevel(legacyFacility.getLevel());
		institution.setName(legacyFacility.getName());
		//if root then delete default root
		if (legacyFacility.getParentId() == 0){
			try {
			InstitutionLocalServiceUtil.deleteInstitution(InstitutionLocalServiceUtil.getRootByGroupId(companyId, groupId));
			} catch (Exception e) {
		         System.out.println(e.getClass().getName());
		         e.printStackTrace();
		         
		       }
		}			
		institution.setParentId(legacyFacility.getParentId());
		//shift sort on first level because Conferences is not a seperate List anymore
		if (legacyFacility.getLevel() == 1)  institution.setSort(legacyFacility.getSort()+1);
		else institution.setSort(legacyFacility.getSort());
		institution.setTyp(legacyFacility.getTyp());
		institution.setWww(legacyFacility.getWww());
		return institution;
	}

}
