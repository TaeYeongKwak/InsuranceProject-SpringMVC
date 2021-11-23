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
    <title>Login</title>
    <style>
        .login_container{
            margin: 10px auto;
            margin-top: 10%;

            width: 300px;
        }
        .login_container h1{
            text-align: center;
            margin: 40px;
        }
    </style>
</head>
<body>

    <div class="login_container">
        <h1>Login</h1>
        <ul class="nav nav-tabs nav-justified " role="tablist">
            <li class="nav-item">
              <a class="nav-link active" data-bs-toggle="tab" href="#client_login">Client</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="tab" href="#manager_login">Manager</a>
            </li>
        </ul>
        <div class="tab-content shadow p-4 mb-4 bg-white rounded-1">
            <div id="client_login" class="container tab-pane active">
                <form action = "ClientLogin" method = POST>
                    <div class="form-floating mb-3 mt-3">
                        <input type="text" class="form-control" id="email" placeholder="Enter ID" name="id">
                        <label for="email">ID</label>
                    </div>
                    <div class="form-floating mb-3 mt-3">
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
                        <label for="pwd">Password</label>
                    </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-outline-primary">Login</button>
                        <button type="button" onclick = "location.href='ClientSginUp'" class="btn btn-outline-primary">Sign Up</button>
                    </div>
                </form>
            </div>
    

            <div id="manager_login" class="container tab-pane fade">
                <form action = "ManagerLogin" method = POST>
                    <div class="form-floating mb-3 mt-3">
                        <input type="text" class="form-control" id="email" placeholder="Enter ID" name="id">
                        <label for="email">ID</label>
                    </div>
                    <div class="form-floating mb-3 mt-3">
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
                        <label for="pwd">Password</label>
                    </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-outline-danger">Login</button>
                        <button type="button" onclick = "location.href='ManagerSginUp'" class="btn btn-outline-danger">Sign Up</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>