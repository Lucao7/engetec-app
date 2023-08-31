package br.edu.fateczl.engetec.maven.model;

import java.util.List;

import org.springframework.web.servlet.support.BindStatus;

import br.edu.fateczl.engetec.maven.enums.Status;
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
