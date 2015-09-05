package com.goodlaike.henghua.dao;

import java.util.ArrayList;
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
    public void batchReplaceInto(List<HenghuaCloth> clothList) {
        List<HenghuaCloth> list = new ArrayList<>();
        clothList.forEach(cloth -> {
            cloth.setImage(cloth.getImage() + ".png");
            list.add(cloth);
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
    public List<HenghuaCloth> getNextList(long id) {
        return super.selectList("findNextList", id);
    }
}
