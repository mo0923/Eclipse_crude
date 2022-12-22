package view.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.UserDAO;
import biz.vo.UserVO;

@WebServlet("/JoinCtrl.do")
public class JoinCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetePost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetePost(request, response);
	}
	
	protected void doGetePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 폼 파라메터값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String password2 = request.getParameter("password2");
		
		// 자바빈에 폼에서 받은 데이터 넣기
		UserVO bean = new UserVO();
		bean.setId(id);
		bean.setPassword(password);
		bean.setName(name);
		bean.setEmail(email);
		bean.setRole(role);
		
		if(password.equals(password2)) {
			// 비밀번호 맞으면
			UserDAO udao = new UserDAO();
			udao.insertMember(bean);
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}else {
			 // 비밀번호 다르면
	         RequestDispatcher dis = request.getRequestDispatcher("JoinError.jsp");
	         dis.forward(request, response);
	    }
		
	
	}

}
