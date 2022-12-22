<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <div class="header-logo">
                <p></p>
                <h1>
                    <a href="./index.jsp"><img src="./images/logo_02.png" alt="로고"></a>
                </h1>
<%
   String name = (String) session.getAttribute("name");
   if(name == null){ // 로그인 전 화면
%>

                <nav class="local">
                    <ul class="lnb">
                        <li><a href="login.jsp">로그인</a></li>
                        <li><a href="./join.jsp">회원가입</a></li>
                    </ul>
                </nav>
<%
   }else{ // 로그인 후 화면
%>
                <nav class="local">
                    <ul class="lnb">
                        <li><a href="LogoutCtrl">로그아웃</a></li>
                        <li><a href="./join.jsp">회원가입</a></li>
                    </ul>
                </nav>
<%
   }
%>
            </div>
            <div class="header-gnb">
                <nav class="gnb">
                    <ul>
                        <li><a href="./index.jsp">소개</a></li>
                        <li><a href="./GetNoticeListCtrl">공지게시판</a></li>
                        <li><a href="./GetBoardListCtrl">문의게시판</a></li>
                    </ul>
                </nav>
            </div>