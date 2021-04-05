  function view()
  {
	  document.getElementById("inner").style.visibility="visible";
  }
  function hide()
  {
	  document.getElementById("inner").style.visibility="hidden";
  }
  function first_hide(){
	  //document.getElementById("first").style.display="none";
	  $("#first").slideUp(1000);
  }

//전체카테고리 부분
  function view_main()
  {
  	document.getElementById("main_submenu").style.visibility="visible";
  }
  function hide_main()
  {
  	document.getElementById("main_submenu").style.visibility="hidden";
  }

  function view_inner(n)
  {
      document.getElementsByClassName("inner_menu")[n].style.visibility="visible";	
  }
  function hide_inner(n)
  {
      document.getElementsByClassName("inner_menu")[n].style.visibility="hidden";	
  }
  
  function id_chk() {
		$.ajax({
			url:"/kurly/member/member/id_ok",
			type:"post",
			dataType: "text",
			data :{"userid":$("#userid").val()},
			success : function(data){
				console.log(data);
				if(data==1){
					$("#uid").text("아이디 중복 확인하세요");
					$("#uid").css("color","red");
					$("#userid_check").val(0);
					alert("중복된 아이디입니다.");
				}else{
					$("#uid").text("아이디 사용 가능");
					$("#uid").css("color","blue");
					$("#userid_check").val(1);
					alert("사용가능한 아이디입니다.");
				}
			}
		})
	}
  
	function email_chk(){
		$.ajax({
			url:"/kurly/member/member/email_chk",
			type:"post",
			dataType:"text",
			data:{"email":$("#email").val()},
			success:function(data){
				console.log(data);
				if(data==1){
					$("#uemail").text("이메일 주소를 확인하세요");
					$("#uemail").css("color","red");
					$("#email_check").val(0);
					alert("중복된 이메일입니다.");
				}else{
					$("#uemail").text("사용가능한 이메일입니다.");
					$("#uemail").css("color","blue");
					$("#email_check").val(1);
					alert("사용가능한 이메일입니다.");
				}
			}
		})
	}
	
	