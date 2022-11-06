package br.com.alura.comex.categoria.dto;

import br.com.alura.comex.categoria.model.Categoria;
import br.com.alura.comex.categoria.model.StatusCategoria;
import br.com.alura.comex.produto.dto.ProdutoOutputDto;
import br.com.alura.comex.produto.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<CategoriaOutputDto> converter(List<Categoria> categoria) {
        return categoria.stream().map(CategoriaOutputDto::new).collect(Collectors.toList());
    }
}
