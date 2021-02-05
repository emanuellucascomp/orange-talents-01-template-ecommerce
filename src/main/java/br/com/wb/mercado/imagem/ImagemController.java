package br.com.wb.mercado.imagem;

import br.com.wb.mercado.produto.Produto;
import br.com.wb.mercado.usuario.Usuario;
import br.com.wb.mercado.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/imagens")
public class ImagemController {

    @Autowired
    private EntityManager manager;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ImagemForm imagemForm){
        Object logado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long usuarioLogadoId = 0L;
        if(logado instanceof UserDetails){
            String username = ((UserDetails) logado).getUsername();
            Optional<Usuario> usuarioLogado = usuarioRepository.findByLogin(username);
            usuarioLogadoId = usuarioLogado.get().getId();
        }
        Produto produto = manager.find(Produto.class, imagemForm.getProdutoId());
        if(produto.getCriador().getId() != usuarioLogadoId){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Imagem imagem = imagemForm.toModel(manager);
        manager.persist(imagem);

        return ResponseEntity.ok().build();

    }
}
