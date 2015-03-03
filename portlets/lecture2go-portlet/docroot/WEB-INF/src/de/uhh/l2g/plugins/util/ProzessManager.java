package de.uhh.l2g.plugins.util;

/***************************************************************************
 * The Lecture2Go software is based on the liferay portal 6.1.1
 * <http://www.liferay.com>
 *
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 *
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 *
 * @Autor Lecture2Go Team
 * @Version 1.0
 * @Contact lecture2go-open-source@uni-hamburg.de
 *
 * Copyright (c) 2013 University of Hamburg / Computer and Data Center (RRZ)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ***************************************************************************/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.LastvideolistLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.Segment_User_VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.UploadLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideohitlistLocalServiceUtil;

public class ProzessManager {
	
	Htaccess HTACCESS = new Htaccess();
	
	public void deactivateDownload(Video video) throws SystemException, PortalException {
		Host host = HostLocalServiceUtil.getHost(video.getHostId());
		Producer producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
		
		video.setDownloadLink(0);
		VideoLocalServiceUtil.updateVideo(video);
		// set RSS
		try {
			generateRSS(video, "mp4");
			generateRSS(video, "mp3");
			generateRSS(video, "m4v");
			generateRSS(video, "m4a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/";
		HTACCESS.makeHtaccess(url, VideoLocalServiceUtil.getByProducerAndDownloadLink(producer.getProducerId(), 0));
	}

	public void activateDownload(Video video) throws SystemException, PortalException {
		Host host = HostLocalServiceUtil.getHost(video.getHostId());
		Producer producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
		
		video.setDownloadLink(1);
		VideoLocalServiceUtil.updateVideo(video);
		// set RSS
		try {
			generateRSS(video, "mp4");
			generateRSS(video, "mp3");
			generateRSS(video, "m4v");
			generateRSS(video, "m4a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/";
		HTACCESS.makeHtaccess(url, VideoLocalServiceUtil.getByProducerAndDownloadLink(producer.getProducerId(), 0));
	}

	public void activateOpenaccess(Video video) throws SystemException, PortalException {
		Host host = HostLocalServiceUtil.getHost(video.getHostId());
		Producer producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
		Lectureseries lectureseries = new LectureseriesImpl();
		try{
			lectureseries= LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
		}catch(Exception e){}

		// first rename the file from the filesystem first
		String path = PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir();
		String videoPreffix = video.getPreffix();
		String videoSPreffix = video.getSPreffix();
		try {
			// then update the filesystem
			// here rename
			File fJpg = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoSPreffix + ".jpg");
			File fJpgm = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoSPreffix + "_m.jpg");
			File fJpgs = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoSPreffix + "_s.jpg");
			File fPdf = new File(path + "/" + videoSPreffix + ".pdf");
			File fMp3 = new File(path + "/" + videoSPreffix + ".mp3");
			File fM4v = new File(path + "/" + videoSPreffix + ".m4v");
			File fMp4 = new File(path + "/" + videoSPreffix + ".mp4");
			File fM4a = new File(path + "/" + videoSPreffix + ".m4a");
			File fOgg = new File(path + "/" + videoSPreffix + ".ogg");
			File fFlv = new File(path + "/" + videoSPreffix + ".flv");
			File fWebm = new File(path + "/" + videoSPreffix + ".webm");
			timeout();// wait for a while!
			// if mp4 or mp3 exists
			if (fMp4.isFile() || fMp3.isFile()) {
				fJpg.renameTo(new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + ".jpg"));
				fJpgm.renameTo(new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + "_m.jpg"));
				fJpgs.renameTo(new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + "_s.jpg"));
				fPdf.renameTo(new File(path + "/" + videoPreffix + ".pdf"));
				fMp3.renameTo(new File(path + "/" + videoPreffix + ".mp3"));
				fM4v.renameTo(new File(path + "/" + videoPreffix + ".m4v"));
				fMp4.renameTo(new File(path + "/" + videoPreffix + ".mp4"));
				fM4a.renameTo(new File(path + "/" + videoPreffix + ".m4a"));
				fOgg.renameTo(new File(path + "/" + videoPreffix + ".ogg"));
				fFlv.renameTo(new File(path + "/" + videoPreffix + ".flv"));
				fWebm.renameTo(new File(path + "/" + videoPreffix + ".webm"));
				// then update the video in the database
				video.setOpenAccess(1);
				video.setSurl("");
				VideoLocalServiceUtil.updateVideo(video);
			}
		} catch (Exception e) {
		}
		// set RSS
		try {
			generateRSS(video, "mp4");
			generateRSS(video, "mp3");
			generateRSS(video, "m4v");
			generateRSS(video, "m4a");
		} catch (Exception e) {
		}
		// rss reload
		generateRSS(video, "mp4");
		generateRSS(video, "mp3");
		generateRSS(video, "m4v");
		generateRSS(video, "m4a");
		String url = PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/";
		HTACCESS.makeHtaccess(url, VideoLocalServiceUtil.getByProducerAndDownloadLink(producer.getProducerId(), 0));
		// refresh last video list
		VideoLocalServiceUtil.createLastVideoList();
		// refresh open acces for lecture series
		LectureseriesLocalServiceUtil.updateOpenAccess(video, lectureseries); 
	}

	public void deactivateOpenaccess(Video video) throws PortalException, SystemException {
		Host host = HostLocalServiceUtil.getHost(video.getHostId());
		Producer producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
		Lectureseries lectureseries = new LectureseriesImpl();
		try{
			lectureseries= LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
		}catch(Exception e){}
		
		// then update the filesystem
		String path = PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir();
		String videoPreffix = video.getPreffix();
		// here rename
		File fJpg = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + ".jpg");
		File fJpgm = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + "_m.jpg");
		File fJpgs = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + "_s.jpg");
		File fPdf = new File(path + "/" + videoPreffix + ".pdf");
		File fMp3 = new File(path + "/" + videoPreffix + ".mp3");
		File fM4v = new File(path + "/" + videoPreffix + ".m4v");
		File fMp4 = new File(path + "/" + videoPreffix + ".mp4");
		File fM4a = new File(path + "/" + videoPreffix + ".m4a");
		File fOgg = new File(path + "/" + videoPreffix + ".ogg");
		File fFlv = new File(path + "/" + videoPreffix + ".flv");
		File fWebm = new File(path + "/" + videoPreffix + ".webm");		
		// wait for a wile!
		timeout();
		if (fMp4.isFile() || fMp3.isFile()) {
			// first update the video in the database and, set openaccess
			video.setOpenAccess(0);
			//generate secure file name
			String secureUrl = Security.createSecureFileName() + "." + video.getContainerFormat();
			video.setSurl(secureUrl);
			VideoLocalServiceUtil.updateVideo(video);
			
			String vidSPreffix = video.getSPreffix();
			// then rename all system files
			fJpg.renameTo(new File(PropsUtil.get("lecture2go.images.system.path") + "/" + vidSPreffix + ".jpg"));
			fJpgm.renameTo(new File(PropsUtil.get("lecture2go.images.system.path") + "/" + vidSPreffix + "_m.jpg"));
			fJpgs.renameTo(new File(PropsUtil.get("lecture2go.images.system.path") + "/" + vidSPreffix + "_s.jpg"));
			fPdf.renameTo(new File(path + "/" + vidSPreffix + ".pdf"));
			fMp3.renameTo(new File(path + "/" + vidSPreffix + ".mp3"));
			fM4v.renameTo(new File(path + "/" + vidSPreffix + ".m4v"));
			fMp4.renameTo(new File(path + "/" + vidSPreffix + ".mp4"));
			fM4a.renameTo(new File(path + "/" + vidSPreffix + ".m4a"));
			fOgg.renameTo(new File(path + "/" + vidSPreffix + ".ogg"));
			fFlv.renameTo(new File(path + "/" + vidSPreffix + ".flv"));
			fWebm.renameTo(new File(path + "/" + vidSPreffix + ".webm"));
		}
		// delete all symbolic links
		File symLinkMp4 = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + video.getPreffix() + ".mp4");
		File symLinkM4v = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + video.getPreffix() + ".m4v");
		File symLinkM4a = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + video.getPreffix() + ".m4a");
		File symLinkMp3 = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + video.getPreffix() + ".mp3");
		symLinkMp4.delete();
		symLinkM4v.delete();
		symLinkM4a.delete();
		symLinkMp3.delete();
		// set RSS
		try {
			generateRSS(video, "mp4");
			generateRSS(video, "mp3");
			generateRSS(video, "m4v");
			generateRSS(video, "m4a");
		} catch (Exception e) {
		}
		// delete video from videohitlist
		VideohitlistLocalServiceUtil.deleteByVideoId(video.getVideoId());
		
		String url = PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/";
		HTACCESS.makeHtaccess(url, VideoLocalServiceUtil.getByProducerAndDownloadLink(producer.getProducerId(), 0));
		
		// refresh last video list
		VideoLocalServiceUtil.createLastVideoList();
		
		// refresh open access for lecture series
		LectureseriesLocalServiceUtil.updateOpenAccess(video, lectureseries); 
	}

	public void deleteThumbnails(Video video) {
		try {
			String videoPreffix = "";
			if (video.getOpenAccess()==1)
				videoPreffix = video.getPreffix();
			else
				videoPreffix = video.getSPreffix();
			File jpgFile = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + ".jpg");
			File jpgmFile = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + "_m.jpg");
			File jpgsFile = new File(PropsUtil.get("lecture2go.images.system.path") + "/" + videoPreffix + "_s.jpg");
			jpgFile.delete();
			jpgmFile.delete();
			jpgsFile.delete();
		} catch (NullPointerException npe) {
		}
	}

	public boolean deleteVideo(Video video) throws PortalException, SystemException{
		Host host = new HostImpl();
		Lectureseries lectureseries = new LectureseriesImpl();
		
		try {
			lectureseries = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
		} catch (SystemException e3) {
			e3.printStackTrace();
		}

		try {
			host = HostLocalServiceUtil.getHost(video.getHostId());
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		Producer producer = new ProducerImpl();
		try {
			producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		Metadata metadata = new MetadataImpl();
		try {
			metadata = MetadataLocalServiceUtil.getMetadata(video.getMetadataId());
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}

		// delete video_lectureseries
		Video_LectureseriesLocalServiceUtil.removeByVideoId(video.getVideoId());
				
		// delete video_institution
		Video_InstitutionLocalServiceUtil.removeByVideoId(video.getVideoId());
				
		// delete all segment images from repository location
		try{
			List<Segment> segmentList = SegmentLocalServiceUtil.getSegmentsByVideoId(video.getVideoId());
			SegmentLocalServiceUtil.deleteThumbhailsFromSegments(segmentList);
		}catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		
		//and all segments
		try {
			SegmentLocalServiceUtil.deleteByVideoId(video.getVideoId());
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		
		LicenseLocalServiceUtil.deleteByVideoId(video.getVideoId());

		//delete upload info
		try {
			UploadLocalServiceUtil.deleteByVideoId(video.getVideoId());
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		// delete video from videohitlist
		try {
			VideohitlistLocalServiceUtil.deleteByVideoId(video.getVideoId());
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		
		// delete meta data which belongs to video 
		try {
			MetadataLocalServiceUtil.deleteMetadata(metadata);
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		// delete video itself
		try {
			VideoLocalServiceUtil.deleteVideo(video);
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		//delete physical files 
		String videoPreffix = "";
		if (video.getOpenAccess()==1) videoPreffix = video.getPreffix();
		else videoPreffix = video.getSPreffix();
		
		try {
			// delete all video contents
			if (video.getFilename() != null) {
				File mp3File = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".mp3");
				File m4aFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".m4a");
				File mp4vFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".m4v");
				File pdfFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".pdf");
				File mp4File = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".mp4");
				File oggFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".ogg");
				File flvFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".flv");
				File webmFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".webm");
				File tarFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".tar");
				mp3File.delete();
				m4aFile.delete();
				mp4vFile.delete();
				pdfFile.delete();
				mp4File.delete();
				tarFile.delete();
				oggFile.delete();
				flvFile.delete();
				webmFile.delete();
				deleteThumbnails(video);
			}
			// delete all symbolic links
			File symLinkMp4 = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".mp4");
			File symLinkM4v = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".m4v");
			File symLinkM4a = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".m4a");
			File symLinkMp3 = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".mp3");
			File symLinkJpg = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".jpg");
			File symLinkOgg = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".ogg");
			File symLinkFlv = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".flv");
			File symLinkWebm = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".webm");
			symLinkMp4.delete();
			symLinkM4v.delete();
			symLinkM4a.delete();
			symLinkMp3.delete();
			symLinkJpg.delete();
			symLinkOgg.delete();
			symLinkFlv.delete();
			symLinkWebm.delete();
		} catch (NullPointerException npe) {}
		
		// update RSS
		try {
			generateRSS(video, "mp4");
			generateRSS(video, "mp3");
			generateRSS(video, "m4v");
			generateRSS(video, "m4a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// update last video list
		LastvideolistLocalServiceUtil.deleteByVideoId(video.getVideoId());
		
		// update uploads for producer
		int n = 0;
		try {
			n = VideoLocalServiceUtil.getByProducer(producer.getProducerId()).size();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		producer.setNumberOfProductions(n);
		try {
			ProducerLocalServiceUtil.updateProducer(producer);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		//Update htaccess
		String url = PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/";
		try {
			HTACCESS.makeHtaccess(url, VideoLocalServiceUtil.getByProducerAndDownloadLink(producer.getProducerId(), 0));
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		// refresh open access for lecture series
		LectureseriesLocalServiceUtil.updateOpenAccess(video, lectureseries); 
		
		return true;
	}
	
	public boolean deleteFilesImagesFromVideo(Video video){
		Host host = new HostImpl();
		try {
			host = HostLocalServiceUtil.getHost(video.getHostId());
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		Producer producer = new ProducerImpl();
		try {
			producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		
		// delete all segments and images from repository location
		try{
			List<Segment> segmentList = SegmentLocalServiceUtil.getSegmentsByVideoId(video.getVideoId());
			SegmentLocalServiceUtil.deleteThumbhailsFromSegments(segmentList);
			
		}catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		//and all segments
		try {
			SegmentLocalServiceUtil.deleteByVideoId(video.getVideoId());
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		
		//delete physical files 
		String videoPreffix = "";
		if (video.getOpenAccess()==1) videoPreffix = video.getPreffix();
		else videoPreffix = video.getSPreffix();
		
		try {
			// delete all video contents
			if (video.getFilename() != null) {
				File mp3File = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".mp3");
				File m4aFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".m4a");
				File mp4vFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".m4v");
				File pdfFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".pdf");
				File mp4File = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".mp4");
				File oggFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".ogg");
				File flvFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".flv");
				File webmFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".webm");
				File tarFile = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/" + videoPreffix + ".tar");
				mp3File.delete();
				m4aFile.delete();
				mp4vFile.delete();
				pdfFile.delete();
				mp4File.delete();
				tarFile.delete();
				oggFile.delete();
				flvFile.delete();
				webmFile.delete();
				deleteThumbnails(video);
			}
			
			// delete all symbolic links
			File symLinkMp4 = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".mp4");
			File symLinkM4v = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".m4v");
			File symLinkM4a = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".m4a");
			File symLinkMp3 = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".mp3");
			File symLinkJpg = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".jpg");
			File symLinkOgg = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".ogg");
			File symLinkFlv = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".flv");
			File symLinkWebm = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo" + "/" + videoPreffix + ".webm");
			symLinkMp4.delete();
			symLinkM4v.delete();
			symLinkM4a.delete();
			symLinkMp3.delete();
			symLinkJpg.delete();
			symLinkOgg.delete();
			symLinkFlv.delete();
			symLinkWebm.delete();
		} catch (NullPointerException npe) {}
		
		// update RSS
		try {
			generateRSS(video, "mp4");
			generateRSS(video, "mp3");
			generateRSS(video, "m4v");
			generateRSS(video, "m4a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Update htaccess
		String url = PropsUtil.get("lecture2go.media.repository") + "/" + host.getName() + "/" + producer.getHomeDir() + "/";
		try {
			HTACCESS.makeHtaccess(url, VideoLocalServiceUtil.getByProducerAndDownloadLink(producer.getProducerId(), 0));
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		// set empty parameter to video itself
		try {
			video.setFilename("");
			video.setContainerFormat("");
			video.setDate("");
			video.setGenerationDate("");
			video.setSurl(Security.createSecureFileName()+".xx");
			video.setUploadDate(null);
			video.setDownloadLink(0);
			video.setOpenAccess(0);
			video.setResolution("");
			video.setDuration("");
			video.setFileSize("");
			VideoLocalServiceUtil.updateVideo(video);
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		return true;
	}

	public void generateRSS(Video video, String type) throws PortalException, SystemException {
		// RSS generate for this lecture
		RSSManager rssMan = new RSSManager();
		String feedName = "";
		rssMan.setTitle(LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId()).getName());
		try {
			List<Video> videoList = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(video.getLectureseriesId(), 1);
			
			if (type.equals("mp4")) feedName = "" + video.getLectureseriesId() + ".mp4.xml";
			if (type.equals("mp3")) feedName = "" + video.getLectureseriesId() + ".mp3.xml";
			if (type.equals("m4a"))	feedName = "" + video.getLectureseriesId() + ".m4a.xml";
			if (type.equals("m4v"))	feedName = "" + video.getLectureseriesId() + ".m4v.xml";
			rssMan.setRssFilename(feedName);
			
			if (type.equals("mp4"))	rssMan.createRssFile(videoList, "mp4");
			if (type.equals("mp3")) rssMan.createRssFile(videoList, "mp3");
			if (type.equals("m4a"))	rssMan.createRssFile(videoList, "m4a");
			if (type.equals("m4v"))	rssMan.createRssFile(videoList, "m4v");
		} catch (Exception e) {
			try {
				if (type.equals("mp4"))	rssMan.createRssFile(null, "mp4");
				if (type.equals("mp3"))	rssMan.createRssFile(null, "mp3");
				if (type.equals("m4a"))	rssMan.createRssFile(null, "m4a");
				if (type.equals("m4v"))	rssMan.createRssFile(null, "m4v");
			} catch (IOException ie) {
			}
		}
		// RSS end
	}

	private void timeout() {
		double a = 0;
		for (int i = 0; i <= 10000000; i++) {
			a++;
			a = Math.exp(a);
		}
	}

	public void addNewMediaDirectoryForProducer(Host host, Producer producer) throws IOException {
		File folder = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir() + "/");
		if (!folder.exists()) {
			if (folder.mkdir()) {
				Runtime runtime = Runtime.getRuntime();
				String[] cmdArray = { PropsUtil.get("lecture2go.shell.bin"), "-c", "chown nobody " + folder.getAbsolutePath() };
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
}