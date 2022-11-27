package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma extends ConocimientoModel{

	//Atributos
	private StringProperty certificacion = new SimpleStringProperty();
	
	//Constructor
	public Idioma(StringProperty denominacion, ObjectProperty<Nivel> nivel, StringProperty certificacion) {
		super();
		this.certificacion = certificacion;
	}

	
	//Metodos
	public final StringProperty certificacionProperty() {
		return this.certificacion;
	}

	public final String getCertificacion() {
		return this.certificacionProperty().get();
	}
	
	public final void setCertificacion(final String certificacion) {
		this.certificacionProperty().set(certificacion);
	}
}
