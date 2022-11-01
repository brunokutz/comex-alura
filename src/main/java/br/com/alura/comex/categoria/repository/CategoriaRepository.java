package br.com.alura.comex.categoria.repository;

import br.com.alura.comex.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
