package kr.co.breadmk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.breadmk.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	//@Setter - lombok 사용, @Autowired - Spring 사용
	// 대신 사용 가능한 어노테이션 : @Autowired - Spring, @Inject - java
	// DI 적용 시 BoardService 타입 : 1. BoardService 인터페이스  / 2. BoardServiceImpl 클래스
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	// 실행할 메서드 - 리스트 
	// 매핑 - get 방식. list.do
	@GetMapping("/list.do")
	public String list() throws Exception {
		log.info("list() - 게시판 리스트-----------------");
		service.list();
		return "board/list";
	}
	
	@GetMapping("/view.do")
	public String view() {
		log.info("view() - 게시판 글 보기-----------------");
		return "board/view";
	}
	
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("writeForm() - 게시판 글 쓰기 폼-----------------");
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public String write() {
		log.info("write() - 게시판 글 쓰기 처리-----------------");
		return "redirect:list.do";
	}
	
	// 글 수정 폼
	@GetMapping("/update.do")
	public String updateForm() {
		log.info("updateForm() - 게시판 글 수정 폼-----------------");
		return "board/update";
	}
	
	// 글 수정 처리
	@PostMapping("/update.do")
	public String update() {
		log.info("update() - 게시판 글 수정 처리-----------------");
		return "redirect:view.do";
	}
	
	// 글 삭제 처리
	@GetMapping("/delete.do")
	public String delete() {
		log.info("delete() - 게시판 글 삭제 처리-----------------");
		return "redirect:list.do";
	}
}
