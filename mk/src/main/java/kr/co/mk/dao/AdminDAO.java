package kr.co.mk.dao;

import java.util.List;

import kr.co.mk.vo.CategoryVo;
import kr.co.mk.vo.GoodsViewVo;
import kr.co.mk.vo.GoodsVo;
import net.webjjang.util.PageObject;

public interface AdminDAO {
	
	public List<CategoryVo> category();
	public void register(GoodsVo vo);
//	public List<GoodsVo> goodsList(PageObject pageObject);
	public List<GoodsViewVo> goodsList(PageObject pageObject);
	public Integer getRow(PageObject pageObject);
	public GoodsVo view(int no);
	public GoodsViewVo goodsView(int no);
	public void update_ok(GoodsVo vo);
	public void delete(int no);
	
}
