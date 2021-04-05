<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  form {
	display: inline;
	float: right;
}
  </style>
</head>
<body>
		<div class="container">
  <h2>게시판 목록</h2>
  <table class="table">
      <tr>
        <td>제목</td>
        <td>${dto.title}</td>
      </tr>
      <tr>
        <td>성별</td>
        <td>${dto.sung}</td>
	  </tr>
       <tr>
        <td>취미</td>
        <td>${dto.kind}</td>
      </tr>
      <tr>
        <td>내용</td>
        <td>${dto.content}</td>
      </tr>
      <tr>
        <td>이메일</td>
        <td>${dto.email}@${dto.email2}</td>
      </tr>
      <tr>
        <td>작성일</td>
        <td>${dto.writeday}</td>
      </tr>
      <tr>
        <td>조회수</td>
        <td>${dto.hit}</td>
      </tr>
      <tr>
      	<td colspan="4">
      	<a href="list">목록</a>
      	<a href="update?id=${dto.id}">수정</a>
      	<a href="delete?id=${dto.id}">삭제</a>
      </tr>
  </table>
</div>
</body>
</html>