package com.goodlaike.henghua.entity.model;

/**
 * Store 的子类 <br>
 * 包含 countryName
 * 
 * @author jail
 *
 */
public class VStore extends Store {

    private static final long serialVersionUID = -7671320365416604624L;
    /**
     * 国家名
     */
    private String countryName;
    /**
     * 获得 countryName
     * @return String
     */
    public String getCountryName() {
        return countryName;
    }
    /**
     * 设置  countryName
     * @param countryName String
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VStore [countryName=" + countryName + "]";
    }
}
