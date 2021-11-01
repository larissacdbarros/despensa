package br.com.despensa.mapper;

import br.com.despensa.model.dto.ControleAlimentoValidadeReqDTO;
import br.com.despensa.model.dto.ControleAlimentoValidadeRespDTO;
import br.com.despensa.model.entity.ControleAlimentoValidade;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ControleAlimentoValidadeMapper extends BaseMapper<ControleAlimentoValidade, ControleAlimentoValidadeReqDTO, ControleAlimentoValidadeRespDTO> {

}
