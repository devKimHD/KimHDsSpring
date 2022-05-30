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
			return false; // 角力夸没 贸府 窍瘤 臼澜
		}

		return true; //角力夸没 贸府 
//		super.preHandle(request, response, handler);
	}

}
