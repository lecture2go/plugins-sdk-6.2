package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyL2gSys;
import de.uhh.l2g.plugins.model.Sys;

public class L2gSysMapper {
	static final Log log = LogFactoryUtil.getLog(L2gSysMapper.class);
	public static Sys mapL2gSys(LegacyL2gSys legacyL2gSys, Sys sys) {
		if (legacyL2gSys == null || sys == null) {
			log.warn("can't execute method with null values - return sys as null value");
			return null;
		}
		
		sys.setSetupWizard(legacyL2gSys.getSetupwizard());
		sys.setVersion(legacyL2gSys.getVersion());
	return sys;
	}

}
