package com.todoList.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todoList.web.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void signup(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.signup(vo);
	}

	public int login(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.login(vo);
	}

	public void withdraw(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.withdraw(vo);
	}
}
