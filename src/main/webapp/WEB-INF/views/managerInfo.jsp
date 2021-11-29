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
<title>매니저 상세 정보</title>
<style>
.info_container {
	margin: 10px auto;
	margin-top: 5%;
	margin-bottom: 10%;
	width: 800px;
}
.content {
	display: block;
	min-height: 300px;
	padding: 10px;
	font-size: larger;
	word-break: break-all;
	margin-bottom: 20px;
}
h2 {
	text-align: center;
	margin: 30px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/manager/Info"
		method="GET">
		<div class="info_container">
			<h2>관리자 상세 정보</h2>
			<div class="input-group mb-3">
				<span class="input-group-text">관리자 아이디</span>
				<div class="form-control">${managerInfo.id}</div>
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text">관리자 비밀번호</span>
				<div class="form-control">${managerInfo.password}</div>
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">관리자 직책</span>
				<div class="form-control">${managerInfo.jobPosition}</div>
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text">관리자 이름</span>
				<div class="form-control">${managerInfo.name}</div>
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text">관리자 나이</span>
				<div class="form-control">${managerInfo.age}</div>
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text">관리자 전화 번호</span>
				<div class="form-control">${managerInfo.phoneNumber}</div>
			</div>

			<button class="btn btn-primary" class="btn"
				onclick="history.back(); return false;">돌아가기</button>
			<button class="btn btn-primary" class="btn"
				onclick="#">내용 수정하기</button>
		</div>
	</form>
</body>
</html>