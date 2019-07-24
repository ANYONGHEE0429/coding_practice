package com.test.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.web.service.MemberService;
import com.test.web.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 회원가입 화면 이동
	@RequestMapping(value = "signupForm", method = RequestMethod.GET)
	public String signupForm() {
		return "/member/signupForm";
	}
	
	// 회원가입 처리
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(MemberVO vo, Model model) {
		boolean result = service.signup(vo);
		model.addAttribute("memberVO", vo);
		model.addAttribute("result", result);
		return "main";
	}
	
	// 로그인 화면 이동
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "/member/loginForm";
	}
	
	// 로그인 처리
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, Model model) {
		boolean result = service.login(vo, session);
		if(result) return "main";
		model.addAttribute("result", result);
		return "/member/loginForm";
	}
	
	// 로그아웃 처리
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		service.logout(session);
		return "main";
	}
}
