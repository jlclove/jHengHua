package com.goodlaike.henghua.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.henghua.entity.model.Country;

/**
 * 全球门店 - 国家列表
 * 
 * @author jail
 */
public final class StoreCountryStore extends HashMap<String, List<Country>> {

    private static final long serialVersionUID = -5572768972086381788L;

    private static StoreCountryStore store;

    /**
     * 单例
     * 
     * @return
     * @author jail
     */
    private static synchronized StoreCountryStore getInstance() {
        if (store == null) {
            try {
                store = new StoreCountryStore();
                File file = new File(StoreCountryStore.class.getClassLoader().getResource("store_countries.js").toURI());
                FileInputStream is = new FileInputStream(file);
                InputStreamReader r = new InputStreamReader(is);
                BufferedReader bufferedReader = new BufferedReader(r);
                StringBuilder sb = new StringBuilder();
                String c;
                while ((c = bufferedReader.readLine()) != null) {
                    sb.append(c);
                }
                r.close();
                is.close();
                @SuppressWarnings("unchecked")
                HashMap<String, Object> map = JSONObject.parseObject(sb.toString(), HashMap.class);
                map.forEach((k, v) -> {
                    String jsonString = ((JSONArray) v).toJSONString();
                    List<Country> list = JSONObject.parseArray(jsonString, Country.class);
                    store.put(k, list);
                });
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }
        return store;
    }

    /**
     * 获得当前语言环境下的国家List
     * 
     * @param request
     * @return List<Country>
     * @author jail
     */
    public static List<Country> getCountryList(HttpServletRequest request) {
        String lang = LanguageHelper.getLocalization(request);
        return getCountryList(lang);
    }

    /**
     * 获得指定语言下的国家List
     * 
     * @param lang
     *            语言
     * @return List<Country>
     * @author jail
     */
    public static List<Country> getCountryList(String lang) {
        return StoreCountryStore.getInstance().get(lang);
    }

    /**
     * 获得指定ID的country对象
     * 
     * @param request
     * @param id
     * @return Country
     */
    public static Country getCountry(HttpServletRequest request, int id) {
        String lang = LanguageHelper.getLocalization(request);
        return getCountry(lang, id);
    }

    /**
     * 获得指定ID的country对象
     * 
     * @param lang
     * @param id
     * @return Country
     */
    public static Country getCountry(String lang, int id) {
        List<Country> countryList = getCountryList(lang);
        Optional<Country> stream = countryList.stream().filter(country -> country.getId() == id).findFirst();
        return stream.get();
    }
}
