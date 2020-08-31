package de.uhh.l2g.hook;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * This class hooks the login process to control user handling.
 */
public class LoginAction extends Action {
	// Role Names
	private static final String L2G_ADMIN = "L2Go Admin";
	private static final String L2G_COORDINATOR = "L2Go Coordinator";
	private static final String L2G_PRODUCER = "L2Go Producer";
	private static final String ADMIN = "Administrator";
	private static final String L2G_PRODUCER_PENDING = "L2Go Producer Pending";
	
    public void run(HttpServletRequest req, HttpServletResponse res) {

    	// only handle login processing if qualifiedgroups is defined in properties file 
    	if (!PropsUtil.contains("lecture2go.producer.pending.qualifiedgroups")) {
    		return;
    	}
    	
    	User user;
		try {
			user = PortalUtil.getUser(req);
			// add permissionchecker manually as it may not be available (necessary for role check)
	    	PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
	    	PermissionThreadLocal.setPermissionChecker(checker);
		} catch (Exception e) {
			// user could not be retrieved from request
			 return;
		}


    	// only handle login processing if user has no active l2go role
    	if (hasRole(user, L2G_COORDINATOR) ||
    		hasRole(user, L2G_PRODUCER) || 
    		hasRole(user, L2G_ADMIN) || 
    		hasRole(user, ADMIN)) {
    			return;
    	}
    	
    	// no active l2go role, check if user is member of qualified groups
    	String[] qualifiedGroups = PropsUtil.getArray("lecture2go.producer.pending.qualifiedgroups");
    	List<String> qualifiedGroupList = Arrays.asList(qualifiedGroups);
    	
    	boolean hasQualifiedUserGroup = hasUserGroup(user, qualifiedGroupList);
    	
		if (!hasQualifiedUserGroup) {
			return;
		} else {
			// set the producer pending role for the user
			if (!hasRole(user, L2G_PRODUCER_PENDING)) {
    			try {
					setRoleForUser(user, L2G_PRODUCER_PENDING);
				} catch (SystemException e) {
					// role could not be set
					return;
				}
			}
		}
    		
    	// get the session, which is used for the redirect
    	HttpSession session = req.getSession();
    	Map params = new HashMap();
    	
		// users with no role selected and which are qualified to self-select their institution are redirected
		LastPath lastPath = new LastPath( "", PropsUtil.get("lecture2go.producer.pending.page"), params );

        session.setAttribute( WebKeys.LAST_PATH, lastPath );

    }
    
    private void setRoleForUser(User user, String roleName) throws SystemException {
        Role liferayRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), roleName);
        RoleLocalServiceUtil.addUserRole(user.getUserId(), liferayRole.getRoleId());
        UserLocalServiceUtil.updateUser(user);
    }
    
    private boolean hasRole(User user, String role) {
    	try {
			return RoleServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), role, false);
		} catch (PortalException e) {
			e.printStackTrace();
			// role could not be checked, return false
			return false;			
		} catch (SystemException e) {
			e.printStackTrace();

			// role could not be checked, return false
			return false;
		}
    }
    
    private boolean hasUserGroup(User user, List<String> userGroupNames) {
    	try {
			for (UserGroup userGroup: user.getUserGroups()) {
				if (userGroupNames.contains(userGroup.getName())) {
					return true;
				}
			}
		} catch (SystemException e) {
			// user group could not be checked, return false
			return false;
		}
    	return false;
    }
}
