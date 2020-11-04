<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
    
				 
        <ul class="navbar-nav mr-auto">
          <c:url var="tempLinkHOME" value="/CustomerController">
	 			
	 			<c:param name = "command" value="HOME" />
	 			  
	 		</c:url>
            <li class="nav-item active">
                <a class="nav-link" href="${tempLinkHOME}"> <i class="fas fa-home"></i> </a>
            </li>
        <c:forEach var="list" items="${List_Manufacturer}">
				<c:url var="tempLinkViewProduct" value="CustomerController">
					<c:param name="command" value="viewProduct" />
					<c:param name = "nameManufacturer" value = "${list.getName_Manufacturer()}"/>
					<c:param name = "idManufacturer" value = "${list.getId_manufacture()}"/>
				</c:url>
				<li class="nav-item"><a class="nav-link" href="${tempLinkViewProduct}">${list.getName_Manufacturer()}</a>
				</li>
			</c:forEach>


        
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto" href="#"> <i class="fab fa-apple"></i> SmartPhone <i class="fab fa-apple"></i> </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
        <li  class="nav-item">
        <% 
        boolean check=false;
        Cookie[] theCookies=request.getCookies();
		if(theCookies!=null)
		{
			for(Cookie tempCookie:theCookies)
			{
				if("checkLogin".equals(tempCookie.getName()) && tempCookie.getValue().equals("true") )
				{
					check=true;
					break;
				}
			}
		}
		
		
		
	if(!check){
        %>
       
        	<c:url var="tempLinkRegister" value="/CustomerController">
	 			
	 			<c:param name = "command" value="Register" />
	 			  
	 		</c:url>
            <li class="nav-item" >
         
            <a class="nav-link" href="${tempLinkRegister}"><i class="fas fa-sign-in-alt"></i> Sign Up</a>
           
     
            </li>
             
          <c:url var="tempLinklOGIN" value="/CustomerController">
	 			
	 			<c:param name = "command" value="ADMIN" />
	 			
	 		</c:url>
            <li class="nav-item">
                <a class="nav-link" href="${tempLinklOGIN}"><i class="fas fa-sign-in-alt"></i> Sign in</a>
              
            </li>
            <%
			  } else {
			%>
			
			  <c:url var="tempLinkupdate" value="/CustomerController">
	 			
	 			<c:param name = "command" value="LoadUpdate" />
	 				<c:param name = "UserName" value = "${usernameLogin}" />
	 			
	 		</c:url>
	 		
			<li class="nav-item"><a class="nav-link" href="${tempLinkupdate}">
			<i class="fas fa-user-tie"></i>
			
			<% 
			theCookies =request.getCookies();
			String username=null;
			if(theCookies != null){
				for(Cookie tempCookie :theCookies){
					if("userLogin".equals(tempCookie.getName())){
						username=tempCookie.getValue();
						break;
					}
				}
			}
			out.print(username); %>
			</a></li>
			<c:url var="tempLinkLogOut" value="/CustomerController">
				<c:param name="command" value="LOGOUT" />
			</c:url>
			<li>
			<a class="nav-link" href="${tempLinkLogOut}"><i
					class="fas fa-sign-out-alt"></i> Log Out</a></li>
			<%
				}
			%>

        </ul>
        	
    </div>
  
</nav>

<script>
	function hideModeLogin(){
		$('#myModalRegister').modal('hide');//trỏ tới id gán là hide
	}
	function hideModeRegister(){
		$('#myModal').modal('hide');
	}
</script>


