package br.com.despensa.mapper;

import br.com.despensa.model.dto.ControleAlimentoReqDTO;
import br.com.despensa.model.dto.ControleAlimentoRespDTO;
import br.com.despensa.model.entity.ControleAlimento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ControleAlimentoMapper extends BaseMapper<ControleAlimento, ControleAlimentoReqDTO, ControleAlimentoRespDTO> {

}
