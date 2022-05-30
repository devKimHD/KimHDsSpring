package com.kh.myex01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object objLogin = session.getAttribute("loginVo");
		if (objLogin == null) {
			response.sendRedirect("/");
			return false; // ������û ó�� ���� ����
		}

		return true; //������û ó�� 
//		super.preHandle(request, response, handler);
	}

}
