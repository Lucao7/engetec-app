package br.com.fateczl.engetec.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fateczl.engetec.entity.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;
	
	public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//			try {
//				Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
//				return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//						usuario.getEmail(), usuario.getHashSenha(), new ArrayList<>()));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				throw new RuntimeException("Falha ao autenticar usuário", e);
//			}
//
//	
//	}
	
//	@Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//
//        DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
//
//        String token = JWT.create().
//                withSubject(usuarioData.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
//                .sign(Algorithm.HMAC512(TOKEN_SENHA));
//
//        response.getWriter().write(token);
//        response.getWriter().flush();
//    }

	@Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            Usuario usuario = new ObjectMapper()
                    .readValue(request.getInputStream(), Usuario.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(),
                    usuario.getPassword(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuario", e);
        }

    }

}
