package br.com.alura.comex.categoria;

import br.com.alura.comex.categoria.dto.CategoriaInputDto;
import br.com.alura.comex.categoria.dto.CategoriaOutputDto;
import br.com.alura.comex.categoria.dto.RelatorioCategoriaOutputDto;
import br.com.alura.comex.produto.dto.ProdutoOutputDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "lista_relatorio_categoria_pedidos", allEntries = true)
    public ResponseEntity<CategoriaOutputDto> create(@RequestBody @Valid CategoriaInputDto categoriaInputDto, UriComponentsBuilder uriBuilder){
        return categoriaService.create(categoriaInputDto, uriBuilder);
    }

    @GetMapping
    public Page<CategoriaOutputDto> listarCategorias(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
        return categoriaService.listarCategorias(pageable).map(CategoriaOutputDto::new);
    }

    @GetMapping("/pedidos")
    @Cacheable(value = "lista_relatorio_categoria_pedidos")
    public List<RelatorioCategoriaOutputDto> lista(){
        return categoriaService.lista();
    }
}
