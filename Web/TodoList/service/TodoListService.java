package com.todoList.web.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.web.dao.TodolistDAO;
import com.todoList.web.vo.TodolistVO;

@Service
public class TodolistService {
	
	@Autowired
	private TodolistDAO dao;
	
	public void insertTodolist(TodolistVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		dao.insertTodolist(vo);
	}

	public ArrayList<TodolistVO> todolist(HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		return dao.todolist(userid);
	}

	public ArrayList<Integer> regdateCnt(HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		return dao.regdateCnt(userid);
	}
	
	public Date getToday() {
		return new Date();
	}
}
