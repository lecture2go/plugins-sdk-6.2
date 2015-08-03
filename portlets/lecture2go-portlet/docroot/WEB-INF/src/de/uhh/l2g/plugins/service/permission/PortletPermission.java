package de.uhh.l2g.plugins.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class PortletPermission {

    public static final String RESOURCE_NAME = "lgadmininstitutionmanagement_WAR_lecture2goportlet";

    public static void check(PermissionChecker permissionChecker, long groupId, String primKey,
            String actionId) throws PortalException {

        if (!contains(permissionChecker, groupId, primKey, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long groupId, String primKey, String actionId) {

        return permissionChecker.hasPermission(groupId, RESOURCE_NAME, primKey,
                actionId);
    }
}
