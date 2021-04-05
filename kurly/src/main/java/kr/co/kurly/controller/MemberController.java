package kr.co.kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kurly.dao.MemberDao;
import kr.co.kurly.dto.MemberDto;
import kr.co.kurly.etc.Mail_Send;

@Controller
public class MemberController {

	@Autowired
	public SqlSession sqlSession;

	@RequestMapping("/")
	public String home() {
		return "redirect:/main/index";
	}

	@RequestMapping("/main/test")
	public String test() {

		return "/main/test";
	}

	@RequestMapping("/main/index")
	public String index() {

		return "/main/index";
	}

	// 회원가입 문서
	@RequestMapping("/member/member")
	public String member() {

		return "/member/member";
	}


	// 회원가입 form
	@RequestMapping("member/member_ok")
	public String member_ok(MemberDto dto) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		dao.member_ok(dto);

		return "redirect:/main/index";
	}

	@RequestMapping("member/member/id_ok")
	public void id_chk(String userid, HttpServletResponse response,PrintWriter out) throws IOException {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int count = dao.id_chk(userid);
		out = response.getWriter();
		out.print(count);
		out.flush();
		out.close();
	}

	@RequestMapping("member/member/email_chk")
	public void email_chk(String email, HttpServletResponse response,PrintWriter out) throws IOException {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int count1 = dao.email_chk(email);
		System.out.println(count1);
		out = response.getWriter();
		out.print(count1);
		out.flush();
		out.close();
	}
// login관련 ------------------------------
	@RequestMapping("/login/login")
	public String login() {
		
		return "/login/login";
	}
	
	@RequestMapping("/login/login_ok")
	public String login_ok(HttpServletRequest request,HttpSession session) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
			
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		MemberDto mdto = dao.get_member(userid,pwd);
		if(mdto != null) {
			session.setAttribute("userid",mdto.getUserid());
			session.setAttribute("name",mdto.getName());
			return "/main/index"; //동작이 있다면 redirect:/사용
		}else { //아이디 혹은 비밀번호가 틀림.
			return "redirect:/login/login?chk=1";
		}
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/main/index";
	}
	
	//아이디 찾기
	@RequestMapping("/login/userid_search")
	public String userid_search() {
		
		return "/login/userid_search";
	}

	@RequestMapping("/login/userid_view")
	public String userid_search_ok(HttpServletRequest request,Model model) {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		//해당 아이디를 찾기
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		String userid = dao.get_userid(name, email);
		
		if(userid==null) {
			model.addAttribute("chk",2);
		}else {
			//userid 의 앞자리 3자 + 뒤에 길이만큼 ****
			int n = userid.length()-3;
			String star = "";
			for(int i=1; i<=n; i++)
				star = star +"8";
			userid = userid.substring(0,3)+"***";
			model.addAttribute("chk",1);
			model.addAttribute("userid",userid);
		}
		return "/login/userid_view";
	}
	
//	비밀번호찾기
	@RequestMapping("/login/pwd_search")
	public String pwd_search() {
		
		return "/login/pwd_search";
	}
	
	@RequestMapping("/login/pwd_view")
	public String pwd_view(MemberDto dto,Model model) throws Exception {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		String pwd = dao.get_pwd(dto.getName(),dto.getUserid(),dto.getEmail());
		
		if(pwd==null) {
			model.addAttribute("chk",2);
		}else {
			 Mail_Send ms = Mail_Send.getInstance();
			 String email = dto.getEmail();
			 String subject = "요청하신 고객님의 이메을을 보내드립니다.";
			 String body = "당신의 비밀번호는 "+ pwd + "입니다.";
			 ms.setEmail(email, subject, body);
			model.addAttribute("chk",1);
			model.addAttribute("pwd",pwd);
		}
		return "/login/pwd_view";
	}
	
}
