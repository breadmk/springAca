<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#login_section{width:1100px;height:500px;margin: auto; text-align: center;}
	#logsecond{width:350px; margin: auto; padding: 20px;}
/* 	#logsecond #secu{float:left;} */
/* 	#logsecond #log{float:right;} */
	#loginbtn{width:300px; height:40px; color:white; background: purple; border:1px solid purple;}
	#registerbtn{width:300px; height:40px; color: purple; background: white; border:1px solid purple;}
</style>
<script>
	$(function(){
		$("#registerbtn").click(function(){
			location.href="../member/member";
		});
	});
</script>
<div id="login_section">
 <form method="post" action="login_ok">
	<h2>로그인</h2>
	<div><input type="text" name="userid" placeholder="아이디를 입력하세요"></div>
	<div><input type="password" name="pwd" placeholder="비밀번호를 입력하세요"></div>
	<c:if test="${param.chk==1}">
		<div style="color:red;" font-size="13">비밀번호 혹은 아이디가 틀립니다.</div>
	</c:if>
	<div id="logsecond">
	 <div id="secu"><input type="checkbox" checked>보안접속 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <a href="userid_search">아이디찾기</a> | <a href="pwd_search">비밀번호찾기</a></div>
	</div>
	<div><input type="submit" value="로그인" id="loginbtn"></div>
	<div><input type="button" value="회원가입" id="registerbtn"></div>
 </form>
</div>