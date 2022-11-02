package br.com.alura.comex.categoria.mapper;

import br.com.alura.comex.categoria.dto.RelatorioCategoriaOutputDto;
import br.com.alura.comex.categoria.projection.CategoriaProjection;

import java.util.ArrayList;
import java.util.List;

public class CategoriaMapper {
    public static List<RelatorioCategoriaOutputDto> toCategoriaRelatorioOutputDto(List<CategoriaProjection> categoriaProjectionList){
        List<RelatorioCategoriaOutputDto> relatorioCategoriaOutputDtos = new ArrayList<>();

        categoriaProjectionList.forEach(categoriaProjection -> {
            RelatorioCategoriaOutputDto relatorioCategoriaOutputDto = new RelatorioCategoriaOutputDto();
            relatorioCategoriaOutputDto.setNomeCategoria(categoriaProjection.getNome());
            relatorioCategoriaOutputDto.setQuantidadeVendas(categoriaProjection.getQuantidade());
            relatorioCategoriaOutputDto.setValorTotal(categoriaProjection.getPreco());

            relatorioCategoriaOutputDtos.add(relatorioCategoriaOutputDto);
        });
        return relatorioCategoriaOutputDtos;
    }
}
