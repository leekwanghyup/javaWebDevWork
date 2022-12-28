package spms.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import spms.dao.MemberDao;
import spms.util.DBConnectionPool;

//@WebListener
public class ContextLoaderListener implements ServletContextListener{
	
	private DBConnectionPool dbConnectionPool;  
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext sc = sce.getServletContext();
			
			// 커넥션풀 객체 생성 : 초기화 파라미터 전달 
			dbConnectionPool = new DBConnectionPool(
					sc.getInitParameter("driver"), 
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			
			MemberDao memberDao = new MemberDao();
			// 커넥션풀 주입
			memberDao.setDbConnectionPool(dbConnectionPool);
			
			sc.setAttribute("memberDao", memberDao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 모든 커넥션 자원 반납
		dbConnectionPool.closeAll();
	}
}
