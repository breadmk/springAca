<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../mk/aside.jsp"%>
<style>
.gdsThumbImg{width:100px; height:100px; margin: 0px; }
.gdsThumbImg img{width:100px; height:100px;}
.goods{list-style: none;}
.goodscon{width:850px; margin: auto; margin-top: 70px; padding-left: 130px;}
.gdsNum{text-align: right;}
.gdsThumbImg{text-align: center;}
#no{display: none;}
.col-md-4{width:250px; height:250px;}
.thumbnail img{width:250px; height:200px;}
</style>

<script type="text/javascript">
	$(function(){
		$(".thumbnail").click(function(){
			var no = $(this).find("#no").text();
			location="/shop/view?no="+no;
		});
	});
</script>
<div class="container">
 <div class="goodscon">
 <h2>상품목록</h2>
	<div class="row">
<c:forEach items="${list}" var="list">
  <div class="col-md-4">
    <div class="thumbnail">
        <img src="${list.gdsThumbImg}" alt="Lights" style="width:100%">
          <p id="no">${list.gdsNum}</p>
          <p>${list.gdsName}</p>
    </div>
  </div>
</c:forEach>
</div>
 </div>
</div>
