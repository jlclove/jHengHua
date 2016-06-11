package com.goodlaike.henghua.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 样品
 * 
 * @author jail
 */
@Alias("henghuaSampleDetail")
public class HenghuaSampleDetail2 implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 样品ID
   */
  private long id;
  /**
   * 样品编码
   */
  @JSONField(name = "样品编码")
  private String detailId;
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
   * 样卡ID集合
   */
  @JSONField(name = "样卡序列")
  private String cardIds;
  /**
   * 样品名中文
   */
  @JSONField(name = "中文品名")
  private String nameCn;
  /**
   * 样品名英文
   */
  @JSONField(name = "英文品名")
  private String nameEn;
  /**
   * 样品品级
   */
  @JSONField(name = "品级")
  private String level;
  /**
   * 样品原料
   */
  @JSONField(name = "原料")
  private String material;
  /**
   * 样品风格
   */
  @JSONField(name = "风格")
  private String style;
  /**
   * 样品季节
   */
  @JSONField(name = "季节")
  private String season;
  /**
   * 样品克重
   */
  @JSONField(name = "克重")
  private String gramWeight;
  /**
   * 织物名称
   */
  @JSONField(name = "织物名称")
  private String fabrics;
  /**
   * 组织
   */
  @JSONField(name = "组织")
  private String zuzhi;
  /**
   * 颜色分类
   */
  @JSONField(name = "颜色分类")
  private String colorTypes;
  /**
   * 原料分类
   */
  @JSONField(name = "原料分类")
  private String materialTypes;
  /**
   * 整理方式
   */
  @JSONField(name = "整理方式")
  private String clearTypes;
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
   * 获得 cardIds
   * 
   * @return String
   */
  @JSONField(name = "cardIds")
  public String getCardIds() {
    return cardIds;
  }

  /**
   * 设置 cardIds
   * 
   * @param cardIds String
   */
  public void setCardIds(String cardIds) {
    this.cardIds = cardIds;
  }

  /**
   * 获得 nameCn
   * 
   * @return String
   */
  @JSONField(name = "nameCn")
  public String getNameCn() {
    return nameCn;
  }

  /**
   * 设置 nameCn
   * 
   * @param nameCn String
   */
  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }

  /**
   * 获得 nameEn
   * 
   * @return String
   */
  @JSONField(name = "nameEn")
  public String getNameEn() {
    return nameEn;
  }

  /**
   * 设置 nameEn
   * 
   * @param nameEn String
   */
  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

  /**
   * 获得 level
   * 
   * @return String
   */
  @JSONField(name = "level")
  public String getLevel() {
    return level;
  }

  /**
   * 设置 level
   * 
   * @param level String
   */
  public void setLevel(String level) {
    this.level = level;
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
   * 获得 season
   * 
   * @return String
   */
  @JSONField(name = "season")
  public String getSeason() {
    return season;
  }

  /**
   * 设置 season
   * 
   * @param season String
   */
  public void setSeason(String season) {
    this.season = season;
  }

  /**
   * 获得 gramWeight
   * 
   * @return String
   */
  @JSONField(name = "gramWeight")
  public String getGramWeight() {
    return gramWeight;
  }

  /**
   * 设置 gramWeight
   * 
   * @param gramWeight String
   */
  public void setGramWeight(String gramWeight) {
    this.gramWeight = gramWeight;
  }

  /**
   * 获得 fabrics
   * 
   * @return String
   */
  @JSONField(name = "fabrics")
  public String getFabrics() {
    return fabrics;
  }

  /**
   * 设置 fabrics
   * 
   * @param fabrics String
   */
  public void setFabrics(String fabrics) {
    this.fabrics = fabrics;
  }

  /**
   * 获得 zuzhi
   * 
   * @return String
   */
  @JSONField(name = "zuzhi")
  public String getZuzhi() {
    return zuzhi;
  }

  /**
   * 设置 zuzhi
   * 
   * @param zuzhi String
   */
  public void setZuzhi(String zuzhi) {
    this.zuzhi = zuzhi;
  }

  /**
   * 获得 colorTypes
   * 
   * @return String
   */
  @JSONField(name = "colorTypes")
  public String getColorTypes() {
    return colorTypes;
  }

  /**
   * 设置 colorTypes
   * 
   * @param colorTypes String
   */
  public void setColorTypes(String colorTypes) {
    this.colorTypes = colorTypes;
  }

  /**
   * 获得 materialTypes
   * 
   * @return String
   */
  @JSONField(name = "materialTypes")
  public String getMaterialTypes() {
    return materialTypes;
  }

  /**
   * 设置 materialTypes
   * 
   * @param materialTypes String
   */
  public void setMaterialTypes(String materialTypes) {
    this.materialTypes = materialTypes;
  }

  /**
   * 获得 clearTypes
   * 
   * @return String
   */
  @JSONField(name = "clearTypes")
  public String getClearTypes() {
    return clearTypes;
  }

  /**
   * 设置 clearTypes
   * 
   * @param clearTypes String
   */
  public void setClearTypes(String clearTypes) {
    this.clearTypes = clearTypes;
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
    return "HenghuaSampleDetail2 [id=" + id + ", detailId=" + detailId + ", desc_jpg=" + desc_jpg + ", desc_png=" + desc_png + ", desc_video="
        + desc_video + ", cardIds=" + cardIds + ", nameCn=" + nameCn + ", nameEn=" + nameEn + ", level=" + level + ", material=" + material
        + ", style=" + style + ", season=" + season + ", gramWeight=" + gramWeight + ", fabrics=" + fabrics + ", zuzhi=" + zuzhi + ", colorTypes="
        + colorTypes + ", materialTypes=" + materialTypes + ", clearTypes=" + clearTypes + ", creator=" + creator + ", createTime=" + createTime
        + ", updator=" + updator + ", updateTime=" + updateTime + "]";
  }
}
