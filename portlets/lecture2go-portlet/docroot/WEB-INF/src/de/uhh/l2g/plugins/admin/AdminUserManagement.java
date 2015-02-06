package de.uhh.l2g.plugins.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;

public class AdminUserManagement extends MVCPortlet {

	public void viewRole(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
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
		
		// institutions
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		//l2go admin is logged in
		boolean permissionAdmin = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOADMIN");
		List<Institution> cfL = new ArrayList<Institution>();//for coordinator
		List<Institution> pfL = new ArrayList<Institution>();//for producer
		
		if(permissionAdmin){//logged in as l2go admin
			List<Institution> allFacil = InstitutionLocalServiceUtil.getByLevel(1);//all institutions for coordinator drop down menu
			List<User> allCoord = UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(remoteUser.getCompanyId(), "L2Go Coordinator").getRoleId()); 
			List<Institution> assignedInstitutions = new ArrayList<Institution>();		
			for (int i = 0; i < allCoord.size(); i++)
				assignedInstitutions.add(InstitutionLocalServiceUtil.getInstitution(CoordinatorLocalServiceUtil.getCoordinator(allCoord.get(i).getUserId()).getInstitutionId()));
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
		boolean permissionCoordinator = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOPRODUCER");		
		Coordinator loggedInCoord = CoordinatorLocalServiceUtil.createCoordinator(remoteUser.getUserId());
		if(permissionCoordinator){//logged in as coordinator
			try{
				loggedInCoord = CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId());
				cfL.add(InstitutionLocalServiceUtil.getInstitution(loggedInCoord.getInstitutionId()));//institutions for coordinator
				//coordinator and requested producer belong to different institutions
				if(loggedInCoord.getInstitutionId()==reqProd.getInstitutionId())pfL=cfL;
				else {
					if(reqProd.getInstitutionId()!=0) pfL.add(InstitutionLocalServiceUtil.getInstitution(reqProd.getInstitutionId()));
					else pfL.add(InstitutionLocalServiceUtil.getInstitution(loggedInCoord.getInstitutionId()));
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
			if (ProducerLocalServiceUtil.fetchProducer(u.getUserId()) != null)
				ProducerLocalServiceUtil.deleteProducer(u.getUserId());			
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
		Coordinator c = null;

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
		Producer p = null;
		//initialize producer
		try {
			p = ProducerLocalServiceUtil.getProducer(new Long(u.getUserId()));
		} catch (PortalException e) {
			p = ProducerLocalServiceUtil.createProducer(u.getUserId());
		}
		// save role to l2go producer table
		p.setProducerId(u.getUserId());
		p.setInstitutionId(new Long(request.getParameter("pfId")));
		// repository for producer
		Host h = null;
		try{
			h = Institution_HostLocalServiceUtil.getByInstitutionId(p.getInstitutionId());
			// host to producer 
			p.setHostId(h.getHostId());
			// home directory 
			p.setHomeDir(u.getScreenName());
			// add or update entry
			ProducerLocalServiceUtil.updateProducer(p);
			createProducersRepository(h, p);
			// finaly add role to user
			addL2GoRole("L2Go Producer", u);
			UserLocalServiceUtil.addRoleUser(RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Producer").getRoleId(), u.getUserId());	
		}catch(Exception e){
			SessionErrors.add(request, "host-or-institution-error");
		}
	}
	
	public static void createProducersRepository(Host host, Producer producer) throws IOException{
		File folder = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir() + "/");
		if (!folder.exists()) {
			if (folder.mkdir()) {
				Runtime runtime = Runtime.getRuntime();
				String[] cmdArray = {PropsUtil.get("lecture2go.shell.bin"), "-c", "chown nobody " + folder.getAbsolutePath() };
				runtime.exec(cmdArray);
				String[] cmdArray1 = { PropsUtil.get("lecture2go.shell.bin"), "-c", "chown nobody:nobody " + folder.getAbsolutePath() };
				runtime.exec(cmdArray1);
				String[] cmdArray2 = { PropsUtil.get("lecture2go.shell.bin"), "-c", "chmod 701 " + folder.getAbsolutePath() };
				runtime.exec(cmdArray2);

				File prodFolder = new File(PropsUtil.get("lecture2go.httpstreaming.video.repository") + "/" + producer.getInstitutionId() + "l2g" + producer.getHomeDir());
				if (!prodFolder.exists()) {
					String cmd = "ln -s " + folder.getAbsolutePath() + " " + prodFolder.getAbsolutePath();
					runtime.exec(cmd);
				}
			}
		}	
	}
	
	public void initL2goRoles(User u) throws SystemException{
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Coordinator");//if role don't exist, go to catch block and create the role coordinator 
		} catch (PortalException e) {
			// delete l2g coordinators from custom table
			List<Coordinator> cL = CoordinatorLocalServiceUtil.getCoordinators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for (int i = 0; i < cL.size(); i++)
				CoordinatorLocalServiceUtil.deleteCoordinator(cL.get(i));
			createRole("L2Go Coordinator", u);
		}
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Producer");
		} catch (PortalException e) {
			// delete l2g producer from custom table
			List<Producer> cL = ProducerLocalServiceUtil.getProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for (int i = 0; i < cL.size(); i++)
				ProducerLocalServiceUtil.deleteProducer(cL.get(i));
			createRole("L2Go Producer", u);
		}
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Student");
		} catch (PortalException e) {
			createRole("L2Go Student", u);
		}
		try {
			RoleLocalServiceUtil.getRole(u.getCompanyId(), "L2Go Admin");
		} catch (PortalException e) {
			createRole("L2Go Admin", u);
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
}