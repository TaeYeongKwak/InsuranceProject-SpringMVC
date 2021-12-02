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
<title>의료 기록 정보</title>
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
	<div class="info_container">
		<h2>보험 상세 정보</h2>
		<div class="input-group mb-3">
			<span class="input-group-text">보험이름</span>
			<div class="form-control">${insuranceProduct.productName }</div>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">보험종류</span>
			<div class="form-control">${insuranceProduct.insuranceProductType.insuranceName }</div>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">기본보험료</span>
			<div class="form-control">${insuranceProduct.basicInsurancePremium }원</div>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">보험금</span>
			<div class="form-control">${insuranceProduct.insuranceMoney }원</div>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">납입기간</span>
			<div class="form-control">${insuranceProduct.paymentCycle }년</div>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">납입주기</span>
			<div class="form-control">매월 ${insuranceProduct.paymentPeriod }일</div>
		</div>
		<c:choose>
			<c:when
				test="${insuranceProduct.insuranceProductType == 'ACTUALEXPENSE'}">
				<div class="input-group mb-3">
					<span class="input-group-text">자기부담금</span>
					<div class="form-control">${insuranceProduct.selfPayment }원</div>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text">보장종류</span>
					<div class="form-control">${insuranceProduct.actualExpenseType.actualexpensename }</div>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text">제한나이</span>
					<div class="form-control">${insuranceProduct.limitAge }세</div>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text">보장한도</span>
					<div class="form-control">${insuranceProduct.limitOfIndemnity }원</div>
				</div>
			</c:when>
			<c:when test="${insuranceProduct.insuranceProductType == 'CANCER'}">
				<div class="input-group mb-3">
					<span class="input-group-text">제한나이</span>
					<div class="form-control">${insuranceProduct.limitAge }세</div>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text">보장종류</span>
					<div class="form-control">${insuranceProduct.guaranteedType.cancerName }</div>
				</div>
			</c:when>
			<c:when test="${insuranceProduct.insuranceProductType == 'PENSION'}">
				<div class="input-group mb-3">
					<span class="input-group-text">보장기간</span>
					<div class="form-control">${insuranceProduct.guaranteedPeriod }세</div>
				</div>
			</c:when>
			<c:when test="${insuranceProduct.insuranceProductType == 'LIFE'}">
				<div class="input-group mb-3">
					<span class="input-group-text">필수납입기간</span>
					<div class="form-control">${insuranceProduct.requiredPaymentPeriod }년</div>
				</div>
			</c:when>
		</c:choose>
		<h2>의료 기록 정보</h2>
		<div class="input-group mb-3">
			<span class="input-group-text">고객 아이디</span>
			<div class="form-control">${client.id}</div>
		</div>
		<form action = "${pageContext.request.contextPath}/contract/add" method = "POST">
			<div class="input-group mb-3">
			<span class="input-group-text">고객 암 병력 </span> <select
				class="form-select" id="clientCancerCareer" name="clientCancerCareer">
				<option value="PANCREATIC">1.췌장암</option>
				<option value="LUNG">2.폐암</option>
				<option value="STOMACH">3.위암</option>
				<option value="COLORECTAL">4.대장암</option>
				<option value="LIVER">5.간암</option>
				<option value="ETC">6.기타</option>
			</select>
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text">가족 암 병력</span> <select
					class="form-select" id="familyCancerCareer" name="familyCancerCareer">
					<option value="PANCREATIC">1.췌장암</option>
					<option value="LUNG">2.폐암</option>
					<option value="STOMACH">3.위암</option>
					<option value="COLORECTAL">4.대장암</option>
					<option value="LIVER">5.간암</option>
					<option value="ETC">6.기타</option>
					<option value="HEALTHY">7.건강</option>
				</select>
			</div>
	
			<div class="input-group mb-3">
				<span class="input-group-text">고객 입원 횟수</span> 
				<input type="text" class="form-control" id="numberOfHospitalizations" name="numberOfHospitalizations" required>
			</div>
	
			<div class="input-group mb-3">
				<span class="input-group-text">고객 병원 방문 횟수</span> 
				<input type="text" class="form-control" id="numberOfHospitalVisits" name="numberOfHospitalVisits" required>
			</div>
			<input type="hidden" name="clientId" value="${client.id }">
			<input type="hidden" name="productName" value="${insuranceProduct.productName }">
			<input type="submit" value="계약하기" class="btn btn-primary">
		</form>
		
	</div>
</body>
</html>