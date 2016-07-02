package com.goodlaike.henghua.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goodlaike.business.core.support.LanguageStore;
import com.goodlaike.henghua.dao.HenghuaClothDao;
import com.goodlaike.henghua.dao.HenghuaSampleDao;
import com.goodlaike.henghua.dao.HenghuaSampleDetailDao;
import com.goodlaike.henghua.entity.model.HenghuaCloth;
import com.goodlaike.henghua.entity.model.HenghuaClothDetail;
import com.goodlaike.henghua.entity.model.HenghuaSample;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail2;
import com.goodlaike.henghua.entity.model.VHenghuaSample;
import com.goodlaike.henghua.protocal.RestHenghua;
import com.goodlaike.henghua.protocal.SampleFilter;
import com.goodlaike.tools.utils.CoderUtil;

/**
 * 
 * @author jail
 */
@Service
@Lazy(true)
@EnableCaching(proxyTargetClass = true)
public class HenghuaService {

  private Logger logger = Logger.getLogger(getClass());

  @Autowired
  private HenghuaSampleDao henghuaSampleDao;
  @Autowired
  private HenghuaSampleDetailDao henghuaSampleDetailDao;
  @Autowired
  private HenghuaClothDao henghuaClothDao;
  @Autowired
  private RestHenghua restHenghua;

  /**
   * 根据 样卡名获得样卡详情
   * 
   * @param cardId 样卡名
   * @return HenghuaSample
   * @author jail
   */
  @Cacheable(value = "sample", key = "'HenghuaService.getSample.'+#cardId")
  public HenghuaSample getSample(String cardId) {
    HenghuaSample sample = henghuaSampleDao.findSample(cardId);
    if (sample != null) {
      bindSampleDetailData(Arrays.asList(sample));
    }
    return sample;
  }

  /**
   * 获得下一页样品数据
   * 
   * @param id
   * @return
   * @author jail
   */
  public List<HenghuaSample> getNextSampleList(long id) {
    List<HenghuaSample> list = henghuaSampleDao.findNextList(id);
    bindSampleDetailData(list);
    return list;
  }

  /**
   * 样卡搜索
   * 
   * @param lang
   * @param filter
   * @return
   * @author jail
   */
  public List<HenghuaSample> search(long id, String level, String style, String gramWeight, String season, String zuzhi, String fabrics,
      String colorTypes, String clearTypes, String materialTypes) {
    List<HenghuaSample> list =
        this.henghuaSampleDao.search(id, level, style, gramWeight, season, zuzhi, fabrics, colorTypes, clearTypes, materialTypes);
    bindSampleDetailData(list);
    return list;
  }

  /**
   * 绑定样品数据到 detailList
   * 
   * @param list
   * @summary
   * @author Jail Hu
   * @version v1
   * @since 2016年6月11日 下午7:46:23
   */
  private void bindSampleDetailData(List<HenghuaSample> list) {
    if (list.size() == 0) {
      return;
    }
    Map<String, Object> map = list.stream().collect(Collectors.toMap(HenghuaSample::getCardId, (s) -> {
      return StringUtils.isNotBlank(s.getSampleList()) ? Arrays.asList(s.getSampleList().split(",")) : Collections.emptyList();
    }));
    Map<String, List<HenghuaSampleDetail2>> resultMap = this.getSampleDetailList(map);
    list.forEach(sample -> {
      ((VHenghuaSample) sample).setDetailList(resultMap.get(sample.getCardId()));
    });
  }

  /**
   * 获取样品到样卡
   * 
   * @param sample
   * @author jail
   */
  public Map<String, List<HenghuaSampleDetail2>> getSampleDetailList(Map<String, Object> map) {
    return this.henghuaSampleDetailDao.findSampleDetails(map).stream().collect(Collectors.groupingBy(HenghuaSampleDetail2::getCardIds));
  }

  /**
   * 同步所有的样卡数据
   * 
   * @author jail
   */
  public void syncAllHenghuaSample() {
    List<HenghuaSample> list = this.restHenghua.restSampleAll();
    henghuaSampleDao.batchReplaceInto(list, true);
  }

