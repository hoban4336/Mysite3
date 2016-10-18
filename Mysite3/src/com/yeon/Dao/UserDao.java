package com.yeon.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}
		return conn;
	}

	// 로그인
	public void insert(UserVo vo) {
		System.out.println(vo);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into Users values( user_seq.nextval,?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public UserVo get(String email, String password) {
		UserVo vo = null;
		Connection conn = null;
		String sql ="select no, name from users where email = ? and password = ?" ;
		ResultSet rs = null;
		try {
			conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery(); 
			if(rs.next()){
				Long no =rs.getLong(1);
				String name =rs.getString(2);
				
				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 회원정보 수정시 정보를 가져오기
	public UserVo get(Long num) {
		UserVo vo = null;
		Connection conn = null;
		String sql ="select no, name, email, password, gender from users where no = ? " ;
		ResultSet rs = null;
		try {
			conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, num);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()){
				Long no =rs.getLong(1);
				String name =rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				String gender = rs.getString(5);
				
				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setPassword(password);
				vo.setGender(gender);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	// 회원정보 수정시 정보를 update
	public void update(UserVo vo) {
		System.out.println(vo);
		Connection conn = null;
		String sql ="update users set NAME=? , GENDER = ?, PASSWORD =? where no =? " ;

		try {
			conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getPassword());
			pstmt.setLong(4, vo.getNo());
			 
			pstmt.executeUpdate(); 
			System.out.println("회원 정보 수정 완료 ");
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}