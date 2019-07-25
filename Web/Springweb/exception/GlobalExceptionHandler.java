package com.test.web.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //예외처리할 클래스에 어노테이션 지정
public class GlobalExceptionHandler {

		@ExceptionHandler(NullPointerException.class) //Exception의 class를 전달하여 해당 메서드가 특정 Exception을 처리 지정
		public String nullPointHandler(Model model, NullPointerException ex){
			model.addAttribute("msg","널 포인트 에러 발생");
			model.addAttribute("ex", ex);
			return "/exception/error";  //Exception 로직 수행 후 지정 페이지로 이동
		}
		  
		@ExceptionHandler(Exception.class) //404 에러 발생시 실행	
		public String Exception(Model model, NullPointerException ex){
			model.addAttribute("msg"," 에러 발생");
			model.addAttribute("ex", ex);
			return "/exception/error";
		}
}
