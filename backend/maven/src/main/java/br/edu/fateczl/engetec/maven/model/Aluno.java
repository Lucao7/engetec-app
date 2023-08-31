package br.edu.fateczl.engetec.maven.model;

import java.util.List;

import br.edu.fateczl.engetec.maven.model.Usuario;
import lombok.Data;

@Data
public class Aluno extends Usuario{
	private String ra;
	private List<Artigo> artigos;
}

