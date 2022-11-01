package br.com.alura.comex.cliente;

import br.com.alura.comex.cliente.dto.ClienteInputDto;
import br.com.alura.comex.cliente.dto.ClienteOutputDto;
import br.com.alura.comex.cliente.model.Cliente;
import br.com.alura.comex.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<Long> create(ClienteInputDto clienteInputDto, UriComponentsBuilder uriBuilder){
        Cliente cliente = clienteRepository.save(ClienteMapper.toEntity(clienteInputDto));

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return  ResponseEntity.created(uri).body(cliente.getId());
    }

    public List<ClienteOutputDto> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "nome"));
        return clienteRepository.findAll(pageable).stream().map(ClienteMapper::toOutputDto).toList();
    }
}
