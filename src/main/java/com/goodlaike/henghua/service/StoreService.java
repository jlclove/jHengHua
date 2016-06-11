package com.goodlaike.henghua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.goodlaike.business.core.support.LanguageStore;
import com.goodlaike.henghua.config.StoreCountryStore;
import com.goodlaike.henghua.dao.StoreDao;
import com.goodlaike.henghua.entity.model.Store;
import com.goodlaike.henghua.entity.model.VStore;

/**
 * 门店 Service
 * 
 * @author jail
 *
 */
@Service
@Lazy(true)
public class StoreService {

    @Autowired
    private StoreDao storeDao;

    /**
     * 根据id与语言获得门店
     * 
     * @param id
     *            门店ID
     * @param lang
     *            语言
     * @return store
     */
    public Store getStore(int id, String lang) {
        lang = LanguageStore.getLanguage(lang);
        VStore store = (VStore) this.storeDao.findStore(id, lang);
        store.setCountryName(StoreCountryStore.getCountry(lang, store.getCountryId()).getName());
        return store;
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
    public List<Store> getStoreList(int countryId, String lang) {
        lang = LanguageStore.getLanguage(lang);
        List<Store> storeList = this.storeDao.findStoreList(countryId, lang);
        return storeList;
    }

    /**
     * 插入门店
     * 
     * @param countryId
     *            国家ID
     * @param storeName
     *            门店名
     * @param address
     *            地址
     * @param province
     *            省份
     * @param zipCode
     *            邮编
     * @param phone
     *            联系电话
     * @param picPath
     *            背景图相对路径
     * @param workTime1
     *            工作时间1
     * @param workTime2
     *            工作时间2
     * @param workTime3
     *            工作时间3
     * @param workTime4
     *            工作时间4
     * @param workTime5
     *            工作时间5
     * @param workTime6
     *            工作时间6
     * @param workTime7
     *            工作时间7
     * @param createUserId
     *            创建人ID
     * @return int
     */
    public int insertStore(int countryId, String storeName, String address, String province, String zipCode,
            String phone, String picPath, String workTime1, String workTime2, String workTime3, String workTime4,
            String workTime5, String workTime6, String workTime7, int createUserId) {
        Store store = new Store();
        store.setCountryId(countryId);
        store.setStoreName(storeName);
        store.setAddress(address);
        store.setProvince(province);
        store.setZipCode(zipCode);
        store.setPhone(phone);
        store.setPicPath(picPath);
        store.setWorkTime1(workTime1);
        store.setWorkTime2(workTime2);
        store.setWorkTime3(workTime3);
        store.setWorkTime4(workTime4);
        store.setWorkTime5(workTime5);
        store.setWorkTime6(workTime6);
        store.setWorkTime7(workTime7);
        store.setCreateUserId(createUserId);
        return this.insertStore(store);
    }

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
     *            createUserId 创建人ID
     * @return int
     */
    public int insertStore(Store store) {
        Assert.isTrue(store.getCountryId() >= 0, "国家ID不能为空");
        return this.storeDao.insertAndReturnId(store);
    }

    /**
     * 更新门店信息
     * 
     * @param id
     *            更新的ID
     * @param countryId
     *            国家ID
     * @param storeName
     *            门店名
     * @param address
     *            地址
     * @param province
     *            省份
     * @param zipCode
     *            邮编
     * @param phone
     *            联系电话
     * @param picPath
     *            背景图相对路径
     * @param workTime1
     *            工作时间1
     * @param workTime2
     *            工作时间2
     * @param workTime3
     *            工作时间3
     * @param workTime4
     *            工作时间4
     * @param workTime5
     *            工作时间5
     * @param workTime6
     *            工作时间6
     * @param workTime7
     *            工作时间7
     * @param updateUserId
     *            更新人ID
     * @param lang
     *            当前语言环境
     * @return boolean
     */
    public boolean updateStore(int id, int countryId, String storeName, String address, String province, String zipCode,
            String phone, String picPath, String workTime1, String workTime2, String workTime3, String workTime4,
            String workTime5, String workTime6, String workTime7, int updateUserId, String lang) {
        Store store = new Store();
        store.setId(id);
        store.setCountryId(countryId);
        store.setStoreName(storeName);
        store.setAddress(address);
        store.setProvince(province);
        store.setZipCode(zipCode);
        store.setPhone(phone);
        store.setPicPath(picPath);
        store.setWorkTime1(workTime1);
        store.setWorkTime2(workTime2);
        store.setWorkTime3(workTime3);
        store.setWorkTime4(workTime4);
        store.setWorkTime5(workTime5);
        store.setWorkTime6(workTime6);
        store.setWorkTime7(workTime7);
        store.setUpdateUserId(updateUserId);
        return this.updateStore(store, lang);
    }

    /**
     * 更新门店信息
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
     *            updateUserId 更新人ID
     * 
     * @param lang
     *            语言版本
     * @return boolean
     */
    public boolean updateStore(Store store, String lang) {
        Assert.isTrue(store.getCountryId() >= 0, "国家ID不能为空");
        return this.storeDao.updateStore(store, lang);
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
        return this.storeDao.deleteStore(id, userId);
    }
}
