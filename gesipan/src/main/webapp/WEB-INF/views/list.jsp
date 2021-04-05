<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
  <h2>게시판 목록</h2>
  <table class="table">
      <tr>
        <th>제목</th>
        <th>성별</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <tr>
      <c:forEach items="${list}" var="gdto">
        <td><a href="hit?id=${gdto.id}">${gdto.title}</a></td>
        <td>${gdto.sung}</td>
        <td>${gdto.writeday}</td>
        <td>${gdto.hit}</td>
      </tr>
      </c:forEach>
      <tr>
      	<td colspan="4"><a href="write">글쓰기</a>
      </tr>
  </table>
</div>
	
</body>
</html>