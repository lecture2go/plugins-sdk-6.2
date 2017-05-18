package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacySegment;
import de.uhh.l2g.plugins.model.Segment;

public class SegmentMapper {
	static final Log log = LogFactoryUtil.getLog(SegmentMapper.class);

	public static Segment mapSegment(Segment segment, LegacySegment legacySegment, long companyId) {
		if (legacySegment == null || segment == null) {
			log.warn("can't execute method with null values - return segment as null value");
			return null;
		}
		segment.setVideoId(legacySegment.getVideoId());
		segment.setStart(legacySegment.getStart());
		segment.setEnd(legacySegment.getEnd());
		segment.setTitle(legacySegment.getTitle());
		segment.setDescription(legacySegment.getDescription());
		segment.setChapter(legacySegment.getChapter());
		segment.setUserId(UserIDMapper.getNewUserId(legacySegment.getUserId(), companyId));
		return segment;
	}
}
