package br.com.wb.mercado.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import br.com.wb.mercado.config.validacao.UniqueValue;

public class CategoriaForm {
	
	@NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome de categoria já cadastrado")
	private String nome;
	private Long categoriaPrincipalId;

	public CategoriaForm(@NotBlank String nome, Long categoriaPrincipalId) {
		super();
		this.nome = nome;
		this.categoriaPrincipalId = categoriaPrincipalId;
	}

	public Categoria toModel(EntityManager manager) {
		Categoria categoria = new Categoria(nome);
		if(categoriaPrincipalId != null) {
			Categoria categoriaPrincipal = manager.find(Categoria.class, categoriaPrincipalId);	
			categoria.setCategoriaPrincipal(categoriaPrincipal);
		}
		return categoria;
	}

}
