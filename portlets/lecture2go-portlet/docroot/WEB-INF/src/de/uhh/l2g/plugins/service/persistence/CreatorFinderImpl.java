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

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;

public class CreatorFinderImpl extends BasePersistenceImpl<Creator> implements CreatorFinder {
	public static final String FIND_CREATORS_FOR_LECTURESERIES = CreatorFinder.class.getName() + ".findCreatorsForLectureseries";
	public static final String FIND_CREATORS_FOR_VIDEO = CreatorFinder.class.getName() + ".findCreatorsForVideo";

	
	public List<Creator> findCreatorsByLectureseries(long lectureseriesId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_CREATORS_FOR_LECTURESERIES);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("creatorId", Type.LONG);
			q.addScalar("firstName", Type.STRING);
			q.addScalar("lastName", Type.STRING);
			q.addScalar("middleName", Type.STRING);
			q.addScalar("jobTitle", Type.STRING);
			q.addScalar("gender", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleCreators(fl);
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
	
	public List<Creator> findCreatorsByVideo(long videoId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_CREATORS_FOR_VIDEO);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("creatorId", Type.LONG);
			q.addScalar("firstName", Type.STRING);
			q.addScalar("lastName", Type.STRING);
			q.addScalar("middleName", Type.STRING);
			q.addScalar("jobTitle", Type.STRING);
			q.addScalar("gender", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(videoId);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleCreators(fl);
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
	
	private List<Creator> assembleCreators(List<Object[]> objectList){
		List<Creator> fl = new ArrayList<Creator>();
		for (Object[] institution: objectList){
			CreatorImpl f = new CreatorImpl();
			f.setCreatorId((Long) institution[0]);
			f.setFirstName((String) institution[1]);
			f.setLastName((String) institution[2]);
			f.setMiddleName((String) institution[3]);
			f.setJobTitle((String) institution[4]);
			f.setGender((String) institution[5]);
			f.setFullName((String) institution[6]);
			fl.add(f);
		}
		return fl;
	}
}
