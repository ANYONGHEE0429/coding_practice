<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function check(){
	var userid = document.getElementBId("userid);
	var userpwd = document.getElementBId("userpwd);

	if(userid.value.length < 3 || userid.value.lenth > 10) {  //자릿수 
		alert("ID는 3~10자리로 입력하세요");
		return false;
	}
	if(userpwd.value.length < 3 || userpwd.value.lenth > 10) {
		alert("PSSWORD는 3~10자리로 입력하세요");
		return false;
	}

</script>
</head>
<body>

<form>
	아이디<input type="text" id="userid"><br>
	비밀번호<input type="password" id="userpwd"><br>
	<input type="submit" onclick="return check()">	<!-- return을 넣어줌으로써 submit을 넘기느냐 마느냐  -->
</form>
</body>
</html>
