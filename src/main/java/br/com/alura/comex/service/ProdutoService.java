package br.com.alura.comex.service;

import br.com.alura.comex.controller.form.ProdutosForm;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
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

    public Long cadastrar(ProdutosForm produtosForm) {
        Produto produto = produtosForm.converter(categoriaRepository);
        produtoRepository.save(produto);
        return produto.getId();
    }
}
