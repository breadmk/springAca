// default.jsp에서 고객센터
function view()
{
  document.getElementById("inner").style.visibility="visible";
}
function hide()
{
  document.getElementById("inner").style.visibility="hidden";
}
function first_hide()
{
	//document.getElementById("first").style.display="none";
	$("#first").slideUp(1000);
}
// member.jsp
function userid_dupcheck(form)
{
	   var chk=new XMLHttpRequest();
	   chk.open("get","userid_dupcheck?userid="+form.userid.value);
	   chk.send();
	   chk.onreadystatechange=function()
	   {
		   if(chk.readyState==4) // 동작이 완료되면
		   {
		         if(chk.responseText==0) // 레코드가 없다 => 사용가능
		         {
		        	 alert("아이디 사용가능"); 
		        	 document.getElementById("uid").innerText="아이디 중복 확인 ";
		        	 document.getElementById("uid").style.color="blue";
		         }
		         else
		         {
		        	 alert("아이디 사용 불가능")
		        	 document.getElementById("uid").innerText="아이디 중복 확인 ";
		        	 document.getElementById("uid").style.color="red";
		         }
		   }	   
	   }
}

function email_dupcheck(form)
{
	   var chk=new XMLHttpRequest();
	   chk.open("get","email_dupcheck?email="+form.email.value);
	   chk.send();
	   chk.onreadystatechange=function()
	   {
		   if(chk.readyState==4)
		   {
			   if(chk.responseText==0)
		         {
		        	 alert("이메일 사용가능"); 
		        	 document.getElementById("ema").innerText="이메일 중복 확인 ";
		        	 document.getElementById("ema").style.color="blue";
		         }
		         else
		         {
		        	 alert("이메일 사용 불가능")
		        	 document.getElementById("ema").innerText="이메일 중복 확인 ";
		        	 document.getElementById("ema").style.color="red";
		         } 
		   }	   
	   }
}

//컨트롤러 
/*@RequestMapping("/member/userid_dupcheck")
public void userid(HttpServletRequest request, PrintWriter out)
{
	String userid=request.getParameter("userid"); // 사용자가 입력한 사용자아이디
	MemberDao mdao=sqlSession.getMapper(MemberDao.class);
	int n=mdao.get_userid_chk(userid);
	out.print(n);
}

@RequestMapping("/member/email_dupcheck")
public void email(HttpServletRequest request, PrintWriter out)
{
	String email=request.getParameter("email");
	MemberDao mdao=sqlSession.getMapper(MemberDao.class);
	int n=mdao.get_email_chk(email);
	out.print(n);
}*/
