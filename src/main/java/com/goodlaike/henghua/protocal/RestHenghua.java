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
     * @param langType 语言参数
     * @param filter 筛选参数
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
}
