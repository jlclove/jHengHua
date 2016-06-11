package com.goodlaike.henghua.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.henghua.service.HenghuaService;
import com.goodlaike.henghua.test.TestBase;

/**
 * HenghuaService Test
 * 
 * @author jail
 */
public class TestHenghuaService extends TestBase {

  @Autowired
  private HenghuaService henghuaService;


  @Test
  public void testHenghuaJsonFormat() {
    /*
     * String a = "{\"YK1X0007\": {\\\"英文描述\\\": \\\"\\\"}}"; a = a.replaceAll("\\\\\\\"", "\"");
     * System.out.println(a); System.out.println(JSONObject.parse(a));
     */

    this.henghuaService.test();
  }

  @Test
  public void getSampleType() {
    System.out.println(henghuaService.getSampleType("cn"));
    System.out.println(henghuaService.getSampleType("en"));
    // System.out.println(henghuaService.getSampleType("en"));
  }

  // 同步所有的样卡数据
  @Test
  public void syncAllHenghuaSample() {
    henghuaService.syncAllHenghuaSample();
  }

  // 从服务器获得样卡详情
  @Test
  public void getSampleFromHost() {
    System.out.println(henghuaService.getSampleFromHost("YK1C0012"));
  }

  // 获得样卡列表
  @Test
  public void getNextSampleList() {
    System.out.println(henghuaService.getNextSampleList(0));
  }

  // 获得样卡详情
  @Test
  public void getSample() {
    System.out.println(this.henghuaService.getSample("YK1C0001"));
  }

  // 获得样品详情
  @Test
  public void getSampleDetail() {
    System.out.println(henghuaService.getSampleDetail("HK12216-3"));
  }

  // 从服务器获得样品详情
  @Test
  public void getSampleDetailFromHost() {
    System.out.println(this.henghuaService.getSampleDetailFromHost("HC130124-01"));
  }

  // 同步所有样品数据
  @Test
  public void syncAllHenghuaSampleDetail() {
    this.henghuaService.syncAllHenghuaSampleDetail();
  }

  @Test
  public void syncHenghuaSampleDetail() {
    this.henghuaService.syncHenghuaSampleDetail("HC130217-02");
  }

  @Test
  public void search() {
    System.out.println(henghuaService.search(0, null, null, null, null, null, null, "黄", null, null));
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
