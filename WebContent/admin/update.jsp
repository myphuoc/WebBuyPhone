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

<title>Update Product</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">

<!-- Timeline CSS -->
<link href="css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/startmin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%
Cookie[] theCookiesLoopLogin= request.getCookies();
boolean checkLoginAdmin=false;
if(theCookiesLoopLogin!=null)//khi giÃ¡ trá»‹ = null thÃ¬ nÃ³ sáº½ khÃ´ng tá»“n táº¡i
{
	for(Cookie tempCookie:theCookiesLoopLogin)
	{
		if("checkLoginPageAdmin".equals(tempCookie.getName())&&"true".equals(tempCookie.getValue()))
		{
			checkLoginAdmin=true;
			break;
		}
	}
}
 if(!checkLoginAdmin)
 {
	 response.sendRedirect("loginPageAdmin.jsp");
 }



%>
<jsp:include page="/admin/Header/navbar.jsp"></jsp:include>
	<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Page Update</h1>
		</div>
	</div>

	<!-- ... Your content goes here ... -->
	<form class="container-fluid" action="/WebBuyPhone/pageController"
		method="post">
		
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputEmail4">ID</label>
				
				<input type="text" class="form-control" name="IdProduct" value="${inforProduct.getId()}"
					disabled="disabled" placeholder="ID Product">

			</div>
			<div class="form-group col-md-6">
				<label for="inputPassword4">Name</label> <input type="text"
				class="form-control" name="NameProduct" value="${inforProduct.getName()}"placeholder="Name Product">
			</div>
		</div>
		<div class="form-group col-md-12">
			<label for="inputAddress">Manufacturer</label>
			
			<input type="text" class="form-control" name="Manufacturer" id="nameManufacturer"disabled="disabled"	
			value="${inforProduct.getManufacturer()}"
				placeholder="Manufacturer Product">
		</div>
		<div class="form-group col-md-12">
			<label for="inputAddress2">Price</label> <input type="number"
				class="form-control" name="PriceProduct"value="${inforProduct.getPrice()}" placeholder="Price Product">
		</div>
		<div class="form-row">
			<div class="form-group col-md-3">
				<label for="inputEmail4">Screen</label> <input type="text"
					class="form-control" name="Screen"value="${inforProduct.getScreen()}" placeholder="Screen Product">
			</div>
			<div class="form-group col-md-3">
				<label for="inputPassword4">Operating system</label> <input
					type="text" class="form-control" name="Operating"value="${inforProduct.getOperating()}"
					placeholder="operating  Product">
			</div>
			<div class="form-group col-md-3">
				<label for="inputEmail4">Rear camera</label> <input type="text"
					class="form-control" name="Rearcamera"value="${inforProduct.getRearcamera()}" placeholder="Rear camera">
			</div>
			<div class="form-group col-md-3">
				<label for="inputPassword4">Front camera</label> <input type="text"
					class="form-control" name="Frontcamera"value="${inforProduct.getfontCamera()}" placeholder="Front camera">
			</div>
		</div>

		<div class="form-row">
			<div class="form-group col-md-3">
				<label for="inputEmail4">CPU</label> <input type="text"
					class="form-control" name="CPUProduct"value="${inforProduct.getCPU()}" placeholder="CPU Product">
			</div>
			<div class="form-group col-md-3">
				<label for="inputPassword4">RAM</label> <input type="text"
					class="form-control" name="RamProduct"value="${inforProduct.getRAM()}" placeholder="RAM Product">
			</div>
			<div class="form-group col-md-3">
				<label for="inputPassword4">Internal memory</label> <input
					type="text" class="form-control" name="Internalmemory"value="${inforProduct.getInternalmemory()}"
					placeholder="Internal memory">
			</div>
			<div class="form-group col-md-3">
				<label for="inputPassword4">Memory Stick</label> <input type="text"
					class="form-control" name="MemoryStick"value="${inforProduct.getMemoryStick()}" placeholder="Memory Stick">
			</div>


		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputEmail4">SIM</label> <input type="text"
					class="form-control" name="SimProduct"value="${inforProduct.getSim()}" placeholder="Sim Product">
			</div>
			<div class="form-group col-md-6">
				<label for="inputPassword4">Battery capacity</label> <input
					type="text" class="form-control" name="Batterycapacity"value="${inforProduct.getBatterycapacity()}"
					placeholder=" Battery capacity">
			</div>
		</div>
		<div class="form-group col-md-12">
			<label for="inputAddress2">New feature</label> <input type="text"
				class="form-control" name="Newfeature" value="${inforProduct.getNewfeature()}"placeholder="New feature">
		</div>
		<div class="form-group col-md-12">
			<label for="inputAddress2">Details</label> <input type="text"
				class="form-control" name="detailsProduct"value="${inforProduct.getDetails()}" placeholder="Details">
		</div>
		<div class="form-group col-md-12">
			<label for="inputAddress2">Image Link</label> <input type="file"
				style="width: 40%" name="linkImage" id="link" onchange="onchangeImage()"value="${inforProduct.getImageLink()}">
		</div>
	
		<div class="form-group col-md-12">
				  	<label>Image Product:</label>
				  </div>
				  <div class="form-group col-md-12">
				  	<img style="width: 200px;height: 200px" id="imgProduct" src="Image/${inforProduct.getImageLink()}"/>
				  	<input type="hidden" name="linkIMG" id="imgHidden">
				  </div>
    	<script type="text/javascript">
    	document.getElementById("imgHidden").value="${inforProduct.getImageLink()}";
    	function onchangeImage() {
    		 var pathManufacturer=document.getElementById("nameManufacturer").value;
    		  var pathImg=document.getElementById("link").files[0].name;
	
			  document.getElementById("imgProduct").src="Image/"+pathImg;
			  document.getElementById("imgHidden").value=pathImg;
		}
   
    
    </script>
		<div class="form-group col-md-12">
			<button type="submit" class="btn btn-primary">Save</button>
			<input type="hidden" name="command" value="UPDATE" />
		</div>
	</form>

	<div class="container-fluid"></div>
</div>
</body>
</html>