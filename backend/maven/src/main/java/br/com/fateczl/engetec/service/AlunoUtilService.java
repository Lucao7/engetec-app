package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Usuario;

@Service
public class AlunoUtilService {

	@Autowired
	private AlunoService alunoService;
	
//	public Aluno alunoServiceFindByUsuario(Usuario usuario) {
//		return alunoService.findByUsuario(usuario);
//	}
//	
//	public ResponseEntity<?> alunoServiceDelete(Long ra) {
//		return alunoService.remover(ra);
//	}
}
