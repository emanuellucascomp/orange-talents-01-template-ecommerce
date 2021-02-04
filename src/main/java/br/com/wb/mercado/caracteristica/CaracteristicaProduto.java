package br.com.wb.mercado.caracteristica;

import br.com.wb.mercado.produto.Produto;

import javax.persistence.*;

@Entity
public class CaracteristicaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private Caracteristica caracteristica;
	@ManyToOne
	private Produto produto;
	
	public CaracteristicaProduto(Caracteristica caracteristica, Produto produto) {
		this.caracteristica = caracteristica;
		this.produto = produto;
	}

	@Deprecated
	public CaracteristicaProduto(){

	}

}
