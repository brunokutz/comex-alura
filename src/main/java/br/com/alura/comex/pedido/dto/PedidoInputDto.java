package br.com.alura.comex.pedido.dto;

import br.com.alura.comex.cliente.model.Cliente;
import br.com.alura.comex.cliente.repository.ClienteRepository;
import br.com.alura.comex.pedido.model.Pedido;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

public class PedidoInputDto {

    @NotBlank
    private Long idCliente;
    @NotBlank @Valid
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

    public Pedido converterPedido(ClienteRepository clienteRepository) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return cliente.map(cli -> new Pedido(cliente.get())).orElse(null);
    }
}