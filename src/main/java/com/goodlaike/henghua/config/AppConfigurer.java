package com.goodlaike.henghua.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

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
		superProps.put("env", BaseConfiguration.getInstance().getEnv());
		log.info(">>>>>>>>>>>>> env:" + superProps.getProperty("env"));
		return superProps;
	}

}
