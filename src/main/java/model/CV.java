package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class CV {

	//Atributos
	private ObjectProperty<PersonalModel> personal = new SimpleObjectProperty<PersonalModel>();
	private ObjectProperty<ContactoModel> contacto = new SimpleObjectProperty<ContactoModel>();
	private ObjectProperty<FormacionModel> titulo = new SimpleObjectProperty<FormacionModel>();
	private ObjectProperty<ExperienciaModel> experiencia = new SimpleObjectProperty<ExperienciaModel>();
	private ObjectProperty<ConocimientoModel> conocimiento = new SimpleObjectProperty<ConocimientoModel>();

	//Constructor
	public CV(ObjectProperty<PersonalModel> personal, ObjectProperty<ContactoModel> contacto, ObjectProperty<FormacionModel> titulo, 
			  ObjectProperty<ExperienciaModel> experiencia, ObjectProperty<ConocimientoModel> conocimiento) {
		
		this.personal = personal;
		this.contacto = contacto;
		this.titulo = titulo;
		this.experiencia = experiencia;
		this.conocimiento = conocimiento;
	}
	
	
	//Metodos
		//personal
	public final ObjectProperty<PersonalModel> personalProperty() {
		return this.personal;
	}

	public final PersonalModel getPersonal() {
		return this.personalProperty().get();
	}
	
	public final void setPersonal(final PersonalModel personal) {
		this.personalProperty().set(personal);
	}
	

		//contacto
	public final ObjectProperty<ContactoModel> contactoProperty() {
		return this.contacto;
	}
	
	public final ContactoModel getContacto() {
		return this.contactoProperty().get();
	}
	
	public final void setContacto(final ContactoModel contacto) {
		this.contactoProperty().set(contacto);
	}
	

		//titulo
	public final ObjectProperty<FormacionModel> tituloProperty() {
		return this.titulo;
	}
	
	public final FormacionModel getTitulo() {
		return this.tituloProperty().get();
	}
	
	public final void setTitulo(final FormacionModel titulo) {
		this.tituloProperty().set(titulo);
	}
	

		//experiencia
	public final ObjectProperty<ExperienciaModel> experienciaProperty() {
		return this.experiencia;
	}
	
	public final ExperienciaModel getExperiencia() {
		return this.experienciaProperty().get();
	}
	
	public final void setExperiencia(final ExperienciaModel experiencia) {
		this.experienciaProperty().set(experiencia);
	}
	

		//conocimiento
	public final ObjectProperty<ConocimientoModel> conocimientoProperty() {
		return this.conocimiento;
	}
	
	public final ConocimientoModel getConocimiento() {
		return this.conocimientoProperty().get();
	}
	
	public final void setConocimiento(final ConocimientoModel conocimiento) {
		this.conocimientoProperty().set(conocimiento);
	}
}
