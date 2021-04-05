<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#aside1 {float:left;}
.low li{width:100px;}
 
#aside { float:left; width:180px; } 
#aside h3 { font-size:22px; margin-bottom:20px; text-align:center; } 
#aside ul { list-style: none; position:relative;}
#aside li { font-size:16px; text-align:center; }
#aside li a { color:#000; display:block; padding:10px 0; }
#aside li a:hover { text-decoration:none; background:#eee; } 
#aside li { position:relative; width:130px;} 
#aside li:hover { background:#eee; } 
#aside li > ul.low { display:none; position:absolute; top:0; left:200px; padding-left: 10px;}  /*  */
#aside li:hover > ul.low {display:block; left:50px; margin-left: 30px;} /*  */
#aside li:hover > ul.low li a { background:#eee; border:1px solid #eee;}
#aside li:hover > ul.low li a:hover { background:#fff;}
#aside li > ul.low li { width:150px; }
</style>
<div id="aside">
    <h3>카테고리</h3>
   <ul>
   	<li><a href="../shop/list?c=100&l=1">무기</a>
   		<ul class="low">
   			<li><a href="../shop/list?c=101&l=2">돌격소총</a></li>
   			<li><a href="../shop/list?c=102&l=2">기관단총</a></li>
   			<li><a href="../shop/list?c=103&l=2">경기관총</a></li>
   			<li><a href="../shop/list?c=104&l=2">산탄총</a></li>
   			<li><a href="../shop/list?c=105&l=2">지정사수소총</a></li>
   			<li><a href="../shop/list?c=106&l=2">저격소총</a></li>
   			<li><a href="../shop/list?c=107&l=2">기타</a></li>
   		</ul>
   	</li>
   	<li><a href="../shop/list?c=200&l=1">탄약</a></li>
   	<li><a href="../shop/list?c=300&l=1">방어구</a></li>
   	<li><a href="../shop/list?c=400&l=1">회복제</a></li>
   </ul>
</div>