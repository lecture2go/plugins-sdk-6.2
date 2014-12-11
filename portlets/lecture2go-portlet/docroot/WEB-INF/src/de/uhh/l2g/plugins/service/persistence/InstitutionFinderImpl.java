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

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;

public class InstitutionFinderImpl extends BasePersistenceImpl<Institution> implements InstitutionFinder {

	public static final String FIND_ALL_SORTED_AS_TREE = InstitutionFinder.class.getName() + ".findAllSortedAsTree";
	public static final String FIND_FROM_LECTURESERIES = InstitutionFinder.class.getName() + ".findByLectureseriesId";
	
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
