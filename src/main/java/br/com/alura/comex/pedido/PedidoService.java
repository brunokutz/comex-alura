package br.com.alura.comex.pedido;

import br.com.alura.comex.cliente.model.Cliente;
import br.com.alura.comex.cliente.repository.ClienteRepository;
import br.com.alura.comex.pedido.dto.ItemPedidoDto;
import br.com.alura.comex.pedido.dto.PedidoInputDto;
import br.com.alura.comex.pedido.model.Pedido;
import br.com.alura.comex.pedido.repository.ItemPedidoRepository;
import br.com.alura.comex.pedido.repository.PedidoRepository;
import br.com.alura.comex.produto.model.Produto;
import br.com.alura.comex.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ResponseEntity<Long> create(PedidoInputDto pedidoInputDto, UriComponentsBuilder uriBuilder){

        Pedido pedido = pedidoRepository.save(pedidoInputDto.converterPedido(clienteRepository));

        for (ItemPedidoDto itemPedidoDto: pedidoInputDto.getProdutos()) {
            Optional<Produto> produto = produtoRepository.findById(itemPedidoDto.getIdProduto());
            if (produto.isEmpty()){
                return ResponseEntity.badRequest().build();
            }else{
                itemPedidoRepository.save(itemPedidoDto.converterItemPedido(pedido, produto.get(), itemPedidoDto));
            }
        }

        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return  ResponseEntity.created(uri).body(pedido.getId());
    }

    private Cliente validateAndReturnCliente(PedidoInputDto pedidoInputDto) {
        Optional<Cliente> cliente = clienteRepository.findById(pedidoInputDto.getIdCliente());
        if (cliente.isEmpty()) {
            return null;
        }else{
            return cliente.get();
        }
    }
}
