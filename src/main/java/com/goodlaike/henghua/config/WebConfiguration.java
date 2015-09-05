package com.goodlaike.henghua.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Web 配置类， 使用 @Configuration、@PropertySource 与 Environment 来实现
 * 
 * @author jail
 */
@Configuration
@PropertySource(name = "webSource", value = { "classpath:global.properties" })
public class WebConfiguration {

    @Autowired
    Environment env;

    public String getEnv() {
        return env.getProperty("env");
    }

    public String getVersion() {
        return env.getProperty("version");
    }
}
