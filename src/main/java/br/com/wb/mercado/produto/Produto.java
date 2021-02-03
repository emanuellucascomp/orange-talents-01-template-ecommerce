package br.com.wb.mercado.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.wb.mercado.categoria.Categoria;
import br.com.wb.mercado.usuario.Usuario;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal valor;
	private int quantidadeDisponivel;
	@OneToMany(mappedBy = "produto")
	private List<Caracteristica> caracteristicas = new ArrayList<>();
	private String descricao;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Usuario criador;
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	public Produto(@NotBlank String nome, @Positive BigDecimal valor, @Positive int quantidadeDisponivel,
			@NotBlank @Size(max = 1000) String descricao, Categoria categoria, List<Caracteristica> caracteristicas, Usuario usuario) {
		this.nome = nome;
		this.valor = valor;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.descricao = descricao;
		this.categoria = categoria;
		this.caracteristicas = caracteristicas;
		this.criador = usuario;
	}

	@Deprecated
	public Produto(){

	}
}
