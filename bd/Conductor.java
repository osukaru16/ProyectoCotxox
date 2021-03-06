package org.proyecto.cotxox.bd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class Conductor {

	@Id // indico que esta propiedad es la primary key
	@GeneratedValue
	private Integer idConductor;
	private String password
	private String nombre;
	//private String telefon;
	private String apellidos;
	private String foto;
	private Boolean libre;

	
	public Conductor() {
	}

	public Conductor(Integer idConductor, String password,String nombre, String apellidos, String foto, Boolean libre) {
		this.idConductor = idConductor;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.foto = foto;
		this.libre = libre;
		//this.telefon = telefon;
	}

	public Integer getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Integer idConductor) {
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

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}





























	/*

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}*/





}
