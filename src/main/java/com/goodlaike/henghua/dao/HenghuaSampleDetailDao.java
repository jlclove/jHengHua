package com.goodlaike.henghua.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.goodlaike.henghua.entity.model.HenghuaSampleDetail2;

/**
 * 
 * @author jail
 */
@Repository
@Lazy(true)
public class HenghuaSampleDetailDao extends LocalRWDao<HenghuaSampleDetail2> {

  /**
   * 批量插入样品数据了，100条一次
   * 
   * @param sampleDetailList
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月3日下午8:58:56
   * @updator jail
   * @updateTime 2015年9月3日下午8:58:56
   */
  public void batchReplaceInto(List<HenghuaSampleDetail2> sampleDetailList, boolean deleteOutOfTime) {
    Date updateTime = new Date();
    super.batchOperate(100, sampleDetailList, new BatchOperation(super.getSqlSession()) {
      @Override
      public int process(List<?> dataList) {
        int effectCount = this.getSqlSession().update("HenghuaSampleDetail.updateSource", dataList);
        effectCount += this.getSqlSession().insert("HenghuaSampleDetail.insertSource", dataList);

        // 删除扩展属性
        this.getSqlSession().delete("HenghuaSampleDetail.deleteDetailItem", dataList);
        List<Map<String, String>> itemList = new ArrayList<>();
        for (Object detail : dataList) {
          itemList.addAll(createDetailItem((HenghuaSampleDetail2) detail));
        }
        if (itemList.size() > 0) {
          this.getSqlSession().insert("HenghuaSampleDetail.insertDetailItem", itemList);
        }
        return effectCount;
      }
    });
    if (deleteOutOfTime) {
      super.getSqlSession().delete("HenghuaSampleDetail.deleteOutOfTime", updateTime);
    }
  }

  public List<Map<String, String>> createDetailItem(HenghuaSampleDetail2 detail) {
    List<Map<String, String>> list = new ArrayList<>();
    if (StringUtils.hasText(detail.getClearTypes())) {
      for (String clear : detail.getClearTypes().split(",")) {
        Map<String, String> map = new HashMap<>();
        map.put("detailId", detail.getDetailId());
        map.put("itemType", "clearTypes");
        map.put("value", clear);
        list.add(map);
      }
    }
    if (StringUtils.hasText(detail.getColorTypes())) {
      for (String clear : detail.getColorTypes().split(",")) {
        Map<String, String> map = new HashMap<>();
        map.put("detailId", detail.getDetailId());
        map.put("itemType", "colorTypes");
        map.put("value", clear);
        list.add(map);
      }
    }
    if (StringUtils.hasText(detail.getMaterialTypes())) {
      for (String clear : detail.getMaterialTypes().split(",")) {
        Map<String, String> map = new HashMap<>();
        map.put("detailId", detail.getDetailId());
        map.put("itemType", "materialTypes");
        map.put("value", clear);
        list.add(map);
      }
    }
    return list;
  }


  /**
   * 根据多个detailId 获得样品
   * 
   * @return List<HenghuaSampleDetail2>
   * @summary 根据多个detailId 获得样品
   * @author Jail Hu
   * @version v1
   * @since 2016年6月11日 下午2:24:14
   */
  public List<HenghuaSampleDetail2> findSampleDetails(Map<String, Object> map) {
    return super.selectList("HenghuaSampleDetail.findSampleDetails", map);
  }

  /**
   * 根据样品名获得样品详情
   * 
   * @param detailId 样品名
   * @return HenghuaSampleDetail
   * @since 1.0.0
   * @author jail
   * @createTime 2015年9月5日上午11:55:16
   * @updator jail
   * @updateTime 2015年9月5日上午11:55:16
   */
  public HenghuaSampleDetail2 findSampleDetail(String detailId) {
    return super.selectOne("HenghuaSampleDetail.findSampleDetail", detailId);
  }

  public void test() {
    Map<String, Object> map = new HashMap<>();
    map.put("name", Arrays.asList("胡杰", "王思雨"));
    map.put("sex", Arrays.asList("男", "女"));
    super.selectOne("HenghuaSampleDetail.test", map);
  }
}
