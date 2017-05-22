package org.formacio.repositori;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // indico que esta es la entidad de mi BBDD
@XmlRootElement // per a que acepti peticions XML
public class Facturas {

	@Id // indico que esta propiedad es la primary key
	private String idFactura;
	//@JsonProperty("contacte")
	private String fecha;
	private String hora;
	private Double importe;
	private Double comision;
	
	public Facturas() {
	}

	public Facturas(String idFactura, String fecha, String hora, Double importe, Double comision) {
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.hora = hora;
		this.importe = importe;
		this.comision = comision;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
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



	//Hay que crear las claves foraneas de usuario y conductor










}
