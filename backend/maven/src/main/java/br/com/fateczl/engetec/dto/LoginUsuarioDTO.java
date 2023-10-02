package br.com.fateczl.engetec.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginUsuarioDTO {

	@NotBlank(message = "Informe um e-mail válido")
	@Email(message = "Informe um e-mail válido")
	private String email;
	@NotBlank(message = "Informe uma senha válida")
	private String senha;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
