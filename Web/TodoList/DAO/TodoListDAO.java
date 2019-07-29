package com.todoList.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todoList.web.vo.TodolistVO;

@Repository
public class TodolistDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertTodolist(TodolistVO vo) {
		TodolistMapper mapper = sqlSession.getMapper(TodolistMapper.class);
		mapper.insertTodolist(vo);
	}

	public ArrayList<TodolistVO> todolist(String userid) {
		TodolistMapper mapper = sqlSession.getMapper(TodolistMapper.class);
		return mapper.todolist(userid);
	}

	public ArrayList<Integer> regdateCnt(String userid) {
		TodolistMapper mapper = sqlSession.getMapper(TodolistMapper.class);
		return mapper.regdateCnt(userid);
	}
}
