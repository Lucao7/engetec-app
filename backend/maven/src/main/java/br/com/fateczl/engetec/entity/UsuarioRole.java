package br.com.fateczl.engetec.entity;

public enum UsuarioRole {

	ALUNO("aluno"), 
	AVALIADOR("avaliador"), 
	COMITE("comite");
	
	private String role;
	
	private UsuarioRole(String role) {
		// TODO Auto-generated constructor stub
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
