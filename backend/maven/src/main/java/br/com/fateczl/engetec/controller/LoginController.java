package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fateczl.engetec.dto.LoginUsuarioDTO;
import br.com.fateczl.engetec.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping(path = "")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody LoginUsuarioDTO loginUsuarioDTO) {
		System.out.println(loginUsuarioDTO.toString());
		return usuarioService.logar(loginUsuarioDTO.getEmail(), loginUsuarioDTO.getSenha());
	}
	
}
