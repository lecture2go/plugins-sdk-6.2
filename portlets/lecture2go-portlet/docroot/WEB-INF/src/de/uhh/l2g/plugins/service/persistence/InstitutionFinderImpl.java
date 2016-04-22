package de.uhh.l2g.plugins.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;

public class InstitutionFinderImpl extends BasePersistenceImpl<Institution> implements InstitutionFinder {

	public static final String FIND_ALL_SORTED_AS_TREE = InstitutionFinder.class.getName() + ".findAllSortedAsTree";
	public static final String FIND_FROM_LECTURESERIES = InstitutionFinder.class.getName() + ".findByLectureseriesId";
	public static final String FIND_MAX_SORT_BY_PARENT = InstitutionFinder.class.getName() + ".findMaxSortByParent";
	public static final String FIND_LOCKING_ELEMENTS = InstitutionFinder.class.getName() + ".findLockingElements";
	public static final String FIND_ROOT_INSTITUTIONS_BY_OPEN_ACCESS_VIDEOS = InstitutionFinder.class.getName() + ".findRootInstitutionsByOpenAccessVideos";
	
	public List<Institution> findRootInstitutionsByOpenAccessVideos() {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ROOT_INSTITUTIONS_BY_OPEN_ACCESS_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.addScalar("path", Type.STRING);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleInstitutionsWithPath(fl);
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
	
	public List<Institution> findByLectureseriesId(long lectureseriesId, int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_FROM_LECTURESERIES);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), begin, end);
			return assembleInstitutions(fl);
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

	public List<Institution> findAllSortedAsTree(int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_SORTED_AS_TREE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.addScalar("path", Type.STRING);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), begin, end);
			return assembleInstitutionsWithPath(fl);
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

	public int findMaxSortByParent(long parentId) {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_MAX_SORT_BY_PARENT);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("maxsort", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(parentId);
			Iterator<?> itr = q.list().iterator();

	        if (itr.hasNext()) {
	          Integer count = (Integer)itr.next();

	          if (count != null) {
	            return count.intValue();
	          }
	        }

	        return out;
	      } catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}

	public int findLockingElements(long institutionId) {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_LOCKING_ELEMENTS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("countElements", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(institutionId);
			Iterator<?> itr = q.list().iterator();

	        if (itr.hasNext()) {
	          Integer count = (Integer)itr.next();

	          if (count != null) {
	            return count.intValue();
	          }
	        }

	        return out;
	      } catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}


	public List<Institution> findInstitutionsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds,  ArrayList<Long> videoIds, Long parentId)  {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlInstitutionsByLectureseriesIdsAndVideoIds(lectureseriesIds,videoIds,parentId);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleInstitutions(fl);
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

	private String sqlInstitutionsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds, Long parentId) {
		boolean hasLectureseries 	= !lectureseriesIds.isEmpty();
		boolean hasVideos 			= !videoIds.isEmpty();
		boolean institutionsWanted	= parentId >0;
		// the query fetches the parentinstitutions or the child institutions depending on the given parentId
		String institutionQuery = institutionsWanted ? "institutionId" : "institutionParentId";
		String lquery = "";
		String vquery = "";

		if (hasLectureseries) {
			// convert the list of ids to a comma-seperated string for the sql query
			String lectureseriesIdsQuery = StringUtils.join(lectureseriesIds, ',');
			lquery = "SELECT " + institutionQuery + " FROM LG_Lectureseries_Institution WHERE lectureseriesId IN (" + lectureseriesIdsQuery + ")";
		}
		if (hasVideos) {
			// convert the list of ids to a comma-seperated string for the sql query
			String videoIdsQuery = StringUtils.join(videoIds, ',');
			vquery = "SELECT " + institutionQuery + " FROM LG_Video_Institution WHERE videoId IN (" + videoIdsQuery + ")";
		}

		String query =  "SELECT DISTINCT i.institutionId,i.parentId,i.name,i.typ,i.www,i.level,i.sort FROM (";

		if (hasLectureseries && hasVideos) {
			query += lquery + " UNION " + vquery;
 		} else if (hasLectureseries) {
			query += lquery;
		} else if (hasVideos) {
			query += vquery;
		}
		else { ////surpress sql error on empty lists 
			query += "SELECT " + institutionQuery + " FROM LG_Video_Institution WHERE videoId IN (0)";
		}

		query += ") AS a JOIN LG_Institution AS i ON a." + institutionQuery + " = i.institutionId";

		if (institutionsWanted) {
			query += " WHERE i.parentId = " + parentId.toString();
		}
		
		query += " ORDER BY sort";

		return query;
	}


	private List<Institution> assembleInstitutionsWithPath(List<Object[]> objectList){
		List<Institution> fl = new ArrayList<Institution>();
		for (Object[] institution: objectList){
			InstitutionImpl f = new InstitutionImpl();
			f.setInstitutionId((Long) institution[0]);
			f.setParentId((Integer) institution[1]);
			f.setName((String) institution[2]);
			f.setTyp((String) institution[3]);
			f.setWww((String) institution[4]);
			f.setLevel((Integer) institution[5]);
			f.setSort((Integer) institution[6]);
			String s = (String) institution[7];
			f.setPath(s);
			fl.add(f);
		}
		return fl;
	}

	private List<Institution> assembleInstitutions(List<Object[]> objectList){
		List<Institution> fl = new ArrayList<Institution>();
		for (Object[] institution: objectList){
			InstitutionImpl f = new InstitutionImpl();
			f.setInstitutionId((Long) institution[0]);
			f.setParentId((Integer) institution[1]);
			f.setName((String) institution[2]);
			f.setTyp((String) institution[3]);
			f.setWww((String) institution[4]);
			f.setLevel((Integer) institution[5]);
			f.setSort((Integer) institution[6]);
			fl.add(f);
		}
		return fl;
	}

}
