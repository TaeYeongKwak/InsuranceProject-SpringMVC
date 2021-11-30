<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Message</title>

</head>

<body>p
</body>

<script>
   window.onload = function() {
      var message = "<c:out value="${message}" />";
      var resultPage = "<c:out value="${resultPage}" />";
      alert(message);
      location.href = "<c:out value="${pageContext.request.contextPath}" />"
            + '/' + resultPage;
   };
</script>

</html>