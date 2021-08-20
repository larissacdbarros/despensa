package br.com.despensa.mapper;

import br.com.despensa.model.dto.AlimentoDTO;
import br.com.despensa.model.entity.Alimento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlimentoMapper {

    Alimento toEntity(AlimentoDTO alimentoDTO);

    AlimentoDTO toDTO (Alimento alimento);

    List<Alimento> toEntity(List<AlimentoDTO> alimentoDTOList);

    List<AlimentoDTO> toDTO (List<Alimento> alimentoList);

}
