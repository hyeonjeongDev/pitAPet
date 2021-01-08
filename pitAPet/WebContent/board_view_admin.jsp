<%@ page import="vo.BoardBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	BoardBean article = (BoardBean)request.getAttribute("article");
	String nowPage = (String)request.getAttribute("page");
%>
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
	<link rel="stylesheet" href="./css/board_view.css" />
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
	
	
	<!-- 상세 정보 -->
<div class="notice">
	<section id="basicInfoArea">
		<table>
		<tr>
			<th width="20%">제목</th>
			<td width="80%"><%=article.getBoard_subject() %></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><%if(!(article.getBoard_file()==null)){ %>
			<a href="#"><%=article.getBoard_file() %></a>
		<%} %></td>
		</tr>
		<tr>
			<td colspan="2"><%=article.getBoard_content()%></td>
		</tr>
		</table>
	</section>
	<div class="abtn">
		<a href="boardModifyForm.bo?board_num=<%=article.getBoard_num() %>" class="btn" id="abtn2">수정</a>
		<a href="boardDeletePro.bo?board_num=<%=article.getBoard_num() %>&page=<%=nowPage %>" class="btn" id="abtn2" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
		<a href="boardList.bo" class="btn" id="abtn2">목록</a>
	</div>
</div>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
  </body>
</html>