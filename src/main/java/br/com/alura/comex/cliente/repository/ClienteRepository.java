package br.com.alura.comex.cliente.repository;

import br.com.alura.comex.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
