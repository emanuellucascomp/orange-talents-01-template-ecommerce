package br.com.wb.mercado.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioForm {
	
	@NotBlank @Email
	private String login;
	@NotBlank @Size(min = 6)
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	
	public Usuario toModel() {
		return new Usuario(login, senha);
	}
	
	

}
