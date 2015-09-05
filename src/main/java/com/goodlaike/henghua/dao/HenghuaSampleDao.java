package com.goodlaike.henghua.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

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
    public void batchReplaceInto(List<HenghuaSample> sampleList) {
        List<HenghuaSample> list = new ArrayList<>();
        sampleList.forEach(sample -> {
            list.add(sample);
            if (list.size() >= 100) {
                super.insert("replaceSource", list);
                list.clear();
            }
        });
        if (list.size() > 0) {
            super.insert("replaceSource", list);
        }
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
     * @param cardId
     *            样卡名
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
}
