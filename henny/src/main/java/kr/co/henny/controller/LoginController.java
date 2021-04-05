package kr.co.henny.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.henny.dao.Dao;
import kr.co.henny.dto.MemberDto;

@Controller
public class LoginController {
	
	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping("/main/index")
	public String index() {
		
		return "/main/index";
	}
	@RequestMapping("/main/login")
	public String login(Model model, HttpServletRequest request) {
		
		model.addAttribute("chk",request.getParameter("chk"));
		return "/main/login";
	}
	@RequestMapping("/main/login_ok")
	public String login_ok(MemberDto mdto,HttpSession session) { //사용자 입력이 담김
		Dao dao = sqlSession.getMapper(Dao.class);
		MemberDto mdto2 = dao.login_ok(mdto); //select 결과가 담김
	
		if(mdto2==null) {
			return "redirect:/main/login?chk=1";
		}else {
			session.setAttribute("userid", mdto2.getUserid());
			session.setAttribute("name", mdto2.getName());
			
			return "redirect:/main/index";
		}
	}
		@RequestMapping("/main/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/main/index";
	}
		@RequestMapping("/main/mypage")
		public String mypage(HttpSession session) {
			if(session.getAttribute("userid")==null) {
				return "redirect:/main/login?chk=2";
			}else {
				return "/main/mypage";
			}
		}
}
