package com.goodlaike.henghua.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * 恒华 样品 类
 * 
 * @author jail
 */
@Alias("sample")
public class HenghuaSample implements Serializable {

    private static final long serialVersionUID = -6528459617198584508L;

    /**
     * 主键ID
     */
    private long id;
    /**
     * 样卡ID
     */
    private String cardId;
    /**
     * 昵称
     */
    private String nick;
    /**
     * 样品原始图片集合
     */
    private String sample2Img;
    /**
     * 样卡材料
     */
    private String material;
    /**
     * 中文描述
     */
    private String descCn;
    /**
     * 中文描述,为了接收，又不想用这个字段名，暂时用这个办法
     */
    @JSONField(serialize = false)
    private String Desc_Cn;
    /**
     * 英文描述
     */
    private String descEn;
    /**
     * 英文描述,为了接收，又不想用这个字段名，暂时用这个办法
     */
    @JSONField(serialize = false)
    private String Desc_En;
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
     * 获得 "样卡ID",对应属性"cardId"
     * 
     * @return String
     */
    public String getCardId() {
        return this.cardId;
    }

    /**
     * 设置 "样卡ID",对应属性"cardId"
     *
     * @param cardId
     *            String
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 获得 "昵称",对应属性"nick"
     * 
     * @return String
     */
    public String getNick() {
        return this.nick;
    }

    /**
     * 设置 "昵称",对应属性"nick"
     *
     * @param nick
     *            String
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
     * @param sample2Img
     *            String
     */
    public void setSample2Img(String sample2Img) {
        this.sample2Img = sample2Img;
    }

    /**
     * 获得 "样卡材料",对应属性"material"
     * 
     * @return String
     */
    public String getMaterial() {
        return this.material;
    }

    /**
     * 设置 "样卡材料",对应属性"material"
     *
     * @param material
     *            String
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * 获得 "中文描述",对应属性"descCn"
     * 
     * @return String
     */
    public String getDescCn() {
        return this.Desc_Cn;
    }

    /**
     * 设置 "中文描述",对应属性"descCn"
     *
     * @param descCn
     *            String
     */
    public void setDescCn(String descCn) {
        this.descCn = descCn;
    }

    /**
     * 获得 "英文描述",对应属性"descEn"
     * 
     * @return String
     */
    public String getDescEn() {
        return this.descEn;
    }

    /**
     * 设置 "英文描述",对应属性"descEn"
     *
     * @param descEn
     *            String
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

    /**
     * 获得 "#{bare_field_comment}",对应属性"desc_Cn"
     * 
     * @return String
     */
    public String getDesc_Cn() {
        return this.Desc_Cn;
    }

    /**
     * 设置 "#{bare_field_comment}",对应属性"desc_Cn"
     *
     * @param desc_Cn
     *            String
     */
    public void setDesc_Cn(String desc_Cn) {
        Desc_Cn = desc_Cn;
    }

    /**
     * 获得 "#{bare_field_comment}",对应属性"desc_En"
     * 
     * @return String
     */
    public String getDesc_En() {
        return this.Desc_En;
    }

    /**
     * 设置 "#{bare_field_comment}",对应属性"desc_En"
     *
     * @param desc_En
     *            String
     */
    public void setDesc_En(String desc_En) {
        Desc_En = desc_En;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HenghuaSample [id=" + id + ", cardId=" + cardId + ", nick=" + nick + ", sample2Img=" + sample2Img
                + ", material=" + material + ", descCn=" + descCn + ", descEn=" + descEn + ", creator=" + creator
                + ", createTime=" + createTime + ", updator=" + updator + ", updateTime=" + updateTime + "]";
    }
}
