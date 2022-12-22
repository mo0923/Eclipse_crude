package biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import biz.common.JDBCConnection;
import biz.vo.UserVO;

public class UserDAO {
	//Connection객체 선언
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	   
	   
	public void insertMember(UserVO bean) {
	   // DB 접속
	   try {
			conn = JDBCConnection.getConnection();

	      // sql
	      String sql = "insert into project_member values((select nvl(max(seq),0)+1 from project_member),?,?,?,?,?)";
	      // ?
	      stmt = conn.prepareStatement(sql);
	      // ? 매핑
	      stmt.setString(1, bean.getId());
	      stmt.setString(2, bean.getPassword());
	      stmt.setString(3, bean.getName());
	      stmt.setString(4, bean.getEmail());
	      stmt.setString(5, bean.getRole());
	         
	      // 실행
	      stmt.executeUpdate();
 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(stmt, conn);
		}
	   System.out.println("DB 데이터 처리완료!!");
	}
	
}
