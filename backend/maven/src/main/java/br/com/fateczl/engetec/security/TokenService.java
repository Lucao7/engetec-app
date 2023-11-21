package br.com.fateczl.engetec.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;

import br.com.fateczl.engetec.entity.Usuario;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generateToken (Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("engetec-api")
					.withSubject(usuario.getEmail())
					// Inclui o atributo id no token
					.withClaim("id", usuario.getId())  
					.withExpiresAt(genExpirationDate())
					.sign(algorithm);
			return token;
		} catch (JWTCreationException exception){
			throw new RuntimeException("Error while generating token", exception);
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("engetec-api")
					.build()
					.verify(token)
					.getSubject();
		} catch (TokenExpiredException  e) {
		        // Token expirado, retorna uma resposta HTTP 401 Unauthorized com uma mensagem
			return "Token expirado. Faça login novamente.";
		} catch (JWTVerificationException exception){
			//return "";
	        return "Token inválido. Faça login novamente.";
		} 
			//return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token expirado. Faça login novamente.");
//    } catch (JWTVerificationException exception) {
//        // Outro erro de validação, retorna uma resposta HTTP 401 Unauthorized com uma mensagem
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido. Faça login novamente.");
//    }
	}
	
	public Long getUserId(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Map<String, Claim> claims = JWT.require(algorithm)
                    .withIssuer("engetec-api")
                    .build()
                    .verify(token)
                    .getClaims();

            Long id = claims.get("id").asLong();
            return id;  // Retorna o ID como uma String
        } catch (TokenExpiredException e) {
            // Token expirado
            throw new RuntimeException("Token expirado. Faça login novamente.");
        } catch (JWTVerificationException e) {
            // Token inválido
            throw new RuntimeException("Token inválido. Faça login novamente.");
        }
    }
	
	private Instant genExpirationDate() {
		//EXPIRA EM 2 HORAS
//		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
		return LocalDateTime.now().plusSeconds(30).toInstant(ZoneOffset.of("-03:00"));
	}
}
