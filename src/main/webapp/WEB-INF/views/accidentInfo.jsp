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
    <title>사고 상세 정보</title>
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
        <h2>사고 상세 정보</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">작성자</span>
            <div class="form-control" >${accident.client.name }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">보험 상품명</span>
            <div class="form-control" >${accident.insuranceProduct.productName }</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">사고 날짜</span>
            <div class="form-control" >${accident.receptionDate }</div>
        </div>

        <div class="border content">
            ${accident.accidentDetail }
        </div>
        
        <button class="btn btn-primary">
            보험금 지급
        </button>
        <button class="btn btn-primary" onclick="history.back()">
            돌아가기
        </button>
    </div>
</body>
</html>