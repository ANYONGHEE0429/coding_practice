package com.test.web.dao;

import com.test.web.vo.MemberVO;

public interface MemberMapper {
	public int signup(MemberVO vo);
	public MemberVO login(MemberVO vo);
}
