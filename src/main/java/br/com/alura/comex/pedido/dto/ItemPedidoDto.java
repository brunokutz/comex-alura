package br.com.alura.comex.pedido.dto;

import br.com.alura.comex.pedido.model.ItemPedido;
import br.com.alura.comex.pedido.model.Pedido;
import br.com.alura.comex.produto.model.Produto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class ItemPedidoDto {

    @NotNull
    private Long idProduto;
    @NotNull
    private Integer quantidade;

    @NotNull @PositiveOrZero
    private BigDecimal valorUnitario;

    public ItemPedidoDto() {
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public ItemPedido converter(Pedido pedido, Produto produto, ItemPedidoDto itemPedidoDto) {
        return new ItemPedido(pedido, produto, itemPedidoDto);
    }
}