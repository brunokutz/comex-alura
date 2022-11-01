package br.com.alura.comex.categoria.dto;

import br.com.alura.comex.categoria.model.Categoria;
import br.com.alura.comex.categoria.model.StatusCategoria;

public class CategoriaOutputDto {

    private Long id;
    private String nome;
    private StatusCategoria status;

    public CategoriaOutputDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.status = categoria.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public StatusCategoria getStatus() {
        return status;
    }
}
