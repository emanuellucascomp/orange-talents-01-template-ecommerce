package br.com.wb.mercado.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.wb.mercado.categoria.Categoria;

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
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	public Produto(@NotBlank String nome, @Positive BigDecimal valor, @Positive int quantidadeDisponivel,
			@NotBlank @Size(max = 1000) String descricao, Categoria categoria, List<Caracteristica> caracteristicas) {
		this.nome = nome;
		this.valor = valor;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.descricao = descricao;
		this.categoria = categoria;
		this.caracteristicas = caracteristicas;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", quantidadeDisponivel="
				+ quantidadeDisponivel + ", caracteristicas=" + caracteristicas + ", descricao=" + descricao
				+ ", categoria=" + categoria + ", dataCadastro=" + dataCadastro + "]";
	}

}
