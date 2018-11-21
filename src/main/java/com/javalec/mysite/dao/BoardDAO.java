package com.javalec.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javalec.mysite.vo.BoardVO;



public class BoardDAO {
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

	public BoardVO selectOne(BoardVO vo) {
		BoardVO bvo = new BoardVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from board where seq =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bvo.getSeq());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo.setSeq(rs.getInt(1));
				bvo.setTitle(rs.getString("title"));
				bvo.setWriter("writer");
				bvo.setContent(rs.getString("content"));
				bvo.setRegdate("regdate");
				bvo.setCnt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return bvo;
	}

	public int insert(BoardVO vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			//
			String sql = "INSERT INTO BOARD" + " VALUES(board_seq.nextval,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());

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
		return count;

	}

	public List<BoardVO> getboardlist() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// Statement 준비
			String sql = "SELECT SEQ,TITLE,WRITER,content, to_char(reg_date,'yyyy/mm/dd') FROM BOARD order by regdate desc";
			// SQL문 실행
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();

				int SEQ = rs.getInt(1);
				String TITLE = rs.getString(2);
				String WRITER = rs.getString(3);
				String content = rs.getString(4);
				String regdate = rs.getString(5);

				vo.setSeq(SEQ);
				vo.setTitle(TITLE);
				vo.setContent(content);
				vo.setWriter(WRITER);
				vo.setRegdate(regdate);
			//	list.insert(vo);

			}
		} catch (SQLException e) {
			System.out.println("getList_error:" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int delete(BoardVO vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			//
			String sql = "DELETE FROM BOARD" + " WHERE SEQ=? AND PASSWORD=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getSeq());
		//	pstmt.setString(2, getPassword());

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" delete_error:" + e);
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
		return count;

	}

	public int update(BoardVO vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "UPDATE GUESTBOOK SET TITLE=?, CONTENT=?  WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			
			pstmt.setInt(3, vo.getSeq());
			int result = pstmt.executeUpdate(); // SQL 실행

		} catch (SQLException e) {
			System.out.println("dao-update 에러");
			e.printStackTrace();
		} finally {

		}

		return count;

	}

}

