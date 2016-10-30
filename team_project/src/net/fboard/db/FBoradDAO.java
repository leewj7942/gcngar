package net.fboard.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FBoradDAO {
	private Connection getConnection() throws Exception {
		Connection con = null;
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();
		return con;
	}
	
	public void insertBoard(FBoardBean fb) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		try {
			// 1,2 디비연결 메서드호출
			con = getConnection();
			// num 구하기
			sql = "select max(num) from download_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 첫번째 행이동
				// 데이터 있으면 true
				num = rs.getInt(1) + 1; // 최근글번호(최대값num)+1
			} else {
				// 데이터 없으면 false
				num = 1; // 글번호 1번부터 시작
			}
			// 3 sql insert
			sql = "insert into board(num,name,pass,subject,content,readcount,ip,date,re_ref,re_lev,re_seq,file) values(?,?,?,?,?,?,?,now(),?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num); // num구한값
			pstmt.setString(2, fb.getName()); // name
			pstmt.setString(3, fb.getPass()); // pass
			pstmt.setString(4, fb.getSubject()); // subject
			pstmt.setString(5, fb.getContent()); // content
			pstmt.setInt(6, 0); // readcount 조회수 0
			pstmt.setString(7, fb.getIp()); // ip
			// date now()
			pstmt.setInt(8, num); // 그룹번호 re_ref == 기준 num 같게 입력
			pstmt.setInt(9, 0); // re_lev 0
			pstmt.setInt(10, 0); // re_seq 0
			pstmt.setString(11, fb.getFile()); // file
			// 4 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(rs!=null)try{rs.close();}catch(SQLException e){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
			if(con!=null)try{con.close();}catch(SQLException e){}
		}
	}
}
