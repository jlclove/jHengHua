package com.goodlaike.henghua.entity.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 样品库存
 * 
 * @author jail
 */
public class HenghuaSampleDetailQuantity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 样品编码
	 */
	@JSONField(name = "样品编码")
	private String detailId;

	/**
	 * 库存
	 */
	@JSONField(name = "可售数量")
	private String stock;

	/**
	 * 零售价
	 */
	@JSONField(name = "零售价")
	private String price;

	/**
	 * 计量单位
	 */
	@JSONField(name = "计量单位")
	private String unit;

	/**
	 * @return the 样品编码
	 */
	@JSONField(name = "detailId")
	public String getDetailId() {
		return detailId;
	}

	/**
	 * @param detailId
	 *            the detailId to set
	 */
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	/**
	 * @return the 库存
	 */
	@JSONField(name = "stock")
	public String getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	/**
	 * @return the 零售价
	 */
	@JSONField(name = "price")
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the 计量单位
	 */
	@JSONField(name = "unit")
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HenghuaSampleDetailQuantity [detailId=" + detailId + ", stock=" + stock + ", price=" + price + ", unit="
				+ unit + "]";
	}
}
