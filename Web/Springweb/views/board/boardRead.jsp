<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title}</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css" />" />
	<script>
		function boardDelete() {
			if(confirm("삭제 하시겠습니까?")) {
				location.href="/web/board/boardDelete?boardNum=${vo.boardNum}";
			}
		}
		
		function replyWrite() {
			var replytext = document.getElementById("replytext");
			if(replytext.value.length == 0) {
				alert("댓글을 입력하세요");
				return;
			}
			document.getElementById("replyWrite").submit();
		}
		
		function replyModify(replynum, text) {
			var replytext = document.getElementById("replytext");  //"인자값은 이곳에서 입력된 값과 일치하는 것을 찾음"
			var replysubmit = document.getElementById("replysubmit");
			
			replytext.value = text;
			replysubmit.value = "댓글 수정";
			
			replysubmit.onclick = function() {
				var updatetext = replytext.value;
				location.href="/web/board/replyUpdate?replynum=" + replynum + "&boardNum="+"${vo.boardNum}&replytext="+updatetext;
			}
		}
		
		function replyDelete(replynum) {
			if(confirm("댓글을 삭제하시겠습니까?")) {
				location.href="/web/board/replyDelete?replynum="+ replynum +"&boardNum="+${vo.boardNum};
			}
		}
	</script>
</head>
<body>
	<c:choose>
		<c:when test="${updateResult == true}">
			<script>alert("수정 완료");</script>
		</c:when>
		<c:when test="${updateResult == false}">
			<script>alert("수정 실패")</script>
		</c:when>
	</c:choose>
<h1>[ 글 읽기 ]</h1>
<table>
	<tr>
		<td class="right" colspan="2">
			<c:if test="${sessionScope.userid == vo.userid}">
				<a href="/web/board/boardUpdateForm?boardNum=${vo.boardNum}"><input type="button" value="수정"></a>
				<input type="button" value="삭제" onclick="boardDelete()">
			</c:if>
			<a href="/web/board/boardList"><input type="button" value="목록"></a>
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<td>${vo.boardNum}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.userid}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><fmt:parseDate value="${vo.inputdate}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss"/>
			<fmt:formatDate value="${parsedDate}"  pattern="yyyy년 MM월 dd일  HH시 mm분 ss초"/></td>
	</tr>
	<tr>
		<th>조회</th>
		<td>${vo.hit}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${vo.title}</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><a href="/web/board/boardDownload?boardNum=${vo.boardNum}">${vo.originalFilename}</a>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea readonly="readonly">${vo.content}</textarea></td>
	</tr>
</table>

<!-- 댓글 입력 -->
<form action="/x`web/board/replyWrite" id="replyWrite" method="post">
	<input type="hidden" name="boardNum" value="${vo.boardNum }" />
	<table id="replyinput">
		<tr>
			<td>
				<input id="replytext" type="text" name="replytext" required="required"/>
				<input id="replysubmit" type="button" value="댓글 입력" onclick="replyWrite()"/>
			</td>
		</tr>
	</table>
</form>

<!-- 댓글 출력 -->
<div id="replydisplay">
<table class="x">
	<c:forEach items="${replylist}" var="reply">
		<tr>
			<td class="replytext">
				${reply.replytext}
			</td>
			<td class="replyid">
				<span>${reply.userid} </span>
			</td>
			<td class="replydate">
				<span>${reply.inputdate}</span>
			</td>
			<c:if test="${sessionScope.userid == reply.userid }">
				<td class="replybtn">
					<input type="button" value="수정" onclick="replyModify('${reply.replynum}', '${reply.replytext}')">
					<input type="button" value="삭제" onclick="replyDelete('${reply.replynum}')" >
				</td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</div> <!-- end #replydisplay -->

</body>
</html>
