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

import java.io.File;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.SegmentLocalServiceBaseImpl;
import de.uhh.l2g.plugins.util.FFmpegManager;

/**
 * The implementation of the segment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.SegmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.SegmentLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.SegmentLocalServiceUtil
 */
public class SegmentLocalServiceImpl extends SegmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.SegmentLocalServiceUtil} to access the segment local service.
	 */

	public void deleteThumbhailsFromSegments(List<Segment> segmentList) throws PortalException, SystemException {
		Iterator<Segment> it = segmentList.iterator();
		while (it.hasNext()) {
			Segment objectSegment = it.next();
			Video objectVideo = VideoLocalServiceUtil.getVideo(objectSegment.getVideoId());
			try{
				int sec = new Integer(objectSegment.getStart().split(":")[0]) * 60 * 60 + new Integer(objectSegment.getStart().split(":")[1]) * 60 + new Integer(objectSegment.getStart().split(":")[2]);
				File thumbNail = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + objectVideo.getVideoId() + "_" + sec + ".jpg");
				if (thumbNail.isFile()) thumbNail.delete();
			}catch (ArrayIndexOutOfBoundsException e) {}
		}
	}
	
	
	public List<Segment> getSegmentsByVideoId(Long videoId) throws SystemException, PortalException {
		List<Segment> sl = segmentPersistence.findByVideo(videoId);
		
		Iterator<Segment> it = sl.iterator();
		Integer counter = 0;
		
		while (it.hasNext()) {
			Segment objectSegment = it.next();
			Video objectVideo = VideoLocalServiceUtil.getVideo(objectSegment.getVideoId());
			
			int sec = new Integer(objectSegment.getStart().split(":")[0]) * 60 * 60 + new Integer(objectSegment.getStart().split(":")[1]) * 60 + new Integer(objectSegment.getStart().split(":")[2]);
			objectSegment.setSeconds(sec);

			File thumbNail = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + objectVideo.getVideoId() + "_" + sec + ".jpg");
			String strt = objectSegment.getStart();

			// count chapters
			if (objectSegment.getChapter()==1) {
				counter++;
				objectSegment.setNumber(counter);
			}

			// generate thumbs
			// for audio 
			if (objectVideo.getContainerFormat().equals("mp3")){
				objectSegment.setImage(PropsUtil.get("lecture2go.web.root") + PropsUtil.get("lecture2go.theme.root.path") + "/images/l2go/audio_only_small.png");
			}
			// for video
			if (objectVideo.getContainerFormat().equals("mp4")){
				if (thumbNail.isFile()) objectSegment.setImage("/" + "images" + "/" + objectVideo.getVideoId() + "_" + sec + ".jpg");
				else {
					FFmpegManager.createThumbnail(objectVideo, strt, PropsUtil.get("lecture2go.images.system.path"));
					if (!thumbNail.isFile()) objectSegment.setImage(PropsUtil.get("lecture2go.theme.root.path") + "/" +"images" + "/" + "l2go" + "/" + "noimage.jpg");
				}				
			}
		}
		return null;
	}
	
	
	public void deleteByVideoId(Long videoId) throws SystemException{
		 segmentPersistence.removeByVideo(videoId);
	}
}