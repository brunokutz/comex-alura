package br.com.alura.comex.categoria.projection;

import java.math.BigDecimal;

public interface CategoriaProjection {
    String getNome();
    Integer getQuantidadeVendida();
    BigDecimal getMontanteVendido();
}
