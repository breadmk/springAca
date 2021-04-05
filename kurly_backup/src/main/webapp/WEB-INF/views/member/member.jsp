<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
   #mem_section {
      height:600px;
      font-size:13px;
   }
</style>
<script>
function juso_search()  // 우편번호 버튼 클릭시 호출 함수명
{
  new daum.Postcode({
      oncomplete: function(data) {
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
              addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
              addr = data.jibunAddress;
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.mk.zip.value = data.zonecode; // 우편번호
          document.mk.juso.value = addr;  // 주소
          // 커서를 상세주소 필드로 이동한다.
          document.mk.juso_etc.focus();
      }
  }).open();
}

 function check(my){ // my = form 태그를 가르킨다.
	
	var pwd = $('#pwd').val();
	var pwd2 = $('#pwd2').val();
 	if(pwd != pwd2){
 		$("#pche").text("비밀번호가 서로 다릅니다");
 		$("#pche").css("color","red");
 		alert("비밀번호가 서로 다릅니다.")
 		return false;
 	}
	//아이디 중복확인이 되었는지, 이메일 중복확인이 되었는지 => 중복이 아니여야한다.
	if($("#userid_check").val()==0){
		alert("아이디 중복확인이 되지 않았습니다.");
		return false;
	}else if($("#email_check").val()==0){
		alert("이메일 중복확인이 되지 않았습니다.");
		return false;
	}else{
		return true;
	}
	

} 
</script>
<div id="mem_section">

 <form method="post" action="member_ok" name="mk" onsubmit="return check(this)">
	<input type="hidden" name="userid_check" value="0" id="userid_check" />
	<input type="hidden" name="email_check" value="0" id="email_check" />
	<table width="500" align="center">
		<caption><h3>회원가입</h3></caption>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" id="userid" ><p>
			<span id="uid"></span></td>
			<td><input type="button" value="중복확인" onclick="id_chk()"></td>
<!-- 			<input type="button" value="중복확인" onclick="userid_dupcheck(this.form)"> -->
		</tr>
		<tr>
			<td>비밀번호</td>
			<td colspan="2"><input type="password" name="pwd" id="pwd"></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td colspan="2"><input type="password" name="pwd2" id="pwd2"><p>
			<span id="pche"></span></td>
		</tr>
		<tr>
			<td>이름</td>
			<td colspan="2"><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" id="email"><p>
			<span id="uemail"></span></td>
			<td><input type="button" value="중복확인" onclick="email_chk()"></td>
<!-- 			<input type="button" value="중복확인" onclick="email_dupcheck(this.form)"> -->
		</tr>
		<tr>
			<td>휴대폰</td>
			<td colspan="2"><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td rowspan="3">주소</td>
			<td><input type="text" name="zip"></td>
			<td><input type="button" value="주소검색" onclick="juso_search()"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" name="juso"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" name="juso_etc"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td colspan="2">
				<input type="radio" name="sung" value="0">남자
				<input type="radio" name="sung" value="1">여자
				<input type="radio" name="sung" value="2">선택안함
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td colspan="2"><input type="text" name="birth"></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<input type="submit" value="가입하기"></td>
		</tr>
		
	</table>
 </form>
</div>