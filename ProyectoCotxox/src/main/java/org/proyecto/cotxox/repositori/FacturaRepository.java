package org.proyecto.cotxox.repositori;

import org.proyecto.cotxox.bd.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Integer>{
	
	
	public Factura findByIdFactura(Integer id);
}
