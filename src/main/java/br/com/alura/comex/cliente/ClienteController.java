package br.com.alura.comex.cliente;

import br.com.alura.comex.cliente.dto.ClienteInputDto;
import br.com.alura.comex.cliente.dto.ClienteOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Long> create(@RequestBody @Valid ClienteInputDto clienteInputDto, UriComponentsBuilder uriBuilder){
        return clienteService.create(clienteInputDto, uriBuilder);
    }

    @GetMapping
    public List<ClienteOutputDto> lista(Integer page){
        return clienteService.getAll(page);
    }
}
