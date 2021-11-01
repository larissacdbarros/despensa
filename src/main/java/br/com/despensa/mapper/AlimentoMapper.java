package br.com.despensa.mapper;

import br.com.despensa.model.dto.AlimentoReqDTO;
import br.com.despensa.model.dto.AlimentoRespDTO;
import br.com.despensa.model.entity.Alimento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AlimentoMapper extends BaseMapper<Alimento, AlimentoReqDTO, AlimentoRespDTO> {

}
