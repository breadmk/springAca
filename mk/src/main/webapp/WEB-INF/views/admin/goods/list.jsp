<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<script>

$(function () {
	$(".info").click(function(){
		var no = $(this).find("#gdsNum").text();
		location = "/admin/goods/view?no="+no;
	});
}); 

</script>
<style>
	table th {
		text-align: center;
	}
	img {width:150px; height:80px;}
</style>
      <table class="table">
    <thead>
      <tr>
        <th>썸네일</th>
        <th>번호</th>
        <th>이름</th>
        <th>카테고리</th>
        <th>가격</th>
        <th>수량</th>
        <th>등록일자</th>
      </tr>
    </thead>
    	<c:if test="${empty list}">
		<tr>
			<td colspan="5">데이터가 존재하지 않습니다.</td>
		</tr>
		</c:if>
		<c:if test="${!empty list}">
    <c:forEach items="${list}" var="list">
      <tr class="info">
      	<td><img id="image" src="${list.gdsThumbImg}"></td>
        <td id="gdsNum">${list.gdsNum}</td>
        <td>${list.gdsName}</td>
        <td>${list.cateCode}</td>
        <td><fmt:formatNumber value="${list.gdsPrice}" type="currency"/></td>
        <td><fmt:formatNumber value="${list.gdsStock}" type="number"/></td>
        <td><fmt:formatDate value="${list.gdsDate}" pattern="yyyy.MM.dd"/></td>
      </tr>
      </c:forEach>
      </c:if>
      	<c:if test="${pageObject.totalPage > 1 }">
		<tr>
			<td colspan="6" align="center">
			 <pageNav:pageNav listURI="list" pageObject="${pageObject}" />
			</td>
		</tr>
	</c:if>
  </table>