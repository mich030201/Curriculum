package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {

	//Atributos
	protected StringProperty denominacion = new SimpleStringProperty();
	
	//Constructor
	public Nacionalidad(StringProperty denominacion) {
		this.denominacion = denominacion;
	}

	
	public Nacionalidad() {
		// TODO Auto-generated constructor stub
	}


	//Metodos
	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	
	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	@Override
	public String toString() {
		return getDenominacion();
	}
}
