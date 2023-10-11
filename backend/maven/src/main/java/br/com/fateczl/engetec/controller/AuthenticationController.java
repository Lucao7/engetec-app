package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fateczl.engetec.dto.AuthenticationDTO;
import br.com.fateczl.engetec.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
//	@Autowired
//	UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		return ResponseEntity.ok().build();
		
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
