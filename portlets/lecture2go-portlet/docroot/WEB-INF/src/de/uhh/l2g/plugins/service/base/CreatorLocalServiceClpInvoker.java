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

import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class CreatorLocalServiceClpInvoker {
	public CreatorLocalServiceClpInvoker() {
		_methodName0 = "addCreator";

		_methodParameterTypes0 = new String[] { "de.uhh.l2g.plugins.model.Creator" };

		_methodName1 = "createCreator";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteCreator";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteCreator";

		_methodParameterTypes3 = new String[] { "de.uhh.l2g.plugins.model.Creator" };

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

		_methodName10 = "fetchCreator";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getCreator";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getCreators";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getCreatorsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateCreator";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Creator"
			};

		_methodName172 = "getBeanIdentifier";

		_methodParameterTypes172 = new String[] {  };

		_methodName173 = "setBeanIdentifier";

		_methodParameterTypes173 = new String[] { "java.lang.String" };

		_methodName178 = "getAllCreators";

		_methodParameterTypes178 = new String[] {  };

		_methodName179 = "getCreatorsByLectureseriesId";

		_methodParameterTypes179 = new String[] { "java.lang.Long" };

		_methodName180 = "getCreatorsByLectureseriesIdForOpenAccessVideosOnly";

		_methodParameterTypes180 = new String[] { "java.lang.Long" };

		_methodName181 = "getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators";

		_methodParameterTypes181 = new String[] { "java.lang.Long", "int" };

		_methodName182 = "getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators";

		_methodParameterTypes182 = new String[] { "java.lang.Long", "int" };

		_methodName183 = "getCreatorsByVideoId";

		_methodParameterTypes183 = new String[] { "java.lang.Long" };

		_methodName184 = "getCreatorsForLectureseriesOverTheAssigenedVideos";

		_methodParameterTypes184 = new String[] { "java.lang.Long" };

		_methodName185 = "updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId";

		_methodParameterTypes185 = new String[] { "java.lang.Long" };

		_methodName186 = "updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId";

		_methodParameterTypes186 = new String[] {  };

		_methodName187 = "getCommaSeparatedCreatorsByVideoIdAndMaxCreators";

		_methodParameterTypes187 = new String[] { "java.lang.Long", "int" };

		_methodName188 = "getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators";

		_methodParameterTypes188 = new String[] { "java.lang.Long", "int" };

		_methodName191 = "getJSONCreatorsByVideoId";

		_methodParameterTypes191 = new String[] { "java.lang.Long" };

		_methodName192 = "getJSONCreatorsByLectureseriesId";

		_methodParameterTypes192 = new String[] { "java.lang.Long" };

		_methodName193 = "getJSONCreator";

		_methodParameterTypes193 = new String[] { "java.lang.Long" };

		_methodName194 = "getByFullName";

		_methodParameterTypes194 = new String[] { "java.lang.String" };

		_methodName195 = "getCreatorsFromLectureseriesIdsAndVideoIds";

		_methodParameterTypes195 = new String[] {
				"java.util.ArrayList", "java.util.ArrayList"
			};

		_methodName196 = "deleteById";

		_methodParameterTypes196 = new String[] { "java.lang.Long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return CreatorLocalServiceUtil.addCreator((de.uhh.l2g.plugins.model.Creator)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return CreatorLocalServiceUtil.createCreator(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return CreatorLocalServiceUtil.deleteCreator(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return CreatorLocalServiceUtil.deleteCreator((de.uhh.l2g.plugins.model.Creator)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return CreatorLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return CreatorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return CreatorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return CreatorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return CreatorLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return CreatorLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return CreatorLocalServiceUtil.fetchCreator(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreator(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return CreatorLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreators(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return CreatorLocalServiceUtil.updateCreator((de.uhh.l2g.plugins.model.Creator)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return CreatorLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			CreatorLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return CreatorLocalServiceUtil.getAllCreators();
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsByLectureseriesIdForOpenAccessVideosOnly((java.lang.Long)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsByVideoId((java.lang.Long)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsForLectureseriesOverTheAssigenedVideos((java.lang.Long)arguments[0]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			CreatorLocalServiceUtil.updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId();

			return null;
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedCreatorsByVideoIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreatorsByVideoId((java.lang.Long)arguments[0]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreatorsByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreator((java.lang.Long)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return CreatorLocalServiceUtil.getByFullName((java.lang.String)arguments[0]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsFromLectureseriesIdsAndVideoIds((java.util.ArrayList<java.lang.Long>)arguments[0],
				(java.util.ArrayList<java.lang.Long>)arguments[1]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			CreatorLocalServiceUtil.deleteById((java.lang.Long)arguments[0]);

			return null;
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
}