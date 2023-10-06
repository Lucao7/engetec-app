package br.com.fateczl.engetec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	int countByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
		
}
