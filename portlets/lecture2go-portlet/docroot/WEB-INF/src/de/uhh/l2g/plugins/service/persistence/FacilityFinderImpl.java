package de.uhh.l2g.plugins.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Facility;
import de.uhh.l2g.plugins.model.impl.FacilityImpl;

public class FacilityFinderImpl extends BasePersistenceImpl<Facility> implements FacilityFinder {

	public static final String FIND_ALL_SORTED_AS_TREE = FacilityFinder.class.getName() + ".findAllSortedAsTree";
	public static final String FIND_FROM_LECTURESERIES = FacilityFinder.class.getName() + ".findByLectureseriesId";

	public List<Facility> findByLectureseriesId(long lectureseriesId, int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_FROM_LECTURESERIES);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("facilityId", Type.LONG);
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
			return assembleFacilities(fl);
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

	public List<Facility> findAllSortedAsTree(int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_SORTED_AS_TREE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("facilityId", Type.LONG);
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
			return assembleFacilitiesWithPath(fl);
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
	
	private List<Facility> assembleFacilitiesWithPath(List<Object[]> objectList){
		List<Facility> fl = new ArrayList<Facility>();
		for (Object[] facility: objectList){
			FacilityImpl f = new FacilityImpl();
			f.setFacilityId((Long) facility[0]);
			f.setParentId((Integer) facility[1]);
			f.setName((String) facility[2]);
			f.setTyp((String) facility[3]);
			f.setWww((String) facility[4]);
			f.setLevel((Integer) facility[5]);
			f.setSort((Integer) facility[6]);
			String s = (String) facility[7];
			f.setPath(s);
			fl.add(f);
		}
		return fl;
	}

	private List<Facility> assembleFacilities(List<Object[]> objectList){
		List<Facility> fl = new ArrayList<Facility>();
		for (Object[] facility: objectList){
			FacilityImpl f = new FacilityImpl();
			f.setFacilityId((Long) facility[0]);
			f.setParentId((Integer) facility[1]);
			f.setName((String) facility[2]);
			f.setTyp((String) facility[3]);
			f.setWww((String) facility[4]);
			f.setLevel((Integer) facility[5]);
			f.setSort((Integer) facility[6]);
			fl.add(f);
		}
		return fl;
	}

}
