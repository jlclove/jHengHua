package com.goodlaike.henghua.entity.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 服装库存类
 * 
 * @summary 服装库存类
 * @author Jail Hu
 * @Copyright (c) 2016, Lianjia Group All Rights Reserved.
 */
public class HenghuaClothQuantity implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 服装编号
   */
  @JSONField(name = "企业码")
  private String serialNo;

  /**
   * 库存量
   */
  @JSONField(name = "数量")
  private String stock;

  /**
   * 获得 serialNo
   * @return String
   */
  @JSONField(name = "serialNo")
  public String getSerialNo() {
    return serialNo;
  }

  /**
   * 设置  serialNo
   * @param serialNo String
   */
  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  /**
   * 获得 stock
   * @return String
   */
  @JSONField(name = "stock")
  public String getStock() {
    return stock;
  }

  /**
   * 设置  stock
   * @param stock String
   */
  public void setStock(String stock) {
    this.stock = stock;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "HenghuaClothQuantity [serialNo=" + serialNo + ", stock=" + stock + "]";
  }
  
}
