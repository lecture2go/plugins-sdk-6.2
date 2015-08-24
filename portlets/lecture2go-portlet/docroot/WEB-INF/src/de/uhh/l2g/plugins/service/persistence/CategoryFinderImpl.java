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

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.impl.CategoryImpl;

public class CategoryFinderImpl extends BasePersistenceImpl<Category> implements CategoryFinder {
	public List<Category> findCategoriesByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds,  ArrayList<Long> videoIds)  {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlCategoriesByLectureseriesIdsAndVideoIds(lectureseriesIds,videoIds);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("categoryId", Type.LONG);
			q.addScalar("parentId", Type.LONG);
			q.addScalar("languageId", Type.STRING);
			q.addScalar("name", Type.STRING);
			q.addScalar("translation", Type.STRING);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleCategories(fl);
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
	
	private String sqlCategoriesByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		boolean hasLectureseries 	= !lectureseriesIds.isEmpty();
		boolean hasVideos 			= !videoIds.isEmpty();
		String lquery = "";
		String vquery = "";
		
		if (hasLectureseries) {
			// convert the list of ids to a comma-seperated string for the sql query
			String lectureseriesIdsQuery = StringUtils.join(lectureseriesIds, ',');
			lquery = "SELECT categoryId FROM LG_Lectureseries WHERE lectureseriesId IN (" + lectureseriesIdsQuery + ")";
		}
		if (hasVideos) {
			// convert the list of ids to a comma-seperated string for the sql query
			String videoIdsQuery = StringUtils.join(videoIds, ',');
			vquery = "SELECT categoryId FROM LG_Video_Category WHERE videoId IN (" + videoIdsQuery + ")";
		}
				
		String query =  "SELECT DISTINCT t.categoryId,t.parentId,t.languageId,t.name,t.translation FROM (";
		
		if (hasLectureseries && hasVideos) {
			query += lquery + " UNION " + vquery;
 		} else if (hasLectureseries) {
			query += lquery;
		} else if (hasVideos) {
			query += vquery;
		}
		
		query += ") AS a JOIN LG_Category AS t ON a.categoryId = t.categoryId";
					
		return query;
	}
	
	private List<Category> assembleCategories(List<Object[]> objectList){
		List<Category> fl = new ArrayList<Category>();
		for (Object[] category: objectList){
			CategoryImpl f = new CategoryImpl();
			f.setCategoryId((Long) category[0]);
			f.setParentId((Long) category[1]);
			f.setLanguageId((String) category[2]);
			f.setName((String) category[3]);
			f.setTranslation((String) category[4]);
			fl.add(f);
		}
		return fl;
	}
}
