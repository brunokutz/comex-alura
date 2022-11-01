package br.com.alura.comex.categoria.dto;

import br.com.alura.comex.categoria.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaInputDto {

    @NotNull @NotEmpty @Length(min = 2)
    private String nome;

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
