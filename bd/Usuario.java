package org.foobarspam.cotxox.bd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class Usuario {

	@Id // indico que esta propiedad es la primary key
	private String nickname;
	//@JsonProperty("contacte")
	private String nombre;
	private String apellidos;
	private String telefon;
	private String foto;
	private String email;

	public Usuario() {
	}

	public Usuario(String nickname, String nombre, String apellidos, String telefon, String foto, String email) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefon = telefon;
		this.foto = foto;
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
