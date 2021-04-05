package kr.co.henny.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class UploadController {
	
	@RequestMapping("/upload/write")
	public String write() {
		
		return "/upload/write";
	}
	
	@RequestMapping("/upload/write_ok")
	public String write_ok(HttpServletRequest request) throws IOException {
		String path=request.getRealPath("resources/img");
		int max = 1024*1024*10;
		MultipartRequest multi = new MultipartRequest(request, path,max,"utf-8", new DefaultFileRenamePolicy());
		multi.getParameter("title");
		multi.getParameter("fname");
		multi.getOriginalFileName("fname");
		
		return "redirect:/upload/list";
	}
	
	@RequestMapping("/upload/list")
	public String list() {
		
		return "/upload/list";
	}
}
