package kr.co.mk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.mk.vo.MemberVo;

public class AdminInterceptor extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(false);
		MemberVo member = (MemberVo) session.getAttribute("member");
		if(member == null) {
			 response.sendRedirect("/mk/shop/signup");
			 return false;
			}
		if(member.getVerify() !=9) {
			response.sendRedirect("/mk/shop/main");
			 return false;
		 }
		 return true;
	}
	
	
	
	
//	@Override
//	 public boolean preHandle(HttpServletRequest req,HttpServletResponse res, Object obj) throws Exception {
//		 HttpSession session = req.getSession();
//		 MemberVo member = (MemberVo) session.getAttribute("member");
//		 System.out.println(member);
//		 if(member == null) {
//			 res.sendRedirect("/mk/admin/2");
//			 return false;
//			}
//		 
//		 if(member.getVerify() !=9) {
//			 res.sendRedirect("/mk/admin/2");
//			 return false;
//		 }
//		 		return true;
//	}
}