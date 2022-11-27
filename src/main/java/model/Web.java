package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Web {

	//Atributos
	private StringProperty url = new SimpleStringProperty();
	
	//Constructor
	public Web(StringProperty url) {
		this.url = url;
	}
	
	public Web() {
		
	}

	
	//Metodos
	public final StringProperty urlProperty() {
		return this.url;
	}
	
	public final String getUrl() {
		return this.urlProperty().get();
	}
	
	public final void setUrl(final String url) {
		this.urlProperty().set(url);
	}
}
