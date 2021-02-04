package br.com.wb.mercado.caracteristica;

import javax.validation.constraints.NotBlank;

public class CaracteristicaForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String valor;
	
	public CaracteristicaForm(@NotBlank String nome, @NotBlank String valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public Caracteristica toModel() {
		return new Caracteristica(nome, valor);
	}
}
