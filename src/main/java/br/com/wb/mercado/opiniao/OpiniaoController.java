package br.com.wb.mercado.opiniao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.mercado.usuario.Usuario;
import br.com.wb.mercado.usuario.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/opinioes")
public class OpiniaoController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid OpiniaoForm opiniaoForm){
		Object logado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(logado instanceof UserDetails){
			String username = ((UserDetails) logado).getUsername();
			Optional<Usuario> usuarioLogado = usuarioRepository.findByLogin(username);
			if(usuarioLogado.isPresent()) {
				Opiniao opiniao = opiniaoForm.toModel(usuarioLogado.get(), manager);
				manager.persist(opiniao);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.badRequest().build();
		
	}

}
