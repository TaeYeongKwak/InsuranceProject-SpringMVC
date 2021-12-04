<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>Email</title>
    <style>
        .email_container{
            margin: 10px auto;
            margin-top: 5%;
            margin-bottom: 10%;
            
            width: 800px;
        }
        h1{
            text-align: center;
            margin: 60px;
        }
        .email_content{
            width: 100%;
            min-height: 300px;
        }
    </style>
    <script>
    	function formSubmit(){
    		document.getElementById('subBtn').disabled = true;
    		var frm = document.getElementById('emailForm');
    		frm.submit();
    	}
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="email_container">
        <h1>Email Send</h1>
        <form id = "emailForm" method ="POST" action ="${pageContext.request.contextPath}/manager/email/send">
        
            <div class="input-group mb-3 mt-3">
                <span class="input-group-text input_span">보내시는 분</span>
                <input type="email" class="form-control" id="uname" placeholder="Enter Email" name="senderMail" required>
            </div>
            <div class="input-group mb-3 mt-3">
                <span class="input-group-text input_span">받으시는 분</span>
                <input type="email" class="form-control" id="uname" placeholder="Enter Email" name="receiveMail" required>
            </div>
            <div class="input-group mb-3 mt-3">
                <span class="input-group-text input_span">제목</span>
                <input type="text" class="form-control" id="uname" placeholder="Enter Title" name="subject" required>
            </div>
            <div>
            <textarea class="email_content" name="message"></textarea>
            </div>
            <button type = "button" id="subBtn" onclick="formSubmit()" class="btn btn-outline-primary">이메일 전송</button>
        </form>
    </div>
</body>
</html>