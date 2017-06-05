package org.proyecto.cotxox.bd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class Coche {

	@Id // indico que esta propiedad es la primary key
	private String matricula;
	private String modelo;
	private String foto;
	@ManyToOne
	private Conductor conductor;
	
	public Coche() {
	}

	public Coche(String matricula, String modelo, String foto, Conductor conductor) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.foto = foto;
		this.conductor = conductor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Conductor getConductor(){
		return conductor;
	}
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}













}
