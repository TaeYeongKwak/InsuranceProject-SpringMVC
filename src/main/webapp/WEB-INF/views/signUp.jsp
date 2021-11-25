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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>Sign Up</title>
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
</style>
</head>
<body>
	<script>
		function checkMId() {
			const managerId = $("#mid").val();
			console.log(managerId);
			$.ajax({
				url : '${pageContext.request.contextPath}/manager/checkId',
				type : 'GET',
				dataType : 'text',
				contentType : 'text/plain; charset=utf-8;',
				data : {mid : managerId},
				success : function(data) {
					if (data == 1) {
						alert("사용할 수 있는 아이디입니다.")
					} else {
						alert("사용할 수 없는 아이디입니다.")
					}
				},
				error : function() {
				}
			});
		}
	</script>
	<div class="sign_up_container">
		<c:choose>
			<c:when test="${isClient == true}">
				<h1>Client Sign Up</h1>
				<form action="${pageContext.request.contextPath}/client/regist" class="was-validated" method="post">
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">ID</span> <input
							type="text" class="form-control" id="id" placeholder="Enter ID"
							name="id" required pattern="^[a-zA-Z0-9]+$">
						<button class="btn btn-primary" type="button"
							onclick="checkCId();">Check ID</button>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Password</span> <input
							type="text" class="form-control" id="password"
							placeholder="Enter Password" name="password" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">User name</span> <input
							type="text" class="form-control" id="name"
							placeholder="Enter Username" name="name" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Age</span> <input
							type="text" class="form-control" id="age" placeholder="Enter Age"
							name="age" required pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3 input_interval">
						<span class="input-group-text input_span">Email</span> <input
							type="text" class="form-control" id="email"
							placeholder="Enter Email" name="email" required
							pattern="^[a-zA-Z0-9]+$">
					</div>
					<div class="input-group mb-3 mt-3 input_interval">
						<span class="input-group-text input_span">Gender</span>
						<div class="row">
							<div class="col radio_item_container">
								<label class="form-check-label" for="male">남자 <input
									type="radio" id="male" name="gender" value="true" checked></label>
							</div>
							<div class="col radio_item_container">
								<label class="form-check-label" for="female">여자 <input
									type="radio" id="female" name="gender" value="false"></label>
							</div>
						</div>
					</div>
					<div class="input-group mb-3 mt-3 input_interval">
						<span class="input-group-text input_span">Job</span> <select
							class="form-select" id="job" name="job">
							<option value="SOLDIER">1.군인</option>
							<option value="PW">2.생산직</option>
							<option value="AF">3.농립어업</option>
							<option value="DRIVER">4.운전기사</option>
							<option value="ETC">5.기타</option>
						</select>
					</div>
					<div class="input-group mb-3 mt-3 input_interval">
						<span class="input-group-text input_span">Address</span> <input
							type="text" class="form-control" id="address"
							placeholder="Enter Address" name="address" required readonly>
						<button class="btn btn-primary" type="button">주소 찾기</button>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Phone Number</span> <input
							type="text" class="form-control" id="phoneNumber"
							placeholder="Enter Phone Number" name="phoneNumber" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Register Number</span> <input
							type="text" class="form-control" id="residentRegistrationNumber"
							placeholder="Enter First Regist Number"
							name="residentRegistrationNumber" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Bank Number</span> <input
							type="text" class="form-control" id="bankAccountNumber"
							placeholder="Enter Bank Number" name="bankAccountNumber" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="d-grid">
						<input type="submit" class="btn btn-outline-primary"
							value="Sign Up">
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<h1>Manager Sign Up</h1>
				<form action="${pageContext.request.contextPath}/manager/regist" class="was-validated" method="post">
					<div class="input-group mb-3 mt-3 input_interval">
						<span class="input-group-text input_span">Job</span> <select
							class="form-select" id="mjob" name="jobPosition">
							<option value=IP>1.보험상품개발자</option>
							<option value=IP>2.보험상품승인자</option>
							<option value=UW>3.U/W</option>
							<option value=CM>4.계약관리자</option>
							<option value=CH>5.보상처리자</option>
							<option value=SP>6.영업사원</option>
						</select>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">ID</span> <input
							type="text" class="form-control" id="mid" placeholder="Enter ID"
							name="id" required pattern="^[a-zA-Z0-9]+$">
						<button class="btn btn-primary" type="button"
							onclick="checkMId();">Check ID</button>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Password</span> <input
							type="text" class="form-control" id="mpassword"
							placeholder="Enter Password" name="password" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">User name</span> <input
							type="text" class="form-control" id="mname"
							placeholder="Enter Username" name="name" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Age</span> <input
							type="text" class="form-control" id="mage"
							placeholder="Enter Age" name="age" required pattern="^[0-9]+$">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="input-group mb-3 mt-3">
						<span class="input-group-text input_span">Phone Number</span> <input
							type="text" class="form-control" id="mphoneNumber"
							placeholder="Enter Phone Number" name="phoneNumber" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="d-grid">
						<input type="submit" class="btn btn-outline-primary"
							value="Sign Up">
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>

</html>