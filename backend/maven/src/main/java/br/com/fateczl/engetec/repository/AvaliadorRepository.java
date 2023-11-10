package br.com.fateczl.engetec.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.fateczl.engetec.entity.Avaliador;

public interface AvaliadorRepository extends UsuarioRepository<Avaliador>{

	int countByMatricula(Long matricula);

	Avaliador findByMatricula(Long matricula);
	
//  não funcionando
//	@Modifying
//    @Query("DELETE FROM AVALIADOR a WHERE a.matricula = :matricula")
//	void deleteByMatricula(Long matricula);

//	int countByEmail(String email);

}
