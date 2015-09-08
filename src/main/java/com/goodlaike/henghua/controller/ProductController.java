package com.goodlaike.henghua.controller;

import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.core.support.LanguageStore;
import com.goodlaike.henghua.entity.model.HenghuaSample;
import com.goodlaike.henghua.entity.model.VHenghuaSample;
import com.goodlaike.henghua.service.HenghuaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * PackageName:com.goodlaike.henghua.controller
 * Author: Charles.xu
 * Create: Charles.xu (2015-09-05 下午3:10)
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private HenghuaService henghuaService;

    @ModelAttribute("languages")
    protected HashMap<String, String> getLanguages(){
        return LanguageStore.getLanguages();
    }

    @RequestMapping("/sample")
    protected String sampleList(Model model, HttpServletRequest request) {
        model.addAttribute("sampleType", henghuaService.getSampleType(LanguageHelper.getLocalization(request)));
        model.addAttribute("sampleList", henghuaService.getNextSampleList(0));
        return "sample";
    }

    @RequestMapping("/sample/{cardId}")
    protected String sampleDetail(@PathVariable String cardId, Model model) {
        model.addAttribute("sampleDetail", henghuaService.getSampleDetail(cardId));
        return "sampleDetail";
    }

    @RequestMapping("/cloth")
    protected String clothList(Model model) {
        model.addAttribute("clothType", henghuaService.getClothType());
        model.addAttribute("clothList", henghuaService.getNextClothList(0));
        return "cloth";
    }

    @RequestMapping("/cloth/{clothId}")
    protected String clothDetail(@PathVariable String clothId) {
        return "clothDetail";
    }
}
