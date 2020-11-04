<!-- Navigation -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
   
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Startmin</a>
        </div>

        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!-- Top Navigation: Left Menu -->
        <ul class="nav navbar-nav navbar-left navbar-top-links">
            <li><a href="#"><i class="fa fa-home fa-fw"></i> Website</a></li>
        </ul>

        <!-- Top Navigation: Right Menu -->
        <ul class="nav navbar-right navbar-top-links">
          <c:url var="tempLinkLoadRegister" value="/pageController">
				<c:param name="command" value="loadregister" />
			</c:url>
           <li> <a href="${tempLinkLoadRegister}"> Register</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> secondtruth <b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <c:url var="tempLinkLogOut" value="/pageController">
				<c:param name="command" value="LOGOUTADMIN" />
			</c:url>
                    <li class="divider"></li>
                    <li><a href="${tempLinkLogOut}"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
            </li>
        </ul>

        <!-- Sidebar -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">

                <ul class="nav" id="side-menu">
           
                    <c:url var="tempLink5" value="/pageController">
	 			<c:param name = "command" value="Manufacture" />
	 			
	 		</c:url>
                    <li>
                        <a href="${tempLink5}" class="active"><i class="fa fa-dashboard fa-fw"></i> Manufacture</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i>Products<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                        <c:forEach var="list" items="${List_ManuFacture}">
                         <c:url var="tempLink1" value="/pageController">
                        	
	 			<c:param name = "command" value="productPhone" />
	 			<c:param name = "nameManufacture" value="${list.getName_Manufacturer()}" />
	 			<c:param name = "idManufacturer" value="${list.getId_manufacture()}" />
	 			
	 		</c:url>
                            <li>
                                <a href="${tempLink1}">${list.getName_Manufacturer()}</a>
                            </li>
                        	</c:forEach>
                       
                           
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>