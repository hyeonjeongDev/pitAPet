<%@page import="vo.BoardBean"%>
<%@page import="vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
%>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	ArrayList<BoardBean> articleList=(ArrayList<BoardBean>)request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="./css/basic.css" />
	<link rel="stylesheet" href="./css/board_list.css" />
	<script src="./js/jquery.js"></script>
	<script src="./js/jquery.bxslider.min.js"></script>
	<script src="./js/isotope.pkgd.min.js"></script>
	<script src="./js/common.js"></script>
	<script src="./js/main.js"></script>

    <title>PIT-A-PET</title>
  </head>
  <body>
<!-- 로그인바 -->
	<nav class="navbar navbar-expand-sm navbar-light" id="login-bar">
		<a class="navbar-brand" id="navyellow" href="./prodMain.prod?p_best=1">PIT-A-PET</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
<%
	if(id == null) {
%>
					<a class="nav-link active" id="navyellow" href="./userLogin.do">로그인</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="./userJoin.do">회원가입</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="./prodCartList.prod">장바구니</a>
				</li>

<%}	else {%>
<% if(id.equals("admin")) {%>
	<script>
		location.href = "admin.jsp";
	</script>
<%} %>
				<li>
					<a class="nav-link" id="navyellow" href="./userLogout.do">로그아웃</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="./prodCartList.prod">장바구니</a>
				</li>
<%
	}
%>
			</ul>
		</div>
	</nav>

<!-- 로고 -->
	<div class="logo">
	<a href="./prodMain.prod?p_best=1"><img src="./img/LOGO.png"></a>
	</div>

<!-- 메뉴바 -->
	<div id="header-wrap">
		<header class="header-inner">
			<nav id="gnb">
				<ul>
					<li class="m1"><a href="intro.jsp">사이트 소개</a></li>
					<li class="m2"><a href="boardList.bo">공지사항</a></li>
					<li class="m3"><a href="./prodList.prod">전체 보기</a></li>
					<li class="m4"><a href="#">강아지</a>
						<ul>
							<li><a href="./prodItemList.prod?p_item=강아지용품">용품</a></li>
							<li><a href="./prodItemList.prod?p_item=강아지간식">간식</a></li>
							<li><a href="./prodItemList.prod?p_item=강아지장난감">장난감</a></li>
						</ul></li>
					<li class="m5"><a href="#">고양이</a>
						<ul>
							<li><a href="./prodItemList.prod?p_item=고양이용품">용품</a></li>
							<li><a href="./prodItemList.prod?p_item=고양이간식">간식</a></li>
							<li><a href="./prodItemList.prod?p_item=고양이장난감">장난감</a></li>
						</ul>
					</li>
				</ul>
			</nav>
		</header>
	</div>
	
<!-- 공지사항 리스트 -->
<div class="notice">
<h3>공지사항</h3>
	<%
		if(articleList != null && listCount > 0){
	%>
	<section id="listForm">
		<table>
				<tr>
					<th width="13%">번호</th>
					<th width="40%">제목</th>
					<th width="15%">작성자</th>
					<th width="17%">날짜</th>
					<th width="15%">조회수</th>
				</tr>
				<%
					for(int i = 0; i<articleList.size(); i++){	
				%>
				<tr>
					<td><%=articleList.get(i).getBoard_num() %></td>
					<td>
						<a href="boardDetail.bo?board_num=<%=articleList.get(i).getBoard_num() %>&page=<%=nowPage %>">
						<%=articleList.get(i).getBoard_subject() %></a>
					</td>
					<td>관리자</td>
					<td><%=articleList.get(i).getBoard_date() %></td>
					<td><%=articleList.get(i).getBoard_readcount() %></td>
				</tr>
				<%} %>
		</table>
	</section>
	<section id="pageList">
		<%if(nowPage <= 1){ %>
			[이전]　
		<%}else{ %>
			<a href="boardList.bo?page=<%=nowPage-1 %>">[이전]</a>　
		<%} %>
		
		<%for(int a=startPage; a<=endPage; a++){
			if(a==nowPage){%>
				[<%=a %>]
			<%}else{ %>
				<a href="boardList.bo?page=<%=a %>">[<%=a %>]</a> 
			<%} %>
		<%} %>
		
		<%if(nowPage >= maxPage){ %>
			　[다음]
		<%}else{ %>
			　<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</section>
	<%}else{%>
	<section id="emptyArea"><h5>등록된 글이 없습니다.</h5></section>
	<%} %>
</div>

<!-- 푸터 -->
	<div class="fdiv">
		<footer>
			<div>
				<a href="./prodMain.prod?p_best=1"><img src="./img/LOGO.png"></a>
			</div>
			<div class="fdiv2">
				이용약관 | 개인정보처리방침<br>
				상호 : PIT-A-PET | 주소 : 대구광역시 달서구 달구벌대로 251 안길 15(이곡동 1224-2번지) <br>
				대표 번호 : 053-123-4567 | 팩스 번호 : 053-123-4568<br>
				COPYRIGHT (c) pitapet.com ALL RIGHTS RESERVED. DESIGNED BY TURU.
			</div>
			<div class="fdiv2">
				고객센터 053-123-4567<br>
				평일 10:00 ~ 18:00<br>
				점심시간 13:00 ~ 14:00<br>
				메일 gangrg@pitapet.com
			</div>
		</footer>
	</div>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
  </body>
</html>