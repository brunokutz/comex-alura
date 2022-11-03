package br.com.alura.comex.produto;

import br.com.alura.comex.produto.dto.ProdutoInputDto;
import br.com.alura.comex.produto.dto.ProdutoOutputDto;
import br.com.alura.comex.produto.model.Produto;
import br.com.alura.comex.categoria.repository.CategoriaRepository;
import br.com.alura.comex.produto.repository.ProdutoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final CategoriaRepository categoriaRepository;

    public ProdutoService(@Lazy ProdutoRepository produtoRepository,
                          @Lazy CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Page<Produto> lista(Pageable pageable) {
        return this.produtoRepository.findAll(pageable);
    }

    public ResponseEntity<ProdutoOutputDto> cadastrar(ProdutoInputDto produtoInputDto, UriComponentsBuilder uriBuilder) {
        Produto produto = produtoRepository.save(produtoInputDto.converter(categoriaRepository));
        URI uri = uriBuilder.path("/api/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoOutputDto(produto));
    }
}
