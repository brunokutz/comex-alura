package br.com.alura.comex.categoria;

import br.com.alura.comex.categoria.dto.CategoriaInputDto;
import br.com.alura.comex.categoria.dto.CategoriaOutputDto;
import br.com.alura.comex.categoria.dto.RelatorioCategoriaOutputDto;
import br.com.alura.comex.categoria.mapper.CategoriaMapper;
import br.com.alura.comex.categoria.model.Categoria;
import br.com.alura.comex.categoria.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public ResponseEntity<CategoriaOutputDto> create(CategoriaInputDto categoriaInputDto, UriComponentsBuilder uriBuilder){
        Categoria categoria = categoriaRepository.save(categoriaInputDto.converter());
        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return  ResponseEntity.created(uri).body(new CategoriaOutputDto(categoria));
    }

    public List<RelatorioCategoriaOutputDto> getPedidos() {
        return CategoriaMapper.toCategoriaRelatorioOutputDto(categoriaRepository.findRelatorioCategoriasVendidas());
    }
}