package com.goodlaike.henghua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/sample")
    protected String sampleList() {
        return "sample";
    }

    @RequestMapping("/sample/{cardId}")
    protected String sampleDetail(@PathVariable String cardId) {
        return "sampleDetail";
    }

    @RequestMapping("/cloth")
    protected String clothList() {
        return "cloth";
    }

    @RequestMapping("/cloth/{clothId}")
    protected String clothDetail(@PathVariable String clothId) {
        return "clothDetail";
    }
}
