package com.todoList.web.dao;

import java.util.ArrayList;

import com.todoList.web.vo.TodolistVO;

public interface TodolistMapper {
	public void insertTodolist(TodolistVO vo);
	
	public ArrayList<TodolistVO> todolist(String userid);
	
	public ArrayList<Integer> regdateCnt(String userid);
}
