package br.com.despensa.mapper;

import br.com.despensa.model.dto.ControleAlimentoDTO;
import br.com.despensa.model.dto.ControleAlimentoValidadeDTO;
import br.com.despensa.model.entity.ControleAlimento;
import br.com.despensa.model.entity.ControleAlimentoValidade;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ControleAlimentoValidadeMapper {

    ControleAlimentoValidade toEntity(ControleAlimentoValidadeDTO controleAlimentoValidadeDTO);

    ControleAlimentoValidadeDTO toDTO(ControleAlimentoValidade controleAlimentoValidade);

    List<ControleAlimentoValidade> toEntity(List<ControleAlimentoValidadeDTO> controleAlimentoValidadeDTOList);

    List<ControleAlimentoValidadeDTO> toDTO(List<ControleAlimentoValidade> controleAlimentoValidadeList);
}
