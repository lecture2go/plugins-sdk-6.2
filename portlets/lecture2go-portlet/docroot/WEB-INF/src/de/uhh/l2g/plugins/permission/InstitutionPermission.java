package de.uhh.l2g.plugins.permission;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class InstitutionPermission {
    public static void check(PermissionChecker permissionChecker,
            long institutionId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, institutionId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long institutionId, String actionId) throws PortalException,
            SystemException {

        Institution institution = InstitutionLocalServiceUtil
                .getInstitution(institutionId);

        return permissionChecker
                .hasPermission(institution.getGroupId(),
                        Institution.class.getName(), institution.getInstitutionId(),
                        actionId);

    }

}
