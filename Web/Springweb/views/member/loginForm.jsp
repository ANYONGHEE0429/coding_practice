<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h1>[ 로그인 ]</h1>
	<form action="login" method="post">
		ID <input type="text" name="userid"><br>
		PASSWORD <input type="password" name="userpwd"><br>
		<input type="submit" value="로그인"><br>
		
		<c:if test="${result==false}">
			ID 또는 PASSWORD 가 일치하지 않습니다
		</c:if>
	</form>
</body>
</html>

