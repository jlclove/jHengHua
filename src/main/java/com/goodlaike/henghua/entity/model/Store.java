package com.goodlaike.henghua.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 门店
 * 
 * @author jail
 */
@Alias("store")
public class Store implements Serializable {

    private static final long serialVersionUID = 2967630998382638884L;

    /**
     * 主键ID
     */
    private int id;
    /**
     * 国家ID
     */
    private int countryId;
    /**
     * 门店名
     */
    private String storeName;
    /**
     * 地址
     */
    private String address;
    /**
     * 省份
     */
    private String province;
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 工作时间1， 格式 10:00-21:00
     */
    private String workTime1;
    /**
     * 工作时间2， 格式 10:00-21:00
     */
    private String workTime2;
    /**
     * 工作时间3， 格式 10:00-21:00
     */
    private String workTime3;
    /**
     * 工作时间4， 格式 10:00-21:00
     */
    private String workTime4;
    /**
     * 工作时间5， 格式 10:00-21:00
     */
    private String workTime5;
    /**
     * 工作时间6， 格式 10:00-21:00
     */
    private String workTime6;
    /**
     * 工作时间7， 格式 10:00-21:00
     */
    private String workTime7;
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
     * 获得 id
     * 
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * 设置 id
     * 
     * @param id
     *            int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获得 countryId
     * 
     * @return int
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * 设置 countryId
     * 
     * @param countryId
     *            int
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * 获得 storeName
     * 
     * @return String
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置 storeName
     * 
     * @param storeName
     *            String
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * 获得 address
     * 
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 address
     * 
     * @param address
     *            String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获得 province
     * 
     * @return String
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置 province
     * 
     * @param province
     *            String
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获得 zipCode
     * 
     * @return String
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置 zipCode
     * 
     * @param zipCode
     *            String
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获得 phone
     * 
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 phone
     * 
     * @param phone
     *            String
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获得 workTime1
     * 
     * @return String
     */
    public String getWorkTime1() {
        return workTime1;
    }

    /**
     * 设置 workTime1
     * 
     * @param workTime1
     *            String
     */
    public void setWorkTime1(String workTime1) {
        this.workTime1 = workTime1;
    }

    /**
     * 获得 workTime2
     * 
     * @return String
     */
    public String getWorkTime2() {
        return workTime2;
    }

    /**
     * 设置 workTime2
     * 
     * @param workTime2
     *            String
     */
    public void setWorkTime2(String workTime2) {
        this.workTime2 = workTime2;
    }

    /**
     * 获得 workTime3
     * 
     * @return String
     */
    public String getWorkTime3() {
        return workTime3;
    }

    /**
     * 设置 workTime3
     * 
     * @param workTime3
     *            String
     */
    public void setWorkTime3(String workTime3) {
        this.workTime3 = workTime3;
    }

    /**
     * 获得 workTime4
     * 
     * @return String
     */
    public String getWorkTime4() {
        return workTime4;
    }

    /**
     * 设置 workTime4
     * 
     * @param workTime4
     *            String
     */
    public void setWorkTime4(String workTime4) {
        this.workTime4 = workTime4;
    }

    /**
     * 获得 workTime5
     * 
     * @return String
     */
    public String getWorkTime5() {
        return workTime5;
    }

    /**
     * 设置 workTime5
     * 
     * @param workTime5
     *            String
     */
    public void setWorkTime5(String workTime5) {
        this.workTime5 = workTime5;
    }

    /**
     * 获得 workTime6
     * 
     * @return String
     */
    public String getWorkTime6() {
        return workTime6;
    }

    /**
     * 设置 workTime6
     * 
     * @param workTime6
     *            String
     */
    public void setWorkTime6(String workTime6) {
        this.workTime6 = workTime6;
    }

    /**
     * 获得 workTime7
     * 
     * @return String
     */
    public String getWorkTime7() {
        return workTime7;
    }

    /**
     * 设置 workTime7
     * 
     * @param workTime7
     *            String
     */
    public void setWorkTime7(String workTime7) {
        this.workTime7 = workTime7;
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
     * @param creator
     *            int
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
     * @param createTime
     *            Date
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
     * @param updator
     *            int
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
     * @param updateTime
     *            Date
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
        return "Store [id=" + id + ", countryId=" + countryId + ", storeName=" + storeName + ", address=" + address
                + ", province=" + province + ", zipCode=" + zipCode + ", phone=" + phone + ", workTime1=" + workTime1
                + ", workTime2=" + workTime2 + ", workTime3=" + workTime3 + ", workTime4=" + workTime4 + ", workTime5="
                + workTime5 + ", workTime6=" + workTime6 + ", workTime7=" + workTime7 + ", creator=" + creator
                + ", createTime=" + createTime + ", updator=" + updator + ", updateTime=" + updateTime + "]";
    }
}
