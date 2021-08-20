package br.com.despensa.service;

import br.com.despensa.mapper.ControleAlimentoValidadeMapper;
import br.com.despensa.repository.ControleAlimentoValidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ControleAlimentoValidadeService {

    private final ControleAlimentoValidadeRepository controleAlimentoValidadeRepository;
    private final ControleAlimentoValidadeMapper controleAlimentoValidadeMapper;

}
