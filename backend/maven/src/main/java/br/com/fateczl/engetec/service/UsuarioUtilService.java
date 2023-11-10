package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.entity.Usuario;

@Service
// classe com métodos que envolvem relação entre UsuarioService e outras classes
// classe criada para evitar referências circulares entre UsuarioService e outras classes
public class UsuarioUtilService {
	
	@Autowired 
	private UsuarioService usuarioService;
	
	public UserDetails usuarioServiceFindByEmail(String email) {
		return usuarioService.findByEmail(email);
	}
	
//	public Usuario usuarioServiceCadastrar(Usuario usuario) {
//		return usuarioService.cadastrar(usuario);
//	}
}
