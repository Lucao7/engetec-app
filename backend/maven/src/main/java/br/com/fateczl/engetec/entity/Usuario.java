package br.com.fateczl.engetec.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
//	@ManyToOne
//	@JoinColumn(name = "role_nomeRole", nullable = false)
	private UsuarioRole role;
//	@Column(nullable = false)
//	private String hashedSenha;
//	@Column(nullable = false)
//	private byte[] salt;
	@Column(nullable = false)
	private String password;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String email, String nome) {
		this.email = email;
		this.nome = nome;
	}

	public Usuario(String email, String nome, String encryptedPassword, UsuarioRole role) {
		this.email = email;
		this.nome = nome;
		this.password = encryptedPassword;
		this.role = role;
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
	
//	public String getHashSenha() {
//		return hashedSenha;
//	}
//	public void setHashSenha(String hashedSenha) {
//		this.hashedSenha = hashedSenha;
//	}
//	public byte[] getSalt() {
//		return salt;
//	}
//	public void setSalt(byte[] salt) {
//		this.salt = salt;
//	}

	public UsuarioRole getRole() {
		return role;
	}

	public void setUsuarioRoles(UsuarioRole role) {
		this.role = role;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UsuarioRole.ALUNO) {
			return List.of(new SimpleGrantedAuthority("ROLE_ALUNO"));
		} else if(this.role == UsuarioRole.AVALIADOR) {
			return List.of(new SimpleGrantedAuthority("ROLE_AVALIADOR"));
		}
		
		return new ArrayList<>();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	@Override
	public String getPassword() {
		return password;
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
