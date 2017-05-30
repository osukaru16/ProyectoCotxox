package org.proyecto.cotxox.repositori;


import org.proyecto.cotxox.bd.Conductor;
import org.springframework.data.repository.CrudRepository;

public interface ConductorRepository extends CrudRepository<Conductor, Integer> {
	
	public Conductor findByNombre(String nombreConductor);
	public Conductor findByLibre(Boolean libre);

}
