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

import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class Lectureseries_InstitutionLocalServiceClpInvoker {
	public Lectureseries_InstitutionLocalServiceClpInvoker() {
		_methodName0 = "addLectureseries_Institution";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries_Institution"
			};

		_methodName1 = "createLectureseries_Institution";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLectureseries_Institution";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLectureseries_Institution";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries_Institution"
			};

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

		_methodName10 = "fetchLectureseries_Institution";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLectureseries_Institution";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLectureseries_Institutions";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLectureseries_InstitutionsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLectureseries_Institution";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries_Institution"
			};

<<<<<<< HEAD
		_methodName162 = "getBeanIdentifier";
=======
		_methodName166 = "getBeanIdentifier";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes162 = new String[] {  };
=======
		_methodParameterTypes166 = new String[] {  };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName163 = "setBeanIdentifier";
=======
		_methodName167 = "setBeanIdentifier";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes163 = new String[] { "java.lang.String" };
=======
		_methodParameterTypes167 = new String[] { "java.lang.String" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName168 = "removeByLectureseriesId";
=======
		_methodName172 = "removeByLectureseriesId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes168 = new String[] { "java.lang.Long" };
=======
		_methodParameterTypes172 = new String[] { "java.lang.Long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName169 = "removeByacilityId";
=======
		_methodName173 = "removeByacilityId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes169 = new String[] { "java.lang.Long" };
=======
		_methodParameterTypes173 = new String[] { "java.lang.Long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName170 = "institutionAssignedToLectureseries";
=======
		_methodName174 = "institutionAssignedToLectureseries";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes170 = new String[] {
=======
		_methodParameterTypes174 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"de.uhh.l2g.plugins.model.Lectureseries_Institution"
			};

<<<<<<< HEAD
		_methodName171 = "getByLectureseries";
=======
		_methodName175 = "getByLectureseries";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes171 = new String[] { "long" };
=======
		_methodParameterTypes175 = new String[] { "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName172 = "findFirstByLectureseriesIdAndInstitutionId";
=======
		_methodName176 = "findFirstByLectureseriesIdAndInstitutionId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes172 = new String[] { "long", "long" };
=======
		_methodParameterTypes176 = new String[] { "long", "long" };
>>>>>>> refs/remotes/l2go@github/master
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution((de.uhh.l2g.plugins.model.Lectureseries_Institution)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.createLectureseries_Institution(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.deleteLectureseries_Institution(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.deleteLectureseries_Institution((de.uhh.l2g.plugins.model.Lectureseries_Institution)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.fetchLectureseries_Institution(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.getLectureseries_Institution(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.getLectureseries_Institutions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.getLectureseries_InstitutionsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.updateLectureseries_Institution((de.uhh.l2g.plugins.model.Lectureseries_Institution)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
=======
		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return Lectureseries_InstitutionLocalServiceUtil.getBeanIdentifier();
		}

<<<<<<< HEAD
		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
=======
		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			Lectureseries_InstitutionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId((java.lang.Long)arguments[0]);
=======
		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId((java.lang.Long)arguments[0]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.removeByacilityId((java.lang.Long)arguments[0]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.institutionAssignedToLectureseries((de.uhh.l2g.plugins.model.Lectureseries_Institution)arguments[0]);
>>>>>>> refs/remotes/l2go@github/master
		}

<<<<<<< HEAD
		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.removeByacilityId((java.lang.Long)arguments[0]);
=======
		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(((Long)arguments[0]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

<<<<<<< HEAD
		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.institutionAssignedToLectureseries((de.uhh.l2g.plugins.model.Lectureseries_Institution)arguments[0]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(((Long)arguments[0]).longValue());
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
=======
		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return Lectureseries_InstitutionLocalServiceUtil.findFirstByLectureseriesIdAndInstitutionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
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
	private String _methodName172;
	private String[] _methodParameterTypes172;
=======
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
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
>>>>>>> refs/remotes/l2go@github/master
}