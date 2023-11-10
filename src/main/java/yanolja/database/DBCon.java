package yanolja.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	  
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	// 드라이버 정보 :@ip:port:DB명
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	public static Connection con() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	// 2. DB 처리한 후, 자원을 해제하는 기능 공통 기능 메서드
	// ... : 여러개의 객체를 매개변수로 받아서 처리할 때 사용하는 형태로 배열로 받는다
	public static void close(AutoCloseable... resources) {
		for (AutoCloseable resource : resources) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					// 해당 클래스의 예외가 나올때 처리
					System.out.print(resource.getClass().getSimpleName());
//					e.printStackTrace();
					System.out.println("닫기 실패");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			DBCon.con();
			System.out.println("접속성공");
		} catch (SQLException e) {
			System.out.println("에러발생" + e.getMessage());
		}
		
	}

}
