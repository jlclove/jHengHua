package com.goodlaike.henghua.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * 公共系统配置参数
 *
 * @author Jerry.hu
 */
public class BaseConfiguration implements Serializable {
	private static final long serialVersionUID = -7702688411943176711L;
	private static Logger logger = Logger.getLogger(BaseConfiguration.class);
	/**
	 * 单例内部变量
	 */
	private static BaseConfiguration config;
	/**
	 * 当前环境，测试: development 集成：integration 生产： production
	 */
	private String env;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 数据源方言
	 */
	private String dialect;

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	/**
	 * 获得 env String
	 *
	 * @return env
	 */
	public String getEnv() {
		return env;
	}

	/**
	 * 设置 env
	 *
	 * @param env
	 */
	public void setEnv(String env) {
		this.env = env;
	}

	/**
	 * 获得 version String
	 *
	 * @return version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 设置 version
	 *
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}



	/**
	 * 判断当前环境是否生产环境
	 *
	 * @return boolean
	 */
	public boolean isProduction() {
		return this.getEnv().equals(BaseConstants.ENV_PRODUCTION);
	}

	/**
	 * 判断当前环境是否集成环境
	 *
	 * @return boolean
	 */
	public boolean isIntegration() {
		return this.getEnv().equals(BaseConstants.ENV_INTEGRATION);
	}

	/**
	 * 判断当前环境是否开发环境
	 *
	 * @return boolean
	 */
	public boolean isDevelopment() {
		return this.getEnv().equals(BaseConstants.ENV_DEVELOPMENT);
	}

	/**
	 * 私有化默认构造函数
	 */
	private BaseConfiguration() {

	}

	/**
	 * 获得单例
	 *
	 * @return
	 */
	public synchronized static BaseConfiguration getInstance() {
		if (config == null) {
			config = new BaseConfiguration();
			try {
				PropertiesConfiguration configuration = new PropertiesConfiguration();
				configuration.setEncoding(BaseConstants.ENCODING);
				configuration.load("global.properties");
				config.setEnv(configuration.getString("env"));
				config.setVersion(configuration.getString("version"));
				configuration.load(config.getEnv() + ".web.properties");
			} catch (ConfigurationException e) {
				logger.error("加载配置文件失败:  " + e.getMessage());
				e.printStackTrace();
			}
		}
		return config;
	}

}
