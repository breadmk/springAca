<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	display: inline;
}
</style>
</head>
<body>
	<table align="center" width="600">
		<tr>
			<td>작성자</td>
			<td>${bdao.name}</td>
			<td>작성일</td>
			<td>${bdao.writeday}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${bdao.title}</td>
			<td>조회수</td>
			<td>${bdao.readnum}</td>
		</tr>
		<tr>
			<td colspan="1">글 내용</td>
			<td colspan="3">${fn:replace(bdao.content,rn,"<br>")}</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
			<a href="list">목록</a>
			<a href="update?id=${bdao.id}">수정</a>
			<form method="post" action="delete">
			<input type="hidden" name="id" value="${bdao.id}">
			비밀번호<input type="password" name="pwd" size="3">
			<input type="submit" value="삭제"></td>
			</form>
		</tr>
		<tr>
		<td align="center" colspan="4">
		 <c:if test="${param.chk==1}">
	 		<div>비밀번호가 틀렸습니다.</div>
		 </c:if>
		 </td>
		</tr>
	</table>
</body>
</html>