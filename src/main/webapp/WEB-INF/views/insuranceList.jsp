<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insurance List</title>
<style>
.table {
	margin-top: 30px;
}
.writeButton {
	margin-top: 10px;
	background: #AADBFF;
	float: right;
	border: none;
	height: 35px;
	width: 130px;
	color: #3c3c3c;
	cursor: pointer;
	margin-bottom: 30px;
}
.writeButton:hover {
	background: #20c997;
	color: #FFFFFF;
}
.row {
	display: flex;
}
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
	<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a href="/">Main</a></li>
							<li><a href="insurance/List">InsuranceList</a></li>
							<li><a href="#">AccidentList</a></li>
							<li><a href="login">Login</a></li>
							<li><a href="signUp">signUp</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="content">
			<div class="row">
				<table class="table table-hover"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th>번호</th>
							<th>보험명</th>
							<th>고객이름</th>
							<th>계약날짜</th>
							<th>만기날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${insuranceProduct.insuranceProductNum}</td>
							<td>${insuranceProduct.productName}</td>
							<td>${contract.client.name}</td>
							<td>${contract.insuranceContractDate}</td>
							<td>${contract.insuranceExpiryDate}</td>
						</tr>
						<tr>
							<td>2</td>
							<td>연금보험</td>
							<td>둘민</td>
							<td>2021.07.11</td>
							<td>2021.08.13</td>
						</tr>
					</tbody>
				</table>
				<div>
					<a href="Design" class="btn btn-primary">보험 설계하기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>