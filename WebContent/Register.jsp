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
	
		input[type="date"]::-webkit-calendar-picker-indicator {
		    background: transparent;
		    bottom: 0;
		    color: transparent;
		    cursor: pointer;
		    height: auto;
		    left: 0;
		    position: absolute;
		    right: 0;
		    top: 0;
		    width: auto;
		}
	</style>
</head>
<body >
<jsp:include page="header.jsp" />
		<h1 style="text-align: center; color: blue">Form Register </h1> 
		<form class="container-fluid" action="CustomerController" method="get">
				  <input type="hidden" name="command" value="AddCustomer" />
				  <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Username</label>
				    <input type="text" class="form-control" name="UserName" placeholder="Username">
				  </div>
				  </div>
				  <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputEmail4">Password</label>
				      <input type="password" class="form-control"  name="Passwork" placeholder="Password">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Confirm Password</label>
				      <input type="password" class="form-control" name="ConfirmPassword"  placeholder="Confirm Password">
				    </div>
				  </div>
				  <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Full Name</label>
				    <input type="text" class="form-control" name="FullName" placeholder="Full Name">
				  </div>
				  </div>
				  <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Address</label>
				    <input type="text" class="form-control" name="Adress" placeholder="Address">
				  </div>	
				</div>
				  <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputEmail4">Email</label>
				      <input type="email" class="form-control"  name="Emaill" placeholder="Email">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Phone</label>
				      <input type="number" class="form-control" name="Phone"  placeholder="Phone">
				    </div>
				  </div>
				  <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Passport</label>
				    <input type="text" class="form-control" name="Passport" placeholder="Passport">
				  </div>
				  </div>
				    <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Birthday</label>
				  <input type="date" required class="form-control input-container" id="birthday" 
				  name="Birthday" placeholder="Birthday">
				  </div>
				  </div>
				<label for="inputCity">Sex</label><br>
		  <div class="form-check-inline">
		  
		      <label class="form-check-label" for="radio1">
		        <input type="radio" class="form-check-input" id="Male" name="Sex" value="Male" checked>Male
		      </label>
		    </div>
		    <div class="form-check-inline">
		      <label class="form-check-label" for="radio2">
		        <input type="radio" class="form-check-input" id="Female" name="Sex" value="Female">Female
		      </label>
		  </div>

				 
				<div class="form-group col-md-12">
				  <button type="submit" class="btn btn-primary">Register</button>
				</div>
				 
		</form>
		  
		  
		  <jsp:include page="footer.jsp" />		
</body>
</html>

