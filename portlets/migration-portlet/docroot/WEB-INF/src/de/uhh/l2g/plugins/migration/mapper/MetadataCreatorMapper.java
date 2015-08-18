package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyMetadata;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Metadata;

public class MetadataCreatorMapper {	
	static final Log log = LogFactoryUtil.getLog(MetadataCreatorMapper.class);

	public static Creator map(LegacyMetadata legacyMetaData, Creator creator) {
	if (creator == null || legacyMetaData == null) {
		log.warn("can't execute method with null values - return metaData as null value");
		return null;
	}
	
		creator.setFirstName(legacyMetaData.getCreator());
		creator.setFullName(legacyMetaData.getCreator());
		creator.setGender(legacyMetaData.getCreator());
		creator.setJobTitle(legacyMetaData.getCreator());
		creator.setLastName(legacyMetaData.getCreator());
		creator.setMiddleName(legacyMetaData.getCreator());
	
	
	return creator;
}

}
