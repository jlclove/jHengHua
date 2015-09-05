package com.goodlaike.henghua.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goodlaike.business.core.support.LanguageStore;
import com.goodlaike.henghua.dao.HenghuaClothDao;
import com.goodlaike.henghua.dao.HenghuaSampleDao;
import com.goodlaike.henghua.entity.model.HenghuaCloth;
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
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日上午11:55:16
     * @updator jail
     * @updateTime 2015年9月5日上午11:55:16
     */
    public HenghuaSample getSample(String cardId) {
        HenghuaSample sample = henghuaSampleDao.getSample(cardId);
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
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午6:14:47
     * @updator jail
     * @updateTime 2015年9月4日下午6:14:47
     */
    public List<HenghuaSample> getNextSampleList(long id) {
        List<HenghuaSample> list = henghuaSampleDao.getNextList(id);
        list.forEach(sample -> {
            this.formatSampleDetail(sample);
        });
        return list;
    }

    /**
     * 格式化 图片到 样品
     * 
     * @param sample
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日上午11:58:55
     * @updator jail
     * @updateTime 2015年9月5日上午11:58:55
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
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午6:14:18
     * @updator jail
     * @updateTime 2015年9月4日下午6:14:18
     */
    public void syncHenghuaSampleList() {
        henghuaSampleDao.batchReplaceInto(this.getSampleAll());
    }

    /**
     * 获得样品详情
     * 
     * @param detailName
     * @return HenghuaSampleDetail
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午11:50:43
     * @updator jail
     * @updateTime 2015年9月4日下午11:50:43
     */
    public HenghuaSampleDetail getSampleDetail(String detailName) {
        String r = restHenghua.restSampleDetail(detailName);
        r = CoderUtil.decodeUnicode(r);
        JSONObject obj = JSONObject.parseObject(r);
        r = obj.getString("result").replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
        System.out.println(r);
        HenghuaSampleDetail detail = JSONObject.parseObject(r, HenghuaSampleDetail.class);
        detail.setDetailName(detailName);
        System.out.println(detail);
        return detail;
    }

    /**
     * 获得 所有样品
     * 
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午12:27:55
     * @updator jail
     * @updateTime 2015年9月4日下午12:27:55
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
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日上午9:48:33
     * @updator jail
     * @updateTime 2015年9月5日上午9:48:33
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
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午6:14:18
     * @updator jail
     * @updateTime 2015年9月4日下午6:14:18
     */
    public void syncHenghuaClothList() {
        henghuaClothDao.batchReplaceInto(this.getClothAll());
    }

    /**
     * 获得下一页服装数据
     * @param id
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午2:04:03
     * @updator jail
     * @updateTime 2015年9月5日下午2:04:03
     */
    public List<HenghuaCloth> getNextClothList(long id) {
        List<HenghuaCloth> list = henghuaClothDao.getNextList(id);
        return list;
    }

    /**
     * 获得所有服装数据
     * 
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午1:56:49
     * @updator jail
     * @updateTime 2015年9月5日下午1:56:49
     */
    private List<HenghuaCloth> getClothAll() {
        String r = restHenghua.restClothAll();
        r = CoderUtil.decodeUnicode(r);
        JSONObject obj = JSONObject.parseObject(r);
        r = obj.getString("result").replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]");
        return JSONArray.parseArray(r, HenghuaCloth.class);
    }

    private final HenghuaSampleTypeCacheMap cacheMap = new HenghuaSampleTypeCacheMap();

    /**
     * 获得 样品分类
     * 
     * @param lang
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日上午11:50:42
     * @updator jail
     * @updateTime 2015年9月4日上午11:50:42
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
}
