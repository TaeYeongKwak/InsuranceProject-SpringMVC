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
    <title>고객 상세 정보 수정</title>
</head>

<fieldset>

<legend>회원정보 수정</legend>
	<form action="client/InfoModify" method="post" name="fr">
		이름 <input type="text" name="name" value="${client.name } "><br>
		나이 <input type="text" name="age" value="${client.age } "><br>
		성별 <input type="text" name="gender" value="${client.gender } "><br>
		아이디 <input type="text" name="id" value="${client.id }" readonly><br>
		비밀번호 <input type="password" name="passWord" placeholder="변경할 비밀번호를 입력하세요" required><br>
		휴대폰 번호 <input type="text" name="phoneNumber" value="${client.phoneNumber } "><br>
		이메일 <input type="text" name="email" value="${client.email } "><br>
		주민번호 <input type="text" name="residentRegistrationNumber " value="${client.residentRegistrationNumber } "><br>
		주소 <input type="text" name="address" value="${client.address } "><br>
		은행계좌번호 <input type="text" name="bankAccountNumber" value="${client.bankAccountNumber } "><br>
		직업 <input type="text" name="job" value="${client.job } "><br>
		
		<input type="submit" class="btn" value="고객정보수정">
		<input type="button" class="btn" value="Home" onclick="location.href='home'">
	</form>
</fieldset>
</body>
</html>