package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FormacionModel {

	//Atributos
	private ObjectProperty<LocalDate> desde = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<LocalDate>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	
	
	//Metodos
	
		//desde
	public final ObjectProperty<LocalDate> desdeProperty() {
		return this.desde;
	}
	
	public final LocalDate getDesde() {
		return this.desdeProperty().get();
	}
	
	public final void setDesde(final LocalDate desde) {
		this.desdeProperty().set(desde);
	}
	

		//hasta
	public final ObjectProperty<LocalDate> hastaProperty() {
		return this.hasta;
	}
	
	public final LocalDate getHasta() {
		return this.hastaProperty().get();
	}
	
	public final void setHasta(final LocalDate hasta) {
		this.hastaProperty().set(hasta);
	}
	

		//denominacion
	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	
	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	

		//organizador
	public final StringProperty organizadorProperty() {
		return this.organizador;
	}
	
	public final String getOrganizador() {
		return this.organizadorProperty().get();
	}
	
	public final void setOrganizador(final String organizador) {
		this.organizadorProperty().set(organizador);
	}
}
