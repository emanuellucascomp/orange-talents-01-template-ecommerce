package br.com.wb.mercado.opiniao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.wb.mercado.produto.Produto;
import br.com.wb.mercado.usuario.Usuario;

@Entity
public class Opiniao {
	
	private Long id;
	private int nota;
	private String titulo;
	private String descricao;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Produto produto;
	
	public Opiniao(@Max(5) @Min(1) int nota, @NotBlank String titulo, @NotBlank @Size(max = 500) String descricao,
			Produto produto, Usuario usuario) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.produto = produto;
		this.usuario = usuario;
	}
	
	

}
