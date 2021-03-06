package br.com.wb.mercado.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.wb.mercado.caracteristica.Caracteristica;
import br.com.wb.mercado.caracteristica.CaracteristicaProduto;
import br.com.wb.mercado.categoria.Categoria;
import br.com.wb.mercado.imagem.Imagem;
import br.com.wb.mercado.usuario.Usuario;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal valor;
	private int quantidadeDisponivel;
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CaracteristicaProduto> caracteristicas = new ArrayList<>();
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Imagem> imagens = new ArrayList<>();
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
		this.caracteristicas = caracteristicas.stream().map(caracteristica -> caracteristica.comProduto(this)).collect(Collectors.toList());
		this.criador = usuario;
	}

	@Deprecated
	public Produto(){

	}

	public Usuario getCriador(){
		return criador;
	}
}
