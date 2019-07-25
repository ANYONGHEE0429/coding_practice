package com.test.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor extends HandlerInterceptorAdapter {
// extends HandlerInterceptorAdapter를 먼저 생성하여야만 밑의 Override 생성 가능

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//preHandle란 컨트롤러 실행 전, 호출
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null) return true; //유저아이디가 존재
		response.sendRedirect("/web/member/loginForm");
		return false;
		
		/*HttpSession session = request.getSession();
		Object obj = session.getAttribute("userid");
		if (obj == null) {
			response.sendRedirect("/web/member/loginForm");
			return false;
		}
		return true;*/
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//postHandle란 컨트롤러 실행 후, 호출  
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//컨트롤러 실행 후, 화면 전환 후에 호출      
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);

	}

}
