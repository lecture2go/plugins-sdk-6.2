package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Creator;


public class VideoCreatorMapper {
	static final Log log = LogFactoryUtil.getLog(VideoCreatorMapper.class);; 
	
	public static Video_Creator map(Video_Creator video_creator,Video Video, Creator creator) {
		if (video_creator == null) {
			log.warn("can't execute method with null values - return Video_Creator as null value");
			return null;
		}
		video_creator.setVideoId(Video.getVideoId());	
		video_creator.setCreatorId(creator.getCreatorId());
		return video_creator;
	} 


}
