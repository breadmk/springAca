<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script>
 function cal(i){
     
     var jung = document.getElementsByClassName("jung")[i].value;
     var gimal = document.getElementsByClassName("gimal")[i].value;
     var chul = document.getElementsByClassName("chul")[i].value;
     var report = document.getElementsByClassName("report")[i].value;
     var url = "sung_cal?jung="+jung+"&gimal="+gimal+"&chul="+chul+"&report="+report;
     var chk = new XMLHttpRequest();
     chk.open("get",url)
     chk.send();
     
     
     chk.onreadystatechange=function(){
        
        if(chk.readyState==4){
        	document.getElementsByClassName("hap")[i].value=chk.responseText
       }
   }
 }
 </script>
</head>
<body>
<table width="500">
 <tr>
  <td> 중간고사 (30) </td>
  <td> 기말고사  (30)</td>
  <td> 출석 (20) </td>
  <td> 레포트 (20) </td>
  <td> 합계 </td>
 </tr>
<c:forEach var="i" begin="1" end="10">
  <tr>
   <td> <input type="text" size="3" class="jung"> </td>
   <td> <input type="text" size="3" class="gimal"></td>
   <td> <input type="text" size="3" class="chul"> </td>
   <td> <input type="text" size="3" class="report"> </td>
   <td> 
       <input type="button" onclick="cal(${i-1})" value="합계"> 
       <input type="text" size="4" class="hap"> 
   </td>
  </tr>
</c:forEach>
</table>
</body>
</html>