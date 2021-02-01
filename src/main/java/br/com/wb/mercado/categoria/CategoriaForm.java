package br.com.wb.mercado.categoria;

import javax.validation.constraints.NotBlank;

import br.com.wb.mercado.config.validacao.UniqueValue;

public class CategoriaForm {
	
	@NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome de categoria já cadastrado")
	private String nome;
	private Categoria categoriaPrincipal;

	public CategoriaForm(@NotBlank String nome, Categoria categoriaPrincipal) {
		super();
		this.nome = nome;
		this.categoriaPrincipal = categoriaPrincipal;
	}

	public Categoria toModel() {
		return new Categoria(nome, categoriaPrincipal);
	}

}
