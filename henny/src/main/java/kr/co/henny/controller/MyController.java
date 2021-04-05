package kr.co.henny.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.henny.dao.Dao;
import kr.co.henny.dto.Dto;

@Controller
public class MyController {
	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping("/")
	public String home() {
		
		return "redirect:/list";
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(Dto dto) {
		
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.write_ok(dto);
			/*
		String name = dto.getName();
		String title = dto.getTitle();
		for(int i=1; i<=2578; i++) {
			dto.setName(name+i);
			dto.setTitle(title+i);
			dao.write_ok(dto);
		}
		*/
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request) {
		Dao dao = sqlSession.getMapper(Dao.class);
		
//		list 메소드에 보낼 index값을 구해야 된다.
//		사용자가 원하는 페이지에 따라 index 값은 바뀐다.
//		1페이지는 =>0~9 , 2페이지는 => 10~19
		int page,index; //index는 넘길값
		if(request.getParameter("page")==null) {
			index=0;
			page=1;
		}else {
			page=Integer.parseInt(request.getParameter("page"));
			index = (page-1)*10;
		}
//		pstart,pend 구하기 => 사용자가 클릭하는 부분
		int pstart = page/10;
		if(page%10==0)
			pstart=pstart-1;
		pstart=(pstart*10)+1;
		int pend = pstart+9;
//		view에 사용자가 원하는 페이지를 클릭할 수 있게
//		1페이지 혹은 10페이지 단위의 이동을 위한 것들
		
		// 총 페이지수를 구해서 전달 => 마지막페이지

		int chong = dao.count();
//		int page_cnt = dao.count()/10+1; //페이지의 갯수가 나옴. (/10) int기 때문에 +1
		int page_cnt = chong/10;
		
		if(chong%10 != 0)
			page_cnt++;
		
		if(pend > page_cnt)
			pend=page_cnt;
		ArrayList<Dto> list = dao.list(index);
		model.addAttribute("list", list);
		model.addAttribute("pstart", pstart);
		model.addAttribute("page", page);
		model.addAttribute("pend", pend);
		model.addAttribute("page_cnt", page_cnt);
		return "/list";
	}
	
	@RequestMapping("readnum")
	public String readnum(@RequestParam int id) {
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.readnum(id);
		return "redirect:/content?id="+id;
	}
	
	@RequestMapping("/content")
	public String content(Model model,@RequestParam int id) {
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.content(id);
		model.addAttribute("dto",dto);
		return "/content";
	}
	
	@RequestMapping("/update")
	public String update(Model model,@RequestParam int id) {
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.update(id);
		model.addAttribute("dto",dto);
		return "/update";
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(Dto dto,@RequestParam int id) {
		
		Dao dao = sqlSession.getMapper(Dao.class);
		String pwd = dao.pwd(dto.getId());
		System.out.println(pwd);
		if(pwd.equals(dto.getPwd())){
			dao.update_ok(dto);
			return "redirect:/content?id="+dto.getId();
		}else {
			return "redirect:/update?id="+dto.getId()+"&chk=1";
		}
	}
	
//	@RequestMapping("/delete")
//	public String delete(HttpServletRequest request) {
//		Dao dao = sqlSession.getMapper(Dao.class);
//		String pwd2 = request.getParameter("pwd");
//		int id = Integer.parseInt(request.getParameter("id"));
//		String pwd = dao.pwd(id);
//		if(pwd.equals(pwd2)){
//			dao.delete(id);
//			return "redirect:/list";
//		}else {
//			return "redirect:/content?id="+id+"&chk=1";
//		}
//	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Dao dao = sqlSession.getMapper(Dao.class);
		String pwd = request.getParameter("pwd");
		int id = Integer.parseInt(request.getParameter("id"));
		Integer num = dao.pwd_check(id, pwd);
		System.out.println(num);
		if(num==1) {
			dao.delete((id));
			return "redirect:/list";
		}else {
			return "redirect:/content?id="+id+"&chk=1";
		}
	}
}
