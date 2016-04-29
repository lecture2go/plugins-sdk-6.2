package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.migration.model.LegacyFacility;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;

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
		//if migrated root then delete default root
		if (legacyFacility.getParentId() == 0){
			try {
				Institution prevRoot = InstitutionLocalServiceUtil.getRootByGroupId(companyId, groupId);
				if(prevRoot != null){ InstitutionLocalServiceUtil.deleteInstitution(prevRoot);
				//also clean Link
				Institution_HostLocalServiceUtil.deleteLinkByInstitution(prevRoot, groupId, companyId);
				}
			
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
