package com.goodlaike.henghua.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.business.core.controller.BaseRestController;
import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.core.support.ExceptionResult;
import com.goodlaike.henghua.ExceptionResultWeb;
import com.goodlaike.henghua.entity.model.HenghuaCloth;
import com.goodlaike.henghua.entity.model.HenghuaClothDetail;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.service.HenghuaService;

/**
 * henghua 控制器
 * 
 * @author jail
 */
@RestController
@RequestMapping("henghua")
public class HenghuaController extends BaseRestController {

    @Autowired
    private HenghuaService henghuaService;

    /**
     * 获得样卡分类列表
     * 
     * @param request
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午12:00:20
     * @updator jail
     * @updateTime 2015年9月4日下午12:00:20
     */
    @RequestMapping("sample/type")
    protected ResponseEntity<?> getSampleType(HttpServletRequest request) {
        return ResponseEntity.ok(henghuaService.getSampleType(LanguageHelper.getLocalization(request)));
    }

    /**
     * 获得下一页样卡
     * 
     * @param request
     * @param id
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午6:16:46
     * @updator jail
     * @updateTime 2015年9月4日下午6:16:46
     */
    @RequestMapping(value = "sample", method = RequestMethod.GET)
    protected ResponseEntity<?> getSampleList(HttpServletRequest request,
            @RequestParam(value = "sinceId", defaultValue = "0") long id) {
        return ResponseEntity.ok(henghuaService.getNextSampleList(id));
    }

    /**
     * 获得样卡详情数据
     * 
     * @param request
     * @param cardId
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午2:05:58
     * @updator jail
     * @updateTime 2015年9月5日下午2:05:58
     */
    @RequestMapping(value = "sample/{cardId}", method = RequestMethod.GET)
    protected ResponseEntity<?> getSample(HttpServletRequest request, @PathVariable String cardId) {
        return ResponseEntity.ok(henghuaService.getSample(cardId));
    }

    /**
     * 获得样品详情
     * 
     * @param request
     * @param detailName
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午11:58:23
     * @updator jail
     * @updateTime 2015年9月4日下午11:58:23
     */
    @RequestMapping(value = "sample/detail/{detailName}", method = RequestMethod.GET)
    protected ResponseEntity<?> getSampleDetail(HttpServletRequest request, @PathVariable String detailName) {
        HenghuaSampleDetail detail = henghuaService.getSampleDetail(detailName);
        return detail == null ? super.notFound(ExceptionResultWeb.NOT_FOUND) : ResponseEntity.ok(detail);
    }

    /**
     * 样品搜索
     * 
     * @param request
     * @param filter
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日上午10:04:03
     * @updator jail
     * @updateTime 2015年9月5日上午10:04:03
     */
    @RequestMapping(value = "sample/detail/search", method = RequestMethod.GET)
    protected ResponseEntity<?> searchSampleDetail(HttpServletRequest request, @RequestParam String filter) {
        return ResponseEntity.ok(henghuaService.getSampleDetailFilter(LanguageHelper.getLocalization(request), filter));
    }

    /**
     * 获得下一页服装
     * 
     * @param request
     * @param id
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午6:16:46
     * @updator jail
     * @updateTime 2015年9月4日下午6:16:46
     */
    @RequestMapping(value = "cloth", method = RequestMethod.GET)
    protected ResponseEntity<?> getClothList(HttpServletRequest request,
            @RequestParam(value = "sinceId", defaultValue = "0") long id) {
        return ResponseEntity.ok(henghuaService.getNextClothList(id));
    }

    /**
     * 获得服装详情1（父详情，对应列表到详情页）
     * 
     * @param request
     * @param serialNo
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午4:45:11
     * @updator jail
     * @updateTime 2015年9月5日下午4:45:11
     */
    @RequestMapping(value = "cloth/{serialNo}", method = RequestMethod.GET)
    protected ResponseEntity<?> getCloth(HttpServletRequest request, @PathVariable String serialNo) {
        HenghuaCloth clothDetail = henghuaService.getCloth(serialNo);
        return clothDetail == null ? super.notFound(ExceptionResult.NOT_FOUND) : ResponseEntity.ok(clothDetail);
    }

    /**
     * 获得服装详情2（子详情）
     * 
     * @param request
     * @param serialNo
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午4:35:56
     * @updator jail
     * @updateTime 2015年9月5日下午4:35:56
     */
    @RequestMapping(value = "cloth/detail/{serialNo}", method = RequestMethod.GET)
    protected ResponseEntity<?> getClothDetail(HttpServletRequest request, @PathVariable String serialNo) {
        HenghuaClothDetail clothDetail = henghuaService.getClothDetail(serialNo);
        return clothDetail == null ? super.notFound(ExceptionResult.NOT_FOUND) : ResponseEntity.ok(clothDetail);
    }

    /**
     * 获得所有洗标
     * 
     * @param request
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午5:20:40
     * @updator jail
     * @updateTime 2015年9月5日下午5:20:40
     */
    @RequestMapping(value = "washing", method = RequestMethod.GET)
    protected ResponseEntity<?> getWashingMap(HttpServletRequest request) {
        return ResponseEntity.ok(henghuaService.getWashingMap());
    }

    /**
     * 获得服装分类
     * 
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午6:54:53
     * @updator jail
     * @updateTime 2015年9月5日下午6:54:53
     */
    @RequestMapping(value = "cloth/type", method = RequestMethod.GET)
    protected ResponseEntity<?> getClothType() {
        return ResponseEntity.ok(henghuaService.getClothType());
    }

    /**
     * 服装筛选,只支持一个条件搜索，见鬼
     * 
     * @param filter
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午7:08:46
     * @updator jail
     * @updateTime 2015年9月5日下午7:08:46
     */
    @RequestMapping(value = "cloth/search", method = RequestMethod.GET)
    protected ResponseEntity<?> searchCloth(@RequestParam(value = "filter") String filter) {
        return ResponseEntity.ok(henghuaService.getClothFilter(filter));
    }
}
