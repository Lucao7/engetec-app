package br.com.fateczl.engetec.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(String email, String password) {

//	@NotBlank(message = "Informe um e-mail válido")
//	@Email(message = "Informe um e-mail válido")
//	private String email;
//	@NotBlank(message = "Informe uma senha válida")
//	private String senha;
	
//	public AuthenticationDTO(String email, String senha) {
//	super();
//	this.email = email;
//	this.senha = senha;
//	}

//	public AuthenticationDTO() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public String getEmail() {
//		return email;
//	}
//	
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	public String getSenha() {
//		return senha;
//	}
//	
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//	@Override
//	public String toString() {
//		return "LoginUsuarioDTO [email=" + email + ", senha=" + senha + "]";
//	}
	
	
	
}
