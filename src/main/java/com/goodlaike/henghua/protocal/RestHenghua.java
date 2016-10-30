package com.goodlaike.henghua.protocal;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goodlaike.henghua.entity.model.HenghuaCloth;
import com.goodlaike.henghua.entity.model.HenghuaClothQuantity;
import com.goodlaike.henghua.entity.model.HenghuaExhibition;
import com.goodlaike.henghua.entity.model.HenghuaSample;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetailQuantity;
import com.goodlaike.henghua.entity.model.Washing;
import com.goodlaike.henghua.utils.HenghuaDamnJsonUtil;
import com.goodlaike.resttemplate.client.RestClient;
import com.goodlaike.tools.utils.CoderUtil;
import com.goodlaike.tools.utils.TextUtil;

/**
 * 恒华样卡同步类， 采用 @Component、@PropertySource 与 @Value 来实现，需要定义 @Bean <br>
 * public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() { <br>
 * return new PropertySourcesPlaceholderConfigurer();<br>
 * } 才能正确取到值 ， 已经迁移到 {@link com.goodlaike.henghua.config.AppConfigurer}
 * 
 * @author jail
 */
@Component
@PropertySource(value = {"classpath:api_henghua.properties"})
public class RestHenghua {

  @Value("${sample_all}")
  private String apiSampleAll;

  @Value("${sample}")
  private String apiSample;

  @Value("${sample_type}")
  private String apiSampleType;

  @Value("${sample_detail}")
  private String apiSampleDetail;

  @Value("${sample_detail_all}")
  private String apiSampleDetailAll;

  @Value("${sample_detail_quantity}")
  private String apiSampleDetailQuantity;

  @Value("${cloth_all}")
  private String apiClothAll;

  @Value("${cloth}")
  private String apiCloth;

  @Value("${cloth_quantity}")
  private String apiClothQuantity;

  @Value("${washing_all}")
  private String apiWashingAll;

  @Value("${cloth_type}")
  private String apiClothType;

  @Value("${recent_activity}")
  private String apiRecentActivity;

  // 恒华json头
  public static final String JSON_HEAD = "result";

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private static final boolean useRegexConvert = true;

  /**
   * 获得所有样卡数据， 接口提供非正常 json,当 json 输出
   * 
   * @return
   * @author jail
   */
  public String restSampleAllStr() {
    return this.rest(this.apiSampleAll);
  }

  /**
   * 获得所有的样卡数据
   * 
   * @return List<HenghuaSample>
   * @summary 获得所有的样卡数据
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 上午11:32:34
   */
  public List<HenghuaSample> restSampleAll() {
    String restStr = this.restSampleAllStr();
    return this.getList(restStr, HenghuaSample.class);
  }

  /**
   * 获得指定样卡ID的样卡数据
   * 
   * @param cardId 样卡ID
   * @return String 么办法，返回数据太混乱了
   * @summary 获得指定样卡ID的样卡数据
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 上午11:32:34
   */
  private String restSampleStr(String cardId) {
    return this.rest(TextUtil.format(this.apiSample, cardId));
  }

  /**
   * 获得指定样卡ID的样卡数据
   * 
   * @param cardId 样卡ID
   * @return HenghuaSample
   * @summary 获得指定样卡ID的样卡数据
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 上午11:32:34
   */
  public HenghuaSample restSample(String cardId) {
    String restStr = this.restSampleStr(cardId);
    return this.getObject(restStr, HenghuaSample.class);
  }

  /**
   * 根据语言参数 获得 接口的样品分类数据
   * 
   * @param langType 语言参数 ，0 中文 1英文
   * @return String
   * @author jail
   */
  private String restSampleTypeStr() {
    return this.rest(this.apiSampleType);
  }

  /**
   * 根据语言参数 获得 接口的样品分类数据
   * 
   * @param langType 语言参数 ，0 中文 1英文
   * @return String
   * @author jail
   */
  public Map<String, List<String>> restSampleType(String langType) {
    String typeStr = this.restSampleTypeStr();
    typeStr = HenghuaDamnJsonUtil.format(typeStr);
    JSONObject obj = JSONObject.parseObject(typeStr);
    // 获取 result key 下的伪数组
    String listStr = obj.getString(RestHenghua.JSON_HEAD);
    // 获取伪数组下的第一个元素
    String listDetailStr = JSONObject.parseArray(listStr, String.class).get(0);
    // 将内容转成json对象并分析所有的value
    JSONObject listObj = JSONObject.parseObject(listDetailStr);
    Map<String, List<String>> sampleTypeMap = new HashMap<String, List<String>>();
    listObj.forEach((k, v) -> {
      if (k.toLowerCase().startsWith(langType)) {
        sampleTypeMap.put(k.toLowerCase().replace(langType, ""), Arrays.asList(String.valueOf(v).split(",")));
      }
    });
    return sampleTypeMap;
  }

