package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customers {

	private StringProperty IdName ;
	private StringProperty UserName;
	private StringProperty Passwork;
	private StringProperty Phone;
	private StringProperty  FullName;
	private StringProperty Emaill;
	private StringProperty Birthday;
	private BooleanProperty  Sex;
	private StringProperty Adress;
	private StringProperty Passport;
	
	public void setIdName(String IdName) {
		this.IdName = new SimpleStringProperty(IdName);
	}
	public String getIdName() {
		return IdName.get();
	}
	public void setUserName(String UserName) {
		this.IdName = new SimpleStringProperty(UserName);
	}
	public String getUserName() {
		return UserName.get();
	}
	public void setPasswork(String Passwork) {
		this.Passwork = new SimpleStringProperty(Passwork);
	}
	public String getPasswork() {
		return Passwork.get();
	}
	public void setPhone(String Phone) {
		this.Phone = new SimpleStringProperty(Phone);
	}
	public String getPhone() {
		return Phone.get();
	}
	public void setFullName(String FullName) {
		this.FullName = new SimpleStringProperty(FullName);
	}
	public String getFullName() {
		return FullName.get();
	}
	public void setEmaill(String Emaill) {
		this.Emaill = new SimpleStringProperty(Emaill);
	}
	public String getEmaill() {
		return Emaill.get();
	}
	public void setBirthday(String Birthday) {
		this.Birthday = new SimpleStringProperty(Birthday);
	}
	public String getBirthday() {
		return Birthday.get();
	}
	public void setSex(Boolean Sex) {
		this.Sex = new SimpleBooleanProperty(Sex);
	}
	public Boolean getSex() {
		return Sex.get();
	}
	public void setAdress(String Adress) {
		this.Adress = new SimpleStringProperty(Adress);
	}
	public String getAdress() {
		return Adress.get();
	}
	public void setPassport(String Passport) {
		this.Passport = new SimpleStringProperty(Passport);
	}
	public String getPassport() {
		return Passport.get();
	}
 public Customers() {
	// TODO Auto-generated constructor stub
		
	}
 public Customers(
			String IdName, String UserName, String Passwork,
			String Phone,String FullName,String  Emaill,
			String Birthday,Boolean Sex,String  Adress,String Passport) {
	
	     this.IdName = new SimpleStringProperty(IdName);
		this.UserName = new SimpleStringProperty(UserName);
		this.Passwork = new SimpleStringProperty(Passwork);
		this.Phone = new SimpleStringProperty(Phone);
		this.FullName = new SimpleStringProperty(FullName);
		this.Emaill = new SimpleStringProperty(Emaill);
		this.Birthday = new SimpleStringProperty(Birthday);
		 this.Sex = new SimpleBooleanProperty(Sex);
		this.Adress = new SimpleStringProperty(Adress);
		this. Passport = new SimpleStringProperty( Passport);
	
		
		
		
	}
}
