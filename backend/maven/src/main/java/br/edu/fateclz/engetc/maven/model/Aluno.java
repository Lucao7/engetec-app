package br.edu.fateclz.engetc.maven.model;

import java.util.List;

import lombok.Data;

@Data
public class Aluno extends Usuario{
	private String ra;
	private List<Artigo> artigos;
}

