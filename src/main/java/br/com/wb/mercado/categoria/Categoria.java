package br.com.wb.mercado.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	private Categoria categoriaPrincipal;
	
	@Deprecated
	public Categoria() {
		
	}

	public Categoria(@NotBlank String nome) {
		Assert.isTrue(StringUtils.hasLength(nome), "Nome é obrigatório");
		
		this.nome = nome;
	}
	
	public void setCategoriaPrincipal(Categoria categoriaPrincipal) {
		this.categoriaPrincipal = categoriaPrincipal;
	}

}
