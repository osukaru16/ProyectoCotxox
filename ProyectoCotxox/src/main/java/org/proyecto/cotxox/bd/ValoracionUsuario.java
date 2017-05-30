package org.proyecto.cotxox.bd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class ValoracionUsuario {
	
	/** Esta Clase no es usa en la aplicacion pero enteoria es para otra aplicacion que tendrian los conductores 
	* para saber mas detalles del usuario Ej: si deja propinas altas o no. Si suele pedir conductor estando borracho.
	*
	*/
	
	

	@Id // indico que esta propiedad es la primary key
	private Integer idValoracionUsuario;
	private String valoracionUsuario;
	private String userNickName;
	private String idConductor;
	
	
	//@JsonProperty("contacte")


	public ValoracionUsuario() {
	}

	public ValoracionUsuario(Integer idValoracionUsuario, String valoracionUsuario, String userNickName, String idConductor) {
		this.idValoracionUsuario =idValoracionUsuario;
		this.valoracionUsuario = valoracionUsuario;
		this.userNickName = userNickName;
		this.idConductor = idConductor;

		
	}
	
	public Integer getIdValoracionUsuario() {
		return idValoracionUsuario;
	}

	public void setIdValoracionUsuario(Integer idValoracionUsuario) {
		this.idValoracionUsuario = idValoracionUsuario;
	}
	
	
	
	

	public String getValoracionUsuario() {
		return valoracionUsuario;
	}

	public void setValoracionUsuario(String valoracionUsuario) {
		this.valoracionUsuario = valoracionUsuario;
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
