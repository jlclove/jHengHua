package com.goodlaike.henghua.protocal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.goodlaike.framework.dao.utils.TextUtil;
import com.goodlaike.resttemplate.client.RestClient;

/**
 * 恒华样卡同步类， 采用 @Component、@PropertySource 与 @Value 来实现，需要定义 @Bean <br>
 * public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
 * <br>
 * return new PropertySourcesPlaceholderConfigurer();<br>
 * } 才能正确取到值 ， 已经迁移到 {@link com.goodlaike.henghua.config.AppConfigurer}
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

	public void test() {
		System.out.println(this.apiSampleList);
	}

	/**
	 * 获得所有样卡数据， 接口提供非正常 json,当 json 输出
	 * 
	 * @return
	 * @author jail
	 */
	public String restSampleAll() {
		return this.rest(this.apiSampleList);
	}

	/**
	 * 根据语言参数 获得 接口的样品分类数据
	 * 
	 * @param langType
	 *            语言参数 ，0 中文 1英文
	 * @return String
	 * @author jail
	 */
	public String restSampleType(int langType) {
		return this.rest(TextUtil.format(this.apiSampleType, langType));
	}

	/**
	 * 获得指定样品数据
	 * 
	 * @param detailName
	 * @return
	 * @author jail
	 */
	public String restSampleDetail(String detailName) {
		return this.rest(TextUtil.format(this.apiSampleDetail, detailName));
	}

	/**
	 * 获得样品筛选
	 * 
	 * @param langType
	 *            语言参数
	 * @param filter
	 *            筛选参数
	 * @return
	 * @author jail
	 */
	public String restSampleFilter(int langType, String filter) {
		return this.rest(TextUtil.format(this.apiSampleDetailFilter, langType, filter));
	}

	/**
	 * 获得所有服装款式
	 * 
	 * @return
	 * @author jail
	 */
	public String restClothAll() {
		return this.rest(this.apiClothList);
	}

	/**
	 * 获得服装详情
	 * 
	 * @param serialNo
	 *            服装内部编码
	 * @return
	 * @author jail
	 */
	public String restClothDetail(String serialNo) {
		return this.rest(TextUtil.format(this.apiClothDetail, serialNo));
	}

	/**
	 * 获得所有洗标
	 * 
	 * @return
	 * @author jail
	 */
	public String restWashingList() {
		return this.rest(this.apiWashingList);
	}

	/**
	 * 获得服装分类
	 * 
	 * @return
	 * @author jail
	 */
	public String restClothType() {
		return this.rest(this.apiClothType);
	}

	/**
	 * 获得服饰筛选
	 * 
	 * @param filter
	 * @return
	 * @author jail
	 */
	public String restClothFilter(String filter) {
		return this.rest(TextUtil.format(this.apiClothFilter, filter));
	}

	private String rest(String url) {
		System.out.println("==============>>" + url);
		return RestClient.exchange(url, HttpMethod.GET, String.class);
	}
}
