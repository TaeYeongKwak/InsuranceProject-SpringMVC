<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
   rel="stylesheet">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>apply accident</title>
</head>
<style>
.row{
margin-top: 100px;
}
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
   <div class="container">
      <div class="row">
         <form accept-charset="utf-8" method="POST" action="${pageContext.request.contextPath}/accident/apply/add" >
            <table class="table table-striped"
               style="text-align: center; border: 2px solid #dddddd">
               <thead>
                  <tr>
                     <th colspan="2"style="background-color: #eeeeee; text-align: center;">사고접수 신청하기</th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td><textarea placeholder="사고 내용" name="accidentDetail" maxlength="2048" style="height: 350px; width:100%"></textarea></td>
                  </tr>
               </tbody>
            </table>
            <input type="hidden" name="productName" value="${productName}"/>
            <button type="button" onclick="history.back()" class="btn btn-danger" style="float:right; margin-left:10px;">뒤로가기</button>
			<button type="submit" class="btn btn-primary" style="float:right">작성완료</button>
         </form>
      </div>
   </div> 
</body>
</html>