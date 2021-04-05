<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="update_ok" >
	<div align="center">
	<input type="hidden" name="id" value="${dto.id}">
	 이름<input type="text" name="name" value="${dto.name}"><p>
	 제목<input type="text" name="title" value="${dto.title}"><p>
	 내용<textarea cols="30" rows="4" name="content">${dto.content}</textarea><p>
	  비밀번호<input type="password" name="pwd"></p>
	 <c:if test="${param.chk==1}">
	 <div style="color:red;" >비밀번호가 틀렸습니다.</div>
	 </c:if>
	 <input type="submit" value="수정하기">
	 </div>
</form>
</body>
</html>