package com.goodlaike.henghua.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodlaike.henghua.service.HenghuaService;

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
public class ProductController extends BaseController{

    @Autowired
    private HenghuaService henghuaService;

    @RequestMapping("/sample")
    protected String sampleList(Model model, HttpServletRequest request) {
//        model.addAttribute("filters", henghuaService.getSampleType(LanguageHelper.getLocalization(request)));
//        model.addAttribute("multiColumns", Arrays.asList("materialTypes", "colorTypes", "clearTypes"));
//        model.addAttribute("sampleList", henghuaService.getNextSampleList(0));
        return "sample";
    }

    @RequestMapping("/sample/{cardId}")
    protected String sampleDetail(@PathVariable String cardId, Model model) {
        model.addAttribute("sample", henghuaService.getSample(cardId));
        return "sampleDetail";
    }

    @RequestMapping("/sample/detail/{detailId}")
    protected String sampleChildDetail(@PathVariable String detailId, Model model) {
        model.addAttribute("sampleDetail", henghuaService.getSampleDetail(detailId));
        return "sampleChildDetail";
    }

    @RequestMapping("/cloth")
    protected String clothList(Model model) {
        model.addAttribute("filters", henghuaService.getClothType());
        model.addAttribute("clothList", henghuaService.getNextClothList(0));
        return "cloth";
    }

    @RequestMapping("/cloth/{serialNo}")
    protected String clothDetail(@PathVariable String serialNo, Model model) {
        model.addAttribute("cloth", henghuaService.getCloth(serialNo));
//        model.addAttribute("clothDetail", henghuaService.getClothDetail(serialNo));
        model.addAttribute("washingMap", henghuaService.getWashingMap());
        return "clothDetail";
    }
}
