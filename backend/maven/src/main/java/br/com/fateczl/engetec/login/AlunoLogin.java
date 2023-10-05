package br.com.fateczl.engetec.login;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AlunoLogin {
	@NotNull(message = "Informe um RA válido")
	private Long ra;
	@NotBlank(message = "Informe uma senha válida")
	private String senha;
	
	public AlunoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlunoLogin(Long ra, String senha) {
		super();
		this.ra = ra;
		this.senha = senha;
	}

	public Long getRa() {
		return ra;
	}
	
	public void setRa(Long ra) {
		this.ra = ra;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
