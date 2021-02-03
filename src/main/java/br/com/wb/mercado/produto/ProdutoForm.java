package br.com.wb.mercado.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.wb.mercado.categoria.Categoria;

public class ProdutoForm {
	
	@NotBlank
	private String nome;
	@NotNull @Positive
	private BigDecimal valor;
	@NotNull @Positive
	private int quantidadeDisponivel;
	@NotBlank @Size(max = 1000)
	private String descricao;
	@NotNull
	private Long categoriaId;
	@NotNull @Size(min = 3)
	private List<CaracteristicaForm> caracteristicas;

	public ProdutoForm(@NotBlank String nome, @Positive BigDecimal valor, @Positive int quantidadeDisponivel, @NotBlank @Size(max = 1000) String descricao, Long categoriaId, @Size(min = 3) List<CaracteristicaForm> caracteristicas) {
		this.nome = nome;
		this.valor = valor;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.descricao = descricao;
		this.categoriaId = categoriaId;
		this.caracteristicas = caracteristicas;
	}

	public Produto toModel(EntityManager manager) {
		Categoria categoria = manager.find(Categoria.class, categoriaId);
		List<Caracteristica> caracteristicasAdicionadas = new ArrayList<>();
		caracteristicas.forEach(caracteristica -> {
			caracteristicasAdicionadas.add(caracteristica.toModel());
		});
		
		return new Produto(nome, valor, quantidadeDisponivel, descricao, categoria, caracteristicasAdicionadas);
	}
	
}
