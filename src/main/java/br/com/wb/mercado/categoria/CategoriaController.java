package br.com.wb.mercado.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm){
		Categoria categoria = categoriaForm.toModel();
		manager.persist(categoria);
		
		return ResponseEntity.ok().build();		
	}

}
