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
.menu{
    width: 100%;
    list-style: none;
    text-align: center;
    border-bottom:2px solid #d49466;
    background-color: #4B0082;
    
}
.menu li{
    display: inline-block;
    line-height: 136px;
}
.menu li a{
    color: #d49466;
    text-decoration: none;
    font-size: 24px;
    margin-right: 40px;
}
.menu li a:hover{
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
							<li class="active"><a href="#">Main</a></li>
							<li><a href="developedInsuranceList">InsuranceList</a></li>
							<li><a href="login">Login</a></li>
							<li><a href="#">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<div class="sign_up_container">
		<h1>Develop Insurance Page</h1>
		<form action="#" class="was-validated" method="post">
			<div class="input-group mb-3 mt-3 input_interval">
				<span class="input-group-text input_span">Insurance</span> <select
					class="form-select" id="insurance" name="insurance">
					<option>1.암보험</option>
					<option>2.연금보험</option>
					<option>3.종신보험</option>
					<option>4.실비보험</option>
				</select>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">InsuranceName</span> <input
					type="text" class="form-control" id="insuranceName"
					placeholder="InsuranceName" name="insuranceName" required
					pattern="^[a-zA-Z0-9]+$">
				<button class="btn btn-primary" type="button">Check Name</button>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">Payment Period</span> <input
					type="text" class="form-control" id="paymentperiod"
					placeholder="Enter paymentperiod" name="paymentperiod" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">Payment Cycle</span> <input
					type="text" class="form-control" id="paymentcycle"
					placeholder="Enter paymentcycle" name="paymentcycle" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">Limit Age</span> <input
					type="text" class="form-control" id="limitage" placeholder="Enter limitage"
					name="limitage" required pattern="^[0-9]+$">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">BasicInsurancePremium</span> <input
					type="text" class="form-control" id="basicinsurancepremium"
					placeholder="Enter basicinsurancepremium" name="basicinsurancepremium" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="input-group mb-3 mt-3">
				<span class="input-group-text input_span">InsuranceMoney</span> <input
					type="text" class="form-control" id="insurancemoney"
					placeholder="Enter insurancemoney" name="insurancemoney" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="d-grid">
				<input type="submit" class="btn btn-outline-primary" value="Develop Insurance">
			</div>
		</form>
	</div>
</body>
</html>