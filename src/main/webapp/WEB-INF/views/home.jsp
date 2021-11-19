<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  ${client.id} </P>
<P>  ${client.password} </P>
<P>  ${manager.id} </P>
<P>  ${manager.password} </P>
</body>
</html>
