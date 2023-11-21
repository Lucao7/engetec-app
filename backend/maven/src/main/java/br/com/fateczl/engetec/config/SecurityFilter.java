package br.com.fateczl.engetec.config;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fateczl.engetec.entity.Usuario;
import br.com.fateczl.engetec.repository.UsuarioRepository;
import br.com.fateczl.engetec.security.ApiResponse;
import br.com.fateczl.engetec.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

	@Autowired
	TokenService tokenService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var token = this.recoverToken(request);
		if(token != null) {
			var login = tokenService.validateToken(token);
			UserDetails usuario = usuarioRepository.findByEmail(login);
			if (usuario != null) {
			    var authetication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			    SecurityContextHolder.getContext().setAuthentication(authetication);
			} else {			    
			    logger.warn("Usuário não encontrado para o token");
	            sendErrorResponse(response, HttpStatus.UNAUTHORIZED, 
	            		"Usuário não encontrado para o token.");
			}
			
		}
		filterChain.doFilter(request, response);
	}
	
	private void sendErrorResponse(HttpServletResponse response, HttpStatus status, String message) throws IOException {
	    // Construa uma resposta personalizada
	    ApiResponse apiResponse = new ApiResponse(status.value(), message);

	    // Configura a resposta HTTP
	    response.setContentType("application/json");
	    response.setStatus(status.value());
	    ObjectMapper objectMapper = new ObjectMapper();
	    response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
	}

	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if(authHeader == null) return null;
		return authHeader.replace("Bearer ", "");
	}

}
