package br.com.wb.mercado.caracteristica;

import br.com.wb.mercado.produto.Produto;

import javax.persistence.Embeddable;

@Embeddable
public class Caracteristica {

    private String nome;
    private String valor;

    public Caracteristica(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Deprecated
    public Caracteristica(){

    }

    public CaracteristicaProduto comProduto(Produto produto) {
        return new CaracteristicaProduto(this, produto);
    }
}