  /**
   * 从官方主机获得样卡详情
   * 
   * @param cardId 样卡ID
   * @return HenghuaSample
   * @summary 从官方主机获得样卡详情
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 上午11:34:09
   */
  public HenghuaSample getSampleFromHost(String cardId) {
    return this.restHenghua.restSample(cardId);
  }

  /**
   * 获得样品详情
   * 
   * @param detailName
   * @return HenghuaSampleDetail
   * @author jail
   */
  @Cacheable(value = "sampleDetail", key = "'HenghuaService.getSampleDetail.'+#detailId")
  public HenghuaSampleDetail2 getSampleDetail(String detailId) {
    return this.henghuaSampleDetailDao.findSampleDetail(detailId);
  }

  /**
   * 从官方主机根据样品编号获得样品详情
   * 
   * @param detailId 样品编号
   * @return HenghuaSampleDetail2
   * @summary 从官方主机根据样品编号获得样品详情
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 下午4:27:20
   */
  public HenghuaSampleDetail2 getSampleDetailFromHost(String detailId) {
    return this.restHenghua.restSampleDatail(detailId);
  }

  /**
   * 同步所有的样卡数据
   * 
   * @author jail
   */
  public void syncAllHenghuaSampleDetail() {
    List<HenghuaSampleDetail2> list = this.restHenghua.restSampleDatailAll();
    this.henghuaSampleDetailDao.batchReplaceInto(list, true);
  }

  /**
   * 根据样品ID同步指定样品数据
   * 
   * @param detailId 样品ID
   * @summary 同步指定样品数据
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 下午5:50:51
   */
  public void syncHenghuaSampleDetail(String detailId) {
    HenghuaSampleDetail2 detail = this.restHenghua.restSampleDatail(detailId);
    this.henghuaSampleDetailDao.batchReplaceInto(Arrays.asList(detail), false);
  }

  /**
   * 根据样品对象同步指定样品数据
   * 
   * @param detail 样品对象
   * @summary 根据样品对象同步指定样品数据
   * @author Jail Hu
   * @version v1
   * @since 2016年6月5日 下午6:09:12
   */
  public void syncHenghuaSampleDetail(HenghuaSampleDetail2 detail) {
    Assert.hasText(detail.getDetailId(), "the argument [detailId] must not be null or empty");
    this.henghuaSampleDetailDao.batchReplaceInto(Arrays.asList(detail), false);
  }



  /**
   * 同步服装数据
   * 
   * @author jail
   */
  public void syncAllHenghuaClothList() {
    henghuaClothDao.batchReplaceInto(this.restHenghua.restClothAll(), true);
  }

  /**
   * 获得下一页服装数据
   * 
   * @param id
   * @return
   * @author jail
   */
  public List<HenghuaCloth> getNextClothList(long id) {
    List<HenghuaCloth> list = henghuaClothDao.findNextList(id);
    return list;
  }

  /**
   * 获得指定服装
   * 
   * @param serialNo
   * @return
   * @author jail
   */
  @Cacheable(value = "cloth", key = "#serialNo")
  public HenghuaCloth getCloth(String serialNo) {
    return henghuaClothDao.findCloth(serialNo);
  }

  /**
   * 获得服装详情
   * 
   * @param serialNo
   * @return
   * @author jail
   */
  @Cacheable(value = "clothDetail", key = "#serialNo")
  public HenghuaClothDetail getClothDetail(String serialNo) {
    String r = restHenghua.restClothDetail(serialNo);
    r = CoderUtil.decodeUnicode(r);
    JSONObject obj = JSONObject.parseObject(r);
    r = obj.getString("result").replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
    HenghuaClothDetail detail = JSONObject.parseObject(r, HenghuaClothDetail.class);
    return detail;
  }

  /**
   * 获得 样品分类
   * 
   * @param lang
   * @return
   * @author jail
   */
  @Cacheable(value = "globalConfig", key = "'HenghuaService.getSampleType.'+#lang")
  public List<SampleFilter> getSampleType(String lang) {
    lang = LanguageStore.getLanguage(lang);
    Map<String, List<String>> map = this.restHenghua.restSampleType(lang);
    List<SampleFilter> filterList = new ArrayList<>();
    map.forEach((k, v) -> {
      filterList.add(new SampleFilter(k, v));
    });
    return filterList;
  }

