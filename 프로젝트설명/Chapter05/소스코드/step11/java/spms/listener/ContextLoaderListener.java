package spms.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import spms.dao.MemberDao;

//@WebListener
public class ContextLoaderListener implements ServletContextListener{
	
	private Connection conn; 
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		try {
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
			sc.getInitParameter("url"),
			sc.getInitParameter("username"),
			sc.getInitParameter("password"));
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			sc.setAttribute("memberDao", memberDao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {conn.close();} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
}
