package br.com.fateczl.engetec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.fateczl.engetec.entity.Usuario;

@NoRepositoryBean
public interface UsuarioBaseRepository<T extends Usuario> extends CrudRepository<T, Long> {

}
