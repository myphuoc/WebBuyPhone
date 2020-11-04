package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Manufacture {
	private BooleanProperty Active;
	private StringProperty Id_manufacture;
	private StringProperty Name_Manufacturer;
	
public Manufacture() {
		
	}
	public Boolean getActive() {
		return Active.get();
	}
	public void setActive(Boolean Active) {
		this.Active = new SimpleBooleanProperty(Active);
	}
	public String getId_manufacture() {
		return Id_manufacture.get();
	}
	public void setId_manufacture(String Id_manufacture) {
		this.Id_manufacture = new SimpleStringProperty(Id_manufacture);
	}
	public void setName_Manufacturer(String Name_Manufacturer) {
		this.Name_Manufacturer = new SimpleStringProperty(Name_Manufacturer);
	}
	public String getName_Manufacturer() {
		return Name_Manufacturer.get();
	}
	
	public Manufacture(Boolean Active,String Id_manufacture,String Name_Manufacturer)
	{
		this.Active = new SimpleBooleanProperty(Active);
		this.Id_manufacture = new SimpleStringProperty(Id_manufacture);
		this.Name_Manufacturer = new SimpleStringProperty(Name_Manufacturer);
	}
	
	
}



