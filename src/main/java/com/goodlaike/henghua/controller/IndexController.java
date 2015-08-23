package com.goodlaike.henghua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Jail Hu
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    protected String index(){
        return "index";
    }
}
