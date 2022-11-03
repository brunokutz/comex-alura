package br.com.alura.comex.produto;

import br.com.alura.comex.produto.dto.ProdutoInputDto;
import br.com.alura.comex.produto.dto.ProdutoOutputDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(@Lazy ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoOutputDto> cadastrar(@RequestBody @Valid ProdutoInputDto produtoInputDto, UriComponentsBuilder uriBuilder) {
        return produtoService.cadastrar(produtoInputDto, uriBuilder);
    }

    @GetMapping
    @Cacheable(value = "lista_produtos")
    public Page<ProdutoOutputDto> lista(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
        return produtoService.lista(pageable).map(ProdutoOutputDto::new);
    }
}
