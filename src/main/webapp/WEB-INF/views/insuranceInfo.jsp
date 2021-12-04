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
    <title>insurance info</title>
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
        <h2>보험 상세 정보</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">보험이름</span>
            <div class="form-control" >${insuranceProduct.productName }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">보험종류</span>
            <div class="form-control" >${insuranceProduct.insuranceProductType.insuranceName }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">기본보험료</span>
            <div class="form-control" >${insuranceProduct.basicInsurancePremium }원</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">보험금</span>
            <div class="form-control" >${insuranceProduct.insuranceMoney }원</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">납입기간</span>
            <div class="form-control" >${insuranceProduct.paymentCycle }년</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">납입주기</span>
            <div class="form-control" >매월 ${insuranceProduct.paymentPeriod }일</div>
        </div>
		<c:choose>
			<c:when test="${insuranceProduct.insuranceProductType == 'ACTUALEXPENSE'}">
				<div class="input-group mb-3">
	            	<span class="input-group-text">자기부담금</span>
	            	<div class="form-control" >${insuranceProduct.selfPayment }원</div>
        		</div>

		        <div class="input-group mb-3">
		            <span class="input-group-text">보장종류</span>
		            <div class="form-control" >${insuranceProduct.actualExpenseType.actualexpensename }</div>
		        </div>
		        
		        <div class="input-group mb-3">
		            <span class="input-group-text">제한나이</span>
		            <div class="form-control" >${insuranceProduct.limitAge }세</div>
		        </div>
		        
		        <div class="input-group mb-3">
		            <span class="input-group-text">보장한도</span>
		            <div class="form-control" >${insuranceProduct.limitOfIndemnity }원</div>
		        </div>
			</c:when>
			<c:when test="${insuranceProduct.insuranceProductType == 'CANCER'}">
				<div class="input-group mb-3">
		            <span class="input-group-text">제한나이</span>
		            <div class="form-control" >${insuranceProduct.limitAge }세</div>
		        </div>
		        
		        <div class="input-group mb-3">
		            <span class="input-group-text">보장종류</span>
		            <div class="form-control" >${insuranceProduct.guaranteedType.cancerName }</div>
		        </div>
			</c:when>
			<c:when test="${insuranceProduct.insuranceProductType == 'PENSION'}">
			 	<div class="input-group mb-3">
		            <span class="input-group-text">보장기간</span>
		            <div class="form-control" >${insuranceProduct.guaranteedPeriod }세</div>
		        </div>
			</c:when>
			<c:when test="${insuranceProduct.insuranceProductType == 'LIFE'}">
				<div class="input-group mb-3">
		            <span class="input-group-text">필수납입기간</span>
		            <div class="form-control" >${insuranceProduct.requiredPaymentPeriod }년</div>
		        </div>
			</c:when>
		</c:choose>
		
        <c:choose>
        	<c:when test="${type == 'acceptance'}">
        		<a href = "${pageContext.request.contextPath}/manager/email" class="btn btn-primary">이메일 보내기</a>
        		<a href = "${pageContext.request.contextPath}/product/approval?productName=${insuranceProduct.productName}" class="btn btn-primary">
            		승인하기
        		</a>
        		<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/product/info/delete?productName=${insuranceProduct.productName}'">
            		승인거절
        		</button>
        	</c:when>
        	<c:when test="${type == 'salesperson'}">
        		<form action="${pageContext.request.contextPath}/contract/login" method="POST">
	        		<div class="input-group mb-3 mt-3">
	        			<span class="input-group-text input_span">Client Login</span>
						<input type="text" class="form-control" id="email" placeholder="Enter ID" name="id">
				        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
				        <button type="submit" class="btn btn-primary">보험계약하기</button>
			        </div>
			        <input type="hidden" name = "productName" value = "${insuranceProduct.productName }">
		       </form> 
        	</c:when>
        	<c:when test="${type == 'manage'}">
        		<a href = "${pageContext.request.contextPath}/product/modify/${insuranceProduct.productName}" class="btn btn-primary">
            		수정하기
        		</a>
        	</c:when>
        	<c:when test="${type == 'delete'}">
        		<a href = "${pageContext.request.contextPath}/product/delete?productName=${insuranceProduct.productName}" class="btn btn-primary">
            		삭제하기
        		</a>
        	</c:when>
        </c:choose>
    </div>
</body>
</html>