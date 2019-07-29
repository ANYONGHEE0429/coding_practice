package com.todoList.web.dao;

import com.todoList.web.vo.MemberVO;

public interface MemberMapper {
	
	public void signup(MemberVO vo);
  
	public int login(MemberVO vo);
  
	public void withdraw(MemberVO vo);
}
