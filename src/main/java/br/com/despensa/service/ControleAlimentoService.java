package br.com.despensa.service;

import br.com.despensa.mapper.ControleAlimentoMapper;
import br.com.despensa.repository.ControleAlimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ControleAlimentoService {

    private final ControleAlimentoRepository controleAlimentoRepository;
    private final ControleAlimentoMapper controleAlimentoMapper;
}
