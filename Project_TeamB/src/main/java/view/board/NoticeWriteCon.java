package view.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.BoardDAO;
import biz.vo.NoticeVO;

@WebServlet("/NoticeWriteCon.do")
public class NoticeWriteCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		NoticeVO nbean = new NoticeVO();
		nbean.setWriter(request.getParameter("writer"));
		nbean.setSubject(request.getParameter("subject"));
		nbean.setEmail(request.getParameter("import"));
		nbean.setContent(request.getParameter("content"));
		nbean.setPassword(request.getParameter("password"));

		
		BoardDAO bdao = new BoardDAO();
		bdao.insertnotice(nbean);
		
		RequestDispatcher dis = request.getRequestDispatcher("GetNoticeListCtrl");
		dis.forward(request, response);
	}

}
