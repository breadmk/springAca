package kr.co.henny.dao;

import java.util.ArrayList;

import kr.co.henny.dto.Dto;
import kr.co.henny.dto.MemberDto;

public interface Dao {
	//메소드 정의
	public void write_ok(Dto dto);
//	public ArrayList<Dto> list();
	public ArrayList<Dto> list(int index);
	public Dto content(int id);
	public void readnum(int id);
	public Dto update(int id);
	public void update_ok(Dto dto);
	public String pwd(int id);
	public void delete(int id);
	public Integer pwd_check(int id,String pwd);
	public Integer count(); //총 레코드의 수
	
	// 로그인 부분
	public MemberDto login_ok(MemberDto mdto);  //아이디 비번을 이용해서 해당되는 레코드를 반환.
	
	//검색 부분
	public ArrayList<Dto> slist(String sear, String sword);
}
