package br.com.fateczl.engetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Usuario;

@Repository
public interface AlunoRepository extends UsuarioRepository<Aluno>{

	List<Aluno> findAll();
	
	Aluno findByRa(Long ra);
	
//	Aluno findByUsuario(Usuario usuario);
//	List<Aluno> findByOrderByNomeAsc();
//	
//	List<Aluno> findByOrderByNomeDesc();
//	
//	List<Aluno> findByNome(String nome);
//	
//	List<Aluno> findByNomeOrderByRaDesc(String nome);
//	
//	List<Aluno> findByNomeContaining(String termo);
//	
//	List<Aluno> findByNomeStartsWith(String termo);
//	
//	List<Aluno> findByNomeEndsWith(String termo);
	
	int countByRa(Long ra);
	
// não está funcionando
//	@Modifying
//    @Query("DELETE FROM ALUNO a WHERE a.ra = :ra")
//	void deleteByRa(Long ra);
	
}