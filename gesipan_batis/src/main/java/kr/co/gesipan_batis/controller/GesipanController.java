package kr.co.gesipan_batis.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gesipan_batis.dao.Dao;
import kr.co.gesipan_batis.dto.Dto;

@Controller
public class GesipanController {

	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping("/")
	public String home() {
		
		return "/home";
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	

	@RequestMapping("/write_ok")
	public String write_ok(Dto dto) {
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.write_ok(dto);
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		Dao dao = sqlSession.getMapper(Dao.class);
		ArrayList<Dto> list = dao.list();
		model.addAttribute("list",list);
		return "/list";
	}
	
	@RequestMapping("/hit")
	public String hit(@RequestParam int id) {
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.hit(id);
		return "redirect:content?id="+id;
	}
	
	@RequestMapping("/content")
	public String content(@RequestParam int id, Model model) {
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.content(id);
		model.addAttribute("dto",dto);
		return "/content";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam int id, Model model) {
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.content(id);
		model.addAttribute("dto",dto);
		return "/update";
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(Dto dto,HttpServletRequest request) {
		Dao dao = sqlSession.getMapper(Dao.class);
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = dao.pwd(id);
		if(pwd.equals(dto.getPwd())){
			dao.update_ok(dto);
			return "redirect:/content?id="+dto.getId();
		}else {
			return "redirect:/update?id="+dto.getId()+"&chk=1";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Dao dao = sqlSession.getMapper(Dao.class);
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(id);
		return "redirect:/list";
	}
}
