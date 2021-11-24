<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
<script>
	var message = ${message};
	var resultPage = ${resultPage};
	alert(message);
	location.href = resultPage;
</script>
</head>
<body>

</body>
</html>