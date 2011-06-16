/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.hr.model.impl;

import com.liferay.hr.model.HRUserTimeOff;
import com.liferay.hr.model.HRUserTimeOffModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the HRUserTimeOff service. Represents a row in the &quot;HRUserTimeOff&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hr.model.HRUserTimeOffModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HRUserTimeOffImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRUserTimeOffImpl
 * @see com.liferay.hr.model.HRUserTimeOff
 * @see com.liferay.hr.model.HRUserTimeOffModel
 * @generated
 */
public class HRUserTimeOffModelImpl extends BaseModelImpl<HRUserTimeOff>
	implements HRUserTimeOffModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h r user time off model instance should use the {@link com.liferay.hr.model.HRUserTimeOff} interface instead.
	 */
	public static final String TABLE_NAME = "HRUserTimeOff";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hrUserTimeOffId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "hrTimeOffTypeId", Types.BIGINT },
			{ "hrUserId", Types.BIGINT },
			{ "year", Types.INTEGER },
			{ "hoursAllowed", Types.DOUBLE },
			{ "hoursAccrued", Types.DOUBLE },
			{ "hoursCarriedOver", Types.DOUBLE },
			{ "hoursUsed", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table HRUserTimeOff (hrUserTimeOffId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,hrTimeOffTypeId LONG,hrUserId LONG,year INTEGER,hoursAllowed DOUBLE,hoursAccrued DOUBLE,hoursCarriedOver DOUBLE,hoursUsed DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table HRUserTimeOff";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hr.model.HRUserTimeOff"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hr.model.HRUserTimeOff"),
			true);

	public Class<?> getModelClass() {
		return HRUserTimeOff.class;
	}

	public String getModelClassName() {
		return HRUserTimeOff.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hr.model.HRUserTimeOff"));

	public HRUserTimeOffModelImpl() {
	}

	public long getPrimaryKey() {
		return _hrUserTimeOffId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHrUserTimeOffId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hrUserTimeOffId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHrUserTimeOffId() {
		return _hrUserTimeOffId;
	}

	public void setHrUserTimeOffId(long hrUserTimeOffId) {
		_hrUserTimeOffId = hrUserTimeOffId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getHrTimeOffTypeId() {
		return _hrTimeOffTypeId;
	}

	public void setHrTimeOffTypeId(long hrTimeOffTypeId) {
		_hrTimeOffTypeId = hrTimeOffTypeId;
	}

	public long getHrUserId() {
		return _hrUserId;
	}

	public void setHrUserId(long hrUserId) {
		_hrUserId = hrUserId;
	}

	public String getHrUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getHrUserId(), "uuid", _hrUserUuid);
	}

	public void setHrUserUuid(String hrUserUuid) {
		_hrUserUuid = hrUserUuid;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public double getHoursAllowed() {
		return _hoursAllowed;
	}

	public void setHoursAllowed(double hoursAllowed) {
		_hoursAllowed = hoursAllowed;
	}

	public double getHoursAccrued() {
		return _hoursAccrued;
	}

	public void setHoursAccrued(double hoursAccrued) {
		_hoursAccrued = hoursAccrued;
	}

	public double getHoursCarriedOver() {
		return _hoursCarriedOver;
	}

	public void setHoursCarriedOver(double hoursCarriedOver) {
		_hoursCarriedOver = hoursCarriedOver;
	}

	public double getHoursUsed() {
		return _hoursUsed;
	}

	public void setHoursUsed(double hoursUsed) {
		_hoursUsed = hoursUsed;
	}

	@Override
	public HRUserTimeOff toEscapedModel() {
		if (isEscapedModel()) {
			return (HRUserTimeOff)this;
		}
		else {
			return (HRUserTimeOff)Proxy.newProxyInstance(_classLoader,
				_escapedModelProxyInterfaces, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					HRUserTimeOff.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		HRUserTimeOffImpl hrUserTimeOffImpl = new HRUserTimeOffImpl();

		hrUserTimeOffImpl.setHrUserTimeOffId(getHrUserTimeOffId());
		hrUserTimeOffImpl.setGroupId(getGroupId());
		hrUserTimeOffImpl.setCompanyId(getCompanyId());
		hrUserTimeOffImpl.setUserId(getUserId());
		hrUserTimeOffImpl.setUserName(getUserName());
		hrUserTimeOffImpl.setCreateDate(getCreateDate());
		hrUserTimeOffImpl.setModifiedDate(getModifiedDate());
		hrUserTimeOffImpl.setHrTimeOffTypeId(getHrTimeOffTypeId());
		hrUserTimeOffImpl.setHrUserId(getHrUserId());
		hrUserTimeOffImpl.setYear(getYear());
		hrUserTimeOffImpl.setHoursAllowed(getHoursAllowed());
		hrUserTimeOffImpl.setHoursAccrued(getHoursAccrued());
		hrUserTimeOffImpl.setHoursCarriedOver(getHoursCarriedOver());
		hrUserTimeOffImpl.setHoursUsed(getHoursUsed());

		hrUserTimeOffImpl.resetOriginalValues();

		return hrUserTimeOffImpl;
	}

	public int compareTo(HRUserTimeOff hrUserTimeOff) {
		long primaryKey = hrUserTimeOff.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HRUserTimeOff hrUserTimeOff = null;

		try {
			hrUserTimeOff = (HRUserTimeOff)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hrUserTimeOff.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{hrUserTimeOffId=");
		sb.append(getHrUserTimeOffId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", hrTimeOffTypeId=");
		sb.append(getHrTimeOffTypeId());
		sb.append(", hrUserId=");
		sb.append(getHrUserId());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", hoursAllowed=");
		sb.append(getHoursAllowed());
		sb.append(", hoursAccrued=");
		sb.append(getHoursAccrued());
		sb.append(", hoursCarriedOver=");
		sb.append(getHoursCarriedOver());
		sb.append(", hoursUsed=");
		sb.append(getHoursUsed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hr.model.HRUserTimeOff");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hrUserTimeOffId</column-name><column-value><![CDATA[");
		sb.append(getHrUserTimeOffId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hrTimeOffTypeId</column-name><column-value><![CDATA[");
		sb.append(getHrTimeOffTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hrUserId</column-name><column-value><![CDATA[");
		sb.append(getHrUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursAllowed</column-name><column-value><![CDATA[");
		sb.append(getHoursAllowed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursAccrued</column-name><column-value><![CDATA[");
		sb.append(getHoursAccrued());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursCarriedOver</column-name><column-value><![CDATA[");
		sb.append(getHoursCarriedOver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursUsed</column-name><column-value><![CDATA[");
		sb.append(getHoursUsed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = HRUserTimeOff.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			HRUserTimeOff.class
		};
	private long _hrUserTimeOffId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _hrTimeOffTypeId;
	private long _hrUserId;
	private String _hrUserUuid;
	private int _year;
	private double _hoursAllowed;
	private double _hoursAccrued;
	private double _hoursCarriedOver;
	private double _hoursUsed;
	private transient ExpandoBridge _expandoBridge;
}