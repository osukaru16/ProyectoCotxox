package org.formacio.repositori;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class Conductores {

	@Id // indico que esta propiedad es la primary key
	private String idConductor;
	//@JsonProperty("contacte")
	private String nombre;
	//private String telefon;

	private String apellidos;
	private String foto;
	private Boolean libre;

	
	public Conductores() {
	}

	public Conductores(String idConductor, String nombre, String apellidos, String foto, Boolean libre) {
		this.idConductor = idConductor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.foto = foto;
		this.libre = libre;
		//this.telefon = telefon;
	}

	public String getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(String idConductor) {
		this.idConductor = idConductor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos(){
		return apellidos;
	}

	public void setApellidos(String apellidos){
		this.apellidos =  apellidos;
	}

	public String getFoto(){
		return foto;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public Boolean getLibre(){
		return libre;
	}

	public void setLibre(Boolean libre){
		this.libre = libre;
	}


	//Pendiente la clave foranea del coche





























	/*

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}*/





}
