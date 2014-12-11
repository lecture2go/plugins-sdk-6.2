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
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;

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
			@SuppressWarnings("unchecked")
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

	public List<Lectureseries> findeFilteredByApprovedSemesterFacultyProducer(Integer approved, String semester, Long facultyId, Long producerId) {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlFilterForLectureseries(approved, semester, facultyId, producerId);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("number_", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("eventCategory", Type.STRING);
			q.addScalar("name", Type.STRING);
			q.addScalar("shortDesc", Type.STRING);
			q.addScalar("semesterName", Type.STRING);
			q.addScalar("language", Type.STRING);
			q.addScalar("facultyName", Type.STRING);
			q.addScalar("instructorsString", Type.STRING);
			q.addScalar("lectureseriesId", Type.STRING);
			q.addScalar("password_", Type.STRING);
			q.addScalar("approved", Type.STRING);
			q.addScalar("longDesc", Type.STRING);
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
			l.setEventCategory((String) lectser[2]);
			l.setName((String) lectser[3]);
			l.setShortDesc((String) lectser[4]);
			l.setSemesterName((String) lectser[5]);
			l.setLanguage((String) lectser[6]);
			l.setFacultyName((String) lectser[7]);
			l.setInstructorsString((String) lectser[8]);
			l.setLectureseriesId(new Long((String) lectser[9]));
			l.setPassword((String) lectser[10]);
			l.setApproved(new Integer((String) lectser[11]));
			l.setLongDesc((String) lectser[12]);
			
			ll.add(l);
		}
		return ll;
	}
	
	private String sqlFilterForLectureseries(Integer approved, String semester, Long facultyId, Long producerId) {
		// build query
		String query = "SELECT c.number_, c.eventType, c.eventCategory, c.name, c.shortDesc, c.longDesc, c.semesterName, c.language, c.facultyName, c.instructorsString, c.lectureseriesId, c.password_, c.approved ";
			   query += "FROM lg_lectureseries AS c ";

		if (facultyId > 0) {
			query += "INNER JOIN lg_lectureseries_institution AS ce ON ( c.lectureseriesId = ce.lectureseriesId ) ";
			query += "INNER JOIN lg_institution AS e ON ( ce.institutionId = e.institutionId ) ";
		}

		if (producerId > 0) {
			query += "INNER JOIN lg_producer_lectureseries AS pc ON ( c.lectureseriesId = pc.lectureseriesId ) ";
			query += "INNER JOIN lg_producer AS p ON ( pc.producerId = p.producerId ) ";
		}

		if ((!"".equals(semester) && semester != null) || (approved==1 || approved==0) || facultyId > 0 || producerId > 0) {
			query += "WHERE ";
			int i = 0;
			if (!"".equals(semester) && semester != null) {
				query += "c.semesterName = \""+semester + "\" ";
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
				query += "(select institutionId from lg_institution AS ein WHERE ein.parentId = "+facultyId+" OR ein.institutionId = "+facultyId+") ";
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
