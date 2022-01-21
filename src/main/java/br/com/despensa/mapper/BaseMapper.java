package br.com.despensa.mapper;

import org.mapstruct.Mapper;

import java.util.List;

public interface BaseMapper<E, REQ, RESP> {

    E toEntity(REQ dto);

    RESP toDto(E entity);

    List<E> toEntity(List<REQ> dto);

    List<RESP> toDto(List<E> entity);

}
