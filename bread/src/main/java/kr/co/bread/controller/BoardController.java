package kr.co.bread.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.bread.dao.BoardDAO;
import kr.co.bread.dto.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping("/index")
	public String index() {
		
		return "/index";
	}
	
	@RequestMapping("/board/list")
	public List<BoardDTO> list(Model model) {
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		
		List<BoardDTO> list = dao.list();
		System.out.println(list);
		model.addAttribute("board",list);
		return list;
	}
}
