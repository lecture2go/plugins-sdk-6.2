package de.uhh.l2g.plugins.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;


public class AutocompleteManager {

	private int _autocompSearchLimit = 100;


	/** The dao bean factory. */
	private XmlBeanFactory daoBeanFactory; 
	
	public void setDaoBeanFactory(XmlBeanFactory daoBeanFactory) {
		this.daoBeanFactory = daoBeanFactory;
	}

	public XmlBeanFactory getDaoBeanFactory() {
		return daoBeanFactory;
	}
	
	public List<String> getAllVideos() {
		
		List<String> resultList = new ArrayList<String>();
		List<Video> videoList = new ArrayList<Video>();

		try {
			videoList = VideoLocalServiceUtil.getAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
				
		for (Video video : videoList) resultList.add(video.getTitle());
		return resultList;
	}
	

	public List<String> getAutocompleteResults(String search) throws SystemException {
		List<Video> videoList = new ArrayList<Video>();
		List<String> resultList = new ArrayList<String>();

		if (search != null) {
			if (search.trim().length() > 1) {
				if(videoList.size()==0)videoList = VideoLocalServiceUtil.getByAllSearchWords();
				
				for (Video video : videoList) {
					
					/** Return only the string, that contained the search term */
					
					String title = video.getTitle().trim();
					String series = video.getLectureseriesName().trim();
					String lecturer = video.getCreatorFullName().trim();
					String tags = video.getTags().trim();
					
					if(!isDuplicate(resultList, title))resultList.add(title);
					
					if(!isDuplicate(resultList, series))resultList.add(series);
					
					if(!isDuplicate(resultList, lecturer))resultList.add(lecturer);
					
					if(!isDuplicate(resultList, tags))resultList.add(tags);
					
					/** Limit the number of result strings for ajax request to 10 
					if (resultList.size() >= 10) {
						break;
					}*/
					
				}
			}
		}

		return resultList;
	}
	
	private boolean isDuplicate(List<String> resultList, String word){
		boolean ret = false;
		for(String w : resultList){
			if(w.equals(word)){
				System.out.println("Duplicated: " + word);
				ret=true;
			}
		}
		return ret;
	}

}
