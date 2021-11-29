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
<style>
.work_menu {
	padding: 0px;
	margin-left: 35px;
	background-color: white;
	width: 33%;
	height: 50%;
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
<c:choose>
<c:when test="${manager.jobPosition == 'IP'}">
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a
								href="${pageContext.request.contextPath}/manager/menu">Main IP</a></li>
							<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="${pageContext.request.contextPath}/Design">보험 설계하기</a></li>
							<li><a href="#">보험 관리하기</a></li>
							<li><a href="#">My Page</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${manager.jobPosition == 'IPA'}">
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a
								href="${pageContext.request.contextPath}/manager/menu">Main IPA</a></li>
							<li><a href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="#">보험 승인하기</a></li>
							<li><a href="#">보험 삭제하기</a></li>
							<li><a href="#">금융감독원에 이메일 보내기</a></li>
							<li><a href="#">My Page</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${manager.jobPosition == 'UW'}">
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a
								href="${pageContext.request.contextPath}/manager/menu">Main UW</a></li>
							<li><a href="#">인수심사하기</a></li>
							<li><a href="#">My Page</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${manager.jobPosition == 'CM'}">
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a
								href="${pageContext.request.contextPath}/manager/menu">Main UW</a></li>
							<li><a href="#">보험계약 관리하기</a></li>
							<li><a href="#">만기계약 관리하기</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${manager.jobPosition == 'CH'}">
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a
								href="${pageContext.request.contextPath}/manager/menu">Main UW</a></li>
							<li><a href="#">AccidentList</a></li>
							<li><a href="#">사고처리</a></li>
							<li><a href="#">My Page</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${manager.jobPosition == 'SP'}">
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a
								href="${pageContext.request.contextPath}/manager/menu">Main UW</a></li>
							<li><a href="#">영업 활동 관리</a></li>
							<li><a href="#">계약 가능한 보험목록</a></li>
							<li><a href="#">My Page</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
<c:when test="${client != null}">
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<li class="active"><a
								href="${pageContext.request.contextPath}/client/menu">Main</a></li>
							<li><a
								href="${pageContext.request.contextPath}/product/List">InsuranceList</a></li>
							<li><a href="#">AccidentList</a></li>
							<li><a href="#">My Page</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</c:when>
</c:choose>
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
                              <a href="#" class="btn btn-primary">See Profile</a>
                     </c:when>
                     <c:otherwise>
                        <h5 class="card-title">${client.name} 고객님</h5>
                              <br><h5 class="card-text">Email: ${client.email }</h5>
                              <h5 class="card-text">HP: ${client.phoneNumber }</h5>
                              <a href="#" class="btn btn-primary">See Profile</a>
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