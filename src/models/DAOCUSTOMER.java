package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import javax.sql.DataSource;

public class DAOCUSTOMER {
	private static DataSource dataSource;

	public DAOCUSTOMER(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public Boolean CheckAcount (String username,String passwork) throws SQLException
	{
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
	
	public	void AddCustomer(String UserName, String Passwork,
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
	String IdName ="CUS-" + String.valueOf(day+"-"+month+"-"+year+" "+hour+":"+minute+":"+second+":"+millis);
		String sql="Insert Into  Customers values(?,?,?,?,?,?,?,?,?,?)";
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
	
	public  static Customers getCustomers(String IdCustomer) throws SQLException {
		Customers telephone = new Customers();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		myConn = dataSource.getConnection();
		String sql = "select * from Customers where UserName = '"+IdCustomer+"' ";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);
		while (myRs.next()) {
		
			 telephone.setPhone(myRs.getString("Phone"));
			 telephone.setFullName(myRs.getString("FullName"));	
			 telephone.setEmaill(myRs.getString("Emaill"));
			 telephone.setBirthday(myRs.getString("Birthday"));
			 telephone.setSex(myRs.getBoolean("Sex"));
			 telephone.setAdress(myRs.getString("Adress"));
			 telephone.setPassport(myRs.getString("Passport"));
			 
		}
		myConn.close();
		myRs.close();
		myStmt.close();
		return telephone;
	}
	public void updateCustomer(String Phone ,String FullName,String  Emaill,
			String Birthday,Boolean Sex,String  Adress,String Passport,String UserName) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		myConn =dataSource.getConnection();
		String sql="Update Customers set Phone=?,FullName=?,Emaill=? ,Birthday=?,Sex=?,Adress=?,Passport=? where UserName=?";
		myStmt=myConn.prepareStatement(sql);
		myStmt.setString(1,Phone);
		myStmt.setString(2,FullName);
		myStmt.setString(3,Emaill);
		myStmt.setString(4,Birthday);
		myStmt.setBoolean(5,Sex);
		myStmt.setString(6,Adress);
		
		myStmt.setString(7,Passport);
		
		myStmt.setString(8,UserName);
		
		myStmt.execute();
		myConn.close();
		myStmt.close();
		
	}
	
}
