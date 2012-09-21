/**
 * Copyright (c) 2005-2012-9-20 www.china-cti.com
 * Id: CircleService.java,0:03:26
 * @author wuwei
 */
package cn.com.rebirth.knowledge.web.service.circle;

import java.util.*;

import javax.persistence.*;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import cn.com.rebirth.knowledge.commons.entity.circle.*;
import cn.com.rebirth.knowledge.commons.entity.circle.CircleCategoryEntity.CircleCategoryType;
import cn.com.rebirth.knowledge.commons.entity.circle.CircleTopicEntity.CircleTopicStatu;
import cn.com.rebirth.knowledge.commons.entity.system.*;
import cn.com.rebirth.persistence.service.*;

import com.google.common.collect.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CircleService.
 *
 * @author wuwei
 */
@Service
@Transactional
public class CircleService extends BaseService {

	public static Long[] FIRST_CATEGORY;

	/**
	 * Gets the first category.
	 * 获取一级类别
	 * @return the first category
	 */
	public List<CircleCategoryEntity> getFirstCategory() {
		return findBy(CircleCategoryEntity.class, "categoryType", CircleCategoryType.FIRST);
	}

	/**
	 * Gets the second category.
	 * 更具一级类别获取二级类别
	 * @param categoryEntity the category entity
	 * @return the second category
	 */
	public List<CircleCategoryEntity> getSecondCategory(CircleCategoryEntity categoryEntity) {
		if (categoryEntity.getCategoryType() == CircleCategoryType.SECOND) {
			return null;
		}
		return findBy(CircleCategoryEntity.class, "parent", categoryEntity);
	}

	/**
	 * Gets the second category.
	 *
	 * @param id the id
	 * @return the second category
	 */
	public List<CircleCategoryEntity> getSecondCategory(Long id) {
		CircleCategoryEntity parent = get(CircleCategoryEntity.class, id);
		return getSecondCategory(parent);
	}

