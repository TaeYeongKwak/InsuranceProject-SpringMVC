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
    <title>사고 목록</title>
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
<jsp:include page="header.jsp"></jsp:include>
    <div class="list_container">
        <h2>사고 목록 조회</h2>
        <select class="form-select select_style" onchange="location.href=this.value">
        <c:choose>
			<c:when test="${type == 'CANCER'}">
				<option value="${pageContext.request.contextPath}/accident/list/CANCER" selected="selected">1.암보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/PENSION">2.연금보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/LIFE">3.종신보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/ACTUALEXPENSE">4.실비보험</option>
			</c:when>
			<c:when test="${type == 'PENSION'}">
				<option value="${pageContext.request.contextPath}/accident/list/CANCER" >1.암보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/PENSION" selected="selected">2.연금보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/LIFE">3.종신보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/ACTUALEXPENSE">4.실비보험</option>
			</c:when>
			<c:when test="${type == 'LIFE'}">
				<option value="${pageContext.request.contextPath}/accident/list/CANCER" >1.암보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/PENSION">2.연금보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/LIFE" selected="selected">3.종신보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/ACTUALEXPENSE">4.실비보험</option>
			</c:when>
			<c:when test="${type == 'ACTUALEXPENSE'}">
				<option value="${pageContext.request.contextPath}/accident/list/CANCER" >1.암보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/PENSION">2.연금보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/LIFE">3.종신보험</option>
				<option value="${pageContext.request.contextPath}/accident/list/ACTUALEXPENSE" selected="selected">4.실비보험</option>
			</c:when>
		</c:choose>
		</select>
        <table class="table table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <th width="150px">회원이름</th>
                <th width="400px">보험상품명</th>
                <th width="200px">접수날짜</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="accident" items="${accidentList}">
		            <tr onclick = "location.href='${pageContext.request.contextPath}/accident/${accident.accidentNum}'">
		            	<td>${accident.client.name}</td>
		                <td>${accident.insuranceProduct.productName }</td>
		                <td>${accident.receptionDate }</td>
		            </tr>
	            </c:forEach>
            </tbody>
          </table>
    </div>
</body>
</html>