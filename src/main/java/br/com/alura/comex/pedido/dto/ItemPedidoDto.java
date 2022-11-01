package br.com.alura.comex.pedido.dto;

import br.com.alura.comex.cliente.model.Cliente;
import br.com.alura.comex.pedido.model.ItemPedido;
import br.com.alura.comex.pedido.model.Pedido;
import br.com.alura.comex.produto.model.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Optional;

public class ItemPedidoDto {

    @NotBlank
    private Long idProduto;
    @NotBlank
    private Integer quantidade;

    @NotBlank @PositiveOrZero
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

    public ItemPedido converterItemPedido(Pedido pedido, Produto produto, ItemPedidoDto itemPedidoDto) {
        return new ItemPedido(pedido, produto, itemPedidoDto);
    }
}