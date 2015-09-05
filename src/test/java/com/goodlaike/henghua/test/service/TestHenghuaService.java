package com.goodlaike.henghua.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.henghua.service.HenghuaService;
import com.goodlaike.henghua.test.BaseTest;

/**
 * HenghuaService Test
 * 
 * @author jail
 */
public class TestHenghuaService extends BaseTest {

    @Autowired
    private HenghuaService henghuaService;

    @Test
    public void getSampleType() {
        System.out.println(henghuaService.getSampleType("cn"));
        System.out.println(henghuaService.getSampleType("en"));
    }

    @Test
    public void syncHenghuaSampleList() {
        henghuaService.syncHenghuaSampleList();
    }

    @Test
    public void getNextSampleList() {
        System.out.println(henghuaService.getNextSampleList(0));
    }

    @Test
    public void getSampleDetail() {
        System.out.println(henghuaService.getSampleDetail("HK12216-3"));
    }

    @Test
    public void getSampleDetailFilter() {
        System.out.println(henghuaService.getSampleDetailFilter("cn", "正装,四季"));
    }

    @Test
    public void syncHenghuaClothList() {
        henghuaService.syncHenghuaClothList();
    }

    @Test
    public void getNextClothList() {
        System.out.println(henghuaService.getNextClothList(0));
    }

    @Test
    public void getCloth() {
        System.out.println(henghuaService.getCloth("SA0201_04"));
    }

    @Test
    public void getClothDetail() {
        System.out.println(henghuaService.getClothDetail("SA0201_04"));
    }

    @Test
    public void getWashingMap() {
        System.out.println(henghuaService.getWashingMap());
        System.out.println(henghuaService.getWashingMap());
        System.out.println(henghuaService.getWashingMap());
    }
    
    @Test
    public void getClothType() {
        System.out.println(henghuaService.getClothType());
        System.out.println(henghuaService.getClothType());
        System.out.println(henghuaService.getClothType());
    }
}
