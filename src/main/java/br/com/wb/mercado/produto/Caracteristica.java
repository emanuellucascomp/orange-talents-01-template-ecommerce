package br.com.wb.mercado.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Caracteristica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String valor;
	@ManyToOne
	private Produto produto;
	
	public Caracteristica(@NotBlank String nome, @NotBlank String valor) {
		this.nome = nome;
		this.valor = valor;
	}

	@Deprecated
	public Caracteristica(){

	}

}
