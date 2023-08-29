package br.edu.fateclz.engetc.maven.model;

import java.util.List;

import lombok.Data;

@Data
public class Area {
	private int id;
	private String nome;
	private List<Artigo> artigos;
	private List<Avaliador> avaliadores;
}
