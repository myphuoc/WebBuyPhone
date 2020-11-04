<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

   
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ManuFacture Details</title>

    <!-- Bootstrap Core CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- MetisMenu CSS -->
    <link href="css/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/startmin.css" rel="stylesheet">
      <!-- script-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Morris Charts CSS -->
    <link href="css/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
<title>Product</title>
</head>
<body>
<jsp:include page="/admin/Header/navbar.jsp"></jsp:include>
<div id="page-wrapper">
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1  style="color: green" class="page-header">MANUFACTURE</h1>
                </div>
            </div>
<form class="container-fluid" action="/WebBuyPhone/pageController" method="post">
				  <input type="hidden" name="command" value="AdminMNF" />
  
   <div class="form-group col-md-12">
				    <label for="inputAddress2">Name</label>
				    <input type="text" class="form-control" name="Manufacture" placeholder="Manufacture">
				  </div>
  
  <div class="form-group col-md-12">
			<button type="submit" class="btn btn-primary">Save</button>
			
		</div>
 
 
 
 </form>
 </div>
 </div>
</body>
</html>