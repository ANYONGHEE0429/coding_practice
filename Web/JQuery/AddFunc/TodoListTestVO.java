package com.todoList.web.vo;

import lombok.AllArgsConstructor; //모든 필드 값을 파라미터로 받는 생성자를 생성
import lombok.Data;
import lombok.NoArgsConstructor; //파라미터가 없는 기본 생성자를 생성

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestVO {
	private String id;
	private String name;
}
