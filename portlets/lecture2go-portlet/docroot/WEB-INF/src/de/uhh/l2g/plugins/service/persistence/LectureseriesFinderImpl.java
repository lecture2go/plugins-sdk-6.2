package de.uhh.l2g.plugins.service.persistence;

import java.util.ArrayList;
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
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;

public class LectureseriesFinderImpl extends BasePersistenceImpl<Lectureseries> implements LectureseriesFinder {

	public static final String FIND_ALL_SEMESTERS = LectureseriesFinder.class.getName() + ".findAllSemesters";
	public static final String FIND_ALL_LECTURESERIES_WITH_OPENACCESS_VIDEOS = LectureseriesFinder.class.getName() + ".findAllLectureseriesWithOpenAccessVideos";
	public static final String FIND_ALL_LECTURESERIES_WITH_PASSWORD = LectureseriesFinder.class.getName() + ".findAllLectureseriesWithPassword";
	public static final String FIND_ALL_LECTURESERIES_FOR_VIDEO = LectureseriesFinder.class.getName() + ".findAllLectureseriesForVideo";
	
	public List<Lectureseries> findAllLectureseriesWhithPassword(){
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_LECTURESERIES_WITH_PASSWORD);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("number_", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("categoryId", Type.LONG);
			q.addScalar("name", Type.STRING);
			q.addScalar("shortDesc", Type.STRING);
			q.addScalar("termId", Type.LONG);
			q.addScalar("language", Type.STRING);
			q.addScalar("facultyName", Type.STRING);
			q.addScalar("lectureseriesId", Type.STRING);
			q.addScalar("password_", Type.STRING);
			q.addScalar("approved", Type.STRING);
			q.addScalar("longDesc", Type.STRING);
			q.addScalar("latestOpenAccessVideoId", Type.LONG);
			q.setCacheable(false);			
			@SuppressWarnings("unchecked")
			List <Object[]> ls =  (List <Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleLectureseries(ls);
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
	
	public List<Lectureseries> findAllLectureseriesForVideo(Video video){
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_LECTURESERIES_FOR_VIDEO);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("number_", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("categoryId", Type.LONG);
			q.addScalar("name", Type.STRING);
			q.addScalar("shortDesc", Type.STRING);
			q.addScalar("termId", Type.LONG);
			q.addScalar("language", Type.STRING);
			q.addScalar("facultyName", Type.STRING);
			q.addScalar("lectureseriesId", Type.STRING);
			q.addScalar("password_", Type.STRING);
			q.addScalar("approved", Type.STRING);
			q.addScalar("longDesc", Type.STRING);
			q.addScalar("latestOpenAccessVideoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(video.getVideoId());
			q.setCacheable(false);	
			@SuppressWarnings("unchecked")
			List <Object[]> ls =  (List <Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleLectureseries(ls);
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
	
	public List<Lectureseries> findAllLectureseriesWhithOpenaccessVideos(){
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_LECTURESERIES_WITH_OPENACCESS_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("number_", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("categoryId", Type.LONG);
			q.addScalar("name", Type.STRING);
			q.addScalar("shortDesc", Type.STRING);
			q.addScalar("termId", Type.LONG);
			q.addScalar("language", Type.STRING);
			q.addScalar("facultyName", Type.STRING);
			q.addScalar("lectureseriesId", Type.STRING);
			q.addScalar("password_", Type.STRING);
			q.addScalar("approved", Type.STRING);
			q.addScalar("longDesc", Type.STRING);
			q.addScalar("latestOpenAccessVideoId", Type.LONG);
			q.setCacheable(false);			
			@SuppressWarnings("unchecked")
			List <Object[]> ls =  (List <Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleLectureseries(ls);
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
	
	/**
	 * Queries the database for data by single filter id's
	 * @param institutionId
	 * @param parentInstitutionId
	 * @param termId
	 * @param categoryId
	 * @param creatorId
	 * @return a list with lectureseries which fit to the given filters
	 */
	public List<Lectureseries> findFilteredByInstitutionParentInstitutionTermCategoryCreator(Long institutionId, Long parentInstitutionId, Long termId, Long categoryId, long creatorId) {
		ArrayList<Long> termIds = new ArrayList<Long>();
		ArrayList<Long> categoryIds = new ArrayList<Long>();
		ArrayList<Long> creatorIds = new ArrayList<Long>();
		if (termId != 0) {
			termIds.add(termId);
		}
		if (categoryId != 0) {
			categoryIds.add(categoryId);
		}
		if (creatorId != 0) {
			creatorIds.add(creatorId);
		}

		return findFilteredByInstitutionParentInstitutionTermCategoryCreator(institutionId,parentInstitutionId,termIds,categoryIds,creatorIds);
	}
	
	public List<Lectureseries> findFilteredByInstitutionParentInstitutionTermCategoryCreator(Long institutionId, Long parentInstitutionId, ArrayList<Long> termIds, ArrayList<Long> categoryIds, ArrayList<Long> creatorIds) {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlFilterForOpenAccessLectureseries(institutionId, parentInstitutionId, termIds, categoryIds, creatorIds);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("number_", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("categoryId", Type.LONG);
			q.addScalar("name", Type.STRING);
			q.addScalar("shortDesc", Type.STRING);
			q.addScalar("termId", Type.LONG);
			q.addScalar("language", Type.STRING);
			q.addScalar("facultyName", Type.STRING);
			q.addScalar("lectureseriesId", Type.STRING);
			q.addScalar("password_", Type.STRING);
			q.addScalar("approved", Type.STRING);
			q.addScalar("longDesc", Type.STRING);
			q.addScalar("latestOpenAccessVideoId", Type.LONG);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleLectureseries(l);
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
	
	private String sqlFilterForOpenAccessLectureseries(Long institutionId, Long institutionParentId, ArrayList<Long> termIds, List<Long> categoryIds, ArrayList<Long> creatorIds) {
		// build query
		
		String lQuery = "SELECT l.number_, l.eventType, l.categoryId, l.name, l.shortDesc, l.termId, l.language, l.facultyName, l.lectureseriesId, l.password_, l.approved, l.longDesc, l.latestOpenAccessVideoId, l.latestVideoUploadDate FROM LG_Lectureseries AS l ";
		String vQuery = "SELECT \"00.000\" AS number_, NULL AS eventType, 0 AS categoryId, v.title AS name, v.title AS shortDesc, v.termId, \"\" AS language, \"\" AS facultyName, v.videoId AS lectureseriesId, NULL AS password_, 1 AS approved, v.title AS longDesc, v.lectureseriesId AS latestOpenAccessVideoId, v.uploadDate AS latestVideoUploadDate FROM LG_Video v ";

		String query = "";

		if (institutionId > 0 || institutionParentId > 0) {
			lQuery += "INNER JOIN LG_Lectureseries_Institution AS li ON ( l.lectureseriesId = li.lectureseriesId ) ";
			vQuery += "INNER JOIN LG_Video_Institution AS vi ON ( v.videoId = vi.videoId ) ";
		}

		if (termIds.size() > 0) {
			lQuery += "INNER JOIN LG_Term AS t ON ( l.termId = t.termId ) ";
			vQuery += "INNER JOIN LG_Term AS t ON ( v.termId = t.termId ) ";
		}
		
		if (creatorIds.size() > 0) {
			lQuery += "INNER JOIN LG_Lectureseries_Creator AS lc ON ( l.lectureseriesId = lc.lectureseriesId ) ";
			vQuery += "INNER JOIN LG_Video_Creator AS vc ON ( v.videoId = vc.videoId ) ";
		}
		
		if (categoryIds.size() > 0) {
			vQuery += "INNER JOIN LG_Video_Category AS vcat ON ( v.videoId = vcat.videoId ) ";
		}
		
		lQuery += "WHERE l.latestOpenAccessVideoId>0 ";
		vQuery += "WHERE v.lectureseriesId<0 ";
		
		if (institutionId > 0 || institutionParentId > 0 || termIds.size() > 0 || categoryIds.size() > 0 || creatorIds.size() > 0) {
			int i = 0;
			if (termIds.size() > 0) {
				lQuery += "AND ";
				vQuery += "AND ";
				ListIterator<Long> it = termIds.listIterator();
				lQuery += "( ";
				vQuery += "( ";
				while(it.hasNext()){
					Long termId = it.next();
					if(it.hasNext()){
						lQuery += "t.termId="+termId+" OR ";
						vQuery += "t.termId="+termId+" OR ";
					}
					else{
						lQuery += "t.termId="+termId+" ) ";
						vQuery += "t.termId="+termId+" ) ";
					}
				}
				i++;
			}

			if (creatorIds.size() > 0) {
//				lQuery += i > 0 ? "AND " : "";
//				vQuery += i > 0 ? "AND " : "";
				lQuery += "AND ";
				vQuery += "AND ";
				lQuery += "( ";
				vQuery += "( ";
				for(int j=0;j<creatorIds.size();j++){
				Long creatorId = creatorIds.get(j);
					if(j<(creatorIds.size()-1)){
						lQuery += "lc.creatorId="+creatorId+" OR ";
						vQuery += "vc.creatorId="+creatorId+" OR ";
					}
					else{
						lQuery += "lc.creatorId="+creatorId+" ) ";
						vQuery += "vc.creatorId="+creatorId+" ) ";
					}
				}
				i++;				
			}
			
			if (categoryIds.size() > 0) {
//				lQuery += i > 0 ? "AND " : "";
//				vQuery += i > 0 ? "AND " : "";
				lQuery += "AND ";
				vQuery += "AND ";
				ListIterator<Long> it = categoryIds.listIterator();
				lQuery += "( ";
				vQuery += "( ";
				while(it.hasNext()){
					Long categoryId = it.next();
					if(it.hasNext()){
						lQuery += "l.categoryId = "+categoryId + " OR ";
						vQuery += "vcat.categoryId = "+categoryId + " OR ";
					}
					else{
						lQuery += "l.categoryId="+categoryId+" ) ";
						vQuery += "vcat.categoryId="+categoryId+" ) ";
					}
				}
				i++;				
			}

			if (institutionId > 0) {
//				lQuery += i > 0 ? "AND " : "";
//				vQuery += i > 0 ? "AND " : "";
				lQuery += "AND ";
				vQuery += "AND ";
				lQuery += "li.institutionId = "+institutionId + " ";
				vQuery += "vi.institutionId = "+institutionId + " ";
				i++;
			}

			if (institutionParentId > 0) {
//				lQuery += i > 0 ? "AND " : "";
//				vQuery += i > 0 ? "AND " : "";
				lQuery += "AND ";
				vQuery += "AND ";
				lQuery += "li.institutionParentId = "+institutionParentId + " ";
				vQuery += "vi.institutionParentId = "+institutionParentId + " ";
				i++;
			}

		}

		query = "SELECT * FROM ( ";
		query+= lQuery;
		query+= "UNION "; 
		query+= vQuery;
		query+= ") ";
		query+= "AS a ";
		query+= "ORDER BY a.latestVideoUploadDate";	
		
	    return query;
	}

	public List<Lectureseries> findFilteredByApprovedSemesterFacultyProducer(Integer approved, Long termId, Long facultyId, Long producerId) {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlFilterForLectureseries(approved, termId, facultyId, producerId);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("number_", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("categoryId", Type.LONG);
			q.addScalar("name", Type.STRING);
			q.addScalar("shortDesc", Type.STRING);
			q.addScalar("termId", Type.LONG);
			q.addScalar("language", Type.STRING);
			q.addScalar("facultyName", Type.STRING);
			q.addScalar("lectureseriesId", Type.STRING);
			q.addScalar("password_", Type.STRING);
			q.addScalar("approved", Type.STRING);
			q.addScalar("longDesc", Type.STRING);
			q.addScalar("latestOpenAccessVideoId", Type.LONG);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleLectureseries(l);
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
	
	private List<Lectureseries> assembleLectureseries(List<Object[]> objectList){
		List<Lectureseries> ll = new ArrayList<Lectureseries>();
		for (Object[] lectser: objectList){
			LectureseriesImpl l = new LectureseriesImpl();
			l.setNumber((String) lectser[0]);
			l.setEventType((String) lectser[1]);
			l.setCategoryId((Long) lectser[2]);
			l.setName((String) lectser[3]);
			l.setShortDesc((String) lectser[4]);
			l.setTermId((Long) lectser[5]);
			l.setLanguage((String) lectser[6]);
			l.setFacultyName((String) lectser[7]);
			l.setLectureseriesId(new Long((String) lectser[8]));
			l.setPassword((String) lectser[9]);
			l.setApproved(new Integer((String) lectser[10]));
			l.setLongDesc((String) lectser[11]);
			l.setLatestOpenAccessVideoId((Long) lectser[12]);
			ll.add(l);
		}
		return ll;
	}
	
	private String sqlFilterForLectureseries(Integer approved, Long termId, Long facultyId, Long producerId) {
		// build query
		String query = "SELECT c.number_, c.eventType, c.categoryId, c.name, c.shortDesc, c.longDesc, c.termId, c.language, c.facultyName, c.lectureseriesId, c.password_, c.approved, c.longDesc, c.latestOpenAccessVideoId ";
			   query += "FROM LG_Lectureseries AS c ";

		if (facultyId > 0) {
			query += "INNER JOIN LG_Lectureseries_Institution AS ce ON ( c.lectureseriesId = ce.lectureseriesId ) ";
			query += "INNER JOIN LG_Institution AS e ON ( ce.institutionId = e.institutionId ) ";
		}

		if (producerId > 0) {
			query += "INNER JOIN LG_Producer_Lectureseries AS pc ON ( c.lectureseriesId = pc.lectureseriesId ) ";
			query += "INNER JOIN LG_Producer AS p ON ( pc.producerId = p.producerId ) ";
		}

		if (termId>0 || (approved==1 || approved==0) || facultyId > 0 || producerId > 0) {
			query += "WHERE ";
			int i = 0;
			if (termId > 0) {
				query += "c.termId = \""+termId + "\" ";
				i++;
			}

			if (approved==1 || approved==0) {
				query += i > 0 ? "AND " : "";
				query += "c.approved = "+approved + " ";
				i++;
			}

			if (facultyId > 0) {
				query += i > 0 ? "AND " : "";
				query += "ce.institutionId IN ";
				query += "(select institutionId from LG_Institution AS ein WHERE ein.parentId = "+facultyId+" OR ein.institutionId = "+facultyId+") ";
				i++;
			}

			if (producerId > 0) {
				query += i > 0 ? "AND " : "";
				query += "pc.producerId = "+producerId + " ";
				i++;
			}
		}
		query += "GROUP BY c.lectureseriesId ";
		query += "ORDER BY c.name ASC ";

		return query;
	}
}
