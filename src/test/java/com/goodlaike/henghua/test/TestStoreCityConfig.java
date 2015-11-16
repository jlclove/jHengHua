package com.goodlaike.henghua.test;

import org.junit.Test;

import com.goodlaike.henghua.config.StoreCountryStore;

/**
 * StoreCityConfig Test类
 * 
 * @author jail
 */
public class TestStoreCityConfig extends TestBase {

	@Test
	public void test() {
		System.out.println(StoreCountryStore.getCountryList("en"));

	}

	@Test
	public void test2() {
		System.out.println(StoreCountryStore.getCountry("en", 1));
	}
}
