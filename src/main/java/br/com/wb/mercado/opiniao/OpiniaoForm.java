package br.com.wb.mercado.opiniao;

import javax.persistence.EntityManager;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.wb.mercado.produto.Produto;
import br.com.wb.mercado.usuario.Usuario;


public class OpiniaoForm {
	
	@Max(5) @Min(1)
	private int nota;
	@NotBlank
	private String titulo;
	@NotBlank @Size(max = 500)
	private String descricao;
	@NotNull
	private Long produtoId;
	
	public OpiniaoForm(@Max(5) @Min(1) int nota, @NotBlank String titulo, @NotBlank @Size(max = 500) String descricao,
			@NotNull Long produtoId) {
		super();
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.produtoId = produtoId;
	}
	
	public Opiniao toModel(Usuario usuario, EntityManager manager) {
		Produto produto = manager.find(Produto.class, produtoId);
		return new Opiniao(nota, titulo, descricao, produto, usuario);
	}

}
