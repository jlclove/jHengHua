package com.goodlaike.henghua.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.core.helper.LoginHelper;
import com.goodlaike.business.core.model.User;
import com.goodlaike.business.core.support.LanguageStore;
import com.goodlaike.henghua.config.StoreCountryStore;
import com.goodlaike.henghua.entity.model.Country;
import com.goodlaike.henghua.entity.model.HenghuaExhibition;
import com.goodlaike.henghua.service.HenghuaService;

/**
 * 
 * @author jail
 */
public abstract class BaseController {

    @Autowired
    HenghuaService henghuaService;

    protected String pageName = "pageName";

    @ModelAttribute("languages")
    protected HashMap<String, String> initLanguages() {
        return LanguageStore.getLanguages();
    }

    @ModelAttribute("lang")
    protected String initCurrentLanguage(HttpServletRequest request) {
        return LanguageHelper.getLocalization(request);
    }

    @ModelAttribute("countries")
    protected List<Country> initCountries(HttpServletRequest request) {
        return StoreCountryStore.getCountryList(request);
    }

    @ModelAttribute("session_user")
    protected User getLoginUser(HttpServletRequest request) {
        return LoginHelper.getLoginUser(request);
    }

    @ModelAttribute("exhibitions")
    protected List<HenghuaExhibition> getExhibitions(HttpServletRequest request) {
        List<HenghuaExhibition> list = henghuaService.getExhibitionAll();
        return list;

      /*  HenghuaExhibition e1 = new HenghuaExhibition();
        HenghuaExhibition e2 = new HenghuaExhibition();
        HenghuaExhibition e3 = new HenghuaExhibition();

        e1.setName("宁波展会1");
        e2.setName("宁波展会2");
        e3.setName("宁波展会3");

        e1.setAddress("浙江省宁波市人民广场");
        e3.setAddress("浙江省宁波市人民广场");
        e3.setAddress("浙江省宁波市人民广场");

        List<HenghuaExhibition> result = new ArrayList<>();
        result.add(e1);
        result.add(e2);
        result.add(e3);

        return result;*/
    }
}
