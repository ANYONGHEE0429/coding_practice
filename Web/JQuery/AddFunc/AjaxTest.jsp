<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link>
<meta charset="UTF-8">
<title>ajaxTest</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	$(function() {
		$('#btn1').on('click', test1);	//
		$('#btn2').on('click', test2);
		$('#btn3').on('click', test3);
		$('#btn4').on('click', test4);
		$('#btn5').on('click', test5);
		$('#btn6').on('click', test6);
	});

	function test1() {
		$.ajax({
			url : "test1",
			type : "get",
			data : {
				"id" : "testid",
				"name" : "testname"
			},
			success : function() {
				alert("성공")
			},
			error : function() {
				alert("에러")
			}
		});
	}

	function test2() {
		$.ajax({
			url : "test2",
			type : "post",
			data : {
				"id" : "testid",
				"name" : "testname"
			},
			success : function() {
				alert("성공")
			},
			error : function() {
				alert("에러")
			}
		});
	}

	function test3() {
		$.ajax({
			url : "test3",
			type : "post",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify({
				"id" : "아이디1",
				"name" : "이름1"
			}),
			success : function() {
				alert("성공")
			},
			error : function() {
				alert("에러")
			}
		});
	}

	function test4() {
		$.ajax({
			url : "test4",
			type : "post",
			data : $("#test4").serialize(),
			success : function() {
				alert("성공")
			},
			error : function() {
				alert("에러")
			}
		});
	}

		
		var temp;
		function test5(){
			$.ajax({
				url: "test5",
				type: "post",
				dataType:"json",	
				success : function(result){
					$(result).each(function(index, item){
						$("#here").append()
							"<tr><td>" +item.id+"</td><td>" + item.name+ "</td></tr>"
						})
				},
					error: function() {alert("에러")}
			});
	}
</script>
</head>
<body>
	<form id="test4">
		ID :<input type="text" name="id"><br> NAME : <input
			type="text" name="name"><br>
	</form>
	<input type="button" id="btn1" value="test1">
	<br>
	<input type="button" id="btn2" value="test2">
	<br>
	<input type="button" id="btn3" value="test3">
	<br>
	<input type="button" id="btn4" value="test4">
	<br>
	<input type="button" id="btn5" value="test5">
	<br>
	
	<div>
		<table id="here">
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</table>
	</div>
</body>
</html>
