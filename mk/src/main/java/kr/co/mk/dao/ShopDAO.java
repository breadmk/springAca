package kr.co.mk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.mk.vo.GoodsViewVo;
import kr.co.mk.vo.ReplyListVo;
import kr.co.mk.vo.ReplyVo;

public interface ShopDAO {
	
	//1차분류
	public List<GoodsViewVo> list_first(@Param("c") int cateCode, int cateCodeRef);
	//2차분류
	public List<GoodsViewVo> list_second(@Param("c") int cateCode);
	//단일 상품 조회
	public GoodsViewVo goodsView(int no);
	//상품 댓글 입력
	public void replyInsert(int gdsNum,String userId, String repCon);
	//상품 댓글 목록
	public List<ReplyListVo> replyList(int no);
}
