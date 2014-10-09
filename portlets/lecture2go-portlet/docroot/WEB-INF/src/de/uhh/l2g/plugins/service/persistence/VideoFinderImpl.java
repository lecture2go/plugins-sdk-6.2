package de.uhh.l2g.plugins.service.persistence;


import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Video;

public class VideoFinderImpl extends BasePersistenceImpl<Video> implements VideoFinder {

	public static final String RESET_LECTURESERIES_FOR_VIDEOS = VideoFinder.class.getName() + ".resetLectureseriesForVideos";

	public int unlinkLectureseriesFromVideos(long lectureseriesId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(RESET_LECTURESERIES_FOR_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("videoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			return q.executeUpdate();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
}
