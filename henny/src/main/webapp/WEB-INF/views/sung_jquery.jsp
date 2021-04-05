<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

 <script>
  $(function()
  {
	  $(".btn").click(function()
	  {
		  var n=$(".btn").index(this);
		  var jung=$(".jung").eq(n).val();
		  var gimal=$(".gimal").eq(n).val();
		  var chul=$(".chul").eq(n).val();
		  var report=$(".report").eq(n).val();
		  $.ajax(
		  { 
		   type: "get",
		   url: "sung_cal",
		   data: {jung:jung,gimal:gimal,chul:chul,report:report} ,  // {name:"값"}
		 
  	       success: function(data)
		   {
		    	$(".hap").eq(n).val(data);
		   }
		  });
	  });
	
  });
	 
 
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
       <input type="button" value="합계" class="btn"> 
       <input type="text" size="4" class="hap"> 
   </td>
  </tr>
</c:forEach>
</table>
</body>
</html>