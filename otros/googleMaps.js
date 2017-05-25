/*************************************/
/** Objeto manejador de google maps **/
/*************************************/

function GoogleMapsHandler(sIdMapa){

	// capa contenedora del mapa
	this.capaMapa = document.getElementById(sIdMapa);
	
	// Array de objetos punto
	this.arrPuntos = new Array();
	
	// Array de marcadores
	this.arrMarcadores = new Array();
	
	// Array de infoWindows
	this.arrInfowindows = new Array();
	
	// Objeto google maps
	this.googleMap = new GMap2(this.capaMapa);
	
	// Geocoder de Google
	this.geocoder = new GClientGeocoder();
	
	// Nivel Zoom
	this.nivelZoom = null;

	GoogleMapsHandler.COORD_PALMA = new Array(39.66 , 2.76);
	GoogleMapsHandler.NIVEL_ZOOM_DEFECTO = 13;
	

	// icono
	/*
	this.icon = new GIcon();
	this.icon.image = "/img/ico/gmaps_marker.png";
	this.icon.iconSize = new GSize(38, 38);
	this.icon.iconAnchor = new GPoint(6, 20);
	this.icon.infoWindowAnchor = new GPoint(5, 1);
	*/
}

GoogleMapsHandler.prototype.initControls = function(){
	// Añadir controles al mapa
	this.googleMap.addControl(new GMapTypeControl());
	this.googleMap.addControl(new GLargeMapControl());
	this.googleMap.addControl(new GOverviewMapControl());

}

// Interfaz para pasar un punto al manejador google maps
GoogleMapsHandler.prototype.getPunto = function(oPunto){
	this.arrPuntos[oPunto.id] = oPunto;
	this.arrMarcadores[oPunto.id] = new GMarker(oPunto.coordenadasGoogle, this.icon);
	this.generaInfoWindow(oPunto);
}


// Obtener coordenadas a partir de un string de direccion
GoogleMapsHandler.prototype.getCoordenadasGeocoder = function(sDireccion){
	var coordenadas = this.geocoder.getLatLng(sDireccion);

}

// Fija el centro del mapa
GoogleMapsHandler.prototype.fijaCentro = function(latitud, longitud){
	// Fijamos nivelZoom
	if(this.nivelZoom == null){
		var nivelZoom = GoogleMapsHandler.NIVEL_ZOOM_DEFECTO;
	}else{
		var nivelZoom = this.nivelZoom;
	}
	this.googleMap.setCenter(new GLatLng(latitud, longitud), nivelZoom, G_NORMAL_MAP);
}

// Sitúa un punto en el mapa (crea un marcador)
GoogleMapsHandler.prototype.situaPunto = function(oPunto, infowindowOnclick){

	var oThis = this;

	var marcador = new GMarker(oPunto.coordenadasGoogle, this.icon);
	
	if(infowindowOnclick == true){
		GEvent.addListener(marcador, "click", function(){
				oThis.showInfoWindow(oPunto);
			}
		);
	}
	
	this.googleMap.addOverlay(marcador);

		// Fijamos nivelZoom
	if(this.nivelZoom == null){
		var nivelZoom = GoogleMapsHandler.NIVEL_ZOOM_DEFECTO;
	}else{
		var nivelZoom = this.nivelZoom;
	}
	this.fijaCentro(oPunto.latitud, oPunto.longitud, nivelZoom);
	
}

// Genera la infoWindow de un punto
GoogleMapsHandler.prototype.generaInfoWindow = function(oPunto){

	var contenedor = document.createElement("div");
	contenedor.id = "infoWindow"+oPunto.id;
	contenedor.className = "infoWindow";
	
	// Titular de la infowindow
	var titular = document.createElement("p");
	titular.className = "titular";
	var txtInTitular = document.createTextNode("Situacion de "+oPunto.nombrePunto);
	titular.appendChild(txtInTitular);
	
	var separador = document.createElement("div");
	separador.className = "separadorH"
	
	var cajaTexto = document.createElement("div");
	cajaTexto.className = "cajaTexto";
	
	if(oPunto.imgTag != ''){
		var cajaImagen = document.createElement("div");
		cajaImagen.className = "cajaImagen";
		cajaImagen.innerHTML = oPunto.imgTag;
		// se pinta la imagen, el texto es mas estrecho
		cajaTexto.className = "cajaTexto conImagen";
	}
	
	// direccion del punto
	var direccion = document.createElement("p");
	var txtInDireccion = document.createTextNode(oPunto.direccionPunto);
	direccion.appendChild(txtInDireccion);
	
	// codigo postal del punto
	var codigoPostal = document.createElement("p");
	var txtInCodigoPostal = document.createTextNode(oPunto.codigoPostal);
	codigoPostal.appendChild(txtInCodigoPostal);
	
	// municipio del punto
	var municipio = document.createElement("p");
	var txtInMunicipio = document.createTextNode(oPunto.municipio);
	municipio.appendChild(txtInMunicipio);
	
	// caja de texto
	cajaTexto.appendChild(direccion);
	cajaTexto.appendChild(codigoPostal);
	cajaTexto.appendChild(municipio);
	
	// Componemos la caja
	contenedor.appendChild(titular);
	contenedor.appendChild(separador);
	if (oPunto.imgTag){
	   contenedor.appendChild(cajaImagen);
	}
	contenedor.appendChild(cajaTexto);
	
	// Añadimos la infowindow al array de infowindows
	this.arrInfowindows[oPunto.id] = contenedor;
	
}

GoogleMapsHandler.prototype.showInfoWindow = function(oPunto){
	this.fijaCentro(oPunto.latitud, oPunto.longitud, this.nivelZoom);
	this.googleMap.openInfoWindow(this.googleMap.getCenter(), this.arrInfowindows[oPunto.id]);
}

// obtiene un array de objetos punto
GoogleMapsHandler.prototype.getPuntos = function(arrPuntos){
	this.arrPuntos = arrPuntos;
}

GoogleMapsHandler.prototype.deshabilitaArrastrar = function(event, newMethod){
	this.googleMap.disableDragging();
}

GoogleMapsHandler.prototype.bindEvent = function(event, newMethod){
	GEvent.bind(this.googleMap, "click", this, newMethod);
}

GoogleMapsHandler.prototype.setNivelZoom = function(nivel){
	this.nivelZoom = nivel;
}



/***********************************/
/** Objeto punto para google maps **/
/***********************************/

function Punto(id, nombrePunto, direccionPunto, codigoPostal, municipio, descripcionPunto, latitud, longitud, imgTag){

	// Propiedades del objeto
	this.id = id;
	this.nombrePunto = nombrePunto;
	this.direccionPunto = direccionPunto;
	this.codigoPostal = codigoPostal;
	this.municipio = municipio;
	this.descripcionPunto = descripcionPunto;
	this.latitud = latitud;
	this.longitud = longitud;
	if(imgTag){
		this.imgTag = imgTag;
	}
	
	// Coordenadas Google
	this.coordenadasGoogle = new GLatLng(this.latitud, this.longitud);
}