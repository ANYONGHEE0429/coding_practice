package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.web.vo.TestVO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	}
	
	@RequestMapping(value = "send1", method = RequestMethod.GET)
	public String send1(String a, int b) {
		System.out.println(a);
		System.out.println(b);
		return "index";
	}
	
	@RequestMapping(value = "send2", method = RequestMethod.GET)
	public String send2(String a, int b) {
		System.out.println(a);
		System.out.println(b);
		return "index";
	}
	
	@RequestMapping(value = "send3", method = RequestMethod.POST)
	public String send3(String a, int b) {
		System.out.println(a);
		System.out.println(b);
		return "index";
	}
	
	@RequestMapping(value = "send4", method = {RequestMethod.GET, RequestMethod.POST})
	public String send4(TestVO vo) {
		System.out.println(vo);
		return "index";
	}
}
