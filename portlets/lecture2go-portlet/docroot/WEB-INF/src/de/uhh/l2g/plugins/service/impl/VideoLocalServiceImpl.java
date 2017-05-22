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
import java.util.Collections;
import java.util.Comparator;
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
import de.uhh.l2g.plugins.NoSuchLectureseriesException;
import de.uhh.l2g.plugins.NoSuchProducerException;
import de.uhh.l2g.plugins.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.LastvideolistImpl;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
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
	public List<Video> getByOpenAccess(int bool) throws SystemException {
		return videoPersistence.findByOpenAccess(bool);
	}

	public Video getLatestOpenAccessVideoForLectureseries(Long lectureseriesId) {
		return VideoFinderUtil.findLatestOpenAccessVideoForLectureseries(lectureseriesId);
	}
	
	public List<Video> getByTerm(Long termId) throws SystemException {
		List<Video> vl = videoPersistence.findByTerm(termId);
		return vl;
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
		List<Video> rvl = getSortedVideoList(vl, lectureseriesId);
		return rvl;
	}

	public List<Video> getByProducerAndLectureseries(Long producerId, Long lectureseriesId) throws SystemException {
		List<Video> vl = videoPersistence.findByProducerAndLectureseries(producerId, lectureseriesId);
		return vl;
	}

	public List<Video> getByProducerAndDownloadLink(Long producerId, int downloadLink) throws SystemException {
		List<Video> vl = videoPersistence.findByProducerAndDownloadLink(producerId, downloadLink);
		return vl;
	}
	
	public List<Video> getPopular(int limit){
		return VideoFinderUtil.findPopular(limit);
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
//			e1.printStackTrace();
		} catch (SystemException e1) {
//			e1.printStackTrace();
		}
		// add all properties to the video object
		Host objectHost = new HostImpl();
		try {
			objectHost = HostLocalServiceUtil.getHost(objectVideo.getHostId());
		} catch (PortalException e1) {
//			e1.printStackTrace();
		} catch (SystemException e1) {
//			e1.printStackTrace();
		}
		Producer objectProducer = new ProducerImpl();
		try {
			objectProducer = producerPersistence.findByPrimaryKey(objectVideo.getProducerId());
		} catch (NoSuchProducerException e1) {
//			e1.printStackTrace();
		} catch (SystemException e1) {
//			e1.printStackTrace();
		}
		@SuppressWarnings("unused")
		Lectureseries objectLectureseries = new LectureseriesImpl();
		try {
			objectLectureseries = lectureseriesPersistence.findByPrimaryKey(objectVideo.getLectureseriesId());
		} catch (NoSuchLectureseriesException e1) {
//			e1.printStackTrace();
		} catch (SystemException e1) {
//			e1.printStackTrace();
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
			videoPfad = PropsUtil.get("lecture2go.media.repository") + "/" + objectHost.getServerRoot() + "/" + objectProducer.getHomeDir() + "/" + objectVideo.getSecureFilename();
			image = objectVideo.getSPreffix() + ".jpg";
			imageSmall = objectVideo.getSPreffix() + "_s.jpg";
			imageMedium = objectVideo.getSPreffix() + "_m.jpg";
		}

		// set thumbnail
		// if no file
		if (objectVideo.getContainerFormat().equals("") && objectVideo.getFilename().equals("")) {
			objectVideo.setImage("/lecture2go-portlet/img/nomedia.png");
			objectVideo.setImageSmall("/lecture2go-portlet/img/nomedia.png");
			objectVideo.setImageMedium("/lecture2go-portlet/img/nomedia.png");
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
				String img = "/lecture2go-portlet/img/noimage.png";
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
		@SuppressWarnings("unused")
		String filename = "";
		if (objectVideo.getOpenAccess() == 1) {
			preffix = objectVideo.getPreffix();
			filename = objectVideo.getFilename();
		} else {
			preffix = objectVideo.getSPreffix();
			filename = objectVideo.getSecureFilename();
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
			String vttChapterFile = new String(PropsUtil.get("lecture2go.chapters.web.root") +"/"+objectVideo.getVideoId()+".vtt");
			//
			objectVideo.setMp4File(mp4File);
			objectVideo.setMp3File(mp3File);
			objectVideo.setM4vFile(m4vFile);
			objectVideo.setPdfFile(pdfFile);
			objectVideo.setM4aFile(m4aFile);
			objectVideo.setFlvFile(fvlFile);
			objectVideo.setOggFile(oggFile);
			objectVideo.setWebmFile(webmFile);
			objectVideo.setVttChapterFile(vttChapterFile);
			//test
		} catch (Exception e) {
			//
		}
		// URL
		String webhome = PropsUtil.get("lecture2go.web.home");
		@SuppressWarnings("unused")
		Institution institution = new InstitutionImpl();
		try {
			institution = institutionPersistence.findByPrimaryKey(objectVideo.getRootInstitutionId());
		} catch (NoSuchInstitutionException e) {
//			e.printStackTrace();
		} catch (SystemException e) {
//			e.printStackTrace();
		}
		try {
			if (webhome.contains("localhost"))
				webhome += "/web/vod";
			objectVideo.setUrl(webhome + "/l2go/-/get/v/" + objectVideo.getVideoId());
			if(objectVideo.getLectureseriesId()>0)
				objectVideo.setLectureseriesUrl(webhome + "/l2go/-/get/l/" + objectVideo.getLectureseriesId()); 
		} catch (NoSuchElementException nseex) {
		}
		// SURL
		if (objectVideo.getOpenAccess() != 1){
			objectVideo.setSecureUrl(webhome + "/l2go/-/get/v/" + objectVideo.getSPreffix());
		}else{
			objectVideo.setSecureUrl("");
		}
		
		// Streaming-URL
		addPlayerUris2Video(objectHost, objectVideo, objectProducer);
		//Streaming-URL end
			
		List<Segment> sl = new ArrayList<Segment>();
		try {
			sl = SegmentLocalServiceUtil.getSegmentsByVideoId(videoId);
			if(sl.size()>0)objectVideo.setHasChapters(true);
		} catch (PortalException e) {
		} catch (SystemException e) {
		}
		
		//creators
		String linkedCreators = CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(videoId,3);
		objectVideo.setLinkedCreators(linkedCreators);

		String creators = CreatorLocalServiceUtil.getCommaSeparatedCreatorsByVideoIdAndMaxCreators(videoId,3);
		objectVideo.setCreators(creators);
		
		//get download Links 
		@SuppressWarnings("unused")
		String l2go_path = objectVideo.getRootInstitutionId() + "l2g" + objectProducer.getHomeDir();
		String preff="";
		String pth="";
		if(objectVideo.getOpenAccess()==1){
			preff=objectVideo.getPreffix();
			pth = PropsUtil.get("lecture2go.downloadserver.web.root")+"/abo/";
		}
		else {
			preff=objectVideo.getSPreffix();
			///getFile?downloadPath=/vh_001/rzii014/00.000_video-20527_2016-12-20_15-26.mp4&downloadAllowed=1
			pth = PropsUtil.get("lecture2go.downloadserver.web.root")+"/servlet-file-download/getFile?downloadAllowed="+objectVideo.getDownloadLink()+"&downloadPath=/"+objectHost.getName()+"/"+objectProducer.getHomeDir()+"/";
		}
		String downMp3Link = pth+preff+".mp3";
		String downMp4Link = pth+preff+".mp4";
		String downM4vLink = pth+preff+".m4v";
		String downM4aLink = pth+preff+".m4a";
		String downWebmLink = pth+preff+".webm";
		String downPdfLink = pth+preff+".pdf";
		String downOggLink = pth+preff+".ogg";
		String downFlvLink = pth+preff+".flv";
		//
		objectVideo.setMp4DownloadLink(downMp4Link);
		objectVideo.setMp3DownloadLink(downMp3Link);
		objectVideo.setM4vDownloadLink(downM4vLink);
		objectVideo.setM4aDownloadLink(downM4aLink);
		objectVideo.setWebmDownloadLink(downWebmLink);
		objectVideo.setPdfDownloadLink(downPdfLink);
		objectVideo.setOggDownloadLink(downOggLink);
		objectVideo.setFlvDownloadLink(downFlvLink);
		//rss links
		if(objectVideo.getLectureseriesId()>0){
			String rssMp3Link = PropsUtil.get("lecture2go.web.root")+"/rss/"+objectVideo.getLectureseriesId()+".mp3.xml";
			String rssMp4Link = PropsUtil.get("lecture2go.web.root")+"/rss/"+objectVideo.getLectureseriesId()+".mp4.xml";
			String rssM4vLink = PropsUtil.get("lecture2go.web.root")+"/rss/"+objectVideo.getLectureseriesId()+".m4v.xml";
			String rssM4aLink = PropsUtil.get("lecture2go.web.root")+"/rss/"+objectVideo.getLectureseriesId()+".m4a.xml";
			String rssWebmLink = PropsUtil.get("lecture2go.web.root")+"/rss/"+objectVideo.getLectureseriesId()+".webm.xml";
			String rssOggLink = PropsUtil.get("lecture2go.web.root")+"/rss/"+objectVideo.getLectureseriesId()+".ogg.xml";
			String rssFlvLink = PropsUtil.get("lecture2go.web.root")+"/rss/"+objectVideo.getLectureseriesId()+".flv.xml";		
			//
			objectVideo.setMp3RssLink(rssMp3Link);
			objectVideo.setMp4RssLink(rssMp4Link);
			objectVideo.setM4vRssLink(rssM4vLink);
			objectVideo.setM4aRssLink(rssM4aLink);
			objectVideo.setWebmRssLink(rssWebmLink);
			objectVideo.setOggRssLink(rssOggLink);
			objectVideo.setFlvRssLink(rssFlvLink);
		}
		
		//embed iframe
		String embedIframe="<iframe src='"+PropsUtil.get("lecture2go.web.root")+"/lecture2go-portlet/player/iframe/?v="+objectVideo.getVideoId()+"' frameborder='0' width='647' height='373'></iframe>";
		objectVideo.setEmbedIframe(embedIframe);
		
		//embed html5
		String embedHtml5="";
		if(objectVideo.getDownloadLink()==1){
			if(objectVideo.getContainerFormat().equals("mp4")){
				if(objectVideo.getOpenAccess()==1){
					embedHtml5="<video width='647' height='373' controls><source src='"+PropsUtil.get("lecture2go.downloadserver.web.root")+"/abo/"+objectVideo.getPreffix()+".mp4"+"' type='video/mp4'>Your browser does not support the video tag.</video>";
				}else{
					embedHtml5="<video width='647' height='373' controls><source src='"+PropsUtil.get("lecture2go.downloadserver.web.root")+"/videorep/"+objectHost.getServerRoot()+"/"+objectProducer.getHomeDir()+"/"+objectVideo.getSecureFilename()+"' type='video/mp4'>Your browser does not support the video tag.</video>";
				}
			}else{
				if(objectVideo.getOpenAccess()==1){
					embedHtml5="<audio controls><source src='"+PropsUtil.get("lecture2go.downloadserver.web.root")+"/abo/"+objectVideo.getPreffix()+".mp3"+"' type='audio/mpeg'>Your browser does not support the audio element.</audio>";
				}else{
					embedHtml5="<audio controls><source src='"+PropsUtil.get("lecture2go.downloadserver.web.root")+"/videorep/"+objectHost.getServerRoot()+"/"+objectProducer.getHomeDir()+"/"+objectVideo.getSecureFilename()+"' type='audio/mpeg'>Your browser does not support the audio element.</audio>";
				}				
			}
		}
		
		//embed commsy
		String embedCommsy="";
		if(objectVideo.getOpenAccess()==1){
			embedCommsy ="(:lecture2go "+objectVideo.getRootInstitutionId() + "l2g" + objectProducer.getHomeDir()+"/"+objectVideo.getFilename()+":)";
		}else{
			embedCommsy ="(:lecture2go "+objectVideo.getRootInstitutionId() + "l2g" + objectProducer.getHomeDir()+"/"+objectVideo.getSecureFilename()+":)";
		}
		objectVideo.setEmbedCommsy(embedCommsy);
		
		objectVideo.setEmbedHtml5(embedHtml5);
		
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
		List<Video> vl = new ArrayList<Video>();
		if(lectureseriesId!=0)vl=videoPersistence.findByLectureseriesAndOpenaccess(lectureseriesId, openAccess);	
		List<Video> rvl = getSortedVideoList(vl, lectureseriesId);		
		return rvl;
	}
	
	/**
	 * required properties for jwplayer in portal-ext.properties file
	 * 
	 * [host]=configured host in database (automatically e.g. streaming.server.com)
	 * [ext]=file extension (automatically e.g mp3)
	 * [l2go_path]=generated lecture2go file path (automatically e.g. 3l2gproducer1)
	 * [filename]=video file name (automatically e.g 00.000_video_2015-06-08_08-06.mp4)
	 * [protocol]=host protocol (automatically e.g rtmpt)
	 * [port]=host port (automatically e.g 80)
	 * [smilfile]=adaptive streaming file 
	 * 
	 * example for lecture2go configuration
	 * lecture2go.uri1.player.template=https://[host]/vod/_definst/smil:[l2go_path]/[smilfile]/playlist.m3u8
	 * lecture2go.uri2.player.template=https://[host]/vod/_definst/[ext]:[l2go_path]/[filename]/playlist.m3u8
	 * lecture2go.uri3.player.template=rtmpt://[host]/vod/_definst/[ext]:[l2go_path]/[filename]
	 * lecture2go.uri4.player.template=${lecture2go.downloadserver.web.root}/abo/[filename]
	 * lecture2go.uri5.player.template=rtsp://[host]:[port]/vod/_definst/[ext]:[l2go_path]/[filename]
	**/
	public void addPlayerUris2Video(Host host, Video video, Producer producer){
		ArrayList<String> playerUris = new ArrayList<String>();
		String  mediaRep = PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir();
		
		String l2go_path = video.getRootInstitutionId() + "l2g" + producer.getHomeDir();
		
		String uri1 = PropsUtil.get("lecture2go.uri1.player.template");
		String uri2 = PropsUtil.get("lecture2go.uri2.player.template");
		String uri3 = PropsUtil.get("lecture2go.uri3.player.template");
		String uri4 = PropsUtil.get("lecture2go.uri4.player.template");
		String uri5 = PropsUtil.get("lecture2go.uri5.player.template");
		
		ArrayList<String> uris = new ArrayList<String>();
		uris.add(uri1);uris.add(uri2);uris.add(uri3);uris.add(uri4);uris.add(uri5);
		
		for(int i=0; i<uris.size();i++){
			String playerUri = "";
			playerUri += uris.get(i);
			if(video.getOpenAccess()==1){
				//check for smil file
				String smilPath = mediaRep + "/" + video.getPreffix()+".smil";
				File smilFile = new File(smilPath);
				if(smilFile.isFile()) playerUri = playerUri.replace("[smilfile]", video.getPreffix()+".smil");
				playerUri = playerUri.replace("[filename]", video.getFilename());
			}else{
				//check for smil file
				String smilPath = mediaRep + "/" + video.getSPreffix()+".smil";
				File smilFile = new File(smilPath);				
				if(smilFile.isFile()) playerUri = playerUri.replace("[smilfile]", video.getSPreffix()+".smil");
				playerUri = playerUri.replace("[filename]", video.getSecureFilename());
				
			}
			//
			playerUri = playerUri.replace("[host]", host.getStreamer());
			playerUri = playerUri.replace("[ext]", video.getContainerFormat());
			playerUri = playerUri.replace("[l2go_path]", l2go_path);
			playerUri = playerUri.replace("[protocol]", host.getProtocol());
			playerUri = playerUri.replace("[port]", host.getPort()+"");
			//
			if( playerUri.length()>0 && !playerUri.contains("[") && !playerUri.contains("]") )playerUris.add(playerUri);
			else playerUris.add("null");
		}
		//sort player uris 
		for(int i=0; i<playerUris.size();i++){
			if(playerUris.get(i).contains("null"))playerUris.set(i, playerUris.get(i+1));
		}
		video.setPlayerUris(playerUris);
	}
	
	public Video getBySecureUrl(String surl) throws NoSuchVideoException, SystemException{
		return VideoFinderUtil.findVideoBySerureUrl(surl);
	}
	
	public List<Video> getAll() throws SystemException{
		return videoPersistence.findAll();
	}

	public List<Video> getBySearchWord(String word, int limit) throws SystemException{
		return VideoFinderUtil.findVideosBySearchWord(word, limit);
	}	
	
	public List<Video> getByAllSearchWords() throws SystemException{
		return VideoFinderUtil.findVideosByAllSearchWords();
	}	

	public List<Video> getBySearchWordAndLectureseriesId(String word, Long lectureseriesId) throws SystemException{
		return VideoFinderUtil.findVideosBySearchWordAndLectureseriesId(word, lectureseriesId);
	}	
	
	public List<Video> getByHits(Long hits){
		return VideoFinderUtil.findVideosByHits(hits);
	}

	public List<Video> getByHitsAndOpenAccess(Long hits){
		return VideoFinderUtil.findVideosByHitsAndOpenAccess(hits);
	}
	
	public List<Video> getByHits(){
		return VideoFinderUtil.findVideosByHits(0);
	}
	
	@Override
	public Video updateVideo(Video video){
		Video v = new VideoImpl();
		if(video.getVideoId()>0)
			try {
				v=super.updateVideo(video);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		return v;
	}
	
	
	private List<Video> getSortedVideoList(List<Video> vl, Long lectureseriesId) throws SystemException
	{ 
		List<Video> sortedVideoList = new ArrayList<Video>();
		
		if(vl == null || lectureseriesId < 1)
			return sortedVideoList;
	
		ListIterator<Video> vli = vl.listIterator();
		while(vli.hasNext()){
			Video objectVideo = getFullVideo(vli.next().getVideoId());
			if(objectVideo.getFilename().trim().length()>0)sortedVideoList.add(objectVideo);
		}
		int sortVideo = 0;
		try {
			Lectureseries lectureseriesObject = lectureseriesPersistence.findByPrimaryKey(lectureseriesId);
			sortVideo = lectureseriesObject.getVideoSort();
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}
		
		// Sort by generation date
		Collections.sort(sortedVideoList, new Comparator<Video>() {
				@Override
				public int compare(Video v1, Video v2) {
					return  v2.getGenerationDate().compareTo(v1.getGenerationDate());
				}
		    });
		
		// Sort videos ascending
		if(sortVideo == 1)
		{
			Collections.reverse(sortedVideoList);
		}
		
		return sortedVideoList;
	}
	
}
