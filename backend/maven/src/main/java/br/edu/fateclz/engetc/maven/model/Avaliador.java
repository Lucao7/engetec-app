package br.edu.fateclz.engetc.maven.model;

import java.util.List;

import lombok.Data;

@Data
public class Avaliador extends Usuario{
	private String matricula;
	private List<Avaliacao> avaliacoes;
	private List<Area> areas;
}
