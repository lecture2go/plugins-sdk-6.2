/*******************************************************************************
 * Lecture2Go-License
 * The Lecture2Go software is based on the liferay portal 6.2-ga6
 * <http://www.liferay.com>
 * 
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 * 
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * 
 * Copyright (c) 2013 - present University of Hamburg / Computer and Data Center (RRZ)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ 
 * 
 * Third Party Software
 * 
 * Lecture2Go uses third-party libraries which may be distributed under different licenses to 
 * the above (but are compatible with the used GPL license). Informations about these licenses 
 * and copyright informations are mostly detailed in the library source code or jars themselves. 
 * You must agree to the terms of these licenses, in addition to  the above Lecture2Go 
 * source code license, in order to use this software. 
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ 
 * 
 * Apache 2.0
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and limitations under the License.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ 
 * 
 * BSD
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, 
 * this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, 
 * this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the copyright holder nor the names of its contributors 
 * may be used to endorse or promote products derived from this software without 
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY 
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER 
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, 
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON 
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ 
 * 
 * Eclipse Public License
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ 
 * 
 * JSON License
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 * associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Software.
 * 
 * The Software shall be used for Good, not Evil.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE 
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ 
 * 
 * MIT
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
 * and associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial 
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE 
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package de.uhh.l2g.plugins.service.persistence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.util.VideoGenerationDateComparator;

public class VideoFinderImpl extends BasePersistenceImpl<Video> implements VideoFinder {

	public static final String RESET_LECTURESERIES_FOR_VIDEOS = VideoFinder.class.getName() + ".resetLectureseriesForVideos";
	public static final String FIND_LATES_OPEN_ACCESS_VIDEO_FOR_LECTURESERIES = VideoFinder.class.getName() + ".findLatestOpenAccessVideoForlectureseries";
	public static final String FIND_VIDEO_FOR_SECURE_URL = VideoFinder.class.getName() + ".findVideoForSecureUrl";
	public static final String FIND_VIDEOS_BY_SEARCH_WORD = VideoFinder.class.getName() + ".findVideosBySearchWord";
	public static final String FIND_VIDEOS_BY_ALL_SEARCH_WORDS = VideoFinder.class.getName() + ".findAllSearchWords";
	public static final String FIND_VIDEOS_BY_SEARCH_WORD_AND_LECTURESERIESID = VideoFinder.class.getName() + ".findVideosBySearchWordAndLectureseriesId";
	public static final String FIND_VIDEOS_BY_HITS = VideoFinder.class.getName() + ".findVideosByHits";
	public static final String FIND_VIDEOS_BY_HITS_AND_OPEN_ACCESS = VideoFinder.class.getName() + ".findVideosByHitsAndOpenAccess";
	public static final String FIND_POPULAR_VIDEOS = VideoFinder.class.getName() + ".findPopularVideos";

	public List<Video> findPopular(int limit) {
		int start= com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS;
		int stop=com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS;
		if (limit>0){
			start =0;
			stop=limit;
		}
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_POPULAR_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("videoId", Type.LONG);
			q.addScalar("title", Type.STRING);
			q.addScalar("lectureseriesId", Type.LONG);
			q.addScalar("producerId", Type.LONG);
			q.addScalar("containerFormat", Type.STRING);
			q.addScalar("filename", Type.STRING);
			q.addScalar("resolution", Type.STRING);
			q.addScalar("duration", Type.STRING);
			q.addScalar("hostId", Type.LONG);
			q.addScalar("fileSize", Type.STRING);
			q.addScalar("generationDate", Type.STRING);
			q.addScalar("openAccess", Type.INTEGER);
			q.addScalar("downloadLink", Type.INTEGER);
			q.addScalar("metadataId", Type.LONG);
			q.addScalar("secureFilename", Type.STRING);
			q.addScalar("hits", Type.INTEGER);
			q.addScalar("uploadDate", Type.STRING);
			q.addScalar("permittedToSegment", Type.INTEGER);
			q.addScalar("rootInstitutionId", Type.LONG);
			q.addScalar("citation2go", Type.INTEGER);
			q.addScalar("termId", Type.LONG);
			q.addScalar("tags", Type.STRING);
			q.addScalar("password_", Type.STRING);
			q.setCacheable(false);
			
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),start , stop);
			return assembleVideos(l);
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
	
	public List<Video> findVideosByHits(long hits) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEOS_BY_HITS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("videoId", Type.LONG);
			q.addScalar("title", Type.STRING);
			q.addScalar("lectureseriesId", Type.LONG);
			q.addScalar("producerId", Type.LONG);
			q.addScalar("containerFormat", Type.STRING);
			q.addScalar("filename", Type.STRING);
			q.addScalar("resolution", Type.STRING);
			q.addScalar("duration", Type.STRING);
			q.addScalar("hostId", Type.LONG);
			q.addScalar("fileSize", Type.STRING);
			q.addScalar("generationDate", Type.STRING);
			q.addScalar("openAccess", Type.INTEGER);
			q.addScalar("downloadLink", Type.INTEGER);
			q.addScalar("metadataId", Type.LONG);
			q.addScalar("secureFilename", Type.STRING);
			q.addScalar("hits", Type.INTEGER);
			q.addScalar("uploadDate", Type.STRING);
			q.addScalar("permittedToSegment", Type.INTEGER);
			q.addScalar("rootInstitutionId", Type.LONG);
			q.addScalar("citation2go", Type.INTEGER);
			q.addScalar("termId", Type.LONG);
			q.addScalar("tags", Type.STRING);
			q.addScalar("password_", Type.STRING);
			
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hits);
			
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleVideos(l);
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

	public List<Video> findVideosByHitsAndOpenAccess(long hits) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEOS_BY_HITS_AND_OPEN_ACCESS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("videoId", Type.LONG);
			q.addScalar("title", Type.STRING);
			q.addScalar("lectureseriesId", Type.LONG);
			q.addScalar("producerId", Type.LONG);
			q.addScalar("containerFormat", Type.STRING);
			q.addScalar("filename", Type.STRING);
			q.addScalar("resolution", Type.STRING);
			q.addScalar("duration", Type.STRING);
			q.addScalar("hostId", Type.LONG);
			q.addScalar("fileSize", Type.STRING);
			q.addScalar("generationDate", Type.STRING);
			q.addScalar("openAccess", Type.INTEGER);
			q.addScalar("downloadLink", Type.INTEGER);
			q.addScalar("metadataId", Type.LONG);
			q.addScalar("secureFilename", Type.STRING);
			q.addScalar("hits", Type.INTEGER);
			q.addScalar("uploadDate", Type.STRING);
			q.addScalar("permittedToSegment", Type.INTEGER);
			q.addScalar("rootInstitutionId", Type.LONG);
			q.addScalar("citation2go", Type.INTEGER);
			q.addScalar("termId", Type.LONG);
			q.addScalar("tags", Type.STRING);
			q.addScalar("password_", Type.STRING);
			
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hits);
			
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleVideos(l);
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
	
	public List<Video> findVideosByAllSearchWords() {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEOS_BY_ALL_SEARCH_WORDS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("title", Type.STRING);
			//custom fields
			q.addScalar("lectureseriesName", Type.STRING);
			q.addScalar("lectureseriesNumber", Type.STRING);
			q.addScalar("creatorFullName", Type.STRING);
			q.addScalar("videoId", Type.LONG);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleVideosSearchWord(l);
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
	
	public List<Video> findVideosBySearchWord(String word, int limit) {
		word = word.replace("&amp;", "&");//get from entity &amp; only the character & for this specific search
		word="%"+word+"%";
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEOS_BY_SEARCH_WORD);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("title", Type.STRING);
			//custom fields
			q.addScalar("lectureseriesName", Type.STRING);
			q.addScalar("lectureseriesNumber", Type.STRING);
			q.addScalar("creatorFullName", Type.STRING);
			q.addScalar("videoId", Type.LONG);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(word);
			qPos.add(word);
			qPos.add(word);
			qPos.add(word);
			qPos.add(word);
			
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(), 0 , limit);
			return assembleVideosSearchWord(l);
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
	
	public List<Video> findVideosBySearchWordAndLectureseriesId(String word, long lectureseriesId) {
		word = word.replace("&amp;", "&");//get from entity &amp; only the character & for this specific search
		word="%"+word+"%";
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEOS_BY_SEARCH_WORD_AND_LECTURESERIESID);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("videoId", Type.LONG);
			q.addScalar("title", Type.STRING);
			q.addScalar("lectureseriesId", Type.LONG);
			q.addScalar("producerId", Type.LONG);
			q.addScalar("containerFormat", Type.STRING);
			q.addScalar("filename", Type.STRING);
			q.addScalar("resolution", Type.STRING);
			q.addScalar("duration", Type.STRING);
			q.addScalar("hostId", Type.LONG);
			q.addScalar("fileSize", Type.STRING);
			q.addScalar("generationDate", Type.STRING);
			q.addScalar("openAccess", Type.INTEGER);
			q.addScalar("downloadLink", Type.INTEGER);
			q.addScalar("metadataId", Type.LONG);
			q.addScalar("secureFilename", Type.STRING);
			q.addScalar("hits", Type.INTEGER);
			q.addScalar("uploadDate", Type.STRING);
			q.addScalar("permittedToSegment", Type.INTEGER);
			q.addScalar("rootInstitutionId", Type.LONG);
			q.addScalar("citation2go", Type.INTEGER);
			q.addScalar("termId", Type.LONG);
			q.addScalar("tags", Type.STRING);
			q.addScalar("password_", Type.STRING);
			
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			//1st query
			qPos.add(word);
			qPos.add(lectureseriesId);
			//2nd query
//			qPos.add(word);
//			qPos.add(lectureseriesId);			
			@SuppressWarnings("unchecked")
			List <Object[]> l =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleVideos(l);
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
	
	public int unlinkLectureseriesFromVideos(Long lectureseriesId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(RESET_LECTURESERIES_FOR_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("videoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			return q.executeUpdate();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public Video findVideoBySerureUrl(String surl) {
		Session session = null;
		Video video = new VideoImpl();
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_VIDEO_FOR_SECURE_URL);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("videoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(surl+"%");
			@SuppressWarnings("unchecked")
			List <Long> vl =  (List<Long>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			video = VideoLocalServiceUtil.getVideo(vl.get(0));
			return video;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				////e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return video;
	}
	
	public Video findLatestOpenAccessVideoForLectureseries(Long lectureseriesId) {
		Session session = null;
		Video video = new VideoImpl();
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_LATES_OPEN_ACCESS_VIDEO_FOR_LECTURESERIES);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("videoId", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			qPos.add(lectureseriesId);
			@SuppressWarnings("unchecked")
			List <Long> vl =  (List<Long>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			video = VideoLocalServiceUtil.getVideo(vl.get(0));
			return video;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				////e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return video;
	}
	
	private List<Video> assembleVideos(List<Object[]> objectList){
		List<Video> vl = new ArrayList<Video>();
		for (Object[] video: objectList){
			VideoImpl v = new VideoImpl();
			v.setVideoId((Long)video[0]);
			v.setTitle((String)video[1]);
			v.setLectureseriesId((Long)video[2]);
			v.setProducerId((Long)video[3]);
			v.setContainerFormat((String)video[4]);
			v.setFilename((String)video[5]);
			v.setResolution((String)video[6]);
			v.setDuration((String)video[7]);
			v.setHostId((Long)video[8]);
			v.setFileSize((String)video[9]);
			v.setGenerationDate((String)video[10]);
			v.setOpenAccess((Integer)video[11]);
			v.setDownloadLink((Integer)video[12]);
			v.setMetadataId((Long)video[13]);
			v.setSecureFilename((String)video[14]);
			v.setHits((Integer)video[15]);
			//parse date
			DateFormat formatter ;
			Date date = new Date();
			formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			try {
				String s = (video[16])+"";
				date = (Date) formatter.parse(s);
			} catch (ParseException e) {
//				//e.printStackTrace();
			}			
			//
			v.setUploadDate(date);
			v.setPermittedToSegment((Integer)video[17]);
			v.setRootInstitutionId((Long)video[18]);
			v.setCitation2go((Integer)video[19]);
			v.setTermId((Long)video[20]);
			v.setTags((String)video[21]);
			v.setPassword((String)video[22]);
			
			vl.add(v);
		}
		return vl;
	}
	
	private List<Video> assembleVideosSearchWord(List<Object[]> objectList) {
		List<Video> vl = new ArrayList<Video>();
		for (Object[] video: objectList){
			VideoImpl v = new VideoImpl();
			v.setTitle((String)video[0]);
			v.setLectureseriesName((String)video[1]);
			v.setLectureseriesNumber((String)video[2]);
			v.setCreatorFullName((String)video[3]);
			v.setVideoId((Long)video[4]);
			//creators
			List<Video_Creator> vc;
			try {
				vc = Video_CreatorLocalServiceUtil.getByVideo(v.getVideoId());
				ListIterator<Video_Creator> vci = vc.listIterator();
				String creators ="";
				while(vci.hasNext()){
					Long cId = vci.next().getCreatorId();
					Creator cr = new CreatorImpl();
					try{
						cr = CreatorLocalServiceUtil.getCreator(cId);
					}catch(Exception e){}
					creators+="###"+cr.getFullName();
				}
				v.setCreators(creators);
			} catch (SystemException e) {
				//e.printStackTrace();
			}
			vl.add(v);
		}
		return vl;
	}
	
	public List<Video> findLatestVideos(){
		List<Lectureseries> ll = new ArrayList<Lectureseries>();
		ll = LectureseriesLocalServiceUtil.getAllLectureseriesWhithOpenaccessVideos();
		List<Video> vl = new ArrayList<Video>();
		Iterator<Lectureseries> it = ll.iterator();
		while (it.hasNext()){
			Lectureseries l = (Lectureseries) it.next();
			Video v = findLatestOpenAccessVideoForLectureseries(l.getLectureseriesId());
			vl.add(v);
		}
		Comparator<Video> comparator = new VideoGenerationDateComparator();
		java.util.Collections.sort(vl, comparator);		
		return vl;
	}
}
