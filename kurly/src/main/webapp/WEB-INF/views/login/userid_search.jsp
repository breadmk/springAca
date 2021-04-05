<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
#us_section{width:1100px; height:400px; margin: auto;}
</style>

<div id="us_section">
<form method="post" action="userid_view">
	<table width="400" height="300" align="center">
	<caption><h2>아이디 찾기</h2></caption>
		<tr>
			<td>이름</td>
		</tr>
		<tr>
			<td><input type="text" name="name" placeholder="고객님의 이름을 입력하세요"></td>
		</tr>
		<tr>
			<td>이메일</td>
		</tr>
		<tr>
			<td><input type="text" name="email" placeholder="가입시 등록한 이메일을 입력하세요"></td>
		</tr>
		<tr>
			<td> <button type="submit">확 인</button>
		</tr>
	</table>
</form>	
</div>