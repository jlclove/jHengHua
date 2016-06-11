package com.goodlaike.henghua.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 
 * 恒华 样品 类
 * 
 * @author jail
 */
@Alias("sample")
@JSONType(asm = false)
public class HenghuaSample implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   */
  private long id;
  /**
   * 样卡ID
   */
  @JSONField(name = "样卡ID")
  private String cardId;
  /**
   * 样卡别名
   */
  @JSONField(name = "样卡别名")
  private String alias;
  /**
   * 昵称
   */
  @JSONField(name = "呢称")
  private String nick;
  /**
   * 样品列表
   */
  @JSONField(name = "样品列表")
  private String sampleList;
  /**
   * 样品原始图片集合（20160605被取消）
   */
  @JSONField(serialize = false)
  private String sample2Img;
  /**
   * 样卡材料
   */
  @JSONField(name = "原料成分")
  private String material;
  /**
   * 中文描述
   */
  @JSONField(name = "中文描述")
  private String descCn;
  /**
   * 英文描述
   */
  @JSONField(name = "英文描述")
  private String descEn;
  /**
   * 样卡创建时间
   */
  @JSONField(name = "建卡时间", format = "yyyy-MM-dd HH:mm:ss")
  private Date cardCreateTime;
  /**
   * 创建人ID
   */
  @JSONField(serialize = false)
  private int creator;
  /**
   * 创建时间
   */
  @JSONField(serialize = false)
  private Date createTime;
  /**
   * 更新人ID
   */
  @JSONField(serialize = false)
  private int updator;
  /**
   * 更新时间
   */
  @JSONField(serialize = false)
  private Date updateTime;

  /**
   * 获得 "主键ID",对应属性"id"
   * 
   * @return long
   */
  public long getId() {
    return this.id;
  }

  /**
   * 设置 "主键ID",对应属性"id"
   *
   * @param id long
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * 获得 "样卡ID",对应属性"cardId"
   * 
   * @return String
   */
  @JSONField(name = "cardId")
  public String getCardId() {
    return this.cardId;
  }

  /**
   * 设置 "样卡ID",对应属性"cardId"
   *
   * @param cardId String
   */
  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  /**
   * 获得 "昵称",对应属性"nick"
   * 
   * @return String
   */
  @JSONField(name = "nick")
  public String getNick() {
    return this.nick;
  }

  /**
   * 设置 "昵称",对应属性"nick"
   *
   * @param nick String
   */
  public void setNick(String nick) {
    this.nick = nick;
  }

  /**
   * 获得 "样品原始图片集合",对应属性"sample2Img"
   * 
   * @return String
   */
  public String getSample2Img() {
    return this.sample2Img;
  }

  /**
   * 设置 "样品原始图片集合",对应属性"sample2Img"
   *
   * @param sample2Img String
   */
  public void setSample2Img(String sample2Img) {
    this.sample2Img = sample2Img;
  }

  /**
   * 获得 "样卡材料",对应属性"material"
   * 
   * @return String
   */
  @JSONField(name = "material")
  public String getMaterial() {
    return this.material;
  }

  /**
   * 设置 "样卡材料",对应属性"material"
   *
   * @param material String
   */
  public void setMaterial(String material) {
    this.material = material;
  }

  /**
   * 获得 descCn
   * 
   * @return String
   */
  @JSONField(name = "descCn")
  public String getDescCn() {
    return descCn;
  }

  /**
   * 设置 "中文描述",对应属性"descCn"
   *
   * @param descCn String
   */
  public void setDescCn(String descCn) {
    this.descCn = descCn;
  }

  /**
   * 获得 "英文描述",对应属性"descEn"
   * 
   * @return String
   */
  @JSONField(name = "descEn")
  public String getDescEn() {
    return this.descEn;
  }

  /**
   * 设置 "英文描述",对应属性"descEn"
   *
   * @param descEn String
   */
  public void setDescEn(String descEn) {
    this.descEn = descEn;
  }

  /**
   * 获得 "创建人ID",对应属性"creator"
   * 
   * @return int
   */
  public int getCreator() {
    return this.creator;
  }

  /**
   * 设置 "创建人ID",对应属性"creator"
   *
   * @param creator int
   */
  public void setCreator(int creator) {
    this.creator = creator;
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
   * @param createTime Date
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获得 "更新人ID",对应属性"updator"
   * 
   * @return int
   */
  public int getUpdator() {
    return this.updator;
  }

  /**
   * 设置 "更新人ID",对应属性"updator"
   *
   * @param updator int
   */
  public void setUpdator(int updator) {
    this.updator = updator;
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
   * @param updateTime Date
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 获得 alias
   * 
   * @return String
   */
  @JSONField(name = "alias")
  public String getAlias() {
    return alias;
  }

  /**
   * 设置 alias
   * 
   * @param alias String
   */
  public void setAlias(String alias) {
    this.alias = alias;
  }

  /**
   * 获得 sampleList
   * 
   * @return String
   */
  @JSONField(name = "sampleList")
  public String getSampleList() {
    return sampleList;
  }

  /**
   * 设置 sampleList
   * 
   * @param sampleList String
   */
  public void setSampleList(String sampleList) {
    this.sampleList = sampleList;
  }

  /**
   * 获得 cardCreateTime
   * 
   * @return Date
   */
  @JSONField(name = "cardCreateTime")
  public Date getCardCreateTime() {
    return cardCreateTime;
  }

  /**
   * 设置 cardCreateTime
   * 
   * @param cardCreateTime Date
   */
  public void setCardCreateTime(Date cardCreateTime) {
    this.cardCreateTime = cardCreateTime;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "HenghuaSample [id=" + id + ", cardId=" + cardId + ", alias=" + alias + ", nick=" + nick + ", sampleList=" + sampleList + ", sample2Img="
        + sample2Img + ", material=" + material + ", descCn=" + descCn + ", descEn=" + descEn + ", cardCreateTime=" + cardCreateTime + ", creator="
        + creator + ", createTime=" + createTime + ", updator=" + updator + ", updateTime=" + updateTime + "]";
  }
}
