package br.edu.fateclz.engetc.maven.model;

import enums.Aceite;
import lombok.Data;

@Data
public class Avaliacao {
	private Artigo artigo;
	private Avaliador avaliador;
	private int nota; 
	private String razao;
	private Aceite aceite;
}
