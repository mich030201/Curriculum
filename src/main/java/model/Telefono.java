package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefono {

	//Atributos
	private StringProperty numero = new SimpleStringProperty();
	private ObjectProperty<TipoTelefono> tipoTelefono = new SimpleObjectProperty<TipoTelefono>();
	
	//Constructor
	public Telefono(StringProperty numero, ObjectProperty<TipoTelefono> tipoTelefono) {
		this.numero = numero;
		this.tipoTelefono = tipoTelefono;
	}
	
	public Telefono() {
		
	}

	
	//Metodos
		//numero
	public final StringProperty numeroProperty() {
		return this.numero;
	}
	
	public final String getNumero() {
		return this.numeroProperty().get();
	}
	
	public final void setNumero(final String numero) {
		this.numeroProperty().set(numero);
	}
	

		//tipoTelefono
	public final ObjectProperty<TipoTelefono> tipoTelefonoProperty() {
		return this.tipoTelefono;
	}
	
	public final TipoTelefono getTipoTelefono() {
		return this.tipoTelefonoProperty().get();
	}
	
	public final void setTipoTelefono(final TipoTelefono tipoTelefono) {
		this.tipoTelefonoProperty().set(tipoTelefono);
	}
}
