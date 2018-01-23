package de.uhh.l2g.plugins.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Producer;

public class ProducerFinderImpl extends BasePersistenceImpl<Producer> implements ProducerFinder {

	
	public static final String FIND_PRODUCER_IDS = ProducerFinder.class.getName() + ".findProducerIds";

	public List<Long> findProducerIds(Long lectureseriesId, int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_PRODUCER_IDS);
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			List <Long> sl =  (List<Long>) QueryUtil.list(q, getDialect(), begin, end);
			return sl;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

}
