package com.goodlaike.henghua.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.core.support.LanguageStore;

/**
 * 
 * @author jail
 */
public abstract class BaseController {
    @ModelAttribute("languages")
    protected HashMap<String, String> initLanguages() {
        return LanguageStore.getLanguages();
    }

    @ModelAttribute("lang")
    protected String initCurrentLanguage(HttpServletRequest request) {
        return LanguageHelper.getLocalization(request);
    }
}
