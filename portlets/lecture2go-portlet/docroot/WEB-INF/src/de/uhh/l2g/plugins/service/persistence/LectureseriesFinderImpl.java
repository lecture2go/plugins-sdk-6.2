package de.uhh.l2g.plugins.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Lectureseries;

public class LectureseriesFinderImpl extends BasePersistenceImpl<Lectureseries> implements LectureseriesFinder {

	public static final String FIND_ALL_SEMESTERS = LectureseriesFinder.class.getName() + ".findAllSemesters";

	public List<String> findAllSemesters(int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_SEMESTERS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("semesterName", Type.STRING);
			q.setCacheable(false);
			List <String> sl =  (List<String>) QueryUtil.list(q, getDialect(), begin, end);
			return sl;
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

	public List<String> findeFilteredBy(String approved, String semester, int facultyId, int producerId, int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlFilterForLectureseries(approved, semester, facultyId, producerId);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("semesterName", Type.STRING);
			q.setCacheable(false);
			List <String> sl =  (List<String>) QueryUtil.list(q, getDialect(), begin, end);
			return sl;
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
	
	private String sqlFilterForLectureseries(String approved, String semester, int facultyId, int producerId) {
		// build query
		String query = "SELECT c.number, c.eventType, c.eventCategory, c.name, c.shortDesc, c.longDesc, c.semesterName, c.language, c.facultyName, c.instructorsString, c.id, c.password, c.approved FROM lectureseries AS c ";

		if (facultyId > 0) {
			query += "INNER JOIN lectureseries_facility AS ce ON ( c.id = ce.lectureseriesId ) ";
			query += "INNER JOIN facility AS e ON ( ce.facilityId = e.id ) ";
		}

		if (producerId > 0) {
			query += "INNER JOIN producer_lectureseries AS pc ON ( c.id = pc.lectureseriesId ) ";
			query += "INNER JOIN producer AS p ON ( pc.producerId = p.id ) ";
		}

		if ((!"".equals(semester) && semester != null) || ("true".equals(approved) || "false".equals(approved)) || facultyId > 0 || producerId > 0) {
			query += "WHERE ";
			int i = 0;
			if (!"".equals(semester) && semester != null) {
				query += "c.semesterName = ? ";
				i++;
			}

			if ("true".equals(approved) || "false".equals(approved)) {
				query += i > 0 ? "AND " : "";
				query += "c.approved = ? ";
				i++;
			}

			if (facultyId > 0) {
				query += i > 0 ? "AND " : "";
				query += "ce.facilityId IN ";
				query += "(select id from facility AS ein WHERE ein.parentId = ? OR ein.id = ?) ";
				i++;
			}

			if (producerId > 0) {
				query += i > 0 ? "AND " : "";
				query += "pc.producerId = ? ";
				i++;
			}
		}
		query += "GROUP BY c.ID ";
		query += "ORDER BY c.name ASC ";
		query += "LIMIT ?, ?";

		return query;
	}
}
