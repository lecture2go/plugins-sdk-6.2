package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyFacilityHost;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

public class FacilityHostMapper {
	static final Log log = LogFactoryUtil.getLog(FacilityHostMapper.class); 
	public static Institution_Host mapFacilityHost(LegacyFacilityHost legacyFacilityHost, Institution_Host institutionHost, long groupId, long companyId) {
		if (institutionHost == null || legacyFacilityHost == null) {
			log.warn("can't execute method with null values - return institutionHost as null value");
			return null;
		}
		institutionHost.setGroupId(groupId);
		institutionHost.setCompanyId(companyId);
		/**if default then delete default host
				if (legacyHost.getDefaultId () != 0){
					try {
					//InstitutionLocalServiceUtil.deleteInstitution(InstitutionLocalServiceUtil.getRootByGroupId(companyId, groupId));
					} catch (Exception e) {
				         System.out.println(e.getClass().getName());
				         e.printStackTrace();
				         
				       }
				}	*/	
		institutionHost.setHostId(legacyFacilityHost.getHostId());
		institutionHost.setInstitutionId(legacyFacilityHost.getFacilityId());
		return institutionHost;
	} 

}
