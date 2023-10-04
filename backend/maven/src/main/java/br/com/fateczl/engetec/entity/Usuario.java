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
public class Usuario implements UserDetails{
	
	//para o aluno é o RA, para o avaliador é a matrícula
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String nome;
//	@Column(nullable = false)
//	private UsuarioRole role;
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
//		this.role = role;
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

//	public UsuarioRole getUsuarioRole() {
//		return role;
//	}
//
//	public void seteTipoUsuario(UsuarioRole role) {
//		this.role = role;
//	}
	
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


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		if(this.role == UsuarioRole.ALUNO) return List.of(new SimpleGrantedAuthority("ROLE_ALUNO"));
		return null;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return hashedSenha;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
