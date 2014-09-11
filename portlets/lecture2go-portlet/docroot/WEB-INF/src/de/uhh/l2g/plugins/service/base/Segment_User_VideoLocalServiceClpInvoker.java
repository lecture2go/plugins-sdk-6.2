/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import de.uhh.l2g.plugins.service.Segment_User_VideoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class Segment_User_VideoLocalServiceClpInvoker {
	public Segment_User_VideoLocalServiceClpInvoker() {
		_methodName0 = "addSegment_User_Video";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.Segment_User_Video"
			};

		_methodName1 = "createSegment_User_Video";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSegment_User_Video";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSegment_User_Video";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.Segment_User_Video"
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

		_methodName10 = "fetchSegment_User_Video";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSegment_User_Video";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSegment_User_Videos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSegment_User_VideosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSegment_User_Video";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Segment_User_Video"
			};

		_methodName106 = "getBeanIdentifier";

		_methodParameterTypes106 = new String[] {  };

		_methodName107 = "setBeanIdentifier";

		_methodParameterTypes107 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.addSegment_User_Video((de.uhh.l2g.plugins.model.Segment_User_Video)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.createSegment_User_Video(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.deleteSegment_User_Video(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.deleteSegment_User_Video((de.uhh.l2g.plugins.model.Segment_User_Video)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.fetchSegment_User_Video(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.getSegment_User_Video(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.getSegment_User_Videos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.getSegment_User_VideosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.updateSegment_User_Video((de.uhh.l2g.plugins.model.Segment_User_Video)arguments[0]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return Segment_User_VideoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			Segment_User_VideoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

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
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
}