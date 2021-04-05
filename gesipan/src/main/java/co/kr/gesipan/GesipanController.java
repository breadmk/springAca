package co.kr.gesipan;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GesipanController {
	
	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(GesipanDTO gdto) throws ClassNotFoundException, SQLException {
		
		gesipanDAO dao = new gesipanDAO();
		dao.write_ok(gdto);
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws ClassNotFoundException, SQLException {
		
		gesipanDAO dao = new gesipanDAO();
		model.addAttribute("list",dao.selectAll());
		return "/list";
	}
	
	@RequestMapping("/content")
	public String list(Model model,@RequestParam int id) throws ClassNotFoundException, SQLException {
		
		gesipanDAO dao = new gesipanDAO();
		model.addAttribute("gdto",dao.select(id));
		return "/content";
	}
	
	@RequestMapping("/update")
	public String update(Model model,@RequestParam int id) throws ClassNotFoundException, SQLException {
		gesipanDAO dao = new gesipanDAO();
		model.addAttribute("gdto",dao.select(id));
		return "/update";
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(Model model,GesipanDTO gdto) throws ClassNotFoundException, SQLException {
		gesipanDAO dao = new gesipanDAO();
		String pwd = dao.pwd(gdto.getId());
		if(pwd.equals(gdto.getPwd())) {
			dao.update_ok(gdto);
			return "redirect:/content?id="+gdto.getId();
		}else {
			return "redirect:/update?id="+gdto.getId()+"&chk=1";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int id) throws ClassNotFoundException, SQLException {
		gesipanDAO dao = new gesipanDAO();
		dao.delete(id);
		return "redirect:/list";
	}
	@RequestMapping("/hit")
	public String hit(@RequestParam int id) throws ClassNotFoundException, SQLException {
		gesipanDAO dao = new gesipanDAO();
		dao.hit(id);
		return "redirect:/content?id="+id;
	}
}
