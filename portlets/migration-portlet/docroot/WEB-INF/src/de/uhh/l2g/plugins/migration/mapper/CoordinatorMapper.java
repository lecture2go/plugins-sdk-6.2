package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import de.uhh.l2g.plugins.migration.model.LegacyCoordinator;
import de.uhh.l2g.plugins.model.Coordinator;

public class CoordinatorMapper {
	static final Log log = LogFactoryUtil.getLog(CoordinatorMapper.class); 
	public static Coordinator mapCoordinator(LegacyCoordinator LegacyCoordinator, Coordinator coordinator) {
		if (coordinator == null || LegacyCoordinator == null) {
			log.warn("can't execute method with null values - return coordinator as null value");
			return null;
		}
		coordinator.setInstitutionId(LegacyCoordinator.getFacilityId());
		coordinator.setOfficeId(LegacyCoordinator.getOfficeId());
		return coordinator;
	} 

}
