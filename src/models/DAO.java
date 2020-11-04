package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import javax.sql.DataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO {
	private static DataSource dataSource;

	public DAO(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public ObservableList<Products> getAllProducts(String manufacturer) throws SQLException {
		ObservableList<Products> list_Telephone = FXCollections.observableArrayList();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		myConn = dataSource.getConnection();
		String sql = "select * from PageDetails where Manufacturer='"+manufacturer+"' and Active=1";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);
		while (myRs.next()) {
			Products telephone = new Products();
			 telephone.setId(myRs.getString("Id"));
			 telephone.setName(myRs.getString("Name"));
			 telephone.setManufacturer(myRs.getString("Manufacturer"));
			 telephone.setPrice(myRs.getDouble("Price"));	
			 telephone.setScreen(myRs.getString("Screen"));
			 telephone.setOperating(myRs.getString("Operating"));
			 telephone.setRearcamera(myRs.getString("Rearcamera"));
			 telephone.setfontCamera(myRs.getString("fontCamera"));
			 telephone.setCPU(myRs.getString("CPU"));
			 telephone.setRAM(myRs.getString("RAM"));
			 telephone.setInternalmemory(myRs.getString("Internalmemory"));
			 telephone.setMemoryStick(myRs.getString("MemoryStick"));
			 telephone.setSim(myRs.getString("Sim"));
			 telephone.setBatterycapacity(myRs.getString("Batterycapacity"));
			 telephone.setNewfeature(myRs.getString("Newfeature"));
			 telephone.setDetails(myRs.getString("Details"));
			 telephone.setImageLink(myRs.getString("ImageLink"));
			
			
			
			
			list_Telephone.add( telephone);
		}
		myConn.close();
		myRs.close();
		myStmt.close();
		return list_Telephone;
	}
	public	void Add(String Id ,String Name,String   Manufacturer,Double Price,String  Screen,String  Operating,
			String  Rearcamera  ,String fontCamera ,String CPU ,String RAM 
			,String Internalmemory ,String  MemoryStick ,String Sim ,
			String Batterycapacity ,String Newfeature ,String Details ,String  ImageLink  ) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		myConn =dataSource.getConnection();
		String sql="Insert Into PageDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		myStmt=myConn.prepareStatement(sql);
		myStmt.setString(1, "1");
		myStmt.setString(2,Id);
		myStmt.setString(3,Name);
		myStmt.setString(4,  Manufacturer);
		myStmt.setDouble(5,Price);
		myStmt.setString(6,  Screen);
		myStmt.setString(7,  Operating);
		myStmt.setString(8,   Rearcamera );
		myStmt.setString(9,  fontCamera);
		myStmt.setString(10,  CPU);
		myStmt.setString(11,  RAM);
		myStmt.setString(12,  Internalmemory);
		myStmt.setString(13,   MemoryStick);
		myStmt.setString(14,  Sim);
		myStmt.setString(15,  Batterycapacity);
		myStmt.setString(16,  Newfeature);
		myStmt.setString(17,  Details);
		myStmt.setString(18,   ImageLink);
		
		
		myStmt.execute();
		myConn.close();
		myStmt.close();
		
		
	}
	public	void AddEmployes(String UserName, String Passwork,
			String Phone,String FullName,String  Emaill,
			String Birthday,Boolean Sex,String  Adress,String Passport) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		myConn =dataSource.getConnection();

   LocalDateTime now = LocalDateTime.now();
	int year = now.getYear();
	int month = now.getMonthValue();
	int day = now.getDayOfMonth();
	int hour = now.getHour();
	int minute = now.getMinute();
	int second = now.getSecond();
	int millis = now.get(ChronoField.MICRO_OF_SECOND);
	String IdName ="EMP-" + String.valueOf(day+"-"+month+"-"+year+" "+hour+":"+minute+":"+second+":"+millis);
		String sql="Insert Into Employees values(?,?,?,?,?,?,?,?,?,?)";
		myStmt=myConn.prepareStatement(sql);
		myStmt.setString(1,IdName);
		myStmt.setString(2,UserName);
		myStmt.setString(3,Passwork);
		myStmt.setString(4,Phone);
		myStmt.setString(5,FullName);
		myStmt.setString(6,Emaill);
		myStmt.setString(7,Birthday);
		myStmt.setBoolean(8,Sex);
		myStmt.setString(9,Adress);
		myStmt.setString(10,Passport);
		myStmt.execute();
		myConn.close();
		myStmt.close();
		
		
	}
	public	void AddManufacture(String Name_Manufacturer) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		myConn =dataSource.getConnection();
		String sql="Insert Into  Manufacturers values(?,?,?)";
   LocalDateTime now = LocalDateTime.now();
	int year = now.getYear();
	int month = now.getMonthValue();
	int day = now.getDayOfMonth();
	int hour = now.getHour();
	int minute = now.getMinute();
	int second = now.getSecond();
	int millis = now.get(ChronoField.MICRO_OF_SECOND);
	String IdName ="MNF-" + String.valueOf(day+"-"+month+"-"+year+"-"+hour+"-"+minute+"-"+second+"-"+millis);
		
		myStmt=myConn.prepareStatement(sql);
		myStmt.setString(1,IdName);
		myStmt.setString(2,Name_Manufacturer);
		myStmt.setBoolean(3,true);
		
		myStmt.execute();
		myConn.close();
		myStmt.close();
		
		
	}

	public	void update(String Id ,String Name,Double Price,String  Screen,String  Operating,
			String  Rearcamera  ,String fontCamera ,String CPU ,String RAM 
			,String Internalmemory ,String  MemoryStick ,String Sim ,
			String Batterycapacity ,String Newfeature ,String Details ,String  ImageLink) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		myConn =dataSource.getConnection();
		String sql="Update  PageDetails set Name=?,"
				+ "Price=?,Screen=?,Operating=?,Rearcamera=?,fontCamera=?,CPU=?,RAM=?,"
				+ "Internalmemory=?,MemoryStick=?,Sim=?,Batterycapacity=?,Newfeature=?,Details=?,ImageLink=? "
				+ "where Id=?";
		myStmt=myConn.prepareStatement(sql);
		myStmt.setString(1,Name);
	//	myStmt.setString(2,  Manufacturer);
		myStmt.setDouble(2,Price);
		myStmt.setString(3,  Screen);
		myStmt.setString(4,  Operating);
		myStmt.setString(5,   Rearcamera );
		myStmt.setString(6,  fontCamera);
		myStmt.setString(7,  CPU);
		myStmt.setString(8,  RAM);
		myStmt.setString(9,  Internalmemory);
		myStmt.setString(10,   MemoryStick);
		myStmt.setString(11,  Sim);
		myStmt.setString(12,  Batterycapacity);
		myStmt.setString(13,  Newfeature);
		myStmt.setString(14,  Details);
		myStmt.setString(15,   ImageLink);
		myStmt.setString(16,Id);
		myStmt.execute();
		myConn.close();
		myStmt.close();
		
	}
	public static Products getProducts(String IdProduct) throws SQLException {
	
		Products telephone = new Products();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		myConn = dataSource.getConnection();
		String sql = "select * from PageDetails where Id = '"+IdProduct+"' ";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);
		while (myRs.next()) {
			telephone.setId(myRs.getString("Id"));
			 telephone.setName(myRs.getString("Name"));
			 telephone.setManufacturer(myRs.getString("Manufacturer"));
			 telephone.setPrice(myRs.getDouble("Price"));	
			 telephone.setScreen(myRs.getString("Screen"));
			 telephone.setOperating(myRs.getString("Operating"));
			 telephone.setRearcamera(myRs.getString("Rearcamera"));
			 telephone.setfontCamera(myRs.getString("fontCamera"));
			 telephone.setCPU(myRs.getString("CPU"));
			 telephone.setRAM(myRs.getString("RAM"));
			 telephone.setInternalmemory(myRs.getString("Internalmemory"));
			 telephone.setMemoryStick(myRs.getString("MemoryStick"));
			 telephone.setSim(myRs.getString("Sim"));
			 telephone.setBatterycapacity(myRs.getString("Batterycapacity"));
			 telephone.setNewfeature(myRs.getString("Newfeature"));
			 telephone.setDetails(myRs.getString("Details"));
			 telephone.setImageLink(myRs.getString("ImageLink"));
			
		}
		myConn.close();
		myRs.close();
		myStmt.close();
		return telephone;
	}
	public void DeleteProduct(String IdProduct) throws SQLException  {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		myConn =dataSource.getConnection();
		String sql="Update PageDetails set Active=0 where Id = '"+IdProduct+"'";
		myStmt=myConn.prepareStatement(sql);
		myStmt.execute();
		myConn.close();
		myStmt.close();
		
	}

	public Boolean LoginPageAdmin(String username, String passwork) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
			ResultSet myRs = null;
			myConn = dataSource.getConnection();
			String sql = "select count(*) as checkAccout From Customers where UserName=? And Passwork=? ";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1,username);
			myStmt.setString(2,passwork);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
			if(myRs.getString("checkAccout").equals("1"))
			{
				return true;
			}
			
		}
			myConn.close();
			myRs.close();
			myStmt.close();
			
		return false;
	}
	public ObservableList<Manufacture> getNameManuFacture() throws SQLException {
		ObservableList<Manufacture> listNameManuFacture = FXCollections.observableArrayList();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		myConn = dataSource.getConnection();
		String sql = "select * from Manufacturers where Active=1";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);
		while (myRs.next()) {
			Manufacture MNF=new Manufacture();
			MNF.setName_Manufacturer(myRs.getString("Name_Manufacturer"));
			MNF.setId_manufacture(myRs.getString("Id_manufacture"));
			listNameManuFacture .add(MNF);
		}
		myConn.close();
		myRs.close();
		myStmt.close();
		return listNameManuFacture;
	}

	
	public String getIdManufacture(String nameManufacturer) throws SQLException {
	
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String IdManuFacture=null;
		myConn = dataSource.getConnection();
		String sql = "select Id_manufacture from Manufacturers where Name_Manufacturer='"+nameManufacturer+"' and Active=1";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);
		while (myRs.next()) {
			IdManuFacture=myRs.getString("Id_manufacture");
		}
		myConn.close();
		myRs.close();
		myStmt.close();
		return IdManuFacture;
	}
}
