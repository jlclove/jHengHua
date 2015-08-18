package com.goodlaike.henghua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodlaike.business.news.service.NewsService;

/**
 * 
 * @author Jail Hu
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private NewsService newsService;
    
	@RequestMapping("/")
	protected String index() {
	    newsService.helloworld();
		return "index";
	}
}
