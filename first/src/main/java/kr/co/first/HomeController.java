package kr.co.first;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/main/index";	//브라우저에 나타낼 문서
	}
	
	//@RequestMapping(value="/first", method=RequestMethod.GET)
	@RequestMapping("/first")
	public String first() {
		return "/first";
	}
	
	@RequestMapping("/my")	//my, my.do 
	public ModelAndView my(ModelAndView mav) { // 요청,메소드명, view문서명은 동일하게!!
		
		String name = "홍길동";
		mav.addObject("name",name);
		mav.setViewName("/my");
		return mav;
	}
	
	@RequestMapping("/your.do") //do는 기본지원이라 위에 do 다 적용됨. do를 적으면 다 적어줘야함.
	public String your(Model model) {
		String name="배트맨";
		model.addAttribute("name",name);
		return "/your";
	}
	
	/*
	 * @RequestMapping(value = "/second", method = RequestMethod.GET) public String
	 * second() {
	 * 
	 * return "/second"; }
	 */
}
