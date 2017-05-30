package org.proyecto.cotxox.repositori;

import org.proyecto.cotxox.bd.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	
	public Usuario findByNickname(String nickName);

}
