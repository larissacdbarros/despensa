package br.com.despensa.service;

import br.com.despensa.mapper.ControleAlimentoMapper;
import br.com.despensa.model.dto.ControleAlimentoReqDTO;
import br.com.despensa.model.dto.ControleAlimentoRespDTO;
import br.com.despensa.model.entity.ControleAlimento;
import br.com.despensa.repository.ControleAlimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ControleAlimentoService {

    private final ControleAlimentoRepository controleAlimentoRepository;
    private final ControleAlimentoMapper controleAlimentoMapper;

    public List<ControleAlimentoRespDTO> getAll() {
        List<ControleAlimento> controleAlimentoList = this.controleAlimentoRepository.findAll();
        return this.controleAlimentoMapper.toDto(controleAlimentoList);
    }

    public ControleAlimentoRespDTO getById(Long id) {
        Optional<ControleAlimento> result = this.controleAlimentoRepository.findById(id);
        if (result.isPresent()) {
            return this.controleAlimentoMapper.toDto(result.get());
        } else {
            throw new RuntimeException("Recurso não encontrado.");
        }
    }

    @Transactional
    public ControleAlimentoRespDTO save(ControleAlimentoReqDTO controleAlimentoDTO) {
        ControleAlimento controleAlimento = this.controleAlimentoMapper.toEntity(controleAlimentoDTO);
        controleAlimento = this.controleAlimentoRepository.save(controleAlimento);
        return this.controleAlimentoMapper.toDto(controleAlimento);
    }

    public ControleAlimentoRespDTO update(Long id, ControleAlimentoReqDTO controleAlimentoDTO) {
        ControleAlimento controleAlimento = this.controleAlimentoMapper.toEntity(controleAlimentoDTO);
        Optional<ControleAlimento> result = this.controleAlimentoRepository.findById(id);
        if (result.isPresent()) {
            controleAlimento.setId(id);
            return this.controleAlimentoMapper.toDto(this.controleAlimentoRepository.save(controleAlimento));
        } else {
            throw new RuntimeException("Recurso não encontrado.");
        }
    }

    public void delete(Long id) {
        Optional<ControleAlimento> result = this.controleAlimentoRepository.findById(id);
        if (result.isPresent()) {
            this.controleAlimentoRepository.delete(result.get());
        } else {
            throw  new RuntimeException("Recurso não encontrado.");
        }
    }
}
