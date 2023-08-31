package br.edu.fateczl.engetec.maven.model;

import br.edu.fateczl.engetec.maven.enums.Aceite;
import lombok.Data;

@Data
public class Avaliacao {
	private Artigo artigo;
	private Avaliador avaliador;
	private int nota; 
	private String razao;
	private Aceite aceite;
}
