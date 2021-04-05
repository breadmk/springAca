package kr.co.kurly.dao;

import kr.co.kurly.dto.MemberDto;

public interface MemberDao {
	
	public void member_ok(MemberDto dto);
	public Integer id_chk(String userid);
	public Integer email_chk(String email);
	
	//로그인 하는 기능.
	public MemberDto get_member(String userid,String pwd);
	//userid 찾기
	public String get_userid(String name,String email);
	//pwd 찾기
	public String get_pwd(String name,String userid,String email);
}
