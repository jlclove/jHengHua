package com.goodlaike.henghua.test;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.goodlaike.henghua.config.StoreCityStore;

/**
 * StoreCityConfig Test类
 * @author jail
 */
public class TestStoreCityConfig extends TestBase{

    
    @Test
    public void test(){
        System.out.println(StoreCityStore.getInstance());
        
    }
    
    @Test
    public void test2(){
        String a = "{'cn':[{'name':'中国','id':1}],'en':[{'name':'China','id':1}]}";
        System.out.println(JSONObject.parseObject(a, HashMap.class));
    }
}
