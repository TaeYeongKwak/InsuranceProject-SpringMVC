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
    <title>고객 상세 정보</title>
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
            word-break:break-all;
            margin-bottom: 20px;
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
        <h2>고객 상세 정보</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">고객 이름</span>
            <div class="form-control" >${client.name}</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">고객 나이</span>
            <div class="form-control" >${client.age}</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">성별</span>
            <div class="form-control" >${client.gender? '남자':'여자'}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 아이디</span>
            <div class="form-control" >${client.id}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 비밀번호</span>
            <div class="form-control" >${client.password}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 휴대폰 번호</span>
            <div class="form-control" >${client.phoneNumber}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 이메일</span>
            <div class="form-control" >${client.email}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 주민번호</span>
            <div class="form-control" >${client.residentRegistrationNumber}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 주소</span>
            <div class="form-control" >${client.address}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 은행계좌번호</span>
            <div class="form-control" >${client.bankAccountNumber}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 직업</span>
            <div class="form-control" >${client.job.jobName}</div>
        </div>
    </div>
</body>
</html>