  /**
   * 获得洗标缓存MAP
   * 
   * @return
   * @author jail
   */
  public HenghuaWashingCacheMap getWashingMap() {
    if (this.washingCacheMap == null || this.washingCacheMap.isOutOfTime()) {
      this.washingCacheMap.clear();
      this.washingCacheMap.reActive();
      logger.debug("初始化===洗标");
      String r = restHenghua.restWashingList();
      r = CoderUtil.decodeUnicode(r);
      JSONObject obj = JSONObject.parseObject(r);
      r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]");
      JSONArray ar = JSONArray.parseArray(r);
      ar.forEach(a -> {
        JSONObject o = (JSONObject) a;
        o.keySet().forEach(key -> this.washingCacheMap.put(key, o.getString(key) + ".png"));
      });
    }
    return this.washingCacheMap;
  }

  /**
   * 洗标缓存 相关
   */
  private final HenghuaWashingCacheMap washingCacheMap = new HenghuaWashingCacheMap();

  private static class HenghuaWashingCacheMap extends HashMap<String, String> {

    private static final long serialVersionUID = 7155720117282678187L;
    private long timeout;

    public boolean isOutOfTime() {
      return System.currentTimeMillis() > this.timeout;
    }

    public void reActive() {
      this.timeout = System.currentTimeMillis() + 60 * 60 * 1000;
    }

    /**
     * 默认一天过期
     */
    public HenghuaWashingCacheMap() {}
  }

  /**
   * 获得服装分类缓存MAP
   * 
   * @return
   * @author jail
   */
  public HenghuaClothTypeCacheMap getClothType() {
    if (this.clothTypeCacheMap == null || this.clothTypeCacheMap.isOutOfTime()) {
      this.clothTypeCacheMap.clear();
      this.clothTypeCacheMap.reActive();
      logger.debug("初始化===服装分类");
      try {
        String r = restHenghua.restClothType();
        r = CoderUtil.decodeUnicode(r);
        JSONObject obj = JSONObject.parseObject(r);
        r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]").replaceAll("%, ", "%，");
        JSONArray ar = JSONArray.parseArray(r);
        ar.forEach(a -> {
          JSONObject o = (JSONObject) a;
          o.keySet().forEach(key -> this.clothTypeCacheMap.put(key, Arrays.asList(o.getString(key).split(","))));
        });
      } catch (Exception e) {

      }
    }
    return this.clothTypeCacheMap;
  }

  /**
   * 服装分类
   */
  private final HenghuaClothTypeCacheMap clothTypeCacheMap = new HenghuaClothTypeCacheMap();

  private static class HenghuaClothTypeCacheMap extends HashMap<String, List<String>> {

    private static final long serialVersionUID = -5907218724079254243L;
    private long timeout;

    public boolean isOutOfTime() {
      return System.currentTimeMillis() > this.timeout;
    }

    public void reActive() {
      this.timeout = System.currentTimeMillis() + 60 * 60 * 1000;
    }

    /**
     * 默认一天过期
     */
    public HenghuaClothTypeCacheMap() {}
  }

  /**
   * 获得服装筛选
   * 
   * @param filter
   * @return
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月5日下午7:04:33
   * @updator jail
   * @updateTime 2015年9月5日下午7:04:33
   */
  public List<HenghuaCloth> getClothFilter(String filter) {
    Assert.hasText(filter, "筛选条件不能为空");
    String[] t = filter.split(",");
    switch (t[0]) {
      case "Category":
      case "0":
        filter = "0," + t[1];
        break;
      case "Wearing":
      case "1":
        filter = "1," + t[1];
        break;
      case "Style":
      case "2":
        filter = "2," + t[1];
        break;
      default:
        throw new IllegalArgumentException("不支持此类型搜索");
    }
    String r = restHenghua.restClothFilter(filter);
    r = CoderUtil.decodeUnicode(r);
    JSONObject obj = JSONObject.parseObject(r);
    r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]");
    List<HenghuaCloth> list = JSONArray.parseArray(r, HenghuaCloth.class);
    // list.forEach(cloth -> cloth.setImage(cloth.getImage() + ".png"));
    return list;
  }

  public void test() {
    this.henghuaSampleDetailDao.test();
  }
}