  /**
   * 获得指定样品数据
   * 
   * @param detailName
   * @return
   * @author jail
   */
  private String restSampleDetailStr(String detailId) {
    return this.rest(TextUtil.format(this.apiSampleDetail, detailId));
  }

  /**
   * 获得指定样品数据
   * 
   * @param detailId 样品编码
   * @return HenghuaSampleDetail2
   * @summary 获得指定样品数据
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 下午2:09:06
   */
  public HenghuaSampleDetail restSampleDatail(String detailId) {
    String restStr = this.restSampleDetailStr(detailId);
    return this.getObject(restStr, HenghuaSampleDetail.class);
  }

  /**
   * 获得全部样品数据
   * 
   * @return String
   * @author jail
   */
  private String restSampleDetailAllStr() {
    return this.rest(this.apiSampleDetailAll);
  }

  /**
   * 获得全部样品数据
   * 
   * @return List<HenghuaSampleDetail2>
   * @summary 获得全部样品数据
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 下午2:09:06
   */
  public List<HenghuaSampleDetail> restSampleDatailAll() {
    String restStr = this.restSampleDetailAllStr();
    return this.getList(restStr, HenghuaSampleDetail.class);
  }

  /**
   * 获得指定样品库存信息
   * 
   * @param detailId 样品编码
   * @return String
   */
  private String restSampleDetailQuantityStr(String detailId) {
    return this.rest(TextUtil.format(this.apiSampleDetailQuantity, detailId));
  }

  /**
   * 获得指定样品库存信息
   * 
   * @param detailId 样品编码
   * @return HenghuaSampleDetailQuantity
   */
  public HenghuaSampleDetailQuantity restSampleDetailQuantity(String detailId) {
    String restStr = this.restSampleDetailQuantityStr(detailId);
    return this.getObject(restStr, HenghuaSampleDetailQuantity.class);
  }

  /**
   * 获得所有服装款式
   * 
   * @return
   * @author jail
   */
  private String restClothAllStr() {
    return this.rest(this.apiClothAll);
  }

  /**
   * 获得所有服装款式
   * 
   * @return List<HenghuaCloth>
   * @author jail
   */
  public List<HenghuaCloth> restClothAll() {
    String clothStr = this.restClothAllStr();
    return this.getList(clothStr, HenghuaCloth.class);
  }

  /**
   * 获得服装详情
   * 
   * @param serialNo 服装内部编码
   * @return
   * @author jail
   */
  private String restClothStr(String serialNo) {
    return this.rest(TextUtil.format(this.apiCloth, serialNo));
  }

  /**
   * 获得服装详情
   * 
   * @param serialNo 服装内部编码
   * @return
   * @author jail
   */
  public HenghuaCloth restCloth(String serialNo) {
    String clothStr = this.restClothStr(serialNo);
    return this.getObject(clothStr, HenghuaCloth.class);
  }

  /**
   * 获得 洗标 的接口字符串
   * 
   * @return String
   * @summary 获得 洗标 的接口字符串
   * @author Jail Hu
   * @version v1
   * @since 2016年7月10日 下午8:33:48
   */
  private String restWashingAllStr() {
    return this.rest(this.apiWashingAll);
  }

  /**
   * 获得所有洗标
   * 
   * @return
   * @author jail
   */
  public Map<Integer, Washing> restWashingAllMap() {
    String washingStr = this.restWashingAllStr();
    washingStr = HenghuaDamnJsonUtil.format(washingStr);
    JSONObject obj = JSONObject.parseObject(washingStr);
    // 获取 result key 下的伪数组
    String listStr = obj.getString(RestHenghua.JSON_HEAD);
    // 获取伪数组下的第一个元素
    String listDetailStr = JSONObject.parseArray(listStr, String.class).get(0);
    // 将内容转成json对象并分析所有的value
    JSONObject listObj = JSONObject.parseObject(listDetailStr);
    Map<Integer, Washing> washingMap = new HashMap<Integer, Washing>();
    listObj.forEach((k, v) -> {
      washingMap.put(Integer.valueOf(k), JSONObject.parseObject(v.toString(), Washing.class));
    });
    return washingMap;
  }

  /**
   * 获得指定服装库存信息
   * 
   * @param sonSerialNo 服装子序列号，对应 {@link HenghuaCloth#getSonCodeList()}
   * @return String
   */
  private String restClothQuantityStr(String sonSerialNo) {
    return this.rest(TextUtil.format(this.apiClothQuantity, sonSerialNo));
  }

  /**
   * 获得指定服装库存信息
   * 
   * @param sonSerialNo 服装子序列号，对应 {@link HenghuaCloth#getSonCodeList()}
   * @return HenghuaClothQuantity
   */
  public HenghuaClothQuantity restClothQuantity(String sonSerialNo) {
    String restStr = this.restClothQuantityStr(sonSerialNo);
    return this.getObject(restStr, HenghuaClothQuantity.class);
  }

  /**
   * 获得服装分类
   * 
   * @return
   * @author jail
   */
  private String restClothTypeStr() {
    return this.rest(this.apiClothType);
  }

