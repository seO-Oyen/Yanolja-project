package yanolja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import yanolja.dao.DB;
import yanolja.vo.ProductInfo;

public class ProductInfoDao {
	
	private Connection con;
	// 2. 대화
	private Statement stmt;
	private PreparedStatement pstmt;
	// 3. 결과
	private ResultSet rs;
	
	public ProductInfo getProductInfo(int num) {
		ProductInfo productInfo = null;
		String sql = "SELECT *\r\n"
				+ "FROM PRODUCTINFO\r\n"
				+ "WHERE PRODUCTINFO =" + num;
		
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				productInfo = new ProductInfo(rs.getInt("productinfo"),
					rs.getBoolean("isused"),
					rs.getString("name"),
					rs.getString("product"),
					rs.getDate("startdate"),
					rs.getDate("enddate"), 
					rs.getBoolean("isbus"),
					rs.getInt("checkin"),
					rs.getInt("checkout"),
					rs.getInt("price"),
					rs.getBoolean("review"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productInfo;
	}

}
