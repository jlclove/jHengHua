package com.goodlaike.henghua.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.core.helper.LoginHelper;
import com.goodlaike.business.core.model.User;
import com.goodlaike.business.core.support.AssertGoodlaike;
import com.goodlaike.henghua.config.StoreCountryStore;
import com.goodlaike.henghua.service.StoreService;

/**
 * 全球门店 Controller
 * 
 * @author jail
 */
@Controller
@RequestMapping("store")
public class StoreController extends BaseController {

    @Autowired
    private StoreService storeService;

    /**
     * 获得当前的国家列表
     * 
     * @param request
     * @return
     * @author jail
     */
    @RequestMapping("country")
    protected ResponseEntity<?> getCountryList(HttpServletRequest request) {
        return ResponseEntity.ok(StoreCountryStore.getCountryList(request));
    }

    /**
     * 添加门店
     * 
     * @param request
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
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    protected ResponseEntity<?> addStore(HttpServletRequest request, @RequestParam(value = "countryId") int countryId,
            @RequestParam(value = "storeName") String storeName,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "province", required = false) String province,
            @RequestParam(value = "zipCode", required = false) String zipCode,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "picPath", required = false) String picPath,
            @RequestParam(value = "workTime1", required = false) String workTime1,
            @RequestParam(value = "workTime2", required = false) String workTime2,
            @RequestParam(value = "workTime3", required = false) String workTime3,
            @RequestParam(value = "workTime4", required = false) String workTime4,
            @RequestParam(value = "workTime5", required = false) String workTime5,
            @RequestParam(value = "workTime6", required = false) String workTime6,
            @RequestParam(value = "workTime7", required = false) String workTime7) {
        Assert.isTrue(countryId >= 0, "国家ID必填");
        Assert.hasText(storeName, "门店名必须填写");
        User user = LoginHelper.getLoginUser(request);
        AssertGoodlaike.needLogin(user);
        return ResponseEntity
                .ok(storeService.insertStore(countryId, storeName, address, province, zipCode, phone, picPath,
                        workTime1, workTime2, workTime3, workTime4, workTime5, workTime6, workTime7, user.getUserId()));
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
     * @return boolean
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    protected ResponseEntity<?> updateStore(HttpServletRequest request, @PathVariable(value = "id") int id,
            @RequestParam(value = "countryId") int countryId, @RequestParam(value = "storeName") String storeName,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "province", required = false) String province,
            @RequestParam(value = "zipCode", required = false) String zipCode,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "picPath", required = false) String picPath,
            @RequestParam(value = "workTime1", required = false) String workTime1,
            @RequestParam(value = "workTime2", required = false) String workTime2,
            @RequestParam(value = "workTime3", required = false) String workTime3,
            @RequestParam(value = "workTime4", required = false) String workTime4,
            @RequestParam(value = "workTime5", required = false) String workTime5,
            @RequestParam(value = "workTime6", required = false) String workTime6,
            @RequestParam(value = "workTime7", required = false) String workTime7) {
        Assert.isTrue(id > 0, "门店ID非法");
        Assert.isTrue(countryId >= 0, "国家ID必填");
        Assert.hasText(storeName, "门店名必须填写");
        User user = LoginHelper.getLoginUser(request);
        AssertGoodlaike.needLogin(user);
        return ResponseEntity.ok(storeService.updateStore(id, countryId, storeName, address, province, zipCode, phone,
                picPath, workTime1, workTime2, workTime3, workTime4, workTime5, workTime6, workTime7, user.getUserId(),
                LanguageHelper.getLocalization(request)));
    }

    /**
     * 删除门店
     * 
     * @param id
     *            主键ID
     * @return boolean
     * @author jail
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    protected ResponseEntity<?> deleteStore(HttpServletRequest request, @PathVariable(value = "id") int id) {
        Assert.isTrue(id > 0, "门店ID非法");
        User user = LoginHelper.getLoginUser(request);
        AssertGoodlaike.needLogin(user);
        return ResponseEntity.ok(storeService.deleteStore(id, user.getUserId()));
    }

    /**
     * 获得门店信息
     * 
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    protected ResponseEntity<?> getStore(HttpServletRequest request, @PathVariable(value = "id") int id) {
        Assert.isTrue(id > 0, "门店ID非法");
        return ResponseEntity.ok(storeService.getStore(id, LanguageHelper.getLocalization(request)));
    }

    /**
     * 根据国家ID获得门店列表
     * 
     * @param request
     * @param countryId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    protected ResponseEntity<?> getStoreList(HttpServletRequest request,
            @RequestParam(value = "countryId") int countryId) {
        Assert.isTrue(countryId >= 0, "国家ID非法");
        return ResponseEntity.ok(storeService.getStoreList(countryId, LanguageHelper.getLocalization(request)));
    }
}
