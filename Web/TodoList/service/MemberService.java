package com.todoList.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.web.dao.MemberDAO;
import com.todoList.web.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	// 회원가입
	public void signup(MemberVO vo) {
		dao.signup(vo);
	}
	
	// 로그인
	public void login(MemberVO vo, HttpSession session) {
		if(dao.login(vo) == 1) session.setAttribute("userid", vo.getUserid());
	}

	// 로그아웃
	public void logout(HttpSession session) {
		session.invalidate();
	}

	public void withdraw(MemberVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		dao.withdraw(vo);
		session.invalidate();
	}
}
