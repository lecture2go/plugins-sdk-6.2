package de.uhh.l2g.hook;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.RoleLocalServiceUtil;
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
	public static final String L2G_ADMIN = "L2Go Admin";
	public static final String L2G_COORDINATOR = "L2Go Coordinator";
	public static final String L2G_PRODUCER = "L2Go Producer";
	public static final String ADMIN = "Administrator";
	public static final String L2G_PENDING = "L2Go Pending";


    public void run(HttpServletRequest req, HttpServletResponse res) {
        try 
        {
        	// get the session, which is used for the redirect
        	HttpSession session = req.getSession();
        	Map params = new HashMap();
        	
        	// retrieve and prepare the qualified user groups from the properties file
        	String qualifiedGroups = PropsUtil.get("lecture2go.producer.qualifiedgroups");
        	List<String> qualifiedGroupList = Arrays.asList(qualifiedGroups.split("\\s*,\\s*"));
        	
        	User user = PortalUtil.getUser(req);
        		
        	boolean hasL2GoRole = false;
        	boolean hasQualifiedUserGroup = false;
        	        	
        	// check if the user already has a role
        	for (Role role: user.getRoles()) {
        		if (role.getName().equals(L2G_COORDINATOR) ||
        			role.getName().equals(L2G_PRODUCER)	||
        			role.getName().equals(L2G_ADMIN) ||
        			role.getName().equals(ADMIN)) {
	        			hasL2GoRole = true;
	        			break;
        		}
        	}
 
        	// check if the user has a qualified user group
			for (UserGroup userGroup: user.getUserGroups()) {
				if (qualifiedGroupList.contains(userGroup.getName())) {
        			hasQualifiedUserGroup = true;
        			break;
				}
        	}
    		
        	if (!hasL2GoRole && hasQualifiedUserGroup) {
        		try {
        			boolean hasPendingRole = false;
                	for (Role role: user.getRoles()) {
                		if (role.getName().equals(L2G_PENDING)) {
                			hasPendingRole = true;
                		}
                	}
                	if (!hasPendingRole) {
            			setPendingRoleForUser(user);
                	}
        		} catch (SystemException e) {
        			System.out.println("error");
        			// todo
        		}
        		
        		// users with no role selected and which are qualified to self-select their institution are redirected
        		LastPath lastPath = new LastPath( "", "/web/vod/user-roles", params );

                session.setAttribute( WebKeys.LAST_PATH, lastPath );
        	}

        } catch(Exception e) {
        	//todo
			System.out.println("exception");

        }
    }
    
    private void setPendingRoleForUser(User user) throws SystemException {
        Role liferayRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), L2G_PENDING);
        System.out.println(liferayRole.getName());
        RoleLocalServiceUtil.addUserRole(user.getUserId(), liferayRole.getRoleId());
        UserLocalServiceUtil.updateUser(user);

    }
}
