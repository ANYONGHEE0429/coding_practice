package com.test.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.TestDAO;
import com.test.web.vo.TestVO;

@Service
public class TestService {
	
	@Autowired
	private TestDAO dao;
	
	public void testInsert(TestVO vo) {
		int result = dao.testInsert(vo);
		System.out.println("testInsert 결과 : " + result);
	}
}
