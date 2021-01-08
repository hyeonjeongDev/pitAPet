<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- 상품 등록 -->
	<section>
		<form enctype="multipart/form-data" method="post" action="prodRegist.prod">
			<h3 class="text-center pb-2">상품 등록</h3><br/>
			<div class="form-group" style="margin-bottom:10px;">
				<label><input type="radio" name="p_best" value="0" checked="checked"> 일반 상품</label>　
				<label><input type="radio" name="p_best" value="1"> 베스트 상품</label>
			</div>
			<div class="form-group">
				<select class="form-control" name="p_item">
					<option value="강아지용품">강아지 용품</option>
					<option value="강아지간식">강아지 간식</option>
					<option value="강아지장난감">강아지 장난감</option>
					<option value="고양이용품">고양이 용품</option>
					<option value="고양이간식">고양이 간식</option>
					<option value="고양이장난감">고양이 장난감</option>
				</select>
			</div>
			<div class="form-group">
				상품명<input type="text" class="form-control" name="p_name" maxlength="30" required="required" />
			</div>
			<div class="form-group">
				가격<input type="text" class="form-control" name="p_price" maxlength="20" required="required" />
			</div>
			<div class="form-group">
				상품 옵션<textarea class="form-control" name="p_option" cols="20" wrap="off"><option>---</option></textarea>
			</div>
			<div class="form-group">
				상세 정보<textarea class="form-control" name="p_content" rows="6" cols="20" wrap="off"><img src = "./img/---.jpg" class="img2">
<p>---</p></textarea>
			</div>
			<div class="form-group">
				상품 이미지<input type="file" class="form-control" style="border:none" name="p_image" maxlength="20" required="required" />
			</div>
			<div class="bts">
				<button type="submit" class="btn form-control" id="btn">등록하기</button>
				<button type="reset" class="btn form-control" id="btn">다시 작성</button>
				<button type="button" class="btn form-control" id="btn" onclick="location.href='prodList.prod'">목록 보기</button>
			</div>
		</form>
	</section>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
  </body>
</html>