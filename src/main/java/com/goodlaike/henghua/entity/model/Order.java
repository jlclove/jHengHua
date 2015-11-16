package com.goodlaike.henghua.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 订单
 * 
 * @author jail
 */
@Alias("order")
public class Order implements Serializable {

	private static final long serialVersionUID = 7606518822084243202L;
	/**
	 * 订单id
	 */
	private int id;
	/**
	 * 购买数量
	 */
	private int quantity;
	/**
	 * 样品id
	 */
	private String sampleDetailNo;
	/**
	 * 购买总价
	 */
	private float totalPrice;
	/**
	 * 购买单价
	 */
	private float unitPrice;
	/**
	 * 订单状态 0：正常 9：删除
	 */
	private byte status;
	/**
	 * 创建人ID
	 */
	private int createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新人ID
	 */
	private int updateUserId;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 获得 "订单id",对应属性"id"
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 设置 "订单id",对应属性"id"
	 *
	 * @param id
	 *            int
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获得 "购买数量",对应属性"quantity"
	 * 
	 * @return int
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 设置 "购买数量",对应属性"quantity"
	 *
	 * @param quantity
	 *            int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 获得 "样品id",对应属性"sampleDetailNo"
	 * 
	 * @return String
	 */
	public String getSampleDetailNo() {
		return this.sampleDetailNo;
	}

	/**
	 * 设置 "样品id",对应属性"sampleDetailNo"
	 *
	 * @param sampleDetailNo
	 *            String
	 */
	public void setSampleDetailNo(String sampleDetailNo) {
		this.sampleDetailNo = sampleDetailNo;
	}

	/**
	 * 获得 "购买总价",对应属性"totalPrice"
	 * 
	 * @return float
	 */
	public float getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * 设置 "购买总价",对应属性"totalPrice"
	 *
	 * @param totalPrice
	 *            float
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 获得 "购买单价",对应属性"unitPrice"
	 * 
	 * @return float
	 */
	public float getUnitPrice() {
		return this.unitPrice;
	}

	/**
	 * 设置 "购买单价",对应属性"unitPrice"
	 *
	 * @param unitPrice
	 *            float
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 获得 "订单状态0：正常9：删除",对应属性"status"
	 * 
	 * @return byte
	 */
	public byte getStatus() {
		return this.status;
	}

	/**
	 * 设置 "订单状态0：正常9：删除",对应属性"status"
	 *
	 * @param status
	 *            byte
	 */
	public void setStatus(byte status) {
		this.status = status;
	}

	/**
	 * 获得 "创建人ID",对应属性"createUserId"
	 * 
	 * @return int
	 */
	public int getCreateUserId() {
		return this.createUserId;
	}

	/**
	 * 设置 "创建人ID",对应属性"createUserId"
	 *
	 * @param createUserId
	 *            int
	 */
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 获得 "创建时间",对应属性"createTime"
	 * 
	 * @return Date
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 设置 "创建时间",对应属性"createTime"
	 *
	 * @param createTime
	 *            Date
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获得 "更新人ID",对应属性"updateUserId"
	 * 
	 * @return int
	 */
	public int getUpdateUserId() {
		return this.updateUserId;
	}

	/**
	 * 设置 "更新人ID",对应属性"updateUserId"
	 *
	 * @param updateUserId
	 *            int
	 */
	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 获得 "更新时间",对应属性"updateTime"
	 * 
	 * @return Date
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * 设置 "更新时间",对应属性"updateTime"
	 *
	 * @param updateTime
	 *            Date
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", quantity=" + quantity + ", sampleDetailNo=" + sampleDetailNo + ", totalPrice="
				+ totalPrice + ", unitPrice=" + unitPrice + ", status=" + status + ", createUserId=" + createUserId
				+ ", createTime=" + createTime + ", updateUserId=" + updateUserId + ", updateTime=" + updateTime + "]";
	}
}
