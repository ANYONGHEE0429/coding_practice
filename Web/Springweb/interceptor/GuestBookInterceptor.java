package com.test.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GuestbookInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	//컨트롤러 실행 전 호출
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userid");
		if(obj ==null){
			response.sendRedirect("/web/member/loginForm");
			return false;
		}
		System.out.println("게스트북 preHandle");
		return true;
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 	//컨트롤러 실행 후 호출
			ModelAndView modelAndView) throws Exception {
		System.out.println("게스트북 postHandle");	
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("게스트북 afterCompletion");
	}
 
	
}
