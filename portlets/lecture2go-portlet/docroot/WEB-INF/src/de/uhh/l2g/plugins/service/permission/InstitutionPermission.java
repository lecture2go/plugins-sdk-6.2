package de.uhh.l2g.plugins.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

/**Helper Class for Permissions on Entity Level for given Class
 * @author sgund
 */
public class InstitutionPermission {

	/** Checks Permission and throws Error on denial
    *
    * @param permissionChecker - PermissionChecker from Liferay
    * @param institutionId - Primary Key of Institution
    * @param actionId - String like defined in in resource-actions
    * @throws PortalException
    * @throws SystemException
    */
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
