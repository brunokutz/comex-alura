package br.com.alura.comex.pedido.repository;

import br.com.alura.comex.pedido.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}