package com.goodlaike.henghua.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.goodlaike.henghua.entity.model.HenghuaSample;

/**
 * 
 * @author jail
 */
@Repository
@Lazy(true)
public class HenghuaSampleDao extends LocalRWDao<HenghuaSample> {

  /**
   * 批量插入数据了，100条一次
   * 
   * @param sampleList
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月3日下午8:58:56
   * @updator jail
   * @updateTime 2015年9月3日下午8:58:56
   */
  public void batchReplaceInto(List<HenghuaSample> sampleList, boolean deleteOutOfTime) {
    Date updateTime = new Date();
    super.batchOperate(100, sampleList, new BatchOperation(super.getSqlSession()) {
      @Override
      public int process(List<?> dataList) {
        int effectCount = this.getSqlSession().update("HenghuaSample.updateSource", dataList);
        effectCount += this.getSqlSession().insert("HenghuaSample.insertSource", dataList);

        // 删除扩展属性
        this.getSqlSession().delete("HenghuaSample.deleteCardDetailRelation", dataList);
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (Object detail : dataList) {
          itemList.addAll(createCardDetailRelation((HenghuaSample) detail));
        }
        if (itemList.size() > 0) {
          this.getSqlSession().insert("HenghuaSample.insertCardDetailRelation", itemList);
        }

        return effectCount;
      }
    });
    if (deleteOutOfTime) {
      super.getSqlSession().delete("HenghuaSample.deleteOutOfTime", updateTime);
    }
  }

  public List<Map<String, Object>> createCardDetailRelation(HenghuaSample card) {
    List<Map<String, Object>> list = new ArrayList<>();
    if (StringUtils.hasText(card.getSampleList())) {
      int i = 0;
      for (String detail : card.getSampleList().split(",")) {
        Map<String, Object> map = new HashMap<>();
        map.put("detailId", detail);
        map.put("cardId", card.getCardId());
        map.put("sort", i);
        list.add(map);
        i++;
      }
    }
    return list;
  }

  /**
   * 获得下一页样品数据
   * 
   * @param id
   * @return
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月4日下午6:14:01
   * @updator jail
   * @updateTime 2015年9月4日下午6:14:01
   */
  public List<HenghuaSample> findNextList(long id) {
    return super.selectList("findNextList", id);
  }

  /**
   * 根据 样卡名获得样卡详情
   * 
   * @param cardId 样卡名
   * @return HenghuaSample
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月5日上午11:55:16
   * @updator jail
   * @updateTime 2015年9月5日上午11:55:16
   */
  public HenghuaSample findSample(String cardId) {
    return super.selectOne("findSample", cardId);
  }

  /**
   * 样卡筛选
   * 
   * @param lang
   * @param filter
   * @return
   * @author jail
   */
  public List<HenghuaSample> search(long id, String level, String style, String gramWeight, String season, String zuzhi, String fabrics,
      String colorTypes, String clearTypes, String materialTypes) {
    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put("id", id);
    searchMap.put("level", level);
    searchMap.put("style", style);
    searchMap.put("gramWeight", gramWeight);
    searchMap.put("season", season);
    searchMap.put("zuzhi", zuzhi);
    searchMap.put("fabrics", fabrics);
    searchMap.put("colorTypes", StringUtils.hasText(colorTypes) ? colorTypes.split(",") : null);
    searchMap.put("clearTypes", StringUtils.hasText(clearTypes) ? clearTypes.split(",") : null);
    searchMap.put("materialTypes", StringUtils.hasText(materialTypes) ? materialTypes.split(",") : null);
    return super.selectList("HenghuaSample.searchSample", searchMap);
  }
}
