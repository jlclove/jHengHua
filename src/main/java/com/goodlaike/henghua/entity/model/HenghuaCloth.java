package com.goodlaike.henghua.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 恒华 服装类
 * 
 * @author jail
 */
@Alias("cloth")
public class HenghuaCloth implements Serializable {

    private static final long serialVersionUID = -9024463786894584772L;
    /**
     * 主键ID
     */
    private long id;
    /**
     * 服装编号
     */
    private String serialNo;
    /**
     * 服装名
     */
    private String name;
    /**
     * 图片
     */
    private String image;
    /**
     * 创建人ID
     */
    private int creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人ID
     */
    private int updator;
    /**
     * 更新时间
     */
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
     * @param id
     *            long
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获得 "服装编号",对应属性"serialNo"
     * 
     * @return String
     */
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * 设置 "服装编号",对应属性"serialNo"
     *
     * @param serialNo
     *            String
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获得 "服装名",对应属性"name"
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 "服装名",对应属性"name"
     *
     * @param name
     *            String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获得 "图片",对应属性"image"
     * 
     * @return String
     */
    public String getImage() {
        return this.image;
    }

    /**
     * 设置 "图片",对应属性"image"
     *
     * @param image
     *            String
     */
    public void setImage(String image) {
        this.image = image;
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
     * @param creator
     *            int
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
     * @param createTime
     *            Date
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
     * @param updator
     *            int
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
        return "HenghuaCloth [id=" + id + ", serialNo=" + serialNo + ", name=" + name + ", image=" + image
                + ", creator=" + creator + ", createTime=" + createTime + ", updator=" + updator + ", updateTime="
                + updateTime + "]";
    }

}
