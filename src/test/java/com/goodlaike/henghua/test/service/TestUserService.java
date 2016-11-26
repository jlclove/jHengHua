package com.goodlaike.henghua.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.goodlaike.business.core.service.user.UserService;
import com.goodlaike.henghua.test.TestBase;

public class TestUserService extends TestBase {

	@Autowired
	private UserService userService;

	@Test
	public void modify() {
		Assert.isTrue(this.userService.updateUser("徐琪", null, null, "链家", "xuqi@163.com", 13, 8));
	}
	
	@Test
	public void changePassword() {
		Assert.isTrue(this.userService.changePassword(13, "222222", "111111", 8));
	}
}
