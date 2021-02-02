package br.com.wb.mercado.autenticacao;

public class AutenticacaoDTO {

    private String token;
    private String tipo;

    public AutenticacaoDTO(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
