package org.proyecto.cotxox.bd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class Factura {

	@Id // indico que esta propiedad es la primary key
	@GeneratedValue
	private Integer idFactura;
	//@JsonProperty("contacte")
	private String fecha;
	private String hora;
	private Double importe;
	private Double comision;
	@ManyToOne
	private Conductor conductor;
	@ManyToOne
	private Usuario user;
	
	public Factura() {
	}

	public Factura(Integer idFactura, String fecha, String hora, Double importe, Double comision, Conductor conductor, Usuario user) {
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.hora = hora;
		this.importe = importe;
		this.comision = comision;
		this.conductor = conductor;
		this.user = user;
		
		
		
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	public Double getImporte(){
		return importe;
	}
	
	public void getImporte(Double importe){
		 this.importe = importe;
	}
	
	
	public Double getComision(){
		return comision;
	}
	
	public void getComision(Double comision){
		 this.comision = comision;
	}

	
	
	
	
	
	
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}
	
	public void setUsuario(Usuario user){
		this.user = user;
	}
	
	
	
	


	//Hay que crear las claves foraneas de usuario y conductor










}
