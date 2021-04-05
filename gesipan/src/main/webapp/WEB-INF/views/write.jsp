<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<h4>글 작성하기</h4>
<form action="write_ok" method="post">
  <div class="form-group">
  <label for="usr">제목</label>
  <input type="text" class="form-control" id="usr" name="title">
</div>
<div class="form-group">
  <label for="comment">내용</label>
  <textarea class="form-control" rows="5" name="content"></textarea>
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
<input type="text" name="email">@
<select name="email2">
<option value="none">선택</option>
<option value="naver.com">naver</option>
<option value="daum.net">daum</option>
<option value="nate.com">nate</option>
<option value="google.com">google</option>
</select><p>
<button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>