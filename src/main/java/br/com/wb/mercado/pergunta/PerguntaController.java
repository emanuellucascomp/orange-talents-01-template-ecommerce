package br.com.wb.mercado.pergunta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/perguntas")
public class PerguntaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PerguntaForm perguntaForm){
		Pergunta pergunta = perguntaForm.toModel(manager);
		manager.persist(pergunta);
		
		return ResponseEntity.ok().build();		
	}

}
