package org.proyecto.cotxox.bd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class Usuario {

	@Id // indico que esta propiedad es la primary key
	private String nickName;
	//@JsonProperty("contacte")
	private String nombre;
	private String apellidos;
	private String telefon;
	private String foto;
	private String email;

	public Usuario() {
	}

	public Usuario(String nickName, String nombre, String apellidos, String telefon, String foto, String email) {
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefon = telefon;
		this.foto = foto;
		this.email = email;
	}

	public String getnickName() {
		return nickName;
	}

	public void setnickName(String nickName) {
		this.nickName = nickName;
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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFoto(){
		return foto;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}







































}
