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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.NoSuchInstitutionException;
import de.uhh.l2g.plugins.NoSuchProducerException;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.LastvideolistImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.LastvideolistLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.VideoLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.VideoFinderUtil;
import de.uhh.l2g.plugins.util.FFmpegManager;

/**
 * The implementation of the video local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.uhh.l2g.plugins.service.VideoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.VideoLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.VideoLocalServiceUtil
 */
public class VideoLocalServiceImpl extends VideoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * de.uhh.l2g.plugins.service.VideoLocalServiceUtil} to access the video
	 * local service.
	 */
	public Video getLatestOpenAccessVideoForLectureseries(Long lectureseriesId) {
		return VideoFinderUtil.findLatestOpenAccessVideoForLectureseries(lectureseriesId);
	}

	public int unlinkLectureseriesFromVideos(Long lectureseriesId) {
		return VideoFinderUtil.unlinkLectureseriesFromVideos(lectureseriesId);
	}

	public List<Video> getByRootInstitution(Long rootInstitutionId) throws SystemException {
		List<Video> vl = videoPersistence.findByRootInstitution(rootInstitutionId);
		return vl;
	}
	
	public List<Video> getByFilename(String filename) throws SystemException {
		List<Video> vl = videoPersistence.findByFilename(filename);
		return vl;
	}

	public List<Video> getByProducer(Long producerId) throws SystemException {
		List<Video> vl = videoPersistence.findByProducer(producerId);
		return vl;
	}

	public List<Video> getByLectureseries(Long lectureseriesId) throws SystemException {
		List<Video> vl = videoPersistence.findByLectureseries(lectureseriesId);
		return vl;
	}

	public List<Video> getByProducerAndLectureseries(Long producerId, Long lectureseriesId) throws SystemException {
		List<Video> vl = videoPersistence.findByProducerAndLectureseries(producerId, lectureseriesId);
		return vl;
	}

	public List<Video> getByProducerAndDownloadLink(Long producerId, int downloadLink) throws SystemException {
		List<Video> vl = videoPersistence.findByProducerAndDownloadLink(producerId, downloadLink);
		return vl;
	}
	
	
	public List<Video> getLatestVideos(){
		return VideoFinderUtil.findLatestVideos();
	}

	@Override
	public Video getFullVideo(Long videoId){
		Video objectVideo = new VideoImpl();
		try {
			objectVideo = videoPersistence.findByPrimaryKey(videoId);
		} catch (NoSuchModelException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		// add all properties to the video object
		Host objectHost = new HostImpl();
		try {
			objectHost = HostLocalServiceUtil.getHost(objectVideo.getHostId());
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		Producer objectProducer = new ProducerImpl();
		try {
			objectProducer = producerPersistence.findByPrimaryKey(objectVideo.getProducerId());
		} catch (NoSuchProducerException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}

		// prepare video short name
		String video_shortname = objectVideo.getTitle();
		if (video_shortname.length() > 45)
			video_shortname = video_shortname.substring(0, 45) + "...";
		objectVideo.setShortTitle(video_shortname);
		
		// thumbnails
		String image = "";
		String imageSmall = "";
		String imageMedium = "";
		String videoPfad = "";
		if (objectVideo.getOpenAccess() == 1) {
			videoPfad = PropsUtil.get("lecture2go.media.repository") + "/" + objectHost.getServerRoot() + "/" + objectProducer.getHomeDir() + "/" + objectVideo.getFilename();
			image = objectVideo.getPreffix() + ".jpg";
			imageSmall = objectVideo.getPreffix() + "_s.jpg";
			imageMedium = objectVideo.getPreffix() + "_m.jpg";
		} else {
			videoPfad = PropsUtil.get("lecture2go.media.repository") + "/" + objectHost.getServerRoot() + "/" + objectProducer.getHomeDir() + "/" + objectVideo.getSurl();
			image = objectVideo.getSPreffix() + ".jpg";
			imageSmall = objectVideo.getSPreffix() + "_s.jpg";
			imageMedium = objectVideo.getSPreffix() + "_m.jpg";
		}

		// set thumbnail
		// if no file
		if (objectVideo.getContainerFormat().equals("") && objectVideo.getFilename().equals("")) {
			objectVideo.setImage("/lecture2go-portlet/img/novideo.jpg");
			objectVideo.setImageSmall("/lecture2go-portlet/img/novideo.jpg");
			objectVideo.setImageMedium("/lecture2go-portlet/img/novideo.jpg");
		}		
		// if audio file
		if (objectVideo.getContainerFormat().equals("mp3")) {
			objectVideo.setImage("/lecture2go-portlet/img/audio_only_big.png");
			objectVideo.setImageSmall("/lecture2go-portlet/img/audio_only_small.png");
			objectVideo.setImageMedium("/lecture2go-portlet/img/audio_only_medium.png");
		}
		// is video
		if (objectVideo.getContainerFormat().equals("mp4")) {
			File videoFile = new File(videoPfad);
			if (videoFile.isFile()) {
				if (!FFmpegManager.thumbnailsExists(objectVideo)) {
					// create thumbnail
					String thumbnailLocation = PropsUtil.get("lecture2go.images.system.path") + "/" + image;
					FFmpegManager.createThumbnail(videoPfad, thumbnailLocation);
				}
				objectVideo.setImage(PropsUtil.get("lecture2go.web.root") + "/images/" + image);
				objectVideo.setImageSmall(PropsUtil.get("lecture2go.web.root") + "/images/" + imageSmall);
				objectVideo.setImageMedium(PropsUtil.get("lecture2go.web.root") + "/images/" + imageMedium);
			} else {
				String img = "/lecture2go-portlet/img/noimage.jpg";
				objectVideo.setImage(img);
				objectVideo.setImageSmall(img);
				objectVideo.setImageMedium(img);
			}
		}
		// date
		// extract time and date from the originalFileName
		String[] parameter = objectVideo.getGenerationDate().split("\\_");
		// check parameter 3 - this is the date
		String l2gDate = "";
		String l2gTime = ""; 
		try{
			l2gDate = parameter[0];
			l2gTime = parameter[1];
			objectVideo.setDate(l2gDate.split("\\-")[2] + "." + l2gDate.split("\\-")[1] + "." + l2gDate.split("\\-")[0] + " - " + l2gTime.split("\\-")[0] + ":" + l2gTime.split("\\-")[1]);
			objectVideo.setSimpleDate(l2gDate.split("\\-")[2] + "." + l2gDate.split("\\-")[1] + "." + l2gDate.split("\\-")[0]);
		}catch(ArrayIndexOutOfBoundsException ai){}
		
		// set preffix and filename
		String preffix = "";
		String filename = "";
		if (objectVideo.getOpenAccess() == 1) {
			preffix = objectVideo.getPreffix();
			filename = objectVideo.getFilename();
		} else {
			preffix = objectVideo.getSPreffix();
			filename = objectVideo.getSurl();
		}
		String homedirPath = "";
		homedirPath = PropsUtil.get("lecture2go.media.repository") + "/" + objectHost.getServerRoot() + "/" + objectProducer.getHomeDir() + "/" + preffix;
		// additional files
		try {
			File mp4File = new File(homedirPath + ".mp4");
			File mp3File = new File(homedirPath + ".mp3");
			File m4vFile = new File(homedirPath + ".m4v");
			File pdfFile = new File(homedirPath + ".pdf");
			File m4aFile = new File(homedirPath + ".m4a");
			File fvlFile = new File(homedirPath + ".flv");
			File oggFile = new File(homedirPath + ".ogg");
			File webmFile = new File(homedirPath + ".webm");
			//
			objectVideo.setMp4File(mp4File);
			objectVideo.setMp3File(mp3File);
			objectVideo.setM4vFile(m4vFile);
			objectVideo.setPdfFile(pdfFile);
			objectVideo.setM4aFile(m4aFile);
			objectVideo.setFlvFile(fvlFile);
			objectVideo.setOggFile(oggFile);
			objectVideo.setWebmFile(webmFile);
		} catch (Exception e) {
			//
		}
		// URL
		String webhome = PropsUtil.get("lecture2go.web.home");
		Institution institudion = new InstitutionImpl();
		try {
			institudion = institutionPersistence.findByPrimaryKey(objectVideo.getRootInstitutionId());
		} catch (NoSuchInstitutionException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		try {
			if (webhome.contains("localhost"))
				webhome += "/web/vod";
			if (institudion.getTyp().equals("tree1"))
				objectVideo.setUrl(webhome + "/l2go/-/v/" + objectVideo.getVideoId());
		} catch (NoSuchElementException nseex) {
		}
		// SURL
		if (objectVideo.getOpenAccess() != 1){
			objectVideo.setSecureUrl(webhome + "/lecture/-/sv/" + objectVideo.getSPreffix());
		}else{
			objectVideo.setSecureUrl("");
		}
		// Streaming-URL
		String streamUrl = "";
		String streamIosUrl = "";
		String streamAndroidUrl = "";
		// base url
		String url = "";
		// wowza stream
		if (objectVideo.getContainerFormat().equals("mp3"))
			url = objectHost.getProtocol() + "://" + objectHost.getStreamer() + "/vod/_definst_/mp3:" + objectVideo.getRootInstitutionId() + "l2g" + objectProducer.getHomeDir() + "/" + filename;
		else
			url = objectHost.getProtocol() + "://" + objectHost.getStreamer() + "/vod/_definst_/mp4:" + objectVideo.getRootInstitutionId() + "l2g" + objectProducer.getHomeDir() + "/" + filename;
		streamUrl = url + "/manifest.f4m"; // normal
		streamIosUrl = url + "/playlist.m3u8"; // iOS
		streamAndroidUrl = url + "/playlist.m3u8"; // android

		objectVideo.setStreamUrl(streamUrl); // normal
		objectVideo.setStreamIosUrl(streamIosUrl); // normal
		objectVideo.setStreamAndroidUrl(streamAndroidUrl); // normal

		List<Segment> sl = new ArrayList<Segment>();
		try {
			sl = SegmentLocalServiceUtil.getSegmentsByVideoId(videoId);
			if(sl.size()>0)objectVideo.setHasChapters(true);
		} catch (PortalException e) {
		} catch (SystemException e) {
		}
		
		//creators
		List<Creator> cl = CreatorLocalServiceUtil.getCreatorsByVideoId(videoId);
		String cS = "";
		ListIterator<Creator> cli = cl.listIterator();
		while(cli.hasNext()){
			cS+=cli.next().getFullName()+"; ";
		}
		objectVideo.setCreators(cS);
		
		return objectVideo;
	}
	
	public JSONArray getJSONVideo(Long videoId){
		Video video = getFullVideo(videoId);
		JSONArray json = new JSONArray();
		
		if(video.getMp4File().isFile()){
			JSONObject jsonoMp4 = new JSONObject();
			try {
				String name="";
				if(video.getOpenAccess()==1){
					name=video.getPreffix()+".mp4";
				}else{
					name=video.getSPreffix()+".mp4";
				}
				jsonoMp4.put("name", name);
				jsonoMp4.put("id", name.replace(".", ""));
				jsonoMp4.put("size", video.getFileSize());
				jsonoMp4.put("type", "mp4");
				json.put(jsonoMp4);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		if(video.getMp3File().isFile()){
			JSONObject jsonoMp3 = new JSONObject();
			try {
				jsonoMp3.put("name", video.getMp3File().getName());
				jsonoMp3.put("id", video.getMp3File().getName().replace(".", ""));
				jsonoMp3.put("size", video.getMp3File().getTotalSpace());
				jsonoMp3.put("type", "mp3");
				json.put(jsonoMp3);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		if(video.getM4aFile().isFile()){
			JSONObject jsonoM4a = new JSONObject();
			try {
				jsonoM4a.put("name", video.getM4aFile().getName());
				jsonoM4a.put("id", video.getM4aFile().getName().replace(".", ""));
				jsonoM4a.put("size",  video.getM4aFile().getTotalSpace());
				jsonoM4a.put("type", "m4a");
				json.put(jsonoM4a);
			} catch (JSONException e) {
				e.printStackTrace();
			} 
		}

		if(video.getM4vFile().isFile()){
			JSONObject jsonoM4v = new JSONObject();
			try {
				jsonoM4v.put("name", video.getM4vFile().getName());
				jsonoM4v.put("id", video.getM4vFile().getName().replace(".", ""));
				jsonoM4v.put("size", video.getM4vFile().getTotalSpace());
				jsonoM4v.put("type", "m4v");
				json.put(jsonoM4v);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		if(video.getPdfFile().isFile()){
			JSONObject pdf = new JSONObject();
			try {
				pdf.put("name", video.getPdfFile().getName());
				pdf.put("id", video.getPdfFile().getName().replace(".", ""));
				pdf.put("size", video.getPdfFile().getTotalSpace());
				pdf.put("type", "pdf");
				json.put(pdf);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		if(video.getFlvFile().isFile()){
			JSONObject flv = new JSONObject();
			try {
				flv.put("name", video.getFlvFile().getName());
				flv.put("id", video.getFlvFile().getName().replace(".", ""));
				flv.put("size", video.getFlvFile().getTotalSpace());
				flv.put("type", "flv");
				json.put(flv);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		if(video.getOggFile().isFile()){
			JSONObject ogg = new JSONObject();
			try {
				ogg.put("name", video.getOggFile().getName());
				ogg.put("id", video.getOggFile().getName().replace(".", ""));
				ogg.put("size", video.getOggFile().getTotalSpace());
				ogg.put("type", "ogg");
				json.put(ogg);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		if(video.getWebmFile().isFile()){
			JSONObject webm = new JSONObject();
			try {
				webm.put("name", video.getWebmFile().getName());
				webm.put("id", video.getWebmFile().getName().replace(".", ""));
				webm.put("size", video.getWebmFile().getTotalSpace());
				webm.put("type", "webm");
				json.put(webm);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
	
	public void createLastVideoList() throws SystemException {
		List<Video> vlist = this.getLatestVideos();
		//refresh the whole video list in the table
		lastvideolistPersistence.removeAll();
		Iterator<Video> vIt = vlist.listIterator();
		while(vIt.hasNext()){
			Video v = vIt.next();
			//save videos in table
			Lastvideolist lastvideolist = new LastvideolistImpl();
			lastvideolist.setVideoId(v.getVideoId());
			LastvideolistLocalServiceUtil.addLastvideolist(lastvideolist);
		}
	}

	public List<Video> getByLectureseriesAndOpenaccess(Long lectureseriesId, int openAccess) throws SystemException{
		List<Video> vl = videoPersistence.findByLectureseriesAndOpenaccess(lectureseriesId, openAccess);
		List<Video> rvl = new ArrayList<Video>();
		ListIterator<Video> vli = vl.listIterator();
		while(vli.hasNext()){
			Video objectVideo = getFullVideo(vli.next().getVideoId());
			rvl.add(objectVideo);
		}
		return rvl;
	}
	
	public List<Video> getFilteredByInstitutionParentInstitutionTermCategoryCreator (Long institutionId, Long parentInstitutionId, ArrayList<Long> termIds, ArrayList<Long> categoryIds, ArrayList<Long> creatorIds){
		return VideoFinderUtil.findFilteredByInstitutionParentInstitutionTermCategoryCreator(institutionId, parentInstitutionId, termIds, categoryIds, creatorIds);
	}
}
