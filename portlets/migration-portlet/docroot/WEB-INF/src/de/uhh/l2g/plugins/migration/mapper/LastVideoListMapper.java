package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyLastVideoList;
import de.uhh.l2g.plugins.model.Lastvideolist;

public class LastVideoListMapper {
	static final Log log = LogFactoryUtil.getLog(LastVideoListMapper.class);
	public static Lastvideolist mapLastVideoList(LegacyLastVideoList legacyLastVideoList, Lastvideolist lastVideoList ) {
		if (legacyLastVideoList == null || lastVideoList == null) {
			log.warn("can't execute method with null values - return lastVideoList as null value");
			return null;
		}
		lastVideoList.setVideoId(legacyLastVideoList.getVideoId());
	return lastVideoList;
	}

}
