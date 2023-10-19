package br.com.fateczl.engetec.dto;

import br.com.fateczl.engetec.entity.UsuarioRole;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AlunoDTO (
		@Valid	@NotNull(message = "Informe um RA válido") 
		@Positive(message = "Informe um RA válido") Long ra, 
		@Valid @Email(message = "Informe um e-mail válido") String email, 
		@Valid @NotBlank(message = "Informe um nome válido") String nome,
		@Valid @NotBlank(message = "Informe uma senha válida") 
		@Size(min = 6, message = "a senha deve conter no mínimo 6 caracteres") 
		String password) 
{
}

//public class AlunoDTO {
//		@NotNull(message = "Informe um RA válido")
//		@Positive(message = "Informe um RA válido")
//		private Long ra;
//		@NotBlank(message = "Informe um e-mail válido")
//		@Email(message = "Informe um e-mail válido")
//		private String email;
//		@NotBlank(message = "Informe um nome válido")
//		private String nome;
//		@NotBlank(message = "Informe uma senha válida")
//		private String senha;
//
//		public Long getRa() {
//			return ra;
//		}
//
//		public void setRa(Long ra) {
//			this.ra = ra;
//		}
//
//		public String getEmail() {
//			return email;
//		}
//
//		public void setEmail(String email) {
//			this.email = email;
//		}
//
//		public String getNome() {
//			return nome;
//		}
//
//		public void setNome(String nome) {
//			this.nome = nome;
//		}
//
//		public String getSenha() {
//			return senha;
//		}
//
//		public void setSenha(String senha) {
//			this.senha = senha;
//		}
//
//		@Override
//		public String toString() {
//			return "Aluno [ra=" + ra + ", email=" + email + ", nome=" + nome + ", senha=" + senha
//					+ "]";
//		}
//
//	}

	
