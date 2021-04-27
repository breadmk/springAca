package kr.co.breadmk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.breadmk.repository.BoardRepository;
import kr.co.breadmk.vo.BoardVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{
	
	//@Setter - lombok 사용, @Autowired - Spring 사용
	// 대신 사용 가능한 어노테이션 : @Autowired - Spring, @Inject - java
	@Setter(onMethod_ = @Autowired)
	private BoardRepository repository;

	@Override
	public List<BoardVo> list() throws Exception {

		log.info("list() - 게시판 리스트 서비스 실행 ****** ");
		repository.getTotalRow();
		repository.list();
		return null;
	}

	@Override
	public BoardVo view() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int write() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
