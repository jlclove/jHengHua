package com.goodlaike.henghua.entity.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 恒华洗标类
 * 
 * @summary 恒华洗标类
 * @author Jail Hu
 * @Copyright (c) 2016, Lianjia Group All Rights Reserved.
 */
public class Washing implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 序号
   */
  @JSONField(name = "序号")
  private int id;
  /**
   * 洗标 png 图片
   */
  private String png;
  /**
   * 洗标 jpg 图片
   */
  private String jpg;
  /**
   * 英文描述
   */
  @JSONField(name = "英文描述")
  private String desc_en;
  /**
   * 中文描述
   */
  @JSONField(name = "中文描述")
  private String desc_cn;

  /**
   * 获得 id
   * 
   * @return int
   */
  @JSONField(name = "id")
  public int getId() {
    return id;
  }

  /**
   * 设置 id
   * 
   * @param id int
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * 获得 png
   * 
   * @return String
   */
  public String getPng() {
    return png;
  }

  /**
   * 设置 png
   * 
   * @param png String
   */
  public void setPng(String png) {
    this.png = png;
  }

  /**
   * 获得 jpg
   * 
   * @return String
   */
  public String getJpg() {
    return jpg;
  }

  /**
   * 设置 jpg
   * 
   * @param jpg String
   */
  public void setJpg(String jpg) {
    this.jpg = jpg;
  }

  /**
   * 获得 desc_en
   * 
   * @return String
   */
  @JSONField(name = "desc_en")
  public String getDesc_en() {
    return desc_en;
  }

  /**
   * 设置 desc_en
   * 
   * @param desc_en String
   */
  public void setDesc_en(String desc_en) {
    this.desc_en = desc_en;
  }

  /**
   * 获得 desc_cn
   * 
   * @return String
   */
  @JSONField(name = "desc_cn")
  public String getDesc_cn() {
    return desc_cn;
  }

  /**
   * 设置 desc_cn
   * 
   * @param desc_cn String
   */
  public void setDesc_cn(String desc_cn) {
    this.desc_cn = desc_cn;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Washing [id=" + id + ", png=" + png + ", jpg=" + jpg + ", desc_en=" + desc_en + ", desc_cn=" + desc_cn + "]";
  }
}
