package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyLicense;
import de.uhh.l2g.plugins.model.License;

public class LicenseMapper {
	static final Log log = LogFactoryUtil.getLog(LicenseMapper.class);
	public static License mapLicense(LegacyLicense legacyLicense, License license) {
		if (legacyLicense == null || license == null) {
			log.warn("can't execute method with null values - return license as null value");
			return null;
		}
		license.setCcby(legacyLicense.getCcby());
		license.setCcbybc(legacyLicense.getCcbybc());
		license.setCcbync(legacyLicense.getCcbync());
		license.setCcbyncnd(legacyLicense.getCcbyncnd());
		license.setCcbyncsa(legacyLicense.getCcbyncsa());
		license.setCcbysa(legacyLicense.getCcbysa());
		license.setL2go(legacyLicense.getL2go());
		license.setVideoId(legacyLicense.getVideoId());		
	return license;
	}


}
