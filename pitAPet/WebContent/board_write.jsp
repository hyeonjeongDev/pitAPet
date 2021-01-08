<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.Product" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="./css/admin.css" />
	<link rel="stylesheet" href="./css/regist.css" />
	<script src="./js/jquery.js"></script>
	<script src="./js/jquery.bxslider.min.js"></script>
	<script src="./js/isotope.pkgd.min.js"></script>
	<script src="./js/common.js"></script>
	<script src="./js/main.js"></script>

    <title>PIT-A-PET</title>
  </head>
  <body>
<!-- 로그인바 -->
	<nav class="navbar navbar-expand-sm navbar-dark" id="login-bar">
		<a class="navbar-brand" id="navyellow" href="admin.jsp">PIT-A-PET</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
<%if(id==null) { %>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="./userLogin.do">로그인</a>
				</li>
<%} %>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="./userLogout.do">로그아웃</a>
				</li>
			</ul>
		</div>
	</nav>
	
	
	<!-- 게시판 -->
	<section id="writeForm">
	
	
		<form action = "boardWritePro.bo" method = "post" enctype = "multipart/form-data" name = "boardform">
				<h3 class="text-center pb-2">공지사항 등록</h3><br/>
				<div class="form-group">
					<label for="board_subject"><span>제목</span></label>
					<input type="text" class="form-control" name="board_subject" id="board_subject" maxlength="120" required="required"/>
				</div>
				<div class="form-group">
					<label for="board_content"><span>내용</span></label>
					<textarea id="board_content" class="form-control" name="board_content" cols="120" rows="15" required="required"></textarea>
				</div>
				<div class="form-group">
					<label for="board_file">파일 첨부</label>
					<input type="file" class="form-control" style="border:none" name="board_file" id="board_file" required="required"/>
				</div>
				<div class="bts">
					<button type="submit" class="btn form-control" id="btn">등록하기</button>
					<button type="reset" class="btn form-control" id="btn">다시 작성</button>
					<button type="button" class="btn form-control" id="btn" onclick="location.href='boardList.bo'">목록 보기</button>
				</div>
			</form>
	
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="board_name">글쓴이</label></td> -->
<!-- 					<td class="td_right"><input type="text" name="board_name" id="board_name" required="required"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="board_pass">비밀번호</label></td> -->
<!-- 					<td class="td_right"><input type="password" name="board_pass" id="board_pass" required="required"/></td> -->
<!-- 				</tr> -->
	</section>
	
	
    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
  </body>
</html>