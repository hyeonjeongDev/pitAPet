<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap" %>
<%@page import="vo.Product" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="./css/prod_list.css" />
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

<!-- 상품 -->
<section>
	<h4>상품 목록　|　<a href="prodRegistForm.prod">상품 등록</a></h4>
	<c:if test="${prodList != null }">
		<div class="bdiv">
			<c:forEach var="prod" items="${prodList }" varStatus="status">
				<div class="card" id="card">
					<a href="prodView.prod?p_id=${prod.p_id }"> <img src="./img/${prod.p_image }" class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">
								<b>${prod.p_name }</b><br><fmt:formatNumber value="${prod.p_price }" pattern="#,###,###"/> 원</p>
						</div>
					</a>
			<c:if test="${((status.index+1) mod 4)==0 }">
				</div>
				<div>
			</c:if>
				</div>
			</c:forEach>
		</div>
	</c:if>
</section>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
  </body>
</html>