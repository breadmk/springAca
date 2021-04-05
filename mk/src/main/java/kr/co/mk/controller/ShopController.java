package kr.co.mk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mk.dao.ShopDAO;
import kr.co.mk.vo.GoodsViewVo;
import kr.co.mk.vo.MemberVo;
import kr.co.mk.vo.ReplyListVo;
import kr.co.mk.vo.ReplyVo;

@Controller
@RequestMapping("/shop/**")
public class ShopController {
	
	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		ShopDAO dao =  sqlSession.getMapper(ShopDAO.class);
		
		int cateCode =  Integer.parseInt(request.getParameter("c"));
		int level = Integer.parseInt(request.getParameter("l"));
		
		int cateCodeRef = 0;
		if(level == 1) {
			cateCodeRef = cateCode;
			List<GoodsViewVo> list = dao.list_first(cateCode,cateCodeRef);
			model.addAttribute("list",list);
		}else {
			List<GoodsViewVo> list = dao.list_second(cateCode);
			model.addAttribute("list",list);
		}
		return "/shop/list";
	}
	
	@RequestMapping("/view")
	public String view(int no,Model model) {
		ShopDAO dao =  sqlSession.getMapper(ShopDAO.class);
		GoodsViewVo gv = dao.goodsView(no);
		model.addAttribute("gv",gv);
		
		return "/shop/view";
	}
	
//	@RequestMapping("/insert_reply")
//	public String replyInsert(HttpSession session,int gdsNum,String userId,String repCon) {
//		ShopDAO dao =  sqlSession.getMapper(ShopDAO.class);
//		System.out.println(userId);
//		
//		dao.replyInsert(gdsNum,userId,repCon);
//		return "redirect:/shop/view?no="+gdsNum;
//	}
}
