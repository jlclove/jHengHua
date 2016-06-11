package com.goodlaike.henghua.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.goodlaike.henghua.entity.model.Order;

/**
 * 订单Dao
 * 
 * @author jail
 */
@Repository
@Lazy(true)
public class OrderDao extends LocalRWDao<Order> {

    /**
     * 插入订单
     * 
     * @param order
     *            订单 需要用到的属性<br>
     *            quantity 数量 <br>
     *            sampleDetailNo 样品编号<br>
     *            totalPrice 总价<br>
     *            unitPrice 单价<br>
     *            createUserId 购买人Id
     * @return boolean
     */
    public boolean insert(Order order) {
        return super.insert(order);
    }
}
