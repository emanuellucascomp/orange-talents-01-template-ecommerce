package br.com.wb.mercado.pergunta;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import br.com.wb.mercado.produto.Produto;
import br.com.wb.mercado.usuario.Usuario;

public class PerguntaForm {
	
	@NotBlank
	private String titulo;
	@NotBlank
	private Long produtoId;
	
	public PerguntaForm(@NotBlank String titulo, @NotBlank Long produtoId) {
		super();
		this.titulo = titulo;
		this.produtoId = produtoId;
	}

	public Pergunta toModel(Usuario usuario, EntityManager manager) {
		Produto produto = manager.find(Produto.class, produtoId);
		return new Pergunta(titulo, produto, usuario);
	}
	
	
	
	

}
