package br.com.alura.comex.produto.repository;

import br.com.alura.comex.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}