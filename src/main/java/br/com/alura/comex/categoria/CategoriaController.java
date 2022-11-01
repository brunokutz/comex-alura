package br.com.alura.comex.categoria;

import br.com.alura.comex.categoria.dto.CategoriaOutputDto;
import br.com.alura.comex.categoria.dto.CategoriaInputDto;
import br.com.alura.comex.categoria.model.Categoria;
import br.com.alura.comex.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaOutputDto> cadastrar(@RequestBody @Valid CategoriaInputDto categoriaInputDto, UriComponentsBuilder uriComponentsBuilder) {
        Categoria categoria = categoriaInputDto.converter();
        categoriaRepository.save(categoria);

        URI uri = uriComponentsBuilder.path("/api/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaOutputDto(categoria));
    }

    @GetMapping("/pedidos")
    public List<CategoriaOutputDto> listarPedidos() {
        return null;
    }
}
