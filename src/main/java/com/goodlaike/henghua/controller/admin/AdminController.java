package com.goodlaike.henghua.controller.admin;

import com.goodlaike.business.core.helper.LoginHelper;
import com.goodlaike.business.core.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * PackageName:com.goodlaike.henghua.controller.admin
 * Author: Charles.xu
 * Create: Charles.xu (2015-09-16 下午10:59)
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request){
        return LoginHelper.getLoginUser(request);
    }

    @RequestMapping("login")
    protected String login() {
        return "/admin/login";
    }

    @RequestMapping("logout")
    protected String logout(HttpServletRequest request, HttpServletResponse response) {
        LoginHelper.removeLoginUser(request);
        return "redirect:/admin/login";
    }

    @RequestMapping("index")
    protected String index() {
        return "/admin/index";
    }
}
