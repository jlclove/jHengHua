package com.goodlaike.henghua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created with IntelliJ IDEA.
 * 用户 Controller
 *
 * @Author Charles.Xu
 * @summary
 * @Copyright (c) 2016, Lianjia Group All Rights Reserved.
 * @since 2016-09-03 上午10:39
 */
@Controller
@RequestMapping("account")
public class AccountController  extends BaseController {
    @RequestMapping("profile")
    protected String index() {
        return "account/profile";
    }
}
