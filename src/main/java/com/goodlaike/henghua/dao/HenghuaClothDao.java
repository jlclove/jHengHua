package com.goodlaike.henghua.dao;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

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
  public void batchReplaceInto(List<HenghuaCloth> clothList, boolean deleteOutOfTime) {
    Date updateTime = new Date();
    super.batchOperate(100, clothList, new BatchOperation(super.getSqlSession()) {
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
}
