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

    <title>Product Details</title>

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
<style type="text/css">
.hero-image {
 background-color: #cccccc;
  height: 100px;
  width:120px;
background-repeat:no-repeat;
background-size:contain;
background-position:center;

  }
  
</style>
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
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Page Details</h1>
                </div>
            </div>

            <!-- ... Your content goes here ... -->
			<form class="container-fluid" action="/WebBuyPhone/pageController" method="post">
			<input type="hidden" name="command" value="LIST" />
				  <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputEmail4">ID</label>
				     
				      <input type="text" class="form-control"  name="IdProduct" 
				       
				      placeholder="ID Product">
				   
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Name</label>
				      <input type="text" class="form-control" name="NameProduct"  placeholder="Name Product">
				    </div>
				  </div>
				  <div class="form-group col-md-12">
				    <label for="inputAddress">Manufacturer</label>
				    <%
				    String manufacturer=null;
				    		Cookie[] theCookiesLoop= request.getCookies();
				    		if(theCookiesLoop!=null)//khi giá trị = null thì nó sẽ không tồn tại
				    		{
				    			for(Cookie tempCookie:theCookiesLoop)
				    			{
				    				if("tagProduct".equals(tempCookie.getName()))
				    				{
				    					manufacturer=tempCookie.getValue();
				    					break;
				    				}
				    			}
				    		}
				    %>
				    <input type="text" class="form-control" name="Manufacturer" id="nameManufacturer"
				    value=<%=manufacturer %> disabled="disabled"
				      placeholder="Manufacturer Product">
				  </div>
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Price</label>
				    <input type="number" class="form-control" name="PriceProduct" placeholder="Price Product">
				  </div>
				  <div class="form-row">
				    <div class="form-group col-md-3">
				      <label for="inputEmail4">Screen</label>
				      <input type="text" class="form-control"  name="Screen" placeholder="Screen Product">
				    </div>
				    <div class="form-group col-md-3">
				      <label for="inputPassword4">Operating system</label>
				      <input type="text" class="form-control" name="Operating"  placeholder="operating  Product">
				    </div>
				    <div class="form-group col-md-3">
				      <label for="inputEmail4">Rear camera</label>
				      <input type="text" class="form-control"  name="Rearcamera" placeholder="Rear camera">
				    </div>
				    <div class="form-group col-md-3">
				      <label for="inputPassword4">Front camera</label>
				      <input type="text" class="form-control" name="Frontcamera"  placeholder="Front camera">
				    </div>
				  </div>
			
				  <div class="form-row">
				    <div class="form-group col-md-3">
				      <label for="inputEmail4">CPU</label>
				      <input type="text" class="form-control"  name="CPUProduct" placeholder="CPU Product">
				    </div>
				    <div class="form-group col-md-3">
				      <label for="inputPassword4">RAM</label>
				      <input type="text" class="form-control" name="RamProduct"  placeholder="RAM Product">
				    </div>
				    <div class="form-group col-md-3">
				      <label for="inputPassword4">Internal memory</label>
				      <input type="text" class="form-control" name="Internalmemory"  placeholder="Internal memory">
				    </div>
				    <div class="form-group col-md-3">
				      <label for="inputPassword4">Memory Stick</label>
				      <input type="text" class="form-control" name="MemoryStick"  placeholder="Memory Stick">
				    </div>
				    
				    
				  </div>
				    <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputEmail4">SIM</label>
				      <input type="text" class="form-control"  name="SimProduct" placeholder="Sim Product">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Battery capacity</label>
				      <input type="text" class="form-control" name="Batterycapacity"  placeholder=" Battery capacity">
				    </div>
				  </div>
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">New feature</label>
				    <input type="text" class="form-control" name="Newfeature" placeholder="New feature">
				  </div>		
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Details</label>
				    <input type="text" class="form-control" name="detailsProduct" placeholder="Details">
				  </div>	
				  <div class="form-group col-md-12">
				    <label for="inputAddress2">Image Link</label>
				    <input type="file" style="width:40%" name="linkImage" id="link" onchange="onchangeImage()">
				  </div>
				  <button type="submit" class="btn btn-primary">Save</button>
				</form>
		     
 </div>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Manufacturer</th>
        <th>Price</th>  
          <th>ImageLink</th>
          <th> More</th>
          <th>Update</th>
          <th>delete</th>
         
        
      </tr>
    </thead>
    <tbody>
 	<c:forEach var="list" items="${PRODUCT_LIST}">
 	<c:url var="tempLinkupdate" value="/pageController">
	 			
	 			<c:param name = "command" value="load" />
	 			<c:param name = "IdInfoProduct" value = "${list.getId()}" />
	 			
	 		</c:url>
	 			<c:url var="tempLinkdelete" value="/pageController">
	 			<c:param name = "command" value="DELETE" />
	 			<c:param name = "deleteProduct" value = "${list.getId()}"/>
	 		</c:url>
	 			<tr>
				<td>${list.getId()}</td>
				<td>${list.getName()}</td>
				<td>${list.getManufacturer()}</td>
				<td>${list.getPrice()}</td>
				<td class="hero-image" style="background-image: url(Image/${list.getImageLink()});"></td>
				
				
				<td><a href="#${list.getId()}" data-toggle="modal">See more</a></td>	
				<td><a href="${tempLinkupdate}">Update</a></td>
				<td><a href="${tempLinkdelete}">Delete</a></td>
		
				
				
		</tr>
		<div class="modal fade" id="${list.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h5 class="modal-title" id="exampleModalLabel"><b>Newfeature</b></h5>
        
      </div>
      <div class="modal-body">
        ${list.getNewfeature()}
      </div>
       <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Details</b></h5>
        
      </div>
      <div class="modal-body">
      ${list.getDetails()}
      </div>
      <div class="modal-header">
      
        <h5 class="modal-title" id="exampleModalLabel"><b>Technical specifications</b></h5>
        
      </div>
      <div class="modal-body">
      <div style="width:25%;float:left;"><b>Screen:</b></div>
        <div>${list.getScreen()}</div>
            <div  style="width:25%;float:left;"><b>RAM:</b></div>
        <div>${list.getRAM()}</div>
          <div  style="width:25%;float:left;"><b>Operating:</b></div>
        <div>${list.getOperating()}</div>
        <div  style="width:25%;float:left;"><b>Sim:</b></div>
        <div>${list.getSim()}</div>
           <div  style="width:25%;float:left;"><b>CPU:</b></div>
        <div>${list.getCPU()}</div>
          <div  style="width:25%;float:left;"><b>Rearcamera:</b></div>
        <div>${list.getRearcamera()}</div>
          <div  style="width:25%;float:left;"><b>FontCamera:</b></div>
        <div>${list.getfontCamera()}</div>
          <div  style="width:25%;float:left;"><b>Internalmemory:</b></div>
        <div>${list.getInternalmemory()}</div>
          <div  style="width:25%;float:left;"><b>MemoryStick:</b></div>
        <div>${list.getMemoryStick()}</div>
          <div  style="width:25%;float:left;"><b>Batterycapacity:</b></div>
        <div>${list.getBatterycapacity()}</div>
        
      </div>
    </div>
  </div>
</div>
		
	 		</c:forEach>
	 		</tbody>
    </table>
   

<!-- Modal -->

        </div>
   
</body>
</html>