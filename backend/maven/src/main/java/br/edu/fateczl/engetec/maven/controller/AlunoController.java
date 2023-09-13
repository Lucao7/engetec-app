package br.edu.fateczl.engetec.maven.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.engetec.maven.model.Aluno;
import br.edu.fateczl.engetec.maven.repository.AlunoRepository;

@RestController
public class AlunoController {

	@Autowired
	private AlunoRepository _alunoRepository;
	
	@RequestMapping(value = "/aluno", method = RequestMethod.GET)
	public List<Aluno> Get() {
		return _alunoRepository.findAll();
	}
	
//	@RequestMapping(value = "/aluno/{ra}", method = RequestMethod.GET)
//	public ResponseEntity<Aluno> GetByRa(@PathVariable(value = "ra") long ra){
//		Optional<Aluno> aluno = _alunoRepository.findByRa(ra);
//	}
}

//@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
//public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id)
//{
//    Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
//    if(pessoa.isPresent())
//        return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
//    else
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//}
//
//@RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
//public Pessoa Post(@Valid @RequestBody Pessoa pessoa)
//{
//    return _pessoaRepository.save(pessoa);
//}
//
//@RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
//public ResponseEntity<Aluno> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa)
//{
//    Optional<Pessoa> oldPessoa = _alunoRepository.findByRa(ra);
//    if(oldPessoa.isPresent()){
//        Pessoa pessoa = oldPessoa.get();
//        pessoa.setNome(newPessoa.getNome());
//        _pessoaRepository.save(pessoa);
//        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
//    }
//    else
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//}
//
//@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
//public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
//{
//    Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
//    if(pessoa.isPresent()){
//        _pessoaRepository.delete(pessoa.get());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    else
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//}