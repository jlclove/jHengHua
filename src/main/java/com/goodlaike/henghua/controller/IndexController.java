package com.goodlaike.henghua.controller;

import javax.servlet.http.HttpServletRequest;

import com.goodlaike.henghua.config.StoreCountryStore;
import com.goodlaike.henghua.entity.model.Store;
import com.goodlaike.henghua.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.news.model.News;
import com.goodlaike.business.news.service.NewsService;
import com.goodlaike.framework.dao.order.OrderFilter;
import com.goodlaike.framework.dao.search.AbstractSearchFilter;
import com.goodlaike.framework.dao.search.SearchFilter;
import com.goodlaike.framework.dao.search.SearchType;
import com.goodlaike.framework.dao.support.Pagination;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 
 * @author Jail Hu
 */
@Controller
@RequestMapping("/")
public class IndexController  extends BaseController{

    @Autowired
    NewsService newsService;

    @Autowired
    private StoreService storeService;

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
    protected String media(HttpServletRequest request, Model model) {
        model.addAttribute(pageName, "media");
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(20);
        pagination.addFilters(new AbstractSearchFilter[]{SearchFilter.and("type", SearchType.EQUAL, new Object[] {"媒体"})});
        pagination.addFilters(new OrderFilter[]{OrderFilter.desc("id")});
        pagination = this.newsService.getPagination(pagination, LanguageHelper.getLocalization(request));
        model.addAttribute("mediaList", pagination.getList());
        return "media";
    }

    /**
     * 媒体报道详情
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/media/{id}")
    protected String mediaDetail(@PathVariable int id, HttpServletRequest request, Model model){
        News news = newsService.getNews(id, LanguageHelper.getLocalization(request));
        model.addAttribute("media", news);
        return "mediaDetail";
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
        pagination = this.newsService.getPagination(pagination, LanguageHelper.getLocalization(request));
        model.addAttribute("newsList", pagination.getList());
        return "news";
    }

    /**
     * 新闻详情
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/news/{id}")
    protected String newsDetail(@PathVariable int id, HttpServletRequest request, Model model){
        News news = newsService.getNews(id, LanguageHelper.getLocalization(request));
        model.addAttribute("news", news);
        return "newsDetail";
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

    /**
     * 全球门店
     * @return
     */
    @RequestMapping("stores")
    protected String store(@RequestParam int countryId, HttpServletRequest request, Model model){
        model.addAttribute("storeList", storeService.getStoreList(countryId, LanguageHelper.getLocalization(request)));
        model.addAttribute("country", StoreCountryStore.getCountry(request, countryId));
        return "stores";
    }

    /**
     * 门店详情
     * @return
     */
    @RequestMapping("stores/{storeId}")
    protected String storeDetail(@PathVariable int storeId, HttpServletRequest request, Model model){
        Store store = storeService.getStore(storeId, LanguageHelper.getLocalization(request));
        if (store != null) {
            model.addAttribute("store", storeService.getStore(storeId, LanguageHelper.getLocalization(request)));
            model.addAttribute("country", StoreCountryStore.getCountry(request, store.getCountryId()));
        }
        return "storesDetail";
    }
}
