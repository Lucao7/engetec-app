package br.com.fateczl.engetec.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	//para o aluno é o RA, para o avaliador é a matrícula
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String hashedSenha;
	@Column(nullable = false)
	private byte[] salt;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Usuario(String email, String nome, UsuarioRole role) {
		this.email = email;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getHashSenha() {
		return hashedSenha;
	}
	public void setHashSenha(String hashedSenha) {
		this.hashedSenha = hashedSenha;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

}
