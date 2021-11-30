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
<title>develop Insurance</title>
<style>
.sign_up_container {
	margin: 10px auto;
	margin-top: 5%;
	margin-bottom: 10%;
	width: 800px;
}

h1 {
	text-align: center;
	margin: 60px;
}

.input_interval {
	padding-bottom: 15px;
}

.input_span {
	width: 140px;
}

.radio_group_container {
	width: 100%;
}

.radio_item_container {
	padding: 5px;
	padding-left: 40px;
	width: 50%;
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
<script>
	function changeForm(value) {
		location.href = "<c:out value="${pageContext.request.contextPath}" />"
				+ '/product/design/' + value;
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="sign_up_container">
		<h1>Develop Insurance Page</h1>
		<form action="${pageContext.request.contextPath}/product/develop/<c:choose>
						<c:when test="${type == 'CANCER'}">
							cancer
						</c:when>
						<c:when test="${type == 'PENSION'}">
							pension
						</c:when>
						<c:when test="${type == 'LIFE'}">
							life
						</c:when>
						<c:when test="${type == 'ACTUALEXPENSE'}">
							actualExpense
						</c:when>
					</c:choose>" class="was-validated" method="post">
			<div class="input-group mb-3 mt-3 input_interval">
				<span class="input-group-text input_span">보험종류</span> 
				<select
					class="form-select" id="insurance" name="insuranceProductType"
					onchange="changeForm(this.value)">
					<c:choose>
						<c:when test="${type == 'CANCER'}">
							<option value="CANCER" selected="selected">1.암보험</option>
							<option value="PENSION">2.연금보험</option>
							<option value="LIFE">3.종신보험</option>
							<option value="ACTUALEXPENSE">4.실비보험</option>
						</c:when>
						<c:when test="${type == 'PENSION'}">
							<option value="CANCER" >1.암보험</option>
							<option value="PENSION" selected="selected">2.연금보험</option>
							<option value="LIFE">3.종신보험</option>
							<option value="ACTUALEXPENSE">4.실비보험</option>
						</c:when>
						<c:when test="${type == 'LIFE'}">
							<option value="CANCER" >1.암보험</option>
							<option value="PENSION">2.연금보험</option>
							<option value="LIFE" selected="selected">3.종신보험</option>
							<option value="ACTUALEXPENSE">4.실비보험</option>
						</c:when>
						<c:when test="${type == 'ACTUALEXPENSE'}">
							<option value="CANCER" >1.암보험</option>
							<option value="PENSION">2.연금보험</option>
							<option value="LIFE">3.종신보험</option>
							<option value="ACTUALEXPENSE" selected="selected">4.실비보험</option>
						</c:when>
					</c:choose>
				</select>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">보험이름</span> <input
					type="text" class="form-control" id="productName"
					placeholder="InsuranceName" name="productName" required>
				<button class="btn btn-primary" type="button">Check Name</button>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">납입기간</span> <input
					type="text" class="form-control" id="paymentPeriod"
					placeholder="Enter paymentperiod" name="paymentPeriod" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">납입주기</span> <input
					type="text" class="form-control" id="paymentCycle"
					placeholder="Enter paymentcycle" name="paymentCycle" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">기본보험료</span> <input
					type="text" class="form-control" id="basicInsurancePremium"
					placeholder="Enter basicinsurancepremium"
					name="basicInsurancePremium" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">보험금</span> <input
					type="text" class="form-control" id="insuranceMoney"
					placeholder="Enter insurancemoney" name="insuranceMoney" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<c:choose>
				<c:when test="${type == 'CANCER'}">
					<div class="input-group mb-3 mt-3 input_interval">
						<span class="input-group-text input_span">보장종류</span> <select
							class="form-select" id="guaranteedType"
							name="guaranteedType">
							<option value="PANCREATIC">1.췌장암</option>
							<option value="LUNG">2.폐암</option>
							<option value="STOMACH">3.위암</option>
							<option value="COLORECTAL">4.대장암</option>
							<option value="LIVER">5.간암</option>
							<option value="ETC">6.기타</option>
						</select>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">제한나이</span> <input
							type="number" class="form-control" id="limitAge"
							placeholder="Enter limitage" name="limitAge" required
							pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
				</c:when>
				<c:when test="${type == 'PENSION'}">
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">보장기간</span> <input
							type="number" class="form-control" id="guaranteedPeriod"
							placeholder="Enter guaranteedPeriod" name="guaranteedPeriod"
							required pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
				</c:when>
				<c:when test="${type == 'LIFE'}">
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">필수납입기간</span> <input
							type="number" class="form-control" id="requiredPaymentPeriod"
							placeholder="Enter requiredPaymentPeriod" name="requiredPaymentPeriod"
							required pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
				</c:when>
				<c:when test="${type == 'ACTUALEXPENSE'}">
					<div class="input-group mb-3 mt-3 input_interval">
						<span class="input-group-text input_span">보장종류</span> <select
							class="form-select" id="actualExpenseType"
							name="actualExpenseType">
							<option value="ADMISSION">1.입원</option>
							<option value="HOSPITALTREATMENT">2.병원진료비</option>
							<option value="MEDICINEPRESCRIPTION">3.약처방비</option>
						</select>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">보장한도</span> <input
							type="number" class="form-control" id="limitOfIndemnity"
							placeholder="Enter limitOfIndemnity" name="limitOfIndemnity"
							required pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">제한나이</span> <input
							type="number" class="form-control" id="limitAge"
							placeholder="Enter limitage" name="limitAge" required
							pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">자기부담금</span> <input
							type="number" class="form-control" id="selfPayment"
							placeholder="Enter selfPayment" name="selfPayment" required
							pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
				</c:when>
			</c:choose>
			<div class="d-grid">
				<input type="submit" class="btn btn-outline-primary"
					value="Develop Insurance">
			</div>
		</form>
	</div>
</body>
</html>