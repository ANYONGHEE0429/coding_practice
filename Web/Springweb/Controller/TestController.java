package com.test.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.web.service.TestService;
import com.test.web.vo.TestVO;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService service;
	
	@RequestMapping(value = "testInsert", method = RequestMethod.GET)
	public String testInsert(TestVO vo) {
		service.testInsert(vo);
		return "main";
	}
	
	@RequestMapping(value = "sessionTest1", method = RequestMethod.GET)
	public String sessionTest1(HttpSession session) {
		session.setAttribute("test", "세션영역 등록");
		return "main";
	}
	
	@RequestMapping(value = "sessionTest2", method = RequestMethod.GET)
	public String sessionTest2(HttpSession session) {
		session.removeAttribute("test");
		// session.invalidate();
		return "main";
	}
}
