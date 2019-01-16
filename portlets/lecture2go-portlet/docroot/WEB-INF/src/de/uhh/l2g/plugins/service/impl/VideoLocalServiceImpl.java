
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
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
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
import de.uhh.l2g.plugins.util.ProzessManager;

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

	public int getByOpenAccessAndUploadedFile(int bool) throws SystemException {
		return	videoPersistence.countByOpenAccessAndUploadedFile(bool);
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

	public int countByLectureseries(Long lectureseriesId) throws SystemException {
		return videoPersistence.countByLectureseries(lectureseriesId);
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
	
	public void createThumbnailsIfNotExisting(Long videoId) {
		Video objectVideo = new VideoImpl();
		try {
			objectVideo = getVideo(videoId);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		// only create thumbnails for mp4 files
		if (objectVideo.getContainerFormat().equals("mp4")) {
			/*String filePath = PropsUtil.get("lecture2go.media.repository") + "/" + objectVideo.getHost().getServerRoot() + "/" + objectVideo.getProducer().getHomeDir() + "/" + objectVideo.getFilename();
			File videoFile = new File(filePath);*/
			File videoFile = objectVideo.getMp4File();

			if (videoFile.isFile()) {
				if (!FFmpegManager.thumbnailsExists(objectVideo)) {
					// create thumbnail
					String thumbnailLocation = PropsUtil.get("lecture2go.images.system.path") + "/" + objectVideo.getCurrentPrefix() + ".jpg";
					//duration in seconds 
					String myDateString = objectVideo.getDuration();
					//SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
					//the above commented line was changed to the one below, as per Grodriguez's pertinent comment:
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					try {
						java.util.Date date = sdf.parse(myDateString);
						Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
						calendar.setTime(date);   // assigns calendar to given date 
						int hour = calendar.get(Calendar.HOUR);
						int min = calendar.get(Calendar.MINUTE);
						int sec = calendar.get(Calendar.SECOND);
						int dur = hour+sec+min;
						FFmpegManager.createThumbnail(videoFile.getPath(), thumbnailLocation, dur/2);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
					}
				}
			}
		}
	}
	
	public void createSymLinkToDownloadableFileIfNotExisting(Long videoId) {
		Video objectVideo = new VideoImpl();
		try {
			objectVideo = getVideo(videoId);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		Host objectHost = objectVideo.getHost();
		Producer objectProducer = objectVideo.getProducer();

		// check if file with download-suffix exists, if not create it 
		// (we always create a _symlink_ with download suffix even if download is not permitted, as this file is also used as an RSTP _fallback_)
		if(checkSmilFile(objectVideo)){
			File file = new File(PropsUtil.get("lecture2go.media.repository") + "/" + objectHost.getServerRoot() + "/" + objectProducer.getHomeDir() + "/" + objectVideo.getCurrentPrefix()+PropsUtil.get("lecture2go.videoprocessing.downloadsuffix")+".mp4");
			try {
				if (!isSymlink(file)) {
					ProzessManager pm = new ProzessManager();
					pm.createSymLinkToDownloadableFile(objectHost, objectVideo, objectProducer);
				}
			} catch (Exception e) {
				//e.printStackTrace();
			} 
		}
	}
	
	public JSONArray getJSONVideo(Long videoId){
		JSONArray json = new JSONArray();
		try {
			Video video = getVideo(videoId);
					
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
	//				//e.printStackTrace();
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
	//				//e.printStackTrace();
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
	//				//e.printStackTrace();
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
	//				//e.printStackTrace();
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
	//				//e.printStackTrace();
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
	//				//e.printStackTrace();
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
	//				//e.printStackTrace();
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
	//				//e.printStackTrace();
				}
			}
		
		} catch (Exception e) {

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

	public int countByLectureseriesAndOpenaccess(Long lectureseriesId, int openAccess) throws SystemException{
		return videoPersistence.countByLectureseriesAndOpenaccess(lectureseriesId, openAccess);
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
	public void addPlayerUris2Video(Video video){
		
		Host host = video.getHost();
		Producer producer = video.getProducer();
		
		ArrayList<String> playerUris = new ArrayList<String>();
		JSONArray playerUrisSortedJSON = new JSONArray();
		
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
			/*
			if(video.getOpenAccess()==1){
				if (checkSmilFile(video)) {
					playerUri = playerUri.replace("[smilfile]", video.getPreffix()+".smil");
				}
				playerUri = playerUri.replace("[filename]", video.getFilename());
			}else{
				if (checkSmilFile(video)) {
					playerUri = playerUri.replace("[smilfile]", video.getSPreffix()+".smil");
				}
				playerUri = playerUri.replace("[filename]", video.getSecureFilename());
			}*/
			
			if (checkSmilFile(video)) {
				playerUri = playerUri.replace("[smilfile]", video.getCurrentPrefix() +".smil");
			}
			playerUri = playerUri.replace("[filename]", video.getCurrentMp4FilenameWithReasonableBitrate());
			//
			playerUri = playerUri.replace("[host]", host.getStreamer());
			playerUri = playerUri.replace("[ext]", video.getContainerFormat());
			playerUri = playerUri.replace("[l2go_path]", l2go_path);
			playerUri = playerUri.replace("[protocol]", host.getProtocol());
			playerUri = playerUri.replace("[port]", host.getPort()+"");
			//
			if( playerUri.length()>0 && !playerUri.contains("[") && !playerUri.contains("]") )playerUris.add(playerUri);
			
		}
		//sort player with priority set in the portal-ext.properties
		for(int i=0; i<playerUris.size();i++){
			String uri = playerUris.get(i);
			//json object
			JSONObject o = new JSONObject();
			//container
			String container ="";
			int l = uri.trim().split("\\.").length;
			container = uri.trim().split("\\.")[l-1];
			String downloadServ = PropsUtil.get("lecture2go.downloadserver.web.root");

			//check player files!
			boolean smilFileAllowed = (uri.contains("vod/_definst/smil") && checkSmilFile(video) && container.contains("m3u8"));
			boolean hlsStreamingAllowed = ((uri.contains("vod/_definst/mp4") || uri.contains("vod/_definst/mp3"))  && !checkSmilFile(video));
			boolean downloadAllowed = (uri.contains(downloadServ) && video.getDownloadLink()==1);
			boolean rtspAllowed = (uri.contains("rtsp"));

			if(smilFileAllowed || hlsStreamingAllowed || downloadAllowed || rtspAllowed){
				//custom case for download allowed 
				//and oper or closed case
				if(downloadAllowed && video.getOpenAccess()==0){
					uri=downloadServ+"/down/"+l2go_path+"/"+video.getSecureFilename();
				}
				try {
					o.put("file", uri);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				playerUrisSortedJSON.put(o);
			}
		}
		//
		video.setJsonPlayerUris(playerUrisSortedJSON);
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
		List<Video> vl = new ArrayList<Video>();
		if(lectureseriesId!=0)vl=VideoFinderUtil.findVideosBySearchWordAndLectureseriesId(word, lectureseriesId);	
		List<Video> rvl = getSortedVideoList(vl, lectureseriesId);		
		return rvl;
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
				//e.printStackTrace();
			}
		return v;
	}
	
	
	private List<Video> getSortedVideoList(List<Video> vl, Long lectureseriesId) throws SystemException
	{ 
		List<Video> sortedVideoList = new ArrayList<Video>();
		
		if(vl == null || lectureseriesId < 1)
			return sortedVideoList;
		
		for(Video objectVideo: vl) {
			if(objectVideo.getFilename().trim().length()>0)sortedVideoList.add(objectVideo); 
		}
		int sortVideo = 0;
		try {
			Lectureseries lectureseriesObject = lectureseriesPersistence.findByPrimaryKey(lectureseriesId);
			sortVideo = lectureseriesObject.getVideoSort();
		} catch (NoSuchModelException e) {
			//e.printStackTrace();
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
	
	public Long getLatestClosedAccessVideoId(Long lectureseriesId){
		List<Video> vl = new ArrayList<Video>();
		try {
			vl = getByLectureseriesAndOpenaccess(lectureseriesId,0);
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		return vl.get(0).getVideoId();
	}
	
	/**
	 * Checks if the video has a related smil-file in the file system
	 */
	public boolean checkSmilFile(Video video) {
		Host host = new HostImpl();
		try {
			host = HostLocalServiceUtil.getHost(video.getHostId());
		} catch (PortalException e1) {
//			e1.printStackTrace();
		} catch (SystemException e1) {
//			e1.printStackTrace();
		}
		Producer producer = new ProducerImpl();
		try {
			producer = producerPersistence.findByPrimaryKey(video.getProducerId());
		} catch (NoSuchProducerException e1) {
//			e1.printStackTrace();
		} catch (SystemException e1) {
//			e1.printStackTrace();
		}
		String  mediaRep = PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir();

		// set prefix according to openaccess filename or secured
		String prefix = video.getOpenAccess()==1 ? video.getPreffix() : video.getSPreffix();
		String smilPath = mediaRep + "/" + prefix +".smil";
		File smilFile = new File(smilPath);
		return smilFile.isFile();
	}

	public boolean fileStringSegmentFoundInArray(String file, JSONArray jsonArray){
		boolean ret = false;
		for(int i=0;i<jsonArray.length();i++){
			try {
				Object o = jsonArray.get(i);
				int df = 0;
				df++;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * Checks if file is a symoblic link
	 * @param file the file to check
	 * @return true if file is sym link, false if not
	 * @throws IOException
	 */
	public boolean isSymlink(File file) throws IOException {
		return Files.isSymbolicLink(file.toPath());
	}
}
