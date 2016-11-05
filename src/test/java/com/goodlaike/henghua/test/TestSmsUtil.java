package com.goodlaike.henghua.test;

import org.junit.Test;

import com.aliyuncs.exceptions.ClientException;
import com.goodlaike.henghua.utils.aliyun.SmsUtil;

public class TestSmsUtil {

	@Test
	public void sendSm() {

		try {
			SmsUtil.sendSms();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
