package br.com.fateczl.engetec.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//classe para salvar os artigos recebidos por upload em uma pasta
@Component
public class Disco {

	@Value("${disco.raiz}")
	private String raiz;
	
	@Value("${disco.diretorio-artigos}")
	private String diretorioArtigos;
	
	public void salvarArtigo(MultipartFile artigo) {
		this.salvar(this.diretorioArtigos, artigo);
	}
	
	public void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}
		
	}
}
