package br.com.wb.mercado.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nome;
	private Categoria categoriaPrincipal;

	public Categoria(@NotBlank String nome, Categoria categoriaPrincipal) {
		Assert.isTrue(StringUtils.hasLength(nome), "Nome é obrigatório");
		
		this.nome = nome;
		this.categoriaPrincipal = categoriaPrincipal;
	}

}
