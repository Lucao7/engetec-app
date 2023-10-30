package br.com.fateczl.engetec.dto;

import java.util.List;

import br.com.fateczl.engetec.entity.Area;
import br.com.fateczl.engetec.entity.Avaliacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AvaliadorDTO (
	@Valid @NotNull(message = "Informe um número de matrícula válido")
	@Positive(message = "Informe um número de matrícula válido")
	Long matricula,
	@Valid @NotBlank(message = "Informe um e-mail válido")
	@Email(message = "Informe um e-mail válido")
	String email,
	@Valid @NotBlank(message = "Informe um nome válido")
	String nome,
	@Valid @NotBlank(message = "Informe uma senha válida")
	@Size(min = 6, message = "a senha deve conter no mínimo 6 caracteres")
	String password){}
