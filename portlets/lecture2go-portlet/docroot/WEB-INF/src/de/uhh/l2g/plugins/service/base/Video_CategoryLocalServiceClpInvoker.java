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

import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class Video_CategoryLocalServiceClpInvoker {
	public Video_CategoryLocalServiceClpInvoker() {
		_methodName7 = "getBeanIdentifier";

		_methodParameterTypes7 = new String[] {  };

		_methodName8 = "setBeanIdentifier";

		_methodParameterTypes8 = new String[] { "java.lang.String" };

		_methodName9 = "getPersistedModel";

		_methodParameterTypes9 = new String[] { "java.io.Serializable" };

		_methodName10 = "addVideo_Category";

		_methodParameterTypes10 = new String[] {
				"de.uhh.l2g.plugins.model.Video_Category"
			};

		_methodName11 = "createVideo_Category";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "deleteVideo_Category";

		_methodParameterTypes12 = new String[] { "long" };

		_methodName13 = "deleteVideo_Category";

		_methodParameterTypes13 = new String[] {
				"de.uhh.l2g.plugins.model.Video_Category"
			};

		_methodName14 = "fetchVideo_Category";

		_methodParameterTypes14 = new String[] { "long" };

		_methodName15 = "getVideo_Category";

		_methodParameterTypes15 = new String[] { "long" };

		_methodName16 = "getVideo_Categories";

		_methodParameterTypes16 = new String[] { "int", "int" };

		_methodName17 = "getVideo_CategoriesCount";

		_methodParameterTypes17 = new String[] {  };

		_methodName18 = "updateVideo_Category";

		_methodParameterTypes18 = new String[] {
				"de.uhh.l2g.plugins.model.Video_Category"
			};

		_methodName19 = "dynamicQuery";

		_methodParameterTypes19 = new String[] {  };

		_methodName20 = "dynamicQuery";

		_methodParameterTypes20 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName21 = "dynamicQuery";

		_methodParameterTypes21 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName22 = "dynamicQuery";

		_methodParameterTypes22 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName23 = "dynamicQueryCount";

		_methodParameterTypes23 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName24 = "dynamicQueryCount";

		_methodParameterTypes24 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName157 = "getByVideo";

		_methodParameterTypes157 = new String[] { "java.lang.Long" };

		_methodName158 = "getByCategory";

		_methodParameterTypes158 = new String[] { "java.lang.Long" };

		_methodName159 = "removeByVideo";

		_methodParameterTypes159 = new String[] { "java.lang.Long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			Video_CategoryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.addVideo_Category((de.uhh.l2g.plugins.model.Video_Category)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.createVideo_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.deleteVideo_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.deleteVideo_Category((de.uhh.l2g.plugins.model.Video_Category)arguments[0]);
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.fetchVideo_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.getVideo_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.getVideo_Categories(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.getVideo_CategoriesCount();
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.updateVideo_Category((de.uhh.l2g.plugins.model.Video_Category)arguments[0]);
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.getByVideo((java.lang.Long)arguments[0]);
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return Video_CategoryLocalServiceUtil.getByCategory((java.lang.Long)arguments[0]);
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			Video_CategoryLocalServiceUtil.removeByVideo((java.lang.Long)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName157;
	private String[] _methodParameterTypes157;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName159;
	private String[] _methodParameterTypes159;
}