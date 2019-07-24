package com.test.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.web.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입 처리
	public int signup(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.signup(vo);
	}
	
	// 로그인 처리
	public MemberVO login(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.login(vo);
	}
}
