package br.edu.fateclz.engetc.maven.model;

import java.util.List;

import enums.Status;
import lombok.Data;

@Data
public class Artigo {
	private int id;
	private Aluno aluno;
	private String titulo;
	private String linkArtigoAluno;
	private String linkArtigoComite;
	private List<Area> areas;
	private String palavrasChave;
	private Status status;
	private String integrantes;
	private List<Avaliacao> avaliacoes;
}
