package br.com.despensa.service;

import br.com.despensa.mapper.ListaComprasMapper;
import br.com.despensa.model.dto.ListaComprasReqDTO;
import br.com.despensa.model.dto.ListaComprasRespDTO;
import br.com.despensa.model.entity.ListaCompras;
import br.com.despensa.repository.ListaComprasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaComprasService {

    private final ListaComprasRepository listaComprasRepository;
    private final ListaComprasMapper listaComprasMapper;

    public List<ListaComprasRespDTO> getAll(){
         List<ListaCompras> listaCompraslist = this.listaComprasRepository.findAll();
         return this.listaComprasMapper.toDto(listaCompraslist);
    }

    public ListaComprasRespDTO getById(Long id){
        Optional<ListaCompras> result = this.listaComprasRepository.findById(id);
        if (result.isPresent()){
            return this.listaComprasMapper.toDto(result.get());
        }else {
            throw new RuntimeException("Recurso não encontrado");
        }
    }

    public ListaComprasRespDTO save(ListaComprasReqDTO listaComprasReqDTO){
        ListaCompras listaCompras = this.listaComprasMapper.toEntity(listaComprasReqDTO);
        listaCompras = this.listaComprasRepository.save(listaCompras);
        return this.listaComprasMapper.toDto(listaCompras);
    }

    public ListaComprasRespDTO update(Long id, ListaComprasReqDTO listaComprasReqDTO){
        ListaCompras listaCompras = this.listaComprasMapper.toEntity(listaComprasReqDTO);
        Optional<ListaCompras> result = this.listaComprasRepository.findById(id);
        if (result.isPresent()){
            listaCompras.setId(id);
            return this.listaComprasMapper.toDto(listaCompras);
        }else{
            throw  new RuntimeException("Recurso não encontrado");
        }
    }

    public void delete(Long id){
        Optional<ListaCompras> result = this.listaComprasRepository.findById(id);
        if (result.isPresent()){
            this.listaComprasRepository.delete(result.get());
        }else {
            throw new RuntimeException("Recurso não encontrado");
        }
    }


}
