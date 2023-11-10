package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.dto.AvaliadorDTO;
import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Avaliador;
import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.entity.Usuario;
import br.com.fateczl.engetec.entity.UsuarioRole;
import br.com.fateczl.engetec.repository.AvaliadorRepository;
import br.com.fateczl.engetec.valida.ValidaPassword;

@Service
public class AvaliadorService {

	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private AvaliadorRepository avaliadorRepository;
	
//	@Autowired
//	private UsuarioService usuarioService;
	
	//Método para cadastrar alunos 
	public ResponseEntity<?> cadastrar(AvaliadorDTO data) {
//		if (!ValidaPassword.validarTamanho(data.password())) 
//			return new ResponseEntity<>
//		("A senha deve ter no mínimo 6 caracteres", HttpStatus.BAD_REQUEST);
		if(this.avaliadorRepository.findByEmail(data.email()) != null) {
			mensagem.setMensagem("email já existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if(avaliadorRepository.countByMatricula(data.matricula())!=0){
			mensagem.setMensagem("Matricula já existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		
		Usuario usuario = new Usuario(data.email(), data.nome(), encryptedPassword, UsuarioRole.AVALIADOR);
		Avaliador avaliador = new Avaliador(data.matricula(), usuario);
		
		return new ResponseEntity<>(avaliadorRepository.save(avaliador), HttpStatus.CREATED);
	}

	public ResponseEntity<?> delete(Long documento) {
		if(avaliadorRepository.countByMatricula(documento)!=0) {
			avaliadorRepository.deleteById(
					avaliadorRepository.findByMatricula(documento).getId());
			return new ResponseEntity(HttpStatus.OK);
		}
		String mensagem = "Não há essa Matricula";
		return new ResponseEntity(mensagem, HttpStatus.NOT_FOUND);
	}
	
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
