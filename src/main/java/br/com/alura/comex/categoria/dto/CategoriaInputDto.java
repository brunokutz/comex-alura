package br.com.alura.comex.categoria.dto;

import br.com.alura.comex.categoria.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CategoriaInputDto {

    @NotBlank @Length(min = 2)
    private String nome;

    public CategoriaInputDto() {
    }

    public CategoriaInputDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(nome);
    }
}
