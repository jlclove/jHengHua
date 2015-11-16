package com.goodlaike.henghua.interceptor;

import com.goodlaike.business.core.helper.LoginHelper;
import com.goodlaike.business.core.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA. PackageName:com.goodlaike.henghua.interceptor
 * Author: Charles.xu Create: Charles.xu (2015-09-16 下午11:04) Description: To
 * change this template use File | Settings | File Templates.
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = LoginHelper.getLoginUser(request);
		if (user == null) {
			response.sendRedirect("/admin/login");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
