package com.goodlaike.henghua.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 恒华 服装类
 * 
 * @author jail
 */
@Alias("cloth")
public class HenghuaCloth implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * 主键ID
   */
  private long id;
  /**
   * 服装编号
   */
  @JSONField(name = "企业码序列")
  private String serialNo;
  /**
   * 服装名
   */
  @JSONField(name = "商品名称")
  private String name;
  /**
   * 描述_jpg图片
   */
  @JSONField(name = "Jpg")
  private String desc_jpg;
  /**
   * 描述_png图片
   */
  @JSONField(name = "Png")
  private String desc_png;
  /**
   * 描述_视频
   */
  @JSONField(name = "Video")
  private String desc_video;
  /**
   * 子编码列表
   */
  @JSONField(name = "子编码列表")
  private String sonCodeList;
  /**
   * 尺码列表
   */
  @JSONField(name = "尺码列表")
  private String sizeList;
  /**
   * 上下类别
   */
  @JSONField(name = "上下类别")
  private String onUnderStyle;
  /**
   * 穿着类别
   */
  @JSONField(name = "穿着类别")
  private String wearStyle;
  /**
   * 样式
   */
  @JSONField(name = "样式")
  private String style;
  /**
   * 原料成分
   */
  @JSONField(name = "原料成分")
  private String material;
  /**
   * 主要颜色
   */
  @JSONField(name = "主要颜色")
  private String mainColor;
  /**
   * 主面料编码
   */
  @JSONField(name = "主面料编码")
  private String detailId;
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
   * 洗标
   */
  @JSONField(name = "洗标")
  private String washCodes;

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
   * 获得 id
   * 
   * @return long
   */
  public long getId() {
    return id;
  }

  /**
   * 设置 id
   * 
   * @param id long
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * 获得 serialNo
   * 
   * @return String
   */
  @JSONField(name = "serialNo")
  public String getSerialNo() {
    return serialNo;
  }

  /**
   * 设置 serialNo
   * 
   * @param serialNo String
   */
  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  /**
   * 获得 name
   * 
   * @return String
   */
  @JSONField(name = "name")
  public String getName() {
    return name;
  }

  /**
   * 设置 name
   * 
   * @param name String
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获得 desc_jpg
   * 
   * @return String
   */
  @JSONField(name = "desc_jpg")
  public String getDesc_jpg() {
    return desc_jpg;
  }

  /**
   * 设置 desc_jpg
   * 
   * @param desc_jpg String
   */
  public void setDesc_jpg(String desc_jpg) {
    this.desc_jpg = desc_jpg;
  }

  /**
   * 获得 desc_png
   * 
   * @return String
   */
  @JSONField(name = "desc_png")
  public String getDesc_png() {
    return desc_png;
  }

  /**
   * 设置 desc_png
   * 
   * @param desc_png String
   */
  public void setDesc_png(String desc_png) {
    this.desc_png = desc_png;
  }

  /**
   * 获得 desc_video
   * 
   * @return String
   */
  @JSONField(name = "desc_video")
  public String getDesc_video() {
    return desc_video;
  }

  /**
   * 设置 desc_video
   * 
   * @param desc_video String
   */
  public void setDesc_video(String desc_video) {
    this.desc_video = desc_video;
  }

  /**
   * 获得 sonCodeList
   * 
   * @return String
   */
  @JSONField(name = "sonCodeList")
  public String getSonCodeList() {
    return sonCodeList;
  }

  /**
   * 设置 sonCodeList
   * 
   * @param sonCodeList String
   */
  public void setSonCodeList(String sonCodeList) {
    this.sonCodeList = sonCodeList;
  }

  /**
   * 获得 sizeList
   * 
   * @return String
   */
  @JSONField(name = "sizeList")
  public String getSizeList() {
    return sizeList;
  }

  /**
   * 设置 sizeList
   * 
   * @param sizeList String
   */
  public void setSizeList(String sizeList) {
    this.sizeList = sizeList;
  }

  /**
   * 获得 onUnderStyle
   * 
   * @return String
   */
  @JSONField(name = "onUnderStyle")
  public String getOnUnderStyle() {
    return onUnderStyle;
  }

  /**
   * 设置 onUnderStyle
   * 
   * @param onUnderStyle String
   */
  public void setOnUnderStyle(String onUnderStyle) {
    this.onUnderStyle = onUnderStyle;
  }

  /**
   * 获得 wearStyle
   * 
   * @return String
   */
  @JSONField(name = "wearStyle")
  public String getWearStyle() {
    return wearStyle;
  }

  /**
   * 设置 wearStyle
   * 
   * @param wearStyle String
   */
  public void setWearStyle(String wearStyle) {
    this.wearStyle = wearStyle;
  }

  /**
   * 获得 style
   * 
   * @return String
   */
  @JSONField(name = "style")
  public String getStyle() {
    return style;
  }

  /**
   * 设置 style
   * 
   * @param style String
   */
  public void setStyle(String style) {
    this.style = style;
  }

  /**
   * 获得 material
   * 
   * @return String
   */
  @JSONField(name = "material")
  public String getMaterial() {
    return material;
  }

  /**
   * 设置 material
   * 
   * @param material String
   */
  public void setMaterial(String material) {
    this.material = material;
  }

  /**
   * 获得 mainColor
   * 
   * @return String
   */
  @JSONField(name = "mainColor")
  public String getMainColor() {
    return mainColor;
  }

  /**
   * 设置 mainColor
   * 
   * @param mainColor String
   */
  public void setMainColor(String mainColor) {
    this.mainColor = mainColor;
  }

  /**
   * 获得 detailId
   * 
   * @return String
   */
  @JSONField(name = "detailId")
  public String getDetailId() {
    return detailId;
  }

  /**
   * 设置 detailId
   * 
   * @param detailId String
   */
  public void setDetailId(String detailId) {
    this.detailId = detailId;
  }

  /**
   * 获得 price
   * 
   * @return String
   */
  @JSONField(name = "price")
  public String getPrice() {
    return price;
  }

  /**
   * 设置 price
   * 
   * @param price String
   */
  public void setPrice(String price) {
    this.price = price;
  }

  /**
   * 获得 unit
   * 
   * @return String
   */
  @JSONField(name = "unit")
  public String getUnit() {
    return unit;
  }

  /**
   * 设置 unit
   * 
   * @param unit String
   */
  public void setUnit(String unit) {
    this.unit = unit;
  }

  /**
   * 获得 washCodes
   * 
   * @return String
   */
  @JSONField(name = "washCodes")
  public String getWashCodes() {
    return washCodes;
  }

  /**
   * 设置 washCodes
   * 
   * @param washCodes String
   */
  public void setWashCodes(String washCodes) {
    this.washCodes = washCodes;
  }

  /**
   * 获得 creator
   * 
   * @return int
   */
  public int getCreator() {
    return creator;
  }

  /**
   * 设置 creator
   * 
   * @param creator int
   */
  public void setCreator(int creator) {
    this.creator = creator;
  }

  /**
   * 获得 createTime
   * 
   * @return Date
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * 设置 createTime
   * 
   * @param createTime Date
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获得 updator
   * 
   * @return int
   */
  public int getUpdator() {
    return updator;
  }

  /**
   * 设置 updator
   * 
   * @param updator int
   */
  public void setUpdator(int updator) {
    this.updator = updator;
  }

  /**
   * 获得 updateTime
   * 
   * @return Date
   */
  public Date getUpdateTime() {
    return updateTime;
  }

  /**
   * 设置 updateTime
   * 
   * @param updateTime Date
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "HenghuaCloth [id=" + id + ", serialNo=" + serialNo + ", name=" + name + ", desc_jpg=" + desc_jpg + ", desc_png=" + desc_png
        + ", desc_video=" + desc_video + ", sonCodeList=" + sonCodeList + ", sizeList=" + sizeList + ", onUnderStyle=" + onUnderStyle + ", wearStyle="
        + wearStyle + ", style=" + style + ", material=" + material + ", mainColor=" + mainColor + ", detailId=" + detailId + ", price=" + price
        + ", unit=" + unit + ", washCodes=" + washCodes + ", creator=" + creator + ", createTime=" + createTime + ", updator=" + updator
        + ", updateTime=" + updateTime + "]";
  }
}
