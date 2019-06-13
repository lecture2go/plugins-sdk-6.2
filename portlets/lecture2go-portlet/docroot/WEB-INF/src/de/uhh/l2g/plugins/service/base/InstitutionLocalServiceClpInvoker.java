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

import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class InstitutionLocalServiceClpInvoker {
	public InstitutionLocalServiceClpInvoker() {
		_methodName0 = "addInstitution";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.Institution"
			};

		_methodName1 = "createInstitution";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteInstitution";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteInstitution";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.Institution"
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

		_methodName10 = "fetchInstitution";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getInstitution";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getInstitutions";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getInstitutionsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateInstitution";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Institution"
			};

		_methodName152 = "getBeanIdentifier";

		_methodParameterTypes152 = new String[] {  };

		_methodName153 = "setBeanIdentifier";

		_methodParameterTypes153 = new String[] { "java.lang.String" };

		_methodName158 = "getById";

		_methodParameterTypes158 = new String[] { "long" };

		_methodName159 = "getRootInstitutionsByOpenAccessVideos";

		_methodParameterTypes159 = new String[] {  };

		_methodName160 = "getByParentIdList";

		_methodParameterTypes160 = new String[] { "long" };

		_methodName161 = "getByParentIdCount";

		_methodParameterTypes161 = new String[] { "long" };

		_methodName162 = "getByParentId";

		_methodParameterTypes162 = new String[] { "long" };

		_methodName163 = "getRoot";

		_methodParameterTypes163 = new String[] {  };

		_methodName164 = "getByParentIdMap";

		_methodParameterTypes164 = new String[] { "long" };

		_methodName165 = "getByLevel";

		_methodParameterTypes165 = new String[] { "int" };

		_methodName166 = "getByLectureseriesId";

		_methodParameterTypes166 = new String[] { "long", "int", "int" };

		_methodName167 = "getAllSortedAsTree";

		_methodParameterTypes167 = new String[] { "int", "int" };

		_methodName168 = "getMaxSortByParentId";

		_methodParameterTypes168 = new String[] { "long" };

		_methodName169 = "getLockingElements";

		_methodParameterTypes169 = new String[] { "long" };

		_methodName170 = "getInstitutionsFromLectureseriesIdsAndVideoIds";

		_methodParameterTypes170 = new String[] {
				"java.util.ArrayList", "java.util.ArrayList"
			};

		_methodName171 = "getInstitutionsFromLectureseriesIdsAndVideoIds";

		_methodParameterTypes171 = new String[] {
				"java.util.ArrayList", "java.util.ArrayList", "java.lang.Long"
			};

		_methodName178 = "getDefaultInstitutionId";

		_methodParameterTypes178 = new String[] {  };

		_methodName179 = "addDefaultInstitution";

		_methodParameterTypes179 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName180 = "addInstitution";

		_methodParameterTypes180 = new String[] {
				"java.lang.String", "long", "long", "int"
			};

		_methodName181 = "updateInstitution";

		_methodParameterTypes181 = new String[] {
				"long", "java.lang.String", "int"
			};

		_methodName182 = "removeByInstitutionId";

		_methodParameterTypes182 = new String[] { "java.lang.Long" };

		_methodName183 = "deleteInstitution";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "updateCounter";

		_methodParameterTypes184 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return InstitutionLocalServiceUtil.addInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return InstitutionLocalServiceUtil.createInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return InstitutionLocalServiceUtil.deleteInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return InstitutionLocalServiceUtil.deleteInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return InstitutionLocalServiceUtil.fetchInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return InstitutionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitutions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitutionsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return InstitutionLocalServiceUtil.updateInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0]);
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return InstitutionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			InstitutionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return InstitutionLocalServiceUtil.getById(((Long)arguments[0]).longValue());
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRootInstitutionsByOpenAccessVideos();
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByParentIdList(((Long)arguments[0]).longValue());
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByParentIdCount(((Long)arguments[0]).longValue());
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByParentId(((Long)arguments[0]).longValue());
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRoot();
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByParentIdMap(((Long)arguments[0]).longValue());
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByLevel(((Integer)arguments[0]).intValue());
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByLectureseriesId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return InstitutionLocalServiceUtil.getAllSortedAsTree(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return InstitutionLocalServiceUtil.getMaxSortByParentId(((Long)arguments[0]).longValue());
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return InstitutionLocalServiceUtil.getLockingElements(((Long)arguments[0]).longValue());
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds((java.util.ArrayList<java.lang.Long>)arguments[0],
				(java.util.ArrayList<java.lang.Long>)arguments[1]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds((java.util.ArrayList<java.lang.Long>)arguments[0],
				(java.util.ArrayList<java.lang.Long>)arguments[1],
				(java.lang.Long)arguments[2]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return InstitutionLocalServiceUtil.getDefaultInstitutionId();
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return InstitutionLocalServiceUtil.addDefaultInstitution((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return InstitutionLocalServiceUtil.addInstitution((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return InstitutionLocalServiceUtil.updateInstitution(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return InstitutionLocalServiceUtil.removeByInstitutionId((java.lang.Long)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return InstitutionLocalServiceUtil.deleteInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return InstitutionLocalServiceUtil.updateCounter();
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
	private String _methodName152;
	private String[] _methodParameterTypes152;
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName159;
	private String[] _methodParameterTypes159;
	private String _methodName160;
	private String[] _methodParameterTypes160;
	private String _methodName161;
	private String[] _methodParameterTypes161;
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName164;
	private String[] _methodParameterTypes164;
	private String _methodName165;
	private String[] _methodParameterTypes165;
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
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
}