package com.goodlaike.henghua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.goodlaike.henghua.dao.OrderDao;
import com.goodlaike.henghua.entity.model.Order;

/**
 * 订单Service
 * 
 * @author jail
 */
@Service
@Lazy(true)
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	/**
	 * 提交订单
	 * 
	 * @param order
	 *            订单 需要用到的属性<br>
	 *            quantity 数量 <br>
	 *            sampleDetailNo 样品编号<br>
	 *            unitPrice 单价<br>
	 *            createUserId 购买人Id
	 * @return boolean
	 */
	public boolean insertOrder(Order order) {
		Assert.hasText(order.getSampleDetailNo(), "缺少样品编号");
		Assert.isTrue(order.getQuantity() > 0, "购买数量必须为正数");
		Assert.isTrue(order.getCreateUserId() > 0, "缺少购买人ID");
		if (order.getTotalPrice() == 0) {
			order.setTotalPrice(order.getUnitPrice() * order.getQuantity());
		}
		return orderDao.insert(order);
	}

	/**
	 * 提交订单
	 * 
	 * @param quantity
	 *            数量
	 * @param sampleDetailNo
	 *            样品编号
	 * @param unitPrice
	 *            单价
	 * @param operateUserId
	 *            购买人Id
	 * @return boolean
	 * @author jail
	 */
	public boolean insertOrder(int quantity, String sampleDetailNo, float unitPrice, int operateUserId) {
		Order order = new Order();
		order.setQuantity(quantity);
		order.setSampleDetailNo(sampleDetailNo);
		order.setTotalPrice(quantity * unitPrice);
		order.setUnitPrice(unitPrice);
		order.setCreateUserId(operateUserId);
		order.setUpdateUserId(operateUserId);
		return this.insertOrder(order);
	}
}
