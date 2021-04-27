package kr.co.breadmk.service;

import java.util.List;

import kr.co.breadmk.vo.BoardVo;

public interface BoardService {
	
	// 1. 리스트
	public List<BoardVo> list() throws Exception;
	
	// 2. 글보기
	public BoardVo view() throws Exception;
	
	// 3. 글쓰기
	public int write() throws Exception;
	
	// 4. 글수정
	public int update() throws Exception;
	
	// 5. 글삭제
	public int board() throws Exception;
}
