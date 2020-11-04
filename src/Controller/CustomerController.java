package Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Customers;
import models.DAO;
import models.DAOCUSTOMER;
import models.Manufacture;
import models.Products;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOCUSTOMER daocustomer;
	private DAO daoAdmin;
	private Cookie theCookie;
	@Resource(name="JDBC/WebBuyPhone")
	private DataSource dataSources;
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		daocustomer = new DAOCUSTOMER(dataSources);
		daoAdmin=new DAO(dataSources);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//tao ra cookie để xem  người dùng nó dăng nhập hay chưa 
		Cookie[] theCookiesLoop= request.getCookies();//lấy ra toàn bộ cokie ở trong web
		boolean check=false;//để xem thử thử cookie có tồn tại hay chưa nếu chưa thì phải tạo ra checklogin và gán=false do chưa đăng nhập
		if(theCookiesLoop!=null)//khi có giá trị ta thực hiện
		{
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("checkLogin".equals(tempCookie.getName()))
				{
					check=true;
					break;//kiểm tra xem 
				}
			}
		}
		if(!check) {
			theCookie= new Cookie("checkLogin", "false");
			
			theCookie.setMaxAge(60*60*24*365);//set tá»‘i Ä‘a vá»� Ä‘á»™ tuá»•i cá»§a coolie theo Ä‘Æ¡n vá»‹ lÃ  giÃ¢y
			response.addCookie(theCookie);
			
			
		}
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "HOME";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "HOME":
				LoadManufacturer(request, response);
				showhome(request, response);
				break;
			case "LOGIN":
				LoadManufacturer(request, response);
				submitlogin(request,response);
				break;
			
			
			case "LOGOUT":
				LoadManufacturer(request, response);
				logout(request,response);
				break;
			case "Register":
				LoadManufacturer(request, response);
				registerCustmer(request,response);
				break;
			case "AddCustomer":
				LoadManufacturer(request, response);
				AddCustmer(request,response);
				break;
			case "UpdateCustomer":
				LoadManufacturer(request, response);
				UpdateCustomer(request,response);
				break;
			case "LoadUpdate":
				LoadManufacturer(request, response);
				LoadCustomer(request,response);
				break;
			case "ADMIN":
				LoadManufacturer(request, response);
				LoginAdmin(request,response);
				break;	
				case "viewProduct":
					LoadManufacturer(request, response);
					ViewIphone(request,response);
					break;	
				
			default:
				showhome(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	private void submitlogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	Boolean checklogin	=daocustomer.CheckAcount(request.getParameter("UserName"), request.getParameter("Passwork"));
		if(checklogin)
		{
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/loginSucess.jsp");
			//dispatcher.forward(request, response);
			Cookie[] theCookiesLoop=request.getCookies();
			if(theCookiesLoop!=null)
			{
				for(Cookie tempCookie:theCookiesLoop)
				{
					if("checkLogin".equals(tempCookie.getName()))
					{
						tempCookie.setValue("true");
						response.addCookie(tempCookie);
						break;
					}
				}
			}
			
			theCookie = new Cookie("userLogin",request.getParameter("UserName"));
			theCookie.setMaxAge(60*60*24*365);//set tá»‘i Ä‘a vá»� Ä‘á»™ tuá»•i cá»§a coolie theo Ä‘Æ¡n vá»‹ lÃ  giÃ¢y
			response.addCookie(theCookie);
			//request.setAttribute("Check_login", "true");//gÃ¡n giÃ¡ trá»‹ 1 biáº¿n vá»›i tÃªn lÃ  check-login
			//String username=request.getParameter("UserName");
			//request.setAttribute("usernameLogin", username);
			request.getSession().setAttribute("usernameLogin", request.getParameter("UserName"));
			response.sendRedirect("home.jsp");
			
		}
		
			
	}
	
	private void LoadCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//response.sendRedirect("updateCustome.jsp");
		Customers inforProduct=new Customers();
		try {
		Cookie[] theCookiesLoop= request.getCookies();
		boolean check=false;
		if(theCookiesLoop!=null)//khi giá trị = null thì nó sẽ không tồn tại
		{
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("IdCustomer".equals(tempCookie.getName()))
				{
					check=true;
					tempCookie.setValue(request.getParameter("UserName"));
					response.addCookie(tempCookie);
					break;
				}
			}
		}
		if(!check) {
			theCookie= new Cookie("IdCustomer", request.getParameter("UserName"));
			
			theCookie.setMaxAge(60*60*24*365);//set tối đa về độ tuổi của coolie theo đơn vị là giây
			response.addCookie(theCookie);
			
			
		}
		inforProduct=DAOCUSTOMER.getCustomers(request.getParameter("UserName"));
     request.getSession().setAttribute("inforProduct", inforProduct);
		
		response.sendRedirect("/WebBuyPhone/updateCustomer.jsp");
		
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
		
	}
	private void ViewIphone(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
		
		ObservableList<Products> list_Telephone = FXCollections.observableArrayList();
		list_Telephone = daoAdmin.getAllProducts(request.getParameter("idManufacturer"));
		request.getSession().setAttribute("PRODUCT_LIST", list_Telephone);
		response.sendRedirect("viewCustomer.jsp");
	}

	private void UpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	//	boolean Sex = false;
		//if(request.getParameter("Sex").equals("Male")) {
			//Sex=true;
			//}
		
		String 	UserName=null;
		Cookie[] theCookiesLoop= request.getCookies();
		
		if(theCookiesLoop!=null)//khi giá trị = null thì nó sẽ không tồn tại
		{
			
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("userLogin".equals(tempCookie.getName()))
				{
					UserName=tempCookie.getValue();
					break;
				}
			}
		}
		
		daocustomer.updateCustomer(request.getParameter("Phone"),request.getParameter("FullName"),
				request.getParameter("Emaill"),request.getParameter("Birthday"),
				Boolean.parseBoolean(request.getParameter("Sex"))	
				,request.getParameter("Adress"),request.getParameter("Passport"),UserName);
		response.sendRedirect("/WebBuyPhone/home.jsp");
	  
	}
	private void AddCustmer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		boolean Sex = false;
		if(request.getParameter("Sex").equals("Male")) {
			Sex=true;//1
			}

		daocustomer.AddCustomer(
					request.getParameter("UserName"), request.getParameter("Passwork")	
					,request.getParameter("Phone"),request.getParameter("FullName"),
					request.getParameter("Emaill"),request.getParameter("Birthday"),
					
					Sex,request.getParameter("Adress"),request.getParameter("Passport"));	
		//response.sendRedirect("/WebBuyPhone/admin/darkboard.jsp");
		showhome(request, response);
	}
	private void LoginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("/WebBuyPhone/admin/darkboard.jsp");
		response.sendRedirect("Login.jsp");
	}
	private void registerCustmer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
	
	response.sendRedirect("Register.jsp");
		
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] theCookiesLoop=request.getCookies();
		if(theCookiesLoop!=null)
		{
			for(Cookie tempCookie:theCookiesLoop)
			{
				if("checkLogin".equals(tempCookie.getName()))
				{
					tempCookie.setValue("false");//khi đăng nhập thì là true thì thanh navBar sec bị thay đổi thoát ra check=false
					response.addCookie(tempCookie);
					break;
				}
			}
		}
		
		showhome(request, response);
		
	}
	
	private void showhome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("home.jsp");
	}
	
	
	private void LoadManufacturer(HttpServletRequest request, HttpServletResponse response) {
		ObservableList<Manufacture> list_Manufacturer= FXCollections.observableArrayList();
		try {
			list_Manufacturer = daoAdmin.getNameManuFacture();
			request.getSession().setAttribute("List_Manufacturer", list_Manufacturer);
		} catch (SQLException e3) {
			// TODO Auto-generated catch 
			e3.printStackTrace();
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//post là đẩy từ fron-end lên server
	//doget lấy dữ liệu xún 

}
