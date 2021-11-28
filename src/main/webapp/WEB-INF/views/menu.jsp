<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>menu</title>
<style>
.menu {
	width: 100%;
	list-style: none;
	text-align: center;
	border-bottom: 2px solid #d49466;
	background-color: #4B0082;
}

.menu li {
	display: inline-block;
	line-height: 136px;
}

.menu li a {
	color: #d49466;
	text-decoration: none;
	font-size: 24px;
	margin-right: 40px;
}

.menu li a:hover {
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>
<c:set var="manager" value="${managerType}">
</c:set>
<c:choose>
<c:when test="${isManager == true && managerType == IP}">
<div class="container pt-3">
	<div class="row">
		<div class="col-sm-4">
			<h2>Insurance Project</h2>
				<p>분산 프로프로그래밍2 Project</p>
				<img src="resources/img/img2.png" class="img-fluid">
				<p><h3>Person involved in development</h3>
				<p>곽태영 60161588
				<p>이승준 60161619
				<p>임용덕 60171656
				<p>한민 60171664</p>
				<p>---------------------------------------------------------------</p>
				<h3>사이드 메뉴</h3>
				<p>사이드 메뉴를 통해 저희 Insurance Page를 구경해보세요.</p>
				<ul class="list-group">
					<li class="list-group-item list-group-item-action"><a href="#">a</a></li>
					<li class="list-group-item list-group-item-action"><a href="#">b</a></li>
					<li class="list-group-item list-group-item-action"><a href="#">c</a></li>
				</ul>
			</div>
			<div class="col-sm-8">
				<h2>This is InsuranceProduct Developer Page.</h2>
				<p>If you want to develop InsuranceProduct, click below IMG!!</p>
				<a href="${pageContext.request.contextPath}/Design"> <img src="resources/img/img1.png"
					class="img-fluid">
				</a>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${isManager == true && managerType == IPA}">
	<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a href="${pageContext.request.contextPath}/">Main</a></li>
							<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/My Page">My page</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${isManager == true && managerType == UW}">
	<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a href="${pageContext.request.contextPath}/">Main</a></li>
							<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/My Page">My page</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${isManager == true && managerType == CM}">
	<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a href="${pageContext.request.contextPath}/">Main</a></li>
							<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/My Page">My page</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${isManager == true && managerType == CH}">
	<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a href="${pageContext.request.contextPath}/">Main</a></li>
							<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/My Page">My page</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${isManager == true && managerType == SP}">
	<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a href="${pageContext.request.contextPath}/">Main</a></li>
							<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/My Page">My page</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
</c:choose>
<div class="header">
	<div class="menu">
		<div class="menu-area">
			<div class="limit-box">
				<nav class="main-menu">
					<ul class="menu-area-main">
						<li class="active"><a href="${pageContext.request.contextPath}/">Main</a></li>
						<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
						<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						<li><a href="${pageContext.request.contextPath}/My Page">My page</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>
</body>
</html>