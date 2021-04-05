package kr.co.henny.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.henny.dao.Dao;

@Controller
public class SearchController {
	
	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping("/search/list")
	public String list(Model model,HttpServletRequest request) {
		Dao dao = sqlSession.getMapper(Dao.class);
		
		//검색필드와 검색단어 가지고 온다.
		String sear;
		String sword;
		if(request.getParameter("sear")==null) {
			sear="title";
			sword="";
		}else {
			sear=request.getParameter("sear");
			sword = request.getParameter("sword");
		}
		
//		String sear = request.getParameter("sear"); //검색할 필드
//		String sword = request.getParameter("sword"); //검색 단어
		model.addAttribute("list",dao.slist(sear,sword));
		model.addAttribute("sear",sear);
		model.addAttribute("sword",sword);
		return "/search/list";
	}
}
