<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head >
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>main</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container pt-3">
	<div class="row">
            <div class="col-sm-4">
                <div class="card shadow p-4 mb-4 bg-white" style="width:100%">
                    <div class="card-body">
                  <c:choose>
                     <c:when test="${manager != null }">
                        <h2 class="card-title">${manager.jobPosition.job }</h2>
                              <br><h5 class="card-text">Name: ${manager.name }</h5>
                              <h5 class="card-text">HP: ${manager.phoneNumber }</h5>
                              <a href="${pageContext.request.contextPath}/manager/Info" class="btn btn-primary">See Profile</a>
                     </c:when>
                     <c:otherwise>
                        <h5 class="card-title">${client.name} 고객님</h5>
                              <br><h5 class="card-text">Email: ${client.email }</h5>
                              <h5 class="card-text">HP: ${client.phoneNumber }</h5>
                              <a href="${pageContext.request.contextPath}/client/info" class="btn btn-primary">See Profile</a>
                     </c:otherwise>
                  </c:choose>
                    </div>
                </div>
                <p>---------------------------------------------------------------</p>
				<h3>사이드 메뉴</h3>
				<p>사이드 메뉴를 통해 빠르게 이용해보세요.</p>
				<c:forEach var="work" items="${workList}">
					<ul class="list-group">
						<li class="list-group-item list-group-item-action"><a href="${pageContext.request.contextPath}${work.url}">${work.name }</a></li>
              		</ul>
               </c:forEach>
            </div>
            <div class="col-sm-8 test">
            	<img src="${pageContext.request.contextPath}/resources/img/2.jpg" alt="" />
            </div>
    </div>
</div>
</body>
</html>