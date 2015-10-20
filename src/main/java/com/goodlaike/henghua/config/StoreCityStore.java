package com.goodlaike.henghua.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.goodlaike.business.core.CoreConfig;
import com.goodlaike.henghua.entity.model.Country;

/**
 * 全球门店 - 国家列表
 * 
 * @author jail
 */
public final class StoreCityStore extends HashMap<String, List<Country>> {

    private static final long serialVersionUID = -5572768972086381788L;

    private static StoreCityStore store;

    @SuppressWarnings("unchecked")
    public static synchronized StoreCityStore getInstance() {
        if (store == null) {
            store = new StoreCityStore();
            try {
                File file = new File(ClassLoader.getSystemClassLoader().getResource("store_countries.js").toURI());
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
                HashMap<String, String> countryMap = JSONObject.parseObject(sb.toString(), HashMap.class);
                System.out.println("=====" + countryMap);
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }
        return store;
    }
}
