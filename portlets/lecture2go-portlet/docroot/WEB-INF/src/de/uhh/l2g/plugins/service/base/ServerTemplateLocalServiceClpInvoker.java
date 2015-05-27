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

import de.uhh.l2g.plugins.service.ServerTemplateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class ServerTemplateLocalServiceClpInvoker {
	public ServerTemplateLocalServiceClpInvoker() {
		_methodName0 = "addServerTemplate";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.ServerTemplate"
			};

		_methodName1 = "createServerTemplate";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteServerTemplate";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteServerTemplate";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.ServerTemplate"
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

		_methodName10 = "fetchServerTemplate";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getServerTemplate";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getServerTemplates";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getServerTemplatesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateServerTemplate";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.ServerTemplate"
			};

		_methodName150 = "getBeanIdentifier";

		_methodParameterTypes150 = new String[] {  };

		_methodName151 = "setBeanIdentifier";

		_methodParameterTypes151 = new String[] { "java.lang.String" };

		_methodName156 = "getById";

		_methodParameterTypes156 = new String[] { "long" };

		_methodName157 = "getByGroupId";

		_methodParameterTypes157 = new String[] { "long" };

		_methodName158 = "getDeviceSpecificByServerTemplateId";

		_methodParameterTypes158 = new String[] { "long" };

		_methodName160 = "addServerTemplate";

		_methodParameterTypes160 = new String[] {
				"java.lang.String", "int", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.addServerTemplate((de.uhh.l2g.plugins.model.ServerTemplate)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.createServerTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.deleteServerTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.deleteServerTemplate((de.uhh.l2g.plugins.model.ServerTemplate)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.fetchServerTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getServerTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getServerTemplates(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getServerTemplatesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.updateServerTemplate((de.uhh.l2g.plugins.model.ServerTemplate)arguments[0]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			ServerTemplateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getById(((Long)arguments[0]).longValue());
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.getDeviceSpecificByServerTemplateId(((Long)arguments[0]).longValue());
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return ServerTemplateLocalServiceUtil.addServerTemplate((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
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
	private String _methodName150;
	private String[] _methodParameterTypes150;
	private String _methodName151;
	private String[] _methodParameterTypes151;
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName157;
	private String[] _methodParameterTypes157;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName160;
	private String[] _methodParameterTypes160;
}