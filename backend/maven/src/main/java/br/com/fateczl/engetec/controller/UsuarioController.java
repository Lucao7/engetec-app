package br.com.fateczl.engetec.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@DeleteMapping(path = "/{documento}")
	public ResponseEntity<?> remover(@PathVariable Long documento) {
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

        if (authentication != null && authentication.isAuthenticated()) {
            // Obter as roles do usuário
            List<String> roles = authentication.getAuthorities().stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());

            // Fazer algo com as roles
            System.out.println("Roles do usuário: " + roles);
            
            if(roles.get(0).equals("ROLE_ALUNO")){
            	return alunoService.delete(documento);
            }
            else if(roles.get(0).equals("ROLE_AVALIADOR")) {
            	return avaliadorService.delete(documento);
            }
            
        }
        return new ResponseEntity("não autenticado", HttpStatus.FORBIDDEN);
	}
        
	
}
