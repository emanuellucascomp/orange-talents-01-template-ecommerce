package br.com.wb.mercado.usuario;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String login;
	private String senha;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Usuario(@Email @NotBlank String login, @NotBlank @Size(min = 6) String senha) {
		Assert.isTrue(StringUtils.hasLength(login), "Email não pode ser em branco");
		Assert.isTrue(StringUtils.hasLength(senha), "Senha não pode ser em branco");
		Assert.isTrue(senha.length() >= 6, "Senha precisa ter mais de seis caracteres");
		
		this.login = login;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}

}
