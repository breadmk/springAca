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
  <script type="text/javascript">
  
  function init(){
	  var sex = '<c:out value="${dto.sung}"/>'
		document.mk.sung.value=sex;
	  
	  var kinds = '<c:out value="${dto.kind}" />'
	  	var kind1 = kinds.split(",");
	    for(i=0; i<kind1.length; i++){
			if(kind1[i]==document.mk.kind[0].value){
 	    		document.mk.kind[0].checked=true;
			}else if(kind1[i]==document.mk.kind[1].value){
				document.mk.kind[1].checked=true;
			}else if(kind1[i]==document.mk.kind[2].value){
				document.mk.kind[2].checked=true;
			}else if(kind1[i]==document.mk.kind[3].value){
				document.mk.kind[3].checked=true;
			}else if(kind1[i]==document.mk.kind[4].value){
				document.mk.kind[4].checked=true;
			}else if(kind1[i]==document.mk.kind[5].value){
				document.mk.kind[5].checked=true;
			}	    	    	    	    
		}
	    
	    var domain = '<c:out value="${dto.email2}" />'
	    document.mk.email2.value = domain;
	    
	    var chk = '<c:out value="${param.chk}" />'
	    if(chk==1)
	    	alert("비밀번호가 틀렸습니다.")
  }
  </script>
</head>
<body onload="init()">
<div class="container">
<h4>글 작성하기</h4>
<form action="update_ok" method="post" name="mk">
<input type="hidden" name="id" value="${dto.id}">
  <div class="form-group">
  <label for="usr">제목</label>
  <input type="text" class="form-control" id="usr" name="title" value="${dto.title}">
</div>
<div class="form-group">
  <label for="comment">내용</label>
  <textarea class="form-control" rows="5" name="content">${dto.content}</textarea>
</div>
<div class="form-group">
  <label for="pwd">비밀번호</label>
  <input type="password" class="form-control" id="pwd" name="pwd">
</div>
<label class="radio-inline"><input type="radio" name="sung" value="남자">남자</label>
<label class="radio-inline"><input type="radio" name="sung" value="여자">여자</label>
<label class="radio-inline"><input type="radio" name="sung" value="안함">선택안함</label><p>
<label class="checkbox-inline"><input type="checkbox" value="낚시" name="kind">낚시</label>
<label class="checkbox-inline"><input type="checkbox" value="운동" name="kind">운동</label>
<label class="checkbox-inline"><input type="checkbox" value="음주" name="kind">음주</label>
<label class="checkbox-inline"><input type="checkbox" value="게임" name="kind">게임</label>
<label class="checkbox-inline"><input type="checkbox" value="잠자기" name="kind">잠자기</label>
<label class="checkbox-inline"><input type="checkbox" value="먹기" name="kind">먹기</label><p>
<input type="text" name="email" value="${dto.email}">@
<select name="email2">
<option value="none">선택</option>
<option value="naver.com">naver</option>
<option value="daum.net">daum</option>
<option value="nate.com">nate</option>
<option value="google.com">google</option>
</select><p>
 <input type="submit" value="수정하기">
</form>
</div>
</body>
</html>