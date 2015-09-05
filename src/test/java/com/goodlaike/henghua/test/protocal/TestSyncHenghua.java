package com.goodlaike.henghua.test.protocal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.henghua.protocal.RestHenghua;
import com.goodlaike.henghua.test.BaseTest;

/**
 * 
 * @author jail
 */
public class TestSyncHenghua extends BaseTest {

    @Autowired
    private RestHenghua syncHenghua;

    @Test
    public void restSampleType() {
        System.out.println(syncHenghua.restSampleType(0));
        System.out.println(syncHenghua.restSampleType(1));
    }
    
    @Test
    public void restClothAll() {
        System.out.println(syncHenghua.restClothAll());
    }
    
    @Test
    public void adf(){
        String a = "aaaa\"竹节棉纱+DUPONT NYLON 66+LYCRA弹力\"bbb";
        System.out.println(a.replaceAll("\"竹节棉纱\\+DUPONT NYLON 66\\+LYCRA弹力\"", ""));
    }
}
