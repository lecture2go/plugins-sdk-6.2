/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostStreamingServerTemplateException;
import de.uhh.l2g.plugins.HostStreamerException;
import de.uhh.l2g.plugins.NoSuchInstitutionException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.InstitutionFinderUtil;

/**
 * The implementation of the institution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.uhh.l2g.plugins.service.InstitutionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil
 */
public class InstitutionLocalServiceImpl extends InstitutionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil} to access the
	 * institution local service.
	 */

	public Institution getById(long institutionId) throws SystemException {
		return institutionPersistence.fetchByPrimaryKey(institutionId);
	}

	public List<Institution> getByGroupId(long groupId) throws SystemException {
		return institutionPersistence.findByGroupId(groupId);
	}

	public Institution getByGroupIdAndId(long groupId, long institutionId) throws SystemException {
		return institutionPersistence.fetchByG_I(groupId, institutionId);
	}

	public Institution getTopLevelByGroupId(long groupId) throws SystemException {
		return (Institution) institutionPersistence.fetchByTopLevel(groupId);
	}

	public List<Institution> getByGroupIdAndParent(long groupId, long parentId) throws SystemException {
		return institutionPersistence.findByG_P(groupId, parentId);
	}

	public List<Institution> getByGroupIdAndParent(long groupId, long parentId, int start, int end) throws SystemException {
		return institutionPersistence.findByG_P(groupId, parentId, start, end);
	}

	public int getByGroupIdAndParentCount(long groupId, long parentId) throws SystemException {
		return institutionPersistence.countByG_P(groupId, parentId);
	}

	public List<Institution> getByParentId(long parentId, String type) throws SystemException {
		return institutionPersistence.findByParent(parentId);
	}

	public Map<String, String> getByParent(long parentId) throws SystemException {
		Map<String, String> institutions = new LinkedHashMap<String, String>();
		List<Institution> fList = institutionPersistence.findByParent(parentId);

		for (Institution institution : fList) {
			String id = "" + institution.getInstitutionId();
			String name = "" + institution.getName();
			institutions.put(id, name);
		}
		return institutions;
	}

	public List<Institution> getByLevel(int level) throws SystemException {
		return institutionPersistence.findBylevel(level);
	}

	public List<Institution> getByLectureseriesId(long lectureseriesId, int begin, int end) throws SystemException {
		return InstitutionFinderUtil.findByLectureseriesId(lectureseriesId, begin, end);
	}

	public Map<String, String> getAllSortedAsTree(int begin, int end) throws SystemException {
		Map<String, String> allInstitutions = new LinkedHashMap<String, String>();
		List<Institution> einListAll = InstitutionFinderUtil.findAllSortedAsTree(1, 20);

		for (Institution institution : einListAll) {
			String id = "" + institution.getInstitutionId();
			String name = _indentFromPath(institution.getPath(), "/") + institution.getName();
			allInstitutions.put(id, name);
		}

		return allInstitutions;
	}

	public int getMaxSortByParentId(long parentId) throws SystemException {
		return InstitutionFinderUtil.findMaxSortByParent(parentId);
	}

	public List<Institution> getInstitutionsFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		return InstitutionFinderUtil.findInstitutionsByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, new Long(0));
	}


	public List<Institution> getInstitutionsFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds, Long parentId) {
		return InstitutionFinderUtil.findInstitutionsByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, parentId);
	}

	private String _indentFromPath(String path, String sep) {
		String s = "";
		for (int i = 1; i <= path.split(sep).length - 1; i++) {
			s += "--";
		}
		return s;
	}

	protected void validate(String name) throws PortalException {

		if (Validator.isNull(name)) {
			throw new HostNameException();
		}

	}

	protected void up(){}

	protected void down() {}


    /** Refreshes sort number for given institution
     *  Adds new number on insert (newpos > 0) - shifts numbers on delete (newpos = 0)
     *
     */
	protected int updateSort(Institution inst, int newpos) throws SystemException{
		int validPosition = 0;
		int curPos = 1;
		int prevPos = inst.getSort();

		//System.out.println(inst.getSort());
		int subElements = InstitutionLocalServiceUtil.getByGroupIdAndParentCount(inst.getGroupId(), inst.getParentId());

		if (subElements < 1) validPosition = 1; // There is nothing to reorder and only one valid position
		else{ // sort Elements newpos <= 1 => shift all, newpos > max attach at back
			List<Institution> subtree = InstitutionLocalServiceUtil.getByGroupIdAndParent(inst.getGroupId(), inst.getParentId());

			//if (newpos > 0) curPos = 1;
			int increment = 0;
			for (Institution subInstitution: subtree){
				 if (newpos <= curPos && increment == 0){ //insert new Institution here
					 if (newpos > 0) {
						 validPosition = curPos;
						 increment = 1; //shift all follwing up
					 }
					 else {
						 if (curPos > prevPos) increment = -1;
					 }
				 }
				 subInstitution.setSort(curPos + increment);
				 institutionPersistence.update(subInstitution);
				// System.out.println(subInstitution.getInstitutionId() +" "+ subInstitution.getName()+ " " + curPos + " " + increment+ " " +validPosition);
				 curPos++;

			}
			if (increment == 0) validPosition = curPos;

		}


		//System.out.println(validPosition);

		return validPosition;
	}


	protected int updateSort(Institution inst, int newpos) throws SystemException{
		int validPosition = 0;

		System.out.println(inst.getSort());
		int subElements = InstitutionLocalServiceUtil.getByGroupIdAndParentCount(inst.getGroupId(), inst.getParentId());

		if (subElements < 1) validPosition = 1; // There is nothing to reorder and only one valid position
		else{ // sort Elements newpos = 1 => shift all, newpos > max attach at back
			List<Institution> subtree = InstitutionLocalServiceUtil.getByGroupIdAndParent(inst.getGroupId(), inst.getParentId());

			int curPos = 1;
			int increment = 0;
			for (Institution subInstitution: subtree){
				 if (newpos <= curPos){ //insert new Institution here
					 validPosition = curPos;
					 increment = 1;
				 }
				 subInstitution.setSort(curPos + increment);
				 institutionPersistence.update(subInstitution);
				 System.out.println(subInstitution.getInstitutionId() +" "+ subInstitution.getName()+ " " + curPos + " "+ increment);
				 curPos++;

			}
			if (increment == 0) validPosition = curPos;

		}


		System.out.println(validPosition);

		return validPosition;
	}

	protected int updateSort(Institution inst, int newpos) throws SystemException{
		int validPosition = 0;

		//System.out.println(inst.getSort());
		int subElements = InstitutionLocalServiceUtil.getByGroupIdAndParentCount(inst.getGroupId(), inst.getParentId());

		if (subElements < 1) validPosition = 1; // There is nothing to reorder and only one valid position
		else{ // sort Elements newpos = 1 => shift all, newpos > max attach at back
			List<Institution> subtree = InstitutionLocalServiceUtil.getByGroupIdAndParent(inst.getGroupId(), inst.getParentId());

			int curPos = 1;
			int increment = 0;
			for (Institution subInstitution: subtree){
				 if (newpos <= curPos && increment == 0){ //insert new Institution here
					 validPosition = curPos;
					 increment = 1;
				 }
				 subInstitution.setSort(curPos + increment);
				 institutionPersistence.update(subInstitution);
				 //System.out.println(subInstitution.getInstitutionId() +" "+ subInstitution.getName()+ " " + curPos + " " + increment+ " " +validPosition);
				 curPos++;

			}
			if (increment == 0) validPosition = curPos;

		}


		//System.out.println(validPosition);

		return validPosition;
	}

	public Institution addInstitution(String name, long hostId, long parentId, int sort, ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name);

		long institutionId = counterLocalService.increment(Institution.class.getName());

		Institution institution = institutionPersistence.create(institutionId);

		Institution parent = InstitutionLocalServiceUtil.getById(parentId);

		institution.setName(name);
		institution.setGroupId(groupId);
		institution.setParentId(parentId);
		if (parentId > 0) institution.setLevel(parent.getLevel()+1);
		else institution.setLevel(0);

		institution.setSort(updateSort(institution,sort));

		institution.setExpandoBridgeAttributes(serviceContext);

		Institution_HostLocalServiceUtil.addEntry(institutionId, hostId, serviceContext);

		institutionPersistence.update(institution);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Institution.class.getName(), institutionId, false, true, true);

		return institution;
	}

	public Institution updateInstitution(long institutionId, String name, long hostId, long parentId, int sort,
		       ServiceContext serviceContext) throws PortalException,
		       SystemException {
		    long groupId = serviceContext.getScopeGroupId();
		    long userId = serviceContext.getUserId();

		    User user = userPersistence.findByPrimaryKey(userId);


			validate(name);

		    Institution institution = getInstitution(institutionId);
		    Institution parent = InstitutionLocalServiceUtil.getById(parentId);

		    institution.setName(name);
			institution.setGroupId(groupId);
			institution.setParentId(parentId);
			if (parentId > 0) institution.setLevel(parent.getLevel()+1);
			else institution.setLevel(0);
			institution.setSort(updateSort(institution,sort));

		    institutionPersistence.update(institution);

		    resourceLocalService.updateResources(user.getCompanyId(), groupId,
		         Institution.class.getName(), institutionId,
		         serviceContext.getGroupPermissions(),
		         serviceContext.getGuestPermissions());

		    return institution;

		}

	   public Institution deleteInstitution(long institutionId, ServiceContext serviceContext)
		        throws PortalException, SystemException {


		        //TODO: check if Institution is empty
		        Institution institution = getInstitution(institutionId);

		        resourceLocalService.deleteResource(serviceContext.getCompanyId(),
		        		Institution.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
		        		institutionId);

		        updateSort(institution, 0);

		        institution = deleteInstitution(institutionId);

		        return institution;

		    }


}
