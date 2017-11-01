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

<<<<<<< HEAD
		_methodName162 = "getBeanIdentifier";

		_methodParameterTypes162 = new String[] {  };

		_methodName163 = "setBeanIdentifier";

		_methodParameterTypes163 = new String[] { "java.lang.String" };

		_methodName168 = "getAllCreators";
=======
		_methodName166 = "getBeanIdentifier";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes168 = new String[] {  };

<<<<<<< HEAD
		_methodName169 = "getCreatorsByLectureseriesId";
=======
		_methodName167 = "setBeanIdentifier";

		_methodParameterTypes167 = new String[] { "java.lang.String" };

		_methodName172 = "getAllCreators";

		_methodParameterTypes172 = new String[] {  };

		_methodName173 = "getCreatorsByLectureseriesId";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes173 = new String[] { "java.lang.Long" };

<<<<<<< HEAD
		_methodName170 = "getCreatorsByLectureseriesIdForOpenAccessVideosOnly";
=======
		_methodName174 = "getCreatorsByLectureseriesIdForOpenAccessVideosOnly";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes174 = new String[] { "java.lang.Long" };

<<<<<<< HEAD
		_methodName171 = "getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators";
=======
		_methodName175 = "getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes171 = new String[] { "java.lang.Long", "int" };
=======
		_methodParameterTypes175 = new String[] { "java.lang.Long", "int" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName172 = "getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators";
=======
		_methodName176 = "getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes172 = new String[] { "java.lang.Long", "int" };
=======
		_methodParameterTypes176 = new String[] { "java.lang.Long", "int" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName173 = "getCreatorsByVideoId";
=======
		_methodName177 = "getCreatorsByVideoId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes173 = new String[] { "java.lang.Long" };

		_methodName174 = "getCreatorsForLectureseriesOverTheAssigenedVideos";

		_methodParameterTypes174 = new String[] { "java.lang.Long" };

		_methodName175 = "updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId";

		_methodParameterTypes175 = new String[] { "java.lang.Long" };

		_methodName176 = "getCommaSeparatedCreatorsByVideoIdAndMaxCreators";

		_methodParameterTypes176 = new String[] { "java.lang.Long", "int" };

		_methodName177 = "getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators";

		_methodParameterTypes177 = new String[] { "java.lang.Long", "int" };

		_methodName180 = "getJSONCreatorsByVideoId";

		_methodParameterTypes180 = new String[] { "java.lang.Long" };

		_methodName181 = "getJSONCreatorsByLectureseriesId";

		_methodParameterTypes181 = new String[] { "java.lang.Long" };

		_methodName182 = "getJSONCreator";

		_methodParameterTypes182 = new String[] { "java.lang.Long" };

		_methodName183 = "getByFullName";

		_methodParameterTypes183 = new String[] { "java.lang.String" };

		_methodName184 = "getCreatorsFromLectureseriesIdsAndVideoIds";

		_methodParameterTypes184 = new String[] {
=======
		_methodParameterTypes177 = new String[] { "java.lang.Long" };

		_methodName178 = "getCreatorsForLectureseriesOverTheAssigenedVideos";

		_methodParameterTypes178 = new String[] { "java.lang.Long" };

		_methodName179 = "updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId";

		_methodParameterTypes179 = new String[] { "java.lang.Long" };

		_methodName180 = "getCommaSeparatedCreatorsByVideoIdAndMaxCreators";

		_methodParameterTypes180 = new String[] { "java.lang.Long", "int" };

		_methodName181 = "getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators";

		_methodParameterTypes181 = new String[] { "java.lang.Long", "int" };

		_methodName184 = "getJSONCreatorsByVideoId";

		_methodParameterTypes184 = new String[] { "java.lang.Long" };

		_methodName185 = "getJSONCreatorsByLectureseriesId";

		_methodParameterTypes185 = new String[] { "java.lang.Long" };

		_methodName186 = "getJSONCreator";

		_methodParameterTypes186 = new String[] { "java.lang.Long" };

		_methodName187 = "getByFullName";

		_methodParameterTypes187 = new String[] { "java.lang.String" };

		_methodName188 = "getCreatorsFromLectureseriesIdsAndVideoIds";

		_methodParameterTypes188 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"java.util.ArrayList", "java.util.ArrayList"
			};

<<<<<<< HEAD
		_methodName185 = "deleteById";
=======
		_methodName189 = "deleteById";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes185 = new String[] { "java.lang.Long" };
=======
		_methodParameterTypes189 = new String[] { "java.lang.Long" };
>>>>>>> refs/remotes/l2go@github/master
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

<<<<<<< HEAD
		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
=======
		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return CreatorLocalServiceUtil.getBeanIdentifier();
		}

<<<<<<< HEAD
		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
=======
		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			CreatorLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return CreatorLocalServiceUtil.getAllCreators();
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsByLectureseriesIdForOpenAccessVideosOnly((java.lang.Long)arguments[0]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

=======
>>>>>>> refs/remotes/l2go@github/master
		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
<<<<<<< HEAD
			return CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
=======
			return CreatorLocalServiceUtil.getAllCreators();
>>>>>>> refs/remotes/l2go@github/master
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
<<<<<<< HEAD
			return CreatorLocalServiceUtil.getCreatorsByVideoId((java.lang.Long)arguments[0]);
=======
			return CreatorLocalServiceUtil.getCreatorsByLectureseriesId((java.lang.Long)arguments[0]);
>>>>>>> refs/remotes/l2go@github/master
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
<<<<<<< HEAD
			return CreatorLocalServiceUtil.getCreatorsForLectureseriesOverTheAssigenedVideos((java.lang.Long)arguments[0]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedCreatorsByVideoIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreatorsByVideoId((java.lang.Long)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreatorsByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreator((java.lang.Long)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return CreatorLocalServiceUtil.getByFullName((java.lang.String)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsFromLectureseriesIdsAndVideoIds((java.util.ArrayList<java.lang.Long>)arguments[0],
				(java.util.ArrayList<java.lang.Long>)arguments[1]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
=======
			return CreatorLocalServiceUtil.getCreatorsByLectureseriesIdForOpenAccessVideosOnly((java.lang.Long)arguments[0]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsByVideoId((java.lang.Long)arguments[0]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsForLectureseriesOverTheAssigenedVideos((java.lang.Long)arguments[0]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedCreatorsByVideoIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreatorsByVideoId((java.lang.Long)arguments[0]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreatorsByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return CreatorLocalServiceUtil.getJSONCreator((java.lang.Long)arguments[0]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return CreatorLocalServiceUtil.getByFullName((java.lang.String)arguments[0]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return CreatorLocalServiceUtil.getCreatorsFromLectureseriesIdsAndVideoIds((java.util.ArrayList<java.lang.Long>)arguments[0],
				(java.util.ArrayList<java.lang.Long>)arguments[1]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
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
<<<<<<< HEAD
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
=======
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
>>>>>>> refs/remotes/l2go@github/master
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
<<<<<<< HEAD
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
=======
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
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
>>>>>>> refs/remotes/l2go@github/master
}