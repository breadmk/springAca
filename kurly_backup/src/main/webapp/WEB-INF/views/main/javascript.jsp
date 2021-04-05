<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
   .main{ list-style: none; display: inline-block; padding: 10px;}
   .sub{visibility: hidden; list-style: none; border:1px solid #ccc; padding-left:0px;}
 </style>
 <script>
  	function view(i) {
		document.getElementsByClassName("sub")[i].style.visibility="visible";
  	}
  	
    function hide(i)
    {
  	  document.getElementsByClassName("sub")[i].style.visibility="hidden";
    }
 </script>
</head>
<body>
  <ul>
    <li class="main" onmouseover="view(0)" onmouseout="hide(0)"> 농산물 
      <ul class="sub">
        <li> 쌀 </li>
        <li> 잡곡 </li>
        <li> 과일 </li>
        <li> 야채 </li>
      </ul>
    </li>
    <li class="main" onmouseover="view(1)" onmouseout="hide(1)"> 수산물 
      <ul class="sub">
        <li> 생선류 </li>
        <li> 갑각류 </li>
        <li> 조개류 </li>
        <li> 가공품 </li>
      </ul>
    </li>
    <li class="main" onmouseover="view(2)" onmouseout="hide(2)"> 축산물 
      <ul class="sub">
        <li> 소고기 </li>
        <li> 돼지고기 </li>
        <li> 닭고기 </li>
        <li> 이것저것 </li>
      </ul>
    </li>
  </ul>
</body>
</html>