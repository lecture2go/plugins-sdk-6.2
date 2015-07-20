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

package de.uhh.l2g.plugins.migration.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import de.uhh.l2g.plugins.migration.model.LegacyContactClp;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacilityClp;
import de.uhh.l2g.plugins.migration.model.LegacyMetadataClp;
import de.uhh.l2g.plugins.migration.model.LegacyOfficeClp;
import de.uhh.l2g.plugins.migration.model.LegacySegmentClp;
import de.uhh.l2g.plugins.migration.model.LegacyUserClp;
import de.uhh.l2g.plugins.migration.model.TestEntityTwoClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author unihh
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"migration-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"migration-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "migration-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(LegacyContactClp.class.getName())) {
			return translateInputLegacyContact(oldModel);
		}

		if (oldModelClassName.equals(
					LegacyLectureSeriesFacilityClp.class.getName())) {
			return translateInputLegacyLectureSeriesFacility(oldModel);
		}

		if (oldModelClassName.equals(LegacyMetadataClp.class.getName())) {
			return translateInputLegacyMetadata(oldModel);
		}

		if (oldModelClassName.equals(LegacyOfficeClp.class.getName())) {
			return translateInputLegacyOffice(oldModel);
		}

		if (oldModelClassName.equals(LegacySegmentClp.class.getName())) {
			return translateInputLegacySegment(oldModel);
		}

		if (oldModelClassName.equals(LegacyUserClp.class.getName())) {
			return translateInputLegacyUser(oldModel);
		}

		if (oldModelClassName.equals(TestEntityTwoClp.class.getName())) {
			return translateInputTestEntityTwo(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputLegacyContact(BaseModel<?> oldModel) {
		LegacyContactClp oldClpModel = (LegacyContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyLectureSeriesFacility(
		BaseModel<?> oldModel) {
		LegacyLectureSeriesFacilityClp oldClpModel = (LegacyLectureSeriesFacilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyLectureSeriesFacilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyMetadata(BaseModel<?> oldModel) {
		LegacyMetadataClp oldClpModel = (LegacyMetadataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyMetadataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyOffice(BaseModel<?> oldModel) {
		LegacyOfficeClp oldClpModel = (LegacyOfficeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyOfficeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacySegment(BaseModel<?> oldModel) {
		LegacySegmentClp oldClpModel = (LegacySegmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacySegmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyUser(BaseModel<?> oldModel) {
		LegacyUserClp oldClpModel = (LegacyUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTestEntityTwo(BaseModel<?> oldModel) {
		TestEntityTwoClp oldClpModel = (TestEntityTwoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTestEntityTwoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyContactImpl")) {
			return translateOutputLegacyContact(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityImpl")) {
			return translateOutputLegacyLectureSeriesFacility(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataImpl")) {
			return translateOutputLegacyMetadata(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeImpl")) {
			return translateOutputLegacyOffice(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacySegmentImpl")) {
			return translateOutputLegacySegment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyUserImpl")) {
			return translateOutputLegacyUser(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoImpl")) {
			return translateOutputTestEntityTwo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyContactException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyContactException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyUserException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyUserException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException();
		}

		return throwable;
	}

	public static Object translateOutputLegacyContact(BaseModel<?> oldModel) {
		LegacyContactClp newModel = new LegacyContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyLectureSeriesFacility(
		BaseModel<?> oldModel) {
		LegacyLectureSeriesFacilityClp newModel = new LegacyLectureSeriesFacilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyLectureSeriesFacilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyMetadata(BaseModel<?> oldModel) {
		LegacyMetadataClp newModel = new LegacyMetadataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyMetadataRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyOffice(BaseModel<?> oldModel) {
		LegacyOfficeClp newModel = new LegacyOfficeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyOfficeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacySegment(BaseModel<?> oldModel) {
		LegacySegmentClp newModel = new LegacySegmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacySegmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyUser(BaseModel<?> oldModel) {
		LegacyUserClp newModel = new LegacyUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTestEntityTwo(BaseModel<?> oldModel) {
		TestEntityTwoClp newModel = new TestEntityTwoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTestEntityTwoRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}