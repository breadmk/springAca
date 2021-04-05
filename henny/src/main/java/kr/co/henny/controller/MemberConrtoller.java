package kr.co.henny.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberConrtoller {

	@RequestMapping("/member/session_view")	//session 변수 만들기(login_ok)
	public String session_view(HttpSession session) {
		//session 변수 생성.
		session.setAttribute("userid", "강땡이다");
		
		return "/member/session_view";
	}
	
	@RequestMapping("/member/member_view")	//회원만 보는 문서를 요청
	public String member_view(HttpSession session) {
		
		if(session.getAttribute("userid") != null) {
			return "/member/member_view";
		}else {
			return "/member/login";
		}
	}
	
	@RequestMapping("member/login")
	public String login(HttpSession session) {
		//session.invalidate();
		return "member/login";
	}
	
}
