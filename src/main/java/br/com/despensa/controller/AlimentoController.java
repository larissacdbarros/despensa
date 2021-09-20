package br.com.despensa.controller;


import br.com.despensa.model.dto.AlimentoDTO;
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
    public ResponseEntity<List<AlimentoDTO>> getAll() {
        List<AlimentoDTO> listaAlimentos = this.alimentoService.getAll();
        return ResponseEntity.ok(listaAlimentos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlimentoDTO> getById(@PathVariable("id") Long id) {
        AlimentoDTO result = this.alimentoService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<AlimentoDTO> save(@RequestBody AlimentoDTO alimentoDTO) {
        AlimentoDTO result = this.alimentoService.save(alimentoDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlimentoDTO> update(@PathVariable("id") Long id, @RequestBody AlimentoDTO alimentoDTO) {
        AlimentoDTO result = this.alimentoService.update(id, alimentoDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.alimentoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
