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
    <title>의료 기록 정보</title>
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
    <div class="info_container">
        <h2>의료 기록 정보</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">고객 아이디</span>
            <div class="form-control" >${medicalHistory.client.id}</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">고객 암 병력 </span>
            <div class="form-control" >${medicalHistory.clientCancerCareer}</div>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">가족 암 병력</span>
            <div class="form-control" >${medicalHistory.familyCancerCareer}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 입원 횟수</span>
            <div class="form-control" >${medicalHistory.numberOfHospitalization}</div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">고객 병원 방문 횟수</span>
            <div class="form-control" >${medicalHistory.numberOfHospitalVisit}</div>
        </div>
        
  
  
        <input type="button" value="Home" class="btn" onclick="location.href='home'">
    </div>
</body>
</html>