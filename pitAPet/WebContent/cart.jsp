<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.Cart" %>
<%@page import="vo.Product" %>
<%@page import="dao.ProdDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.ArrayList" %>
<%
	String id = (String)session.getAttribute("id");
%>
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
	<link rel="stylesheet" href="./css/cart.css" />
	<script src="./js/jquery.js"></script>
	<script src="./js/jquery.bxslider.min.js"></script>
	<script src="./js/isotope.pkgd.min.js"></script>
	<script src="./js/common.js"></script>
	<script src="./js/main.js"></script>
 	<script> 
 		function checkAll(theForm){ 
 			if(theForm.remove.length == undefined){ 
 				theForm.remove.checked = theForm.allCheck.checked; 
 			}else{ 
 				for(var i=0; i<theForm.remove.length; i++){ 
 					theForm.remove[i].checked = theForm.allCheck.checked; 
 				} 
 			} 
 		} 
		
 		function checkQtyDown(p_name, p_qty){
 			if(p_qty != 1){
 				location.href="prodCartQtyDown.prod?p_name="+p_name;
 			}
 		}
 		
 		function checkQtyUp(p_name, p_qty){
 			if(p_qty >= 1){
 				location.href="prodCartQtyUp.prod?p_name="+p_name;
 			}
 		}
 		
 	</script> 
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


<!-- 장바구니 -->
	<section id="listForm">
		<c:if test="${cartList != null && cartList.size()>0}">
		<h2>장바구니</h2><br>
		<form method="post">
			<table>
				<tr class = "tr_top">
					<th><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(this.form)"/></th>
					<th>번호</th>
					<th colspan="3">상품</th>
					<th>가격</th>
					<th>수량</th>
				</tr>
				
				<c:forEach var="cart" items="${cartList }" varStatus="status">
				
					<tr class="tr">
						<td><input type="checkbox" id="remove" name="remove" value="${cart.p_name }"/></td>
						<td>${status.index+1}	<!-- 번호값 계산 --></td>
						<td><img src = "./img/${cart.p_image }" id = "cartImage"/></td>
						<td colspan="2">${cart.p_name }</td>
						<td><fmt:formatNumber value="${cart.p_price }" pattern="#,###,###"/> 원</td>
						<td><a href="javascript:checkQtyUp('${cart.p_name }', ${cart.p_qty })"><img src="./img/up.jpg" id="upImage" border=0/>
						</a><br>
						${cart.p_qty }<br>
	 					<a href = "javascript:checkQtyDown('${cart.p_name }', ${cart.p_qty })">
	 					<img src="./img/down.jpg" id="downImage" border=0/>
	 					</a>
	 					</td>
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td colspan="2" id="left">
						<input type="submit" value="삭제" formaction="prodCartRemove.prod" id="subbtn"/></td>
					<td colspan="5" id="right">
						총 금액 : <fmt:formatNumber value="${totalMoney }" pattern="#,###,###"/> 원</td>
				</tr>
			</table>
		</form><br>
		</c:if>
		<c:if test="${cartList.size() == 0 || cartList == null }">
			<section class="div_empty">
				<h4>장바구니에 담긴 상품이 없습니다.</h4>
			</section>
		</c:if>
		<nav id = "commandList">
			<a href = "prodList.prod" id="keep">쇼핑 계속하기</a>
		</nav>
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