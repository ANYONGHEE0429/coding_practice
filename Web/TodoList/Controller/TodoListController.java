package com.todoList.web.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todoList.web.service.TodolistService;
import com.todoList.web.vo.TodolistVO;

@Controller
@RequestMapping("/tlist")
public class TodolistController {

	@Autowired
	private TodolistService service;
	
	// Todo List 화면 이동
	@RequestMapping(value = "todolist", method = RequestMethod.GET)
	public String todolist(Model model, HttpSession session) {
		ArrayList<TodolistVO> list = service.todolist(session);
		ArrayList<Integer> cnt = service.regdateCnt(session);
		Date today = service.getToday();
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
		model.addAttribute("today", today);
		return "/todolist/todolist";
	}
	
	// Todo List 등록
	@RequestMapping(value = "insertTodolist", method = RequestMethod.POST)
	public String insertTodolist(TodolistVO vo, HttpSession session) {
		service.insertTodolist(vo, session);
		return "redirect:/tlist/todolist";
	}
}
