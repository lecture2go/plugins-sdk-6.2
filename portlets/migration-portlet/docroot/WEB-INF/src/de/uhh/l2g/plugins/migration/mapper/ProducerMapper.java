package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import de.uhh.l2g.plugins.migration.model.LegacyProducer;
import de.uhh.l2g.plugins.model.Producer;

public class ProducerMapper {
	static final Log log = LogFactoryUtil.getLog(ProducerMapper.class); 
	
	public static Producer mapProducer(LegacyProducer legacyProducer, Producer producer) {
		if (producer == null || legacyProducer == null) {
			log.warn("can't execute method with null values - return coordinator as null value");
			return null;
		}
		producer.setIdNum(legacyProducer.getIdNum());
		producer.setHomeDir(legacyProducer.getHomeDir());
		producer.setHostId(legacyProducer.getHostId());
		producer.setInstitutionId(legacyProducer.getFacilityId());
		return producer;
	} 


}
