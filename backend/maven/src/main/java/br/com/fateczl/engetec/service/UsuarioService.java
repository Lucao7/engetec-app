package br.com.fateczl.engetec.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Mensagem;
//import br.com.fateczl.engetec.entity.Role;
import br.com.fateczl.engetec.entity.Usuario;
//import br.com.fateczl.engetec.repository.SenhaRepository;
import br.com.fateczl.engetec.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private Mensagem mensagem;
		
//	@Autowired
//	private SenhaRepository senhaRepository;
	
	@Autowired
	private AlunoUtilService alunoutilService;
	
	@Autowired
	private AvaliadorService avaliadorService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	public ResponseEntity<?> logar(String email, String senha){
//		if(usuarioRepository.countByEmail(email)==0) {
//			mensagem.setMensagem("email não existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//		} else {
//			Usuario usuario = usuarioRepository.findByEmail(email);
//			if(!HashSenha.verifyPassword(senha, usuario.getHashSenha(), 
//					usuario.getSalt())){
//				mensagem.setMensagem("senha incorreta");
//				return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//			} else {
//				mensagem.setMensagem("logado");
//				return new ResponseEntity<>(mensagem, HttpStatus.OK);
//			}
//		}
//	}
	
	public ResponseEntity<?> editar(String nome, String email, Long id) {
		if(usuarioRepository.countById(id) == 0) {
			mensagem.setMensagem("O ID informado não existe.");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}else {
			Usuario usuarioAntigo = (Usuario) usuarioRepository.findById(id).get();
			if ((email!=usuarioAntigo.getEmail())
					&&(usuarioRepository.countByEmail(email)!=0)) {
				mensagem.setMensagem("O email já existe");
				return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
			}
			usuarioAntigo.setEmail(email);
			usuarioAntigo.setNome(nome);
			usuarioRepository.save(usuarioAntigo);
			mensagem.setMensagem("Pessoa alterada com sucesso");
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}
	}
	
	//Método para cadastrar alunos 
//	public Usuario cadastrar(Usuario usuario) {
//		return usuarioRepository.save(usuario);
//	}
	
//	private Senha salvaSenha(Senha senha) {
//		return senhaRepository.save(senha);
//	}
	
	public int countByEmail(String email) {
		return usuarioRepository.countByEmail(email);
	}

	public UserDetails findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
//	public ResponseEntity<?> remover(Long id) {
//		if(usuarioRepository.countById(id) == 0) {
//			mensagem.setMensagem("O ID informado não existe.");
//			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
//		}else {
//			Optional<Usuario> usuario = usuarioRepository.findById(id);
//			usuarioRepository.deleteById(id);
//			switch (usuario.get().getRole()) { 
//				case ALUNO:
//					Aluno aluno = alunoutilService.alunoServiceFindByUsuario(usuario.get());
//					alunoutilService.alunoServiceDelete(aluno.getRa());
//					break;
//				case AVALIADOR:
//						break;
//			}
//	
//			mensagem.setMensagem("Pessoa removida com sucesso");
//			return new ResponseEntity<>(mensagem, HttpStatus.OK);
//		}
//	}

	public ResponseEntity<?> remover(Long id) {
		if(usuarioRepository.countById(id) == 0) {
			mensagem.setMensagem("O ID informado não existe.");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}else {
			usuarioRepository.deleteById(id);
			mensagem.setMensagem("Pessoa removida com sucesso");
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}
	}
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return usuarioRepository.findByLogin(username);
//	}
}
