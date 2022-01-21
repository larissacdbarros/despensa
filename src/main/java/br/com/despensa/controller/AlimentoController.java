package br.com.despensa.controller;


import br.com.despensa.model.dto.AlimentoReqDTO;
import br.com.despensa.model.dto.AlimentoRespDTO;
import br.com.despensa.service.AlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alimentos") //padrao de endpoints é no plural
@RequiredArgsConstructor //os atributos precisam ser private e final

public class AlimentoController {

    private final AlimentoService alimentoService;

    @GetMapping
    public ResponseEntity<List<AlimentoRespDTO>> getAll() {
        List<AlimentoRespDTO> listaAlimentos = this.alimentoService.getAll();
        return ResponseEntity.ok(listaAlimentos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlimentoRespDTO> getById(@PathVariable("id") Long id) {
        AlimentoRespDTO result = this.alimentoService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<AlimentoRespDTO> save(@RequestBody AlimentoReqDTO alimentoReqDTO) {
        AlimentoRespDTO result = this.alimentoService.save(alimentoReqDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlimentoRespDTO> update(@PathVariable("id") Long id, @RequestBody AlimentoReqDTO alimentoReqDTO) {
        AlimentoRespDTO result = this.alimentoService.update(id, alimentoReqDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.alimentoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
