package com.javalec.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javalec.mysite.vo.UsersVO;

public class UsersDAO {
	private Connection getConnection() {
		Connection conn = null;

		try {

//			InitialContext ic = new InitialContext();
//			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/Oracle11g");
//
//			conn = ds.getConnection();

			// 밑에꺼 복사안할려고 util만들거나 connection따로 만드는 이유
			// 1. JDBC 드라이버 로딩(JDBC 클래스로딩)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}


	public void insert(UsersVO vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			//
			String sql = "INSERT INTO USERS" + " VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(3, vo.getRole());

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" insert_error:" + e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
		
	

	public void update(UsersVO vo) {
		// TODO Auto-generated method stub
		
	}

	public UsersVO selectOne(UsersVO vo) {
		return vo;
		// TODO Auto-generated method stub
		
	}

}
