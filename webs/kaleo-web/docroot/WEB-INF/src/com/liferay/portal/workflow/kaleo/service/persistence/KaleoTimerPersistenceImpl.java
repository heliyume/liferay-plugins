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

package com.liferay.portal.workflow.kaleo.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.workflow.kaleo.NoSuchTimerException;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoTimerImpl;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoTimerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the kaleo timer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTimerPersistence
 * @see KaleoTimerUtil
 * @generated
 */
public class KaleoTimerPersistenceImpl extends BasePersistenceImpl<KaleoTimer>
	implements KaleoTimerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KaleoTimerUtil} to access the kaleo timer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KaleoTimerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_PARENTKALEONODEID = new FinderPath(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByparentKaleoNodeId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTKALEONODEID = new FinderPath(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByparentKaleoNodeId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PKNI_DT = new FinderPath(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPKNI_DT",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PKNI_DT = new FinderPath(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPKNI_DT",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the kaleo timer in the entity cache if it is enabled.
	 *
	 * @param kaleoTimer the kaleo timer
	 */
	public void cacheResult(KaleoTimer kaleoTimer) {
		EntityCacheUtil.putResult(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerImpl.class, kaleoTimer.getPrimaryKey(), kaleoTimer);

		kaleoTimer.resetOriginalValues();
	}

	/**
	 * Caches the kaleo timers in the entity cache if it is enabled.
	 *
	 * @param kaleoTimers the kaleo timers
	 */
	public void cacheResult(List<KaleoTimer> kaleoTimers) {
		for (KaleoTimer kaleoTimer : kaleoTimers) {
			if (EntityCacheUtil.getResult(
						KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
						KaleoTimerImpl.class, kaleoTimer.getPrimaryKey(), this) == null) {
				cacheResult(kaleoTimer);
			}
		}
	}

	/**
	 * Clears the cache for all kaleo timers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KaleoTimerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KaleoTimerImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the kaleo timer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KaleoTimer kaleoTimer) {
		EntityCacheUtil.removeResult(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerImpl.class, kaleoTimer.getPrimaryKey());
	}

	/**
	 * Creates a new kaleo timer with the primary key. Does not add the kaleo timer to the database.
	 *
	 * @param kaleoTimerId the primary key for the new kaleo timer
	 * @return the new kaleo timer
	 */
	public KaleoTimer create(long kaleoTimerId) {
		KaleoTimer kaleoTimer = new KaleoTimerImpl();

		kaleoTimer.setNew(true);
		kaleoTimer.setPrimaryKey(kaleoTimerId);

		return kaleoTimer;
	}

	/**
	 * Removes the kaleo timer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kaleo timer
	 * @return the kaleo timer that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KaleoTimer remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the kaleo timer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoTimerId the primary key of the kaleo timer
	 * @return the kaleo timer that was removed
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer remove(long kaleoTimerId)
		throws NoSuchTimerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KaleoTimer kaleoTimer = (KaleoTimer)session.get(KaleoTimerImpl.class,
					Long.valueOf(kaleoTimerId));

			if (kaleoTimer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + kaleoTimerId);
				}

				throw new NoSuchTimerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					kaleoTimerId);
			}

			return kaleoTimerPersistence.remove(kaleoTimer);
		}
		catch (NoSuchTimerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the kaleo timer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoTimer the kaleo timer
	 * @return the kaleo timer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KaleoTimer remove(KaleoTimer kaleoTimer) throws SystemException {
		return super.remove(kaleoTimer);
	}

	@Override
	protected KaleoTimer removeImpl(KaleoTimer kaleoTimer)
		throws SystemException {
		kaleoTimer = toUnwrappedModel(kaleoTimer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, kaleoTimer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerImpl.class, kaleoTimer.getPrimaryKey());

		return kaleoTimer;
	}

	@Override
	public KaleoTimer updateImpl(
		com.liferay.portal.workflow.kaleo.model.KaleoTimer kaleoTimer,
		boolean merge) throws SystemException {
		kaleoTimer = toUnwrappedModel(kaleoTimer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, kaleoTimer, merge);

			kaleoTimer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
			KaleoTimerImpl.class, kaleoTimer.getPrimaryKey(), kaleoTimer);

		return kaleoTimer;
	}

	protected KaleoTimer toUnwrappedModel(KaleoTimer kaleoTimer) {
		if (kaleoTimer instanceof KaleoTimerImpl) {
			return kaleoTimer;
		}

		KaleoTimerImpl kaleoTimerImpl = new KaleoTimerImpl();

		kaleoTimerImpl.setNew(kaleoTimer.isNew());
		kaleoTimerImpl.setPrimaryKey(kaleoTimer.getPrimaryKey());

		kaleoTimerImpl.setKaleoTimerId(kaleoTimer.getKaleoTimerId());
		kaleoTimerImpl.setGroupId(kaleoTimer.getGroupId());
		kaleoTimerImpl.setCompanyId(kaleoTimer.getCompanyId());
		kaleoTimerImpl.setUserId(kaleoTimer.getUserId());
		kaleoTimerImpl.setUserName(kaleoTimer.getUserName());
		kaleoTimerImpl.setCreateDate(kaleoTimer.getCreateDate());
		kaleoTimerImpl.setModifiedDate(kaleoTimer.getModifiedDate());
		kaleoTimerImpl.setKaleoDefinitionId(kaleoTimer.getKaleoDefinitionId());
		kaleoTimerImpl.setKaleoNodeId(kaleoTimer.getKaleoNodeId());
		kaleoTimerImpl.setParentKaleoNodeId(kaleoTimer.getParentKaleoNodeId());
		kaleoTimerImpl.setName(kaleoTimer.getName());
		kaleoTimerImpl.setDefaultTimer(kaleoTimer.isDefaultTimer());
		kaleoTimerImpl.setDescription(kaleoTimer.getDescription());
		kaleoTimerImpl.setDuration(kaleoTimer.getDuration());
		kaleoTimerImpl.setScale(kaleoTimer.getScale());

		return kaleoTimerImpl;
	}

	/**
	 * Returns the kaleo timer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kaleo timer
	 * @return the kaleo timer
	 * @throws com.liferay.portal.NoSuchModelException if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KaleoTimer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the kaleo timer with the primary key or throws a {@link com.liferay.portal.workflow.kaleo.NoSuchTimerException} if it could not be found.
	 *
	 * @param kaleoTimerId the primary key of the kaleo timer
	 * @return the kaleo timer
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer findByPrimaryKey(long kaleoTimerId)
		throws NoSuchTimerException, SystemException {
		KaleoTimer kaleoTimer = fetchByPrimaryKey(kaleoTimerId);

		if (kaleoTimer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + kaleoTimerId);
			}

			throw new NoSuchTimerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				kaleoTimerId);
		}

		return kaleoTimer;
	}

	/**
	 * Returns the kaleo timer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kaleo timer
	 * @return the kaleo timer, or <code>null</code> if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KaleoTimer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the kaleo timer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kaleoTimerId the primary key of the kaleo timer
	 * @return the kaleo timer, or <code>null</code> if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer fetchByPrimaryKey(long kaleoTimerId)
		throws SystemException {
		KaleoTimer kaleoTimer = (KaleoTimer)EntityCacheUtil.getResult(KaleoTimerModelImpl.ENTITY_CACHE_ENABLED,
				KaleoTimerImpl.class, kaleoTimerId, this);

		if (kaleoTimer == null) {
			Session session = null;

			try {
				session = openSession();

				kaleoTimer = (KaleoTimer)session.get(KaleoTimerImpl.class,
						Long.valueOf(kaleoTimerId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (kaleoTimer != null) {
					cacheResult(kaleoTimer);
				}

				closeSession(session);
			}
		}

		return kaleoTimer;
	}

	/**
	 * Returns all the kaleo timers where parentKaleoNodeId = &#63;.
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @return the matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findByparentKaleoNodeId(long parentKaleoNodeId)
		throws SystemException {
		return findByparentKaleoNodeId(parentKaleoNodeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kaleo timers where parentKaleoNodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param start the lower bound of the range of kaleo timers
	 * @param end the upper bound of the range of kaleo timers (not inclusive)
	 * @return the range of matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findByparentKaleoNodeId(long parentKaleoNodeId,
		int start, int end) throws SystemException {
		return findByparentKaleoNodeId(parentKaleoNodeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kaleo timers where parentKaleoNodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param start the lower bound of the range of kaleo timers
	 * @param end the upper bound of the range of kaleo timers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findByparentKaleoNodeId(long parentKaleoNodeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				parentKaleoNodeId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoTimer> list = (List<KaleoTimer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PARENTKALEONODEID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_KALEOTIMER_WHERE);

			query.append(_FINDER_COLUMN_PARENTKALEONODEID_PARENTKALEONODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(KaleoTimerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentKaleoNodeId);

				list = (List<KaleoTimer>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_PARENTKALEONODEID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PARENTKALEONODEID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first kaleo timer in the ordered set where parentKaleoNodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo timer
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a matching kaleo timer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer findByparentKaleoNodeId_First(long parentKaleoNodeId,
		OrderByComparator orderByComparator)
		throws NoSuchTimerException, SystemException {
		List<KaleoTimer> list = findByparentKaleoNodeId(parentKaleoNodeId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentKaleoNodeId=");
			msg.append(parentKaleoNodeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTimerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last kaleo timer in the ordered set where parentKaleoNodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo timer
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a matching kaleo timer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer findByparentKaleoNodeId_Last(long parentKaleoNodeId,
		OrderByComparator orderByComparator)
		throws NoSuchTimerException, SystemException {
		int count = countByparentKaleoNodeId(parentKaleoNodeId);

		List<KaleoTimer> list = findByparentKaleoNodeId(parentKaleoNodeId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentKaleoNodeId=");
			msg.append(parentKaleoNodeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTimerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the kaleo timers before and after the current kaleo timer in the ordered set where parentKaleoNodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param kaleoTimerId the primary key of the current kaleo timer
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo timer
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer[] findByparentKaleoNodeId_PrevAndNext(long kaleoTimerId,
		long parentKaleoNodeId, OrderByComparator orderByComparator)
		throws NoSuchTimerException, SystemException {
		KaleoTimer kaleoTimer = findByPrimaryKey(kaleoTimerId);

		Session session = null;

		try {
			session = openSession();

			KaleoTimer[] array = new KaleoTimerImpl[3];

			array[0] = getByparentKaleoNodeId_PrevAndNext(session, kaleoTimer,
					parentKaleoNodeId, orderByComparator, true);

			array[1] = kaleoTimer;

			array[2] = getByparentKaleoNodeId_PrevAndNext(session, kaleoTimer,
					parentKaleoNodeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KaleoTimer getByparentKaleoNodeId_PrevAndNext(Session session,
		KaleoTimer kaleoTimer, long parentKaleoNodeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KALEOTIMER_WHERE);

		query.append(_FINDER_COLUMN_PARENTKALEONODEID_PARENTKALEONODEID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(KaleoTimerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentKaleoNodeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(kaleoTimer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KaleoTimer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the kaleo timers where parentKaleoNodeId = &#63; and defaultTimer = &#63;.
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @return the matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findByPKNI_DT(long parentKaleoNodeId,
		boolean defaultTimer) throws SystemException {
		return findByPKNI_DT(parentKaleoNodeId, defaultTimer,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kaleo timers where parentKaleoNodeId = &#63; and defaultTimer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @param start the lower bound of the range of kaleo timers
	 * @param end the upper bound of the range of kaleo timers (not inclusive)
	 * @return the range of matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findByPKNI_DT(long parentKaleoNodeId,
		boolean defaultTimer, int start, int end) throws SystemException {
		return findByPKNI_DT(parentKaleoNodeId, defaultTimer, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kaleo timers where parentKaleoNodeId = &#63; and defaultTimer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @param start the lower bound of the range of kaleo timers
	 * @param end the upper bound of the range of kaleo timers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findByPKNI_DT(long parentKaleoNodeId,
		boolean defaultTimer, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				parentKaleoNodeId, defaultTimer,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoTimer> list = (List<KaleoTimer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PKNI_DT,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_KALEOTIMER_WHERE);

			query.append(_FINDER_COLUMN_PKNI_DT_PARENTKALEONODEID_2);

			query.append(_FINDER_COLUMN_PKNI_DT_DEFAULTTIMER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(KaleoTimerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentKaleoNodeId);

				qPos.add(defaultTimer);

				list = (List<KaleoTimer>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_PKNI_DT,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PKNI_DT,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first kaleo timer in the ordered set where parentKaleoNodeId = &#63; and defaultTimer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kaleo timer
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a matching kaleo timer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer findByPKNI_DT_First(long parentKaleoNodeId,
		boolean defaultTimer, OrderByComparator orderByComparator)
		throws NoSuchTimerException, SystemException {
		List<KaleoTimer> list = findByPKNI_DT(parentKaleoNodeId, defaultTimer,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentKaleoNodeId=");
			msg.append(parentKaleoNodeId);

			msg.append(", defaultTimer=");
			msg.append(defaultTimer);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTimerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last kaleo timer in the ordered set where parentKaleoNodeId = &#63; and defaultTimer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kaleo timer
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a matching kaleo timer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer findByPKNI_DT_Last(long parentKaleoNodeId,
		boolean defaultTimer, OrderByComparator orderByComparator)
		throws NoSuchTimerException, SystemException {
		int count = countByPKNI_DT(parentKaleoNodeId, defaultTimer);

		List<KaleoTimer> list = findByPKNI_DT(parentKaleoNodeId, defaultTimer,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentKaleoNodeId=");
			msg.append(parentKaleoNodeId);

			msg.append(", defaultTimer=");
			msg.append(defaultTimer);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTimerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the kaleo timers before and after the current kaleo timer in the ordered set where parentKaleoNodeId = &#63; and defaultTimer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param kaleoTimerId the primary key of the current kaleo timer
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kaleo timer
	 * @throws com.liferay.portal.workflow.kaleo.NoSuchTimerException if a kaleo timer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoTimer[] findByPKNI_DT_PrevAndNext(long kaleoTimerId,
		long parentKaleoNodeId, boolean defaultTimer,
		OrderByComparator orderByComparator)
		throws NoSuchTimerException, SystemException {
		KaleoTimer kaleoTimer = findByPrimaryKey(kaleoTimerId);

		Session session = null;

		try {
			session = openSession();

			KaleoTimer[] array = new KaleoTimerImpl[3];

			array[0] = getByPKNI_DT_PrevAndNext(session, kaleoTimer,
					parentKaleoNodeId, defaultTimer, orderByComparator, true);

			array[1] = kaleoTimer;

			array[2] = getByPKNI_DT_PrevAndNext(session, kaleoTimer,
					parentKaleoNodeId, defaultTimer, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KaleoTimer getByPKNI_DT_PrevAndNext(Session session,
		KaleoTimer kaleoTimer, long parentKaleoNodeId, boolean defaultTimer,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KALEOTIMER_WHERE);

		query.append(_FINDER_COLUMN_PKNI_DT_PARENTKALEONODEID_2);

		query.append(_FINDER_COLUMN_PKNI_DT_DEFAULTTIMER_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(KaleoTimerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentKaleoNodeId);

		qPos.add(defaultTimer);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(kaleoTimer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KaleoTimer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the kaleo timers.
	 *
	 * @return the kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kaleo timers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of kaleo timers
	 * @param end the upper bound of the range of kaleo timers (not inclusive)
	 * @return the range of kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kaleo timers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of kaleo timers
	 * @param end the upper bound of the range of kaleo timers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoTimer> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoTimer> list = (List<KaleoTimer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KALEOTIMER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KALEOTIMER.concat(KaleoTimerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<KaleoTimer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<KaleoTimer>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the kaleo timers where parentKaleoNodeId = &#63; from the database.
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByparentKaleoNodeId(long parentKaleoNodeId)
		throws SystemException {
		for (KaleoTimer kaleoTimer : findByparentKaleoNodeId(parentKaleoNodeId)) {
			kaleoTimerPersistence.remove(kaleoTimer);
		}
	}

	/**
	 * Removes all the kaleo timers where parentKaleoNodeId = &#63; and defaultTimer = &#63; from the database.
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPKNI_DT(long parentKaleoNodeId, boolean defaultTimer)
		throws SystemException {
		for (KaleoTimer kaleoTimer : findByPKNI_DT(parentKaleoNodeId,
				defaultTimer)) {
			kaleoTimerPersistence.remove(kaleoTimer);
		}
	}

	/**
	 * Removes all the kaleo timers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (KaleoTimer kaleoTimer : findAll()) {
			kaleoTimerPersistence.remove(kaleoTimer);
		}
	}

	/**
	 * Returns the number of kaleo timers where parentKaleoNodeId = &#63;.
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @return the number of matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByparentKaleoNodeId(long parentKaleoNodeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentKaleoNodeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTKALEONODEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KALEOTIMER_WHERE);

			query.append(_FINDER_COLUMN_PARENTKALEONODEID_PARENTKALEONODEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentKaleoNodeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTKALEONODEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of kaleo timers where parentKaleoNodeId = &#63; and defaultTimer = &#63;.
	 *
	 * @param parentKaleoNodeId the parent kaleo node ID
	 * @param defaultTimer the default timer
	 * @return the number of matching kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPKNI_DT(long parentKaleoNodeId, boolean defaultTimer)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentKaleoNodeId, defaultTimer };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PKNI_DT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KALEOTIMER_WHERE);

			query.append(_FINDER_COLUMN_PKNI_DT_PARENTKALEONODEID_2);

			query.append(_FINDER_COLUMN_PKNI_DT_DEFAULTTIMER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentKaleoNodeId);

				qPos.add(defaultTimer);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PKNI_DT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of kaleo timers.
	 *
	 * @return the number of kaleo timers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KALEOTIMER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the kaleo timer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portal.workflow.kaleo.model.KaleoTimer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KaleoTimer>> listenersList = new ArrayList<ModelListener<KaleoTimer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KaleoTimer>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(KaleoTimerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = KaleoActionPersistence.class)
	protected KaleoActionPersistence kaleoActionPersistence;
	@BeanReference(type = KaleoConditionPersistence.class)
	protected KaleoConditionPersistence kaleoConditionPersistence;
	@BeanReference(type = KaleoDefinitionPersistence.class)
	protected KaleoDefinitionPersistence kaleoDefinitionPersistence;
	@BeanReference(type = KaleoInstancePersistence.class)
	protected KaleoInstancePersistence kaleoInstancePersistence;
	@BeanReference(type = KaleoInstanceTokenPersistence.class)
	protected KaleoInstanceTokenPersistence kaleoInstanceTokenPersistence;
	@BeanReference(type = KaleoLogPersistence.class)
	protected KaleoLogPersistence kaleoLogPersistence;
	@BeanReference(type = KaleoNodePersistence.class)
	protected KaleoNodePersistence kaleoNodePersistence;
	@BeanReference(type = KaleoNotificationPersistence.class)
	protected KaleoNotificationPersistence kaleoNotificationPersistence;
	@BeanReference(type = KaleoNotificationRecipientPersistence.class)
	protected KaleoNotificationRecipientPersistence kaleoNotificationRecipientPersistence;
	@BeanReference(type = KaleoTaskPersistence.class)
	protected KaleoTaskPersistence kaleoTaskPersistence;
	@BeanReference(type = KaleoTaskAssignmentPersistence.class)
	protected KaleoTaskAssignmentPersistence kaleoTaskAssignmentPersistence;
	@BeanReference(type = KaleoTaskAssignmentInstancePersistence.class)
	protected KaleoTaskAssignmentInstancePersistence kaleoTaskAssignmentInstancePersistence;
	@BeanReference(type = KaleoTaskInstanceTokenPersistence.class)
	protected KaleoTaskInstanceTokenPersistence kaleoTaskInstanceTokenPersistence;
	@BeanReference(type = KaleoTimerPersistence.class)
	protected KaleoTimerPersistence kaleoTimerPersistence;
	@BeanReference(type = KaleoTimerInstanceTokenPersistence.class)
	protected KaleoTimerInstanceTokenPersistence kaleoTimerInstanceTokenPersistence;
	@BeanReference(type = KaleoTransitionPersistence.class)
	protected KaleoTransitionPersistence kaleoTransitionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_KALEOTIMER = "SELECT kaleoTimer FROM KaleoTimer kaleoTimer";
	private static final String _SQL_SELECT_KALEOTIMER_WHERE = "SELECT kaleoTimer FROM KaleoTimer kaleoTimer WHERE ";
	private static final String _SQL_COUNT_KALEOTIMER = "SELECT COUNT(kaleoTimer) FROM KaleoTimer kaleoTimer";
	private static final String _SQL_COUNT_KALEOTIMER_WHERE = "SELECT COUNT(kaleoTimer) FROM KaleoTimer kaleoTimer WHERE ";
	private static final String _FINDER_COLUMN_PARENTKALEONODEID_PARENTKALEONODEID_2 =
		"kaleoTimer.parentKaleoNodeId = ?";
	private static final String _FINDER_COLUMN_PKNI_DT_PARENTKALEONODEID_2 = "kaleoTimer.parentKaleoNodeId = ? AND ";
	private static final String _FINDER_COLUMN_PKNI_DT_DEFAULTTIMER_2 = "kaleoTimer.defaultTimer = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kaleoTimer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KaleoTimer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KaleoTimer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KaleoTimerPersistenceImpl.class);
}