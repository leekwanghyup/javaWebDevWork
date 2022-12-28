package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import spms.util.DBConnectionPool;
import spms.vo.Member;

public class MemberDao {
	
	private DBConnectionPool dbConnectionPool;
	
	public void setDbConnectionPool(DBConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}

	public List<Member> selectList() throws Exception {
		Connection connection = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query ="SELECT MNO,MNAME,EMAIL,CRE_DATE FROM MEMBERS ORDER BY MNO ASC";
	    try {
	    	// 커넥션풀에서 커넥션을 얻어옴
	    	connection = dbConnectionPool.getConnection(); 
	        pstmt = connection.prepareStatement(query);
	        rs = pstmt.executeQuery(query);
	        ArrayList<Member> members = new ArrayList<Member>();
	        while(rs.next()) {
				members.add(new Member()
				  .setNo(rs.getInt("MNO"))
				  .setName(rs.getString("MNAME"))
				  .setEmail(rs.getString("EMAIL"))
				  .setCreatedDate(rs.getDate("CRE_DATE")));
	        }
	        return members;
	    } catch (Exception e) {
	    	throw e;
	    } finally {
	    	try {if (rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	    	try {if (pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	    	// 커넥션풀에 반납
	    	if(connection!=null) dbConnectionPool.returnConnection(connection);
	    }
	}
	
  public int insert(Member member) throws Exception  {
	Connection connection = null;
    PreparedStatement pstmt = null;
    try {
      connection = dbConnectionPool.getConnection(); 
      pstmt = connection.prepareStatement(
          "INSERT INTO MEMBERS(EMAIL,PWD,MNAME,CRE_DATE,MOD_DATE) VALUES (?,?,?,NOW(),NOW())");
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getPassword());
      pstmt.setString(3, member.getName());
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	   // 커넥션풀에 반납
	  	if(connection!=null) dbConnectionPool.returnConnection(connection);
    }
  }
	
  public int delete(int no) throws Exception {
	Connection connection = null; 
    PreparedStatement pstmt = null;
    String query = "DELETE FROM MEMBERS WHERE MNO=?";
    try {
      connection = dbConnectionPool.getConnection(); 
	  pstmt = connection.prepareStatement(query);
	  pstmt.setInt(1, no);
	  return pstmt.executeUpdate();
    } catch (Exception e) {
    	throw e;
    } finally {
    	try {if (pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
    	if(connection!=null) dbConnectionPool.returnConnection(connection);
    }
  }

  public Member selectOne(int no) throws Exception { 
	 
	Connection connection = null;
    PreparedStatement pstmt = null;
    String query ="SELECT MNO,EMAIL,MNAME,CRE_DATE FROM MEMBERS WHERE MNO=?";
    ResultSet rs = null;
    try {
      connection = dbConnectionPool.getConnection();
      pstmt = connection.prepareStatement(query);
      pstmt.setInt(1, no);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        return new Member()
        .setNo(rs.getInt("MNO"))
        .setEmail(rs.getString("EMAIL"))
        .setName(rs.getString("MNAME"))
        .setCreatedDate(rs.getDate("CRE_DATE"));
      } else {
        throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
      }
    } catch (Exception e) {
      throw e;
    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
      try {if (pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
      if(connection!=null) dbConnectionPool.returnConnection(connection);
    }
 }

  public int update(Member member) throws Exception {
	Connection connection = null; 
    PreparedStatement pstmt = null;
    String query = "UPDATE MEMBERS SET EMAIL=?,MNAME=?,MOD_DATE=now() WHERE MNO=?";
    try {
      connection = dbConnectionPool.getConnection();
      pstmt = connection.prepareStatement(query);
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      pstmt.setInt(3, member.getNo());
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
      if(connection!=null) dbConnectionPool.returnConnection(connection);
    }
 }
  
  public Member exist(String email, String password) throws Exception {
	Connection connection = null; 
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      connection = dbConnectionPool.getConnection();	
      pstmt = connection.prepareStatement("SELECT MNAME,EMAIL FROM MEMBERS  WHERE EMAIL=? AND PWD=?");
      pstmt.setString(1, email);
      pstmt.setString(2, password);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        return new Member()
          .setName(rs.getString("MNAME"))
          .setEmail(rs.getString("EMAIL"));
      } else {
        return null;
      }
    } catch (Exception e) {
      throw e;
    } finally {
      try {if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
      try {if (pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
      if(connection!=null) dbConnectionPool.returnConnection(connection);
    }
 }
}
