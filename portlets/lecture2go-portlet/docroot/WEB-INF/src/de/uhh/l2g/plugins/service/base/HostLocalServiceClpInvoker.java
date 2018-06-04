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

import de.uhh.l2g.plugins.service.HostLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class HostLocalServiceClpInvoker {
	public HostLocalServiceClpInvoker() {
		_methodName0 = "addHost";

		_methodParameterTypes0 = new String[] { "de.uhh.l2g.plugins.model.Host" };

		_methodName1 = "createHost";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteHost";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteHost";

		_methodParameterTypes3 = new String[] { "de.uhh.l2g.plugins.model.Host" };

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

		_methodName10 = "fetchHost";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getHost";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getHosts";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getHostsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateHost";

		_methodParameterTypes15 = new String[] { "de.uhh.l2g.plugins.model.Host" };

		_methodName156 = "getBeanIdentifier";

		_methodParameterTypes156 = new String[] {  };

		_methodName157 = "setBeanIdentifier";

		_methodParameterTypes157 = new String[] { "java.lang.String" };

		_methodName162 = "getByInstitution";

		_methodParameterTypes162 = new String[] { "long" };

		_methodName163 = "getByHostId";

		_methodParameterTypes163 = new String[] { "long" };

		_methodName164 = "getByGroupId";

		_methodParameterTypes164 = new String[] { "long" };

		_methodName165 = "getByGroupId";

		_methodParameterTypes165 = new String[] { "long", "int", "int" };

		_methodName166 = "getByGroupIdCount";

		_methodParameterTypes166 = new String[] { "long" };

		_methodName167 = "getByGroupIdAndHostId";

		_methodParameterTypes167 = new String[] { "long", "long" };

		_methodName168 = "getByCompanyIdAndGroupId";

		_methodParameterTypes168 = new String[] { "long", "long" };

		_methodName169 = "getByDefault";

		_methodParameterTypes169 = new String[] { "long", "long" };

		_methodName170 = "getDefaultHostId";

		_methodParameterTypes170 = new String[] { "long", "long" };

		_methodName171 = "getLockingElements";

		_methodParameterTypes171 = new String[] { "long", "long" };

		_methodName173 = "addDefaultHost";

		_methodParameterTypes173 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName174 = "addHost";

		_methodParameterTypes174 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "com.liferay.portal.service.ServiceContext"
			};

		_methodName175 = "updateHost";

		_methodParameterTypes175 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName176 = "deleteHost";

		_methodParameterTypes176 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName177 = "updateCounter";

		_methodParameterTypes177 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return HostLocalServiceUtil.addHost((de.uhh.l2g.plugins.model.Host)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return HostLocalServiceUtil.createHost(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return HostLocalServiceUtil.deleteHost(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return HostLocalServiceUtil.deleteHost((de.uhh.l2g.plugins.model.Host)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return HostLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return HostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return HostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return HostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return HostLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return HostLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return HostLocalServiceUtil.fetchHost(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return HostLocalServiceUtil.getHost(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return HostLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return HostLocalServiceUtil.getHosts(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return HostLocalServiceUtil.getHostsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return HostLocalServiceUtil.updateHost((de.uhh.l2g.plugins.model.Host)arguments[0]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return HostLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			HostLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return HostLocalServiceUtil.getByInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return HostLocalServiceUtil.getByHostId(((Long)arguments[0]).longValue());
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return HostLocalServiceUtil.getByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return HostLocalServiceUtil.getByGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return HostLocalServiceUtil.getByGroupIdCount(((Long)arguments[0]).longValue());
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return HostLocalServiceUtil.getByGroupIdAndHostId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return HostLocalServiceUtil.getByCompanyIdAndGroupId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return HostLocalServiceUtil.getByDefault(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return HostLocalServiceUtil.getDefaultHostId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return HostLocalServiceUtil.getLockingElements(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return HostLocalServiceUtil.addDefaultHost((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return HostLocalServiceUtil.addHost((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return HostLocalServiceUtil.updateHost(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return HostLocalServiceUtil.deleteHost(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return HostLocalServiceUtil.updateCounter();
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
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName157;
	private String[] _methodParameterTypes157;
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
}