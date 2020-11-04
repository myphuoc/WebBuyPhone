<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
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
		<h1 style="text-align: center; color: red">Update of Customer </h1> 
		<form class="container-fluid" action="/WebBuyPhone/CustomerController" method="post">
				
				
				  <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Full Name</label>
				    <input type="text" class="form-control" value="${inforProduct.getFullName()}" name="FullName" placeholder="Full Name">
				  </div>
				  </div>
				  <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Address</label>
				    <input type="text" class="form-control" value="${inforProduct.getAdress()}" name="Adress" placeholder="Address">
				  </div>	
				</div>
				  <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputEmail4">Email</label>
				      <input type="email" class="form-control" value="${inforProduct.getEmaill()}"  name="Emaill" placeholder="Email">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Phone</label>
				      <input type="number" class="form-control" value="${inforProduct.getPhone()}"name="Phone"  placeholder="Phone">
				    </div>
				  </div>
				  <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Passport</label>
				    <input type="text" class="form-control" value="${inforProduct.getPassport()}" name="Passport" placeholder="Passport">
				  </div>
				  </div>
				    <div class="form-row">
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Birthday</label>
				  <input type="date" required class="form-control input-container" id="birthday" 
				value="${inforProduct.getBirthday()}"  name="Birthday" placeholder="Birthday">
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
				  <button type="submit" class="btn btn-primary">Save</button>
				    <input type="hidden" name="command" value="UpdateCustomer" />
				</div>
				 
		</form>
		 <jsp:include page="footer.jsp" />				
</body>
</html>

