package com.goodlaike.henghua.entity.model;

import java.io.Serializable;

/**
 * 国家类
 * 
 * @author jail
 */
public class Country implements Serializable {

    private static final long serialVersionUID = 6814202057015866200L;

    /**
     * 国家ID
     */
    private int id;
    /**
     * 国家名
     */
    private String name;

    /**
     * 获得 "国家ID",对应属性"id"
     * 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * 设置 "国家ID",对应属性"id"
     *
     * @param id
     *            int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获得 "国家名",对应属性"name"
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 "国家名",对应属性"name"
     *
     * @param name
     *            String
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Country [id=" + id + ", name=" + name + "]";
    }

}
