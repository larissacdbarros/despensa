package br.com.despensa.mapper;

import br.com.despensa.model.dto.ListaComprasReqDTO;
import br.com.despensa.model.dto.ListaComprasRespDTO;
import br.com.despensa.model.entity.ListaCompras;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ListaComprasMapper extends BaseMapper<ListaCompras, ListaComprasReqDTO, ListaComprasRespDTO>{

}
