package org.proyecto.cotxox.bd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class ValoracionConductor {

	@Id // indico que esta propiedad es la primary key
	private Integer idValoracionConductor;
	private Integer valoracion;
	private String userNickName;
	private String idConductor;
	
	
	//@JsonProperty("contacte")


	public ValoracionConductor() {
	}

	public ValoracionConductor(Integer idValoracionConductor, Integer valoracion, String userNickName, String idConductor) {
		this.idValoracionConductor =idValoracionConductor;
		this.valoracion = valoracion;
		this.userNickName = userNickName;
		this.idConductor = idConductor;

		
	}
	
	public Integer getIdValoracionConductor() {
		return idValoracionConductor;
	}

	public void setIdValoracionConductor(Integer idValoracionConductor) {
		this.idValoracionConductor = idValoracionConductor;
	}
	
	
	
	

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	
	
	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	
	
	public String getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(String idConductor) {
		this.idConductor = idConductor;
	}








































}
