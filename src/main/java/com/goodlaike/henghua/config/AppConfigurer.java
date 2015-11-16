package com.goodlaike.henghua.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Jail Hu
 * @description 配置参数加载类
 * @date 2014年4月9日
 */
public class AppConfigurer extends PropertyPlaceholderConfigurer {

	Log log = LogFactory.getLog(AppConfigurer.class);

	@Override
	protected Properties mergeProperties() throws IOException {
		Properties superProps = super.mergeProperties();
		log.info(">>>>>>>>>>>>> env:" + superProps.getProperty("env"));
		return superProps;
	}

	// 用于 其余地方 @propertySource + @value 取值
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
