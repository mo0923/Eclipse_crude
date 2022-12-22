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


@WebServlet("/GetBoardListCtrl")
public class GetBoardListCtrl extends HttpServlet {
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardDAO bdao = new BoardDAO();
		ArrayList<BoardVO> boardList = bdao.getBoardList();
		// 바인딩
		request.setAttribute("boardList", boardList);
		// 포워딩
		RequestDispatcher dis = request.getRequestDispatcher("getBoardList.jsp");
		dis.forward(request, response);
		
		
		/*
		 * // #1. 넘버링 페이지 = 페이징
		 * 
		 * // 화면에 보여질 게시판글의 갯수 지정 int pageSize = 10; // 현재 보여지고 있는 페이지의 넘버값을 읽음 String
		 * pageNum = request.getParameter("pageNum"); // 처음엔 값이 없으므로 null 처리 if(pageNum
		 * == null) { pageNum = "1"; }
		 * 
		 * // 전체 게시판글의 갯수 = 이전, 이후 버튼 필요유무 판별시 사용 int count = 0; // View JSP 페이지 내에서 보여질
		 * 넘버링 숫자값 저장 변수 => 총 게시글의 갯수는 최신글부터 나오게 함 int number = 0; // 현재 보여지고 있는 페이지 정보
		 * = 숫자로 형변환 int currentPage = Integer.parseInt(pageNum);
		 * 
		 * // #2. 전체글의 갯수를 가져와야 되기 때문에 비지니스 로직 처리 BoardDAO bdao2 = new BoardDAO(); count
		 * = bdao2.getAllCount();
		 * 
		 * // #3. 전체 보여질 페이지의 시작 번호를 설정 int startRow = (currentPage -1) * pageSize +1;
		 * // 첫번째 게시판글 int endRow = currentPage * pageSize; // 마지막 게시판글
		 * 
		 * // #4. 최신글 10개를 기준으로 게시판 글을 가져옴 ArrayList<BoardVO> v =
		 * bdao2.getAllBoard(startRow, endRow); // 화면에 보일 number를 설정해줌 number = count -
		 * (currentPage-1) * pageSize;
		 * 
		 * // 바인딩 // 최신글 10개 기준으로 게시판 글 바인딩 request.setAttribute("v", v); // JSP 뷰에서 보여질
		 * 넘버링 숫자값 request.setAttribute("number", number); // 화면에 보여질 게시판 글 갯수
		 * request.setAttribute("pageSize", pageSize); // 전체 게시판글 갯수
		 * request.setAttribute("count", count); // 현재 페이지
		 * request.setAttribute("currentPage", currentPage);
		 */
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
