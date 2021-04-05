package kr.co.mk.dao;

import kr.co.mk.vo.MemberVo;

public interface MemberDAO {
	
	public void signUp(MemberVo vo);
	public Integer login(String userId, String userPass);
	public MemberVo login_ok(MemberVo vo);
}
