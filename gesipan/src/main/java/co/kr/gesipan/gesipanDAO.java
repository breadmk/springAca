package co.kr.gesipan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class gesipanDAO {

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	//Connection
	public gesipanDAO() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String db="jdbc:mysql://localhost:3306/spring?useSSL=false"; 
		String userid="root";
	    String pw="1234";
	    conn = DriverManager.getConnection(db, userid, pw);
	}
	
	public void write_ok(GesipanDTO gdto) throws SQLException {
		sql = "insert into gesipan(title,content,pwd,sung,kind,email,email2,writeday) values(?,?,?,?,?,?,?,now())";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gdto.getTitle());
		pstmt.setString(2, gdto.getContent());
		pstmt.setString(3, gdto.getPwd());
		pstmt.setString(4, gdto.getSung());
		pstmt.setString(5, gdto.getKind());
		pstmt.setString(6, gdto.getEmail());
		pstmt.setString(7, gdto.getEmail2());
		pstmt.executeUpdate();
		
	}
	
	public ArrayList<GesipanDTO> selectAll() throws SQLException {
		
		sql = "select * from gesipan order by id desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<GesipanDTO> list = new ArrayList<GesipanDTO>();
		while(rs.next()) {
			GesipanDTO gdto = new GesipanDTO();
			gdto.setId(rs.getInt("id"));
			gdto.setTitle(rs.getString("title"));
			gdto.setHit(rs.getInt("hit"));
			gdto.setWriteday(rs.getString("writeday"));
			gdto.setSung(rs.getString("sung"));
			list.add(gdto);
		}
		return list;
	}
	
	public GesipanDTO select(int id) throws SQLException {
		sql = "select * from gesipan where id="+id;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		GesipanDTO gdto = new GesipanDTO();
		gdto.setId(rs.getInt("id"));
		gdto.setTitle(rs.getString("title"));
		gdto.setContent(rs.getString("content"));
		gdto.setWriteday(rs.getString("writeday"));
		gdto.setHit(rs.getInt("hit"));
		gdto.setSung(rs.getString("sung"));
		gdto.setKind(rs.getString("kind"));
		gdto.setEmail(rs.getString("email"));
		gdto.setEmail2(rs.getString("email2"));
		return gdto;
	}
	
	public void update_ok(GesipanDTO gdto) throws SQLException {
		
		sql = "update gesipan set title=?,content=?,sung=?,kind=?,email=?,email2=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gdto.getTitle());
		pstmt.setString(2, gdto.getContent());
		pstmt.setString(3, gdto.getSung());
		pstmt.setString(4, gdto.getKind());
		pstmt.setString(5, gdto.getEmail());
		pstmt.setString(6, gdto.getEmail2());
		pstmt.setInt(7, gdto.getId());
		pstmt.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		sql = "delete from gesipan where id="+id;
		stmt= conn.createStatement();
		stmt.executeUpdate(sql);
	}
	
	public String pwd(int id) throws SQLException {
		sql = "select pwd from gesipan where id="+id;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		String pwd = rs.getString("pwd");
		return pwd;
	}
	
	public void hit(int id) throws SQLException {
		sql = "update gesipan set hit = hit+1 where id="+id;
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
	}
}

















