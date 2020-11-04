<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css" rel="stylesheet">
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<style type="text/css">
		.login-form-block {
  margin: 50px auto;
  max-width: 340px;
}
h2{
	margin-bottom:10px;
}
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.logo {
    text-align: center;
    margin: 16px 0 10px 0;
}

.logo img {
    width: 40%;
    border-radius: 50%;
}
		
		</style>
<title>LOGIN</title>
</head>
<body>
<jsp:include page="header.jsp" />
	
	<div class="login-form-block">
<h1 style="text-align: center;color: red;font: bold;"> LOGIN</h1>

<form class="container-fluid" action="/WebBuyPhone/CustomerController" method="post">
				  <input type="hidden" name="command" value="LOGIN" />
  <div class="logo">
    <img src="http://www.middleeastgulfjobs.com/images/placeholder.png" alt="logo">
  </div>

  <div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="UserName" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="Passwork" required>
        
    <button type="submit">Login</button>
    
  </div>

  
</form>
</div>
  
		  <jsp:include page="footer.jsp" />		
</body>
</html>