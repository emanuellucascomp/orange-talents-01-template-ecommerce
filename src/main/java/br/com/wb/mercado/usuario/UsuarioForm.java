package br.com.wb.mercado.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.wb.mercado.config.validacao.UniqueValue;

public class UsuarioForm {
	
	@NotBlank @Email @UniqueValue(domainClass = Usuario.class, fieldName = "login", message = "Email já cadastrado")
	private String login;
	@NotBlank @Size(min = 6)
	private String senha;
	
	public UsuarioForm(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Usuario toModel() {
		return new Usuario(login, senha);
	}
	
	

}
