package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.entity.Usuario;
//import br.com.fateczl.engetec.repository.SenhaRepository;
import br.com.fateczl.engetec.repository.UsuarioRepository;
import br.com.fateczl.engetec.senha.HashSenha;

@Service
public class UsuarioService {

	@Autowired
	private Mensagem mensagem;
		
//	@Autowired
//	private SenhaRepository senhaRepository;
	
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
	
	//Método para cadastrar alunos 
	public Usuario cadastrar(Usuario usuario, String senhaSemCiptografia) {
		byte[] salt = new byte[16];
		salt = HashSenha.generateSalt();
		usuario.setSalt(salt);
		usuario.setHashSenha(HashSenha.hashPassword(senhaSemCiptografia, salt));
		return usuarioRepository.save(usuario);
	}
	
//	private Senha salvaSenha(Senha senha) {
//		return senhaRepository.save(senha);
//	}
	
	public int countByEmail(String email) {
		return usuarioRepository.countByEmail(email);
	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return usuarioRepository.findByLogin(username);
//	}
}
