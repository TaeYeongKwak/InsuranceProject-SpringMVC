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
    </style>
</head>
<body>
    <div class="list_container">
        <h2>계약 목록 조회</h2>
        <c:if test="${mode == 'cm' || mode == 'expire' }">
	        <select class="form-select select_style" onchange="location.href=this.value">
	          <option value="#1">실비보험</option>
	          <option value="#2">암보험</option>
	          <option value="#3">연금보험</option>
	          <option value="#4">종신보험</option>
	        </select>
        </c:if>
        <table class="table table-bordered">
            <thead>
              <tr>
                <th width="150px">회원이름</th>
                <th width="400px">보험상품명</th>
                <th width="200px">가입날짜</th>
                <th width="200px">승인날짜</th>
                <th width="200px">승인여부</th>
              </tr>
            </thead>
            <tbody>
            	<c:forEach var="contract" items="${contractList}">
		            <tr>
		            	<td>${contract.client.name}</td>
		                <td>${contract.insurance.productName }</td>
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