/*js de Cotxox*/
var longitud;
var latitud;

window.onload = function() {
            inicializar_mapa();
        };



function inicializar_mapa() {
	var mapOptions = {center: new google.maps.LatLng(39.511450, 2.533794),
		zoom: 19, mapTypeId: google.maps.MapTypeId.ROADMAP
     };
    var map = new google.maps.Map(document.getElementById("mapa"), mapOptions);
	var pos = new google.maps.LatLng(39.511450, 2.533794);
	var marker = new google.maps.Marker({position: pos,
			map: map,
			title: "L",
			animation: google.maps.Animation.DROP
            });
}










function logear(){
	alert("Prueba Logear");
}


function registrar(){
	alert("Prueba Registrar");
}














$(#logear).onclick(logear());














