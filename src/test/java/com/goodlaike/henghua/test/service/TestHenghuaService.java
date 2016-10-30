package com.goodlaike.henghua.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.henghua.entity.model.HenghuaSample;
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
		 * String a = "{\"YK1X0007\": {\\\"英文描述\\\": \\\"\\\"}}"; a =
		 * a.replaceAll("\\\\\\\"", "\""); System.out.println(a);
		 * System.out.println(JSONObject.parse(a));
		 */

		this.henghuaService.test();
	}

	@Test
	public void getSampleType() {
		System.out.println(henghuaService.getSampleType("cn"));
		System.out.println(henghuaService.getSampleType("en"));
	}

	// 同步所有的样卡数据
	@Test
	public void syncAllSample() {
		henghuaService.syncAllSample();
	}

	// 同步单条样卡数据
	@Test
	public void syncSample() {
		System.out.println(this.henghuaService.syncSample("YK150001"));
	}

	// 从服务器获得样卡详情
	@Test
	public void getSampleFromHost() {
		System.out.println(henghuaService.getSampleFromHost("YK150001"));
	}

	// 获得样卡详情
	@Test
	public void getSample() {
		HenghuaSample sample = this.henghuaService.getSample("YK1W0034");
		System.out.println(sample);
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

	// 获得指定样品库存信息
	@Test
	public void getSampleDetailQuantity() {
		System.out.println(this.henghuaService.getSampleDetailQuantity("HK140498-01"));
	}

	// 同步所有样品数据
	@Test
	public void syncAllSampleDetail() {
		this.henghuaService.syncAllSampleDetail();
	}

	// 同步单条样品数据
	@Test
	public void syncSampleDetail() {
		this.henghuaService.syncSampleDetail("HC130121-01");
	}

	// 搜索样卡
	@Test
	public void searchSample() {
		List<HenghuaSample> list = henghuaService.searchSample(Integer.MAX_VALUE, null, null, null, null, null, null,
				null, null, null, null, false);
		System.out.println(list);
	}

	// 同步所有服装款式
	@Test
	public void syncAllCloth() {
		henghuaService.syncAllCloth();
	}

	// 获得服装详情
	@Test
	public void getCloth() {
		System.out.println(henghuaService.getCloth("SAA0201_01"));
	}

	// 从官方主机获得服装详情
	@Test
	public void getClothFromHost() {
		System.out.println(henghuaService.getClothFromHost("SAA0201_01"));
	}

	@Test
	public void syncCloth() {
		System.out.println(this.henghuaService.syncCloth("SAA0201_01"));
	}

	@Test
	public void getClothQuantity() {
		System.out.println(this.henghuaService.getClothQuantity("SAA0201101"));
	}

	// 搜索服装
	@Test
	public void searchCloth() {
		System.out.println(
				henghuaService.searchCloth(0, null, null, null, null, null, "LABEL TOP 长袖系列,PURPLE LABEL 长袖系列", null));
	}

	// 获得所有洗标Map
	@Test
	public void getWashingMap() {
		System.out.println(henghuaService.getWashingAllMap());
		System.out.println(henghuaService.getWashingAllMap());
		System.out.println(henghuaService.getWashingAllMap());
	}

	@Test
	public void getClothType() {
		System.out.println(henghuaService.getClothType());
		System.out.println(henghuaService.getClothType());
		System.out.println(henghuaService.getClothType());
	}

	// 获得最新活动列表(所有)
	@Test
	public void restHenghuaExhibition() {
		System.out.println(this.henghuaService.getExhibitionAll());
	}
}
