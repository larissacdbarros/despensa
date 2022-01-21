package br.com.despensa.service;

import br.com.despensa.mapper.AlimentoMapper;
import br.com.despensa.model.dto.AlimentoReqDTO;
import br.com.despensa.model.dto.AlimentoRespDTO;
import br.com.despensa.model.entity.Alimento;
import br.com.despensa.repository.AlimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;
    private final AlimentoMapper alimentoMapper;

    public List<AlimentoRespDTO> getAll() {
        List<Alimento> alimentoList = this.alimentoRepository.findAll();
        return this.alimentoMapper.toDto(alimentoList);
    }

    public AlimentoRespDTO getById(Long id) {
        Optional<Alimento> result = this.alimentoRepository.findById(id);
        if (result.isPresent()) {
            return this.alimentoMapper.toDto(result.get());
        } else {
            throw new RuntimeException("Recurso não encontrado");
        }
    }

    public AlimentoRespDTO save(AlimentoReqDTO alimentoReqDTO) {
        Alimento alimento = this.alimentoMapper.toEntity(alimentoReqDTO);
        alimento = this.alimentoRepository.save(alimento);
        return this.alimentoMapper.toDto(alimento);
    }


    public AlimentoRespDTO update(Long id, AlimentoReqDTO alimentoReqDTO) {
        Alimento alimento = this.alimentoMapper.toEntity(alimentoReqDTO);
        Optional<Alimento> result = this.alimentoRepository.findById(id);
        if (result.isPresent()) {
            alimento.setId(id);
            return this.alimentoMapper.toDto(this.alimentoRepository.save(alimento));
        } else {
            throw new RuntimeException("Recurso não encontrado");
        }
    }

    public void delete(Long id) {
        Optional<Alimento> result = this.alimentoRepository.findById(id);
        if (result.isPresent()) {
            this.alimentoRepository.delete(result.get());
        } else {
            throw new RuntimeException("Recurso não encontrado");
        }
    }
}
