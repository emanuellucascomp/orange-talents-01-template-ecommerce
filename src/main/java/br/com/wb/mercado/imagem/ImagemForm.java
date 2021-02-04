package br.com.wb.mercado.imagem;

import br.com.wb.mercado.produto.Produto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ImagemForm {

    @NotBlank
    private String url;
    @NotNull
    private Long produtoId;

    public ImagemForm(@NotBlank String url, @NotNull Long produtoId) {
        this.url = url;
        this.produtoId = produtoId;
    }

    public Imagem toModel(EntityManager manager) {
        Produto produto = manager.find(Produto.class, produtoId);
        return new Imagem(url, produto);
    }

    public Long getProdutoId(){
        return produtoId;
    }
}
