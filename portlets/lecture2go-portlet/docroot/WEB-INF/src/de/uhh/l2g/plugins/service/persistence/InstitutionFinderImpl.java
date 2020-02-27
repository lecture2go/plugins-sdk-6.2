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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;

public class InstitutionFinderImpl extends BasePersistenceImpl<Institution> implements InstitutionFinder {

	public static final String FIND_ALL_SORTED_AS_TREE = InstitutionFinder.class.getName() + ".findAllSortedAsTree";
	public static final String FIND_FROM_LECTURESERIES = InstitutionFinder.class.getName() + ".findByLectureseriesId";
	public static final String FIND_MAX_SORT_BY_PARENT = InstitutionFinder.class.getName() + ".findMaxSortByParent";
	public static final String FIND_LOCKING_ELEMENTS = InstitutionFinder.class.getName() + ".findLockingElements";
	public static final String FIND_ROOT_INSTITUTIONS_BY_OPEN_ACCESS_VIDEOS = InstitutionFinder.class.getName() + ".findRootInstitutionsByOpenAccessVideos";
	
	public List<Institution> findRootInstitutionsByOpenAccessVideos() {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ROOT_INSTITUTIONS_BY_OPEN_ACCESS_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleInstitutions(fl);
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
	
	public List<Institution> findByLectureseriesId(long lectureseriesId, int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_FROM_LECTURESERIES);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), begin, end);
			return assembleInstitutions(fl);
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

	public List<Institution> findAllSortedAsTree(int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_SORTED_AS_TREE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.addScalar("path", Type.STRING);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), begin, end);
			return assembleInstitutionsWithPath(fl);
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

	public int findMaxSortByParent(long parentId) {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_MAX_SORT_BY_PARENT);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("maxsort", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(parentId);
			Iterator<?> itr = q.list().iterator();

	        if (itr.hasNext()) {
	          Integer count = (Integer)itr.next();

	          if (count != null) {
	            return count.intValue();
	          }
	        }

	        return out;
	      } catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}

	public int findLockingElements(long institutionId) {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_LOCKING_ELEMENTS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("countElements", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(institutionId);
			Iterator<?> itr = q.list().iterator();

	        if (itr.hasNext()) {
	          Integer count = (Integer)itr.next();

	          if (count != null) {
	            return count.intValue();
	          }
	        }

	        return out;
	      } catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}


	public List<Institution> findInstitutionsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds,  ArrayList<Long> videoIds, Long parentId)  {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlInstitutionsByLectureseriesIdsAndVideoIds(lectureseriesIds,videoIds,parentId);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("institutionId", Type.LONG);
			q.addScalar("parentId", Type.INTEGER);
			q.addScalar("name", Type.STRING);
			q.addScalar("typ", Type.STRING);
			q.addScalar("www", Type.STRING);
			q.addScalar("level", Type.INTEGER);
			q.addScalar("sort", Type.INTEGER);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleInstitutions(fl);
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

	private String sqlInstitutionsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds, Long parentId) {
		boolean hasLectureseries 	= !lectureseriesIds.isEmpty();
		boolean hasVideos 			= !videoIds.isEmpty();
		boolean institutionsWanted	= parentId >0;
		// the query fetches the parentinstitutions or the child institutions depending on the given parentId
		String institutionQuery = institutionsWanted ? "institutionId" : "institutionParentId";
		String lquery = "";
		String vquery = "";

		if (hasLectureseries) {
			// convert the list of ids to a comma-seperated string for the sql query
			String lectureseriesIdsQuery = StringUtils.join(lectureseriesIds, ',');
			lquery = "SELECT " + institutionQuery + " FROM LG_Lectureseries_Institution WHERE lectureseriesId IN (" + lectureseriesIdsQuery + ")";
		}
		if (hasVideos) {
			// convert the list of ids to a comma-seperated string for the sql query
			String videoIdsQuery = StringUtils.join(videoIds, ',');
			vquery = "SELECT " + institutionQuery + " FROM LG_Video_Institution WHERE videoId IN (" + videoIdsQuery + ")";
		}

		String query =  "SELECT DISTINCT i.institutionId,i.parentId,i.name,i.typ,i.www,i.level,i.sort FROM (";

		if (hasLectureseries && hasVideos) {
			query += lquery + " UNION " + vquery;
 		} else if (hasLectureseries) {
			query += lquery;
		} else if (hasVideos) {
			query += vquery;
		}
		else { ////surpress sql error on empty lists 
			query += "SELECT " + institutionQuery + " FROM LG_Video_Institution WHERE videoId IN (0)";
		}

		query += ") AS a JOIN LG_Institution AS i ON a." + institutionQuery + " = i.institutionId";

		if (institutionsWanted) {
			query += " WHERE i.parentId = " + parentId.toString();
		}
		
		query += " ORDER BY sort";

		return query;
	}


	private List<Institution> assembleInstitutionsWithPath(List<Object[]> objectList){
		List<Institution> fl = new ArrayList<Institution>();
		for (Object[] institution: objectList){
			InstitutionImpl f = new InstitutionImpl();
			f.setInstitutionId((Long) institution[0]);
			f.setParentId((Integer) institution[1]);
			f.setName((String) institution[2]);
			f.setTyp((String) institution[3]);
			f.setWww((String) institution[4]);
			f.setLevel((Integer) institution[5]);
			f.setSort((Integer) institution[6]);
			String s = (String) institution[7];
			f.setPath(s);
			fl.add(f);
		}
		return fl;
	}

	private List<Institution> assembleInstitutions(List<Object[]> objectList){
		List<Institution> fl = new ArrayList<Institution>();
		for (Object[] institution: objectList){
			InstitutionImpl f = new InstitutionImpl();
			f.setInstitutionId((Long) institution[0]);
			f.setParentId((Integer) institution[1]);
			f.setName((String) institution[2]);
			f.setTyp((String) institution[3]);
			f.setWww((String) institution[4]);
			f.setLevel((Integer) institution[5]);
			f.setSort((Integer) institution[6]);
			fl.add(f);
		}
		return fl;
	}

}
