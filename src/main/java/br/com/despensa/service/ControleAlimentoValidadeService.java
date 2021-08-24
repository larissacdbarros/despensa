package br.com.despensa.service;

import br.com.despensa.mapper.ControleAlimentoValidadeMapper;
import br.com.despensa.model.dto.ControleAlimentoValidadeDTO;
import br.com.despensa.model.entity.ControleAlimentoValidade;
import br.com.despensa.repository.ControleAlimentoValidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ControleAlimentoValidadeService {

    private final ControleAlimentoValidadeRepository controleAlimentoValidadeRepository;
    private final ControleAlimentoValidadeMapper controleAlimentoValidadeMapper;


    public List<ControleAlimentoValidadeDTO> getAll() {
        List<ControleAlimentoValidade> controleAlimentoValidadeList = this.controleAlimentoValidadeRepository.findAll();
        return this.controleAlimentoValidadeMapper.toDTO(controleAlimentoValidadeList);
    }

    public ControleAlimentoValidadeDTO getById(Long id){
        Optional<ControleAlimentoValidade> result = this.controleAlimentoValidadeRepository.findById(id);
        if (result.isPresent()){
            return this.controleAlimentoValidadeMapper.toDTO(result.get());
        }else{
            throw new RuntimeException("Recurso não encontrado.");
        }
    }

    public ControleAlimentoValidadeDTO save(ControleAlimentoValidadeDTO controleAlimentoValidadeDTO){
        ControleAlimentoValidade controleAlimentoValidade = this.controleAlimentoValidadeMapper.toEntity(controleAlimentoValidadeDTO);
        controleAlimentoValidade = this.controleAlimentoValidadeRepository.save(controleAlimentoValidade);
        return this.controleAlimentoValidadeMapper.toDTO(controleAlimentoValidade);
    }

    public ControleAlimentoValidadeDTO update(Long id, ControleAlimentoValidadeDTO controleAlimentoValidadeDTO){
       ControleAlimentoValidade controleAlimentoValidade = this.controleAlimentoValidadeMapper.toEntity(controleAlimentoValidadeDTO);
        Optional<ControleAlimentoValidade> result = this.controleAlimentoValidadeRepository.findById(id);
        if (result.isPresent()){
            controleAlimentoValidade.setId(id);
            return this.controleAlimentoValidadeMapper.toDTO(this.controleAlimentoValidadeRepository.save(controleAlimentoValidade));
        }else {
            throw  new RuntimeException("Resurso não encontrado.");
        }
    }

    public void delete(Long id){
        Optional<ControleAlimentoValidade> result = this.controleAlimentoValidadeRepository.findById(id);
        if (result.isPresent()){
            this.controleAlimentoValidadeRepository.delete(result.get());
        }else {
            throw new RuntimeException("Resurso não encontrado.");
        }
    }


}
