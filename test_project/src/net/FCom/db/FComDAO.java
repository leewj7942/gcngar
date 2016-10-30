package net.FCom.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class FComDAO {

	private Connection getConnection() throws Exception {
		Connection con = null;
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();
		return con;
	}

	public void insertCom(FComBean cb) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;

		try {
			con = getConnection();
			sql = "select max(num) from com";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 첫번째 행이동
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}

			sql = "insert into com(num,name,pass,content) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, cb.getName());
			pstmt.setString(3, cb.getPass());
			pstmt.setString(4, cb.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException e){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
			if(con!=null)try{con.close();}catch(SQLException e){}
		}
	}
}
