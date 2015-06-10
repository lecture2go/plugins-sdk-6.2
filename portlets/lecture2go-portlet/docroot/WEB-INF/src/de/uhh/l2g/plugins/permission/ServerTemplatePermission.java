package de.uhh.l2g.plugins.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import de.uhh.l2g.plugins.model.ServerTemplate;
import de.uhh.l2g.plugins.service.ServerTemplateLocalServiceUtil;

public class ServerTemplatePermission {
    public static void check(PermissionChecker permissionChecker,
            long serverTemplateId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, serverTemplateId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long serverTemplateId, String actionId) throws PortalException,
            SystemException {

        ServerTemplate serverTemplate = ServerTemplateLocalServiceUtil
                .getServerTemplate(serverTemplateId);

        return permissionChecker
                .hasPermission(serverTemplate.getGroupId(),
                        ServerTemplate.class.getName(), serverTemplate.getServerTemplateId(),
                        actionId);

    }
}
