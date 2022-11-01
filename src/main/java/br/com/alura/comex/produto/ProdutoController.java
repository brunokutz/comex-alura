package br.com.alura.comex.produto;

import br.com.alura.comex.produto.dto.ProdutoOutputDto;
import br.com.alura.comex.produto.dto.ProdutoInputDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoOutputDto> cadastrar(@RequestBody @Valid ProdutoInputDto produtoInputDto, UriComponentsBuilder uriComponentsBuilder) {
        Long id = produtoService.cadastrar(produtoInputDto);
        URI uri = uriComponentsBuilder.path("/api/produtos/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public Page<ProdutoOutputDto> listar() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "nome"));
        return produtoService.listar(pageable).map(ProdutoOutputDto::new);
    }
}
