<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="header">
		<div class="menu">
			<div class="menu-area">
				<div class="limit-box">
					<nav class="main-menu">
						<ul class="menu-area-main">
							<c:choose>
								<c:when test="${sessionScope.manager.jobPosition == 'IP'}">
									<li class="active"><a href="${pageContext.request.contextPath}/manager/menu">Main</a></li>
									<li><a href="${pageContext.request.contextPath}/product/design/CANCER">보험 설계하기</a></li>
									<li><a href="#">보험 관리하기</a></li>
									<li><a href="${pageContext.request.contextPath}/manager/Info">My Page</a></li>
								</c:when>
								<c:when test="${sessionScope.manager.jobPosition == 'IPA'}">
									<li class="active"><a href="${pageContext.request.contextPath}/manager/menu">Main</a></li>
									<li><a href="${pageContext.request.contextPath}/product/list/acceptance">보험 승인하기</a></li>
									<li><a href="#">보험 삭제하기</a></li>
									<li><a href="${pageContext.request.contextPath}/manager/Info">My Page</a></li>
								</c:when>
								<c:when test="${sessionScope.manager.jobPosition == 'UW'}">
									<li class="active"><a href="${pageContext.request.contextPath}/manager/menu">Main</a></li>
									<li><a href="${pageContext.request.contextPath}/contract/list/uw">인수심사하기</a></li>
									<li><a href="${pageContext.request.contextPath}/manager/Info">My Page</a></li>
								</c:when>
								<c:when test="${sessionScope.manager.jobPosition == 'CM'}">
									<li class="active"><a href="${pageContext.request.contextPath}/manager/menu">Main</a></li>
									<li><a href="#">보험계약 관리하기</a></li>
									<li><a href="#">만기계약 관리하기</a></li>
									<li><a href="${pageContext.request.contextPath}/manager/Info">My Page</a></li>
								</c:when>
								<c:when test="${sessionScope.manager.jobPosition == 'CH'}">
									<li class="active"><a href="${pageContext.request.contextPath}/manager/menu">Main</a></li>
									<li><a href="${pageContext.request.contextPath}/accident/list/CANCER">사고처리</a></li>
									<li><a href="${pageContext.request.contextPath}/manager/Info">My Page</a></li>
								</c:when>
								<c:when test="${sessionScope.manager.jobPosition == 'SP'}">
									<li class="active"><a href="${pageContext.request.contextPath}/manager/menu">Main</a></li>
									<li><a href="#">영업 활동 관리</a></li>
									<li><a href="${pageContext.request.contextPath}/product/list/salesperson">계약 가능한 보험목록</a></li>
									<li><a href="${pageContext.request.contextPath}/manager/Info">My Page</a></li>
								</c:when>
								<c:when test="${sessionScope.client != null}">
									<li class="active"><a href="${pageContext.request.contextPath}/client/menu">Main</a></li>
									<li><a href="${pageContext.request.contextPath}/contract/list/client">가입한 보험 조회</a></li>
									<li><a href="${pageContext.request.contextPath}/client/info">My Page</a></li>
								</c:when>
							</c:choose>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>