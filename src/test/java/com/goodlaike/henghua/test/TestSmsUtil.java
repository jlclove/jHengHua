package com.goodlaike.henghua.test;

import org.junit.Test;

import com.aliyuncs.exceptions.ClientException;
import com.goodlaike.framework.tools.utils.aliyun.SmsUtil;
import com.goodlaike.framework.tools.utils.aliyun.SmsUtil.AliSmsType;

public class TestSmsUtil {

	@Test
	public void sendSm() {

		try {
			SmsUtil.sendSms(AliSmsType.TEST, "18621807761", "胡大叔22");
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void randVeriCode() {
		System.out.println((int) ((Math.random() * 9 + 1) * 100000));
	}
}
