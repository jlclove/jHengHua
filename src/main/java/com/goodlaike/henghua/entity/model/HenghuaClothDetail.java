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

}
