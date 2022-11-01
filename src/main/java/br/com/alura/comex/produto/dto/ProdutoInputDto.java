package br.com.alura.comex.produto.dto;

import br.com.alura.comex.categoria.model.Categoria;
import br.com.alura.comex.produto.model.Produto;
import br.com.alura.comex.categoria.repository.CategoriaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Optional;

public class ProdutoInputDto {

    @NotBlank @Length(min = 2)
    private String nome;
    private String descricao;
    @NotBlank @PositiveOrZero
    private BigDecimal precoUnitario;
    @NotBlank
    private Integer quantidadeEstoque;
    @NotBlank
    private Long idCategoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Produto converter(CategoriaRepository categoriaRepository) {
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        return categoria.map(cat -> new Produto(nome, descricao, precoUnitario, quantidadeEstoque, cat)).orElse(null);
    }
}
