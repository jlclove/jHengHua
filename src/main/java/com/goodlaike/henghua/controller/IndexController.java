package com.goodlaike.henghua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/service")
    protected String service() {
        return "service";
    }
    @RequestMapping("/service-faq")
    protected String serviceFaq() {
        return "service-faq";
    }
    @RequestMapping("/about-our-shirts")
    protected String aboutOurShirts() {
        return "about-our-shirts";
    }
    @RequestMapping("/about-our-suits")
    protected String aboutOurSuits() {
        return "about-our-suits";
    }
    @RequestMapping("/media")
    protected String media(Model model) {
        model.addAttribute(pageName, "media");
        return "media";
    }
    @RequestMapping("/news")
    protected String news(Model model) {
        model.addAttribute(pageName, "news");
        return "news";
    }
    @RequestMapping("/about")
    protected String about(Model model) {
        model.addAttribute(pageName, "about");
        return "about";
    }
    @RequestMapping("/contact")
    protected String contact(Model model) {
        model.addAttribute(pageName, "contact");
        return "contact";
    }
    @RequestMapping("/career")
    protected String career(Model model) {
        model.addAttribute(pageName, "career");
        return "career";
    }
    @RequestMapping("/franchise")
    protected String franchise(Model model) {
        model.addAttribute(pageName, "franchise");
        return "franchise";
    }

    @RequestMapping("/privacy")
    protected String privacy(Model model) {
        return "privacy";
    }

    @RequestMapping("/term")
    protected String term(Model model) {
        return "term";
    }
}
