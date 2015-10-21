package com.goodlaike.henghua.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodlaike.henghua.config.StoreCityStore;

/**
 * 
 * @author jail
 */
@Controller
@RequestMapping("store")
public class StoreController extends BaseController {

    /**
     * 获得当前的国家列表
     * 
     * @param request
     * @return
     * @author jail
     */
    @RequestMapping("country")
    protected ResponseEntity<?> getCountryList(HttpServletRequest request) {
        return ResponseEntity.ok(StoreCityStore.getCountryList(request));
    }
}
