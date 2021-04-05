<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../mk/aside.jsp"%>
<style>
 div.goods div.goodsImg { float:left; width:350px; margin-top: 30px;}
 div.goods div.goodsImg img { width:350px; height:auto; }
 
 div.goods div.goodsInfo { float:right; width:330px; font-size:22px; margin-top: 30px;}
 div.goods div.goodsInfo p { margin:0 0 20px 0; }
 div.goods div.goodsInfo p span { display:inline-block; width:100px; margin-right:15px; }
 
 div.goods div.goodsInfo p.cartStock input { font-size:22px; width:50px; padding:5px; margin:0; border:1px solid #eee; }
 div.goods div.goodsInfo p.cartStock button { font-size:26px; border:none; background:none; }
 div.goods div.goodsInfo p.addToCart { text-align:right; }
 div.goods div.goodsInfo p.cartStock button { font-size:26px; border:none; background:#ccc; }
 div.goods div.gdsDes { font-size:18px; clear:both; padding-top:30px; }

 section.replyForm { padding:30px 0; }
 section.replyForm div.input_area { margin:10px 0; }
 section.replyForm textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px;; height:150px; }
 section.replyForm button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 
 section.replyList { padding:30px 0; }
 section.replyList ol { padding:0; margin:0; list-style: none;}
 section.replyList ol li { padding:10px 0; border-bottom:2px solid #eee; }
 section.replyList div.userInfo { }
 section.replyList div.userInfo .userName { font-size:24px; font-weight:bold; }
 section.replyList div.userInfo .date { color:#999; display:inline-block; margin-left:10px; }
 section.replyList div.replyContent { padding:10px; margin:20px 0; }
section.replyList div.replyFooter button { font-size:14px; border: 1px solid #999; background:none; margin-right:10px; }
</style>
 <script>
//댓글 ajax
function replylist(){
	 var no = ${gv.gdsNum};
		$.getJSON("/shop/view/view_reply?no="+no,function(data){
			var str = "";
			$(data).each(function(){
				console.log(data);
			 var repDate = new Date(this.repDate);
			   repDate = repDate.toLocaleDateString("ko-US")
			   
			   str += "<li data-gdsNum='" + this.gdsNum + "'>"
			     + "<div class='userInfo'>"
			     + "<span class='userName'>" + this.userName + "</span>"
			     + "<span class='date'>" + repDate + "</span>"
			     + "</div>"
			     + "<div class='replyContent'>" + this.repCon + "</div>"
			     + "<div class='replyFooter'>"
			     + "<button type='button' class='modify' data-repNum='" + this.repNum + "'>수정</button>"
			     + "<button type='button' class='delete' data-repNum='" + this.repNum + "'>삭제</button>"
			     + "</div>"
			     + "</li>"; 
			});
		  $("section.replyList ol").html(str);
		});
}
	
 
 //주문 수량 버튼
 $(function(){
  $(".plus").click(function(){
	   var num = $(".numBox").val();
	   var plusNum = Number(num) + 1;
	   
	   if(plusNum >= ${gv.gdsStock}) {
		    $(".numBox").val(num);
		   } else {
		    $(".numBox").val(plusNum);          
		   }
		   
		  });
  
  $(".doubleplus").click(function(){
	   var num = $(".numBox").val();
	   var plusNum = Number(num) + 5;
	   
	   if(plusNum >= ${gv.gdsStock}) {
		    $(".numBox").val(num);
		   } else {
		    $(".numBox").val(plusNum);          
		   }
		   
		  });
  
  $(".minus").click(function(){
   var num = $(".numBox").val();
   var minusNum = Number(num) - 1;
   
   if(minusNum <= 0) {
    $(".numBox").val(num);
   } else {
    $(".numBox").val(minusNum);          
   }
  });
  
  $(".doubleminus").click(function(){
	   var num = $(".numBox").val();
	   var minusNum = Number(num) - 5;
	   
	   if(minusNum <= 0) {
	    $(".numBox").val(num);
	   } else {
	    $(".numBox").val(minusNum);          
	   }
	  });
  replylist()
  $("#reply_btn").click(function(){
// 		var form = $(".replyForm form[role='form']");
		var gdsNum = $("#gdsNum").val();
		var userId = $("#userId").val();
		var repCon = $("#repCon").val();
		
		var data = {gdsNum:gdsNum,
					userId:userId,
					repCon:repCon};
		
		$.ajax({
			url : "/shop/view/insert_reply",
			type : "post",
			data : data,
			success : function(){
				replylist();
			}
		});
		
	});
 });
 
 //댓글 작성 
	
 </script>

<div class="container">
<form role="form" method="post">
 <input type="hidden" name="gdsNum" value="${gv.gdsNum}" />
</form>

<div class="goods">
 <div class="goodsImg">
  <img src="${gv.gdsImg}">
 </div>
 
 <div class="goodsInfo">
  <p class="gdsName"><span>상품명</span>${gv.gdsName}</p>
  
  <p class="cateName"><span>카테고리</span>${gv.cateName}</p>
  
  <p class="gdsPrice">
   <span>가격 </span><fmt:formatNumber pattern="###,###,###" value="${gv.gdsPrice}" /> 원
  </p>
  
  <p class="gdsStock">
   <span>재고 </span><fmt:formatNumber pattern="###,###,###" value="${gv.gdsStock}" /> EA
  </p>
  
<p class="cartStock">
 <span>구입 수량</span>
 <button type="button" class="doubleplus">++</button>
 <button type="button" class="plus">+</button>
 <input type="number" class="numBox" min="1" max="${gv.gdsStock}" value="1" readonly="readonly"/>
 <button type="button" class="minus">-</button>
 <button type="button" class="doubleminus">--</button>
  </p>
  
  <p class="addToCart">
   <button type="button">카트에 담기</button>
  </p>
 </div>
 
 <div class="gdsDes">${gv.gdsDes}</div>
</div>
	<div id="reply">

 <c:if test="${member == null }">
  <p>소감을 남기시려면 <a href="/shop/login">로그인</a>해주세요</p>
 </c:if>
 
 <c:if test="${member != null}">
 <section class="replyForm">
  <form role="form" method="post" autocomplete="off"> <!--  action="/shop/view/insert_reply" -->
  <input type="hidden" value="${gv.gdsNum}" name="gdsNum" id="gdsNum">
  <input type="hidden" value="${member.userId}" name="userId" id="userId">
   <div class="input_area">
    <textarea name="repCon" id="repCon"></textarea>
   </div>
   
   <div class="input_area">
    <button type="submit" id="reply_btn">소감 남기기</button>
   </div>
   
  </form>
 </section>
 </c:if>
 
 <section class="replyList">
   <ol>
   </ol>  
 </section>
</div>
</div>