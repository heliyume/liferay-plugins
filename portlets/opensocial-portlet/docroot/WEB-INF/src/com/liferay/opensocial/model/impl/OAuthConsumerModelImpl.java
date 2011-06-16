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

package com.liferay.opensocial.model.impl;

import com.liferay.opensocial.model.OAuthConsumer;
import com.liferay.opensocial.model.OAuthConsumerModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the OAuthConsumer service. Represents a row in the &quot;OpenSocial_OAuthConsumer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.opensocial.model.OAuthConsumerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OAuthConsumerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConsumerImpl
 * @see com.liferay.opensocial.model.OAuthConsumer
 * @see com.liferay.opensocial.model.OAuthConsumerModel
 * @generated
 */
public class OAuthConsumerModelImpl extends BaseModelImpl<OAuthConsumer>
	implements OAuthConsumerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a o auth consumer model instance should use the {@link com.liferay.opensocial.model.OAuthConsumer} interface instead.
	 */
	public static final String TABLE_NAME = "OpenSocial_OAuthConsumer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "oAuthConsumerId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "gadgetId", Types.BIGINT },
			{ "serviceName", Types.VARCHAR },
			{ "consumerKey", Types.VARCHAR },
			{ "consumerSecret", Types.CLOB },
			{ "keyType", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table OpenSocial_OAuthConsumer (oAuthConsumerId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,gadgetId LONG,serviceName VARCHAR(75) null,consumerKey VARCHAR(75) null,consumerSecret TEXT null,keyType VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table OpenSocial_OAuthConsumer";
	public static final String ORDER_BY_JPQL = " ORDER BY oAuthConsumer.serviceName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY OpenSocial_OAuthConsumer.serviceName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.opensocial.model.OAuthConsumer"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.opensocial.model.OAuthConsumer"),
			true);

	public Class<?> getModelClass() {
		return OAuthConsumer.class;
	}

	public String getModelClassName() {
		return OAuthConsumer.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.opensocial.model.OAuthConsumer"));

	public OAuthConsumerModelImpl() {
	}

	public long getPrimaryKey() {
		return _oAuthConsumerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOAuthConsumerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_oAuthConsumerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getOAuthConsumerId() {
		return _oAuthConsumerId;
	}

	public void setOAuthConsumerId(long oAuthConsumerId) {
		_oAuthConsumerId = oAuthConsumerId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getGadgetId() {
		return _gadgetId;
	}

	public void setGadgetId(long gadgetId) {
		if (!_setOriginalGadgetId) {
			_setOriginalGadgetId = true;

			_originalGadgetId = _gadgetId;
		}

		_gadgetId = gadgetId;
	}

	public long getOriginalGadgetId() {
		return _originalGadgetId;
	}

	public String getServiceName() {
		if (_serviceName == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceName;
		}
	}

	public void setServiceName(String serviceName) {
		if (_originalServiceName == null) {
			_originalServiceName = _serviceName;
		}

		_serviceName = serviceName;
	}

	public String getOriginalServiceName() {
		return GetterUtil.getString(_originalServiceName);
	}

	public String getConsumerKey() {
		if (_consumerKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _consumerKey;
		}
	}

	public void setConsumerKey(String consumerKey) {
		_consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		if (_consumerSecret == null) {
			return StringPool.BLANK;
		}
		else {
			return _consumerSecret;
		}
	}

	public void setConsumerSecret(String consumerSecret) {
		_consumerSecret = consumerSecret;
	}

	public String getKeyType() {
		if (_keyType == null) {
			return StringPool.BLANK;
		}
		else {
			return _keyType;
		}
	}

	public void setKeyType(String keyType) {
		_keyType = keyType;
	}

	@Override
	public OAuthConsumer toEscapedModel() {
		if (isEscapedModel()) {
			return (OAuthConsumer)this;
		}
		else {
			return (OAuthConsumer)Proxy.newProxyInstance(_classLoader,
				_escapedModelProxyInterfaces, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					OAuthConsumer.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		OAuthConsumerImpl oAuthConsumerImpl = new OAuthConsumerImpl();

		oAuthConsumerImpl.setOAuthConsumerId(getOAuthConsumerId());
		oAuthConsumerImpl.setCompanyId(getCompanyId());
		oAuthConsumerImpl.setCreateDate(getCreateDate());
		oAuthConsumerImpl.setModifiedDate(getModifiedDate());
		oAuthConsumerImpl.setGadgetId(getGadgetId());
		oAuthConsumerImpl.setServiceName(getServiceName());
		oAuthConsumerImpl.setConsumerKey(getConsumerKey());
		oAuthConsumerImpl.setConsumerSecret(getConsumerSecret());
		oAuthConsumerImpl.setKeyType(getKeyType());

		oAuthConsumerImpl.resetOriginalValues();

		return oAuthConsumerImpl;
	}

	public int compareTo(OAuthConsumer oAuthConsumer) {
		int value = 0;

		value = getServiceName().compareTo(oAuthConsumer.getServiceName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OAuthConsumer oAuthConsumer = null;

		try {
			oAuthConsumer = (OAuthConsumer)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = oAuthConsumer.getPrimaryKey();

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
		OAuthConsumerModelImpl oAuthConsumerModelImpl = this;

		oAuthConsumerModelImpl._originalGadgetId = oAuthConsumerModelImpl._gadgetId;

		oAuthConsumerModelImpl._setOriginalGadgetId = false;

		oAuthConsumerModelImpl._originalServiceName = oAuthConsumerModelImpl._serviceName;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{oAuthConsumerId=");
		sb.append(getOAuthConsumerId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", gadgetId=");
		sb.append(getGadgetId());
		sb.append(", serviceName=");
		sb.append(getServiceName());
		sb.append(", consumerKey=");
		sb.append(getConsumerKey());
		sb.append(", consumerSecret=");
		sb.append(getConsumerSecret());
		sb.append(", keyType=");
		sb.append(getKeyType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.opensocial.model.OAuthConsumer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>oAuthConsumerId</column-name><column-value><![CDATA[");
		sb.append(getOAuthConsumerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>gadgetId</column-name><column-value><![CDATA[");
		sb.append(getGadgetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceName</column-name><column-value><![CDATA[");
		sb.append(getServiceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerKey</column-name><column-value><![CDATA[");
		sb.append(getConsumerKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerSecret</column-name><column-value><![CDATA[");
		sb.append(getConsumerSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keyType</column-name><column-value><![CDATA[");
		sb.append(getKeyType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OAuthConsumer.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			OAuthConsumer.class
		};
	private long _oAuthConsumerId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _gadgetId;
	private long _originalGadgetId;
	private boolean _setOriginalGadgetId;
	private String _serviceName;
	private String _originalServiceName;
	private String _consumerKey;
	private String _consumerSecret;
	private String _keyType;
	private transient ExpandoBridge _expandoBridge;
}