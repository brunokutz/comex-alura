package br.com.alura.comex.pedido.dto;

import java.math.BigDecimal;

public class PedidoOutputDto {

    private String nomeCategoria;
    private String quantidadeVenda;
    private BigDecimal valorTotal;

    public PedidoOutputDto() {
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(String quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}