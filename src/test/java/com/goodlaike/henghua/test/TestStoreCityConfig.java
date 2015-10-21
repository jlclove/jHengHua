package com.goodlaike.henghua.test;

import org.junit.Test;

import com.goodlaike.henghua.config.StoreCityStore;

/**
 * StoreCityConfig Test类
 * 
 * @author jail
 */
public class TestStoreCityConfig extends TestBase {

    @Test
    public void test() {
        System.out.println(StoreCityStore.getCountryList("en"));

    }

    @Test
    public void test2() {
        System.out.println(StoreCityStore.getCountry("en", 1));
    }
}
