<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
<!-- 	<h1><a href="/web/test/testInsert?a=가나다라&b=1234">testInsert</a></h1> -->
<!-- 	<h1><a href="/web/test/testSelect">testSelect1</a></h1> -->
<!-- 	<h1><a href="/web/test/sessionTest1">Session Test1</a></h1> -->
<!-- 	<h1><a href="/web/test/sessionTest2">Session Test2</a></h1> -->
	
<%-- 	sessionScope.test : ${sessionScope.test}<br> --%>
	
	<c:if test="${sessionScope.userid == null}">
		<h1><a href="/web/member/signupForm">회원가입</a></h1>
		<h1><a href="/web/member/loginForm">로그인</a></h1>
	</c:if>
	
	<c:if test="${sessionScope.userid != null}">
		<h1>${sessionScope.userid} 님 반갑습니다!</h1>
		<h1><a href="/web/board/boardList">게시판</a></h1>
		<h1><a href="/web/member/logout">로그아웃</a></h1>
	</c:if>
	<h1><a href="/web/guestbook/guestbookList">방명록</a></h1>
<%-- 	<c:if test="${result == true}"> --%>
<!-- 		<h3>가입 성공</h3> -->
<%-- 	</c:if> --%>
	
<%-- 	<c:if test="${requestScope.memberVO != null}"> --%>
<%-- 		<h3>회원정보 : ${memberVO}</h3> --%>
<%-- 	</c:if> --%>
	
</body>
</html>
