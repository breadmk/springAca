package kr.co.henny.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {
	
	@RequestMapping("/ajax")
	public String ajax() {
		
		return "/ajax";
	}	
	
	@RequestMapping("/ajax_cal")
	public void ajax_cal(HttpServletRequest request,PrintWriter out) {
		
		int kor=Integer.parseInt(request.getParameter("kor"));
		int eng=Integer.parseInt(request.getParameter("eng"));
		int tot = kor+eng;
		System.out.println(tot);
		out.print(tot);
	}
	
	@RequestMapping("/sung")
	public String sung() {
		
		return "/sung";
	}
		
	@RequestMapping("/sung_cal")
	public void sung_cal(HttpServletRequest request,PrintWriter out) {
		
		int jung = Integer.parseInt(request.getParameter("jung"));
		int gimal = Integer.parseInt(request.getParameter("gimal"));
		int chul = Integer.parseInt(request.getParameter("chul"));
		int report = Integer.parseInt(request.getParameter("report"));
		int tot = jung+gimal+chul+report;
		System.out.println(tot);
		out.print(tot);
	}

}
