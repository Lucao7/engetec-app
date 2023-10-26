package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	//teste
//	@PostMapping("/login")
//	public void login(@RequestBody String email) {
//		System.out.println(email);
		
//		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
//		var auth = this.authenticationManager.authenticate(usernamePassword);
//		
//		var token = tokenService.generateToken((Usuario) auth.getPrincipal());
//		
//		return ResponseEntity.ok(new LoginResponseDTO(token));
		
//	}
	
//	o certo
	/*
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody String data) {
		 ObjectMapper objectMapper = new ObjectMapper();
         AuthenticationDTO authenticationDTO;
		try {
			authenticationDTO = objectMapper.readValue(data, AuthenticationDTO.class);
			System.out.println(authenticationDTO);
			
			var usernamePassword = new UsernamePasswordAuthenticationToken
					(authenticationDTO.email(), authenticationDTO.password());
			var auth = this.authenticationManager.authenticate(usernamePassword);
			
			var token = tokenService.generateToken((Usuario) auth.getPrincipal());
			
			return ResponseEntity.ok(new LoginResponseDTO(token));
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Erro ao mapear o objeto: " + e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Erro ao mapear o objeto: " + e.getMessage());
		}*/
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody AuthenticationDTO data) {
			System.out.println(data);
			var usernamePassword = new UsernamePasswordAuthenticationToken
					(data.email(), data.password());
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
