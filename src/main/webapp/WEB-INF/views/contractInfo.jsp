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
<jsp:include page="header.jsp"></jsp:include>
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
            <span class="input-group-text">회원암경력</span>
            <div class="form-control" >${contract.client.medicalHistory.clientCancerCareer.cancerName }</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">가족암경력</span>
            <div class="form-control" >${contract.client.medicalHistory.familyCancerCareer.cancerName }</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">입원수</span>
            <div class="form-control" >${contract.client.medicalHistory.numberOfHospitalizations }</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">병원진료수</span>
            <div class="form-control" >${contract.client.medicalHistory.numberOfHospitalVisits }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">가입한 보험</span>
            <div class="form-control" >${contract.insuranceProduct.productName }</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">보험종류</span>
            <div class="form-control" >${contract.insuranceProduct.insuranceProductType.insuranceName }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">기본보험료</span>
            <div class="form-control" >${contract.insuranceProduct.basicInsurancePremium }원</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">보험금</span>
            <div class="form-control" >${contract.insuranceProduct.insuranceMoney }원</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">납입기간</span>
            <div class="form-control" >${contract.insuranceProduct.paymentCycle }년</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">납입주기</span>
            <div class="form-control" >매월 ${contract.insuranceProduct.paymentPeriod }일</div>
        </div>
		<c:choose>
			<c:when test="${contract.insuranceProduct.insuranceProductType == 'ACTUALEXPENSE'}">
				<div class="input-group mb-3">
	            	<span class="input-group-text">자기부담금</span>
	            	<div class="form-control" >${contract.insuranceProduct.selfPayment }원</div>
        		</div>

		        <div class="input-group mb-3">
		            <span class="input-group-text">보장종류</span>
		            <div class="form-control" >${contract.insuranceProduct.actualExpenseType.actualexpensename }</div>
		        </div>
		        
		        <div class="input-group mb-3">
		            <span class="input-group-text">제한나이</span>
		            <div class="form-control" >${contract.insuranceProduct.limitAge }세</div>
		        </div>
		        
		        <div class="input-group mb-3">
		            <span class="input-group-text">보장한도</span>
		            <div class="form-control" >${contract.insuranceProduct.limitOfIndemnity }원</div>
		        </div>
			</c:when>
			<c:when test="${contract.insuranceProduct.insuranceProductType == 'CANCER'}">
				<div class="input-group mb-3">
		            <span class="input-group-text">제한나이</span>
		            <div class="form-control" >${contract.insuranceProduct.limitAge }세</div>
		        </div>
		        
		        <div class="input-group mb-3">
		            <span class="input-group-text">보장종류</span>
		            <div class="form-control" >${contract.insuranceProduct.guaranteedType.cancerName }</div>
		        </div>
			</c:when>
			<c:when test="${contract.insuranceProduct.insuranceProductType == 'PENSION'}">
			 	<div class="input-group mb-3">
		            <span class="input-group-text">보장기간</span>
		            <div class="form-control" >${contract.insuranceProduct.guaranteedPeriod }세</div>
		        </div>
			</c:when>
			<c:when test="${contract.insuranceProduct.insuranceProductType == 'LIFE'}">
				<div class="input-group mb-3">
		            <span class="input-group-text">필수납입기간</span>
		            <div class="form-control" >${contract.insuranceProduct.requiredPaymentPeriod }년</div>
		        </div>
			</c:when>
		</c:choose>

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
        		<a href="${pageContext.request.contextPath}/contract/underwrite?clientId=${contract.client.id}&productName=${contract.insuranceProduct.productName}" class="btn btn-primary">
		            승인하기
		        </a>
		        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/contract/delete?clientId=${contract.client.id}&productName=${contract.insuranceProduct.productName}'">
		            승인거절
		        </button>
        	</c:when>
        	<c:when test="${mode == 'expire'}">
        		<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/contract/delete?clientId=${contract.client.id}&productName=${contract.insuranceProduct.productName}'">
		            만기된 고객 삭제
		        </button>
		        <button class="btn btn-primary" onclick="history.back()">
		            돌아가기
		        </button>
        	</c:when>
        	<c:when test="${mode == 'client'}">
        		<a href='${pageContext.request.contextPath}/contract/delete?clientId=${contract.client.id}&productName=${contract.insuranceProduct.productName}' class="btn btn-primary"> 보험 해지하기 </a>
		        <a href="${pageContext.request.contextPath}/contract/info/pay?productName=${contract.insuranceProduct.productName}" class="btn btn-primary" >
		            보험료 납부하기
		        </a>
		        <a href="${pageContext.request.contextPath}/accident/apply?productName=${contract.insuranceProduct.productName}" class="btn btn-primary" >
		            사고 접수하기
		        </a>
        	</c:when>
        </c:choose>
    </div>
</body>
</html>