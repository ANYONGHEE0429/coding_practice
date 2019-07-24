<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css"/>" />
<script>
	function pageProc(currentPage, searchItem, searchKeyword) {
		location.href="/web/board/boardList?currentPage=" + currentPage + "&searchItem=" + searchItem + "&searchKeyword=" + searchKeyword;
	}
</script>
</head>
<body>
<c:choose>
	<c:when test="${deleteResult == true}">
		<script>alert("삭제 완료");</script>
	</c:when>
	<c:when test="${deleteResult == false}">
		<script>alert("삭제 실패");</script>
	</c:when>
	<c:when test="${writeResult == true}">
		<script>alert("등록 완료");</script>
	</c:when>
	<c:when test="${writeResult == false}">
		<script>alert("등록 실패");</script>
	</c:when>
</c:choose>
	<h1>[ 게시판 ]</h1>
	<table>
		<tr>
			<td id="boardSearch" colspan="4">
			<form action="/web/board/boardList" method="get">
				<select name="searchItem">
					<option value="title" selected="selected">제목</option>
					<option value="userid">작성자</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="searchKeyword">
				<input type="submit" value="검색">
			</form>
			</td>
			<td class="right">
				<a href="/web/board/boardWriteForm"><img src="<c:url value="/img/write_64.png"/>"></a>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="boardVO">
			<tr>
				<td class="center">${boardVO.boardNum}</td>
				<td class="center">${boardVO.userid}</td>
				<td id="title"><a href="/web/board/boardRead?boardNum=${boardVO.boardNum}">${boardVO.title}</a></td>
				<td class="center">${boardVO.hit}</td>
				<td id="inputdate"><fmt:parseDate value="${boardVO.inputdate}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:formatDate value="${parsedDate}"  pattern="yyyy년 MM월 dd일"/></td>
			</tr>
		</c:forEach>
		
<tr>
	<td id="navigator" colspan="5">
		<a href="javascript:pageProc(${navi.currentPage - navi.pagePerGroup}, '${searchItem}', '${searchKeyword}')">◁◁ </a> &nbsp;&nbsp;
		<a href="javascript:pageProc(${navi.currentPage - 1}, '${searchItem}', '${searchKeyword}')">◀</a> &nbsp;&nbsp;
		<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}"> 
			<c:if test="${counter == navi.currentPage}"><b></c:if>
				<a href="javascript:pageProc(${counter}, '${searchItem}', '${searchKeyword}')">${counter}</a>&nbsp;
			<c:if test="${counter == navi.currentPage}"></b></c:if>
		</c:forEach>
		&nbsp;&nbsp;
		<a href="javascript:pageProc(${navi.currentPage + 1}, '${searchItem}', '${searchKeyword}')">▶</a> &nbsp;&nbsp;
		<a href="javascript:pageProc(${navi.currentPage + navi.pagePerGroup}, '${searchItem}', '${searchKeyword}')">▷▷</a>
	</td>
</tr>
					
	</table>
</body>
</html>
