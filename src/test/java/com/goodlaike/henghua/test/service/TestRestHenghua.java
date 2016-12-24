package com.goodlaike.henghua.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.goodlaike.henghua.entity.model.HenghuaSample;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.protocal.RestHenghua;
import com.goodlaike.henghua.test.TestBase;

public class TestRestHenghua extends TestBase {


  @Autowired
  private RestHenghua restHenghua;


  @Test
  public void testObject() {

    Map<String, Object> map = new HashMap<>();
    map.put("name", "abc\r\n\"def");
    System.out.println(JSONObject.toJSONString(map));

  }


  @Test
  public void testList() {
    String restStr =
        "{\"result\":[\"{\r\n \"YK1C0001\":\"{\\r\\n \\\"\u6837\u5361ID\\\":\\\"YK1C0001\\\",\\r\\n \\\"\u6837\u5361\u522B\u540D\\\":\\\"YK130001\\\",\\r\\n \\\"\u5462\u79F0\\\":\\\"MILANO\\\",\\r\\n \\\"\u6837\u54C1\u5217\u8868\\\":\\\"HK12216-3,HK12216-1,HK12216-2\\\",\\r\\n \\\"\u539F\u6599\u6210\u5206\\\":\\\"100%COTTON\\\",\\r\\n \\\"\u4E2D\u6587\u63CF\u8FF0\\\":\\\"40*802+402\u4F18\u8D28\u957F\u7ED2\u68C9\u914D\u6709\u6BB5\u67D3\u5DE5\u827A\uFF0C\u8BBE\u8BA1\u5E08\u900F\u8FC7\u9762\u6599\u5C55\u73B0\u51FA\u9752\u6625\u6D3B\u529B\u7F8E\u3002\\\",\\r\\n \\\"\u82F1\u6587\u63CF\u8FF0\\\":\\\"\\\",\\r\\n \\\"\u5EFA\u5361\u65F6\u95F4\\\":\\\"2013-06-27 18:04:24\\\"\\r\\n}\"\r\n}\",\"{\r\n \"YK1C0002\":\"{\\r\\n \\\"\u6837\u5361ID\\\":\\\"YK1C0002\\\",\\r\\n \\\"\u6837\u5361\u522B\u540D\\\":\\\"YK130002\\\",\\r\\n \\\"\u5462\u79F0\\\":\\\"MILANO\\\",\\r\\n \\\"\u6837\u54C1\u5217\u8868\\\":\\\"HK12216-3,HK12216-1,HK12216-2\\\",\\r\\n \\\"\u539F\u6599\u6210\u5206\\\":\\\"100%COTTON\\\",\\r\\n \\\"\u4E2D\u6587\u63CF\u8FF0\\\":\\\"40*802\\\\/+402\u4F18\u8D28\u957F\u7ED2\u68C9\u914D\u6709\u6BB5\u67D3\u5DE5\u827A\uFF0C\u8BBE\u8BA1\u5E08\u900F\u8FC7\u9762\u6599\u5C55\u73B0\u51FA\u9752\u6625\u6D3B\u529B\u7F8E\u3002\\\",\\r\\n \\\"\u82F1\u6587\u63CF\u8FF0\\\":\\\"\\\",\\r\\n \\\"\u5EFA\u5361\u65F6\u95F4\\\":\\\"2013-06-27 18:04:24\\\"\\r\\n}\"\r\n}\"]}";

    List<HenghuaSample> sampleList = this.restHenghua.getListByRegex(restStr, HenghuaSample.class);

    System.out.println(sampleList);
  }

  @Test
  public void aaa() {
    String restStr =
        "{\"样品编码\":\"HC130121-01\",\"Jpg\":\"\",\"Png\":\"3mmrb1.png\",\"Video\":\"\",\"样卡序列\":\"YK1W0293-6\",\"中文品名\":\"全棉色织布\",\"英文品名\":\"\",\"品级\":\"C\",\"原料\":\"C\",\"风格\":\"\",\"季节\":\"\",\"幅宽\":\"57/58\",\"克重\":\"\",\"织物名称\":\"\",\"组织\":\"\",\"颜色分类\":\"\",\"原料分类\":\"\",\"整理方式\":\"\"}";


    System.out.println(JSONObject.parseObject(restStr, HenghuaSampleDetail.class));
  }

}
