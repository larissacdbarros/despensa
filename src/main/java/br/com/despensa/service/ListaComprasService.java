package br.com.despensa.service;

import br.com.despensa.mapper.ListaComprasMapper;
import br.com.despensa.model.dto.ListaComprasDTO;
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

    public List<ListaComprasDTO> getAll(){
         List<ListaCompras> listaCompraslist = this.listaComprasRepository.findAll();
         return this.listaComprasMapper.toDTO(listaCompraslist);
    }

    public ListaComprasDTO getById(Long id){
        Optional<ListaCompras> result = this.listaComprasRepository.findById(id);
        if (result.isPresent()){
            return this.listaComprasMapper.toDTO(result.get());
        }else {
            throw new RuntimeException("Recurso não encontrado");
        }
    }

    public ListaComprasDTO save(ListaComprasDTO listaComprasDTO){
        ListaCompras listaCompras = this.listaComprasMapper.toEntity(listaComprasDTO);
        listaCompras = this.listaComprasRepository.save(listaCompras);
        return this.listaComprasMapper.toDTO(listaCompras);
    }

    public ListaComprasDTO update(Long id,ListaComprasDTO listaComprasDTO){
        ListaCompras listaCompras = this.listaComprasMapper.toEntity(listaComprasDTO);
        Optional<ListaCompras> result = this.listaComprasRepository.findById(id);
        if (result.isPresent()){
            listaCompras.setId(id);
            return this.listaComprasMapper.toDTO(listaCompras);
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
