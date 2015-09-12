package com.goodlaike.henghua.entity.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 样品
 * 
 * @author jail
 */
public class HenghuaSampleDetail implements Serializable {

    private static final long serialVersionUID = -4770870284123463022L;
    /**
     * 样品名
     */
    private String detailName;
    /**
     * 样品图片
     */
    private String picPath;
    /**
     * 样品图片,为了接收，又不想用这个字段名，暂时用这个办法
     */
    @JSONField(serialize = false)
    private String Image;
    /**
     * 中文名称
     */
    private String nameCn;

    @JSONField(name = "Name(C)", serialize = false)
    private String nameCnBak;
    /**
     * 英文名称
     */
    private String nameEn;
    @JSONField(name = "Name(E)", serialize = false)
    private String nameEnBak;
    /**
     * 材料
     */
    private String material;
    /**
     * 零售价
     */
    private String price;
    /**
     * 库存
     */
    private String reserve;
    @JSONField(name = "Belongs Sample Card", serialize = false)
    private String cardBak;
    /**
     * 币种
     */
    private String currency;
    /**
     * 零售计量单位
     */
    private String retailUnit;
    @JSONField(name = "Retail Unit", serialize = false)
    private String retailUnitBak;
    @JSONField(name = "SampleID", serialize = false)
    private String sampleID;

    /**
     * 获得 "样品名",对应属性"detailName"
     * 
     * @return String
     */
    public String getDetailName() {
        return this.detailName;
    }

    /**
     * 设置 "样品名",对应属性"detailName"
     *
     * @param detailName
     *            String
     */
    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    /**
     * 设置 "#{bare_field_comment}",对应属性"nameCnBak"
     *
     * @param nameCnBak
     *            String
     */
    public void setNameCnBak(String nameCnBak) {
        this.nameCnBak = nameCnBak;
    }

    /**
     * 获得 "样品图片",对应属性"picPath"
     * 
     * @return String
     */
    public String getPicPath() {
        return (StringUtils.isBlank(this.picPath) ? this.Image : this.picPath) + ".png";
    }

    /**
     * 设置 "样品图片",对应属性"picPath"
     *
     * @param picPath
     *            String
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    /**
     * 获得 "样卡名",对应属性"sampleName"
     * 
     * @return String
     */
    public String getSampleName() {
        return StringUtils.isBlank(this.sampleID) ? (StringUtils.isNotBlank(cardBak) ? cardBak : "")
                : this.sampleID;
    }

    /**
     * 获得 "所属样卡的索引",对应属性"detailIndex"
     * 
     * @return int
     */
    public int getDetailIndex() {
        if (StringUtils.isNotBlank(cardBak)) {
            String[] a = cardBak.split("-");
            if (a.length > 1) {
                return Integer.valueOf(a[1]);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 获得 "中文名称",对应属性"nameCn"
     * 
     * @return String
     */
    public String getNameCn() {
        return StringUtils.isBlank(this.nameCn) ? this.nameCnBak : this.nameCn;
    }

    /**
     * 设置 "中文名称",对应属性"nameCn"
     *
     * @param nameCn
     *            String
     */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    /**
     * 设置 "#{bare_field_comment}",对应属性"nameEnBak"
     *
     * @param nameEnBak
     *            String
     */
    public void setNameEnBak(String nameEnBak) {
        this.nameEnBak = nameEnBak;
    }

    /**
     * 获得 "英文名称",对应属性"nameEn"
     * 
     * @return String
     */
    public String getNameEn() {
        return StringUtils.isBlank(this.nameEn) ? this.nameEnBak : this.nameEn;
    }

    /**
     * 设置 "英文名称",对应属性"nameEn"
     *
     * @param nameEn
     *            String
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     * 获得 "材料",对应属性"material"
     * 
     * @return String
     */
    public String getMaterial() {
        return this.material;
    }

    /**
     * 设置 "材料",对应属性"material"
     *
     * @param material
     *            String
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * 设置 "样品图片,为了接收，又不想用这个字段名，暂时用这个办法",对应属性"image"
     *
     * @param image
     *            String
     */
    public void setImage(String image) {
        Image = image;
    }

    /**
     * 获得 "零售价",对应属性"price"
     * 
     * @return String
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * 设置 "零售价",对应属性"price"
     *
     * @param price
     *            String
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获得 "库存",对应属性"reserve"
     * 
     * @return String
     */
    public String getReserve() {
        return this.reserve;
    }

    /**
     * 设置 "库存",对应属性"reserve"
     *
     * @param reserve
     *            String
     */
    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    /**
     * 设置 "#{bare_field_comment}",对应属性"cardBak"
     *
     * @param cardBak
     *            String
     */
    public void setCardBak(String cardBak) {
        this.cardBak = cardBak;
    }

    /**
     * 获得 "币种",对应属性"currency"
     * 
     * @return String
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * 设置 "币种",对应属性"currency"
     *
     * @param currency
     *            String
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 获得 "零售计量单位",对应属性"retailUnit"
     * 
     * @return String
     */
    public String getRetailUnit() {
        return StringUtils.isBlank(this.retailUnit) ? this.retailUnitBak : this.retailUnit;
    }

    /**
     * 设置 "零售计量单位",对应属性"retailUnit"
     *
     * @param retailUnit
     *            String
     */
    public void setRetailUnit(String retailUnit) {
        this.retailUnit = retailUnit;
    }

    /**
     * 设置 "#{bare_field_comment}",对应属性"retailUnitBak"
     *
     * @param retailUnitBak
     *            String
     */
    public void setRetailUnitBak(String retailUnitBak) {
        this.retailUnitBak = retailUnitBak;
    }

    /**
     * 设置 "#{bare_field_comment}",对应属性"sampleID"
     *
     * @param sampleID
     *            String
     */
    public void setSampleID(String sampleID) {
        this.sampleID = sampleID;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HenghuaSampleDetail [detailName=" + detailName + ", picPath=" + this.getPicPath() + ", nameCn="
                + this.getNameCn() + ",  nameEn=" + this.getNameEn() + ",  material=" + material + ", price=" + price
                + ", reserve=" + reserve + ", cardBak=" + cardBak + ", currency=" + currency + ", retailUnit="
                + this.getRetailUnit() + "]";
    }
}
