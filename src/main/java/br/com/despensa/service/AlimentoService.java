package br.com.despensa.service;

import br.com.despensa.model.entity.Alimento;
import br.com.despensa.repository.AlimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {
    AlimentoRepository alimentoRepository;

    public AlimentoService(AlimentoRepository alimentoRepository){
        this.alimentoRepository = alimentoRepository;
    }

    public List<Alimento> getAlimentos(){
        return this.alimentoRepository.findAll();
    }

}
