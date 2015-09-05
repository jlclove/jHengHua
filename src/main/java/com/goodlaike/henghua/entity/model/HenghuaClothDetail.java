package com.goodlaike.henghua.entity.model;

import java.io.Serializable;

/**
 * 恒华 服装详情
 * 
 * @author jail
 */
public class HenghuaClothDetail implements Serializable {

    private static final long serialVersionUID = -2330833921307553L;

    /**
     * 服装内部编号
     */
    private String serialNo;
    /**
     * 服装尺寸
     */
    private String size;
    /**
     * 上下类别
     */
    private String category;
    /**
     * 穿着类别
     */
    private String wearing;
    /**
     * 样式
     */
    private String style;
    /**
     * 原料成份
     */
    private String materials;
    /**
     * 主要颜色
     */
    private String color;
    /**
     * 主要面料编码
     */
    private String fabricNo;
    /**
     * 国标条码
     */
    private String barCode;
    /**
     * 零售价
     */
    private String retailPrice;
    /**
     * 洗标
     */
    private String washing;

    /**
     * 获得 "服装内部编号",对应属性"serialNo"
     * 
     * @return String
     */
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * 设置 "服装内部编号",对应属性"serialNo"
     *
     * @param serialNo
     *            String
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获得 "服装尺寸",对应属性"size"
     * 
     * @return String
     */
    public String getSize() {
        return this.size;
    }

    /**
     * 设置 "服装尺寸",对应属性"size"
     *
     * @param size
     *            String
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 获得 "上下类别",对应属性"category"
     * 
     * @return String
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * 设置 "上下类别",对应属性"category"
     *
     * @param category
     *            String
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获得 "穿着类别",对应属性"wearing"
     * 
     * @return String
     */
    public String getWearing() {
        return this.wearing;
    }

    /**
     * 设置 "穿着类别",对应属性"wearing"
     *
     * @param wearing
     *            String
     */
    public void setWearing(String wearing) {
        this.wearing = wearing;
    }

    /**
     * 获得 "样式",对应属性"style"
     * 
     * @return String
     */
    public String getStyle() {
        return this.style;
    }

    /**
     * 设置 "样式",对应属性"style"
     *
     * @param style
     *            String
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * 获得 "原料成份",对应属性"materials"
     * 
     * @return String
     */
    public String getMaterials() {
        return this.materials;
    }

    /**
     * 设置 "原料成份",对应属性"materials"
     *
     * @param materials
     *            String
     */
    public void setMaterials(String materials) {
        this.materials = materials;
    }

    /**
     * 获得 "主要颜色",对应属性"color"
     * 
     * @return String
     */
    public String getColor() {
        return this.color;
    }

    /**
     * 设置 "主要颜色",对应属性"color"
     *
     * @param color
     *            String
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获得 "主要面料编码",对应属性"fabricNo"
     * 
     * @return String
     */
    public String getFabricNo() {
        return this.fabricNo;
    }

    /**
     * 设置 "主要面料编码",对应属性"fabricNo"
     *
     * @param fabricNo
     *            String
     */
    public void setFabricNo(String fabricNo) {
        this.fabricNo = fabricNo;
    }

    /**
     * 获得 "国标条码",对应属性"barCode"
     * 
     * @return String
     */
    public String getBarCode() {
        return this.barCode;
    }

    /**
     * 设置 "国标条码",对应属性"barCode"
     *
     * @param barCode
     *            String
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * 获得 "零售价",对应属性"retailPrice"
     * 
     * @return String
     */
    public String getRetailPrice() {
        return this.retailPrice;
    }

    /**
     * 设置 "零售价",对应属性"retailPrice"
     *
     * @param retailPrice
     *            String
     */
    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获得 "洗标",对应属性"washing"
     * 
     * @return String
     */
    public String getWashing() {
        return this.washing;
    }

    /**
     * 设置 "洗标",对应属性"washing"
     *
     * @param washing
     *            String
     */
    public void setWashing(String washing) {
        this.washing = washing;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HenghuaClothDetail [serialNo=" + serialNo + ", size=" + size + ", category=" + category + ", wearing="
                + wearing + ", style=" + style + ", materials=" + materials + ", color=" + color + ", fabricNo="
                + fabricNo + ", barCode=" + barCode + ", retailPrice=" + retailPrice + ", washing=" + washing + "]";
    }
}
