package br.com.despensa.service;

import br.com.despensa.mapper.AlimentoMapper;
import br.com.despensa.model.dto.AlimentoDTO;
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

    public List<AlimentoDTO> getAll() {
        List<Alimento> alimentoList = this.alimentoRepository.findAll();
        return this.alimentoMapper.toDTO(alimentoList);
    }

    public AlimentoDTO getById(Long id) {
        Optional<Alimento> result = this.alimentoRepository.findById(id);
        if (result.isPresent()) {
            return this.alimentoMapper.toDTO(result.get());
        } else {
            throw new RuntimeException("Recurso não encontrado");
        }
    }

    public AlimentoDTO save(AlimentoDTO alimentoDTO) {
        Alimento alimento = this.alimentoMapper.toEntity(alimentoDTO);
        alimento = this.alimentoRepository.save(alimento);
        return this.alimentoMapper.toDTO(alimento);
    }

    public AlimentoDTO update(Long id, AlimentoDTO alimentoDTO) {
        Alimento alimento = this.alimentoMapper.toEntity(alimentoDTO);
        Optional<Alimento> result = this.alimentoRepository.findById(id);
        if (result.isPresent()) {
            alimento.setId(id);
            return this.alimentoMapper.toDTO(this.alimentoRepository.save(alimento));
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
