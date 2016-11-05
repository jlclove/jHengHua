package com.goodlaike.henghua.utils.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;

public class SmsUtil {

	public static void sendSms() throws ClientException {
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIXTCOMtDwU4dX", "GkhflnlXDxzABZhwlOzYB0DHCqdQ7W");
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendSmsRequest request = new SingleSendSmsRequest();
		try {
			request.setSignName("短信测试");
			request.setTemplateCode("SMS_16790379");
			request.setParamString("{\"customer\":\"help\"}");
			request.setRecNum("18621807761");
			SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
			System.out.println(httpResponse);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}
