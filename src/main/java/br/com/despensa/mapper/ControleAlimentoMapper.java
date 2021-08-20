package br.com.despensa.mapper;

import br.com.despensa.model.dto.AlimentoDTO;
import br.com.despensa.model.dto.ControleAlimentoDTO;
import br.com.despensa.model.entity.Alimento;
import br.com.despensa.model.entity.ControleAlimento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ControleAlimentoMapper {
    ControleAlimento toEntity(ControleAlimentoDTO controleAlimentoDTO);

    ControleAlimentoDTO toDTO(ControleAlimento controleAlimento);

    List<ControleAlimento> toEntity(List<ControleAlimentoDTO> controleAlimentoDTOList);

    List<ControleAlimentoDTO> toDTO(List<ControleAlimento> controleAlimentoList);
}
