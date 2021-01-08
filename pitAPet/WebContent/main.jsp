<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
%>
<%@page import="vo.ProdBean" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="./css/basic.css" />
	<link rel="stylesheet" href="./css/main.css" />
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

<!-- 배너 -->
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="2500">
	  <ol class="carousel-indicators">
	    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="./img/cat_dog.jpg" class="d-block w-100" alt="..." id="banner">
	    </div>
	    <div class="carousel-item">
	      <img src="./img/cat.jpg" class="d-block w-100" alt="..." id="banner">
	    </div>
	    <div class="carousel-item">
	      <img src="./img/dog.jpg" class="d-block w-100" alt="..." id="banner">
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>

<!-- 상품 -->
<section>
	<h4>BEST ITEM</h4>
	<c:if test="${bestItem != null }">
		<div class="bdiv">
			<c:forEach var="best" items="${bestItem }" varStatus="status">
				<div class="card" id="card">
					<a href="prodView.prod?p_id=${best.p_id }"> <img src="./img/${best.p_image }" class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">
								<b>${best.p_name }</b><br>
								<fmt:formatNumber value="${best.p_price }" pattern="#,###,###" /> 원
							</p>
						</div>
					</a>
			<c:if test="${((status.index+1) mod 3)==0 }">
				</div>
				<div>
			</c:if>
				</div>
			</c:forEach>
		</div>
	</c:if>
</section>

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