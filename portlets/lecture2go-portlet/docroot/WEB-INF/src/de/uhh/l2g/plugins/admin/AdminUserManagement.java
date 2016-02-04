package de.uhh.l2g.plugins.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.impl.CoordinatorImpl;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;

public class AdminUserManagement extends MVCPortlet {

	public void viewRole(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		//updateUsersScreenName();
		// logged in user
		User remoteUser = UserLocalServiceUtil.getUser(new Long(request.getRemoteUser()));
		
		// requested user
		long reqUserId = new Long(request.getParameterMap().get("userId")[0]);
		
		User reqUser = UserLocalServiceUtil.getUser(reqUserId);
		request.setAttribute("reqUser", reqUser);

		// faculties, producer, coordinator, student, admin - objects
		// check whether user is coordinator
		
		//check whether user is l2go coordinator
		boolean isL2goCoordinator = false;
		for (int i = 0; i < reqUser.getRoles().size(); i++)
			if(reqUser.getRoles().get(i).getName().equals("L2Go Coordinator")) isL2goCoordinator = true;
		
		Coordinator reqCoord = CoordinatorLocalServiceUtil.createCoordinator(reqUserId);
		//not coordinator
		if(!isL2goCoordinator){
			deleteL2GoRole("L2Go Coordinator", reqUser);
		}else{
		//is coordinator
			try {
				reqCoord = CoordinatorLocalServiceUtil.getCoordinator(reqUserId);
			} catch (PortalException e) {
			}
		}
		request.setAttribute("reqCoordinator", reqCoord);
		
		//check whether user is l2go coordinator
		boolean isL2goProducer = false;
		for (int i = 0; i < reqUser.getRoles().size(); i++)
			if(reqUser.getRoles().get(i).getName().equals("L2Go Producer")) isL2goProducer = true;
		// producer
		Producer reqProd = ProducerLocalServiceUtil.createProducer(reqUserId);		
		if(!isL2goProducer){
			deleteL2GoRole("L2Go Producer", reqUser);
		}else{
			try {
				reqProd = ProducerLocalServiceUtil.getProducer(reqUserId);
			} catch (PortalException e) {
			}
		}
		request.setAttribute("reqProducer", reqProd);
		
		System.out.println(reqProd.getProducerId() +" "+ reqUser.getUserId() + " " + remoteUser.getUserId());
		
		// institutions
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		//l2go admin is logged in 
		//Remark: Test could be solved rolebased, current action is counter intuitive (ability to add admins 
		//is generallaly expected to be independent from visibility of Institutions and Coord./Prod. Mapping))
		boolean permissionAdmin = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOADMIN");
		List<Institution> cfL = new ArrayList<Institution>();//for coordinator
		List<Institution> pfL = new ArrayList<Institution>();//for producer
		
		if(permissionAdmin){//logged in as l2go admin
			List<Institution> allFacil = InstitutionLocalServiceUtil.getByLevel(1);//all institutions for coordinator drop down menu
			List<User> allCoord = UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(remoteUser.getCompanyId(), "L2Go Coordinator").getRoleId()); 
			List<Institution> assignedInstitutions = new ArrayList<Institution>();		
			try{
				for (int i = 0; i < allCoord.size(); i++){
					Long cId = allCoord.get(i).getUserId();
					Coordinator c = CoordinatorLocalServiceUtil.getCoordinator(cId);
					Institution instId = InstitutionLocalServiceUtil.getInstitution(c.getInstitutionId());
					assignedInstitutions.add(instId);
				}
			}catch(Exception e){}
			List<Institution> notAssignedInstitutions = new ArrayList<Institution>();
  			for(int i = 0; i < allFacil.size(); i++){
				boolean assigned = false;
				for (int j = 0; j < assignedInstitutions.size(); j++){
					if(allFacil.get(i).equals(assignedInstitutions.get(j)) && allFacil.get(i).getInstitutionId()!=reqCoord.getInstitutionId())assigned=true;
				}
				if(!assigned)notAssignedInstitutions.add(allFacil.get(i));
			}
				
			cfL = notAssignedInstitutions;	
			pfL = allFacil;//all institutions for producer drop down menu
		}
		
