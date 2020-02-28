/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service.base;

import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class VideoLocalServiceClpInvoker {
	public VideoLocalServiceClpInvoker() {
		_methodName0 = "addVideo";

		_methodParameterTypes0 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName1 = "createVideo";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVideo";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVideo";

		_methodParameterTypes3 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchVideo";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getVideo";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getVideos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getVideosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateVideo";

		_methodParameterTypes15 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName172 = "getBeanIdentifier";

		_methodParameterTypes172 = new String[] {  };

		_methodName173 = "setBeanIdentifier";

		_methodParameterTypes173 = new String[] { "java.lang.String" };

		_methodName178 = "getByOpenAccess";

		_methodParameterTypes178 = new String[] { "int" };

		_methodName179 = "getByOpenAccessAndUploadedFile";

		_methodParameterTypes179 = new String[] { "int" };

		_methodName180 = "getLatestOpenAccessVideoForLectureseries";

		_methodParameterTypes180 = new String[] { "java.lang.Long" };

		_methodName181 = "getByTerm";

		_methodParameterTypes181 = new String[] { "java.lang.Long" };

		_methodName182 = "unlinkLectureseriesFromVideos";

		_methodParameterTypes182 = new String[] { "java.lang.Long" };

		_methodName183 = "getByRootInstitution";

		_methodParameterTypes183 = new String[] { "java.lang.Long" };

		_methodName184 = "getByFilename";

		_methodParameterTypes184 = new String[] { "java.lang.String" };

		_methodName185 = "getByProducer";

		_methodParameterTypes185 = new String[] { "java.lang.Long" };

		_methodName186 = "getByLectureseries";

		_methodParameterTypes186 = new String[] { "java.lang.Long" };

		_methodName187 = "countByLectureseries";

		_methodParameterTypes187 = new String[] { "java.lang.Long" };

		_methodName188 = "getByProducerAndLectureseries";

		_methodParameterTypes188 = new String[] {
				"java.lang.Long", "java.lang.Long"
			};

		_methodName189 = "getByProducerAndDownloadLink";

		_methodParameterTypes189 = new String[] { "java.lang.Long", "int" };

		_methodName190 = "getPopular";

		_methodParameterTypes190 = new String[] { "int" };

		_methodName191 = "getLatestVideos";

		_methodParameterTypes191 = new String[] {  };

		_methodName192 = "createThumbnailsIfNotExisting";

		_methodParameterTypes192 = new String[] { "java.lang.Long" };

		_methodName193 = "createSymLinkToDownloadableFileIfNotExisting";

		_methodParameterTypes193 = new String[] { "java.lang.Long" };

		_methodName194 = "getJSONVideo";

		_methodParameterTypes194 = new String[] { "java.lang.Long" };

		_methodName195 = "createLastVideoList";

		_methodParameterTypes195 = new String[] {  };

		_methodName196 = "countByLectureseriesAndOpenaccess";

		_methodParameterTypes196 = new String[] { "java.lang.Long", "int" };

		_methodName197 = "getByLectureseriesAndOpenaccess";

		_methodParameterTypes197 = new String[] { "java.lang.Long", "int" };

		_methodName198 = "addPlayerUris2Video";

		_methodParameterTypes198 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName199 = "addTextTracks2VideoWithLanguageLabel";

		_methodParameterTypes199 = new String[] {
				"de.uhh.l2g.plugins.model.Video", "java.util.Locale"
			};

		_methodName200 = "addTextTracks2Video";

		_methodParameterTypes200 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName201 = "getBySecureUrl";

		_methodParameterTypes201 = new String[] { "java.lang.String" };

		_methodName202 = "getAll";

		_methodParameterTypes202 = new String[] {  };

		_methodName203 = "getBySearchWord";

		_methodParameterTypes203 = new String[] { "java.lang.String", "int" };

		_methodName204 = "getByAllSearchWords";

		_methodParameterTypes204 = new String[] {  };

		_methodName205 = "getBySearchWordAndLectureseriesId";

		_methodParameterTypes205 = new String[] {
				"java.lang.String", "java.lang.Long"
			};

		_methodName206 = "getByHits";

		_methodParameterTypes206 = new String[] { "java.lang.Long" };

		_methodName207 = "getByHitsAndOpenAccess";

		_methodParameterTypes207 = new String[] { "java.lang.Long" };

		_methodName208 = "getByHits";

		_methodParameterTypes208 = new String[] {  };

		_methodName209 = "updateVideo";

		_methodParameterTypes209 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName211 = "getLatestClosedAccessVideoId";

		_methodParameterTypes211 = new String[] { "java.lang.Long" };

		_methodName212 = "checkSmilFile";

		_methodParameterTypes212 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName213 = "fileStringSegmentFoundInArray";

		_methodParameterTypes213 = new String[] {
				"java.lang.String", "org.json.JSONArray"
			};

		_methodName214 = "createSymLinkForCaptionIfExisting";

		_methodParameterTypes214 = new String[] { "java.lang.Long" };

		_methodName215 = "isSymlink";

		_methodParameterTypes215 = new String[] { "java.io.File" };

		_methodName216 = "retrieveLanguageDisplayNameOfCaptionFile";

		_methodParameterTypes216 = new String[] {
				"java.io.File", "java.util.Locale"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VideoLocalServiceUtil.addVideo((de.uhh.l2g.plugins.model.Video)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VideoLocalServiceUtil.createVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VideoLocalServiceUtil.deleteVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VideoLocalServiceUtil.deleteVideo((de.uhh.l2g.plugins.model.Video)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VideoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VideoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VideoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VideoLocalServiceUtil.fetchVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VideoLocalServiceUtil.getVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VideoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VideoLocalServiceUtil.getVideos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VideoLocalServiceUtil.getVideosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VideoLocalServiceUtil.updateVideo((de.uhh.l2g.plugins.model.Video)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return VideoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			VideoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return VideoLocalServiceUtil.getByOpenAccess(((Integer)arguments[0]).intValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return VideoLocalServiceUtil.getByOpenAccessAndUploadedFile(((Integer)arguments[0]).intValue());
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return VideoLocalServiceUtil.getLatestOpenAccessVideoForLectureseries((java.lang.Long)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return VideoLocalServiceUtil.getByTerm((java.lang.Long)arguments[0]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return VideoLocalServiceUtil.unlinkLectureseriesFromVideos((java.lang.Long)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return VideoLocalServiceUtil.getByRootInstitution((java.lang.Long)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return VideoLocalServiceUtil.getByFilename((java.lang.String)arguments[0]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return VideoLocalServiceUtil.getByProducer((java.lang.Long)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return VideoLocalServiceUtil.getByLectureseries((java.lang.Long)arguments[0]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return VideoLocalServiceUtil.countByLectureseries((java.lang.Long)arguments[0]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return VideoLocalServiceUtil.getByProducerAndLectureseries((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return VideoLocalServiceUtil.getByProducerAndDownloadLink((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return VideoLocalServiceUtil.getPopular(((Integer)arguments[0]).intValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return VideoLocalServiceUtil.getLatestVideos();
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			VideoLocalServiceUtil.createThumbnailsIfNotExisting((java.lang.Long)arguments[0]);

			return null;
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			VideoLocalServiceUtil.createSymLinkToDownloadableFileIfNotExisting((java.lang.Long)arguments[0]);

			return null;
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return VideoLocalServiceUtil.getJSONVideo((java.lang.Long)arguments[0]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			VideoLocalServiceUtil.createLastVideoList();

			return null;
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return VideoLocalServiceUtil.countByLectureseriesAndOpenaccess((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return VideoLocalServiceUtil.getByLectureseriesAndOpenaccess((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			VideoLocalServiceUtil.addPlayerUris2Video((de.uhh.l2g.plugins.model.Video)arguments[0]);

			return null;
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			VideoLocalServiceUtil.addTextTracks2VideoWithLanguageLabel((de.uhh.l2g.plugins.model.Video)arguments[0],
				(java.util.Locale)arguments[1]);

			return null;
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			VideoLocalServiceUtil.addTextTracks2Video((de.uhh.l2g.plugins.model.Video)arguments[0]);

			return null;
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return VideoLocalServiceUtil.getBySecureUrl((java.lang.String)arguments[0]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return VideoLocalServiceUtil.getAll();
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return VideoLocalServiceUtil.getBySearchWord((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return VideoLocalServiceUtil.getByAllSearchWords();
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return VideoLocalServiceUtil.getBySearchWordAndLectureseriesId((java.lang.String)arguments[0],
				(java.lang.Long)arguments[1]);
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return VideoLocalServiceUtil.getByHits((java.lang.Long)arguments[0]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return VideoLocalServiceUtil.getByHitsAndOpenAccess((java.lang.Long)arguments[0]);
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return VideoLocalServiceUtil.getByHits();
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return VideoLocalServiceUtil.updateVideo((de.uhh.l2g.plugins.model.Video)arguments[0]);
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return VideoLocalServiceUtil.getLatestClosedAccessVideoId((java.lang.Long)arguments[0]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return VideoLocalServiceUtil.checkSmilFile((de.uhh.l2g.plugins.model.Video)arguments[0]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return VideoLocalServiceUtil.fileStringSegmentFoundInArray((java.lang.String)arguments[0],
				(org.json.JSONArray)arguments[1]);
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			VideoLocalServiceUtil.createSymLinkForCaptionIfExisting((java.lang.Long)arguments[0]);

			return null;
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return VideoLocalServiceUtil.isSymlink((java.io.File)arguments[0]);
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return VideoLocalServiceUtil.retrieveLanguageDisplayNameOfCaptionFile((java.io.File)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
	private String _methodName204;
	private String[] _methodParameterTypes204;
	private String _methodName205;
	private String[] _methodParameterTypes205;
	private String _methodName206;
	private String[] _methodParameterTypes206;
	private String _methodName207;
	private String[] _methodParameterTypes207;
	private String _methodName208;
	private String[] _methodParameterTypes208;
	private String _methodName209;
	private String[] _methodParameterTypes209;
	private String _methodName211;
	private String[] _methodParameterTypes211;
	private String _methodName212;
	private String[] _methodParameterTypes212;
	private String _methodName213;
	private String[] _methodParameterTypes213;
	private String _methodName214;
	private String[] _methodParameterTypes214;
	private String _methodName215;
	private String[] _methodParameterTypes215;
	private String _methodName216;
	private String[] _methodParameterTypes216;
}