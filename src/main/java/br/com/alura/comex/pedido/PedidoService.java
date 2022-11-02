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
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    public PedidoService(@Lazy PedidoRepository pedidoRepository,
                         @Lazy ClienteRepository clienteRepository,
                         @Lazy ProdutoRepository produtoRepository,
                         @Lazy ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ResponseEntity<Long> create(PedidoInputDto pedidoInputDto, UriComponentsBuilder uriBuilder){

        Optional<Cliente> cliente = clienteRepository.findById(pedidoInputDto.getIdCliente());

        if (cliente.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Pedido pedido = pedidoRepository.save(pedidoInputDto.converter(cliente.get()));

        for (ItemPedidoDto itemPedidoDto: pedidoInputDto.getProdutos()) {
            Optional<Produto> produto = produtoRepository.findById(itemPedidoDto.getIdProduto());
            if (produto.isEmpty()){
                return ResponseEntity.badRequest().build();
            }else{
                itemPedidoRepository.save(itemPedidoDto.converter(pedido, produto.get(), itemPedidoDto));
            }
        }

        URI uri = uriBuilder.path("/api/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return  ResponseEntity.created(uri).body(pedido.getId());
    }
}
