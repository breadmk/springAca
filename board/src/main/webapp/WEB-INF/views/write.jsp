<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="write_ok">
	<div align="center">
	<h3>글 쓰기</h3>
	 이름<input type="text" name="name"><p>
	 제목<input type="text" name="title"><p>
	 내용<textarea cols="30" rows="4" name="content"></textarea><p>
	 비번<input type="password" name="pwd"><p>
	 <input type="submit" value="저장">
	 </div>
	</form>
</body>
</html>