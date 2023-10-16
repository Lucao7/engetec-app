package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.dto.AuthenticationDTO;
import br.com.fateczl.engetec.dto.LoginResponseDTO;
import br.com.fateczl.engetec.entity.Usuario;
import br.com.fateczl.engetec.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
//	@Autowired
//	UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Usuario) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
		
	}
	
//	@PostMapping(path = "")
//	public ResponseEntity<?> cadastrar(@Valid @RequestBody LoginUsuarioDTO loginUsuarioDTO) {
//		System.out.println(loginUsuarioDTO.toString());
//		return usuarioService.logar(loginUsuarioDTO.getEmail(), loginUsuarioDTO.getSenha());
//	}
//	
//	@GetMapping("/login")
//	String login() {
//		return "login";
//	}
	
}
