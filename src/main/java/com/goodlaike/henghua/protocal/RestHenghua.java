package com.goodlaike.henghua.protocal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.goodlaike.framework.dao.utils.TextUtil;
import com.goodlaike.resttemplate.client.RestClient;

/**
 * 恒华样卡同步类， 采用 @Component、@PropertySource 与 @Value 来实现，需要定义 @Bean <br>
 * public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
 * <br>
 * return new PropertySourcesPlaceholderConfigurer();<br>
 * } 才能正确取到值
 * 
 * @author jail
 */
@Component
@PropertySource(value = { "classpath:api_henghua.properties" })
public class RestHenghua {

    @Value("${sample_list}")
    private String apiSampleList;
    @Value("${sample_type}")
    private String apiSampleType;
    @Value("${sample_detail}")
    private String apiSampleDetail;
    @Value("${sample_detail_filter}")
    private String apiSampleDetailFilter;
    @Value("${cloth_list}")
    private String apiClothList;
    @Value("${cloth_detail}")
    private String apiClothDetail;
    @Value("${washing_list}")
    private String apiWashingList;
    @Value("${cloth_type}")
    private String apiClothType;
    @Value("${cloth_filter}")
    private String apiClothFilter;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 获得所有样卡数据， 接口提供非正常 json,当 json 输出
     * 
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午12:22:52
     * @updator jail
     * @updateTime 2015年9月4日下午12:22:52
     */
    public String restSampleAll() {
        return RestClient.exchange(this.apiSampleList, HttpMethod.GET, String.class);
    }

    /**
     * 根据语言参数 获得 接口的样品分类数据
     * 
     * @param langType
     *            语言参数 ，0 中文 1英文
     * @return String
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日上午11:49:39
     * @updator jail
     * @updateTime 2015年9月4日上午11:49:39
     */
    public String restSampleType(int langType) {
        return RestClient.exchange(TextUtil.format(this.apiSampleType, langType), HttpMethod.GET, String.class);
    }

    /**
     * 获得指定样品数据
     * 
     * @param detailName
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月4日下午11:48:43
     * @updator jail
     * @updateTime 2015年9月4日下午11:48:43
     */
    public String restSampleDetail(String detailName) {
        return RestClient.exchange(TextUtil.format(this.apiSampleDetail, detailName), HttpMethod.GET, String.class);
    }

    /**
     * 获得样品筛选
     * 
     * @param langType
     *            语言参数
     * @param filter
     *            筛选参数
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日上午9:45:04
     * @updator jail
     * @updateTime 2015年9月5日上午9:45:04
     */
    public String restSampleFilter(int langType, String filter) {
        return RestClient.exchange(TextUtil.format(this.apiSampleDetailFilter, langType, filter), HttpMethod.GET,
                String.class);
    }

    /**
     * 获得所有服装款式
     * 
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午3:10:26
     * @updator jail
     * @updateTime 2015年9月5日下午3:10:26
     */
    public String restClothAll() {
        return RestClient.exchange(this.apiClothList, HttpMethod.GET, String.class);
    }

    /**
     * 获得服装详情
     * 
     * @param serialNo
     *            服装内部编码
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午3:10:08
     * @updator jail
     * @updateTime 2015年9月5日下午3:10:08
     */
    public String restClothDetail(String serialNo) {
        return RestClient.exchange(TextUtil.format(this.apiClothDetail, serialNo), HttpMethod.GET, String.class);
    }

    /**
     * 获得所有洗标
     * 
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午5:06:21
     * @updator jail
     * @updateTime 2015年9月5日下午5:06:21
     */
    public String restWashingList() {
        return RestClient.exchange(this.apiWashingList, HttpMethod.GET, String.class);
    }

    /**
     * 获得服装分类
     * 
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午6:38:05
     * @updator jail
     * @updateTime 2015年9月5日下午6:38:05
     */
    public String restClothType() {
        return RestClient.exchange(this.apiClothType, HttpMethod.GET, String.class);
    }

    /**
     * 获得服饰筛选
     * 
     * @param filter
     * @return
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月5日下午7:02:04
     * @updator jail
     * @updateTime 2015年9月5日下午7:02:04
     */
    public String restClothFilter(String filter) {
        return RestClient.exchange(TextUtil.format(this.apiClothFilter, filter), HttpMethod.GET, String.class);
    }

}
