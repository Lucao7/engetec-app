package br.com.fateczl.engetec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.fateczl.engetec.entity.Usuario;

@Repository
//public interface UsuarioRepository <T extends Usuario> extends CrudRepository<T, Long>{
public interface UsuarioRepository <T extends Usuario> extends CrudRepository<T, Long>{

	int countByEmail(String email);
	
	int countById(Long id);
	//Optional<Usuario> findByEmail(String email);
	
	Optional<T> findById(Long id);
	//UserDetails findByLogin(String email);
	UserDetails findByEmail(String email);
//	Optional<Usuario> findByEmail(String email);
		
}
