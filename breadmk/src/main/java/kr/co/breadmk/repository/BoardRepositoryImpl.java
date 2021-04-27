package kr.co.breadmk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.breadmk.vo.BoardVo;
import lombok.extern.log4j.Log4j;

//자동 생성하게 하는 어노테이션 @Controller / @Service / @Repository / @Component  / @RestController / @Advice
///web이랑 관련된 설정은 WEB-INF/spring/appServlet/servlet-context.xml 설정이 되어 있어야 한다. component-scan
@Repository
@Log4j
public class BoardRepositoryImpl implements BoardRepository{

	@Override
	public List<BoardVo> list() throws Exception {
		log.info("list()- 게시판 리스트 데이터 가져오기 ++++++ ");
		return null;
	}

	@Override
	public Long getTotalRow() throws Exception {
		log.info("getTotalRow()- 게시판 전체  갯수 가져오기 ++++++ ");
		return null;
	}

	@Override
	public BoardVo view() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int increase() throws Exception {
		// TODO Auto-generated method stub
		return 0;
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
