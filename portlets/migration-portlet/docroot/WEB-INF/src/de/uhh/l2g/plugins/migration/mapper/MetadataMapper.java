package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyMetadata;
import de.uhh.l2g.plugins.model.Metadata;

public class MetadataMapper {	
	static final Log log = LogFactoryUtil.getLog(MetadataMapper.class);

	public static Metadata mapMetadata(LegacyMetadata legacyMetaData, Metadata metaData) {
	if (metaData == null || legacyMetaData == null) {
		log.warn("can't execute method with null values - return metaData as null value");
		return null;
	}
	metaData.setDescription(legacyMetaData.getDescription());
	metaData.setLanguage(legacyMetaData.getLanguage());
	metaData.setPublisher(legacyMetaData.getPublisher());
	metaData.setSubject(legacyMetaData.getSubject());
	metaData.setTitle(legacyMetaData.getTitle());
	metaData.setType(legacyMetaData.getType());
	return metaData;
}

}
