package br.com.alura.comex.produto;

import br.com.alura.comex.produto.dto.ProdutoInputDto;
import br.com.alura.comex.produto.model.Produto;
import br.com.alura.comex.categoria.repository.CategoriaRepository;
import br.com.alura.comex.produto.repository.ProdutoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final CategoriaRepository categoriaRepository;

    public ProdutoService(@Lazy ProdutoRepository produtoRepository,
                          @Lazy CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Page<Produto> listar(Pageable pageable) {
        return this.produtoRepository.findAll(pageable);
    }

    public Long cadastrar(ProdutoInputDto produtoInputDto) {
        Produto produto = produtoInputDto.converter(categoriaRepository);
        produtoRepository.save(produto);
        return produto.getId();
    }
}
