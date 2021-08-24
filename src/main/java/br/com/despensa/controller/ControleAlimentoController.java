package br.com.despensa.controller;

import br.com.despensa.model.dto.AlimentoDTO;
import br.com.despensa.model.dto.ControleAlimentoDTO;
import br.com.despensa.model.entity.Alimento;
import br.com.despensa.model.entity.ControleAlimento;
import br.com.despensa.service.ControleAlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping(path = "/controles-alimentos")
@RequiredArgsConstructor
public class ControleAlimentoController {

    private final ControleAlimentoService controleAlimentoService;

    @GetMapping
    public ResponseEntity<List<ControleAlimentoDTO>> getAll(){
        List<ControleAlimentoDTO> listaControleAlimento = this.controleAlimentoService.getAll();
        return ResponseEntity.ok(listaControleAlimento);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ControleAlimentoDTO> getById (@PathVariable Long id){
        ControleAlimentoDTO result = this.controleAlimentoService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ControleAlimentoDTO> save(@RequestBody ControleAlimentoDTO controleAlimentoDTO){
        ControleAlimentoDTO result = this.controleAlimentoService.save(controleAlimentoDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ControleAlimentoDTO> update(@PathVariable Long id, @RequestBody ControleAlimentoDTO controleAlimentoDTO){
        ControleAlimentoDTO result = this.controleAlimentoService.update(id, controleAlimentoDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.controleAlimentoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
