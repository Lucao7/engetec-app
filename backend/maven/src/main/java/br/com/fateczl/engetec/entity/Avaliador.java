package br.com.fateczl.engetec.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("AVALIADOR")
public class Avaliador extends Usuario{
//	@Id
	@Column(unique = true)
	private Long matricula;
	@OneToMany(mappedBy = "avaliador")
	private List<Avaliacao> avaliacoes;
	@ManyToMany(mappedBy = "avaliadores")
	private List<Area> areas;
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "usuario_id")
//	private Usuario usuario;
	
	public Avaliador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avaliador(Long matricula, Usuario usuario) {
		this.matricula = matricula;
//		this.usuario = usuario;
		this.setEmail(usuario.getEmail());
		this.setNome(usuario.getNome());
		this.setPassword(usuario.getPassword());
		this.setUsuarioRoles(usuario.getRole());
		this.areas = new ArrayList<Area>();
		this.avaliacoes = new ArrayList<Avaliacao>();
	}

	public Long getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public List<Area> getAreas() {
		return areas;
	}
	
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

	
}
