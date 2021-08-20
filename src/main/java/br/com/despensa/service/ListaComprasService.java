package br.com.despensa.service;

import br.com.despensa.mapper.ListaComprasMapper;
import br.com.despensa.repository.ListaComprasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListaComprasService {

    private final ListaComprasRepository listaComprasRepository;
    private final ListaComprasMapper listaComprasMapper;

}
