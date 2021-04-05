package kr.co.mk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mk.dao.ShopDAO;
import kr.co.mk.vo.MemberVo;
import kr.co.mk.vo.ReplyListVo;
import kr.co.mk.vo.ReplyVo;

@Controller
public class ReplyController {
	
	@Autowired
	public SqlSession sqlSession;
	
	@ResponseBody
    @RequestMapping(value="/shop/view/view_reply",method = RequestMethod.GET)
    public List<ReplyListVo> list(int no){
		ShopDAO dao =  sqlSession.getMapper(ShopDAO.class);
		List<ReplyListVo> list = dao.replyList(no);
		
		return list;		
		
	}
	@ResponseBody
	@RequestMapping(value = "/shop/view/insert_reply", method =RequestMethod.POST)
	public void insertReply(int gdsNum,String userId,String repCon,HttpSession session) {
		ShopDAO dao =  sqlSession.getMapper(ShopDAO.class);
		dao.replyInsert(gdsNum, userId, repCon);
		
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
