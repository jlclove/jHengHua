package com.goodlaike.henghua.controller;

import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.news.service.NewsService;
import com.goodlaike.framework.dao.order.OrderFilter;
import com.goodlaike.framework.dao.search.AbstractSearchFilter;
import com.goodlaike.framework.dao.search.SearchFilter;
import com.goodlaike.framework.dao.search.SearchType;
import com.goodlaike.framework.dao.support.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Jail Hu
 */
@Controller
@RequestMapping("/")
public class IndexController  extends BaseController{

    @Autowired
    NewsService newsService;

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
    protected String news(HttpServletRequest request, Model model) {
        model.addAttribute(pageName, "news");
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(5);
        pagination.addFilters(new AbstractSearchFilter[]{SearchFilter.and("type", SearchType.EQUAL, new Object[] {"新闻"})});
        pagination.addFilters(new OrderFilter[]{OrderFilter.desc("id")});
        pagination = this.newsService.getPagination(pagination, LanguageHelper.getLocalization(request, ""));
        model.addAttribute("newsList", pagination.getList());
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
    
    /**
     * 隐私声明
     * @return
     * @author jail
     */
    @RequestMapping("privacy")
    protected String privacy(){
        return "privacy";
    }
    
    /**
     * 购买条款
     * @return
     * @author jail
     */
    @RequestMapping("term")
    protected String term(){
        return "term";
    }
    
}