		//l2go coordinator is logged in
		//check if current user can add producers... on site scope
		boolean permissionCoordinator = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOPRODUCER");		
		Coordinator loggedInCoord = CoordinatorLocalServiceUtil.createCoordinator(remoteUser.getUserId());
		if(permissionCoordinator && !permissionAdmin){//logged in as coordinator
			try{
				loggedInCoord = CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId());
				//add whole institution object which is assigned to coordinator
				cfL.add(InstitutionLocalServiceUtil.getInstitution(loggedInCoord.getInstitutionId()));//institutions for coordinator
				//logged in is coordinator and requested producer belong to different institutions
				if(loggedInCoord.getInstitutionId()==reqProd.getInstitutionId())pfL=cfL; //pfL = not assigned institutions
				else {
					if(reqProd.getInstitutionId()!=0){
						Long instId = reqProd.getInstitutionId();
						Institution inst = InstitutionLocalServiceUtil.getInstitution(instId);
						pfL.add(inst);
					}
					else{
						Institution inst = InstitutionLocalServiceUtil.getInstitution(loggedInCoord.getInstitutionId()); 
						pfL.add(inst);
					}
				}
			}catch(PortalException e){
			}
		}
		request.setAttribute("loggedInCoordinator", loggedInCoord);
		request.setAttribute("cInstitutions", cfL);
		request.setAttribute("pInstitutions", pfL);
		
		//check whether user is student
		boolean isStudent = false;
		List<Role> rl = reqUser.getRoles(); 
		for (int i = 0; i < rl.size(); i++)
			if(reqUser.getRoles().get(i).getName().equals("L2Go Student")) isStudent = true;
		request.setAttribute("isStudent", isStudent);
		
		//check whether user is l2go admin
		boolean isL2goAdmin = false;
		for (int i = 0; i < reqUser.getRoles().size(); i++)
			if(reqUser.getRoles().get(i).getName().equals("L2Go Admin")) isL2goAdmin = true;
		request.setAttribute("isL2goAdmin", isL2goAdmin);
		String backURL = request.getParameter("backURL");		
		request.setAttribute("backURL", backURL);
		response.setRenderParameter("jspPage", "/admin/editL2GoRole.jsp");
	}
	
	public void updateUsersScreenName(){
		List<Producer> pl = new ArrayList<Producer>();
		try {
			pl = ProducerLocalServiceUtil.getAllProducers(0, 300);
			ListIterator<Producer> pit = pl.listIterator();
			while (pit.hasNext()){
				Producer p = pit.next();
				try {
					User u = UserLocalServiceUtil.getUser(p.getProducerId());
					UserLocalServiceUtil.updateScreenName(u.getUserId(), p.getHomeDir());
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	public static List<Role> getL2GoRoles(User u) throws SystemException{
		//prepare l2go roles
		List<Role> l2goRoles = new ArrayList<Role>();
		List<Role> allRoles = RoleLocalServiceUtil.getRoles(u.getCompanyId());
		for(int i = 0; i < allRoles.size(); i++){
			Role r = allRoles.get(i);
			if(r.getName().contains("L2Go")){
				l2goRoles.add(r);
			}
		}
		return l2goRoles;
	}
	
	
	public void editRole(ActionRequest request, ActionResponse response) throws SystemException, NumberFormatException, PortalException, IOException {
		User u = UserLocalServiceUtil.getUser(new Long(request.getParameter("userId")));
		
		// coordinator request --- start
		try{//parameter is null for not authorized user to use this function
			if (!request.getParameter("cfId").isEmpty())
				handleCoordinatorRequest(request);
			else {
				// delete role for user
				deleteL2GoRole("L2Go Coordinator", u);
			}			
		}catch(NullPointerException npe){}
		// coordinator request --- end

		// producer request --- start
		try{//parameter is null for not authorized user to use this function
			if (!request.getParameter("pfId").isEmpty())
				handleProducerRequest(request);
			else {
				// delete role for user
				deleteL2GoRole("L2Go Producer", u);
			}
		}catch(NullPointerException npe){}
		// producer request --- end		
		
		// student request --- start
		if (request.getParameter("isStud").equals("true"))
			addL2GoRole("L2Go Student", u);
		else
			deleteL2GoRole("L2Go Student", u);
		// student request --- end	
		
		// l2go admin request --- start
		try{//parameter is null for not authorized user to use this function
			if (request.getParameter("isL2goAdmin").equals("true"))
				addL2GoRole("L2Go Admin", u);
			else
				deleteL2GoRole("L2Go Admin", u);
		}catch(NullPointerException npe){}
		// l2go admin request --- end
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteL2GoRole(String n, User u) throws PortalException, SystemException{
		Role r = RoleLocalServiceUtil.getRole(u.getCompanyId(), n);
		RoleLocalServiceUtil.deleteUserRole(u.getUserId(), r);
		UserLocalServiceUtil.deleteRoleUser(r.getRoleId(), u.getUserId());		
		if(n.equals("L2Go Coordinator")){
			// remove role from l2go coordinator table, because empty
			if (CoordinatorLocalServiceUtil.fetchCoordinator(u.getUserId()) != null)
				CoordinatorLocalServiceUtil.deleteCoordinator(u.getUserId());			
		}
		if(n.equals("L2Go Producer")){
			// remove role from l2go producer table, because empty
			Producer p = ProducerLocalServiceUtil.fetchProducer(u.getUserId());
			if ( p != null) {
				p.setInstitutionId(0);
				p.setApproved(0);
				ProducerLocalServiceUtil.updateProducer(p);	
			}
		}
	}
	
	private void addL2GoRole(String n, User u) throws PortalException, SystemException{
		// add role to user
		Role nRo = RoleLocalServiceUtil.getRole(u.getCompanyId(), n);
		//user roles
		List<Role> uRo = RoleLocalServiceUtil.getUserRoles(u.getUserId());
		//add new role to user roles
		uRo.add(nRo);
		//set roles to user
		RoleLocalServiceUtil.addUserRoles(u.getUserId(), uRo);		
	}
	
	private void handleCoordinatorRequest(ActionRequest request) throws NumberFormatException, PortalException, SystemException {
		User u = UserLocalServiceUtil.getUser(new Long(request.getParameter("userId")));
		
		Coordinator c = new CoordinatorImpl();
		try {
			c = CoordinatorLocalServiceUtil.getCoordinator(new Long(u.getUserId()));
		} catch (PortalException e) {
			c = CoordinatorLocalServiceUtil.createCoordinator(u.getUserId());
		}

		// add role to user
		addL2GoRole("L2Go Coordinator", u);
		
		// save role to l2go coordinator table
		c.setCoordinatorId(u.getUserId());
		c.setInstitutionId(new Long(request.getParameter("cfId")));
		CoordinatorLocalServiceUtil.updateCoordinator(c);// add or edit entry
	}
	
	private void handleProducerRequest(ActionRequest request) throws NumberFormatException, PortalException, SystemException, IOException {
		User u = UserLocalServiceUtil.getUser(new Long(request.getParameter("userId")));
		Producer p = new ProducerImpl();
		//initialize producer
		try {
			p = ProducerLocalServiceUtil.getProducer(u.getUserId());
		} catch (Exception e) {
			p.setProducerId(u.getUserId());
		}
		// save role to l2go producer table
		p.setInstitutionId(new Long(request.getParameter("pfId")));
		p.setApproved(1);
		// home directory 
		p.setHomeDir(u.getScreenName());
		// repository for producer
		Host h = new HostImpl();
		try{
			h = Institution_HostLocalServiceUtil.getByInstitution(p.getInstitutionId());
			// host to producer 
			p.setHostId(h.getHostId());
		}catch(Exception e){
			SessionErrors.add(request, "host-or-institution-error");
		}
		if(createProducersRepository(h, p)){
			// add or update entry
			ProducerLocalServiceUtil.updateProducer(p);				
			// finaly add role to user
			addL2GoRole("L2Go Producer", u);
			UserLocalServiceUtil.addRoleUser(RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Producer").getRoleId(), u.getUserId());	
		}else{
			SessionErrors.add(request, "system-permissions-error");
		}
	}
	
	public static boolean createProducersRepository(Host host, Producer producer) throws IOException{
		boolean ret = false;
		File folder = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir() + "/");
		Runtime runtime = Runtime.getRuntime();
		if (!folder.exists()) {
			//create repository for producer
			if (folder.mkdir()) {
				String[] cmdArray = {PropsUtil.get("lecture2go.shell.bin"), "-c", "chown nobody " + folder.getAbsolutePath() };
				runtime.exec(cmdArray);
				String[] cmdArray1 = { PropsUtil.get("lecture2go.shell.bin"), "-c", "chown nobody:nobody " + folder.getAbsolutePath() };
				runtime.exec(cmdArray1);
				String[] cmdArray2 = { PropsUtil.get("lecture2go.shell.bin"), "-c", "chmod 701 " + folder.getAbsolutePath() };
				runtime.exec(cmdArray2);

				ret = true;
			}
		}else{
			ret = true;
		}
		//link to main server dir
		File prodFolder = new File(PropsUtil.get("lecture2go.httpstreaming.video.repository") + "/" + producer.getInstitutionId() + "l2g" + producer.getHomeDir());
		if (!prodFolder.exists()) {
			String cmd = "ln -s " + folder.getAbsolutePath() + " " + prodFolder.getAbsolutePath();
			runtime.exec(cmd);
		}
		return ret;
	}
	
	public void initL2goRoles(User u) throws SystemException{
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Coordinator");//if role don't exist, go to catch block and create the role coordinator 
		} catch (PortalException e) {
			// delete l2g coordinators from custom table
			List<Coordinator> cL = CoordinatorLocalServiceUtil.getCoordinators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for (int i = 0; i < cL.size(); i++)
				CoordinatorLocalServiceUtil.deleteCoordinator(cL.get(i));
			
			Role role = createRole("L2Go Coordinator", u);
			//add default Permissions
			try {
				//User Model: Add Producer Permission
				ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), User.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {"ADD_L2GOPRODUCER"});
				
				//Institutions Portlet
				ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), "lgadmininstitutionmanagement_WAR_lecture2goportlet", ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
				//Institutions Models 
				ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution.class.getName(), ResourceConstants.SCOPE_GROUP, String.valueOf(u.getGroupId()), role.getRoleId(), new String[] {ActionKeys.VIEW, "ADD_SUB_INSTITUTION_ENTRY", "ADD_HOSTS", "EDIT_HOSTS", "EDIT_ALL_INSTITUTIONS", "VIEW_OWN_INSTITUTIONS" ,"EDIT_OWN_INSTITUTIONS" ,"DELETE_INSTITUTIONS", "DELETE_SUB_INSTITUTIONS", "EDIT_ROOT_INSTITUTION", "ADD_INSTITUTION_ENTRY", "ADD_SUB_INSTITUTION_ENTRY"});
				ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution_Host.class.getName(), ResourceConstants.SCOPE_GROUP, String.valueOf(u.getGroupId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
				ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Host.class.getName(), ResourceConstants.SCOPE_GROUP, String.valueOf(u.getGroupId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Producer");
		} catch (PortalException e) {
			// delete l2g producer from custom table
			List<Producer> cL = ProducerLocalServiceUtil.getProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for (int i = 0; i < cL.size(); i++)
				ProducerLocalServiceUtil.deleteProducer(cL.get(i));
			Role role = createRole("L2Go Producer", u);
			//add default Permissions
			try {
				//ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), "lgadmininstitutionmanagement_WAR_lecture2goportlet", ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW, "MANAGE_INSTITUTIONS"});
				//ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW, "VIEW_OWN_INSTITUTIONS"});
				//ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution_Host.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
				ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Host.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Student");
		} catch (PortalException e) {
			Role role = createRole("L2Go Student", u);
			//add default Permissions
			try {
				//ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), "lgadmininstitutionmanagement_WAR_lecture2goportlet", ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW, "MANAGE_INSTITUTIONS"});
				//ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW, "VIEW_OWN_INSTITUTIONS"});
				//ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution_Host.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
				ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Host.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Admin");
		} catch (PortalException e) {
			Role role = createRole("L2Go Admin", u);
			//add default Permissions
			setL2GBasePermissions(role, u);
		}

	}
	
	
	private Role createRole(String roleName, User user) throws SystemException{
		long roleId = CounterLocalServiceUtil.increment();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId("com.liferay.portal.model.Role");
		Date date = new Date();
		Role role = RoleLocalServiceUtil.createRole(roleId);
		role.setRoleId(roleId);
		role.setClassNameId(classNameId);
		role.setCompanyId(user.getCompanyId());
		role.setClassPK(roleId);
		role.setName(roleName);
		role.setTitle(roleName);
		role.setDescription(roleName);
		role.setType(1);
		role.setUserName(user.getFullName());
		role.setUserId(user.getUserId());
		role.setCreateDate(date);
		role.setModifiedDate(date);
		return RoleLocalServiceUtil.addRole(role);//save role to database	
	}
	
	
	/**Permission Defaults on L2Go User Role creation
	 * 
	 * @param role - the Admin Role
	 * @param u
	 * @throws SystemException
	 */
	public void setL2GBasePermissions(Role role, User u) throws SystemException{
		try {
			
			//TODO: replace harcoded friendly-url element below, for dynmic portlet  page detection
			
			//Retrieve the Site Group, not personal Group to determine Role accesss, assumes Site(ScopeGroupId) is constant) 
			Group guestGroup = GroupLocalServiceUtil.getGroup(u.getCompanyId(), GroupConstants.GUEST);
			long guestGroupId = guestGroup.getGroupId();
			
			//Get layout to retrieve Plid for Portlet Page assumes title is constant and unique
            Layout imPage = LayoutLocalServiceUtil.getFriendlyURLLayout(guestGroupId, false, "/institution-management");
            
			//Page Permission
            ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), role.getRoleId(), new String[] {ActionKeys.VIEW});	
			
			
            //Portlet Permissions
			//User Portlet
			ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), "lgadminusermanagement_WAR_lecture2goportlet", ResourceConstants.SCOPE_GROUP, String.valueOf(u.getUserId()), role.getRoleId(), new String[] {ActionKeys.VIEW});	
			//User Model: Add Producer Permission
			ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), User.class.getName(), ResourceConstants.SCOPE_COMPANY, String.valueOf(u.getCompanyId()), role.getRoleId(), new String[] {"ADD_L2GOADMIN","ADD_L2GOCOORDINATOR","ADD_L2GOPRODUCER","ADD_L2GOSTUDENT"});
			
			//Institutions Portlet
			ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), "lgadmininstitutionmanagement_WAR_lecture2goportlet", ResourceConstants.SCOPE_GROUP, String.valueOf(guestGroupId), role.getRoleId(), new String[] {ActionKeys.VIEW, "VIEW_ALL_INSTITUTIONS", "VIEW_HOSTS", "ADD_INSTITUTIONS"});
			//General Entity Defaults 
			ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution.class.getName(), ResourceConstants.SCOPE_GROUP, String.valueOf(guestGroupId), role.getRoleId(), new String[] {ActionKeys.VIEW, "ADD_SUB_INSTITUTION_ENTRY", "ADD_HOSTS", "EDIT_HOSTS", "EDIT_ALL_INSTITUTIONS", "VIEW_OWN_INSTITUTIONS" ,"EDIT_OWN_INSTITUTIONS" ,"DELETE_INSTITUTIONS", "DELETE_SUB_INSTITUTIONS", "EDIT_ROOT_INSTITUTION", "ADD_INSTITUTION_ENTRY", "ADD_SUB_INSTITUTION_ENTRY"});
			ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Institution_Host.class.getName(), ResourceConstants.SCOPE_GROUP, String.valueOf(guestGroupId), role.getRoleId(), new String[] {ActionKeys.VIEW});
			ResourcePermissionLocalServiceUtil.setResourcePermissions(u.getCompanyId(), Host.class.getName(), ResourceConstants.SCOPE_GROUP, String.valueOf(guestGroupId), role.getRoleId(), new String[] {ActionKeys.VIEW});
			
			//Root Institution 
			ResourcePermissionLocalServiceUtil.removeResourcePermission(u.getCompanyId(), Institution.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(InstitutionLocalServiceUtil.getRootByGroupId(u.getCompanyId(), guestGroupId)), role.getRoleId(), "EDIT_INSTITUTION");
	
			
			
			//Remove defaults for non L2G Users (https://github.com/liferay/liferay-portal/blob/master/portal-impl/src/resource-actions/sites.xml)
			try {
				Role guestRole = RoleLocalServiceUtil.getRole(u.getCompanyId(), "Guest");
				ResourcePermissionLocalServiceUtil.removeResourcePermission(u.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), guestRole.getRoleId(), ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.removeResourcePermission(u.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), guestRole.getRoleId(), ActionKeys.ADD_DISCUSSION);
			} catch (PortalException e) {
				RoleLocalServiceUtil.checkSystemRoles();
				e.printStackTrace();
			}
			try {
				Role memberRole = RoleLocalServiceUtil.getRole(u.getCompanyId(), "Site Member");
				ResourcePermissionLocalServiceUtil.removeResourcePermission(u.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), memberRole.getRoleId(), ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.removeResourcePermission(u.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), memberRole.getRoleId(), ActionKeys.ADD_DISCUSSION);
				ResourcePermissionLocalServiceUtil.removeResourcePermission(u.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), memberRole.getRoleId(), ActionKeys.CUSTOMIZE);
			} catch (PortalException e) {
				RoleLocalServiceUtil.checkSystemRoles();
				e.printStackTrace();
			}
		
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	 
}
