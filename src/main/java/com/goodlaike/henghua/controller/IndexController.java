package com.goodlaike.henghua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Jail Hu
 */
@Controller
@RequestMapping("/")
public class IndexController  extends BaseController{

    private String pageName = "pageName";

    @RequestMapping("/")
    protected String index() {
        return "index";
    }

    @RequestMapping("/service-faq")
    protected String serviceFaq() {
        return "service-faq";
    }

    /**
     * 了解衬衫
     * @return
     */
    @RequestMapping("/about-our-shirts")
    protected String aboutOurShirts() {
        return "about-our-shirts";
    }

    /**
     * 了解西装
     * @return
     */
    @RequestMapping("/about-our-suits")
    protected String aboutOurSuits() {
        return "about-our-suits";
    }

    /**
     * 媒体报道
     * @param model
     * @return
     */
    @RequestMapping("/media")
    protected String media(Model model) {
        model.addAttribute(pageName, "media");
        return "media";
    }

    /**
     * 新闻
     * @param model
     * @return
     */
    @RequestMapping("/news")
    protected String news(Model model) {
        model.addAttribute(pageName, "news");
        return "news";
    }

    /**
     * 企业信息
     * @param pageName
     * @param model
     * @return
     */
    @RequestMapping("/enterprise/{pageName}")
    protected String enterprise(@PathVariable String pageName, Model model){
        model.addAttribute(pageName, "pageName");
        return "enterprise";
    }

    /**
     * 专业服务
     * @param pageName
     * @param model
     * @return
     */
    @RequestMapping("/service/{pageName}")
    protected String service(@PathVariable String pageName, Model model){
        model.addAttribute(pageName, "pageName");
        return "service";
    }
}
