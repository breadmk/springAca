package kr.co.board;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardDto bdto) throws SQLException, ClassNotFoundException {
		//폼에 입력된 값을 board테이블에 저장
		
		BoardDao bdao = new BoardDao();
		bdao.write_ok(bdto);
		return "redirect:/list"; //list로 이동.
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws SQLException, ClassNotFoundException {
	
		BoardDao bdao = new BoardDao();
		model.addAttribute("list",bdao.selectAll());
		return "/list"; //list로 이동.
	}
	
	@RequestMapping("/content")
	public String content(Model model,@RequestParam int id) throws ClassNotFoundException, SQLException {
		
		BoardDao bdao = new BoardDao();
		model.addAttribute("bdao",bdao.select(id));
		model.addAttribute("rn","\r\n");
		return "/content";
		
	}
	
	@RequestMapping("/update")
	public String update(Model model,@RequestParam int id) throws SQLException, ClassNotFoundException {
		
		BoardDao bdao = new BoardDao();
		model.addAttribute("bdao",bdao.select(id));
		return "/update";
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(BoardDto bdto) throws Exception {
		BoardDao bdao = new BoardDao();
		String pwd = bdao.pwd(bdto.getId());
		if(pwd.equals(bdto.getPwd())) {
			bdao.update_ok(bdto);
			return "redirect:/content?id="+bdto.getId();
		}else {
			return "redirect:/update?id="+bdto.getId()+"&chk=1";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		BoardDao bdao = new BoardDao();
		String pwd = request.getParameter("pwd");
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd1 = bdao.pwd(id);
		if(pwd.equals(pwd1)) {
			bdao.delete(id);
			return "redirect:/list"; 
		}else {
			return "redirect:/content?id="+id+"&chk=1";
		}
	}
}







