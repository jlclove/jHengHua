package com.goodlaike.henghua.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.goodlaike.henghua.entity.model.HenghuaCloth;
import com.goodlaike.henghua.entity.model.HenghuaClothDetail;
import com.goodlaike.henghua.entity.model.HenghuaSample;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.entity.model.VHenghuaSample;
import com.goodlaike.henghua.protocal.Language2Henghua;
import com.goodlaike.henghua.protocal.RestHenghua;
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
    private HenghuaClothDao henghuaClothDao;
    @Autowired
    private RestHenghua restHenghua;

    /**
     * 根据 样卡名获得样卡详情
     * 
     * @param cardId
     *            样卡名
     * @return HenghuaSample
     * @author jail
     */
    @Cacheable(value = "sample", key = "#cardId")
    public HenghuaSample getSample(String cardId) {
        HenghuaSample sample = henghuaSampleDao.findSample(cardId);
        if (sample != null) {
            this.formatSampleDetail(sample);
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
        list.forEach(sample -> {
            this.formatSampleDetail(sample);
        });
        return list;
    }

    /**
     * 格式化 图片到 样品
     * 
     * @param sample
     * @author jail
     */
    private void formatSampleDetail(HenghuaSample sample) {
        for (String detail : sample.getSample2Img().split(",")) {
            String[] d = detail.split("=");
            if (d.length == 2) {
                HenghuaSampleDetail dd = new HenghuaSampleDetail();
                dd.setCardBak(d[0]);
                dd.setPicPath(d[1]);
                ((VHenghuaSample) sample).detailList.add(dd);
            }
        }
        ((VHenghuaSample) sample).detailList
                .sort((d1, d2) -> Integer.compare(d1.getDetailIndex(), d2.getDetailIndex()));
    }

    /**
     * 同步样卡数据
     * 
     * @author jail
     */
    public void syncHenghuaSampleList() {
        henghuaSampleDao.batchReplaceInto(this.getSampleAll());
    }

    /**
     * 获得样品详情
     * 
     * @param detailName
     * @return HenghuaSampleDetail
     * @author jail
     */
    @Cacheable(value = "sampleDetail", key = "#detailName")
    public HenghuaSampleDetail getSampleDetail(String detailName) {
        String r = restHenghua.restSampleDetail(detailName);
        r = CoderUtil.decodeUnicode(r);
        JSONObject obj = JSONObject.parseObject(r);
        r = obj.getString("result").replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
        HenghuaSampleDetail detail = JSONObject.parseObject(r, HenghuaSampleDetail.class);
        detail.setDetailName(detailName);
        System.out.println(detail);
        return detail;
    }

    /**
     * 获得 所有样品
     * 
     * @return
     * @author jail
     */
    private List<HenghuaSample> getSampleAll() {
        String r = restHenghua.restSampleAll();
        r = CoderUtil.decodeUnicode(r);
        r = r.replace("\"独一无二\"", "'独一无二'").replace("\"唯一\"", "'唯一'").replace("\"彩点\"", "'彩点'")
                .replace("\"竹节棉纱", "'竹节棉纱").replace("LYCRA弹力\"", "LYCRA弹力'").replace("\"黄色\"", "'黄色'")
                .replaceAll("\"我是独一无二\"", "'我是独一无二'").replaceAll("\"宝格丽格\"", "'宝格丽格'")
                .replaceAll("\"德唯思现货\"", "'德唯思现货'");
        JSONObject obj = JSONObject.parseObject(r);
        r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]");
        return JSONArray.parseArray(r, HenghuaSample.class);
    }

    /**
     * 样品筛选
     * 
     * @param lang
     * @param filter
     * @return
     * @author jail
     */
    public List<HenghuaSampleDetail> getSampleDetailFilter(String lang, String filter) {
        lang = LanguageStore.getLanguage(lang);
        String r = restHenghua.restSampleFilter(Language2Henghua.getHenghuaParameter(lang), filter);
        r = CoderUtil.decodeUnicode(r);
        JSONObject obj = JSONObject.parseObject(r);
        r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]");
        return JSONArray.parseArray(r, HenghuaSampleDetail.class);
    }

    /**
     * 同步服装数据
     * 
     * @author jail
     */
    public void syncHenghuaClothList() {
        henghuaClothDao.batchReplaceInto(this.getClothAll());
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
     * 获得所有服装数据
     * 
     * @return
     * @author jail
     */
    private List<HenghuaCloth> getClothAll() {
        String r = restHenghua.restClothAll();
        r = CoderUtil.decodeUnicode(r);
        JSONObject obj = JSONObject.parseObject(r);
        r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]");
        return JSONArray.parseArray(r, HenghuaCloth.class);
    }

    /**
     * 获得 样品分类
     * 
     * @param lang
     * @return
     * @author jail
     */
    public Map<String, List<String>> getSampleType(String lang) {
        lang = LanguageStore.getLanguage(lang);
        HenghuaSampleTypeCache cache = this.cacheMap.get(lang);
        if (cache == null || cache.isOutOfTime()) {
            logger.debug("初始化===" + lang);
            HenghuaSampleTypeCache tempCache = new HenghuaSampleTypeCache();
            String r = restHenghua.restSampleType(Language2Henghua.getHenghuaParameter(lang));
            r = CoderUtil.decodeUnicode(r);
            JSONObject obj = JSONObject.parseObject(r);
            r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]");
            JSONArray ar = JSONArray.parseArray(r);
            ar.forEach(a -> {
                JSONObject o = (JSONObject) a;
                o.keySet().forEach(key -> {
                    tempCache.putIfAbsent(key, Arrays.asList(o.getString(key).split(",")));
                });
            });
            this.cacheMap.putIfAbsent(lang, tempCache);
            cache = tempCache;
        }
        return cache;
    }

    private final HenghuaSampleTypeCacheMap cacheMap = new HenghuaSampleTypeCacheMap();

    /**
     * 样品分类缓存
     * 
     * @author jail
     */
    private static class HenghuaSampleTypeCacheMap extends HashMap<String, HenghuaSampleTypeCache> {
        private static final long serialVersionUID = -7839720185089593810L;
    }

    private static class HenghuaSampleTypeCache extends HashMap<String, List<String>> {

        private static final long serialVersionUID = -2827403363818531281L;
        private long timeout;

        public boolean isOutOfTime() {
            return System.currentTimeMillis() > this.timeout;
        }

        /**
         * 默认一天过期
         */
        public HenghuaSampleTypeCache() {
            this(60 * 24);
        }

        public HenghuaSampleTypeCache(int mins) {
            this.timeout = System.currentTimeMillis() + mins * 60 * 1000;
        }
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
        public HenghuaWashingCacheMap() {
        }
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
            String r = restHenghua.restClothType();
            r = CoderUtil.decodeUnicode(r);
            JSONObject obj = JSONObject.parseObject(r);
            r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]").replaceAll("%, ", "%，");
            JSONArray ar = JSONArray.parseArray(r);
            ar.forEach(a -> {
                JSONObject o = (JSONObject) a;
                o.keySet().forEach(key -> this.clothTypeCacheMap.put(key, Arrays.asList(o.getString(key).split(","))));
            });
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
        public HenghuaClothTypeCacheMap() {
        }
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
        list.forEach(cloth -> cloth.setImage(cloth.getImage() + ".png"));
        return list;
    }
}
