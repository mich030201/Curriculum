package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {

	//Atributos
	private StringProperty direccion = new SimpleStringProperty();
	
	//Constructor
	public Email(StringProperty direccion) {
		this.direccion = direccion;
	}
	
	public Email() {
		
	}

		
	//Metodos
	public final StringProperty direccionProperty() {
		return this.direccion;
	}
	
	public final String getDireccion() {
		return this.direccionProperty().get();
	}
	
	public final void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}
}
