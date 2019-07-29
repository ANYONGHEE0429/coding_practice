package com.todoList.web.vo;


import java.sql.Date;

import lombok.Data;

@Data
public class TodolistVO {
	private int todoseq;
	private String userid;
	private String tododata;
	private Date regdate;
	private String importance;
	private Date deadline;
	private String result;
	private String comments;
}
