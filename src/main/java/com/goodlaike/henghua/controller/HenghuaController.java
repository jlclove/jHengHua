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
import com.goodlaike.henghua.ExceptionResultWeb;
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
}
