package kr.co.mk.controller;


import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mk.dao.MemberDAO;
import kr.co.mk.vo.MemberVo;

@Controller
@RequestMapping("/shop")
public class MemberController {
	
//	private final String MODULE  = "shop";
//	@Qualifier("MemberDAOImpl")
//	private MemberDAO dao;
//	
//	@Autowired
//	BCryptPasswordEncoder passEncoder;
//	
	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping("/main")
	public String main_one() {
		
		return "/shop/main";
	}
	
	@RequestMapping("/")
	public String main() {
		
		return "/shop/main";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		
		return "/shop/signup";
	}
	
	@RequestMapping("/signup_ok")
	public String signup_ok(MemberVo vo) {
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		dao.signUp(vo);
		return "/shop/main";
	}
	@RequestMapping("/login")
	public String login() {
		
		return "/shop/login";
	}
	
	@RequestMapping("/login_ok")
	public String login(MemberVo vo, HttpSession session) {
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		MemberVo vo2 = dao.login_ok(vo);
		
		if(vo2 == null) {
			return "redirect:/shop/login?chk=1";
		}else {
			session.setAttribute("member", vo2);
			session.setAttribute("userName", vo2.getUserName());
			session.setAttribute("verify", vo2.getVerify());
			session.setAttribute("member.verify", vo2.getVerify());
			return "redirect:/shop/main";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/shop/main";
	}
}
