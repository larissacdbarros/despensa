package br.com.despensa.service;

import br.com.despensa.mapper.ControleAlimentoValidadeMapper;
import br.com.despensa.model.dto.ControleAlimentoValidadeReqDTO;
import br.com.despensa.model.dto.ControleAlimentoValidadeRespDTO;
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


    public List<ControleAlimentoValidadeRespDTO> getAll() {
        List<ControleAlimentoValidade> controleAlimentoValidadeList = this.controleAlimentoValidadeRepository.findAll();
        return this.controleAlimentoValidadeMapper.toDto(controleAlimentoValidadeList);
    }

    public ControleAlimentoValidadeRespDTO getById(Long id){
        Optional<ControleAlimentoValidade> result = this.controleAlimentoValidadeRepository.findById(id);
        if (result.isPresent()){
            return this.controleAlimentoValidadeMapper.toDto(result.get());
        }else{
            throw new RuntimeException("Recurso não encontrado.");
        }
    }

    public ControleAlimentoValidadeRespDTO save(ControleAlimentoValidadeReqDTO controleAlimentoValidadeReqDTO){
        ControleAlimentoValidade controleAlimentoValidade = this.controleAlimentoValidadeMapper.toEntity(controleAlimentoValidadeReqDTO);
        controleAlimentoValidade = this.controleAlimentoValidadeRepository.save(controleAlimentoValidade);
        return this.controleAlimentoValidadeMapper.toDto(controleAlimentoValidade);
    }

    public ControleAlimentoValidadeRespDTO update(Long id, ControleAlimentoValidadeReqDTO controleAlimentoValidadeReqDTO){
       ControleAlimentoValidade controleAlimentoValidade = this.controleAlimentoValidadeMapper.toEntity(controleAlimentoValidadeReqDTO);
        Optional<ControleAlimentoValidade> result = this.controleAlimentoValidadeRepository.findById(id);
        if (result.isPresent()){
            controleAlimentoValidade.setId(id);
            return this.controleAlimentoValidadeMapper.toDto(this.controleAlimentoValidadeRepository.save(controleAlimentoValidade));
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
