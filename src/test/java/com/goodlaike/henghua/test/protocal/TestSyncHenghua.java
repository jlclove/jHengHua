package com.goodlaike.henghua.test.protocal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.henghua.protocal.RestHenghua;
import com.goodlaike.henghua.test.TestBase;

/**
 * 
 * @author jail
 */
public class TestSyncHenghua extends TestBase {

  @Autowired
  private RestHenghua syncHenghua;

  @Test
  public void restSampleType() {
    System.out.println(syncHenghua.restSampleType("cn"));
  }

  @Test
  public void restClothAll() {
    System.out.println(syncHenghua.restClothAll());
  }

  @Test
  public void adf() {
    String a = "aaaa\"竹节棉纱+DUPONT NYLON 66+LYCRA弹力\"bbb";
    System.out.println(a.replaceAll("\"竹节棉纱\\+DUPONT NYLON 66\\+LYCRA弹力\"", ""));
  }
}
