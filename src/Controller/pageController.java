package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.DAO;
import models.Manufacture;
import models.Products;

/**
 * Servlet implementation class pageController
 */
@WebServlet("/pageController")
public class pageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
	private Cookie theCookie;
	@Resource(name="JDBC/WebBuyPhone")
	private DataSource dataSource;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//gọi đên cái Source
		super.init();
		dao = new DAO(dataSource);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//kiem tra xem cai cookie đc tao chua
		
		LoadNameManuFacture(request,response);
		Cookie[] theCookiesLoop= request.getCookies();
		boolean checkLoginAdmin=false;
		if(theCookiesLoop!=null)
		{
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("checkLoginPageAdmin".equals(tempCookie.getName()))
				{
					checkLoginAdmin=true;
					break;
				}
			}
		}
		if(!checkLoginAdmin) {
			theCookie= new Cookie("checkLoginPageAdmin", "false");
			
			theCookie.setMaxAge(60*60*24*365);
			response.addCookie(theCookie);	
			
		}
	
		 theCookiesLoop= request.getCookies();
		boolean check=false;
		if(theCookiesLoop!=null)//khi giá trị = null thì nó sẽ không tồn tại
		{
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("tagProduct".equals(tempCookie.getName()))
				{
					check=true;
					break;
				}
			}
		}
		if(!check) {
			theCookie= new Cookie("tagProduct", "null");
			
			theCookie.setMaxAge(60*60*24*365);//set tối đa về độ tuổi của cookie theo đơn vị là giây
			response.addCookie(theCookie);
			
			
		}
	
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			theCookiesLoop=request.getCookies();//tạo một cái mảng cookie có 
			boolean checkIdManufacturer=false;					//có tên là theCookieloop sau đó lấy ra các đối tượng trong mảng Cookie
			if(theCookiesLoop !=null) {
				for(Cookie tempCookie:theCookiesLoop)//dùng để duyệt qu các mảng cookie 
					{
					if("idManufacturer".equals(tempCookie.getName())) {
						check=true;
						break;
					}
				}
			}
			//nếu tagProduct chưa dc tạo thì ta phải tạo một tagProduct ở bên dưới
			if(!checkIdManufacturer) {
				theCookie =new Cookie("idManufacturer","null");
				theCookie.setMaxAge(60*60*24*365);
				response.addCookie(theCookie);
			}

			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "home";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			case "home":
				home(request,response);
				break;
			case "LOGINPageAdmin":
				loginAdmin(request,response);
				break; 
			case "LOADPage":
				loadpage(request,response);
				break;
			case "LOGOUTADMIN":
				logout(request,response);
				break;	
			case "Manufacture":
				PageManufacture(request,response);
				break;
			case "LIST":
				Addpage(request, response);
				break;
			case "productPhone":
				try {
					theCookiesLoop=request.getCookies();
					if(theCookiesLoop!=null)//khi giá trị = null thì nó sẽ không tồn tại
					{
						for(Cookie tempCookie:theCookiesLoop)
						{
							if("tagProduct".equals(tempCookie.getName()))
							{
								tempCookie.setValue(request.getParameter("nameManufacture"));
								response.addCookie(tempCookie);
								break;
							}
						}
						for(Cookie tempCookie:theCookiesLoop)//dùng để duyệt qua các mảng cookie 
						{
							if("idManufacturer".equals(tempCookie.getName())) {
								tempCookie.setValue(request.getParameter("idManufacturer"));
								response.addCookie(tempCookie);
								break;
							}
						}
	for(Cookie tempCookie:theCookiesLoop)//dùng để duyệt qua các mảng cookie 
						{
							if("idManufacturer".equals(tempCookie.getName())) {
								tempCookie.setValue(request.getParameter("idManufacturer"));
								response.addCookie(tempCookie);
								break;
							}
						}
	

					}
					loadpage(request, response);
					
				}
				catch (Exception exc) {
					throw new ServletException(exc);
				}
				break;
			
			case "load":
				LoadProduct(request,response);
				break;
			case "UPDATE":
				updatepage(request,response);
				break;
			case"AdminMNF":
				AddMNF(request,response);
				break;
			case "register":
				registerEmp(request,response);
				break;
			case "loadregister":
				loadregisterEmp(request,response);
				break;	
			case"DELETE":	
				DeleteProduct(request,response);	
				break;
			default:
				loadpage(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	

	}

	private void LoadNameManuFacture(HttpServletRequest request, HttpServletResponse response) 
	{
		ObservableList<Manufacture> listNameManuFacture = FXCollections.observableArrayList();
		try {
			listNameManuFacture=dao.getNameManuFacture();
			request.getSession().setAttribute("List_ManuFacture", listNameManuFacture);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void AddMNF(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		dao.AddManufacture(request.getParameter("Manufacture"));
		LoadNameManuFacture(request,response);
		response.sendRedirect("/WebBuyPhone/admin/darkboard.jsp");
	}
	private void PageManufacture(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("admin/pageManufacturer.jsp");
	}
	private void loadregisterEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("admin/registerEmployees.jsp");
	}
	private void registerEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		boolean Sex = false;
		if(request.getParameter("Sex").equals("Male")) {
			Sex=true;
			}

		dao.AddEmployes(
					request.getParameter("UserName"), request.getParameter("Passwork")	
					,request.getParameter("Phone"),request.getParameter("FullName"),
					request.getParameter("Emaill"),request.getParameter("Birthday"),	
					Sex,request.getParameter("Adress"),request.getParameter("Passport"));	
	    loadpage(request, response);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Cookie[] theCookiesLoop= request.getCookies();
		
		
		
			if(theCookiesLoop!=null)//khi giÃ¡ trá»‹ = null thÃ¬ nÃ³ sáº½ khÃ´ng tá»“n táº¡i
			{
				for(Cookie tempCookie:theCookiesLoop)
				{
					if("checkLoginPageAdmin".equals(tempCookie.getName()))
					{
						tempCookie.setValue("false");
						response.addCookie(tempCookie);
						break;
					}
				}
			}
			response.sendRedirect("admin/loginPageAdmin.jsp");
		}
	
	private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String username=request.getParameter("UserName");
		String pass=request.getParameter("Passwork");
		Cookie[] theCookiesLoop= request.getCookies();
	
	
		if(username.equals("mykieu")&& pass.equals("12345"))
		{
			if(theCookiesLoop!=null)//khi giÃ¡ trá»‹ = null thÃ¬ nÃ³ sáº½ khÃ´ng tá»“n táº¡i
			{
				for(Cookie tempCookie:theCookiesLoop)
				{
					if("checkLoginPageAdmin".equals(tempCookie.getName()))
					{
						tempCookie.setValue("true");
						response.addCookie(tempCookie);
						break;
					}
				}
			}
			
		}
		Boolean checklogin	=dao.LoginPageAdmin(request.getParameter("UserName"), request.getParameter("Passwork"));
		if(checklogin)
		{
		 theCookiesLoop=request.getCookies();
			if(theCookiesLoop!=null)
			{
				for(Cookie tempCookie:theCookiesLoop)
				{
					if("checkLoginPageAdmin".equals(tempCookie.getName()))
					{
						tempCookie.setValue("true");
						response.addCookie(tempCookie);
						break;
					}
				}
			}
			
			theCookie = new Cookie("userLoginPageAdmin",request.getParameter("UserName"));
			theCookie.setMaxAge(60*60*24*365);//set tá»‘i Ä‘a vá»� Ä‘á»™ tuá»•i cá»§a coolie theo Ä‘Æ¡n vá»‹ lÃ  giÃ¢y
			response.addCookie(theCookie);
			request.getSession().setAttribute("usernameLogin", request.getParameter("UserName"));
			response.sendRedirect("/WebBuyPhone/admin/darkboard.jsp");
			
		}
		
			
	}
	private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String Id_Product = request.getParameter("deleteProduct");
		dao.DeleteProduct(Id_Product);
		loadpage(request, response);
	}
	private void LoadProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		//tao cookie
		Products inforProduct=new Products();
		try {
		Cookie[] theCookiesLoop= request.getCookies();
		boolean check=false;
		if(theCookiesLoop!=null)//khi giá trị = null thì nó sẽ không tồn tại
		{
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("IdProduct".equals(tempCookie.getName()))
				{
					check=true;
					tempCookie.setValue(request.getParameter("IdInfoProduct"));
					response.addCookie(tempCookie);
					break;
				}
			}
		}
		if(!check) {
			theCookie= new Cookie("IdProduct", request.getParameter("IdInfoProduct"));
			
			theCookie.setMaxAge(60*60*24*365);//set tối đa về độ tuổi của coolie theo đơn vị là giây
			response.addCookie(theCookie);
			
			
		}
		inforProduct=DAO.getProducts(request.getParameter("IdInfoProduct"));
     request.getSession().setAttribute("inforProduct", inforProduct);	
		response.sendRedirect("/WebBuyPhone/admin/update.jsp");
		
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
		
	}
	
	private void updatepage(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String manufacturer=null;
		String IdProduct=null;
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
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("IdProduct".equals(tempCookie.getName()))
				{
					IdProduct=tempCookie.getValue();
					break;
				}
			}
		}
		dao.update(IdProduct
				//request.getParameter("IdProduct"),
				,request.getParameter("NameProduct"),
			//request.getParameter("Manufacturer")
				//manufacturer
				Double.parseDouble(request.getParameter("PriceProduct")),
				request.getParameter("Screen"),
			request.getParameter("Operating"),request.getParameter("Rearcamera"),
		    request.getParameter("Frontcamera"),
		    request.getParameter("CPUProduct"),request.getParameter("RamProduct"),
		request.getParameter("Internalmemory"),request.getParameter("MemoryStick"),
		request.getParameter("SimProduct"),request.getParameter("Batterycapacity"),
		request.getParameter("Newfeature"),request.getParameter("detailsProduct"),
		request.getParameter("linkIMG"));
		//response.sendRedirect("/WebBuyPhone/admin/viewProduct.jsp");
	    loadpage(request, response);
	}
	private void loadpage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
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
		ObservableList<Products> list_Telephone = FXCollections.observableArrayList();
		
		
		String IdManuFacture=dao.getIdManufacture(manufacturer);
		list_Telephone = dao.getAllProducts(IdManuFacture);
		request.getSession().setAttribute("PRODUCT_LIST", list_Telephone);
		response.sendRedirect("/WebBuyPhone/admin/viewProduct.jsp");
		
	}
	private void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/WebBuyPhone/admin/darkboard.jsp");
	}
	private void Addpage(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String manufacturer=null;
		Cookie[] theCookiesLoop= request.getCookies();
		String idManufacturer=null;
		if(theCookiesLoop!=null)//khi giá trị = null thì nó sẽ không tồn tại
		{
			for(Cookie tempCookie:theCookiesLoop)//dùng để duyệt qu các mảng cookie 
			{
			if("idManufacturer".equals(tempCookie.getName())) {
				idManufacturer=tempCookie.getValue();
				break;
			}
		}


			for(Cookie tempCookie:theCookiesLoop)
			{
				if("tagProduct".equals(tempCookie.getName()))
				{
					manufacturer=tempCookie.getValue();
					break;
				}
			}
		}
		dao.Add(request.getParameter("IdProduct"), request.getParameter("NameProduct"),
				//request.getParameter("Manufacturer")
				idManufacturer
				,Double.parseDouble(request.getParameter("PriceProduct")),
				request.getParameter("Screen"),
			request.getParameter("Operating"),request.getParameter("Rearcamera"),
		    request.getParameter("Frontcamera"),
		    request.getParameter("CPUProduct"),request.getParameter("RamProduct"),
		request.getParameter("Internalmemory"),request.getParameter("MemoryStick"),
		request.getParameter("SimProduct"),request.getParameter("Batterycapacity"),
		request.getParameter("Newfeature"),request.getParameter("detailsProduct"),
		request.getParameter("linkImage"));
		//response.sendRedirect("/WebBuyPhone/admin/viewProduct.jsp");
	    loadpage(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
