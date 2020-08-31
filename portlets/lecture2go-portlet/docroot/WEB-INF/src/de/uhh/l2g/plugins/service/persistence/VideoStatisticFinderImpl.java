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

import de.uhh.l2g.plugins.model.VideoStatistic;
import de.uhh.l2g.plugins.model.impl.VideoStatisticImpl;

public class VideoStatisticFinderImpl extends BasePersistenceImpl<VideoStatistic> implements VideoStatisticFinder {

	public static final String FIND_BY_DATE_DIFF = VideoFinder.class.getName() + ".findVideoStatistics";
	
	public List<VideoStatistic> findAllStats() {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_DATE_DIFF);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("dateDiff", Type.INTEGER);
			q.addScalar("timespanId", Type.INTEGER);
			q.addScalar("maxDate", Type.DATE);
			q.addScalar("public", Type.INTEGER);
			q.addScalar("private", Type.INTEGER);
			q.addScalar("total", Type.INTEGER);
			q.addScalar("pubPercent", Type.INTEGER);
			q.addScalar("privPercent", Type.INTEGER);
			q.addScalar("current", Type.DATE);
			q.addScalar("currentPublic", Type.INTEGER);
			q.addScalar("currentPrivate", Type.INTEGER);
			q.addScalar("currentTotal", Type.INTEGER);
			q.addScalar("curPubPercent", Type.INTEGER);
			q.addScalar("curPrivPercent", Type.INTEGER);
			q.addScalar("publicDiff", Type.INTEGER);
			q.addScalar("privateDiff", Type.INTEGER);
			q.addScalar("totalDiff", Type.INTEGER);
			//
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assemble(l);
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
	
	private List<VideoStatistic> assemble(List<Object[]> objectList){
		List<VideoStatistic> sl = new ArrayList<VideoStatistic>();
		for (Object[] video: objectList){
			VideoStatisticImpl vs = new VideoStatisticImpl();
			vs.setDateDiff((Integer)video[0]);
			vs.setPublicVideos((Integer)video[3]);
			vs.setPrivateVideos((Integer)video[4]);
			vs.setTotalVideos((Integer)video[5]);
			vs.setPubPercent((Integer)video[6]);
			vs.setPrivPercent((Integer)video[7]);
			vs.setCurrentTotal((Integer)video[11]);
			vs.setCurrentPublic((Integer)video[9]);
			vs.setCurrentPrivate((Integer)video[10]);
			vs.setCurrentPubPercent((Integer)video[12]);
			vs.setCurrentPrivPercent((Integer)video[13]);
			vs.setPublicDiff((Integer)video[14]);
			vs.setPrivateDiff((Integer)video[15]);
			vs.setTotalDiff((Integer)video[16]);
			sl.add(vs);
		}
		return sl;		
	}
	
}
