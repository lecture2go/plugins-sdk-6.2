package de.uhh.l2g.plugins.service.persistence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.util.VideoGenerationDateComparator;

public class VideoFinderImpl extends BasePersistenceImpl<Video> implements VideoFinder {

	public static final String RESET_LECTURESERIES_FOR_VIDEOS = VideoFinder.class.getName() + ".resetLectureseriesForVideos";
	public static final String FIND_LATES_OPEN_ACCESS_VIDEO_FOR_LECTURESERIES = VideoFinder.class.getName() + ".findLatestOpenAccessVideoForlectureseries";
	public static final String FIND_VIDEO_FOR_SECURE_URL = VideoFinder.class.getName() + ".findVideoForSecureUrl";
	public static final String FIND_VIDEOS_BY_SEARCH_WORD = VideoFinder.class.getName() + ".findVideosBySearchWord";
	public static final String FIND_VIDEOS_BY_SEARCH_WORD_AND_LECTURESERIESID = VideoFinder.class.getName() + ".findVideosBySearchWordAndLectureseriesId";

	public List<Video> findVideosBySearchWord(String word, int limit) {
		word="%"+word+"%";
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEOS_BY_SEARCH_WORD);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("title", Type.STRING);
			//custom fields
			q.addScalar("lectureseriesName", Type.STRING);
			q.addScalar("lectureseriesNumber", Type.STRING);
			q.addScalar("creatorFullName", Type.STRING);
			
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(word);
			qPos.add(word);
			qPos.add(word);
			qPos.add(word);
			qPos.add(word);
			
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(), 0 , limit);
			return assembleVideosSearchWord(l);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Video> findVideosBySearchWordAndLectureseriesId(String word, long lectureseriesId) {
		word="%"+word+"%";
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEOS_BY_SEARCH_WORD_AND_LECTURESERIESID);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("videoId", Type.LONG);
			q.addScalar("title", Type.STRING);
			q.addScalar("lectureseriesId", Type.LONG);
			q.addScalar("producerId", Type.LONG);
			q.addScalar("containerFormat", Type.STRING);
			q.addScalar("filename", Type.STRING);
			q.addScalar("resolution", Type.STRING);
			q.addScalar("duration", Type.STRING);
			q.addScalar("hostId", Type.LONG);
			q.addScalar("fileSize", Type.STRING);
			q.addScalar("generationDate", Type.STRING);
			q.addScalar("openAccess", Type.INTEGER);
			q.addScalar("downloadLink", Type.INTEGER);
			q.addScalar("metadataId", Type.LONG);
			q.addScalar("secureFilename", Type.STRING);
			q.addScalar("hits", Type.INTEGER);
			q.addScalar("uploadDate", Type.STRING);
			q.addScalar("permittedToSegment", Type.INTEGER);
			q.addScalar("rootInstitutionId", Type.LONG);
			q.addScalar("citation2go", Type.INTEGER);
			q.addScalar("termId", Type.LONG);
			q.addScalar("tags", Type.STRING);
			q.addScalar("password_", Type.STRING);
			
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(word);
			qPos.add(lectureseriesId);
			
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleVideos(l);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public int unlinkLectureseriesFromVideos(Long lectureseriesId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(RESET_LECTURESERIES_FOR_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("videoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			return q.executeUpdate();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public Video findVideoBySerureUrl(String surl) {
		Session session = null;
		Video video = new VideoImpl();
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEO_FOR_SECURE_URL);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("videoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(surl+"%");
			@SuppressWarnings("unchecked")
			List <Long> vl =  (List<Long>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			video = VideoLocalServiceUtil.getVideo(vl.get(0));
			return video;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return video;
	}
	
	public Video findLatestOpenAccessVideoForLectureseries(Long lectureseriesId) {
		Session session = null;
		Video video = new VideoImpl();
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_LATES_OPEN_ACCESS_VIDEO_FOR_LECTURESERIES);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("videoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			qPos.add(lectureseriesId);
			@SuppressWarnings("unchecked")
			List <Long> vl =  (List<Long>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			video = VideoLocalServiceUtil.getVideo(vl.get(0));
			return video;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return video;
	}
	
	private List<Video> assembleVideos(List<Object[]> objectList){
		List<Video> vl = new ArrayList<Video>();
		for (Object[] video: objectList){
			VideoImpl v = new VideoImpl();
			v.setVideoId((Long)video[0]);
			v.setTitle((String)video[1]);
			v.setLectureseriesId((Long)video[2]);
			v.setProducerId((Long)video[3]);
			v.setContainerFormat((String)video[4]);
			v.setFilename((String)video[5]);
			v.setResolution((String)video[6]);
			v.setDuration((String)video[7]);
			v.setHostId((Long)video[8]);
			v.setFileSize((String)video[9]);
			v.setGenerationDate((String)video[10]);
			v.setOpenAccess((Integer)video[11]);
			v.setDownloadLink((Integer)video[12]);
			v.setMetadataId((Long)video[13]);
			v.setSecureFilename((String)video[14]);
			v.setHits((Integer)video[15]);
			//parse date
			DateFormat formatter ;
			Date date = new Date();
			formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			try {
				String s = (video[16])+"";
				date = (Date) formatter.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}			
			//
			v.setUploadDate(date);
			v.setPermittedToSegment((Integer)video[17]);
			v.setRootInstitutionId((Long)video[18]);
			v.setCitation2go((Integer)video[19]);
			v.setTermId((Long)video[20]);
			v.setTags((String)video[21]);
			v.setPassword((String)video[22]);
			
			vl.add(v);
		}
		return vl;
	}
	
	private List<Video> assembleVideosSearchWord(List<Object[]> objectList){
		List<Video> vl = new ArrayList<Video>();
		for (Object[] video: objectList){
			VideoImpl v = new VideoImpl();
			v.setTitle((String)video[0]);
			v.setLectureseriesName((String)video[1]);
			v.setLectureseriesNumber((String)video[2]);
			v.setCreatorFullName((String)video[3]);
			
			vl.add(v);
		}
		return vl;
	}
	
	public List<Video> findLatestVideos(){
		List<Lectureseries> ll = new ArrayList<Lectureseries>();
		ll = LectureseriesLocalServiceUtil.getAllLectureseriesWhithOpenaccessVideos();
		List<Video> vl = new ArrayList<Video>();
		Iterator<Lectureseries> it = ll.iterator();
		while (it.hasNext()){
			Lectureseries l = (Lectureseries) it.next();
			Video v = findLatestOpenAccessVideoForLectureseries(l.getLectureseriesId());
			vl.add(v);
		}
		Comparator<Video> comparator = new VideoGenerationDateComparator();
		java.util.Collections.sort(vl, comparator);		
		return vl;
	}
}
