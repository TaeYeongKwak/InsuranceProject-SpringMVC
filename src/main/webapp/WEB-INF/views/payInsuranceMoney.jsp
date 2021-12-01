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
    <title>보험료 납부</title>
    <style>
        .list_container{
            margin: 10px auto;
            margin-top: 5%;
            margin-bottom: 10%;
            
            width: 800px;
        }
        h2{
            text-align: center;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="list_container">
        <h2>보험료 납부 현황</h2>
        <div class="table-responsive">
            <table class="table table-hover" style="text-align: center; border: 1px solid #dddddd">
                <thead>
                    <tr>
                      <th>1월</th>
                      <th>2월</th>
                      <th>3월</th>
                      <th>4월</th>
                      <th>5월</th>
                      <th>6월</th>
                      <th>7월</th>
                      <th>8월</th>
                      <th>9월</th>
                      <th>10월</th>
                      <th>11월</th>
                      <th>12월</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <c:forEach var = "month" items="${contract.month }">
                      	<td>
                      	<c:choose>
                      		<c:when test="${month }">O</c:when>
                      		<c:otherwise>X</c:otherwise>
                      	</c:choose>
                      	</td>
                      </c:forEach>
                    </tr>
                  </tbody>
            </table>
        </div>
        <div class="input-group mb-3 mt-3">
            <span class="input-group-text input_span">납부할 금액</span>
            <span class="form-control">${insuranceMoney }원</span>
            <span class="input-group-text input_span">납부할 달</span>
            <span class="form-control">${toMonth }월</span>
            <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/contract/pay?month=${toMonth }&productName=${contract.insuranceProduct.productName }'">보험료 납부하기</button>
        </div>
    </div>
</body>
</html>