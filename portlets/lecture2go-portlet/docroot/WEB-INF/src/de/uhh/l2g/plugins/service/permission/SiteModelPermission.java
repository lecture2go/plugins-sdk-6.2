package de.uhh.l2g.plugins.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class SiteModelPermission {

    public static final String RESOURCE_NAME = "de.uhh.l2g.plugins.model.";
    public static final long L2G_GROUP_ID = 10182;

    public static void check(PermissionChecker permissionChecker, String model,
            String actionId) throws PortalException {

        if (!contains(permissionChecker, model, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            String model, String actionId) {

        return permissionChecker.hasPermission(L2G_GROUP_ID, RESOURCE_NAME+model, L2G_GROUP_ID,
                actionId);
    }
}
