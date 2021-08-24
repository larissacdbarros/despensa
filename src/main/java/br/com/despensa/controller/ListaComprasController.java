package br.com.despensa.controller;

import br.com.despensa.model.dto.ListaComprasDTO;
import br.com.despensa.model.entity.ListaCompras;
import br.com.despensa.service.ListaComprasService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/listas-compras")
@RequiredArgsConstructor
public class ListaComprasController {

    private final ListaComprasService listaComprasService;

    @GetMapping
    public ResponseEntity<List<ListaComprasDTO>> getAll(){
        List<ListaComprasDTO> result  = this.listaComprasService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListaComprasDTO> getById(@PathVariable Long id){
       ListaComprasDTO result = this.listaComprasService.getById(id);
       return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ListaComprasDTO> save(@RequestBody ListaComprasDTO listaComprasDTO){
        ListaComprasDTO result = this.listaComprasService.save(listaComprasDTO);
        return ResponseEntity.ok(result);
    }
    
    @PutMapping(value = "/{id}")
    public  ResponseEntity<ListaComprasDTO> update(@PathVariable Long id, @RequestBody ListaComprasDTO listaComprasDTO){
        ListaComprasDTO result = this.listaComprasService.update(id, listaComprasDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.listaComprasService.delete(id);
        return ResponseEntity.ok().build();
    }

}
