package br.com.alura.comex.cliente;

import br.com.alura.comex.cliente.dto.ClienteInputDto;
import br.com.alura.comex.cliente.dto.ClienteOutputDto;
import br.com.alura.comex.cliente.model.Cliente;
import br.com.alura.comex.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<ClienteOutputDto> create(ClienteInputDto clienteInputDto, UriComponentsBuilder uriBuilder){
        Cliente cliente = clienteRepository.save(clienteInputDto.converter());
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return  ResponseEntity.created(uri).body(new ClienteOutputDto(cliente));
    }

    public Page<ClienteOutputDto> lista(Pageable pageable) {
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        return ClienteOutputDto.converter(clientes);
    }
}
