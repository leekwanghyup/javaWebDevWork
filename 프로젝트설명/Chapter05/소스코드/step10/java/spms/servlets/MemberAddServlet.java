package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberForm.jsp");
		rd.forward(request, response);		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = getServletContext();
		    Connection conn = (Connection) sc.getAttribute("conn"); 
		    
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			memberDao.insert(new Member()
			.setEmail(request.getParameter("email"))
			.setPassword(request.getParameter("password"))
			.setName(request.getParameter("name")));
			response.sendRedirect("list");
			
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
}
