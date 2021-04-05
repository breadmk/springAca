<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		
		document.getElementById("sel").value=${page};
	}

</script>
</head>
<body>
	<table align="center" width="600" border="1">
		<tr>
			<td colspan="4" align="right">
				<select id="sel" onchange="location='list?page='+this.value">
				<c:forEach var="p" begin="1" end="${page_cnt}">
					<option value="${p}">${p}page</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td>제목</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
		
		<c:forEach items="${list}" var="bdto">
		<tr>
			<td>${bdto.name}</td>
			<td><a href="readnum?id=${bdto.id}">${bdto.title}</a></td>
			<td>${bdto.readnum}</td>
			<td>${bdto.writeday}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center"><a href="write">글 작성</a></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<!-- 현재페이지 이전으로 이동 시작: 1페이지 단위, 10페이지 이동 -->
		<c:if test="${pstart != 1}">
			<a href="list?page=${pstart-1}"> ◀◀ </a>
   		 </c:if>
   		 <c:if test="${page != 1}">
       		<a href="list?page=${page-1}"> 이전</a>
    	 </c:if>
			<c:forEach var="i" begin="${pstart}" end="${pend}">
			<c:if test="${page != i}"> 
          	 <a href="list?page=${i}"> ${i} </a>
        		</c:if>
        		<c:if test="${page == i}">
				<a href="list?page=${i}" style="color:red">${i}</a>
				 </c:if>
			</c:forEach>
			<!-- 현재 페이지 이후로 이동 시작 -->
			 <c:if test="${page != page_cnt}">
		       <a href="list?page=${page+1}"> 다음 </a>
		      </c:if>
		      <c:if test="${page == page_cnt}">
		                   다음
		      </c:if>
		      <c:if test="${pend != page_cnt}">
	       		<a href="list?page=${pend+1}"> ▶▶  </a>
		      </c:if>
		      <c:if test="${pend == page_cnt}">
		                    ▶▶
		      </c:if>   
			</td>
		</tr>
	</table>
</body>
</html>