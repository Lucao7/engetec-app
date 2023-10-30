package br.com.fateczl.engetec.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fateczl.engetec.entity.Avaliador;

public interface AvaliadorRepository extends CrudRepository<Avaliador, Long>{

	int countByMatricula(Long matricula);

//	int countByEmail(String email);

}
