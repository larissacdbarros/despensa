package br.com.despensa.mapper;

import br.com.despensa.model.dto.AlimentoDTO;
import br.com.despensa.model.dto.ListaComprasDTO;
import br.com.despensa.model.entity.Alimento;
import br.com.despensa.model.entity.ListaCompras;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListaComprasMapper {

    ListaCompras toEntity(ListaComprasDTO listaComprasDTO);

    ListaComprasDTO toDTO(ListaCompras listaCompras);

    List<ListaCompras> toEntity(List<ListaComprasDTO> listaComprasDTOList);

    List<ListaComprasDTO> toDTO(List<ListaCompras> listaComprasList);
}
