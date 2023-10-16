package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.repository.AvaliadorRepository;

@Service
public class AvaliadorService {

	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private AvaliadorRepository avaliadorRepository;
	
//	@Autowired
//	private SenhaRepository senhaRepository;
	
	
//	public ResponseEntity<?> cadastrar(AvaliadorDTO avaliadorDTO) {
//		Senha objSenha = hashSenha.tratamentoSenha(avaliadorDTO.getSenha());
//		Avaliador avaliador = AvaliadorDtoToAvaliador(avaliadorDTO, objSenha);
//		if((avaliadorRepository.countByEmail(avaliador.getEmail())!=0)||(alunoService.countByEmail(avaliador.getEmail())!=0)){
//			mensagem.setMensagem("email já existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//		} else {
//			senhaRepository.save(avaliador.getSenha());
//			return new ResponseEntity<>(avaliadorRepository.save(avaliador), HttpStatus.CREATED);
//		}
//	}
//
//	private Avaliador AvaliadorDtoToAvaliador(AvaliadorDTO avaliadorDTO, Senha objSenha) {
//		Avaliador avaliador = new Avaliador(avaliadorDTO.getMatricula(), avaliadorDTO.getAvaliacoes(), 
//				avaliadorDTO.getAreas(), avaliadorDTO.getEmail(), avaliadorDTO.getNome(), objSenha);
//		return avaliador;
//	}
//
//	public int countByEmail(String email) {
//		return avaliadorRepository.countByEmail(email);
//	}
//	
}
