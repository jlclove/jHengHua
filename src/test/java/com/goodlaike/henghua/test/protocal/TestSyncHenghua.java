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
}
