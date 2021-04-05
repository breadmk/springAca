package kr.co.kurly.dao;

import java.util.List;

import kr.co.kurly.dto.DeaDto;
import kr.co.kurly.dto.JungDto;
import kr.co.kurly.dto.ProductDto;

public interface ProductDao {
	
	public List<DeaDto> get_dea();
	public List<JungDto> get_jung(String deacode);
	public Integer get_MaxPcode(String pcode);
	public void pwrite_ok(ProductDto pdto);
	public List<ProductDto> get_pro_list(String pcode);
}
