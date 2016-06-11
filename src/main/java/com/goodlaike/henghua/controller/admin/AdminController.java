package com.goodlaike.henghua.controller.admin;

import com.goodlaike.business.core.helper.LoginHelper;
import com.goodlaike.business.core.model.User;
import com.goodlaike.business.news.config.NewsConfig;
import com.goodlaike.henghua.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
public class AdminController extends BaseController {

    @Autowired
    private NewsConfig newsConfig;

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request){
        return LoginHelper.getLoginUser(request);
    }
    @ModelAttribute("newsType")
    protected List<String> getNewsTypeList() {
        return newsConfig.getNewsTypeList();
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("login")
    protected String login() {
        return "/admin/login";
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("logout")
    protected String logout(HttpServletRequest request, HttpServletResponse response) {
        LoginHelper.removeLoginUser(request);
        return "redirect:/admin/login";
    }

    /**
     * 新闻页面
     * @param model
     * @return
     */
    @RequestMapping({"/", "","/news"})
    protected String news(Model model) {
        model.addAttribute(pageName, "news");
        return "/admin/news";
    }

    /**
     * 媒体页面
     * @param model
     * @return
     */
    @RequestMapping("/medias")
    protected String medias(Model model) {
        model.addAttribute(pageName, "medias");
        return "/admin/medias";
    }

    /**
     * 门店页面
     * @param model
     * @return
     */
    @RequestMapping("/stores")
    protected String stores(Model model) {
        model.addAttribute(pageName, "stores");
        return "/admin/stores";
    }
}
