package com.goodlaike.henghua.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.henghua.service.StoreService;
import com.goodlaike.henghua.test.TestBase;

public class TestStoreService extends TestBase {

    @Autowired
    private StoreService storeService;

    @Test
    public void insert() {
        storeService.insertStore(1, "上海公馆店", "静安区宝安路699号", "上海", "210004", "86 15566224578", "org.png", "10:00-18:00",
                "10:00-19:00", "10:00-20:00", "10:00-21:00", "10:00-22:00", "10:00-23:00", "10:00-23:59", 8);
    }

    @Test
    public void update() {
        Assert.assertTrue(storeService.updateStore(1, 1, "上海公馆店", "静安区宝安路699号", "上海", "210004", "86 15566224578",
                "org.png", "10:00-18:00", "10:00-19:00", "10:00-20:00", "10:00-21:00", "10:00-22:00", "10:00-23:00",
                "10:00-23:59", 8, "cn"));
    }

    @Test
    public void update2() {
        Assert.assertTrue(storeService.updateStore(1, 1, "上海公馆店3", "静安区宝安路699号22", "上海11", "210004", "86 15566224578",
                "org.png", "10:00-18:00", "10:00-19:00", "10:00-20:00", "10:00-21:00", "10:00-22:00", "10:00-23:00",
                "10:00-23:59", 8, "en"));
    }

    @Test
    public void delete() {
        Assert.assertTrue(storeService.deleteStore(1, 8));
    }

    @Test
    public void getStore() {
        Assert.assertNotNull(storeService.getStore(1, "cn"));
    }

    @Test
    public void getStoreList() {
        Assert.assertTrue(storeService.getStoreList(1, "cn").size() > 0);
    }
}
