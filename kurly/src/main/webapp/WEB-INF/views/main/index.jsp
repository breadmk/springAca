<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div id="fifth">
		<img src="../resources/img/5f.jpg">
	</div>
	<div id="sixth">
		<img src="../resources/img/6f.png">
	</div>
	<div id="seventh">
		<img src="../resources/img/7f.png">
	</div>
<style>
	#mk{
	position: absolute;
	left:1280px;
	top:300px;
	width:100px;
	height:100px;
	background: red;
	}
</style>
<script>
 function change(){
	 var mk = document.documentElement.scrollTop;
	 document.getElementById("aa").innerText = mk+"px";
	 if(mk>=160){
		 document.getElementById("mk").style.position="fixed";
		 document.getElementById("mk").style.top="140px"; //top300맞춰주기
	 }else{
		 document.getElementById("mk").style.position="absolute";
		 document.getElementById("mk").style.top="300px"; //top300맞춰주기
	 }
 }
 function change2()
{
	 var k = window.innerWidth; //(window는 생략가능)
	 k=k-1100; // 웹페이지 공간을 제외한 브라우저의 가로크기
	 if(k>0) //mk의 left의 값을 변경
	 {
		k=k/2;
		document.getElementById("mk").style.left=(k+1100)+"px";
	 }
 }
 window.onresize=change2;
 window.onscroll=change;
</script>


<div id="mk">
	따라다니기<span id="aa"></span>
</div>