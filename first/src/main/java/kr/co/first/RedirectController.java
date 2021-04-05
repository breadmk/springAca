package kr.co.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("/redirect/first")
	public String first() {
		
		return "/redirect/first";
	}
	
	@RequestMapping("/redirect/list")
	public String list(Model model) {
		
		model.addAttribute("name","홍길동이다");
		return "/redirect/list";
	}
	
	@RequestMapping("/redirect/test")
	public String test(Model model) {
		
		//return "/redirect/list"; // => view만 전당
		return "redirect:/redirect/list"; //요청을 다시 보낸다.
	}
}
