package org.proyecto.cotxox.servicio;

import org.proyecto.cotxox.repositori.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorServicio {
	
	@Autowired
	private ConductorRepository conductorRepository;
	
	
	public boolean existe(String nombre){
		if(conductorRepository.findByNombre(nombre) == null){
			return false;
		}
		else
			return true;
	}
	
	
	
	
	
	
	
	

}
