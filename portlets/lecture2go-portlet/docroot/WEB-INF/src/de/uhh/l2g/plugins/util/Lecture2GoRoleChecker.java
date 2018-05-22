package de.uhh.l2g.plugins.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;

public class Lecture2GoRoleChecker extends RoleLocalServiceUtil {
	
	private  boolean producer = false;
	private  boolean coordinator = false;
	private  boolean l2gAdmin = false;
	private  boolean student = false;
	
	public  boolean isProducer(User user) {
		List<Role> rL = new ArrayList<Role>();
		try {
			rL = user.getRoles();
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		for (Role role : rL) if(role.getName().equals("L2Go Producer"))producer=true;
		return producer;
	}
	public  boolean isCoordinator(User user) {
		List<Role> rL = new ArrayList<Role>();
		try {
			rL = user.getRoles();
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		for (Role role : rL) if(role.getName().equals("L2Go Coordinator"))coordinator=true;
		return coordinator;
	}
	public  boolean isL2gAdmin(User user) {
		List<Role> rL = new ArrayList<Role>();
		try {
			rL = user.getRoles();
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		for (Role role : rL) if(role.getName().equals("L2Go Admin") || role.getName().equals("Administrator") )l2gAdmin=true;
		return l2gAdmin;
	}
	public  boolean isStudent(User user) {
		List<Role> rL = new ArrayList<Role>();
		try {
			rL = user.getRoles();
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		for (Role role : rL) if(role.getName().equals("L2Go Student"))student=true;
		return student;
	}
	
}
