package de.uhh.l2g.plugins.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

/**Helper Class for Permissions on Entity Level
 * @author sgund
 */
public class EntityPermission {

	//Full path to class name
    public static final String RESOURCE_NAME = "de.uhh.l2g.plugins.model.";
    public static final long L2G_GROUP_ID = 10182; //Site Scope
    public static final long L2G_COMPANY_ID = 10155; //Company Scope


    /** Checks Permission and throws Error on denial
     *
     * @param permissionChecker - PermissionChecker from Liferay
     * @param model - Name of the Entity Class
     * @param primKey - Primary Key of Element
     * @param actionId - String like defined in in resource-actions
     * @throws PortalException
     */
    public static void check(PermissionChecker permissionChecker, String model, long primKey,
            String actionId) throws PortalException {

        if (!contains(permissionChecker, model, primKey, actionId)) {
            throw new PrincipalException();
        }
    }

    /** Checks permission and returns boolean value
     *
     * @param permissionChecker - PermissionChecker from Liferay
     * @param model - Name of the Entity Class
     * @param primKey - Primary Key of Element
     * @param actionId - String like defined in in resource-actions
     * @return boolean true - success
     */
    public static boolean contains(PermissionChecker permissionChecker,
            String model, long primKey, String actionId) {

    	// Use constant scopeId to define scope of test
        return permissionChecker.hasPermission(L2G_GROUP_ID, RESOURCE_NAME+model, primKey,
                actionId);
    }
}
