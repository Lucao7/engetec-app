package br.com.fateczl.engetec.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.fateczl.engetec.data.DetalheUsuarioData;
import br.com.fateczl.engetec.entity.Usuario;
import br.com.fateczl.engetec.repository.UsuarioRepository;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	public DetalheUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
		}
		return new DetalheUsuarioData(usuario);
	}

}
