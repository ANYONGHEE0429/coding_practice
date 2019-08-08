package com.todoList.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todoList.web.vo.TestVO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "test5", method = RequestMethod.POST)
	@ResponseBody	
	public ArrayList<TestVO> test5() {
		ArrayList<TestVO> list = new ArrayList<>();
		list.add(new TestVO("아이디 1", "이름1"));
		list.add(new TestVO("아이디 2", "이름2"));
		list.add(new TestVO("아이디 3", "이름3"));
		list.add(new TestVO("아이디 4", "이름4"));
		
		return list;
	}
	
	@RequestMapping(value = "test4", method = RequestMethod.POST)
	@ResponseBody	
	public void test4(TestVO vo) {
		System.out.println(vo);
	}
	
	@RequestMapping(value = "test3", method = RequestMethod.POST)
	@ResponseBody	
	public void test3(@RequestBody TestVO vo) {
		System.out.println(vo);
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.POST)
	@ResponseBody	
	public void test2(TestVO vo) {
		System.out.println(vo);
	}
	
	@RequestMapping(value = "test1", method = RequestMethod.GET)
	@ResponseBody	//메소드에서 리턴되는 값은 View 를 통해서 출력되지 않고 HTTP Response Body 에 직접 사용
	public void test1(String id, String name) {
		System.out.println(id);
		System.out.println(name);
	}
	
	// 메인화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "ajaxTest", method = RequestMethod.GET)
	public String ajaxTest() {
		return "ajaxTest";
	}
	
}
