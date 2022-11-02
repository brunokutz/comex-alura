package br.com.alura.comex.pedido.dto;

import br.com.alura.comex.cliente.model.Cliente;
import br.com.alura.comex.pedido.model.Pedido;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class PedidoInputDto {

    @NotNull
    private Long idCliente;
    @NotNull @NotEmpty @Valid
    private List<ItemPedidoDto> produtos;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemPedidoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemPedidoDto> produtos) {
        this.produtos = produtos;
    }

    public Pedido converter(Cliente cliente) {
        return new Pedido(cliente);
    }
}