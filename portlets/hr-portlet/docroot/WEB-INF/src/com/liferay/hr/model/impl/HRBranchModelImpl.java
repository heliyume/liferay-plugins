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

import com.liferay.hr.model.HRBranch;
import com.liferay.hr.model.HRBranchModel;

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
 * The base model implementation for the HRBranch service. Represents a row in the &quot;HRBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hr.model.HRBranchModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HRBranchImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRBranchImpl
 * @see com.liferay.hr.model.HRBranch
 * @see com.liferay.hr.model.HRBranchModel
 * @generated
 */
public class HRBranchModelImpl extends BaseModelImpl<HRBranch>
	implements HRBranchModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h r branch model instance should use the {@link com.liferay.hr.model.HRBranch} interface instead.
	 */
	public static final String TABLE_NAME = "HRBranch";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hrBranchId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "organizationId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table HRBranch (hrBranchId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,organizationId LONG)";
	public static final String TABLE_SQL_DROP = "drop table HRBranch";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hr.model.HRBranch"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hr.model.HRBranch"),
			true);

	public Class<?> getModelClass() {
		return HRBranch.class;
	}

	public String getModelClassName() {
		return HRBranch.class.getName();
	}

	public static final String MAPPING_TABLE_HRBRANCHES_HRJOBTITLES_NAME = "HRBranches_HRJobTitles";
	public static final Object[][] MAPPING_TABLE_HRBRANCHES_HRJOBTITLES_COLUMNS = {
			{ "hrBranchId", Types.BIGINT },
			{ "hrJobTitleId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_HRBRANCHES_HRJOBTITLES_SQL_CREATE = "create table HRBranches_HRJobTitles (hrBranchId LONG not null,hrJobTitleId LONG not null,primary key (hrBranchId, hrJobTitleId))";
	public static final boolean FINDER_CACHE_ENABLED_HRBRANCHES_HRJOBTITLES = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.HRBranches_HRJobTitles"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hr.model.HRBranch"));

	public HRBranchModelImpl() {
	}

	public long getPrimaryKey() {
		return _hrBranchId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHrBranchId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hrBranchId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHrBranchId() {
		return _hrBranchId;
	}

	public void setHrBranchId(long hrBranchId) {
		_hrBranchId = hrBranchId;
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

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	@Override
	public HRBranch toEscapedModel() {
		if (isEscapedModel()) {
			return (HRBranch)this;
		}
		else {
			return (HRBranch)Proxy.newProxyInstance(_classLoader,
				_escapedModelProxyInterfaces, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					HRBranch.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		HRBranchImpl hrBranchImpl = new HRBranchImpl();

		hrBranchImpl.setHrBranchId(getHrBranchId());
		hrBranchImpl.setGroupId(getGroupId());
		hrBranchImpl.setCompanyId(getCompanyId());
		hrBranchImpl.setUserId(getUserId());
		hrBranchImpl.setUserName(getUserName());
		hrBranchImpl.setCreateDate(getCreateDate());
		hrBranchImpl.setModifiedDate(getModifiedDate());
		hrBranchImpl.setOrganizationId(getOrganizationId());

		hrBranchImpl.resetOriginalValues();

		return hrBranchImpl;
	}

	public int compareTo(HRBranch hrBranch) {
		long primaryKey = hrBranch.getPrimaryKey();

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

		HRBranch hrBranch = null;

		try {
			hrBranch = (HRBranch)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hrBranch.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{hrBranchId=");
		sb.append(getHrBranchId());
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
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hr.model.HRBranch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hrBranchId</column-name><column-value><![CDATA[");
		sb.append(getHrBranchId());
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
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = HRBranch.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			HRBranch.class
		};
	private long _hrBranchId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _organizationId;
	private transient ExpandoBridge _expandoBridge;
}