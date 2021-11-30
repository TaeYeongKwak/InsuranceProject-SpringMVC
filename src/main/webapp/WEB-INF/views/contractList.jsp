<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <title>계약 목록</title>
    <style>
        .list_container{
            margin: 10px auto;
            margin-top: 5%;
            margin-bottom: 10%;
            
            width: 1200px;
        }
        th{
            text-align: center;
        }
        .select_style{
            margin-bottom: 30px;
        }
        h2{
            text-align: center;
            margin: 30px;
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
<jsp:include page="header.jsp"></jsp:include>
    <div class="list_container">
        <h2>계약 목록 조회</h2>
        <c:if test="${mode == 'cm' || mode == 'expire'}">
	        <c:choose>
	        	<c:when test="${type == 'ACTUALEXPENSE'}">
	        		<select class="form-select select_style" onchange="location.href=this.value">
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/ACTUALEXPENSE" selected>실비보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/CANCER">암보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/PENSION">연금보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/LIFE">종신보험</option>
			        </select>
	        	</c:when>
	        	<c:when test="${type == 'CANCER'}">
	        		<select class="form-select select_style" onchange="location.href=this.value">
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/ACTUALEXPENSE" >실비보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/CANCER" selected>암보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/PENSION">연금보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/LIFE">종신보험</option>
			        </select>
	        	</c:when>
	        	<c:when test="${type == 'PENSION'}">
	        		<select class="form-select select_style" onchange="location.href=this.value">
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/ACTUALEXPENSE" >실비보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/CANCER">암보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/PENSION" selected>연금보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/LIFE">종신보험</option>
			        </select>
	        	</c:when>
	        	<c:when test="${type == 'LIFE'}">
	        		<select class="form-select select_style" onchange="location.href=this.value">
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/ACTUALEXPENSE" >실비보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/CANCER">암보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/PENSION" >연금보험</option>
			          <option value="${pageContext.request.contextPath}/contract/list/${mode}/LIFE" selected>종신보험</option>
			        </select>
	        	</c:when>
	        
	        </c:choose>
        </c:if>
        <table class="table table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <c:if test="${mode != 'client'}"><th width="150px">회원이름</th></c:if>
                <th width="400px">보험상품명</th>
                <th width="200px">가입날짜</th>
                <th width="200px">승인날짜</th>
                <th width="200px">승인여부</th>
              </tr>
            </thead>
            <tbody>
            	<c:forEach var="contract" items="${contractList}">
		            <tr onclick="location.href='${pageContext.request.contextPath}/contract/info/${mode}?clientId=${contract.client.id }&productName=${contract.insuranceProduct.productName}'">
		            	<c:if test="${mode != 'client'}"><td>${contract.client.name}</td></c:if>
		                <td>${contract.insuranceProduct.productName }</td>
		                <td>${contract.insuranceContractDate }</td>
		                <td>${contract.insuranceExpiryDate }</td>
		                <td>
		                	<c:choose>  
							    <c:when test="${contract.approval == true}">O</c:when>  
							    <c:otherwise>X</c:otherwise>
							</c:choose>
		                </td>
		            </tr>
	            </c:forEach>
            </tbody>
          </table>
    </div>
</body>
</html>