  /**
   * 获得最新活动列表(所有)
   * 
   * @return List<HenghuaExhibition>
   */
  public List<HenghuaExhibition> restHenghuaExhibitionAll() {
    String restStr = this.restExhibitionAllStr();
    return this.getList(restStr, HenghuaExhibition.class);
  }

  private String restExhibitionAllStr() {
    return this.rest(this.apiRecentActivity);
  }

  /**
   * 获得服装分类的数组Map
   * 
   * @return String Map<String, List<String>>
   * @author jail
   */
  public Map<String, List<String>> restClothType() {
    String typeStr = this.restClothTypeStr();
    typeStr = HenghuaDamnJsonUtil.format(typeStr);
    JSONObject obj = JSONObject.parseObject(typeStr);
    // 获取 result key 下的伪数组
    String listStr = obj.getString(RestHenghua.JSON_HEAD);
    // 获取伪数组下的第一个元素
    String listDetailStr = JSONObject.parseArray(listStr, String.class).get(0);
    // 将内容转成json对象并分析所有的value
    JSONObject listObj = JSONObject.parseObject(listDetailStr);
    Map<String, List<String>> clothTypeMap = new HashMap<String, List<String>>();
    listObj.forEach((k, v) -> {
      clothTypeMap.put(k, Arrays.asList(String.valueOf(v).split(",")));
    });
    return clothTypeMap;
  }

  private String rest(String url) {
    System.out.println("==============>>" + url);
    return RestClient.exchange(url, HttpMethod.GET, String.class);
  }

  /**
   * 获得目标对象
   * 
   * @param restStr 恒华接口返回的“json”字符串
   * @param clazz 转换对象类
   * @return <T>
   * @summary 获得目标对象
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 下午12:01:31
   */
  public <T> T getObject(String restStr, Class<T> clazz) {
    try {
      restStr = HenghuaDamnJsonUtil.format(restStr);
      System.out.println(restStr);
      JSONObject obj = JSONObject.parseObject(restStr);
      JSONArray array = obj.getJSONArray("result");
      if (array.size() == 1) {
        return array.getObject(0, clazz);
      }
      return null;
    } catch (Exception e) {
      logger.error("===>>getObject 接口返回异常，ex：【{}】", e.getMessage());
      return null;
    }
  }

  public <T> List<T> getList(String restStr, Class<T> clazz) {
    if (useRegexConvert) {
      return this.getListByRegex(restStr, clazz);
    } else {
      return this.getListByJson(restStr, clazz);
    }
  }

  /**
   * 获得目标对象列表
   * 
   * @param restStr 恒华接口返回的“json”字符串
   * @param clazz 转换对象类
   * @return List<T>
   * @summary 获得目标对象列表
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 下午12:59:22
   */
  public <T> List<T> getListByJson(String restStr, Class<T> clazz) {
    try {
      restStr = HenghuaDamnJsonUtil.format(restStr);
      JSONObject obj = JSONObject.parseObject(restStr);
      // 获取 result key 下的伪数组
      String listStr = obj.getString(RestHenghua.JSON_HEAD);
      // 获取伪数组下的第一个元素
      List<String> strList = JSONObject.parseArray(listStr, String.class);
      if (strList.size() > 0) {
        String listDetailStr = strList.get(0);
        // 将内容转成json对象并分析所有的value
        JSONObject listObj = JSONObject.parseObject(listDetailStr);
        List<T> list = new ArrayList<T>();
        for (Object o : listObj.values()) {
          list.add(JSONObject.parseObject(o.toString(), clazz));
        }
        return list;
      } else {
        return new ArrayList<>();
      }
    } catch (Exception e) {
      logger.error("===>>getList 接口返回异常，ex：【{}】", e.getMessage());
      return new ArrayList<>();
    }
  }

  public <T> List<T> getListByRegex(String restStr, Class<T> clazz) {
    Pattern patt = Pattern.compile("\\{\"result\":\\[([\\s\\S]*)?\\]\\}");
    Matcher matcher = patt.matcher(restStr);
    if (matcher.matches()) {
      List<T> tList = new ArrayList<>();
      String listStr = matcher.group(1);
      listStr = CoderUtil.decodeUnicode(listStr);
      // System.out.println("===========" + listStr);
      Pattern patt2 = Pattern.compile("\"[\\s\\S]*?:\"(\\{[\\s\\S]*?\\})\"");
      Matcher matcher2 = patt2.matcher(listStr);
      while (matcher2.find()) {
        String str = matcher2.group(1);
        str = HenghuaDamnJsonUtil.formatForRegex(str);
        // System.out.println("++++" + str);
        try {
          tList.add(JSONObject.parseObject(str, clazz));
        } catch (Exception e) {
          logger.error("=== json 数据转换失败， ex：【{}】，data：【{}】", e.getMessage(), str);
        }
      }
      return tList;
    } else {
      return new ArrayList<>();
    }
  }
}
