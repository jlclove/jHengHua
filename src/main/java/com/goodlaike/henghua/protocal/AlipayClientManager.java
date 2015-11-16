package com.goodlaike.henghua.protocal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * ali支付 客户端 采用 @Component 与 @Value 来获取 值
 * 
 * @author jail
 */
@Component
@PropertySource(value = { "classpath:global.properties", "classpath:${env}.web.properties" })
public class AlipayClientManager {

	@Value("${alipayId}")
	private String appId;

	@Value("${serverUrl}")
	private String serverUrl;

	@Value("${privateKey}")
	private String privateKey;

	/*
	 * public void al() { System.out.println(this.appId);
	 * System.out.println(this.serverUrl); System.out.println(this.privateKey);
	 * }
	 */

	public AlipayClient getClient() {
		DefaultAlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey);
		return alipayClient;
	}
}
