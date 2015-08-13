package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyVideoHitlist;
import de.uhh.l2g.plugins.model.Videohitlist;

public class VideoHitlistMapper {
	static final Log log = LogFactoryUtil.getLog(VideoHitlistMapper.class);; 
	
	public static Videohitlist mapVideoHitlist(LegacyVideoHitlist legacyVideoHitlist, Videohitlist videohitlist) {
		if (videohitlist == null || legacyVideoHitlist == null) {
			log.warn("can't execute method with null values - return videohitlist as null value");
			return null;
		}
		videohitlist.setHitsPerDay(legacyVideoHitlist.getHitsperday());
		videohitlist.setHitsPerMonth(legacyVideoHitlist.getHitspermonth());
		videohitlist.setHitsPerWeek(legacyVideoHitlist.getHitsperweek());
		videohitlist.setHitsPerYear(legacyVideoHitlist.getHitsperyear());
		//TODO : videoIDs == legacyIds? 
		videohitlist.setVideoId(legacyVideoHitlist.getId());
		return videohitlist;
	}

}
