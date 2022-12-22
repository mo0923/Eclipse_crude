package view.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.common.JDBCConnection;
import biz.vo.UserVO;

@WebServlet("/LoginCtrl.do")
public class LoginCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 폼 데이터 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
				
		// DB 접속
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
			// DB 접속
			conn = JDBCConnection.getConnection();
			// SQL 준비
			String sql = "select * from project_member where id=? and password=?";
			// ?
			stmt = conn.prepareStatement(sql);
			// ? 매핑
			stmt.setString(1, id);
			stmt.setString(2, password);
			// 실행
			rs = stmt.executeQuery();
			// 사용
			if(rs.next()){
				String name = rs.getString("name"); // DB 칼럼명
				HttpSession session = request.getSession();
				session.setAttribute("name", name); // 위 DB에서 가져온 할당한 값
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("LoginError.jsp");
			}
				rs.close();
				stmt.close();
				conn.close();
					
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(rs, stmt, conn);
			}
		}

}
