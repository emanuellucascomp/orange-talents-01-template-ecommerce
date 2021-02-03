package br.com.wb.mercado.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.wb.mercado.usuario.Usuario;
import br.com.wb.mercado.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ProdutoForm produtoForm){
		Object logado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long usuarioLogadoId = 0L;
		if(logado instanceof UserDetails){
			String username = ((UserDetails) logado).getUsername();
			Optional<Usuario> usuarioLogado = usuarioRepository.findByLogin(username);
			usuarioLogadoId = usuarioLogado.get().getId();
		}
		Produto produto = produtoForm.toModel(usuarioLogadoId, manager);
		manager.persist(produto);

		return ResponseEntity.ok().build();
	}
}
