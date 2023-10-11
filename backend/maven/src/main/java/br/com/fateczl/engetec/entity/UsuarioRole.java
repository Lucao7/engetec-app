package br.com.fateczl.engetec.entity;

public enum UsuarioRole {
	ALUNO("aluno"),
	AVALIADOR("avaliador");
	
	private String role;
	
	UsuarioRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}

}
