package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Products {
	private BooleanProperty Active;
	private StringProperty Id ;
	private StringProperty Name;
	private StringProperty Manufacturer;
	private DoubleProperty Price;
	private StringProperty Screen;
	private StringProperty  Operating;
	private StringProperty Rearcamera;
	private StringProperty fontCamera;
	private StringProperty  CPU;
	private StringProperty RAM;
	private StringProperty Internalmemory;
	private StringProperty MemoryStick;
	private StringProperty Sim;
	private StringProperty Batterycapacity;
	private StringProperty Newfeature;
	private StringProperty Details;
	private StringProperty ImageLink;
	
	
	public Boolean getActive() {
		return  Active .get();
	}

	public void setActive (Boolean  Active ) {
		this. Active = new SimpleBooleanProperty(Active);
	}
	
	public String getId() {
		return Id.get();
	}

	public void setId(String Id) {
		this.Id = new SimpleStringProperty(Id);
	}
	public String getName() {
		return Name.get();
	}

	public void setName(String Name) {
		this.Name = new SimpleStringProperty(Name);
	}
	public String getManufacturer() {
		return Manufacturer.get();
	}

	public void setManufacturer(String Manufacturer) {
		this.Manufacturer = new SimpleStringProperty(Manufacturer);
	}
	public Double getPrice() {
		return Price.get();
	}

	public void setPrice(Double Price) {
		this.Price = new SimpleDoubleProperty(Price);
	}
	
	public String getScreen() {
		return Screen.get();
	}

	public void setScreen(String Screen) {
		this.Screen = new SimpleStringProperty(Screen);
	}
	public String getOperating() {
		return Operating.get();
	}

	public void setOperating(String Operating) {
		this.Operating = new SimpleStringProperty(Operating);
	}
	public String getRearcamera() {
		return Rearcamera.get();
	}

	public void setRearcamera(String Rearcamera) {
		this.Rearcamera = new SimpleStringProperty(Rearcamera);
	}
	public String getfontCamera() {
		return fontCamera.get();
	}

	public void setfontCamera(String fontCamera) {
		this.fontCamera = new SimpleStringProperty(fontCamera);
	}
	public String getCPU() {
		return CPU.get();
	}

	public void setCPU(String CPU) {
		this.CPU = new SimpleStringProperty(CPU);
	}
	public String getRAM() {
		return RAM.get();
	}

	public void setRAM(String RAM) {
		this.RAM = new SimpleStringProperty(RAM);
	}
	public String getInternalmemory () {
		return Internalmemory .get();
	}

	public void setInternalmemory (String Internalmemory ) {
		this.Internalmemory = new SimpleStringProperty(Internalmemory );
	}
	public String getMemoryStick () {
		return MemoryStick .get();
	}

	public void setMemoryStick (String MemoryStick ) {
		this.MemoryStick = new SimpleStringProperty(MemoryStick );
	}
	public String getSim() {
		return Sim .get();
	}

	public void setSim (String Sim ) {
		this.Sim = new SimpleStringProperty(Sim);
	}
	public String getBatterycapacity() {
		return Batterycapacity .get();
	}

	public void setBatterycapacity (String Batterycapacity ) {
		this.Batterycapacity = new SimpleStringProperty(Batterycapacity);
	}
	public String getNewfeature() {
		return Newfeature .get();
	}

	public void setNewfeature (String Newfeature ) {
		this.Newfeature = new SimpleStringProperty(Newfeature);
	}
	public String getDetails() {
		return Details .get();
	}

	public void setDetails (String Details ) {
		this.Details = new SimpleStringProperty(Details);
	}
	public String getImageLink() {
		return  ImageLink .get();
	}

	public void setImageLink (String  ImageLink ) {
		this. ImageLink = new SimpleStringProperty( ImageLink);
	}
	
	
	 public Products() {
		
	}
	 public Products(Boolean Active ,String Id, String Name, String Manufacturer, Double Price,
				String Screen, String Operating, String Rearcamera,
				String fontCamera,String CPU,String  RAM,
				String Internalmemory,String  MemoryStick,String Sim,
				String Batterycapacity,
				String Newfeature,String Details,String ImageLink) {
		 this.Active = new SimpleBooleanProperty(Active);
		 this.Id = new SimpleStringProperty(Id);
			this.Name = new SimpleStringProperty(Name);
			this.Manufacturer = new SimpleStringProperty(Manufacturer);
			this.Price = new SimpleDoubleProperty(Price);
			this.Screen = new SimpleStringProperty(Screen);
			this.Operating = new SimpleStringProperty(Operating);
			this.Rearcamera = new SimpleStringProperty(Rearcamera);
			this.fontCamera = new SimpleStringProperty(fontCamera);
			this.CPU = new SimpleStringProperty(CPU);
			this. RAM = new SimpleStringProperty( RAM);
			this.Internalmemory = new SimpleStringProperty(Internalmemory);
			this. MemoryStick = new SimpleStringProperty( MemoryStick);
			this.Sim = new SimpleStringProperty(Sim);
			this.Batterycapacity = new SimpleStringProperty(Batterycapacity);
			this.Newfeature = new SimpleStringProperty(Newfeature);
			this.Details = new SimpleStringProperty(Details);
			this.ImageLink = new SimpleStringProperty(ImageLink);
			
			
			
		}
	
	
	
	

	
	
	
	

	

}
