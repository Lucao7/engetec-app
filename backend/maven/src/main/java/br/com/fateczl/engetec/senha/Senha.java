/*package br.com.fateczl.engetec.senha;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Senha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@OneToOne(mappedBy = "senha")
//	private Aluno aluno;
	
	public Senha(String hashedSenha, byte[] salt) {
		this.hashedSenha = hashedSenha;
		this.salt = salt;
	}
	
	public Senha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Aluno getAluno() {
//		return aluno;
//	}
//
//	public void setAluno(Aluno aluno) {
//		this.aluno = aluno;
//	}


	
	
}
*/
