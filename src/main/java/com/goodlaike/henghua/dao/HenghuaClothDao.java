package com.goodlaike.henghua.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.goodlaike.henghua.entity.model.HenghuaCloth;

/**
 * 服装 Dao
 * 
 * @author jail
 */
@Repository
@Lazy(true)
public class HenghuaClothDao extends LocalRWDao<HenghuaCloth> {

  /**
   * 批量插入数据了，100条一次
   * 
   * @param clothList
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月3日下午8:58:56
   * @updator jail
   * @updateTime 2015年9月3日下午8:58:56
   */
  public int batchReplaceInto(List<HenghuaCloth> clothList, boolean deleteOutOfTime) {
    Date updateTime = new Date();
    int effectCount = super.batchOperate(100, clothList, new BatchOperation(super.getSqlSession()) {
      @Override
      public int process(List<?> dataList) {
        int effectCount = this.getSqlSession().update("HenghuaCloth.updateSource", dataList);
        effectCount += this.getSqlSession().insert("HenghuaCloth.insertSource", dataList);
        return effectCount;
      }
    });
    if (deleteOutOfTime) {
      super.getSqlSession().delete("HenghuaCloth.deleteOutOfTime", updateTime);
    }
    return effectCount;
  }

  /**
   * 获得下一页服装数据
   * 
   * @param id
   * @return
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月4日下午6:14:01
   * @updator jail
   * @updateTime 2015年9月4日下午6:14:01
   */
  public List<HenghuaCloth> findNextList(long id) {
    return super.selectList("findNextList", id);
  }

  /**
   * 获得服装详情
   * 
   * @param serialNo
   * @return
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月5日下午4:42:21
   * @updator jail
   * @updateTime 2015年9月5日下午4:42:21
   */
  public HenghuaCloth findCloth(String serialNo) {
    return super.selectOne("findCloth", serialNo);
  }


  /**
   * 服装搜索
   * 
   * @param id 其实ID
   * @param material 原料，多选
   * @param wearStyle 穿着类别
   * @param mainColor 颜色，多选
   * @param style 样式
   * @param onUnderStyle 上下类别
   * @param name 商品名称，多选
   * @param keys 关键词
   * @return  List<HenghuaCloth>
   * @summary 服装搜索
   * @author Jail Hu
   * @version v1
   * @since 2016年7月11日 下午9:03:17
   */
  public List<HenghuaCloth> search(long id, String material, String wearStyle, String mainColor, String style, String onUnderStyle, String name,
      String keys) {
    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put("id", id);
    searchMap.put("wearStyle", wearStyle);
    searchMap.put("style", style);
    searchMap.put("onUnderStyle", onUnderStyle);
    searchMap.put("material", StringUtils.hasText(material) ? material.split(",") : null);
    searchMap.put("mainColor", StringUtils.hasText(mainColor) ? mainColor.split(",") : null);
    searchMap.put("name", StringUtils.hasText(name) ? name.split(",") : null);
    searchMap.put("keys", keys);
    return super.selectList("HenghuaCloth.searchCloth", searchMap);
  }
}
