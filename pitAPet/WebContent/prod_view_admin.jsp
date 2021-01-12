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
	<link rel="stylesheet" href="./css/prod_view.css" />
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
	<section>
	<div id="fdiv">
		<div class="sdiv">
			<img src="./img/${product.p_image}" class="img">
		</div>
		<div class="sdiv">
			<form>
				<table>
					<tr>
						<td class="left">이름　 |　 ${product.p_name}</td>		
					</tr>
					<tr>
						<td class="left">가격　 |　 <fmt:formatNumber value="${product.p_price}" pattern="#,###,###"/> 원</td>		
					</tr>
					<tr>
						<td class="left">상품　 |　 
							<select style="text-align-last: center">
							<option>----- 옵션 선택 -----</option>
							${product.p_option}
							</select>
						</td>
					</tr>
					<tr>
						<td class="left">수량　 |　 1</td>
					</tr>
					<tr>
						<td class="td5">총 금액　 |　 <fmt:formatNumber value="${product.p_price}" pattern="#,###,###"/> 원</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
<!-- 상세 정보 출력 -->
		<div id ="center">
			<hr>
			<h4>상품 상세 설명</h4>
				<p>${product.p_content}</p>
		</div>
	
	<div class="abtn">
		<a href="prodDelete.prod?p_id=${product.p_id }" class="btn" id="abtn1" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
		<a href="prodList.prod" class="btn" id="abtn1">목록</a>
	</div>
	</section>
	
    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
  </body>
</html>