package spms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnectionPool {
	String url;
	String username; 
	String password; 
	
	// 커넥션 객체를 보관할 리스트 
	ArrayList<Connection> connList = new ArrayList<Connection>();
	
	public DBConnectionPool(String driver,String url, String username, String password) throws ClassNotFoundException {
		this.url = url;
		this.username = username;
		this.password = password;
		Class.forName(driver);
	}
	
	public Connection getConnection() throws SQLException {
		if(connList.size()>0) {
			Connection conn = connList.get(0);
			if(conn.isValid(10)) { // 연결 유효성 검사 - 유효한 연결이면 true, 유효하지 않거나 제한시간안에 유효성을 확인할 수 없을 경우 false반환
				return conn; 
			}
		} 
		// 보관된 Connection 객체가 없다면 새로 생성 후 반환 
		return DriverManager.getConnection(url,username,password);
	}
	
	public void returnConnection(Connection conn) throws Exception {
		// 사용한 커넥션 객체를 커넥션풀에 반환 
		connList.add(conn);
	}
	
	public void closeAll() {
		// 웹 애플리케이션 종료 전 DB와 연결 종료 
		for(Connection conn : connList) {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
