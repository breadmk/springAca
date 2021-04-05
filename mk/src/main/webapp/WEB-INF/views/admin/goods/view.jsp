<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	.form-group{
		margin: auto;
	}
	.oriImg{width:500px; height:auto;}
	.thumbImg{}
</style>
<script>
	$(function(){
		$("#update").click(function(){
			var gdsNum = ${vo.gdsNum};
			location.href = "update?no="+gdsNum
		});	
		$("#delete").click(function(){
			var con = confirm("정말로 삭제하시겠습니까?");
			var gdsNum = ${vo.gdsNum};
			if(con){
				location.href = "delete?no="+gdsNum
			}else{
				return false;
			}
		});	
	});
</script>
<form method="post">
 <table class="table table-bordered">
 <h3> 상품상세  </h3>
     <tr>
        <td>1차 분류</td>
        <td>-</td>
      </tr>
      <tr>
        <td>2차 분류</td>
        <td>${vo.cateCode}</td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>${vo.gdsName}</td>
      </tr>
      <tr>
        <td>상품가격</td>
        <td>${vo.gdsPrice}</td>
      </tr>
      <tr>
        <td>상품수량</td>
        <td>${vo.gdsStock}</td>
      </tr>
      <tr>
        <td>상품소개</td>
        <td>${vo.gdsDes}</td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td><fmt:formatDate value="${vo.gdsDate}" pattern="yyyy.MM.dd"/></td>
      </tr>
      <tr>
      	<td>원본사진</td>
      	<td><img src="${vo.gdsImg}" class="oriImg"/></td>
      </tr>
      <tr>
      	<td>썸네일</td>
      	<td><img src="${vo.gdsThumbImg}" class="thumbImg"/></td>
      </tr>
       <tr>
        <td colspan="3">
        	<button type="button" class="btn btn-info" onclick="location='list?ch=1'">목록</button>
       		<button type="button" class="btn btn-primary" id="update">수정</button>
        	<button type="button" class="btn btn-danger" id="delete">삭제</button>
        	</td>
      </tr>
</table>
</form>