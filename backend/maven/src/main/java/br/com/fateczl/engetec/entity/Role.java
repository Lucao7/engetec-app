//package br.com.fateczl.engetec.entity;
//
//import java.util.List;
//import br.com.fateczl.engetec.entity.Usuario;
//
//
//import org.springframework.security.core.GrantedAuthority;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
//
//@Entity
//public class Role implements GrantedAuthority{
//
//	@Id
//	private String nomeRole;
//	@OneToMany(mappedBy = "role")
//	private List<Usuario> usuarios;
//	
//	public Role(String nomeRole) {
//		super();
//		this.nomeRole = nomeRole;
//	}
//
//	public String getNomeRole() {
//		return nomeRole;
//	}
//
//	public void setNomeRole(String nomeRole) {
//		this.nomeRole = nomeRole;
//	}
//
//
//
//	@Override
//	public String getAuthority() {
//		// TODO Auto-generated method stub
//		return this.nomeRole;
//	}
//
//}
