package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Lectureseries;

public class VideoLectureseriesMapper {
	static final Log log = LogFactoryUtil.getLog(VideoLectureseriesMapper.class);; 
	
	public static Video_Lectureseries mapVideoLectureseries(Video video, Video_Lectureseries video_Lectureseries, long companyId) {
		if (video_Lectureseries == null || video == null) {
			log.warn("can't execute method with null values - return video as null value");
			return null;
		}
		video_Lectureseries.setVideoId(video.getVideoId());
		video_Lectureseries.setLectureseriesId(video.getLectureseriesId());
		video_Lectureseries.setOpenAccess(video.getOpenAccess());
		return video_Lectureseries;
	} 


}
