package de.uhh.l2g.plugins.permission;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class HostPermission {
    public static void check(PermissionChecker permissionChecker,
            long guestbookId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, guestbookId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long hostId, String actionId) throws PortalException,
            SystemException {

        Host host = HostLocalServiceUtil
                .getHost(hostId);

        return permissionChecker
                .hasPermission(host.getGroupId(),
                        Host.class.getName(), host.getHostId(),
                        actionId);

    }


}
