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
    <title>계약 상세 정보</title>
    <style>
        .info_container{
            margin: 10px auto;
            margin-top: 5%;
            margin-bottom: 10%;
            
            width: 800px;
        }
        .content{
            display: block;
            min-height: 300px;
            padding: 10px;
            font-size: larger;
            word-break:break-all
        }
        h2{
            text-align: center;
            margin: 30px;
        }
    </style>
</head>
<body>
    <div class="info_container">
        <h2>계약 상세 정보</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">고객이름</span>
            <div class="form-control" >${contract.client.name }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">고객나이</span>
            <div class="form-control" >${contract.client.age }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">가입한 보험</span>
            <div class="form-control" >${contract.insuranceProduct.productName }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">가입한 날짜</span>
            <div class="form-control" >${contract.insuranceContractDate }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">만기 날짜</span>
            <div class="form-control" >${contract.insuranceExpiryDate }</div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">영업사원</span>
            <div class="form-control" >${contract.salesPerson.name }</div>
        </div>

        <c:choose>
        	<c:when test="${mode == 'uw'}">
        		<button class="btn btn-primary">
		            승인하기
		        </button>
		        <button class="btn btn-primary">
		            승인거절
		        </button>
        	</c:when>
        	<c:when test="${mode == 'expire'}">
        		<button class="btn btn-primary">
		            만기된 고객 삭제
		        </button>
		        <button class="btn btn-primary">
		            돌아가기
		        </button>
        	</c:when>
        </c:choose>
    </div>
</body>
</html>