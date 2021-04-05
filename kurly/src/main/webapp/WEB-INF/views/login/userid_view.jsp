<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
  #uv_section {
    width:1100px;
    height:300px;
    margin:auto;
    text-align:center;
  }
  #uv_section #btn {
    width:300px;
    height:40px;
    background:purple;
    border:1px solid purple;
    color:white;
    margin-top:20px;
  }
  #uv_section #txt {
    color:purple;
    font-size:19px;
    font-weight:900;
  }
</style>
<div id="uv_section">
 <c:if test="${chk==1}">
<%--  	당신의 아이디는 : ${fn:substring(userid,0,3)}
 	<c:forEach begin="4" end="${fn:length(userid)}">
 		*
 	</c:forEach>
 	입니다. --%>
 	<img src="../resources/img/id_search.png"> <p>
 	<div id="txt"> 고객님의 <br>아이디 찾기가 완료되었습니다!! </div>
 	당신의 아이디는 :${userid}입니다. <p>
 	<button type="button" id="btn"> 로그인 하기 </button>
 </c:if>
  <c:if test="${chk==2}">
  <img src="../resources/img/id_search.png"> <p>
  <div id="txt"> 고객님께서 입력하신 정보가 <br> 정확한지 확인후 다시 시도해 주세요 </div> 
 <button type="button" id="btn"> 아이디 다시 찾기 </button>
 </c:if>
</div>