package br.com.wb.mercado.imagem;

import br.com.wb.mercado.produto.Produto;

import javax.persistence.*;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne
    private Produto produto;


    public Imagem(String url, Produto produto) {
        this.url = url;
        this.produto = produto;
    }

    @Deprecated
    public Imagem() {

    }
}
