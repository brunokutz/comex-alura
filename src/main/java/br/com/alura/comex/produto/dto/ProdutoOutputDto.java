package br.com.alura.comex.produto.dto;

import br.com.alura.comex.produto.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoOutputDto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private Integer quantidadeEstoque;
    private Long idCategoria;
    private String nomeCategoria;

    public ProdutoOutputDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.precoUnitario = produto.getPrecoUnitario();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.idCategoria = produto.getCategoria().getId();
        this.nomeCategoria = produto.getCategoria().getNome();
    }

    public static List<ProdutoOutputDto> converter(List<Produto> produto) {
        return produto.stream().map(ProdutoOutputDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
