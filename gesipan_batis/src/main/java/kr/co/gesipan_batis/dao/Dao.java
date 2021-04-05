package kr.co.gesipan_batis.dao;

import java.util.ArrayList;

import kr.co.gesipan_batis.dto.Dto;

public interface Dao {

	public void write_ok(Dto dto);
	public ArrayList<Dto> list();
	public void hit(int id);
	public Dto content(int id);
	public String pwd(int id);
	public void update_ok(Dto dto);
	public void delete(int id);
}
