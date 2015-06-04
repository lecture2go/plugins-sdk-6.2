package de.uhh.l2g.plugins.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.TermImpl;

public class TermFinderImpl extends BasePersistenceImpl<Term> implements TermFinder {
	public List<Term> findTermsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds,  ArrayList<Long> videoIds)  {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlTermsByLectureseriesIdsAndVideoIds(lectureseriesIds,videoIds);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("termId", Type.LONG);
			q.addScalar("parentId", Type.LONG);
			q.addScalar("languageId", Type.STRING);
			q.addScalar("prefix", Type.STRING);
			q.addScalar("year", Type.STRING);
			q.addScalar("translation", Type.STRING);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleTerms(fl);
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
	
	private String sqlTermsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		boolean hasLectureseries 	= !lectureseriesIds.isEmpty();
		boolean hasVideos 			= !videoIds.isEmpty();
		String lquery = "";
		String vquery = "";
		
		if (hasLectureseries) {
			// convert the list of ids to a comma-seperated string for the sql query
			String lectureseriesIdsQuery = StringUtils.join(lectureseriesIds, ',');
			lquery = "SELECT termId FROM LG_Lectureseries WHERE lectureseriesId IN (" + lectureseriesIdsQuery + ")";
		}
		if (hasVideos) {
			// convert the list of ids to a comma-seperated string for the sql query
			String videoIdsQuery = StringUtils.join(videoIds, ',');
			vquery = "SELECT termId FROM LG_Video WHERE videoId IN (" + videoIdsQuery + ")";
		}
				
		String query =  "SELECT DISTINCT t.termId,t.parentId,t.languageId,t.prefix,t.year,t.translation FROM (";
		
		if (hasLectureseries && hasVideos) {
			query += lquery + " UNION " + vquery;
 		} else if (hasLectureseries) {
			query += lquery;
		} else if (hasVideos) {
			query += vquery;
		}
		
		query += ") AS a JOIN LG_Term AS t ON a.termId = t.termId ORDER BY t.year DESC";
					
		return query;
	}
	
	private List<Term> assembleTerms(List<Object[]> objectList){
		List<Term> fl = new ArrayList<Term>();
		for (Object[] term: objectList){
			TermImpl f = new TermImpl();
			f.setTermId((Long) term[0]);
			f.setParentId((Long) term[1]);
			f.setLanguageId((String) term[2]);
			f.setPrefix((String) term[3]);
			f.setYear((String) term[4]);
			f.setTranslation((String) term[5]);
			fl.add(f);
		}
		return fl;
	}
}
