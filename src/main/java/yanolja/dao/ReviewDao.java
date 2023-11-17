package yanolja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import yanolja.database.DBCon;
import yanolja.vo.Review;

public class ReviewDao {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Review getReview(int infoNum) {
		Review review = null;
		String sql = "SELECT *\r\n"
				+ "FROM REVIEW\r\n"
				+ "WHERE PRODUCTINFO = ? ";
		
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 처리코드1
			pstmt.setInt(1, infoNum);
			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드 2
				if(rs.next()) {
					review = new Review(
							rs.getInt("reviewnum"), 
							rs.getInt("productinfo"),
							rs.getInt("star"),
							rs.getString("text"));
				}
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		}
		
		return review;
	}
	
	public void setReview(int infoNum, int star, String text) {
		String sql = "INSERT INTO REVIEW\r\n"
				+ "(\r\n"
				+ "reviewnum,\r\n"
				+ "PRODUCTINFO,\r\n"
				+ "star,\r\n"
				+ "text\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(\r\n"
				+ "(SELECT NVL(MAX(REVIEWNUM), 0) + 1 FROM REVIEW),\r\n"
				+ "?,\r\n"
				+ "?,\r\n"
				+ "?\r\n"
				+ ")";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 처리코드1
			pstmt.setInt(1, infoNum);
			pstmt.setInt(2, star);
			pstmt.setString(3, text);
			
			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드 2
				if(rs.next()) {
					System.out.println("리뷰등록 처리성공");
				}
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		}
	}

}
