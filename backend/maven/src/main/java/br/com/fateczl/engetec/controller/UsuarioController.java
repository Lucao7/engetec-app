package br.com.fateczl.engetec.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Avaliador;
import br.com.fateczl.engetec.security.TokenService;
import br.com.fateczl.engetec.service.AlunoService;
import br.com.fateczl.engetec.service.AvaliadorService;
import br.com.fateczl.engetec.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	AvaliadorService avaliadorService;
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	TokenService tokenService;
	
	@DeleteMapping
	public ResponseEntity<?> remover() {
//        // Obtém a autenticação atual do contexto de segurança
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//        // Verifica se o usuário está autenticado
//		if (authentication != null && authentication.isAuthenticated()) {
//            // Obtém o tipo de usuário a partir do objeto de usuário personalizado
//            if (authentication.getPrincipal() instanceof UsuarioPersonalizado) {
//                UsuarioPersonalizado usuario = (UsuarioPersonalizado) authentication.getPrincipal();
//                String tipoUsuario = usuario.getTipoUsuario();
//                System.out.println("Tipo de usuário: " + tipoUsuario);
//            }
//        }
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
		if (authentication != null && authentication.isAuthenticated()) {
            // Obter as roles do usuário
            List<String> roles = authentication.getAuthorities().stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            
            System.out.println("Roles do usuário: " + roles);
            if(roles.get(0).equals("ROLE_ALUNO")){
        		Aluno aluno = (Aluno) authentication.getPrincipal();
//            	return alunoService.delete(aluno.getRa());
        		return usuarioService.remover(aluno.getId());
            }
            else if(roles.get(0).equals("ROLE_AVALIADOR")) {
            	Avaliador avaliador = (Avaliador) authentication.getPrincipal();
//            	return avaliadorService.delete(avaliador.getMatricula());
        		return usuarioService.remover(avaliador.getId());
            }
        }
        return new ResponseEntity("não autenticado", HttpStatus.FORBIDDEN);
	}
} 
	
