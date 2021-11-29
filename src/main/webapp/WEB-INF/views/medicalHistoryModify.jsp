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
    <title>의료 기록 수정</title>
</head>

<fieldset>

<legend>의료 기록 수정</legend>
	<form action="medicalHistory/Update" method="post" name="fr">
		아이디 <input type="text" name="id" value="${medicalHistory.client.id }" readonly><br>
		고객 암 병력 <input type="text" name="phoneNumber" value="${medicalHistory.clientCancerCareer } "><br>
		가족 암 병력 <input type="text" name="email" value="${medicalHistory.familyCancerCareer } "><br>
		고객 입원 횟수 <input type="text" name="residentRegistrationNumber " value="${medicalHistory.numberOfHospitalization } "><br>
		고객 병원 방문 횟수 <input type="text" name="address" value="${medicalHistory.numberOfHospitalVisit } "><br>
		
		<input type="submit" class="btn" value="의료기록수정">
		<input type="button" class="btn" value="Home" onclick="location.href='home'">
	</form>
</fieldset>
</body>
</html>