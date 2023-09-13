package br.edu.fateczl.engetec.maven.model;

import java.util.List;

import br.edu.fateczl.engetec.maven.model.Usuario;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Aluno extends Usuario{
	private Long ra;
	private List<Artigo> artigos;
}