	/**
	 * Category2 json.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<SimpleJsonEntity> category2Json(List<CircleCategoryEntity> list) {
		List<SimpleJsonEntity> jsonEntities = Lists.newArrayList();
		for (CircleCategoryEntity circleCategoryEntity : list) {
			SimpleJsonEntity jsonEntity = new SimpleJsonEntity();
			jsonEntity.setId(circleCategoryEntity.getId());
			jsonEntity.setName(circleCategoryEntity.getCategoryName());
			jsonEntities.add(jsonEntity);
		}
		return jsonEntities;
	}

	/**
	 * Gets the topic.
	 * 获得用户参与圈子的话题
	 * @param userEntity the user entity
	 * @param num the num
	 * @return the topic
	 */
	@SuppressWarnings("unchecked")
	public List<CircleTopicEntity> getTopic(SysUserEntity userEntity, int num) {
		List<CircleTopicEntity> list = Lists.newArrayList();
		Query memberquery = getBaseDao()
				.getEm()
				.createQuery(
						"from CircleTopicEntity t where t.circleEntity in (select  c from CircleEntity c left join c.memberUser u where u=?) order by t.createDate desc");
		memberquery.setParameter(1, userEntity);
		memberquery.setMaxResults(num);
		Query secondaryMasterQuery = getBaseDao()
				.getEm()
				.createQuery(
						"from CircleTopicEntity t where t.circleEntity in (select  c from CircleEntity c left join c.secondaryMaster m where m=?) order by t.createDate desc");
		secondaryMasterQuery.setParameter(1, userEntity);
		secondaryMasterQuery.setMaxResults(num);
		Query masterQuery = getBaseDao().getEm().createQuery(
				"from CircleTopicEntity t where t.circleEntity in (from CircleEntity c where c.master=?)");
		masterQuery.setParameter(1, userEntity);
		list.addAll(memberquery.getResultList());
		list.addAll(secondaryMasterQuery.getResultList());
		list.addAll(masterQuery.getResultList());
		Collections.sort(list, new Comparator<CircleTopicEntity>() {

			@Override
			public int compare(CircleTopicEntity o1, CircleTopicEntity o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getCreateDate().getTime() - o2.getCreateDate().getTime());
			}
		});
		return list.size() > num ? list.subList(0, num) : list;
	}

	/**
	 * Gets the marrow topic.
	 * 获得用户参与圈子的精华话题
	 * @param userEntity the user entity
	 * @param num the num
	 * @return the marrow topic
	 */
	@SuppressWarnings("unchecked")
	public List<CircleTopicEntity> getMarrowTopic(SysUserEntity userEntity, int num) {
		List<CircleTopicEntity> list = Lists.newArrayList();
		Query memberquery = getBaseDao()
				.getEm()
				.createQuery(
						"from CircleTopicEntity t where t.circleEntity in (select  c from CircleEntity c left join c.memberUser u where u=?) and t.marrow=? order by t.createDate desc");
		memberquery.setParameter(1, userEntity);
		memberquery.setParameter(2, true);
		memberquery.setMaxResults(num);
		Query secondaryMasterQuery = getBaseDao()
				.getEm()
				.createQuery(
						"from CircleTopicEntity t where t.circleEntity in (select  c from CircleEntity c left join c.secondaryMaster m where m=?)  and t.marrow=? order by t.createDate desc");
		secondaryMasterQuery.setParameter(1, userEntity);
		secondaryMasterQuery.setParameter(2, true);
		secondaryMasterQuery.setMaxResults(num);
		Query masterQuery = getBaseDao()
				.getEm()
				.createQuery(
						"from CircleTopicEntity t where t.circleEntity in (select c from CircleEntity c where c.master=?) and t.marrow=?");
		masterQuery.setParameter(1, userEntity);
		masterQuery.setParameter(2, true);
		list.addAll(memberquery.getResultList());
		list.addAll(secondaryMasterQuery.getResultList());
		list.addAll(masterQuery.getResultList());
		Collections.sort(list, new Comparator<CircleTopicEntity>() {

			@Override
			public int compare(CircleTopicEntity o1, CircleTopicEntity o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getCreateDate().getTime() - o2.getCreateDate().getTime());
			}
		});
		return list.size() > num ? list.subList(0, num) : list;
	}

	/**
	 * Gets the my topic.
	 * 获得我发表的话题
	 * @param userEntity the user entity
	 * @param num the num
	 * @return the my topic
	 */
	@SuppressWarnings("unchecked")
	public List<CircleTopicEntity> getMyTopic(SysUserEntity userEntity, int num) {
		List<CircleTopicEntity> list = Lists.newArrayList();
		Query query = getBaseDao().getEm().createQuery(
				"from CircleTopicEntity t where t.creater=? order by t.createDate desc");
		query.setParameter(1, userEntity);
		query.setMaxResults(num);
		list = query.getResultList();
		return list;
	}

	/**
	 * Gets the my reply topic.
	 * 获得我回复的话题
	 * @param userEntity the user entity
	 * @param num the num
	 * @return the my reply topic
	 */
	@SuppressWarnings("unchecked")
	public List<CircleTopicEntity> getMyReplyTopic(SysUserEntity userEntity, int num) {
		List<CircleTopicEntity> list = Lists.newArrayList();
		Query query = getBaseDao()
				.getEm()
				.createQuery(
						"select t from CircleTopicEntity t  left join t.topicReplyEntities r where r.replyUser=? order by r.replyDate desc");
		query.setParameter(1, userEntity);
		query.setMaxResults(num);
		list = query.getResultList();
		return list;
	}

	/**
	 * Gets the managing circle.
	 * 获得我管理的圈子
	 * @param userEntity the user entity
	 * @return the managing circle
	 */
	@SuppressWarnings("unchecked")
	public List<CircleEntity> getManagingCircle(SysUserEntity userEntity) {
		List<CircleEntity> list = Lists.newArrayList();
		Query query = getBaseDao().getEm().createQuery("from CircleEntity t where t.master=?");
		query.setParameter(1, userEntity);
		list = query.getResultList();
		Query secondaryQuery = getBaseDao().getEm().createQuery(
				"from CircleEntity t left join t.secondaryMaster s where s=?");
		secondaryQuery.setParameter(1, userEntity);
		list.addAll(secondaryQuery.getResultList());
		return list;
	}

	/**
	 * Gets the member circle.
	 * 获得我只有普通权限的圈子
	 * @param userEntity the user entity
	 * @return the member circle
	 */
	@SuppressWarnings("unchecked")
	public List<CircleEntity> getMemberCircle(SysUserEntity userEntity) {
		List<CircleEntity> list = Lists.newArrayList();
		Query query = getBaseDao().getEm().createQuery("from CircleEntity t left join t.memberUser s where s=?");
		query.setParameter(1, userEntity);
		list = query.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<CircleTopicEntity> getHotTopicEntities(CircleCategoryEntity categoryEntity, int num) {
		Query query = getBaseDao()
				.getEm()
				.createQuery(
						"select r.circleTopicEntity from CircleTopicStatisticalEntity r where r.circleTopicEntity.circleEntity.category=? order by r.weekReplyCount desc");
		query.setParameter(1, categoryEntity);
		query.setMaxResults(num);
		List<CircleTopicEntity> list = query.getResultList();
		return list;
	}

	public Map<CircleCategoryEntity, List<CircleTopicEntity>> getHotTopicMap(int num) {
		Map<CircleCategoryEntity, List<CircleTopicEntity>> map = Maps.newHashMap();
		List<CircleCategoryEntity> categoryEntities = find(
				"from CircleCategoryEntity t where t.categoryType=? order by t.id", CircleCategoryType.FIRST);
		List<CircleTopicEntity> typed;
		for (CircleCategoryEntity circleCategoryEntity : categoryEntities) {
			typed = getHotTopicEntities(circleCategoryEntity, num);
			map.put(circleCategoryEntity, typed);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<CircleCategoryEntity, Map<CircleCategoryEntity, List<CircleEntity>>> getHotCircle(int num) {
		Map<CircleCategoryEntity, Map<CircleCategoryEntity, List<CircleEntity>>> map = Maps.newHashMap();
		Map<CircleCategoryEntity, List<CircleEntity>> secMap = Maps.newHashMap();
		List<CircleCategoryEntity> first = getFirstCategory();
		List<CircleEntity> typed;
		for (CircleCategoryEntity category : first) {
			//遍历一级类别下的二级类别
			for (CircleCategoryEntity sec : category.getSecondCategory()) {
				//今天该二级类别最热门的圈子
				Query query = getBaseDao()
						.getEm()
						.createQuery(
								"select t.circleEntity from CircleStatisticalEntity t and t.secCategory = ? order by t.dayReplyCount desc");
				query.setParameter(1, sec);
				query.setMaxResults(num);
				typed = query.getResultList();
				secMap.put(sec, typed);
			}
			map.put(category, secMap);
		}
		return map;
	}

	public List<CircleTopicEntity> getTopicByCircle(CircleEntity circleEntity) {
		List<CircleTopicEntity> list = find(
				"from CircleTopciEntity t where t.circleEntity=? order by t.sticky,t.statisticalEntity.lastReplyDate desc",
				circleEntity);
		return list;
	}

	public int setStickyTopic(Long[] ids) {
		return batchExecute("update CircleTopicEntity t set t.sticky=? where t.id in ?",
				new Object[] { true, Arrays.asList(ids) });
	}

	public int setMarrowTopic(Long[] ids) {
		return batchExecute("update CircleTopicEntity t set t.marrow=? where t.id in ?",
				new Object[] { true, Arrays.asList(ids) });
	}

	public int recycleTopic(Long[] ids) {
		return batchExecute("update CircleTopicEntity t set t.statu=? where t.id in ?", new Object[] {
				CircleTopicStatu.DELETE, Arrays.asList(ids) });
	}
}
