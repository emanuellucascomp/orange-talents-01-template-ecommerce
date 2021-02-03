package br.com.wb.mercado.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ProdutoForm produtoForm){
		Produto produto = produtoForm.toModel(manager);
		manager.persist(produto);

		return ResponseEntity.ok().build();
	}
}
