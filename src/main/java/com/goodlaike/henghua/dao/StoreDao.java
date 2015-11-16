package com.goodlaike.henghua.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goodlaike.business.core.support.Constants;
import com.goodlaike.business.core.support.LanguageStore;
import com.goodlaike.henghua.entity.model.Store;

/**
 * 订单Dao
 * 
 * @author jail
 */
@Repository
@Lazy(true)
public class StoreDao extends LocalRWDao<Store> {

	/**
	 * 插入门店
	 * 
	 * @param store
	 *            门店 需要用到的属性<br>
	 *            countryId 国家ID<br>
	 *            storeName 门店名<br>
	 *            address 地址<br>
	 *            province 省份<br>
	 *            zipCode 邮编<br>
	 *            phone 联系电话<br>
	 *            picPath 背景图相对路径<br>
	 *            workTime1 工作时间1<br>
	 *            workTime2 工作时间2<br>
	 *            workTime3 工作时间3<br>
	 *            workTime4 工作时间4<br>
	 *            workTime5 工作时间5<br>
	 *            workTime6 工作时间6<br>
	 *            workTime7 工作时间7<br>
	 *            creator 创建人ID
	 * @return int
	 */
	@Transactional(transactionManager = "transactionManagerDefault")
	public int insertAndReturnId(Store store) {
		super.insertAndReturnId(store);
		int returnId = store.getId();
		HashMap<String, Object> map = this.createLangMap();
		map.put("id", returnId);
		super.insert("insertOthers", map);
		return returnId;
	}

	/**
	 * 根据ID与语言获得门店
	 * 
	 * @param id
	 *            门店ID
	 * @param lang
	 *            语言
	 * @return Store
	 */
	public Store findStore(int id, String lang) {
		HashMap<String, Object> map = this.createLangMap(lang);
		map.put("id", id);
		return super.selectOne(map);
	}

	/**
	 * 根据国家ID与语言获得门店列表
	 * 
	 * @param countryId
	 *            国家ID
	 * @param lang
	 *            语言
	 * @return List<Store>
	 */
	public List<Store> findStoreList(int countryId, String lang) {
		HashMap<String, Object> map = this.createLangMap(lang);
		map.put("countryId", countryId);
		return super.selectList("findStoreListByCountryId", map);
	}

	/**
	 * 更新门店信息
	 * 
	 * @param store
	 *            门店 需要用到的属性<br>
	 *            id 门店ID<br>
	 *            countryId 国家ID<br>
	 *            storeName 门店名<br>
	 *            address 地址<br>
	 *            province 省份<br>
	 *            zipCode 邮编<br>
	 *            phone 联系电话<br>
	 *            picPath 背景图相对路径<br>
	 *            workTime1 工作时间1<br>
	 *            workTime2 工作时间2<br>
	 *            workTime3 工作时间3<br>
	 *            workTime4 工作时间4<br>
	 *            workTime5 工作时间5<br>
	 *            workTime6 工作时间6<br>
	 *            workTime7 工作时间7<br>
	 *            updateUserId 更新人ID
	 * 
	 * @param lang
	 *            语言版本
	 * @return boolean
	 * @author jail
	 */
	@Transactional(transactionManager = "transactionManagerDefault")
	public boolean updateStore(Store store, String lang) {
		HashMap<String, Object> map = this.createLangMap(lang);
		if (map.get("lang").equals(Constants.DEFAULT_LOCALIZATION.getValue())) {
			return super.update("updateDefault", store);
		} else {
			if (super.update("updateCn", store)) {
				map.put("store", store);
				if (!super.update("updateOther", map)) {
					throw new RuntimeException();
				}
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 删除门店
	 * 
	 * @param id
	 *            主键ID
	 * @param userId
	 *            操作人ID
	 * @return boolean
	 * @author jail
	 */
	public boolean deleteStore(int id, int userId) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("userId", userId);
		return super.delete(map);
	}

	/**
	 * 创建带其他语言分区的map
	 * 
	 * @return HashMap<String, Object>
	 * @author jail
	 */
	protected HashMap<String, Object> createLangMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("langs", LanguageStore.getLanguagesWithOutDefault());
		return map;
	}

	/**
	 * 创建带语言区分的map
	 * 
	 * @param lang
	 * @return HashMap<String, Object>
	 * @author jail
	 */
	protected HashMap<String, Object> createLangMap(String lang) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("lang", LanguageStore.getLanguage(lang));
		return map;
	}
}
