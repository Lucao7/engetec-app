package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.dto.LoginUsuarioDTO;
import br.com.fateczl.engetec.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping(path = "")
	public ResponseEntity<?> logar(@Valid @RequestBody LoginUsuarioDTO loginUsuarioDTO) {
		return usuarioService.logar(loginUsuarioDTO.getEmail(), loginUsuarioDTO.getSenha());
	}
	
}
