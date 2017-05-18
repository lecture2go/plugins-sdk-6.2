package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.migration.model.LegacyUser;
import de.uhh.l2g.plugins.migration.service.LegacyUserLocalServiceUtil;

public class UserIDMapper {
	static Log log = LogFactoryUtil.getLog(UserIDMapper.class);	
	public static Long getNewUserId(Long legacyUserId, long companyId) {
		if (legacyUserId == 0) {
			log.warn("legacyId:" + legacyUserId + " !! and companyid:" +companyId + "---> id 0 is beeing set in migrated table!!");
			return 0L;
		}
		if (legacyUserId == null) {
			log.warn("NULL ? legacyId" + legacyUserId + " !! and companyid:" +companyId + "---> id 0 is beeing set in migrated table!!");
			return 0L;
		}
		try {
			LegacyUser legacyUser = LegacyUserLocalServiceUtil.getLegacyUser(legacyUserId);
			User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, legacyUser.getEmailAddress());
			return user.getUserId();
		} catch (Exception e) {
			log.error("can't find legacy user with legacyId" + legacyUserId + "---> id 0 is beeing set in migrated table!!");
		}
		return 0L;
	}

}
