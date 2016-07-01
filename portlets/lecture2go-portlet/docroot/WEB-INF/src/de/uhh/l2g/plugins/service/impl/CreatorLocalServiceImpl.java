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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.service.base.CreatorLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.CreatorFinderUtil;

/**
 * The implementation of the creator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.CreatorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.CreatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.CreatorLocalServiceUtil
 */
public class CreatorLocalServiceImpl extends CreatorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.CreatorLocalServiceUtil} to access the creator local service.
	 */

	public List<Creator> getAllCreators() throws SystemException{
		List<Creator> cl = new ArrayList<Creator>();
		cl = creatorPersistence.findAll();
		return cl;
	}
	
	public List<Creator> getCreatorsByLectureseriesId(Long lectureseriesId){
		List<Creator> cl = CreatorFinderUtil.findCreatorsByLectureseries(lectureseriesId);
		return cl;
	}
	
	public String getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(Long lectureseriesId, int maxCreators){
		List<Creator> creatorList = getCreatorsByLectureseriesId(lectureseriesId);
		String creators = createCommaSeparatedStringFromCreatorList(creatorList, maxCreators);
		return creators;
	}
	
	public List<Creator> getCreatorsByVideoId(Long videoId){
		List<Creator> cl = CreatorFinderUtil.findCreatorsByVideo(videoId);
		return cl;
	}
	
	public String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(Long videoId, int maxCreators){
		List<Creator> creatorList = getCreatorsByVideoId(videoId);
		String creators = createCommaSeparatedStringFromCreatorList(creatorList, maxCreators);
		return creators;
	}

	public String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(Long videoId, int maxCreators){
		List<Creator> creatorList = getCreatorsByVideoId(videoId);
		String creators = createCommaSeparatedLinkedStringFromCreatorList(creatorList, maxCreators);
		return creators;
	}
	
	private String createCommaSeparatedStringFromCreatorList(List<Creator> creatorList, int maxCreators) {
		List<String> creatorFullnameList = new ArrayList<String>();
		for (Creator creator: creatorList) { 
			creatorFullnameList.add(creator.getFullName());
		}

		String creators = com.liferay.portal.kernel.util.StringUtil.merge(creatorFullnameList,", ");
		if (creatorFullnameList.size() > maxCreators) {
			creators += " u.a.";
		}
		return creators;
	}
	
	private String createCommaSeparatedLinkedStringFromCreatorList(List<Creator> creatorList, int maxCreators) {
		List<String> creatorFullnameList = new ArrayList<String>();
		for (Creator creator: creatorList) { 
			String fn = creator.getFullName();
			//?_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery=Prof. Dr. Marc Frey
			String fnLink = "<a href='/l2go/-/get/0/0/0/0/0/?_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery="+fn+"'>"+fn+"</a>";;
			creatorFullnameList.add(fnLink);
		}
		
		String creators = com.liferay.portal.kernel.util.StringUtil.merge(creatorFullnameList,", ");
		if (creatorFullnameList.size() > maxCreators) {
			creators += " u.a.";
		}
		return creators;
	}
	
	public JSONArray getJSONCreatorsByVideoId(Long videoId){
		List<Creator> cl = getCreatorsByVideoId(videoId);
		ListIterator<Creator> i = cl.listIterator();
		JSONArray json = new JSONArray();
		while(i.hasNext()){
			Creator cr = i.next();
			JSONObject c = new JSONObject();
			try {
				c.put("creatorId", cr.getCreatorId());
				c.put("firstName", cr.getFirstName());
				c.put("lastName", cr.getLastName());
				c.put("middleName", cr.getMiddleName());
				c.put("jobTitle", cr.getJobTitle());
				c.put("gender", cr.getGender());
				c.put("fullName", cr.getFullName());
				json.put(c);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
	
	public JSONArray getJSONCreatorsByLectureseriesId(Long lectureseriesId){
		List<Creator> cl = getCreatorsByLectureseriesId(lectureseriesId);
		ListIterator<Creator> i = cl.listIterator();
		JSONArray json = new JSONArray();
		while(i.hasNext()){
			Creator cr = i.next();
			JSONObject c = new JSONObject();
			try {
				c.put("creatorId", cr.getCreatorId());
				c.put("firstName", cr.getFirstName());
				c.put("lastName", cr.getLastName());
				c.put("middleName", cr.getMiddleName());
				c.put("jobTitle", cr.getJobTitle());
				c.put("gender", cr.getGender());
				c.put("fullName", cr.getFullName());
				json.put(c);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
	
	public JSONArray getJSONCreator(Long creatorId) throws PortalException, SystemException{
		Creator cr = getCreator(creatorId);
		JSONArray json = new JSONArray();
		JSONObject c = new JSONObject();
		try {
			c.put("creatorId", cr.getCreatorId());
			c.put("firstName", cr.getFirstName());
			c.put("lastName", cr.getLastName());
			c.put("middleName", cr.getMiddleName());
			c.put("jobTitle", cr.getJobTitle());
			c.put("gender", cr.getGender());
			c.put("fullName", cr.getFullName());
			json.put(c);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public List<Creator> getByFullName(String fullName) throws SystemException{
		return creatorPersistence.findByFullName(fullName);
	}
	
	public List<Creator> getCreatorsFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		return CreatorFinderUtil.findCreatorsByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
	}
	
	public void deleteById(Long id) throws NoSuchModelException, SystemException{
		video_CreatorPersistence.removeByCreator(id);
		lectureseries_CreatorPersistence.removeByCreator(id);
		creatorPersistence.remove(id);
	}
	
}