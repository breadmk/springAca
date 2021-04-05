package kr.co.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardDao {
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	//Connection
	public BoardDao() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String db="jdbc:mysql://localhost:3306/spring?useSSL=false"; 
		String userid="root";
	    String pw="1234";
	    conn = DriverManager.getConnection(db, userid, pw);
	}
	
	
	public void write_ok(BoardDto bdto) throws SQLException {  // form 입력값 => 테이블에 저장.
			
		//쿼리작성
		sql = "insert into board(name,title,content,pwd,writeday) ";
		sql = sql + " values(?,?,?,?,now())";
		//심부름꾼
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bdto.getName());
		pstmt.setString(2, bdto.getTitle());
		pstmt.setString(3, bdto.getContent());
		pstmt.setString(4, bdto.getPwd());
		//실행
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}
	
	public ArrayList<BoardDto> selectAll() throws SQLException {
		
		sql = "select * from board order by id desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		while(rs.next()) {
			BoardDto bdto = new BoardDto();
			bdto.setId(rs.getInt("id"));
			bdto.setName(rs.getString("name"));
			bdto.setContent(rs.getString("content"));
			bdto.setTitle(rs.getString("title"));
			bdto.setReadnum(rs.getInt("readnum"));
			bdto.setWriteday(rs.getString("writeday"));
			list.add(bdto);
		}
		return list;
	}
	
	public BoardDto select(int id) throws SQLException {
		sql = "select * from board where id="+id;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		BoardDto bdto = new BoardDto();
		bdto.setId(rs.getInt("id"));
		bdto.setName(rs.getString("name"));
		bdto.setTitle(rs.getString("title"));
		bdto.setContent(rs.getString("content"));
		bdto.setWriteday(rs.getString("writeday"));
		bdto.setReadnum(rs.getInt("readnum"));
		return bdto;
	}
	
	public void update_ok(BoardDto bdto) throws SQLException {
		
		sql = "update board set name=?, title=?,content=?,pwd=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bdto.getName());
		pstmt.setString(2, bdto.getTitle());
		pstmt.setString(3, bdto.getContent());
		pstmt.setString(4, bdto.getPwd());
		pstmt.setInt(5, bdto.getId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	public void delete(int id) throws SQLException {
		sql = "delete from board where id="+id;
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
	
	public String pwd(int id) throws SQLException {
		sql = "select pwd from board where id="+id;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		String pwd = rs.getString("pwd");
		return pwd;
	}
}
















