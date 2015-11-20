/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
import java.util.List;
import java.util.ListIterator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.CategoryImpl;
import de.uhh.l2g.plugins.model.impl.TagcloudImpl;
import de.uhh.l2g.plugins.model.impl.TermImpl;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.TagcloudLocalServiceBaseImpl;

/**
 * The implementation of the tagcloud local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.TagcloudLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.TagcloudLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil
 */
public class TagcloudLocalServiceImpl extends TagcloudLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil} to access the tagcloud local service.
	 */
	
	public void deleteByObjectId(long objectId) throws SystemException{
		tagcloudPersistence.removeByObjectId(objectId);
	}
	
	public Tagcloud getByObjectIdAndObjectClassType(long objectId, String objectClassType) throws SystemException, NoSuchTagcloudException{
		return tagcloudPersistence.findByObjectClassTypeAndObjectId(objectClassType, objectId);
	}
	
	public void add(ArrayList<String> tagCloudArrayString, String className, Long objectId) throws SystemException{
		String tagCloudString = "";
		for(int i=0;i<tagCloudArrayString.size();i++){
			tagCloudString += tagCloudArrayString.get(i) +" ### ";
		}
		
		Tagcloud tagcloud = new TagcloudImpl();
		tagcloud.setTags(tagCloudString);
		tagcloud.setObjectClassType(className);
		tagcloud.setObjectId(objectId);
		TagcloudLocalServiceUtil.addTagcloud(tagcloud);
		//
	}
	
	public void updateByObjectIdAndObjectClassType(ArrayList<String> tagCloudArrayString, String className, long objectId) throws SystemException{
		String tagCloudString = "";
		for(int i=0;i<tagCloudArrayString.size();i++) tagCloudString += tagCloudArrayString.get(i) +" ### ";
		
		Tagcloud tagcloud = new TagcloudImpl();
		try {
			tagcloud = TagcloudLocalServiceUtil.getByObjectIdAndObjectClassType(objectId, className);
		} catch (NoSuchTagcloudException e) {
			e.printStackTrace();
		}
		
		tagcloud.setTags(tagCloudString);
		tagcloud.setObjectClassType(className);
		tagcloud.setObjectId(objectId);
		TagcloudLocalServiceUtil.addTagcloud(tagcloud);
	}
	
	public void generateForAllLectureseries(){
		List<Lectureseries> all = new ArrayList<Lectureseries>();
		try {
			all = LectureseriesLocalServiceUtil.getAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		ListIterator<Lectureseries> li = all.listIterator();
		while(li.hasNext()){
			ArrayList<String> tagCloudArrayString = new ArrayList<String>();
			Lectureseries l = li.next();
			//self
			tagCloudArrayString.add(l.getName());
			tagCloudArrayString.add(l.getNumber());
			tagCloudArrayString.add(l.getEventType());
			//Term
			Term t = new TermImpl();
			try {
				t = TermLocalServiceUtil.getTerm(l.getTermId());
			} catch (Exception e) {} 
			tagCloudArrayString.add(t.getPrefix());
			tagCloudArrayString.add(t.getYear());
			tagCloudArrayString.add(t.getPrefix());
			tagCloudArrayString.add(t.getPrefix()+" "+t.getYear());
			
			//Category
			Category ctgr = new CategoryImpl();
			try{ctgr = CategoryLocalServiceUtil.getCategory(l.getCategoryId());}catch(Exception e){}			
			tagCloudArrayString.add(ctgr.getName());
			tagCloudArrayString.add(l.getName());
			tagCloudArrayString.add(l.getNumber());
			//Institution
			List<Lectureseries_Institution> il = new ArrayList<Lectureseries_Institution>();
			try {
				il = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(l.getLectureseriesId());
				ListIterator<Lectureseries_Institution> li1 = il.listIterator();
				while(li1.hasNext()){
					long instId = li1.next().getInstitutionId();
					try {
						tagCloudArrayString.add(InstitutionLocalServiceUtil.getInstitution(instId).getName());
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
			//Creators
			List<Lectureseries_Creator> lcl = new ArrayList<Lectureseries_Creator>(); 
			try {
				lcl = Lectureseries_CreatorLocalServiceUtil.getByLectureseriesId(l.getLectureseriesId());
				ListIterator<Lectureseries_Creator> li2 = lcl.listIterator();
				while(li2.hasNext()){
					long creatId = li2.next().getCreatorId();
					try {
						Creator cr = CreatorLocalServiceUtil.getCreator(creatId);
						tagCloudArrayString.add(cr.getFirstName());
						tagCloudArrayString.add(cr.getLastName());
						tagCloudArrayString.add(cr.getFullName());
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			//add tag cloud
			try {
				add(tagCloudArrayString, l.getClass().getName(), l.getLectureseriesId());
			} catch (SystemException e) {
				e.printStackTrace();
			}		
		}
		
	}
}