package com.goodlaike.henghua.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.goodlaike.henghua.config.StoreCountryStore;
import com.goodlaike.henghua.entity.model.Country;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.core.support.LanguageStore;

/**
 * 
 * @author jail
 */
public abstract class BaseController {

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

}
