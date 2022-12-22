package view.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.BoardDAO;
import biz.vo.BoardVO;
import biz.vo.NoticeVO;


@WebServlet("/GetNoticeListCtrl")
public class GetNoticeListCtrl extends HttpServlet {
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardDAO bdao = new BoardDAO();
		ArrayList<NoticeVO> noticeList = bdao.getNoticeList();
		// 바인딩
		request.setAttribute("noticeList", noticeList);
		// 포워딩
		RequestDispatcher dis = request.getRequestDispatcher("getNoticeList.jsp");
		dis.forward(request, response);
	}

}
