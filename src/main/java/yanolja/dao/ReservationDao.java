package yanolja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yanolja.vo.ReservationInfo;

public class ReservationDao {
	// 공통으로 사용할 전역 객체 선언
	// 1. 연결
	private Connection con;
	// 2. 대화
	private Statement stmt;
	private PreparedStatement pstmt;
	// 3. 결과
	private ResultSet rs;
	
	ProductInfoDao productInfoDao = new ProductInfoDao();
	
	// 조건에 맞춰 리스트 조회
	public List<ReservationInfo> getReservationInfo(String category, int period) {
		
		List<ReservationInfo> rlist = new ArrayList<ReservationInfo>();
		String sql = "SELECT *\r\n"
				+ "FROM RESERVATIONINFO\r\n"
				+ "WHERE RESERVATIONDATE > ADD_MONTHS(SYSDATE, -" + period + ")\r\n"
				+ "ORDER BY RESERVATIONDATE DESC";
		
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				rlist.add(new ReservationInfo(rs.getString("reservationnum"),
						rs.getDate("reservationdate"), productInfoDao.getProductInfo(rs.getInt("productinfo")),
						rs.getInt("personnum")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rlist;
	}

}
