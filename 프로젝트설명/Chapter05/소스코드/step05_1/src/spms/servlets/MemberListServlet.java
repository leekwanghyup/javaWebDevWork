package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import spms.vo.Member;

@WebServlet("/member/list")
public class MemberListServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT MNO,MNAME,EMAIL,CRE_DATE" + 
					" FROM MEMBERS" +
					" ORDER BY MNO ASC");
			
			response.setContentType("text/html; charset=UTF-8");
			// 데이터베이스에서 회원 정보를 가져와 Member에 담는다.
			// 그리고 Member객체를 ArrayList에 추가한다.
			ArrayList<Member> members = new ArrayList<Member>();
			while(rs.next()) {
				members.add(new Member()
					.setNo(rs.getInt("MNO"))
					.setName(rs.getString("MNAME"))
					.setEmail(rs.getString("EMAIL"))
					.setCreatedDate(rs.getDate("CRE_DATE"))	);
			}
			// request에 회원 목록 데이터 보관한다.
			request.setAttribute("members", members);
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e); // 에러객체 보관
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response); // Error.jsp페이지로 포워딩
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
			try {if (stmt != null) stmt.close();} catch(Exception e) {e.printStackTrace();}
			try {if (conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
}
